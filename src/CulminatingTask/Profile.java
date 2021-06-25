package CulminatingTask;

import javax.swing.*;
import java.awt.*;
import static CulminatingTask.Application.*;
import static CulminatingTask.Login.application;
import static CulminatingTask.Login.user;

/**
 * <p><i><b>User's Profile</b></i></p>
 * <p>This class will create a panel using the properties of JPanel to show the progress of the user. The user
 * can see the number of unlocked sorting algorithms, their username and their email address. The panel will
 * be accessible through {@link Menu} panel.</p>
 * @see Menu
 */
public class Profile extends JPanel {

    /**
     * Variable declarations
     */
    private JLabel progressBarLabel;
    private JProgressBar unlockedAlgosProgressBar;
    private JPanel lockPanel1;
    private JPanel lockPanel2;
    private JLabel insertionSortStatusLabel;
    private JLabel insertionSortUnlockedLabel;
    private JLabel bubbleSortStatusLabel;
    private JLabel bubbleSortUnlockedLabel;
    private JLabel gnomeSortStatusLabel;
    private JLabel gnomeSortUnlockedLabel;
    private JLabel mergeSortStatusLabel;
    private JLabel mergeSortUnlockedLabel;
    private JLabel quickSortStatusLabel;
    private JLabel quickSortUnlockedLabel;
    private JLabel radixSortStatusLabel;
    private JLabel radixSortUnlockedLabel;
    private JLabel selectionSortStatusLabel;
    private JLabel selectionSortUnlockedLabel;
    private JLabel shellSortStatusLabel;
    private JLabel shellSortUnlockLabel;
    private JLabel userPictureLabel;
    private JLabel usernameLabelFromProfile;
    private JLabel emailLabelFromProfile;
    private JButton closeButtonFromProfile;
    private JButton minButtonFromProfile;
    private JButton infoButtonFromProfile;
    private JButton returnToMenuFromProfile;

    /**
     * Initialise the panel
     */
    Profile() {
        initComponents();
    }

