package CulminatingTask;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <p><i><b>Application Frame</b></i></p>
 * <p>This class will create a frame using the properties of JFrame to setup a frame in which all the of application
 * panels, logics and the GUI will be defined. This frame will also contain some methods which will be used by initialised panels (such
 * as {@link #GoToComponent}, {@link #ExitTheApplication} and {@link #MinimizeTheApplication}).</p>
 * @see Menu
 * @see LearnSorting
 * @see Profile
 * @see Help
 * @see PlaySorting
 */
public class Application extends JFrame {

    /**
     * Variables declarations:
     **/
    static JPanel parentPanel; // This panel holds the panels of the game on top of it
    static JPanel currentPanel; // To keep track of the current panel user is using
    static Menu menuPanel; // The panel that lets the user to navigate through other panels
    public static LearnSorting learnSortingPanel; // The panel that shows the visualizations of sorting
    public static Profile profilePanel; // The panel that shows the progress of the user
    static Help helpPanel; // The panel that helps the user how to interact with the GUI
    static PlaySorting playSortingPanel; // The panel that user can play games on
    static SortingVisualizer sortingVisualizer; // Helper class for learnSortingPanel

    /**
     * Creates a new Application Frame
     */
    Application() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the frame.
     */
    private void initComponents() {

        parentPanel = new JPanel();
        setTitle("SORTVIS"); // Frame's title
        setUndecorated(true); // Turns off the native decorations of the frame
        setResizable(false); // Sets the frame not resizable
        setLocationRelativeTo(null); // Makes the frame appear relative to the centre

        // Makes the frame draggable:
        FrameDragListener frameDragListener = new FrameDragListener(this);
        addMouseListener(frameDragListener);
        addMouseMotionListener(frameDragListener);

        // Set the layout to CardLayout to move between various panels:
        parentPanel.setLayout(new CardLayout());

        //region Initialise the panels
        menuPanel = new Menu();
        learnSortingPanel = new LearnSorting();
        sortingVisualizer = new SortingVisualizer(learnSortingPanel);
        profilePanel = new Profile();
        helpPanel = new Help();
        playSortingPanel = new PlaySorting();
        currentPanel = menuPanel;
        //endregion

        getContentPane().add(parentPanel, BorderLayout.CENTER);

        pack();
    }

    /**
     * <p>Takes a JComponent (mostly panels) and after clearing the frame, paints that component.</p>
     * <p>The idea was from "Dc Rocha" on <a href="https://www.youtube.com/watch?v=t03skXkORqk">YouTube</a></p>
     * @param component Any JComponents such as JPanels or JTabbedPanes.
     * @version 1.2
     */
    static void GoToComponent(JComponent component) {
        parentPanel.removeAll();
        parentPanel.add(component);
        parentPanel.repaint();
        parentPanel.revalidate();
        // To keep track of the current panel:
        if (!component.equals(helpPanel))
            currentPanel = (JPanel) component;
    }

    /**
     * <p>Exists the application after confirming the intention.</p>
     * @version 1.1
     */
    static void ExitTheApplication() {
        // Make sure that the user wants to exit the application:
        int ans = JOptionPane.showOptionDialog(null, "Are you sure?", "Exit the Application", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);
        if (ans == 0)
            System.exit(0);
    }

    /**
     * <p>This method minimizes the application.</p>
     * @version 1.1
     */
    void MinimizeTheApplication() {
        setState(JFrame.ICONIFIED);
    }

    /**
     * <p>Makes the frame Draggable.</p>
     * <p>The code is written by "Eric Pragt" on <a href="https://stackoverflow.com/questions/16046824/making-a-java-swing-frame-movable-and-setundecorated">StackOverflow</a></p>
     * @version 1.1
     */
    static class FrameDragListener extends MouseAdapter {

        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }

}
