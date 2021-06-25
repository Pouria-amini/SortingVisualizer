package CulminatingTask;

import CulminatingTask.Games.BalanceSortingGame;
import CulminatingTask.Games.GuessSortingGame;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static CulminatingTask.Application.*;
import static CulminatingTask.Login.application;
import static CulminatingTask.Login.user;

/**
 * <p><b><i>Play Sorting Games</i></b></p>
 * <p>This class creates a panel using the properties of JPanel on top of {@link Application#parentPanel}.
 * This panel will be a placeholder for games created for this application. There are three main panels on this
 * panel: {@link #mainGamePanel}, {@link #controlPanelFromPS controlPanel}, and {@link #chooseGameModePanel}.</p>
 * <p>{@link #controlPanelFromPS controlPanel} is the panel that holds the frame control and does actions such as
 * closing the Application frame, minimising the frame, and returning to main menu. {@link #chooseGameModePanel} is
 * the panel that holds the option to switch between games available. {@link #mainGamePanel} is the main frame in which
 * the games will be performed.</p>
 * @see BalanceSortingGame
 * @see GuessSortingGame
 */
public class PlaySorting extends JPanel {

    /**
     * Variable Initialisations
     */
    private JPanel controlPanelFromPS;
    private JButton closeButtonFromPS;
    private JButton minButtonFromPS;
    private JButton returnHomeButtonFromPS;
    private JButton infoButtonFromPS;
    private JPanel chooseGameModePanel;
    private JComboBox gameModeComboBox;
    private JLabel chooseGameModeLabel;
    public static JPanel mainGamePanel;
    private BalanceSortingGame balanceSortingGame;
    private GuessSortingGame guessSortingGamePanel;

    PlaySorting() {
        initComponents();
    }

    /**
     * Create the object
     */
    private void initComponents() {

        controlPanelFromPS = new JPanel();
        closeButtonFromPS = new JButton();
        minButtonFromPS = new JButton();
        returnHomeButtonFromPS = new JButton();
        infoButtonFromPS = new JButton();
        chooseGameModePanel = new JPanel();
        gameModeComboBox = new JComboBox();
        chooseGameModeLabel = new JLabel();
        mainGamePanel = new JPanel();

        controlPanelFromPS.setBackground(new Color(255, 245, 240));

        // Close button settings:
        closeButtonFromPS.setIcon(new ImageIcon("src/CulminatingTask/Images/close-circle.png"));
        closeButtonFromPS.setBorder(null);
        closeButtonFromPS.setBorderPainted(false);
        closeButtonFromPS.setFocusable(false);
        closeButtonFromPS.setBackground(new Color(255, 245, 240));
        closeButtonFromPS.addActionListener(e -> {
            if(user.isScoreChanged())
                updateUserScore(user.getScore());
            ExitTheApplication();
        });

        // Minimize button settings:
        minButtonFromPS.setIcon(new ImageIcon("src/CulminatingTask/Images/minus-circle.png"));
        minButtonFromPS.setBorder(null);
        minButtonFromPS.setBorderPainted(false);
        minButtonFromPS.setFocusable(false);
        minButtonFromPS.setBackground(new Color(255, 245, 240));
        minButtonFromPS.addActionListener(e -> application.MinimizeTheApplication());

        // Return to menu button settings:
        returnHomeButtonFromPS.setIcon(new ImageIcon("src/CulminatingTask/Images/home-circle.png"));
        returnHomeButtonFromPS.setBorder(null);
        returnHomeButtonFromPS.setBorderPainted(false);
        returnHomeButtonFromPS.setFocusable(false);
        returnHomeButtonFromPS.setBackground(new Color(255, 245, 240));
        returnHomeButtonFromPS.addActionListener(e ->{ // Make sure that the user know they will lose their progress if they quite:
            int answer = JOptionPane.showConfirmDialog(null, "        Are you Sure?\nYour Progress Will not be saved!", "Warning", JOptionPane.YES_NO_OPTION);
            if(answer != 0)
                return;
            if(user.isScoreChanged())
                updateUserScore(user.getScore());
            balanceSortingGame.resetTheGame();
            GoToComponent(menuPanel);
        });

        // Information button settings:
        infoButtonFromPS.setIcon(new ImageIcon("src/CulminatingTask/Images/information.png"));
        infoButtonFromPS.setBorder(null);
        infoButtonFromPS.setBorderPainted(false);
        infoButtonFromPS.setFocusable(false);
        infoButtonFromPS.setBackground(new Color(255, 245, 240));
        infoButtonFromPS.addActionListener(e -> {
            helpPanel.setSelectedIndex(2);
            GoToComponent(helpPanel);});

        //region The exact position of the elements on the controlPanelFromPS (IDE generated Code)
        GroupLayout controlPanelFromPSLayout = new GroupLayout(controlPanelFromPS);
        controlPanelFromPS.setLayout(controlPanelFromPSLayout);
        controlPanelFromPSLayout.setHorizontalGroup(
                controlPanelFromPSLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, controlPanelFromPSLayout.createSequentialGroup()
                                .addComponent(infoButtonFromPS)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(returnHomeButtonFromPS)
                                .addGap(0, 0, 0)
                                .addComponent(minButtonFromPS)
                                .addGap(0, 0, 0)
                                .addComponent(closeButtonFromPS))
        );
        controlPanelFromPSLayout.setVerticalGroup(
                controlPanelFromPSLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(controlPanelFromPSLayout.createSequentialGroup()
                                .addGroup(controlPanelFromPSLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(closeButtonFromPS)
                                        .addComponent(minButtonFromPS)
                                        .addComponent(returnHomeButtonFromPS)
                                        .addComponent(infoButtonFromPS))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        //endregion

        chooseGameModePanel.setBackground(new Color(255, 150, 102));

        // Select game mode combo box settings:
        gameModeComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Play Balance Sorting", "Play Guess Sorting" }));
        gameModeComboBox.setEnabled(false); // The other games are not available at the moment
        gameModeComboBox.setToolTipText("Not Available at the Moment!"); // The text will be displayed if mouse hovers over the combo box
        // This option is not available:
        gameModeComboBox.addActionListener(e -> {
            String selectedGame = (String) gameModeComboBox.getSelectedItem();
            if (selectedGame.equals("Play Guess Sorting")){

                // Make sure that the user know they will lose their progress if they quite:
                int answer = JOptionPane.showConfirmDialog(null, "        Are you Sure?\nYour Progress Will not be saved!", "Warning", JOptionPane.YES_NO_OPTION);
                if(answer != 0){
                    gameModeComboBox.setSelectedIndex(0);
                    return;
                }
                // Save the user's score:
                if(user.isScoreChanged())
                    updateUserScore(user.getScore());

                // Reset the game:
                balanceSortingGame.resetTheGame();
                mainGamePanel.add(balanceSortingGame);
                mainGamePanel.repaint();
                mainGamePanel.revalidate();
            }
            else if (selectedGame.equals("Play Balance Sorting")){

                // Make sure that the user know they will lose their progress if they quite:
                int answer = JOptionPane.showConfirmDialog(null, "        Are you Sure?\nYour Progress Will not be saved!", "Warning", JOptionPane.YES_NO_OPTION);
                if(answer != 0){
                    gameModeComboBox.setSelectedIndex(1);
                    return;
                }
                // TODO Save the user's score
                // TODO guessSortingGame.resetTheGame();
                mainGamePanel.add(guessSortingGamePanel);
                mainGamePanel.repaint();
                mainGamePanel.revalidate();
            }
        });

        chooseGameModeLabel.setText("Choose Game Mode:");

        //region The exact position of the elements on the chooseGameModePanel (IDE generated Code)
        GroupLayout chooseGameModePanelLayout = new GroupLayout(chooseGameModePanel);
        chooseGameModePanel.setLayout(chooseGameModePanelLayout);
        chooseGameModePanelLayout.setHorizontalGroup(
                chooseGameModePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, chooseGameModePanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chooseGameModeLabel)
                                .addGap(40, 40, 40)
                                .addComponent(gameModeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109))
        );
        chooseGameModePanelLayout.setVerticalGroup(
                chooseGameModePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, chooseGameModePanelLayout.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addGroup(chooseGameModePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(gameModeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(chooseGameModeLabel))
                                .addContainerGap())
        );
        //endregion

