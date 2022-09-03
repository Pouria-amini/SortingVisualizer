package CulminatingTask;

import javax.swing.*;

import java.awt.*;

import java.util.ArrayList;
import java.util.HashMap;

import static CulminatingTask.Application.*;
import static CulminatingTask.Login.application;
import static CulminatingTask.Login.user;

/**
 * <p><i><b>Visualize Sorting Algorithms</b></i></p>
 * <p>This class will create a panel using the properties of JPanel to setup a new panel to show the visualisation of
 * sorting algorithms to the user.</p>
 * <ul>
 * <li>The sorting algorithms include:
 * <ul style="list-style-type:square">
 *     <li>Gnome Sort</li>
 *     <li>Insertion Sort</li>
 *     <li>Merge Sort</li>
 *     <li>Quick Sort</li>
 *     <li>Radix Sort</li>
 *     <li>Selection Sort</li>
 *     <li>Shell Sort</li>
 * </ul>
 * </li></ul>
 * <p>The user will have the chance to change the size and speed of the sorting. In addition, the user can make the
 * sorting values stepped, meaning that the values of the sorted array are all different by one. Also, There is a second
 * version of some of the algorithms with the suffix "fast". These algorithms are the same as the corresponding ones.
 * However, these ones are much faster and can give a give an overview of how the sorting algorithm work.</p>
 * @see SortingVisualizer
 */
public class LearnSorting extends JPanel{

    /**
     * Variable Declarations
     */
    private int sizeModifier;
    private final JPanel arrayWrapperPanel;
    private JPanel[] squarePanels;
    private final JSlider speedSlider;
    public static JSlider sizeSlider;
    public static JCheckBox steppedCheckBox;
    public static JButton startButton;
    public static JComboBox<String> selectionComboBox;
    private final JLabel speedValLabel;
    private final JLabel sizeValLabel;
    private final GridBagConstraints c;
    private final JPanel buttonWrapperPanel;
    private final JPanel controlWrapperPanel;
    private JButton minButtonFromLS;
    private JButton returnToMenuButtonFromLS;
    private JButton closeButtonFromLS;
    private JButton infoButtonFromLS;
    private final int DEFAULT_SPEED = 20;
    private final int MIN_SPEED = 1;
    private final int MAX_SPEED = 500;
    private final int DEFAULT_SIZE = 100;
    private final int MIN_SIZE = 10;
    private final int MAX_SIZE = 230;
    private ArrayList<String> availableSortingAlgos;
    private HashMap<String, Integer> sortsAndCorrespondingValues;

