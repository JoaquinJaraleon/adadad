package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controllers.EventListController;
import core.Model;
import core.View;

@SuppressWarnings("serial")
public class EventListView extends JPanel implements View {

    @SuppressWarnings("unused")
    private EventListController eventListController;
    JTable table;

    public EventListView(EventListController eventListController, JTable table) {

        this.eventListController = eventListController;
        this.table = table;

        make_frame();

    }

    @Override
    public void update(Model model, Object data) {

        if (data != null) {

            String notice = (String) data;
            JOptionPane.showMessageDialog(this, notice);

        }

    }

    private void make_frame() {

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

    }

    public void removeRow(int row) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(row);
    }
}
