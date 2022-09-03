package CulminatingTask;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

import static CulminatingTask.Application.*;
import static CulminatingTask.Login.application;

/**
 * <p><i><b>Navigation Menu</b></i></p>
 * <p>The following class is to help the user to navigate between the various panels of the application. The user can
 * either take one of the following actions:</p>
 * <ul>
 *  <li>Learn Sorting Algorithms By Visualization</li>
 *  <li>Play Sorting Games</li>
 *  <li>Visit the Profile Sections</li>
 *  <li>Visit the Help Section</li>
 *  <li>Exit the Application</li>
 * </ul>
 * <p>If the user choose one of the options, The frame would show the desired panel.</p>
 * @see LearnSorting
 * @see PlaySorting
 * @see Profile
 * @see Help
 * @see Application#ExitTheApplication() ExitTheApplication
 */
class Menu extends JPanel {

    /**
     * Variable declarations
     */
    private JLabel sortvisPictureLabelInMenu;
    private JLabel creditLabel;
    private JButton learnSortingButton;
    private JButton startPlayingButton;
    private JButton profileButton;
    private JButton helpButton;
    private JButton exitButton;
    private JButton minButtonFromMenu;
    private JButton closeButtonFromMenu;
    private JButton infoButtonFromMenu;

    Menu() {
        initComponents();
    }

    /**
     * Logic and GUI
     */
    private void initComponents(){
        sortvisPictureLabelInMenu = new JLabel();
        creditLabel = new JLabel();
        learnSortingButton = new JButton();
        startPlayingButton = new JButton();
        profileButton = new JButton();
        helpButton = new JButton();
        exitButton = new JButton();
        minButtonFromMenu = new JButton();
        closeButtonFromMenu = new JButton();
        infoButtonFromMenu = new JButton();

        setBackground(new Color(255, 245, 240));

        sortvisPictureLabelInMenu.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/My_Post-14.png"));

        //Help button settings:
        helpButton.setBackground(new Color(255, 150, 102));
        helpButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
        helpButton.setForeground(new Color(102, 102, 102)); // Change button's color
        helpButton.setText("Help");
        helpButton.setBorder(new LineBorder(new Color(255, 150, 102), 1, true)); // Set a border for the button
        helpButton.setFocusable(false);
        helpButton.addActionListener(evt -> {
            // Go to Help section:
            helpPanel.setSelectedIndex(0);
            GoToComponent(helpPanel);
        });

        //Exit button settings:
        exitButton.setBackground(new Color(255, 150, 102));
        exitButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
        exitButton.setForeground(new Color(102, 102, 102));
        exitButton.setText("Exit");
        exitButton.setBorder(new LineBorder(new Color(255, 150, 102), 1, true));
        exitButton.setFocusable(false);
        exitButton.addActionListener(evt -> ExitTheApplication());

        // Learn sorting button settings:
        learnSortingButton.setBackground(new Color(255, 150, 102));
        learnSortingButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
        learnSortingButton.setForeground(new Color(102, 102, 102));
        learnSortingButton.setText("Visualize Sorting Algorithms");
        learnSortingButton.setBorder(new LineBorder(new Color(255, 150, 102), 1, true));
        learnSortingButton.setFocusable(false);
        learnSortingButton.addActionListener(evt -> {
            // Go to Learning Panel:
            GoToComponent(learnSortingPanel);
        });

        //Profile button settings:
        profileButton.setBackground(new Color(255, 150, 102));
        profileButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
        profileButton.setForeground(new Color(102, 102, 102));
        profileButton.setText("Your Profile");
        profileButton.setBorder(new LineBorder(new Color(255, 150, 102), 1, true));
        profileButton.setFocusable(false);
        profileButton.addActionListener(evt -> {
            // Go to Profile Panel:
            GoToComponent(profilePanel);
        });

        //Start playing button Settings
        startPlayingButton.setBackground(new Color(255, 150, 102));
        startPlayingButton.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
        startPlayingButton.setForeground(new Color(102, 102, 102));
        startPlayingButton.setText("Play Sorting Games");
        startPlayingButton.setBorder(new LineBorder(new Color(255, 150, 102), 1, true));
        startPlayingButton.setFocusable(false);
        startPlayingButton.addActionListener(evt -> {
            // Go to Play Sorting Games Panel:
            GoToComponent(playSortingPanel);
        });

        // Credit:
        creditLabel.setForeground(new Color(102, 102, 102));
        creditLabel.setText("Created by Pouria Amini");

        // Close button on top:
        closeButtonFromMenu.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/close-circle.png"));
        closeButtonFromMenu.setBackground(new Color(255, 245, 240));
        closeButtonFromMenu.setBorder(null);
        closeButtonFromMenu.setBorderPainted(false);
        closeButtonFromMenu.setFocusable(false);
        closeButtonFromMenu.addActionListener(evt -> ExitTheApplication());

        // Minimize button on top:
        minButtonFromMenu.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/minus-circle.png"));
        minButtonFromMenu.setBorder(null);
        minButtonFromMenu.setBackground(new Color(255, 245, 240));
        minButtonFromMenu.setBorderPainted(false);
        minButtonFromMenu.setFocusable(false);
        minButtonFromMenu.addActionListener(evt -> application.MinimizeTheApplication());

        // Info button on top:
        infoButtonFromMenu.setIcon(new ImageIcon("src/main/java/CulminatingTask/Images/information.png"));
        infoButtonFromMenu.setBorder(null);
        infoButtonFromMenu.setBackground(new Color(255, 245, 240));
        infoButtonFromMenu.setBorderPainted(false);
        infoButtonFromMenu.setFocusable(false);
        infoButtonFromMenu.addActionListener(evt -> {
            // Go to the helper panel for the Menu:
            helpPanel.setSelectedIndex(0);
            GoToComponent(helpPanel);
        });

        //region The exact position of the elements on the panel (IDE generated Code)
        GroupLayout menuPanelLayout = new GroupLayout(this);
        this.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(creditLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(learnSortingButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(exitButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(startPlayingButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 489, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(helpButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(profileButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addComponent(sortvisPictureLabelInMenu)
                                .addGap(79, 257, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                                .addComponent(infoButtonFromMenu)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(minButtonFromMenu)
                                .addGap(0, 0, 0)
                                .addComponent(closeButtonFromMenu))
        );
        menuPanelLayout.setVerticalGroup(
                menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                .addComponent(closeButtonFromMenu)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(menuPanelLayout.createSequentialGroup()
                                                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(minButtonFromMenu)
                                                        .addComponent(infoButtonFromMenu))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                                .addComponent(sortvisPictureLabelInMenu, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62)))
                                .addComponent(learnSortingButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(startPlayingButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(profileButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(helpButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(creditLabel)
                                .addContainerGap())
        );
        //endregion

        // Add the Menu Panel to the Parent Panel:
        parentPanel.add(this, "card3");
    }
}
