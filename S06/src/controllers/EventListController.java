package controllers;

import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import core.Controller;
import models.SchedulerIO;
import views.EventListView;

public class EventListController extends Controller {

    private EventListView eventListView;
    private JTable table;

    @Override
    public void run() {

        table = new JTable(getDataColumns(), getNameColumns());
        eventListView = new EventListView(this, table);

    }

    public void addNewRow(Object[] values) {

        ((DefaultTableModel) table.getModel()).addRow(values);

    }

    public EventListView getView() {
        return eventListView;
    }

    public Vector<String> getNameColumns() {

        Vector<String> nameColumns = new Vector<String>();

        nameColumns.add("Fecha");
        nameColumns.add("Descripción");
        nameColumns.add("Frecuencia");
        nameColumns.add("Correo");
        nameColumns.add("Alarma");

        return nameColumns;

    }

    public Vector<Vector<Object>> getDataColumns() {

        Vector<Vector<Object>> dataColumns = null;

        try {

            SchedulerIO schedulerIO = new SchedulerIO();
            schedulerIO.attach(eventListView);
            dataColumns = schedulerIO.getEvents();

        } catch (Exception ex) { }

        return dataColumns;

    }

}
