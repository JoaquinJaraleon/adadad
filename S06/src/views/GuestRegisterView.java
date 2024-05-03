package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

@SuppressWarnings("serial")
public class GuestRegisterView extends JPanel {

    private JTextField tf_name;
    private JTextField tf_lastName;
    private JTextField tf_phone;
    private JTextField tf_email;
    private JTextField tf_eventCode;
    private JLabel lbl_photo;

    public GuestRegisterView() {

        setLayout(null);
        makeFields();
        makePhotoButton();

    }

    private void makeFields() {

        JLabel lbl_name = new JLabel("Nombre:");
        lbl_name.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_name.setBounds(20, 20, 100, 20);
        add(lbl_name);

        tf_name = new JTextField();
        tf_name.setBounds(130, 20, 200, 20);
        add(tf_name);

        JLabel lbl_lastName = new JLabel("Apellido:");
        lbl_lastName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_lastName.setBounds(20, 50, 100, 20);
        add(lbl_lastName);

        tf_lastName = new JTextField();
        tf_lastName.setBounds(130, 50, 200, 20);
        add(tf_lastName);

        JLabel lbl_email = new JLabel("Correo electrónico:");
        lbl_email.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_email.setBounds(20, 80, 100, 20);
        add(lbl_email);

        tf_email = new JTextField();
        tf_email.setBounds(130, 80, 200, 20);
        add(tf_email);

        JLabel lbl_phone = new JLabel("Teléfono:");
        lbl_phone.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_phone.setBounds(20, 110, 100, 20);
        add(lbl_phone);

        tf_phone = new JTextField();
        tf_phone.setBounds(130, 110, 200, 20);
        add(tf_phone);

        JLabel lbl_eventCode = new JLabel("Código de evento:");
        lbl_eventCode.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_eventCode.setBounds(20, 140, 100, 20);
        add(lbl_eventCode);

        tf_eventCode = new JTextField();
        tf_eventCode.setBounds(130, 140, 200, 20);
        add(tf_eventCode);

        lbl_photo = new JLabel();
        lbl_photo.setBounds(350, 20, 150, 150);
        lbl_photo.setFont(new Font("Tahoma", Font.BOLD, 11));
        lbl_photo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(lbl_photo);

    }

    private void makePhotoButton() {

        JButton btn_photo = new JButton("Cargar Foto");
        btn_photo.setBounds(350, 180, 150, 30);
        add(btn_photo);

        btn_photo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {

                    String imagePath = fileChooser.getSelectedFile().getAbsolutePath();

                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
                    lbl_photo.setIcon(imageIcon);

                }
            }
        });
    }

    public String getName() {
        return tf_name.getText();
    }

    public String getLastName() {
        return tf_lastName.getText();
    }

    public String getEmail() {
        return tf_email.getText();
    }

    public String getPhone() {
        return tf_phone.getText().replace(" ", "");
    }

    public String getEventCode() {
        return tf_eventCode.getText();
    }
}
