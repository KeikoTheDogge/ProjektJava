package pl.pwr.edu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

public class GUI implements ActionListener {
    private static JLabel titleSub;
    private static JTextField loginText;
    private static JLabel loginLabel;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton loginButton;

    public static void Frame() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setTitle("Better NFZ");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);
        frame.setLocationRelativeTo(null);

        titleSub = new JLabel();
        titleSub.setText("Better-NFZ");
        titleSub.setBounds(150, 0, 80, 25);
        panel.add(titleSub);


        loginLabel = new JLabel("Login");
        loginLabel.setBounds(10, 40, 80, 25);
        panel.add(loginLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 100, 80, 25);
        panel.add(passwordLabel);

        loginText = new JTextField(20);
        loginText.setBounds(100, 40, 165, 25);
        panel.add(loginText);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 100, 165, 25);
        panel.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 150, 165, 25);
        loginButton.addActionListener(new pl.pwr.edu.GUI());
        panel.add(loginButton);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String login = loginText.getText();
        String password = passwordText.getText();
        try {
            /* Stworzenie HashMapy z pliku doclog */
            HashMap<String, String> docLo = FileEdit.getDocLog();

            // Podanie informacji i pobranie loginu
            //System.out.print("Login: ");
            //String log = input.nextLine();

            // Jeżeli istnieje taki login w bazie (plik.txt)
            if (docLo.containsKey(login)) {
                // Jeżeli istnieje taki login, to pobierz dla niego z hashmapy hasło
                String passwordtxt = docLo.get(login);

                // Podanie hasła
                // Jeżeli podane hasło jest takie samo jak pobrane -> zaloguj
                if (password.equals(passwordtxt)) {
                    System.out.println("Welcome to NFZ-SPACE-MEDIC-X-SITE");
                } else {
                    throw new WrongPassword();
                }
            } else {
                throw new WrongLogin();
            }
        } catch (IOException | WrongLogin ex) {
            System.out.println("Wrong login - access denied.");
        } catch (WrongPassword ex) {
            System.out.println("Wrong password - access denied.");
        }
    }
}
