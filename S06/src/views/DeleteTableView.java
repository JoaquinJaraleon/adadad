package views;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import core.Model;
import core.View;
import controllers.DeleteTableController;

@SuppressWarnings("serial")
public class DeleteTableView extends JPanel implements View {

    private DeleteTableController deleteTableController;

    public DeleteTableView(DeleteTableController deleteTableController) {
        this.deleteTableController = deleteTableController;
        makeFrame();
        makeButtonRemove();
    }

    private void makeFrame() {
        setLayout(null);
    }

    public void makeButtonRemove() {
        JButton btn_remove = new JButton("Eliminar Fila");
        btn_remove.setBounds(10, 10, 120, 25);
        add(btn_remove);

        btn_remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int selectedRow = deleteTableController.getEventListView().table.getSelectedRow();
                if (selectedRow != -1) {
                    deleteTableController.getEventListView().removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona una fila para eliminar");
                }
            }
        });
    }

    @Override
    public void update(Model model, Object data) {

    }
}
