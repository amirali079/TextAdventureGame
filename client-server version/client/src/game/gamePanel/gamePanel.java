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
    private JTextField textField2;
    public static String userName;
    public static String passWord;
    public static String difficulty="Easy";

    public gamePanel() {
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficulty= (String) comboBox1.getSelectedItem();
            }
        });
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
                setName();
                 JOptionPane.showMessageDialog(null, "Hi " + textField1.getText() + "!\n" + "Welcome To This Game.","accept",JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                dispose();
            }
        });

    }
    public void setName(){
        userName= textField1.getText();
        passWord=textField2.getText();
    }
}
