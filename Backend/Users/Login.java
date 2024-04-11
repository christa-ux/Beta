//log in and signup page 

package Backend.Users;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import Backend.TabbedPaneDemo;


class SignUp extends JFrame {
    JTextField t1,t2;
    JButton b1;

    // Declaration of object of JRadioButton class
    JRadioButton jRadioButton1;
    JRadioButton jRadioButton2;
    JRadioButton jRadioButton3;  
    JRadioButton jRadioButton4; 

    // JButton jButton; 
    ButtonGroup G1;
    JLabel L1; 

    SignUp() {
        setLayout(null);
        t1=new JTextField(60);
        t2=new JPasswordField(60);
b1=new JButton("Submit");
t1.setBounds(100,20,80,30);
t2.setBounds(100,60,80,30);
b1.setBounds(100,100,80,30);

// Initialization of object of "JRadioButton" class. 
jRadioButton1 = new JRadioButton();
jRadioButton2 = new JRadioButton();
jRadioButton3 = new JRadioButton();
jRadioButton4 = new JRadioButton();

G1 = new ButtonGroup();
L1 = new JLabel("Type\n");

jRadioButton1.setText("Parent");
jRadioButton2.setText("Child");
jRadioButton3.setText("Stranger");
jRadioButton4.setText("Guest");

jRadioButton1.setBounds(100, 180, 80, 50);
jRadioButton2.setBounds(200, 180, 80, 50);
jRadioButton3.setBounds(300, 180, 80, 50);
jRadioButton4.setBounds(400, 180, 80, 50);
L1.setBounds(100, 140, 150, 50);


b1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae){
        try {
            String username = t1.getText();
            String password = t2.getText();

            // Check if username or password contains spaces
            if (username.contains(" ") || password.contains(" ")) {
                JOptionPane.showMessageDialog(new JFrame(), "Username and password cannot contain spaces.");
                return; 
            }
            User newUser = null;
            if(jRadioButton1.isSelected()) {
                newUser = new Parent(username, password);
            }
            else if (jRadioButton2.isSelected()) {
                newUser = new Child(username, password);
            }
            else if(jRadioButton3.isSelected()) {
                newUser = new Stranger(username, password);
            }
            else {
                newUser = new Guest(username, password);
            }

FileWriter fw= new FileWriter("UserData.txt",true);
fw.write(newUser.getUsername() + "\t" + newUser.getUserPassword() + "\t" + newUser.getType() + "\n");
fw.close();    
JFrame f=new JFrame();
JOptionPane.showMessageDialog(f, "Registration Completed");
dispose();
}catch(Exception e) {
    e.printStackTrace();
}
}
    
});
add(t1);
add(t2);
add(b1);
add(L1);
add(jRadioButton1);
add(jRadioButton2);
add(jRadioButton3);
add(jRadioButton4);
G1.add(jRadioButton1); 
G1.add(jRadioButton2); 
G1.add(jRadioButton3); 
G1.add(jRadioButton4); 

    }
}

 class Login extends JFrame{
    JTextField t1, t2; 
    //t1: username
    //t2: password
    JButton b1,b2; //login button

    JLabel l1,l2;
//l1: title of the form


   Login() {
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);  //close frame when user click on close
    l1=new JLabel("Login");
    l1.setFont(new Font("Times New Roman", Font.BOLD,30));
    l1.setForeground(Color.RED);
    l1.setBounds(120,10,300,30);
    add(l1);
    t1=new JTextField(60);
    t2=new JPasswordField(60);

    b1=new JButton("Login");
    b2=new JButton("SignUp");

    t1.setBounds(100,60,120,30);
    t2.setBounds(100,100,120,30);

    b1.setBounds(120,145,80,30);

    l2=new JLabel("");
    l2.setBounds(250, 80, 300, 30);
    b2.setBounds(120, 185, 80, 30);
    add(l2);
    add(t1);
    add(t2);
    add(b1);
    add(b2);
    b1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae){
            boolean matched=false;
            String username=t1.getText();
            String password=t2.getText();
            try {
            FileReader fr=new FileReader("UserData.txt");
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line=br.readLine())!=null) {
                String[] parts = line.split("\t");
                if (parts.length == 3 && parts[0].equals(username) && parts[1].equals(password)) {
                    matched=true;
                    break;
                }
            }
            fr.close();
        }catch(Exception e){
            e.printStackTrace();
        }

            if(matched) {
            dispose();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    UIManager.put("swing.boldMetal", Boolean.FALSE);
                    TabbedPaneDemo.createAndShowGUI();
                }
            });
                        }else {
                            l2.setText("Invalid Username or Password");
                        }
                
                    }
                });
    b2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
SignUp s=new SignUp();
s.setVisible(true);
s.setBounds(200,100,500, 300);
        }
    });
   } 
}
class LoginDemo {
    public static void main(String[] args) {
        Login l=new Login();
        l.setBounds(400,200,500,300);
        l.setVisible(true); //by default the form is hidden

    }
}

