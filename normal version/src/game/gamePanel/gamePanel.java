package game.gamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gamePanel extends JFrame{
    private JTextField textField1;
    private JLabel NameLabel;
    private JButton OKButton;
    private JButton cancelButton;
    private JPanel mypanel;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JComboBox comboBox1;
    private JSpinner spinner1;

    public gamePanel() {
        setVisible(true);
        setTitle("Adenture Game");
        setVisible(true);
        setSize(450, 450);
        add(mypanel);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(null, "Hi " + textField1.getText() + "!\n" + "Welcome To This Game.","accept",JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                dispose();
            }
        });

    }
}