    /**
     * The logic and GUI
     */
    public LearnSorting(){

        startButton = new JButton("Start"); //Start sorting
        buttonWrapperPanel = new JPanel(); // The setting panel for sorting
        arrayWrapperPanel = new JPanel(); // The panel visualizing the sorting
        controlWrapperPanel = new JPanel(); // The panel holding the exit, minimize,info and return to menu button
        minButtonFromLS = new JButton();
        returnToMenuButtonFromLS = new JButton();
        closeButtonFromLS = new JButton();
        infoButtonFromLS = new JButton();
        selectionComboBox = new JComboBox<>(); // The combo box holding the sorting algorithms name
        speedSlider = new JSlider(MIN_SPEED, MAX_SPEED, DEFAULT_SPEED); 
        sizeSlider = new JSlider(MIN_SIZE, MAX_SIZE, DEFAULT_SIZE);
        speedValLabel = new JLabel("Speed: 20 ms");
        sizeValLabel = new JLabel("Size: 100 values");
        steppedCheckBox = new JCheckBox("Stepped Values");
        c = new GridBagConstraints();


        //region The sorting algorithms that the user can choose from according to their score
        availableSortingAlgos = new ArrayList<>(); // To hold the available sorting algorithms
        sortsAndCorrespondingValues = new HashMap<>(); // To hold the sorting algorithms and their corresponding unlock score
        sortsAndCorrespondingValues.put("Bubble", 0);
        sortsAndCorrespondingValues.put("Bubble(fast)", 0);
        sortsAndCorrespondingValues.put("Selection", 5);
        sortsAndCorrespondingValues.put("Selection(fast)", 5);
        sortsAndCorrespondingValues.put("Insertion", 15);
        sortsAndCorrespondingValues.put("Insertion(fast)", 15);
        sortsAndCorrespondingValues.put("Shell", 25);
        sortsAndCorrespondingValues.put("Merge", 40);
        sortsAndCorrespondingValues.put("Radix LSD", 55);
        sortsAndCorrespondingValues.put("Radix MSD", 55);
        sortsAndCorrespondingValues.put("Gnome", 70);
        sortsAndCorrespondingValues.put("Gnome(fast)", 70);
        sortsAndCorrespondingValues.put("Quick", 100);
        // Go over the sortsAndCorrespondingValues and add the algorithms to the availableSortingAlgos if the user's score is enough for the algorithms:
        for(String i: sortsAndCorrespondingValues.keySet()) {
            if (sortsAndCorrespondingValues.get(i) > user.getScore())
                continue;
            availableSortingAlgos.add(i);
        }
        // Add the availableSortingAlgos to the selectionComboBox options:
        String[] availableSortArray = new String[availableSortingAlgos.size()];
        selectionComboBox.setModel(new DefaultComboBoxModel<>(availableSortingAlgos.toArray(availableSortArray)));
        //endregion

        selectionComboBox.setBackground(new Color(255, 245, 240));
        
        setLayout(new BorderLayout()); // Set the layout of the panel
        controlWrapperPanel.setLayout(new BoxLayout(controlWrapperPanel, BoxLayout.X_AXIS));
        arrayWrapperPanel.setLayout(new GridBagLayout()); // Set the layout of arrayWrapperPanel to a GridBagLayout to place the components in a grid of rows and columns

        // Background settings:
        arrayWrapperPanel.setBackground(new Color(0XFF9666));
        buttonWrapperPanel.setBackground(new Color(0XFFF5F0));
        controlWrapperPanel.setBackground(new Color(0XFF9666));

        // To connect the panels representing the values of the unsorted array:
        c.insets = new Insets(0,1,0,1);
        c.anchor = GridBagConstraints.SOUTH;

        // Minimise button settings:
        minButtonFromLS.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/minus-circle.png"));
        minButtonFromLS.setBackground(new Color(255, 150, 102));
        minButtonFromLS.setBorder(null);
        minButtonFromLS.setBorderPainted(false);
        minButtonFromLS.setFocusable(false);
        minButtonFromLS.addActionListener(e -> application.MinimizeTheApplication());

        // Return to the menu from LearnSortingPanel:
        returnToMenuButtonFromLS.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/home-circle.png"));
        returnToMenuButtonFromLS.setBackground(new Color(255, 150, 102));
        returnToMenuButtonFromLS.setBorder(null);
        returnToMenuButtonFromLS.setBorderPainted(false);
        returnToMenuButtonFromLS.setFocusable(false);
        returnToMenuButtonFromLS.addActionListener(e -> {
            GoToComponent(menuPanel);
            // Stop the sorting:
            SortingVisualizer.stopSort();
            // Clear the arrayWrapper Panel (Clear the sorting area):
            arrayWrapperPanel.removeAll();
            selectionComboBox.setSelectedIndex(0);
            validate();
        });

        // Close button settings:
        closeButtonFromLS.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/close-circle.png"));
        closeButtonFromLS.setBackground(new Color(255, 150, 102));
        closeButtonFromLS.setBorder(null);
        closeButtonFromLS.setBorderPainted(false);
        closeButtonFromLS.setFocusable(false);
        closeButtonFromLS.addActionListener(e -> ExitTheApplication());

        // Information button settings:
        infoButtonFromLS.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/information.png"));
        infoButtonFromLS.setBackground(new Color(255, 150, 102));
        infoButtonFromLS.setBorder(null);
        infoButtonFromLS.setBorderPainted(false);
        infoButtonFromLS.setFocusable(false);
        infoButtonFromLS.addActionListener(e -> {
            helpPanel.setSelectedIndex(1);
            GoToComponent(helpPanel);
            // Stop the sorting:
            SortingVisualizer.stopSort();
            // Clear the arrayWrapper Panel (Clear the sorting area):
            arrayWrapperPanel.removeAll();
            selectionComboBox.setSelectedIndex(0);
            validate();
        });

        // If the start button is pushed, start sorting:
        startButton.addActionListener(e -> {
            if (startButton.getText().equals("Start"))
                SortingVisualizer.startSort((String) selectionComboBox.getSelectedItem()); // Get the chosen algorithms and use it to sort a shuffled array
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

        // If the steppedCheckBox is checked, the values of sorting are all stepped by one value:
        steppedCheckBox.addActionListener(e -> SortingVisualizer.stepped = steppedCheckBox.isSelected());

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

        steppedCheckBox.setBackground(new Color(0XFFF5F0));
        speedValLabel.setBackground(new Color(0XFFF5F0));
        sizeValLabel.setBackground(new Color(0XFFF5F0));

        // Add the buttonWrapperPanel's components:
        buttonWrapperPanel.add(steppedCheckBox);
        buttonWrapperPanel.add(speedValLabel);
        buttonWrapperPanel.add(speedSlider);
        buttonWrapperPanel.add(sizeValLabel);
        buttonWrapperPanel.add(sizeSlider);
        buttonWrapperPanel.add(startButton);
        buttonWrapperPanel.add(selectionComboBox);

        // Add the controlWrapperPanel's components:
        controlWrapperPanel.add(infoButtonFromLS);
        controlWrapperPanel.add(Box.createHorizontalStrut(831));
        controlWrapperPanel.add(returnToMenuButtonFromLS);
        controlWrapperPanel.add(minButtonFromLS);
        controlWrapperPanel.add(closeButtonFromLS);

        // Add the LearnSortingPanel's components:
        add(controlWrapperPanel, BorderLayout.NORTH);
        add(buttonWrapperPanel, BorderLayout.SOUTH);
        add(arrayWrapperPanel);
    }

    /**
     * Initializes the array of panels that represent the values. They are set based on the size of the parent panel which
     * is {@link LearnSorting}.
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

    /**
     * Updates the selectionComboBox if the user earned new points.
     * This method is used by the games in Game directory.
     * @version 1.1
     * @see PlaySorting
     * @see CulminatingTask.Games.BalanceSortingGame BalanceSortingGame
     * @see CulminatingTask.Games.GuessSortingGame GuessSortingGame
     */
    public void updateLearnSorting() {

        availableSortingAlgos = new ArrayList<>(); // To hold the available sorting algorithms
        // Go over the sortsAndCorrespondingValues and add the algorithms to the availableSortingAlgos if the user's score is enough for the algorithms:
        for(String i: sortsAndCorrespondingValues.keySet()) {
            if (sortsAndCorrespondingValues.get(i) > user.getScore())
                continue;
            availableSortingAlgos.add(i);
        }
        // Add the availableSortingAlgos to the selectionComboBox options:
        String[] availableSortArray = new String[availableSortingAlgos.size()];
        selectionComboBox.setModel(new DefaultComboBoxModel<>(availableSortingAlgos.toArray(availableSortArray)));
    }

}
