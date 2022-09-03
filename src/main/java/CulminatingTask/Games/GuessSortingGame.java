//TODO This game is under construction.
// Since this game would make the application too complicated and would require additional time, I decided to stop making it.
// I may continue working on it at a later time, through!

package CulminatingTask.Games;

import CulminatingTask.SortingVisualizer;

import javax.swing.*;
import java.util.Random;
import java.awt.*;

import static CulminatingTask.PlaySorting.mainGamePanel;

/**
 * <p><b><i>Guess Sorting Game</i></b></p>
 * <p><i>Description of the game:</i></p>
 * <p>A shuffled array will be displayed for the user, and the user has to guess what kind of
 * algorithm is sorting the the array. The user will only have one chance to guess the sorting algorithm, and if they
 * fail, the game will be restarted and the user should guess another algorithm. However, if they correctly guess the
 * algorithm sorting the array, they will be awarded based on the time they spent figuring out the algorithm. The sooner
 * they guess, the higher their score will be.</p>
 *
 */
public class GuessSortingGame extends JPanel {

    private int sizeModifier;
    private final JPanel arrayWrapperPanel;
    private JPanel[] squarePanels;
    private final JSlider speedSlider;
    public static JSlider sizeSlider;
    public static JButton startButton;
    public static JComboBox<String> selectionComboBox;
    private final JLabel speedValLabel;
    private final JLabel sizeValLabel;
    private final GridBagConstraints c;
    private final JPanel buttonWrapperPanel;
    private JButton minButtonFromLS;
    private JButton returnToMenuButtonFromLS;
    private JButton closeButtonFromLS;
    private JButton infoButtonFromLS;
    private String[] availableSortArray;
    private final int DEFAULT_SPEED = 20;
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 500;
    private final int DEFAULT_SIZE = 100;
    private final int MIN_SIZE = 10;
    private final int MAX_SIZE = 230;
    private final Random rand = new Random();

