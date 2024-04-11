package Backend.SMModules;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SimulationParam extends javax.swing.JPanel {
    private List<SimulationParameters> parametersList;

    public SimulationParam() {
        initComponents();
        displayUserProfile();
        loadParametersFromFile();
    }

    private void initComponents() {
        // Initialization code here
        jToggleButton1 = new javax.swing.JToggleButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jToggleButton1.setText("ON");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Time Speed");

        jLabel2.setText("Location:");

        jButton1.setText("EDIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openEditParametersDialog();
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("User Profile"));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Profile Image");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("User Type");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                            .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap(328, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(252, 252, 252))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                            .addGap(321, 321, 321))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(jToggleButton1)
                            .addGap(31, 31, 31)
                            .addComponent(jButton1)
                            .addGap(68, 68, 68)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap())
        );
    }

    private void displayUserProfile() {
        // Display user profile code here
        // Assuming you have logic to display user profile
        ImageIcon profileIcon = new ImageIcon(getClass().getResource("/path/to/user_profile_image.png"));
        jLabel3.setIcon(profileIcon);
        String userType = "Parent"; // Example, you can replace it with the actual user type
        jLabel4.setText("User Type: " + userType);
    }

    private void loadParametersFromFile() {
        parametersList = SimulationParametersFileManager.loadParameters();
        // Populate UI with loaded parameters
        // Assuming you have UI elements to display parameters
        // You can access parameters from parametersList and update UI accordingly
    }

    private void saveParametersToFile() {
        SimulationParametersFileManager.saveParameters(parametersList);
    }

    private void openEditParametersDialog() {
        JDialog paramDialog = new JDialog();
        paramDialog.setLayout(new GridLayout(5, 2));

        // Add text fields and labels for each parameter
        JTextField locationField = new JTextField(10);
        paramDialog.add(new JLabel("Location:"));
        paramDialog.add(locationField);

        JTextField dateField = new JTextField(10);
        paramDialog.add(new JLabel("Date (dd/MM/yyyy):"));
        paramDialog.add(dateField);

        JTextField timeField = new JTextField(10);
        paramDialog.add(new JLabel("Time (HH:mm):"));
        paramDialog.add(timeField);

        JTextField tempField = new JTextField(10);
        paramDialog.add(new JLabel("Temperature (°C):"));
        paramDialog.add(tempField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic to handle updating the parameters
                String location = locationField.getText();
                String date = dateField.getText();
                String time = timeField.getText();
                double temperature = Double.parseDouble(tempField.getText());
                updateParameters(location, date, time, temperature);
                paramDialog.dispose(); // Close the dialog
            }
        });
        paramDialog.add(submitButton);

        paramDialog.setSize(300, 200);
        paramDialog.setVisible(true);
    }

    private void updateParameters(String location, String date, String time, double temperature) {
        SimulationParameters newParameters = new SimulationParameters(location, date, time, temperature, jToggleButton1.isSelected());
        parametersList.add(newParameters);
        saveParametersToFile();
        loadParametersFromFile(); // Refresh UI after updating parameters
    }

    private void adjustSimulationSpeed(int sliderValue) {
        double[] speedFactors = {1.0, 1.5, 2.0, 4.0}; // Possible speed factors
        int maxSliderValue = 100; // Maximum value of the slider
        int factorIndex = sliderValue * (speedFactors.length - 1) / maxSliderValue;
        double speedFactor = speedFactors[factorIndex];
        // Use the speedFactor to adjust the simulation speed
    }
    
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        boolean isSimulationRunning = jToggleButton1.isSelected();
        if (isSimulationRunning) {
            // Start the simulation
        } else {
            // Stop the simulation
        }
    }
    

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {
        int sliderValue = jSlider1.getValue();
        adjustSimulationSpeed(sliderValue);
    }
    

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JToggleButton jToggleButton1;
}
