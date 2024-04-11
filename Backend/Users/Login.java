package Backend.Users;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import Backend.TabbedPaneDemo;

class SignUp extends JFrame {
    JTextField t1, t2;
    JButton b1;
    JRadioButton jRadioButton1, jRadioButton2, jRadioButton3, jRadioButton4;
    ButtonGroup G1;
    JLabel L1;

    SignUp() {
        setLayout(null);
        t1 = new JTextField(20);
        t2 = new JPasswordField(20);
        b1 = new JButton("Submit");

        jRadioButton1 = new JRadioButton("Parent");
        jRadioButton2 = new JRadioButton("Child");
        jRadioButton3 = new JRadioButton("Stranger");
        jRadioButton4 = new JRadioButton("Guest");

        G1 = new ButtonGroup();
        L1 = new JLabel("Type");

        // Set bounds for components
        t1.setBounds(100, 20, 120, 30);
        t2.setBounds(100, 60, 120, 30);
        b1.setBounds(100, 100, 80, 30);
        jRadioButton1.setBounds(100, 180, 80, 20);
        jRadioButton2.setBounds(200, 180, 80, 20);
        jRadioButton3.setBounds(300, 180, 80, 20);
        jRadioButton4.setBounds(400, 180, 80, 20);
        L1.setBounds(100, 140, 150, 20);

        // Add components to button group
        G1.add(jRadioButton1);
        G1.add(jRadioButton2);
        G1.add(jRadioButton3);
        G1.add(jRadioButton4);

        // Action listener for the submit button
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String username = t1.getText();
                    String password = t2.getText();

                    // Check if username or password contains spaces
                    if (username.contains(" ") || password.contains(" ")) {
                        JOptionPane.showMessageDialog(null, "Username and password cannot contain spaces.");
                        return;
                    }

                    // Determine user type based on selected radio button
                    User newUser = null;
                    if (jRadioButton1.isSelected()) {
                        newUser = new Parent(username, password);
                    } else if (jRadioButton2.isSelected()) {
                        newUser = new Child(username, password);
                    } else if (jRadioButton3.isSelected()) {
                        newUser = new Stranger(username, password);
                    } else {
                        newUser = new Guest(username, password);
                    }

                    // Write user data to file
                    FileWriter fw = new FileWriter("UserData.txt", true);
                    fw.write(newUser.getUsername() + "\t" + newUser.getUserPassword() + "\t" + newUser.getType() + "\n");
                    fw.close();

                    // Show registration completion message
                    JOptionPane.showMessageDialog(null, "Registration Completed");
                    dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // Add components to frame
        add(t1);
        add(t2);
        add(b1);
        add(L1);
        add(jRadioButton1);
        add(jRadioButton2);
        add(jRadioButton3);
        add(jRadioButton4);

        // Set frame properties
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class Login extends JFrame {
    JTextField t1, t2;
    JButton b1, b2;
    JLabel l1, l2;

    Login() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1 = new JLabel("Login");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        l1.setForeground(Color.RED);
        l1.setBounds(120, 10, 300, 30);
        add(l1);
        t1 = new JTextField(20);
        t2 = new JPasswordField(20);
        b1 = new JButton("Login");
        b2 = new JButton("SignUp");

        t1.setBounds(100, 60, 120, 30);
        t2.setBounds(100, 100, 120, 30);
        b1.setBounds(120, 145, 80, 30);
        l2 = new JLabel("");
        l2.setBounds(250, 80, 300, 30);
        b2.setBounds(120, 185, 80, 30);

        add(l2);
        add(t1);
        add(t2);
        add(b1);
        add(b2);

        // Action listener for login button
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                boolean matched = false;
                String username = t1.getText();
                String password = t2.getText();
                try {
                    FileReader fr = new FileReader("UserData.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split("\t");
                        if (parts.length == 3 && parts[0].equals(username) && parts[1].equals(password)) {
                            matched = true;
                            break;
                        }
                    }
                    fr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (matched) {
                    dispose();
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            UIManager.put("swing.boldMetal", Boolean.FALSE);
                            TabbedPaneDemo.createAndShowGUI();
                        }
                    });
                } else {
                    l2.setText("Invalid Username or Password");
                }
            }
        });

        // Action listener for signup button
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                SignUp s = new SignUp();
            }
        });

        // Set frame properties
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class LoginDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }
}
