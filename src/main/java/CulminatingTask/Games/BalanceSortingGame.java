package CulminatingTask.Games;

import CulminatingTask.PlaySorting;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static CulminatingTask.PlaySorting.mainGamePanel;
import static CulminatingTask.Login.user;
import static CulminatingTask.Application.profilePanel;
import static CulminatingTask.Application.learnSortingPanel;

/**
 * <p><i><b>Balance Sorting Game</b></i></p>
 * <p><i>Description of the Game:</i></p>
 * <p>The player will be provided with 10 distinct weights. The rule of the game is to try to arrange the ways from the
 * lighter weight to the heavier one. The player has to use the spinners to set the position of the weights. The player
 * also has the opportunity to examine the weight of two weights and arrange the weights according to the output of the
 * examination. The history of the prior examinations will be provided to a text field (historyTextField) to the right
 * of the panel. If the player could arrange the weight, they will achieve points according to the number of the examination.
 * The more they examine the weights, the lesser would be their final score, but they would definitely achieve a score higher
 * than zero. See how to balance the weights using sorting algorithms: <a href="https://www.youtube.com/watch?v=BkDVboMlYuA&list=PL_EbyzYKBbbWCS4nbCKbKmYIbUS4b_4JS">YouTube</a>.</p>
 * <p><i>Description of the class created for the game:</i></p>
 * <p>The {@link BalanceSortingGame} is created using the properties of the JPanel. This class extend JPanel, designs the GUI
 * and defines the logic behind the game. This panel will be placed on {@link CulminatingTask.PlaySorting#mainGamePanel mainGamePanel}
 * which has CardLayout and contains various panels on it.</p>
 */
public class BalanceSortingGame extends JPanel {

    /**
     * Variable declarations
     */
    private JLabel greaterOrSmallerSignLabel;
    private JLabel historyLabel;
    private JLabel bestScoreLabel;
    private JLabel weightHolderLabel1;
    private JLabel weightHolderLabel10;
    private JLabel weightHolderLabel2;
    private JLabel weightHolderLabel3;
    private JLabel weightHolderLabel4;
    private JLabel weightHolderLabel5;
    private JLabel weightHolderLabel6;
    private JLabel weightHolderLabel7;
    private JLabel weightHolderLabel8;
    private JLabel weightHolderLabel9;
    private JLabel[] weightHolderLabels;
    private JLabel aLabel;
    private JSpinner aSpinner;
    private JLabel bLabel;
    private JSpinner bSpinner;
    private JLabel cLabel;
    private JSpinner cSpinner;
    private JLabel dLabel;
    private JSpinner dSpinner;
    private JLabel eLabel;
    private JSpinner eSpinner;
    private JLabel fLabel;
    private JSpinner fSpinner;
    private JLabel gLabel;
    private JSpinner gSpinner;
    private JLabel hLabel;
    private JSpinner hSpinner;
    private JLabel iLabel;
    private JSpinner iSpinner;
    private JLabel jLabel;
    private JSpinner jSpinner;
    private JLabel[] labels;
    private JSpinner[] spinners;
    private JComboBox<String> selectedWeightComboBox2;
    private JComboBox<String> selectedWeightComboBox1;
    private JTextArea historyTextArea;
    private JScrollPane historyScrollPane;

    public static int bestScore = 0;
    private int currentScore = 100;
    private Map<String, Integer> correctOrderOfWeights;

