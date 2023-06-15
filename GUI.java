/*
 *  File Input Gui
 */

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * GUI Framing
 *
 */
public class GUI extends JFrame {
    
    public GUI( controller cs) {
        this.setTitle("Word Frequency Reader");
        this.setSize( 350, 250);
        this.setLocation(100, 100);
        this.getContentPane().setLayout( null);
        
        JButton button = new JButton( "Choose a File to Read");
        button.setLocation(40, 50);
        button.setSize( 250, 100);
        button.addActionListener(cs);
        this.getContentPane().add( button);
        
        this.setVisible(true);
        
    }
}
