package Backend.SMModules;
import Backend.Users.*;
import Backend.Users.User.UserType;
import java.io.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SHSFrame extends javax.swing.JFrame implements LoginListener {
   
   
    public SHSFrame() {
        initComponents();
  
    }

   
                        
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        password = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        javax.swing.JLabel usernameLabel = new javax.swing.JLabel();
        javax.swing.JLabel passwordLabel = new javax.swing.JLabel();
        javax.swing.JLabel userTypeLable = new javax.swing.JLabel();
        PARENT = new javax.swing.JRadioButton();
        CHILD = new javax.swing.JRadioButton();
        GUEST = new javax.swing.JRadioButton();
        STRANGER = new javax.swing.JRadioButton();
        javax.swing.JButton addButton = new javax.swing.JButton();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        javax.swing.JButton deleteButton = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane = new javax.swing.JScrollPane();
        TableUsers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("List of clients");

        password.setText("Enter password");
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        username.setText("Enter username");
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        passwordLabel.setText("Password");

        userTypeLable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userTypeLable.setText("User Type");

        buttonGroup1.add(PARENT);
        PARENT.setText("PARENT");
        PARENT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PARENTActionPerformed(evt);
            }
        });

        buttonGroup1.add(CHILD);
        CHILD.setText("CHILD");
        CHILD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHILDActionPerformed(evt);
            }
        });

        buttonGroup1.add(GUEST);
        GUEST.setText("GUEST");

        buttonGroup1.add(STRANGER);
        STRANGER.setText("STRANGER");

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setText("New Account");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PARENT, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CHILD, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GUEST, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(STRANGER, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userTypeLable)
                                    .addComponent(passwordLabel)
                                    .addComponent(usernameLabel))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                        .addGap(21, 21, 21))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(addButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userTypeLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PARENT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CHILD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(STRANGER)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GUEST)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(29, 29, 29))
        );

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        TableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Type"
            }
        ));
        jScrollPane.setViewportView(TableUsers);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(269, 269, 269)
                        .addComponent(deleteButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }                       
  
    @Override
    public void loginPerformed(LoginEvent event) {
        
        try {
            FileInputStream file = new FileInputStream("UserData.txt");
            ObjectInputStream input = new ObjectInputStream(file);

            Vector<Vector> tableData = (Vector<Vector>) input.readObject();
            input.close();
            file.close();
            DefaultTableModel model = (DefaultTableModel) TableUsers.getModel();
            model.setRowCount(0); // Clear existing data
            for (int i = 0; i < tableData.size(); i++) {
                Vector row = tableData.get(i);
                model.addRow(new Object[]{row.get(0), row.get(1), row.get(2)});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
                  
      
    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {}                                        

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {}                                        

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String usernameText = username.getText();
        String passwordText = password.getText();
        UserType userTypeText;
       
        if (usernameText.contains(" ") || passwordText.contains(" ")) {
            JOptionPane.showMessageDialog(this, "Username and password cannot contain spaces.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (PARENT.isSelected()) {
            userTypeText = UserType.PARENT;
        } else if (CHILD.isSelected()) {
            userTypeText = UserType.CHILD;
        } else if (STRANGER.isSelected()) {
            userTypeText = UserType.STRANGER;
        }else if (GUEST.isSelected()) {
            userTypeText=UserType.GUEST;
        } else {
        JOptionPane.showMessageDialog(this, "Please select a user type.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
        }   
    if(usernameText.isEmpty()|| passwordText.isEmpty() ) {
JOptionPane.showMessageDialog(this, "Please enter all fields", "try again", JOptionPane.ERROR_MESSAGE);
    } 
    else {
        DefaultTableModel model = (DefaultTableModel) TableUsers.getModel();
        model.addRow(new Object[]{usernameText, passwordText, userTypeText});
        username.setText("");
        password.setText("");
        buttonGroup1.clearSelection();
    }
    }                                         

    private void CHILDActionPerformed(java.awt.event.ActionEvent evt) {                                      

    }                                     

    private void PARENTActionPerformed(java.awt.event.ActionEvent evt) {                                       
        
    }                                      

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        int row = TableUsers.getSelectedRow();
       
    if (row < 0) {
        JOptionPane.showMessageDialog(this, "No row selected", "Select Row", JOptionPane.ERROR_MESSAGE);
    } else {
        DefaultTableModel model = (DefaultTableModel) TableUsers.getModel();
        model.removeRow(row); // Remove selected row from the model
        try {
            FileWriter fw = new FileWriter("UserData.txt");
            for (int i = 0; i < model.getRowCount(); i++) {
                fw.write(model.getValueAt(i, 0) + "\t" + model.getValueAt(i, 1) + "\t" + model.getValueAt(i, 2) + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}                                            

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        DefaultTableModel model=(DefaultTableModel) TableUsers.getModel();
    Vector<Vector> tableData=model.getDataVector();
try {
    FileOutputStream file=new FileOutputStream("UserData.txt");
    ObjectOutputStream output=new ObjectOutputStream(file);
output.writeObject(tableData);
output.close();
file.close();
}catch(Exception e) {
    e.printStackTrace();
}
    }                                  

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
       try {
    FileInputStream file=new FileInputStream("UserData.txt");
ObjectInputStream input=new ObjectInputStream(file);

Vector <Vector> tableData=(Vector<Vector>)input.readObject();
input.close();
file.close();
DefaultTableModel model=(DefaultTableModel)TableUsers.getModel();
for(int i=0;i<tableData.size();i++) {
    Vector row=tableData.get(i);
    model.addRow(new Object[]{row.get(0),row.get(2),row.get(3)});
}
}
catch(Exception e) {
    e.printStackTrace();
}
    }                                 

    
                        
    private javax.swing.JRadioButton CHILD;
    private javax.swing.JRadioButton GUEST;
    private javax.swing.JRadioButton PARENT;
    private javax.swing.JRadioButton STRANGER;
    public static javax.swing.JTable TableUsers;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
                    
}
