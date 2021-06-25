package CulminatingTask;

import javax.swing.*;
import java.awt.*;

/**
 * <b><i>Start the Application</i></b><br>
 * <p>This class starts the application and shows a gif with the name of the application. To start the application, the class
 * calls {@link Login} class.
 * </p>
 * @see Login
 */
class Start extends JFrame {

    public Start(){

        // Create a label to hold the image and set its scale to 540:
        JLabel label = new JLabel();
        label.setBounds(0, 0, 540, 540);

        // Resize the image to 540-540 pixels:
        ImageIcon image = new ImageIcon(new ImageIcon("src/CulminatingTask/Images/SORTVIS.gif").getImage()
                .getScaledInstance(540, 540, Image.SCALE_DEFAULT));

        // The frame settings:
        this.setUndecorated(true);
        this.setSize(new Dimension(540, 540));
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(0xFF9666));
        this.setVisible(true);
        // Set the image to the label:
        label.setIcon(image);
        // Add the label to the frame:
        this.add(label);

        // Sleep for 7.7 sec to fully show the gif:
        try{
            Thread.sleep(7700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* Create and display the Login frame */
        EventQueue.invokeLater(() -> new Login().setVisible(true));
        // dispose the frame:
        this.dispose();
    }
}