        mainGamePanel.setLayout(new CardLayout()); // MAke the mainGamePanel CardLayout to be able to switch between panels

        balanceSortingGame = new BalanceSortingGame(); // Initialise balanceSortingGame instance

        //guessSortingGamePanel = new GuessSortingGame(); // TODO Class under construction for now!

        //region The exact position of the elements on the playSortingPanel (IDE generated Code)
        GroupLayout playSortingGamesPanelLayout = new GroupLayout(this);
        this.setLayout(playSortingGamesPanelLayout);
        playSortingGamesPanelLayout.setHorizontalGroup(
                playSortingGamesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(controlPanelFromPS, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chooseGameModePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainGamePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        playSortingGamesPanelLayout.setVerticalGroup(
                playSortingGamesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(playSortingGamesPanelLayout.createSequentialGroup()
                                .addComponent(controlPanelFromPS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(mainGamePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(chooseGameModePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        //endregion

        // Add this panel to the parentPanel
        parentPanel.add(this, "card6");
    }

    /**
     * Resets the score of the user in the csv file using the {@link User} class.
     * @param newScore newly updated score of the user
     * @version 1.2
     * @see BalanceSortingGame
     * @see GuessSortingGame
     */
    public static void updateUserScore(int newScore) {
        try {
            // Create a open the csv file and create an scanner:
            File userInfoFile = new File("src/CulminatingTask/UserInfo.csv");
            Scanner scanner = new Scanner(userInfoFile);

            // Accounts holder:
            ArrayList<String[]> users = new ArrayList<>();
            String[] userInfo;

            // Until a user exists, add their info to userInfoFile:
            while (scanner.hasNextLine()) {
                userInfo = scanner.nextLine().split(",");
                users.add(userInfo);
            }
            scanner.close();

            // Create a BufferedWriter to write on the csv file:
            BufferedWriter csvWriter = new BufferedWriter(new FileWriter(userInfoFile));

            // Add the users to the csv file and change the score of the current user:
            for(String[] eachUser: users) {
                // Change the score of the current user:
                if (eachUser[0].equals(user.getUsername()))
                    eachUser[3] = String.valueOf(user.getScore());

                // Add the users to the csv file.
                csvWriter.write(String.join(",", eachUser));
                csvWriter.write("\n");
            }
            csvWriter.close();

        } catch (IOException e) {// handle the errors with the file
            JOptionPane.showMessageDialog(null, "<HTML>The Application is hacked!<br>Contact the Developer ASAP!"
                    , "The Application is hacked!", JOptionPane.ERROR_MESSAGE);

            // Exist the program and show the error on the console:
            System.out.println("Something's Wrong with the File");
            e.printStackTrace();
            System.exit(0);
        }
    }
}