    /**
     * The game logic and GUI
     */
    public BalanceSortingGame() {

        greaterOrSmallerSignLabel = new JLabel();
        historyLabel = new JLabel();
        bestScoreLabel = new JLabel();

        // Labels to hold the position of the weights as user's desire:
        weightHolderLabel1 = new JLabel();
        weightHolderLabel2 = new JLabel();
        weightHolderLabel3 = new JLabel();
        weightHolderLabel4 = new JLabel();
        weightHolderLabel5 = new JLabel();
        weightHolderLabel6 = new JLabel();
        weightHolderLabel7 = new JLabel();
        weightHolderLabel8 = new JLabel();
        weightHolderLabel9 = new JLabel();
        weightHolderLabel10 = new JLabel();
        weightHolderLabels = new JLabel[]{ // A collection fot the weightHolderLabel labels for some optimisations
                weightHolderLabel1, weightHolderLabel2, weightHolderLabel3, weightHolderLabel4, weightHolderLabel5,
                weightHolderLabel6, weightHolderLabel7, weightHolderLabel8, weightHolderLabel9, weightHolderLabel10
        };

        // Labels and their corresponding spinners to let the user change the position of the weights:
        aLabel = new JLabel();
        aSpinner = new JSpinner();
        bLabel = new JLabel();
        bSpinner = new JSpinner();
        cLabel = new JLabel();
        cSpinner = new JSpinner();
        dLabel = new JLabel();
        dSpinner = new JSpinner();
        eLabel = new JLabel();
        eSpinner = new JSpinner();
        fLabel = new JLabel();
        fSpinner = new JSpinner();
        gLabel = new JLabel();
        gSpinner = new JSpinner();
        hLabel = new JLabel();
        hSpinner = new JSpinner();
        iLabel = new JLabel();
        iSpinner = new JSpinner();
        jLabel = new JLabel();
        jSpinner = new JSpinner();
        labels = new JLabel[]{ // A collection fot the weight labels for some optimisations
                aLabel, bLabel, cLabel, dLabel, eLabel,
                fLabel, gLabel, jLabel, hLabel, iLabel
        };
        spinners = new JSpinner[]{ // A collection fot the weight spinners for some optimisations
                aSpinner, bSpinner, cSpinner, dSpinner, eSpinner,
                fSpinner, gSpinner, jSpinner, hSpinner, iSpinner
        };

        selectedWeightComboBox2 = new JComboBox<>(); // This combo box is to let the user pick a letter for comparison with selectedWeightComboBox1's letter
        selectedWeightComboBox1 = new JComboBox<>(); // This combo box is to let the user pick a letter for comparison with selectedWeightComboBox2's letter

        // These two variables create a text area which will be scrollable and holds the previous user's attempt on comparing the weights' weight.
        historyTextArea = new JTextArea();
        historyScrollPane = new JScrollPane();

        // Setting the weight of each of the weights randomly into a LinkedHashMap (Using a linked hash map to keep the order of the hash map):
        correctOrderOfWeights = new LinkedHashMap<>();
        int[] weightsWeight = new int[10];
        String[] weightsName = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        for (int i = 1; i < 11; i++) // Create the numbers 1-10
            weightsWeight[i - 1] = i;
        shuffleArray(weightsWeight); // Shuffle the numbers

        for (int i = 0; i < 10; i++) { // Assign the weights to the shuffled numbers
            correctOrderOfWeights.put(weightsName[i], weightsWeight[i]);
        }

        setBackground(new Color(255, 245, 240)); // Set the background of the panel

        loseFocus(this); // Loose focus when the user clicks on the panel

        // Set the icon of each of the weight labels:
        aLabel.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/BottleA.png"));
        bLabel.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/BottleB.png"));
        cLabel.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/BottleC.png"));
        dLabel.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/BottleD.png"));
        eLabel.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/BottleE.png"));
        fLabel.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/BottleF.png"));
        gLabel.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/BottleG.png"));
        hLabel.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/BottleI.png"));
        iLabel.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/BottleJ.png"));
        jLabel.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/BottleH.png"));

        selectedWeightComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"Select", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}));
        selectedWeightComboBox1.addActionListener(evt -> comboBoxesActionListener());

        selectedWeightComboBox2.setModel(new DefaultComboBoxModel<>(new String[]{"Select", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}));
        selectedWeightComboBox2.addActionListener(e -> comboBoxesActionListener());

        //History area settings:
        historyTextArea.setColumns(20);
        historyTextArea.setRows(5);
        historyTextArea.setEditable(false);
        historyTextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        historyScrollPane.setViewportView(historyTextArea);

        // Set the settings of spinners and weightHolderLabels simultaneously (Optimised):
        for (int i = 0; i < 10; i++) {

            spinners[i].setModel(new SpinnerNumberModel(0, 0, 10, 1)); // Set the range of each of the spinner to 1-10
            spinners[i].setValue(0); // Set the default (Primary) value of each of the spinner to 0

            weightHolderLabels[i].setSize(new Dimension(49, 90)); // Set the dimension of each of the weightHolderLabels
            weightHolderLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Set the border of each of the weightHolderLabels to black to make the labels recognisable

            spinnerActionListener(spinners[i], labels[i]); // Call the spinnerActionListener (Do actions if the spinners are triggered)
        }

        // The settings of the history text field.
        historyLabel.setBackground(new Color(255, 245, 240));
        historyLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        historyLabel.setForeground(new Color(255, 0, 0));
        historyLabel.setText("History");

        bestScoreLabel.setText("                ");

        //region The exact position of the elements on the BalanceSortingGamePanel (IDE generated Code)
        GroupLayout balanceSortingGamePanelLayout = new GroupLayout(this);
        this.setLayout(balanceSortingGamePanelLayout);
        balanceSortingGamePanelLayout.setHorizontalGroup(
                balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                .addComponent(fSpinner)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(fLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(gSpinner, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                .addComponent(aSpinner, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(aLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(bSpinner, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                .addComponent(bLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cSpinner, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(dSpinner, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                .addComponent(gLabel)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jSpinner, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(greaterOrSmallerSignLabel)
                                                                        .addComponent(jLabel))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(hSpinner, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(dLabel)
                                                        .addComponent(hLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                .addComponent(iSpinner, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(iLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                .addComponent(eSpinner, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(eLabel))))
                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(weightHolderLabel1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(weightHolderLabel2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                .addComponent(selectedWeightComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(195, 195, 195)
                                                                .addComponent(selectedWeightComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                .addComponent(weightHolderLabel3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(weightHolderLabel4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(weightHolderLabel5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(weightHolderLabel6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(weightHolderLabel7, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(weightHolderLabel8, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(weightHolderLabel9, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(weightHolderLabel10, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                .addGap(256, 256, 256)
                                                .addComponent(bestScoreLabel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(historyScrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(historyLabel))
                                .addGap(30, 30, 30))
        );
        balanceSortingGamePanelLayout.setVerticalGroup(
                balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, balanceSortingGamePanelLayout.createSequentialGroup()
                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                                .addComponent(bLabel, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(dLabel)
                                                                                                .addComponent(eLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                                                .addGap(4, 4, 4)
                                                                                                .addComponent(cLabel)))
                                                                                .addGap(23, 23, 23)
                                                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(gLabel, GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(jLabel, GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(iLabel)))
                                                                        .addComponent(hLabel)))
                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                                .addGap(38, 38, 38)
                                                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(bSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(cSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                                .addGap(37, 37, 37)
                                                                                .addComponent(dSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                                .addGap(36, 36, 36)
                                                                                .addComponent(eSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                                .addGap(91, 91, 91)
                                                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(gSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                                .addGap(89, 89, 89)
                                                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(hSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(iSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(aLabel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                                .addGap(38, 38, 38)
                                                                                .addComponent(aSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(fLabel))
                                                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                                                .addGap(47, 47, 47)
                                                                                .addComponent(fSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(selectedWeightComboBox1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(selectedWeightComboBox2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(greaterOrSmallerSignLabel, GroupLayout.Alignment.TRAILING))
                                                .addGap(30, 30, 30)
                                                .addComponent(bestScoreLabel)
                                                .addGap(62, 62, 62)
                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(weightHolderLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(weightHolderLabel2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(balanceSortingGamePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(weightHolderLabel3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(weightHolderLabel4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(weightHolderLabel5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(weightHolderLabel6, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(weightHolderLabel7, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(weightHolderLabel8, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(weightHolderLabel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(weightHolderLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(balanceSortingGamePanelLayout.createSequentialGroup()
                                                .addGap(0, 68, Short.MAX_VALUE)
                                                .addComponent(historyLabel)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(historyScrollPane, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)))
                                .addGap(15, 15, 15))
        );
        //endregion

        mainGamePanel.add(this, "card3"); // Add the panel to the main Panel
    }

    /**
     * <p>Shuffles the array that holds the value of the weights' weight to make them randomly distributed.
     * (Implementing Fisher–Yates shuffle)</p>
     * <p>The code is written by "PhiLho" on <a href="https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array">stackoverflow</a>.</p>
     *
     * @param array An int array to shuffle
     * @version 1.1
     */
    private void shuffleArray(int[] array) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }

    /**
     * <p>Makes the components to loose their focus whenever the user clicks on the panel.</p>
     * <p>The code is written by "tmwanik" on <a href="https://stackoverflow.com/questions/15336251/lose-focus-on-jtextfield-when-clicking-on-the-panel/15336634">stackoverflow</a>.</p>
     *
     * @param panel The clickable panel that gains the focus
     * @version 1.1
     */
    public static void loseFocus(JPanel panel) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseReleased(e);
                panel.grabFocus();
            }
        });
    }

    /**
     * <p>Resets the game and replaces all the components with their default values.</p>
     *
     * @version 1.1
     */
    public void resetTheGame() {

        greaterOrSmallerSignLabel.setIcon(null);
        historyTextArea.setText("");
        currentScore = 0;

        // If user's score has changed, reset their score in the csv file containing their info and update the profile and the learnSorting panels.
        if(user.isScoreChanged()) {
            PlaySorting.updateUserScore(user.getScore());
            profilePanel.updateProfile();
            learnSortingPanel.updateLearnSorting();
        }

        if (bestScore != 0)
            bestScoreLabel.setText("Best Score: " + bestScore);
        else
            bestScoreLabel.setText("                ");


        for (int i = 0; i < 10; i++) { // Go over all the spinners and weightHolderLabels and reset their values
            spinners[i].setValue(0);
            weightHolderLabels[i].setIcon(null);
        }

        // Set the selectedWeightComboBoxes to their default value, which is "Select":
        selectedWeightComboBox1.setSelectedIndex(0);
        selectedWeightComboBox2.setSelectedIndex(0);

        validate();
    }

    /**
     * <p>Will be called when the combo boxes of the weights are triggered.</p>
     * <p>The values of the selected options will be compared and the results will be displayed on the history text field.
     * If the weights of the combo boxes are not equal, the greater sign label will display that inequality.</p>
     *
     * @version 1.2
     */
    private void comboBoxesActionListener() {

        // Retrieve the selected weights from the combo boxes:
        String selectedRight = (String) selectedWeightComboBox2.getSelectedItem();
        String selectedLeft = (String) selectedWeightComboBox1.getSelectedItem();

        // If the retrieved items are not null ("Selected"), check which on is larger in weight:
        if (!selectedRight.equals("Select") && !selectedLeft.equals("Select")) {
            // If the left one is larger, assign greater icon to the left and display the inequality on the history text field:
            if (correctOrderOfWeights.get(selectedLeft) > correctOrderOfWeights.get(selectedRight)) {
                greaterOrSmallerSignLabel.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/LeftGreater.png"));
                historyTextArea.append(selectedLeft + " is heavier than " + selectedRight + "\n");
                currentScore--;
            }

            // If the two weights are the same, clear the greaterOrSmallerSignLabel's icon and display the equality on the history text field:
            else if (selectedRight.equals(selectedLeft)) {
                greaterOrSmallerSignLabel.setIcon(null);
                historyTextArea.append("Same Weights" + "\n");
            }
            // If the right one is larger, assign greater icon to the right and display the inequality on the history text field:
            else {
                greaterOrSmallerSignLabel.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/RightGreater.png"));
                historyTextArea.append(selectedRight + " is heavier than " + selectedLeft + "\n");
                currentScore--;
            }
        }
        // If any of the selected items include "Select" word, clear the greaterOrSmallerSignLabel's icon.
        else
            greaterOrSmallerSignLabel.setIcon(null);
    }

    /**
     * <p>Makes the spinners uneditable by the keyboard and calls the {@link #setOrder(JSpinner, JLabel) setOrder} method
     * whenever the spinner looses its focus.</p>
     * <p>The idea of adding {@link #addFocusListener(FocusListener) FocusListener} to the default editor instead of the spinner
     * was taken from "dlorde"'s comment on <a href="https://forums.codeguru.com/showthread.php?446751-RESOLVED-Detecting-focus-lost-for-JSpinner">codeguru</a>.</p>
     *
     * @param spinner The spinner that the user is currently on.
     * @param label   The label of the corresponding spinner.
     * @version 1.1
     * @see #setOrder(JSpinner, JLabel) setOrder
     */
    private void spinnerActionListener(JSpinner spinner, JLabel label) {
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) spinner.getEditor(); // Get the editor of the spinner
        editor.getTextField().setEditable(false); // Set the spinner's editor uneditable (to fix some bugs generated by keyboard input on the spinner)
        // If the editor of the spinner sis triggered, call the actionListener.
        editor.getTextField().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // DO NOTHING
            }

            /**
             * If the user remove the focus from the spinner, update the game (Call setOrder method).
             * Also check if the user won the game ofter the their move. If so, show a "You Won!" message and reset the game.
             */
            @Override
            public void focusLost(FocusEvent e) {
                setOrder(spinner, label);
                if (isWon()) {
                    if(currentScore/5 > bestScore) // If current score is higher than the best score, then the best score is current score
                        bestScore = currentScore/5;
                    user.addToScore(currentScore/5);
                    JOptionPane.showMessageDialog(null, "\tYou Won!\nYou Gained " + currentScore/5 + " points.", "You Won!", JOptionPane.INFORMATION_MESSAGE);
                    resetTheGame();
                }
            }
        });
    }

    /**
     * <p>Sets the order of the weights according to the user's desire.</p>
     *
     * @param spinner The spinner that the user is currently on.
     * @param label   The label of the corresponding spinner.
     * @version 1.6 (Optimised)
     * @see #spinnerActionListener(JSpinner, JLabel) spinnerActionListener
     */
    private void setOrder(JSpinner spinner, JLabel label) {

        Icon icon = label.getIcon(); // The icon of the label corresponding to the triggered spinner
        int spinnerValue = (int) spinner.getValue(); // The value of the triggered spinner

        // If spinner Value is not 0, set the chosen weight on the desired position:
        if (spinnerValue > 0) {
            // If the spot is already occupied, get rid of the former weight:
            if (weightHolderLabels[spinnerValue - 1].getIcon() != null)
                weightsCollision(weightHolderLabels[spinnerValue - 1]);
            clearWeightPreviousSpot(label); // Make sure there is no other duplicated of the same weight
            weightHolderLabels[spinnerValue - 1].setIcon(icon); // Set the weight on the desired position
        }
        // If spinner Value is 0, clear the weight from the order:
        else {
            for (JLabel weightsHolderLabel : weightHolderLabels)
                if (weightsHolderLabel.getIcon() != null && weightsHolderLabel.getIcon().equals(icon)) {
                    weightsHolderLabel.setIcon(null); // Clear the weight from the order
                    break; // (Optimised)
                }
        }
    }

    /**
     * <p>If a weightHolderLabel is already occupied, this method clears the label by assigning 0 to the spinner holding
     * the previous weight of the spinner.</p>
     *
     * @param weightHolderLabel The current weightHolderLabel that the user is manipulating.
     * @version 1.4 (optimised)
     * @see #setOrder(JSpinner, JLabel) setOrder
     */
    private void weightsCollision(JLabel weightHolderLabel) {
        for (int i = 0; i < 10; i++) {
            if (weightHolderLabel.getIcon() == labels[i].getIcon())
                spinners[i].setValue(0);
        }
    }

    /**
     * <p>Clears the icon of the weightLabel if it is already in the WeightHolderLabels. This avoids any duplications of
     * the same weight holders icon.</p>
     *
     * @param weightLabel The label that needs to be examined and compared to the other weightHolderLabels.
     * @version 1.2 (optimised)
     * @see #setOrder(JSpinner, JLabel) setOrder
     */
    private void clearWeightPreviousSpot(JLabel weightLabel) {
        for (JLabel weightHolderLabel : weightHolderLabels) {
            if (weightLabel.getIcon() == weightHolderLabel.getIcon())
                weightHolderLabel.setIcon(null);
        }
    }

    /**
     * <p>Checks if the player has won the game.</p>
     *
     * @return true if the player won the game, else false.
     * @version 1.2 (optimised)
     * @see #spinnerActionListener(JSpinner, JLabel) spinnerActionListener
     */
    private boolean isWon() {
        // Assign the values of the spinners into currentPositionsOfWeights:
        int[] currentPositionsOfWeights = new int[10];
        for (int i = 0; i < 10; i++)
            currentPositionsOfWeights[i] = (int) spinners[i].getValue();

        /*
        Go over currentPositionsOfWeights and correctOrderOfWeights
        values simultaneously to check if the order of the user's
        arrangement of weights is the same as the order of the correct
        arrangement of weights.
         */
        int k = 0;
        int i = currentPositionsOfWeights[k];
        for (int j : correctOrderOfWeights.values()) {
            // If arrangement is not correct return false:
            if (i != j)
                return false;
            if (k >= 9) break;
            i = currentPositionsOfWeights[++k];
        }
        // If arrangement is correct return true:
        return true;
    }
}