    public GuessSortingGame() {

        startButton = new JButton("Start"); //Start sorting
        buttonWrapperPanel = new JPanel(); // The setting panel for sorting
        arrayWrapperPanel = new JPanel(); // The panel visualizing the sorting
        minButtonFromLS = new JButton();
        returnToMenuButtonFromLS = new JButton();
        closeButtonFromLS = new JButton();
        infoButtonFromLS = new JButton();
        selectionComboBox = new JComboBox<>(); // The combo box holding the sorting algorithms name
        speedSlider = new JSlider(MIN_SPEED, MAX_SPEED, DEFAULT_SPEED);
        sizeSlider = new JSlider(MIN_SIZE, MAX_SIZE, DEFAULT_SIZE);
        speedValLabel = new JLabel("Speed: 20 ms");
        sizeValLabel = new JLabel("Size: 100 values");
        availableSortArray = new String[9];
        c = new GridBagConstraints();


        availableSortArray[0] = "Select";
        availableSortArray[1] = "Bubble";
        availableSortArray[2] = "Selection";
        availableSortArray[3] = "Insertion";
        availableSortArray[4] = "Gnome";
        availableSortArray[5] = "Merge";
        availableSortArray[6] = "Radix";
        availableSortArray[7] = "Shell";
        availableSortArray[8] = "Quick";

        selectionComboBox.setModel(new DefaultComboBoxModel<>(availableSortArray));
        selectionComboBox.setBackground(new Color(255, 245, 240));

        setLayout(new BorderLayout()); // Set the layout of the panel
        arrayWrapperPanel.setLayout(new GridBagLayout()); // Set the layout of arrayWrapperPanel to a GridBagLayout to place the components in a grid of rows and columns

        // Background settings:
        arrayWrapperPanel.setBackground(new Color(0XFFF5F0));
        buttonWrapperPanel.setBackground(new Color(0XFFF5F0));

        // To connect the panels representing the values of the unsorted array:
        c.insets = new Insets(0,1,0,1);
        c.anchor = GridBagConstraints.SOUTH;

        // Generate a random sorting algorithm:
        int n = rand.nextInt(8) + 1;

        // If the start button is pushed, start sorting:
        startButton.addActionListener(e -> {
            if (startButton.getText().equals("Start"))
                SortingVisualizer.startSort(availableSortArray[n]); // Get the random algorithms and use it to sort a shuffled array
                // If the sorting is currently happening, the second push will cause the sorting to stop and reset:
            else {
                SortingVisualizer.stopSort();

                //Give the thread a time to fully stop:
                try {
                    Thread.sleep(30);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

                // Clear the arrayWrapper Panel (Clear the sorting area):
                arrayWrapperPanel.removeAll();
                validate();
            }
        });

        //region speedSlider settings
        speedSlider.setMinorTickSpacing(10); //Minimum limits
        speedSlider.setMajorTickSpacing(100); //Maximum limits
        speedSlider.setPaintTicks(true); //Divide the slider into sections
        speedSlider.setBackground(new Color(0XFFF5F0));

        // If the speedSlider is triggered at any time, change the sorting speed:
        speedSlider.addChangeListener(e -> {
            speedValLabel.setText(("Speed: " + speedSlider.getValue() + "ms")); // Change the value of the speedValLabel according to the speedSlider's value
            validate();
            SortingVisualizer.sleep = speedSlider.getValue(); // Change the sorting speed
        });
        //endregion

        //region sizeSlider settings
        sizeSlider.setMinorTickSpacing(10); //Minimum limits
        sizeSlider.setMajorTickSpacing(100);  //Maximum limits
        sizeSlider.setPaintTicks(true); //Divide the slider into sections
        sizeSlider.setBackground(new Color(0XFFF5F0));

        // If the sizeSlider is triggered when not sorting, change the size of the sorting array:
        sizeSlider.addChangeListener(arg0 -> {
            sizeValLabel.setText(("Size: " + sizeSlider.getValue() + " values")); // Change the value of the sizeValLabel according to the sizeSlider's value
            validate();
            SortingVisualizer.sortDataCount = sizeSlider.getValue(); // Change the size of the sorting array
        });
        //endregion

        speedValLabel.setBackground(new Color(0XFFF5F0));
        sizeValLabel.setBackground(new Color(0XFFF5F0));

        // Add the buttonWrapperPanel's components:
        buttonWrapperPanel.add(speedValLabel);
        buttonWrapperPanel.add(speedSlider);
        buttonWrapperPanel.add(sizeValLabel);
        buttonWrapperPanel.add(sizeSlider);
        buttonWrapperPanel.add(startButton);
        buttonWrapperPanel.add(selectionComboBox);

        // Add the LearnSortingPanel's components:
        add(buttonWrapperPanel, BorderLayout.SOUTH);
        add(arrayWrapperPanel);

        mainGamePanel.add(this, "card2");
    }


    /**
     * Initializes the array of panels that represent the values. They are set based on the size of the parent panel which
     * is LearnSortingPanel.
     * @param squares The panels of the Sorting array that represent the values, which are the lines corresponding to
     *                the values of the Sorting array.
     * @version 2.3 (optimised)
     */
    public void preDrawArray(Integer[] squares){
        squarePanels = new JPanel[SortingVisualizer.sortDataCount]; // Initialise the panels that represent the array values
        arrayWrapperPanel.removeAll(); // Clear the arrayWrapperPanel
        // 90% of the windows height, divided by the size of the sorted array:
        sizeModifier =  (int) ((getHeight()*0.9)/(squarePanels.length));
        // Go over all of the array panels and initialise them and add them to the arrayWrapperPanel by using insets:
        for(int i = 0; i<SortingVisualizer.sortDataCount; i++){
            squarePanels[i] = new JPanel();
            squarePanels[i].setPreferredSize(new Dimension(SortingVisualizer.blockWidth, squares[i]*sizeModifier));
            squarePanels[i].setBackground(Color.blue);
            arrayWrapperPanel.add(squarePanels[i], c);
        }
        repaint();
        validate();
    }

    /**
     * Draws the array with no cruiser moving along the panels while sorting.
     * @param x The array of panels value that represent the values that need to be sorted.
     * @version 1.1
     */
    public void reDrawArray(Integer[] x){
        reDrawArray(x, -1);
    }

    /**
     * Draws the array with only one cruiser moving along the panels while sorting.
     * @param x The array of panels value that represent the values that need to be sorted.
     * @param y The position of the first cruiser (the working cruiser)
     * @version 1.1
     */
    public void reDrawArray(Integer[] x, int y){
        reDrawArray(x, y, -1);
    }

    /**
     * Draws the array with two cruiser moving along the panels while sorting.
     * @param x The array of panels value that represent the values that need to be sorted.
     * @param y The position of the first cruiser (the working cruiser)
     * @param z The position of the second cruiser (the comparing cruiser)
     * @version 1.1
     */
    public void reDrawArray(Integer[] x, int y, int z){
        reDrawArray(x, y, z, -1);
    }

    /**
     * <p>Draws the final array over the arrayWrapperPanel after each step of sorting. reDrawArray does similar to
     * preDrawArray except it does not reinitialize the panel array.</p>
     * @param squares The array of panels value that represent the values that need to be sorted.
     * @param working The position of the first cruiser (the working cruiser)
     * @param comparing The position of the second cruiser (the comparing cruiser)
     * @param reading The position of the third cruiser (the reading cruiser)
     * @version 1.7
     */
    public void reDrawArray(Integer[] squares, int working, int comparing, int reading){
        arrayWrapperPanel.removeAll(); // Clear the panel before drawing
        // Go over all of the array panels and visualise them onto the screen according to the size of the windows:
        for(int i = 0; i<squarePanels.length; i++){
            squarePanels[i] = new JPanel();
            squarePanels[i].setPreferredSize(new Dimension(SortingVisualizer.blockWidth, squares[i]*sizeModifier));
            if (i == working){
                squarePanels[i].setBackground(Color.green);
            }else if(i == comparing){
                squarePanels[i].setBackground(Color.blue);
            }else if(i == reading){
                squarePanels[i].setBackground(Color.yellow);
            }else{
                squarePanels[i].setBackground(new Color(0xFFF5F0));
            }
            arrayWrapperPanel.add(squarePanels[i], c);
        }
        repaint();
        validate();
    }

}
