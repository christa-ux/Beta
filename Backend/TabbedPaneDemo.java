//Dashboard page 

package Backend;
 import javax.swing.JTabbedPane;
import java.io.*;
import java.awt.*;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
 import java.awt.Dimension;
 import java.awt.GridLayout;
 import java.awt.event.KeyEvent;
 import Backend.SMModules.SHSFrame;
  
 public class TabbedPaneDemo extends JPanel {
     public TabbedPaneDemo() {
         super(new GridLayout(1, 1));
          
         JTabbedPane tabbedPane = new JTabbedPane();
        
          
         JComponent panel1 = makeTextPanel("");
         tabbedPane.addTab("SHH", null, panel1,
                 "Heating Module");
         tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
          
         JComponent panel2 = makeTextPanel("");
         tabbedPane.addTab("SHP",null, panel2,
                 "Security Module");
         tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
          
         JComponent panel3 = makeTextPanel("");
         tabbedPane.addTab("SHC", null, panel3,
                 "Core Functionality Module");
         tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
          
         SHSFrame shsFrame = new SHSFrame();
         JPanel panel4 = new JPanel(new BorderLayout());
         panel4.add(shsFrame.getContentPane(), BorderLayout.CENTER);
        
         tabbedPane.addTab("SHS", null, panel4,
                 "Smart Home System");
         tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

         JComponent panel5 = makeTextPanel(
                 "");
         panel5.setPreferredSize(new Dimension(410, 50));
         tabbedPane.addTab("Simulation parameters", null, panel5,
                 "Does nothing at all");
         tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);
        add(tabbedPane);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
     }
      
     protected JComponent makeTextPanel(String text) {
         JPanel panel = new JPanel(false);
         JLabel filler = new JLabel(text);
         filler.setHorizontalAlignment(JLabel.CENTER);
         panel.setLayout(new GridLayout(1, 1));
         panel.add(filler);
         return panel;
     }
      
     public static void createAndShowGUI() {
            JFrame frame = new JFrame("Dashboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            TabbedPaneDemo tabbedPaneDemo = new TabbedPaneDemo(); 
            frame.setContentPane(tabbedPaneDemo);
            frame.pack();
            frame.setVisible(true);
    
            // Synchronize table data with UserData.txt
            syncTableWithDataFile();
        }
     
     private static void addComponentsToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();
        SHSFrame shsFrame = new SHSFrame();
        tabbedPane.addTab("SHSFrame", shsFrame.getContentPane());
        pane.add(tabbedPane, BorderLayout.CENTER);
    }
    private static void syncTableWithDataFile() {
        try {
            // Read data from UserData.txt
            BufferedReader reader = new BufferedReader(new FileReader("UserData.txt"));
            DefaultTableModel model = (DefaultTableModel) SHSFrame.TableUsers.getModel();
            model.setRowCount(0); // Clear existing data
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    model.addRow(new Object[]{parts[0], parts[1], parts[2]});
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //  public static void main(String[] args) {
    //     SwingUtilities.invokeLater(TabbedPaneDemo::createAndShowGUI);
        
    //  }
 }