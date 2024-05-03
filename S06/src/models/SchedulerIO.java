package models;

import java.io.*;
import java.util.*;

import core.Model;
import core.View;

public class SchedulerIO implements Model {

    private static final String DIRECTORY = ".";
    private static final String FILE = "S06.txt";
    private List<View> views = new ArrayList<>();
    private String notice;

    @Override
    public void attach(View view) {
        views.add(view);
    }

    @Override
    public void detach(View view) {
        views.remove(view);
    }

    @Override
    public void notifyViews() {

        for (View v : views) {
            v.update(this, notice);
        }

    }

    public void saveEvent(SchedulerEvent event) throws Exception {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(DIRECTORY, FILE), true));
            writer.write(event.toString(), 0, event.toString().length());
            writer.newLine();
            writer.close();
        } catch (FileNotFoundException fnfe) {
            notice = "Archivo no encontrado";
            notifyViews();
        } catch (Exception ex) {
            notice = "Error al escribir el archivo";
            notifyViews();
        }

    }

    public Vector<Vector<Object>> getEvents() throws Exception {

        Vector<Vector<Object>> response = new Vector<Vector<Object>>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(DIRECTORY, FILE)));
            String line = reader.readLine();

            while (line != null) {
                Vector<Object> eventInfo = new Vector<Object>();
                String[] tokens = line.split(";");

                eventInfo.add(tokens[0]);
                eventInfo.add(tokens[1]);
                eventInfo.add(Frequency.valueOf(tokens[2]));
                eventInfo.add(tokens[3]);
                eventInfo.add(tokens[4].equals("1") ? "ON" : "OFF");

                response.add(eventInfo);
                line = reader.readLine();
            }

            reader.close();
        } catch (FileNotFoundException fnfe) {
            notice = "Archivo no encontrado";
            notifyViews();
        } catch (Exception ex) {
            notice = "Hubo un problema al leer el archivo de eventos";
            notifyViews();
        }

        return response;

    }

}
