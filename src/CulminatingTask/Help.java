package CulminatingTask;

import javax.swing.*;
import java.awt.*;

/**
 * <p><b><i>Help Section</i></b></p>
 * <p>This class is a JTabbedPane in which all of the instruction on how to use the application is mentioned.
 * The user can get detailed info about the functionalities of all of the buttons, spinners, sliders and other
 * JComponents available within the application.</p>
 * <p>The class holds various panels such as {@link #menuHelperPanel}, {@link #playTheGameHelperPanel},
 * {@link #profilePictureLabel}, and {@link #learnSortingPictureLabel}. All of these helper panels contain info about
 * their corresponding panels.</p>
 * @see PlaySorting
 * @see LearnSorting
 * @see Menu
 * @see Profile
 */
public class Help extends JTabbedPane {

    /**
     * Variable Declarations
     */
    public JPanel menuHelperPanel;
    public JLabel menuPictureLabel;
    public JPanel playTheGameHelperPanel;
    public JLabel playTheGamePictureLabel;
    public JPanel profileHelperPanel;
    public JLabel profilePictureLabel;
    public JPanel learnSortingHelperPanel;
    public JLabel learnSortingPictureLabel;
    public JButton returnToPreviousPanelFromHelper1;
    public JButton returnToPreviousPanelFromHelper2;
    public JButton returnToPreviousPanelFromHelper3;
    public JButton returnToPreviousPanelFromHelper4;
    
    Help(){
        initComponents();
    }

    /**
     * Initialise the TabbedPane
     */
    private void initComponents() {
        
          menuHelperPanel = new JPanel();
          menuPictureLabel = new JLabel();
          playTheGameHelperPanel = new JPanel();
          playTheGamePictureLabel = new JLabel();
          profileHelperPanel = new JPanel();
          profilePictureLabel = new JLabel();
          learnSortingHelperPanel = new JPanel();
          learnSortingPictureLabel = new JLabel();
          returnToPreviousPanelFromHelper1 = new JButton();
          returnToPreviousPanelFromHelper2 = new JButton();
          returnToPreviousPanelFromHelper3 = new JButton();
          returnToPreviousPanelFromHelper4 = new JButton();

          // Set the properties of the panels of the JTabbedPane:
          setPanels(menuHelperPanel, returnToPreviousPanelFromHelper1,
                  menuPictureLabel,
                  "Menu",
                  "src/CulminatingTask/Images/MenuPicture.png");

          setPanels(learnSortingHelperPanel,
                  returnToPreviousPanelFromHelper2,
                  learnSortingPictureLabel,
                  "Learn Sorting",
                  "src/CulminatingTask/Images/SortingVisualizerPicture.png");

          setPanels(playTheGameHelperPanel,
                  returnToPreviousPanelFromHelper3,
                  playTheGamePictureLabel,
                  "Play the Game",
                  "src/CulminatingTask/Images/PlaySortingPictureBalanceGame.png");

          setPanels(profileHelperPanel,
                  returnToPreviousPanelFromHelper4,
                  profilePictureLabel,
                  "Profile",
                  "src/CulminatingTask/Images/ProfilePicture.png");

          // Add the Help tabbedPane to the parentPanel:
          Application.parentPanel.add(this, "card7");
    }

    /**
     * Sets the setting of the return button.
     * @param returnButton return button.
     * @see #returnToPreviousPanelFromHelper1
     * @see #returnToPreviousPanelFromHelper2
     * @see #returnToPreviousPanelFromHelper3
     * @see #returnToPreviousPanelFromHelper4
     * @version 1.1
     */
    private void setReturnButton(JButton returnButton) {
        returnButton.setBackground(new Color(255, 150, 102));
        returnButton.setIcon(new ImageIcon("src/CulminatingTask/Images/arrow-right-circle.png"));
        returnButton.setBorder(null);
        returnButton.setFocusable(false);
        returnButton.addActionListener(evt -> Application.GoToComponent(Application.currentPanel));
    }

    /**
     * Sets the properties of each of the panels of Help TabbedPane class.
     * @param helpPanel The panel on the tabbedPane
     * @param returnButton The button to return to the previous section
     * @param pictureLabel The label which holds the picture of instruction
     * @param tabbedPaneName The name of the panel on the tabbedPane
     * @param pictureSource The source of the picture of instructions
     * @see #menuHelperPanel
     * @see #learnSortingHelperPanel
     * @see #playTheGameHelperPanel
     * @see #profileHelperPanel
     * @version 1.2
     */
    private void setPanels(JPanel helpPanel, JButton returnButton, JLabel pictureLabel, String tabbedPaneName, String pictureSource) {
        helpPanel.setBackground(new Color(255, 150, 102));

        // Add a return button to the panel user came from:
        setReturnButton(returnButton);

        // Set the instructions image on the helpPanel
        pictureLabel.setIcon(new ImageIcon(new ImageIcon(pictureSource).getImage()
                .getScaledInstance(922, 629, Image.SCALE_DEFAULT)));

        //region The exact position of the elements on the helpPanel (IDE generated Code)
        GroupLayout helpPanelLayout = new GroupLayout(helpPanel);
        helpPanel.setLayout(helpPanelLayout);
        helpPanelLayout.setHorizontalGroup(
                helpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, helpPanelLayout.createSequentialGroup()
                                .addComponent(pictureLabel, GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(returnButton))
        );
        helpPanelLayout.setVerticalGroup(
                helpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(helpPanelLayout.createSequentialGroup()
                                .addComponent(returnButton)
                                .addGap(0, 521, Short.MAX_VALUE))
                        .addComponent(pictureLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        //endregion

        // Add helpPanel to the Help TabbedPane
        addTab(tabbedPaneName, helpPanel);
    }

}
