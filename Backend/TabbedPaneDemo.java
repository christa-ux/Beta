//Dashboard page 

package Backend;
 import javax.swing.JTabbedPane;

 import javax.swing.JLabel;
 import javax.swing.JPanel;
 import javax.swing.JFrame;
 import javax.swing.JComponent;
 import javax.swing.SwingUtilities;
 import javax.swing.UIManager;
 import java.awt.BorderLayout;
 import java.awt.Dimension;
 import java.awt.GridLayout;
 import java.awt.event.KeyEvent;
  
 public class TabbedPaneDemo extends JPanel {
     public TabbedPaneDemo() {
         super(new GridLayout(1, 1));
          
         JTabbedPane tabbedPane = new JTabbedPane();
        
          
         JComponent panel1 = makeTextPanel("Panel #1");
         tabbedPane.addTab("SHH", null, panel1,
                 "Heating Module");
         tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
          
         JComponent panel2 = makeTextPanel("Panel #2");
         tabbedPane.addTab("SHP",null, panel2,
                 "Security Module");
         tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
          
         JComponent panel3 = makeTextPanel("Panel #3");
         tabbedPane.addTab("SHC", null, panel3,
                 "");
         tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
          
         JComponent panel4 = makeTextPanel(
                 "Panel #4 (has a preferred size of 410 x 50).");
         panel4.setPreferredSize(new Dimension(410, 50));
         tabbedPane.addTab("SHS", null, panel4,
                 "Core Functionality Module");
         tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
         JComponent panel5 = makeTextPanel(
                 "Panel #5 (has a preferred size of 410 x 50).");
         panel4.setPreferredSize(new Dimension(410, 50));
         tabbedPane.addTab("Simulation parameters", null, panel5,
                 "Does nothing at all");
         tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);
          
         //Add the tabbed pane to this panel.
         add(tabbedPane);
          
         //The following line enables to use scrolling tabs.
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
         //Create and set up the window.
         JFrame frame = new JFrame("TabbedPaneDemo");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
         //Add content to the window.
         frame.add(new TabbedPaneDemo(), BorderLayout.CENTER);
          
         //Display the window.
         frame.pack();
         frame.setVisible(true);
     }
      
     public static void main(String[] args) {
         
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 
         UIManager.put("swing.boldMetal", Boolean.FALSE);
         createAndShowGUI();
             }
         });
     }
 }