    /**
     * The main function
     */
    private void initComponents() {
          progressBarLabel = new JLabel();
          unlockedAlgosProgressBar = new JProgressBar();
          lockPanel1 = new JPanel();
          lockPanel2 = new JPanel();
          insertionSortStatusLabel = new JLabel();
          insertionSortUnlockedLabel = new JLabel();
          bubbleSortStatusLabel = new JLabel();
          bubbleSortUnlockedLabel = new JLabel();
          gnomeSortStatusLabel = new JLabel();
          gnomeSortUnlockedLabel = new JLabel();
          mergeSortStatusLabel = new JLabel();
          mergeSortUnlockedLabel = new JLabel();
          quickSortStatusLabel = new JLabel();
          quickSortUnlockedLabel = new JLabel();
          radixSortStatusLabel = new JLabel();
          radixSortUnlockedLabel = new JLabel();
          selectionSortStatusLabel = new JLabel();
          selectionSortUnlockedLabel = new JLabel();
          shellSortStatusLabel = new JLabel();
          shellSortUnlockLabel = new JLabel();
          userPictureLabel = new JLabel();
          usernameLabelFromProfile = new JLabel();
          emailLabelFromProfile = new JLabel();
          closeButtonFromProfile = new JButton();
          minButtonFromProfile = new JButton();
          infoButtonFromProfile = new JButton();
          returnToMenuFromProfile = new JButton();

        setBackground(new Color(255, 150, 102));

        // Create a Progress Bar to show the progress of the user:
        unlockedAlgosProgressBar.setBackground(new Color(255, 150, 102));
        unlockedAlgosProgressBar.setForeground(new Color(102, 102, 102));
        unlockedAlgosProgressBar.setStringPainted(true); // Attach Percentage counter to the progressBar
        unlockedAlgosProgressBar.setValue(user.getScore());

        // A Label for the Progress Bar
        progressBarLabel.setBackground(new Color(255, 150, 102));
        progressBarLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 18));
        progressBarLabel.setForeground(new Color(255, 245, 240));
        progressBarLabel.setText("Algorithms Unlocked:");

        //region A Label for each one of the Sorting Algorithms
        bubbleSortUnlockedLabel.setBackground(new Color(255, 150, 102));
        bubbleSortUnlockedLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
        bubbleSortUnlockedLabel.setForeground(new Color(255, 245, 240));
        bubbleSortUnlockedLabel.setText("Bubble Sort:");

        selectionSortUnlockedLabel.setBackground(new Color(255, 150, 102));
        selectionSortUnlockedLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
        selectionSortUnlockedLabel.setForeground(new Color(255, 245, 240));
        selectionSortUnlockedLabel.setText("Selection Sort:");

        insertionSortUnlockedLabel.setBackground(new Color(255, 150, 102));
        insertionSortUnlockedLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
        insertionSortUnlockedLabel.setForeground(new Color(255, 245, 240));
        insertionSortUnlockedLabel.setText("Insertion Sort:");

        shellSortUnlockLabel.setBackground(new Color(255, 150, 102));
        shellSortUnlockLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
        shellSortUnlockLabel.setForeground(new Color(255, 245, 240));
        shellSortUnlockLabel.setText("Shell Sort:");

        mergeSortUnlockedLabel.setBackground(new Color(255, 150, 102));
        mergeSortUnlockedLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
        mergeSortUnlockedLabel.setForeground(new Color(255, 245, 240));
        mergeSortUnlockedLabel.setText("Merge Sort");

        radixSortUnlockedLabel.setBackground(new Color(255, 150, 102));
        radixSortUnlockedLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
        radixSortUnlockedLabel.setForeground(new Color(255, 245, 240));
        radixSortUnlockedLabel.setText("Radix Sort");

        gnomeSortUnlockedLabel.setBackground(new Color(255, 150, 102));
        gnomeSortUnlockedLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
        gnomeSortUnlockedLabel.setForeground(new Color(255, 245, 240));
        gnomeSortUnlockedLabel.setText("Gnome Sort");

        quickSortUnlockedLabel.setBackground(new Color(255, 150, 102));
        quickSortUnlockedLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
        quickSortUnlockedLabel.setForeground(new Color(255, 245, 240));
        quickSortUnlockedLabel.setText("Quick Sort");
        //endregion

        //region The Left container of the status of the sorting algorithms (Locked or Unlocked)
        lockPanel1.setBackground(new Color(255, 245, 240));

        // Bubble sort label settings:
        bubbleSortStatusLabel.setBackground(new Color(255, 245, 240));
        bubbleSortStatusLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        bubbleSortStatusLabel.setForeground(new Color(102, 102, 102));
        bubbleSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
        bubbleSortStatusLabel.setText("Unlocked"); // The default status is locked

        // Selection sort label settings:
        selectionSortStatusLabel.setBackground(new Color(255, 245, 240));
        selectionSortStatusLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        selectionSortStatusLabel.setForeground(new Color(102, 102, 102));
        if (user.getScore() >= 15){ // If the user reaches 15 scores or more, the algorithms os unlocked
            selectionSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            selectionSortStatusLabel.setText("Unlocked");
        } else { // If the user didn't reach 15 scores or more, show the required score for unlock
            selectionSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock.png"));
            selectionSortStatusLabel.setText("Locked 15%");
        }

        // Insertion sort label settings:
        insertionSortStatusLabel.setBackground(new Color(255, 245, 240));
        insertionSortStatusLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        insertionSortStatusLabel.setForeground(new Color(102, 102, 102));
        if (user.getScore() >= 5){ // If the user reaches 5 scores or more, the algorithms os unlocked
            insertionSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            insertionSortStatusLabel.setText("Unlocked");
        } else { // If the user didn't reach 5 scores or more, show the required score for unlock
            insertionSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock.png"));
            insertionSortStatusLabel.setText("Locked 5%");
        }

        // Sell sort label settings:
        shellSortStatusLabel.setBackground(new Color(255, 245, 240));
        shellSortStatusLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        shellSortStatusLabel.setForeground(new Color(102, 102, 102));
        if (user.getScore() >= 25){ // If the user reaches 25 scores or more, the algorithms os unlocked
            shellSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            shellSortStatusLabel.setText("Unlocked");
        } else { // If the user didn't reach 25 scores or more, show the required score for unlock
            shellSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock.png"));
            shellSortStatusLabel.setText("Locked 25%");
        }

        //region The exact position of the elements on the lockPanel1 (Left Panel) (IDE generated Code)
        GroupLayout LockPanel1Layout = new GroupLayout(lockPanel1);
        lockPanel1.setLayout(LockPanel1Layout);
        LockPanel1Layout.setHorizontalGroup(
                LockPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(LockPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(LockPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(shellSortStatusLabel)
                                        .addComponent(insertionSortStatusLabel)
                                        .addComponent(selectionSortStatusLabel)
                                        .addComponent(bubbleSortStatusLabel))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LockPanel1Layout.setVerticalGroup(
                LockPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(LockPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(bubbleSortStatusLabel)
                                .addGap(68, 68, 68)
                                .addComponent(insertionSortStatusLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                .addComponent(selectionSortStatusLabel)
                                .addGap(72, 72, 72)
                                .addComponent(shellSortStatusLabel)
                                .addGap(29, 29, 29))
        );
        //endregion
        //endregion

        //region The Right container of the status of the sorting algorithms (Locked or Unlocked)
        lockPanel2.setBackground(new Color(255, 245, 240));

        // Merge sort label settings:
        mergeSortStatusLabel.setBackground(new Color(255, 245, 240));
        mergeSortStatusLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        mergeSortStatusLabel.setForeground(new Color(102, 102, 102));
        if (user.getScore() >= 40){ // If the user reaches 40 scores or more, the algorithms os unlocked
            mergeSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            mergeSortStatusLabel.setText("Unlocked");
        } else { // If the user didn't reach 25 scores or more, show the required score for unlock
            mergeSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock.png"));
            mergeSortStatusLabel.setText("Locked 40%");
        }

        // Radix sort label settings:
        radixSortStatusLabel.setBackground(new Color(255, 245, 240));
        radixSortStatusLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        radixSortStatusLabel.setForeground(new Color(102, 102, 102));
        if (user.getScore() >= 55){ // If the user reaches 55 scores or more, the algorithms os unlocked
            radixSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            radixSortStatusLabel.setText("Unlocked");
        } else { // If the user didn't reach 55 scores or more, show the required score for unlock
            radixSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock.png"));
            radixSortStatusLabel.setText("Locked 55%");
        }

        // Gnome sort label settings: (75% is just a joke for Gnome sort)
        gnomeSortStatusLabel.setBackground(new Color(255, 245, 240));
        gnomeSortStatusLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        gnomeSortStatusLabel.setForeground(new Color(102, 102, 102));
        if (user.getScore() >= 75){ // If the user reaches 75 scores or more, the algorithms os unlocked
            gnomeSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            gnomeSortStatusLabel.setText("Unlocked");
        } else { // If the user didn't reach 75 scores or more, show the required score for unlock
            gnomeSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock.png"));
            gnomeSortStatusLabel.setText("Locked 75%");
        }

        // Quick sort label settings:
        quickSortStatusLabel.setBackground(new Color(255, 245, 240));
        quickSortStatusLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        quickSortStatusLabel.setForeground(new Color(102, 102, 102));
        if (user.getScore() >= 100){ // If the user reaches 100 scores or more, the algorithms os unlocked
            quickSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            quickSortStatusLabel.setText("Unlocked              ");
        } else { // If the user didn't reach 100 scores or more, show the required score for unlock
            quickSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock.png"));
            quickSortStatusLabel.setText("Locked 100%       ");
        }

        //region The exact position of the elements on the lockPanel2(Right Panel) (IDE generated Code)
        GroupLayout LockPanel2Layout = new GroupLayout(lockPanel2);
        lockPanel2.setLayout(LockPanel2Layout);
        LockPanel2Layout.setHorizontalGroup(
                LockPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(quickSortStatusLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(LockPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(LockPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(gnomeSortStatusLabel)
                                        .addComponent(radixSortStatusLabel)
                                        .addComponent(mergeSortStatusLabel))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        LockPanel2Layout.setVerticalGroup(
                LockPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(LockPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(mergeSortStatusLabel)
                                .addGap(64, 64, 64)
                                .addComponent(radixSortStatusLabel)
                                .addGap(71, 71, 71)
                                .addComponent(gnomeSortStatusLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(quickSortStatusLabel)
                                .addGap(34, 34, 34))
        );
        //endregion
        //endregion

        // The Username Label to hold the name of the user:
        usernameLabelFromProfile.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
        usernameLabelFromProfile.setForeground(new Color(255, 245, 240));
        usernameLabelFromProfile.setText("Username: " + user.getUsername());

        // The Email Address Label to hold the email of the user:
        emailLabelFromProfile.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
        emailLabelFromProfile.setForeground(new Color(255, 245, 240));
        emailLabelFromProfile.setText("Email Address: " + user.getEmailAddress());

        // Set an icon for the user (It can not be changed though)
        userPictureLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/account-circle-2.png"));

        // Close button on top:
        closeButtonFromProfile.setBackground(new Color(255, 150, 102));
        closeButtonFromProfile.setIcon(new ImageIcon("src/CulminatingTask/Images/close-circle.png"));
        closeButtonFromProfile.setBorder(null);
        closeButtonFromProfile.setBorderPainted(false);
        closeButtonFromProfile.setFocusable(false);
        closeButtonFromProfile.addActionListener(eve -> ExitTheApplication());

        // Minimize button on top:
        minButtonFromProfile.setBackground(new Color(255, 150, 102));
        minButtonFromProfile.setIcon(new ImageIcon("src/CulminatingTask/Images/minus-circle.png"));
        minButtonFromProfile.setBorder(null);
        minButtonFromProfile.setBorderPainted(false);
        minButtonFromProfile.setFocusable(false);
        minButtonFromProfile.addActionListener(eve -> application.MinimizeTheApplication());

        // Go back to the Menu button on top:
        returnToMenuFromProfile.setBackground(new Color(255, 150, 102));
        returnToMenuFromProfile.setIcon(new ImageIcon("src/CulminatingTask/Images/home-circle.png"));
        returnToMenuFromProfile.setBorder(null);
        returnToMenuFromProfile.setBorderPainted(false);
        returnToMenuFromProfile.setFocusable(false);
        returnToMenuFromProfile.addActionListener(evt -> GoToComponent(menuPanel));

        // Info button about the profile on top:
        infoButtonFromProfile.setBackground(new Color(255, 150, 102));
        infoButtonFromProfile.setIcon(new ImageIcon("src/CulminatingTask/Images/information.png"));
        infoButtonFromProfile.setBorder(null);
        infoButtonFromProfile.setBorderPainted(false);
        infoButtonFromProfile.setFocusable(false);
        infoButtonFromProfile.addActionListener(evt -> {
            // Go to the forth tab in the help tabbed pane for info about the profile:
            helpPanel.setSelectedIndex(3);
            GoToComponent(helpPanel);
        });

        //region The exact position of the elements on the profile Panel (IDE generated Code)
        GroupLayout profilePanelLayout = new GroupLayout(this);
        this.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
                profilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(profilePanelLayout.createSequentialGroup()
                                                .addGap(17, 17, 17)
                                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(emailLabelFromProfile, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                                                        .addComponent(usernameLabelFromProfile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(profilePanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(userPictureLabel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(infoButtonFromProfile))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(profilePanelLayout.createSequentialGroup()
                                                .addComponent(unlockedAlgosProgressBar, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                                                .addComponent(returnToMenuFromProfile)
                                                .addGap(0, 0, 0)
                                                .addComponent(minButtonFromProfile)
                                                .addGap(0, 0, 0)
                                                .addComponent(closeButtonFromProfile, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2))
                                        .addGroup(profilePanelLayout.createSequentialGroup()
                                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(profilePanelLayout.createSequentialGroup()
                                                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(selectionSortUnlockedLabel)
                                                                        .addComponent(insertionSortUnlockedLabel)
                                                                        .addComponent(shellSortUnlockLabel)
                                                                        .addComponent(bubbleSortUnlockedLabel))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lockPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(90, 90, 90)
                                                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(mergeSortUnlockedLabel)
                                                                        .addComponent(radixSortUnlockedLabel)
                                                                        .addComponent(gnomeSortUnlockedLabel)
                                                                        .addComponent(quickSortUnlockedLabel))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lockPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(progressBarLabel, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
                                                .addGap(23, 23, 23))))
        );
        profilePanelLayout.setVerticalGroup(
                profilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(profilePanelLayout.createSequentialGroup()
                                .addGap(203, 203, 203)
                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(bubbleSortUnlockedLabel)
                                        .addComponent(mergeSortUnlockedLabel))
                                .addGap(74, 74, 74)
                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(radixSortUnlockedLabel)
                                        .addComponent(selectionSortUnlockedLabel))
                                .addGap(73, 73, 73)
                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(gnomeSortUnlockedLabel)
                                        .addComponent(insertionSortUnlockedLabel))
                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(profilePanelLayout.createSequentialGroup()
                                                .addGap(73, 73, 73)
                                                .addComponent(quickSortUnlockedLabel))
                                        .addGroup(profilePanelLayout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(shellSortUnlockLabel)))
                                .addContainerGap(145, Short.MAX_VALUE))
                        .addGroup(profilePanelLayout.createSequentialGroup()
                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(profilePanelLayout.createSequentialGroup()
                                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(profilePanelLayout.createSequentialGroup()
                                                                .addComponent(infoButtonFromProfile)
                                                                .addGap(44, 44, 44)
                                                                .addComponent(progressBarLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(closeButtonFromProfile, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(profilePanelLayout.createSequentialGroup()
                                                                .addComponent(returnToMenuFromProfile, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(77, 77, 77)))
                                                .addComponent(unlockedAlgosProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(minButtonFromProfile))
                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(profilePanelLayout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(userPictureLabel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(usernameLabelFromProfile)
                                                .addGap(18, 18, 18)
                                                .addComponent(emailLabelFromProfile)
                                                .addGap(156, 156, 156))
                                        .addGroup(GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(profilePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lockPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lockPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(115, 115, 115))))
        );
        //endregion

        // Add the Profile Panel to the Parent Panel:
        parentPanel.add(this, "card6");
    }

    /**
     * Update the profile panel if the user earns new points.
     * This method is used by the games in Game directory.
     * @version 1.1
     * @see PlaySorting
     * @see CulminatingTask.Games.BalanceSortingGame BalanceSortingGame
     * @see CulminatingTask.Games.GuessSortingGame GuessSortingGame
     */
    public void updateProfile() {

        unlockedAlgosProgressBar.setValue(user.getScore());

        if (user.getScore() >= 15) { // If the user reaches 15 scores or more, the algorithms os unlocked
            selectionSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            selectionSortStatusLabel.setText("Unlocked");
        }

        if (user.getScore() >= 5) { // If the user reaches 5 scores or more, the algorithms os unlocked
            insertionSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            insertionSortStatusLabel.setText("Unlocked");
        }

        if (user.getScore() >= 25) { // If the user reaches 25 scores or more, the algorithms os unlocked
            shellSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            shellSortStatusLabel.setText("Unlocked");
        }

        if (user.getScore() >= 40){ // If the user reaches 40 scores or more, the algorithms os unlocked
            mergeSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            mergeSortStatusLabel.setText("Unlocked");
        }

        if (user.getScore() >= 55){ // If the user reaches 55 scores or more, the algorithms os unlocked
            radixSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            radixSortStatusLabel.setText("Unlocked");
        }

        if (user.getScore() >= 75){ // If the user reaches 75 scores or more, the algorithms os unlocked
            gnomeSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            gnomeSortStatusLabel.setText("Unlocked");
        }

        if (user.getScore() >= 100){ // If the user reaches 100 scores or more, the algorithms os unlocked
            quickSortStatusLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock-open-variant.png"));
            quickSortStatusLabel.setText("Unlocked              ");
        }
    }
}
