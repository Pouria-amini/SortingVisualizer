package CulminatingTask;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * <h><i><b>Login Section</b></i></h>
 * <p>This class will create a frame in which the user can retrieve their previously achieved score. The user has to
 * use the username and password he/she created before to entre the application. If the user is new, they can create a new
 * account to entre the application. In addition, if the user forgot their username or password, they can retrieve their
 * information by providing the email address they used for signing up.</p>
 * <p>If the username and password provided by the user match the records, the frame would be disposed and a new {@link Application}
 * would be created.</p>
 * @see Application
 */
public class Login extends JFrame {

    /**
     * Variable Declarations
     */
    private File userInfoFile;
    private Scanner scanner;
    private JPanel backPanel;
    private JButton backToLoginButtonFromFP;
    private JPanel backToLoginFromForgotPanel;
    private JButton backToLoginFromSUButton;
    private JPanel backToLoginPanel;
    private JTextField createEmailField;
    private JPasswordField createPasswordField;
    private JTextField createUsernameField;
    private JTextField emailAddressField;
    private JLabel emailPicture2Label;
    private JButton forgotPasswordButton;
    private JPanel forgotPasswordPanel;
    private JButton goToSignUpPanelButton;
    private JLabel accountIconLabel;
    private JLabel lockIconLabel;
    private JLabel emailIconLabel;
    private JButton loginButton;
    private JPanel loginPanel;
    private JSeparator newSeparatorPassword;
    private JSeparator newSeparatorPassword1;
    private JSeparator newSeparatorPassword3;
    private JSeparator newSeparatorUsername;
    private JPanel newUsernamePasswordPanel;
    private JPanel newUsernamePasswordPanel1;
    private JPasswordField passwordField;
    private JLabel passwordPictureLabel;
    private JSeparator separatorPassword;
    private JSeparator separatorUsername;
    private JButton signUpButton;
    private JButton recoverAccountButton;
    private JPanel signUpButtonPanel;
    private JPanel signUpPanel;
    private JLabel sortvisPictureLabel;
    private JTextField usernameField;
    private JPanel usernamePasswordPanel;
    private JLabel usernamePictureLabel;
    public static Application application;
    public static User user;

    /**
     * Creates new Login frame.
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the Login class.
     */
    private void initComponents() {

        backPanel = new JPanel();
        loginPanel = new JPanel();
        signUpButtonPanel = new JPanel();
        goToSignUpPanelButton = new JButton();
        usernamePasswordPanel = new JPanel();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        separatorUsername = new JSeparator();
        separatorPassword = new JSeparator();
        loginButton = new JButton();
        forgotPasswordButton = new JButton();
        sortvisPictureLabel = new JLabel();
        usernamePictureLabel = new JLabel();
        passwordPictureLabel = new JLabel();
        signUpPanel = new JPanel();
        backToLoginPanel = new JPanel();
        backToLoginFromSUButton = new JButton();
        newUsernamePasswordPanel = new JPanel();
        createEmailField = new JTextField();
        createPasswordField = new JPasswordField();
        newSeparatorUsername = new JSeparator();
        newSeparatorPassword = new JSeparator();
        signUpButton = new JButton();
        createUsernameField = new JTextField();
        newSeparatorPassword1 = new JSeparator();
        accountIconLabel = new JLabel();
        lockIconLabel = new JLabel();
        emailIconLabel = new JLabel();
        forgotPasswordPanel = new JPanel();
        backToLoginFromForgotPanel = new JPanel();
        backToLoginButtonFromFP = new JButton();
        newUsernamePasswordPanel1 = new JPanel();
        emailAddressField = new JTextField();
        recoverAccountButton = new JButton();
        newSeparatorPassword3 = new JSeparator();
        emailPicture2Label = new JLabel();
        userInfoFile = new File("src/CulminatingTask/UserInfo.csv");

        // Panel settings:
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("SORTVIS");
        setLocationRelativeTo(null);
        setSize(new Dimension(800, 600));

        // Using an extra panel to utilize CardLayout for switching between front panels:
        backPanel.setLayout(new CardLayout());

        loginPanel.setPreferredSize(new Dimension(800, 600));

        signUpButtonPanel.setBackground(new Color(255, 150, 102));

        // goToSignUpPanel button settings:
        goToSignUpPanelButton.setBackground(new Color(255, 150, 102));
        goToSignUpPanelButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        goToSignUpPanelButton.setForeground(new Color(102, 102, 102));
        goToSignUpPanelButton.setText("Sign Up");
        goToSignUpPanelButton.setAlignmentY(0.0F);
        goToSignUpPanelButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        goToSignUpPanelButton.setFocusable(false);
        goToSignUpPanelButton.setHorizontalTextPosition(SwingConstants.CENTER);
        goToSignUpPanelButton.addActionListener(evt -> goToSignUpPanelButtonActionPerformed(evt));

        //region The exact position of the elements on the signUpButtonPanel (IDE generated Code)
        GroupLayout signUpButtonPanelLayout = new GroupLayout(signUpButtonPanel);
        signUpButtonPanel.setLayout(signUpButtonPanelLayout);
        signUpButtonPanelLayout.setHorizontalGroup(
                signUpButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(signUpButtonPanelLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(goToSignUpPanelButton, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(76, Short.MAX_VALUE))
        );
        signUpButtonPanelLayout.setVerticalGroup(
                signUpButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(signUpButtonPanelLayout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(goToSignUpPanelButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(279, Short.MAX_VALUE))
        );
        //endregion

        // Panel for the username and password entries:
        usernamePasswordPanel.setBackground(new Color(255, 245, 240));

        // Username text field settings:
        usernameField.setBackground(new Color(255, 245, 240));
        usernameField.setFont(new Font("Sana", Font.PLAIN, 14));
        usernameField.setForeground(new Color(153, 153, 153));
        usernameField.setText("USERNAME");
        usernameField.setBorder(null);
        usernameField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                usernameFieldFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                usernameFieldFocusLost(evt);
            }
        });

        // Password text field settings:
        passwordField.setBackground(new Color(255, 245, 240));
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 13));
        passwordField.setForeground(new Color(153, 153, 153));
        passwordField.setText("PASSWORD");
        passwordField.setBorder(null);
        passwordField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });

        // Login button settings:
        loginButton.setBackground(new Color(255, 245, 240));
        loginButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        loginButton.setForeground(new Color(102, 102, 102));
        loginButton.setText("Log In");
        loginButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        loginButton.addActionListener(evt -> loginButtonActionPerformed(evt));

        // ForgotPassword button settings:
        forgotPasswordButton.setBackground(new Color(255, 245, 240));
        forgotPasswordButton.setFont(new Font("SansSerif", Font.BOLD, 13));
        forgotPasswordButton.setForeground(new Color(255, 150, 102));
        forgotPasswordButton.setText("Forgot Username or Password? ");
        forgotPasswordButton.setBorder(null);
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.addActionListener(evt -> forgotPasswordButtonActionPerformed(evt));

        // Setting some icons for on the panel:
        sortvisPictureLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/My_Post-14.png"));
        usernamePictureLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/account-3.png"));
        passwordPictureLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock.png"));

        //region The exact position of the elements on the usernamePasswordPanel (IDE generated Code)
        GroupLayout usernamePasswordPanelLayout = new GroupLayout(usernamePasswordPanel);
        usernamePasswordPanel.setLayout(usernamePasswordPanelLayout);
        usernamePasswordPanelLayout.setHorizontalGroup(
                usernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(usernamePasswordPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(forgotPasswordButton, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, usernamePasswordPanelLayout.createSequentialGroup()
                                .addContainerGap(51, Short.MAX_VALUE)
                                .addGroup(usernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, usernamePasswordPanelLayout.createSequentialGroup()
                                                .addGroup(usernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(usernamePictureLabel)
                                                        .addComponent(passwordPictureLabel))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(usernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(separatorUsername, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(usernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(separatorPassword, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(46, 46, 46))
                                        .addGroup(GroupLayout.Alignment.TRAILING, usernamePasswordPanelLayout.createSequentialGroup()
                                                .addComponent(sortvisPictureLabel)
                                                .addGap(65, 65, 65))))
        );
        usernamePasswordPanelLayout.setVerticalGroup(
                usernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, usernamePasswordPanelLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(sortvisPictureLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(usernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(usernamePasswordPanelLayout.createSequentialGroup()
                                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(separatorUsername, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(usernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordPictureLabel))
                                                .addGap(0, 0, 0)
                                                .addComponent(separatorPassword, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                                .addGap(65, 65, 65)
                                                .addComponent(forgotPasswordButton, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(usernamePictureLabel))
                                .addGap(28, 28, 28))
        );
        //endregion

        //region The exact position of the elements on the loginPanel (IDE generated Code)
        GroupLayout loginPanelLayout = new GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(signUpButtonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(usernamePasswordPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(signUpButtonPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usernamePasswordPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        //endregion

        // Adding login panel to the backPanel:
        backPanel.add(loginPanel, "card2");

        backToLoginPanel.setBackground(new Color(255, 150, 102));

        // backToLoginFromSU button settings:
        backToLoginFromSUButton.setBackground(new Color(255, 150, 102));
        backToLoginFromSUButton.setFont(new Font("SansSerif", Font.PLAIN, 24));
        backToLoginFromSUButton.setForeground(new Color(102, 102, 102));
        backToLoginFromSUButton.setText("Back To Log In");
        backToLoginFromSUButton.setAlignmentY(0.0F);
        backToLoginFromSUButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        backToLoginFromSUButton.setFocusable(false);
        backToLoginFromSUButton.setHorizontalTextPosition(SwingConstants.CENTER);
        backToLoginFromSUButton.addActionListener(evt -> backToLoginFromSUButtonActionPerformed(evt));

        //region The exact position of the elements on the backToLoginPanel (IDE generated Code)
        GroupLayout backToLoginPanelLayout = new GroupLayout(backToLoginPanel);
        backToLoginPanel.setLayout(backToLoginPanelLayout);
        backToLoginPanelLayout.setHorizontalGroup(
                backToLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, backToLoginPanelLayout.createSequentialGroup()
                                .addContainerGap(52, Short.MAX_VALUE)
                                .addComponent(backToLoginFromSUButton, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
        );
        backToLoginPanelLayout.setVerticalGroup(
                backToLoginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(backToLoginPanelLayout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(backToLoginFromSUButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //endregion

        newUsernamePasswordPanel.setBackground(new Color(255, 245, 240));

        // createEmail text field settings:
        createEmailField.setBackground(new Color(255, 245, 240));
        createEmailField.setFont(new Font("Sana", Font.PLAIN, 14));
        createEmailField.setForeground(new Color(153, 153, 153));
        createEmailField.setText("NEW EMAIL ADDRESS");
        createEmailField.setBorder(null);
        createEmailField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                createEmailFieldFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                createEmailFieldFocusLost(evt);
            }
        });

        // createPassword text field settings:
        createPasswordField.setBackground(new Color(255, 245, 240));
        createPasswordField.setFont(new Font("SansSerif", Font.PLAIN, 13));
        createPasswordField.setForeground(new Color(153, 153, 153));
        createPasswordField.setText("NEW PASSWORD");
        createPasswordField.setBorder(null);
        createPasswordField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                createPasswordFieldFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                createPasswordFieldFocusLost(evt);
            }
        });

        // signUp button settings:
        signUpButton.setBackground(new Color(255, 245, 240));
        signUpButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        signUpButton.setForeground(new Color(102, 102, 102));
        signUpButton.setText("Sign Up");
        signUpButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        signUpButton.addActionListener(evt -> signUpButtonActionPerformed(evt));

        // createUsername text field settings:
        createUsernameField.setBackground(new Color(255, 245, 240));
        createUsernameField.setFont(new Font("Sana", Font.PLAIN, 14));
        createUsernameField.setForeground(new Color(153, 153, 153));
        createUsernameField.setText("NEW USERNAME");
        createUsernameField.setBorder(null);
        createUsernameField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                createUsernameFieldFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                createUsernameFieldFocusLost(evt);
            }
        });

        // Setting some icons close to the text fields:
        accountIconLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/account-3.png"));
        lockIconLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/lock.png"));
        emailIconLabel.setIcon(new ImageIcon("src/CulminatingTask/Images/email.png"));

        //region The exact position of the elements on the newUsernamePasswordPanel (IDE generated Code)
        GroupLayout newUsernamePasswordPanelLayout = new GroupLayout(newUsernamePasswordPanel);
        newUsernamePasswordPanel.setLayout(newUsernamePasswordPanelLayout);
        newUsernamePasswordPanelLayout.setHorizontalGroup(
                newUsernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(newUsernamePasswordPanelLayout.createSequentialGroup()
                                .addContainerGap(317, Short.MAX_VALUE)
                                .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                        .addGroup(newUsernamePasswordPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(newUsernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(accountIconLabel)
                                        .addComponent(lockIconLabel)
                                        .addComponent(emailIconLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(newUsernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(newSeparatorPassword, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newSeparatorUsername, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(createPasswordField, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(createEmailField, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(createUsernameField, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newSeparatorPassword1, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        newUsernamePasswordPanelLayout.setVerticalGroup(
                newUsernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, newUsernamePasswordPanelLayout.createSequentialGroup()
                                .addContainerGap(207, Short.MAX_VALUE)
                                .addGroup(newUsernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(newUsernamePasswordPanelLayout.createSequentialGroup()
                                                .addComponent(createUsernameField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(newSeparatorUsername, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(accountIconLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(newUsernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lockIconLabel)
                                        .addComponent(createPasswordField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(newSeparatorPassword, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(newUsernamePasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(createEmailField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailIconLabel))
                                .addGap(0, 0, 0)
                                .addComponent(newSeparatorPassword1, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164))
        );
        // endregion

        //region The exact position of the elements on the signUpPanel (IDE generated Code)
        GroupLayout signUpPanelLayout = new GroupLayout(signUpPanel);
        signUpPanel.setLayout(signUpPanelLayout);
        signUpPanelLayout.setHorizontalGroup(
                signUpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, signUpPanelLayout.createSequentialGroup()
                                .addComponent(newUsernamePasswordPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(backToLoginPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        signUpPanelLayout.setVerticalGroup(
                signUpPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(backToLoginPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newUsernamePasswordPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        // endregion

        // Adding login panel to the backPanel:
        backPanel.add(signUpPanel, "card3");

        backToLoginFromForgotPanel.setBackground(new Color(255, 150, 102));

        // backToLoginFromFP button settings:
        backToLoginButtonFromFP.setBackground(new Color(255, 150, 102));
        backToLoginButtonFromFP.setFont(new Font("SansSerif", Font.PLAIN, 24));
        backToLoginButtonFromFP.setForeground(new Color(102, 102, 102));
        backToLoginButtonFromFP.setText("Back To Log In");
        backToLoginButtonFromFP.setAlignmentY(0.0F);
        backToLoginButtonFromFP.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        backToLoginButtonFromFP.setFocusable(false);
        backToLoginButtonFromFP.setHorizontalTextPosition(SwingConstants.CENTER);
        backToLoginButtonFromFP.addActionListener(evt -> backToLoginButtonFromFPActionPerformed(evt));

        //region The exact position of the elements on the backToLoginFromForgotPanel (IDE generated Code)
        GroupLayout backToLoginFromForgotPanelLayout = new GroupLayout(backToLoginFromForgotPanel);
        backToLoginFromForgotPanel.setLayout(backToLoginFromForgotPanelLayout);
        backToLoginFromForgotPanelLayout.setHorizontalGroup(
                backToLoginFromForgotPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(backToLoginFromForgotPanelLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(backToLoginButtonFromFP, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(55, Short.MAX_VALUE))
        );
        backToLoginFromForgotPanelLayout.setVerticalGroup(
                backToLoginFromForgotPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(backToLoginFromForgotPanelLayout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(backToLoginButtonFromFP, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(280, Short.MAX_VALUE))
        );
        // endregion

        newUsernamePasswordPanel1.setBackground(new Color(255, 245, 240));

        // emailAddress text field settings:
        emailAddressField.setBackground(new Color(255, 245, 240));
        emailAddressField.setFont(new Font("Sana", Font.PLAIN, 14));
        emailAddressField.setForeground(new Color(153, 153, 153));
        emailAddressField.setText("EMAIL ADDRESS");
        emailAddressField.setBorder(null);
        emailAddressField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                emailAddressFieldFocusGained(evt);
            }
            public void focusLost(FocusEvent evt) {
                emailAddressFieldFocusLost(evt);
            }
        });

        // recoverAccount button settings:
        recoverAccountButton.setBackground(new Color(255, 245, 240));
        recoverAccountButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        recoverAccountButton.setForeground(new Color(102, 102, 102));
        recoverAccountButton.setText("Recover Your Account");
        recoverAccountButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        recoverAccountButton.addActionListener(evt -> recoverAccountButtonActionPerformed(evt));

        emailPicture2Label.setIcon(new ImageIcon("src/CulminatingTask/Images/email.png"));

        //region The exact position of the elements on the newUsernamePasswordPanel1 (IDE generated Code)
        GroupLayout newUsernamePasswordPanel1Layout = new GroupLayout(newUsernamePasswordPanel1);
        newUsernamePasswordPanel1.setLayout(newUsernamePasswordPanel1Layout);
        newUsernamePasswordPanel1Layout.setHorizontalGroup(
                newUsernamePasswordPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(newUsernamePasswordPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(emailPicture2Label)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(newUsernamePasswordPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(emailAddressField, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newSeparatorPassword3, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(96, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, newUsernamePasswordPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(recoverAccountButton, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
        );
        newUsernamePasswordPanel1Layout.setVerticalGroup(
                newUsernamePasswordPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, newUsernamePasswordPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(newUsernamePasswordPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(newUsernamePasswordPanel1Layout.createSequentialGroup()
                                                .addComponent(emailAddressField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(newSeparatorPassword3, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(emailPicture2Label))
                                .addGap(54, 54, 54)
                                .addComponent(recoverAccountButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164))
        );
        // endregion

        //region The exact position of the elements on the forgotPasswordPanel (IDE generated Code)
        GroupLayout forgotPasswordPanelLayout = new GroupLayout(forgotPasswordPanel);
        forgotPasswordPanel.setLayout(forgotPasswordPanelLayout);
        forgotPasswordPanelLayout.setHorizontalGroup(
                forgotPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, forgotPasswordPanelLayout.createSequentialGroup()
                                .addComponent(newUsernamePasswordPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(backToLoginFromForgotPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        forgotPasswordPanelLayout.setVerticalGroup(
                forgotPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(backToLoginFromForgotPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(newUsernamePasswordPanel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        // endregion

        // Adding login panel to the backPanel:
        backPanel.add(forgotPasswordPanel, "card4");

        getContentPane().add(backPanel, BorderLayout.CENTER);
        pack();
    }

    /**
     * If the user pushed {@link #forgotPasswordButton}, the method resets the text fields and
     * goes to {@link #forgotPasswordPanel}.
     * @version 1.2
     */
    private void forgotPasswordButtonActionPerformed(ActionEvent evt) {
        passwordField.setText("PASSWORD"); // TO clear the field
        usernameField.setText("USERNAME"); // TO clear the field
        goToPanel(forgotPasswordPanel);
    }

    /**
     * If the user pushed {@link #goToSignUpPanelButton}, the method resets the text fields and
     * goes to {@link #signUpPanel}.
     * @version 1.2
     */
    private void goToSignUpPanelButtonActionPerformed(ActionEvent evt) {
        passwordField.setText("PASSWORD"); // TO clear the field
        usernameField.setText("USERNAME"); // TO clear the field
        goToPanel(signUpPanel);
    }

    /**
     * If the user pushed {@link #backToLoginFromSUButton}, the method resets the text fields and
     * goes to {@link #loginPanel}.
     * @version 1.2
     */
    private void backToLoginFromSUButtonActionPerformed(ActionEvent evt) {
        createUsernameField.setText("NEW USERNAME"); // TO clear the field
        createPasswordField.setText("NEW PASSWORD"); // TO clear the field
        createEmailField.setText("NEW EMAIL ADDRESS"); // TO clear the field
        goToPanel(loginPanel);
    }

    /**
     * If the user pushed {@link #backToLoginButtonFromFP}, the method resets the text fields and
     * goes to {@link #loginPanel}.
     * @version 1.2
     */
    private void backToLoginButtonFromFPActionPerformed(ActionEvent evt) {
        emailAddressField.setText("EMAIL ADDRESS"); // TO clear the field
        goToPanel(loginPanel);
    }

    /**
     * Clears the {@link #backPanel} and add the new panel on the backPanel.
     * @version 1.1
     */
    private void goToPanel(JPanel panel) {
        // Clear the panel:
        backPanel.removeAll();
        // Add the new panel:
        backPanel.add(panel);
        backPanel.repaint();
        backPanel.revalidate();
    }

    /**
     * Checks if the cruiser is enabled on {@link #usernameField}. If so, it deletes the default text.
     */
    private void usernameFieldFocusGained(FocusEvent evt) {
        if (usernameField.getText().equals("USERNAME"))
            usernameField.setText("");
    }

    /**
     * If the user lefts {@link #usernameField} blank, the default text fills the text field again.
     */
    private void usernameFieldFocusLost(FocusEvent evt) {
        if (usernameField.getText().equals(""))
            usernameField.setText("USERNAME");
    }

    /**
     * Checks if the cruiser is enabled on {@link #passwordField}. If so, it deletes the default text.
     */
    private void passwordFieldFocusGained(FocusEvent evt) {
        if (passwordField.getText().equals("PASSWORD"))
            passwordField.setText("");
    }

    /**
     * If the user lefts {@link #passwordField} blank, the default text fills the text field again.
     */
    private void passwordFieldFocusLost(FocusEvent evt) {
        if (passwordField.getText().equals(""))
            passwordField.setText("PASSWORD");
    }

    /**
     * Checks if the cruiser is enabled on {@link #createUsernameField}. If so, it deletes the default text.
     */
    private void createUsernameFieldFocusGained(FocusEvent evt) {
        if (createUsernameField.getText().equals("NEW USERNAME"))
            createUsernameField.setText("");
    }

    /**
     * If the user lefts {@link #createUsernameField} blank, the default text fills the text field again.
     */
    private void createUsernameFieldFocusLost(FocusEvent evt) {
        if (createUsernameField.getText().equals(""))
            createUsernameField.setText("NEW USERNAME");
    }

    /**
     * Checks if the cruiser is enabled on {@link #createPasswordField}. If so, it deletes the default text.
     */
    private void createPasswordFieldFocusGained(FocusEvent evt) {
        if (createPasswordField.getText().equals("NEW PASSWORD"))
            createPasswordField.setText("");
    }

    /**
     * If the user lefts {@link #createPasswordField} blank, the default text fills the text field again.
     */
    private void createPasswordFieldFocusLost(FocusEvent evt) {
        if (createPasswordField.getText().equals(""))
            createPasswordField.setText("NEW PASSWORD");
    }

    /**
     * Checks if the cruiser is enabled on {@link #createEmailField}. If so, it deletes the default text.
     */
    private void createEmailFieldFocusGained(FocusEvent evt) {
        if (createEmailField.getText().equals("NEW EMAIL ADDRESS"))
            createEmailField.setText("");
    }

    /**
     * If the user lefts {@link #createEmailField} blank, the default text fills the text field again.
     */
    private void createEmailFieldFocusLost(FocusEvent evt) {
        if (createEmailField.getText().equals(""))
            createEmailField.setText("NEW EMAIL ADDRESS");
    }

    /**
     * Checks if the cruiser is enabled on {@link #emailAddressField}. If so, it deletes the default text.
     */
    private void emailAddressFieldFocusGained(FocusEvent evt) {
        if (emailAddressField.getText().equals("EMAIL ADDRESS"))
            emailAddressField.setText("");
    }

    /**
     * If the user lefts {@link #emailAddressField} blank, the default text fills the text field again.
     */
    private void emailAddressFieldFocusLost(FocusEvent evt) {
        if (emailAddressField.getText().equals(""))
            emailAddressField.setText("EMAIL ADDRESS");
    }

    /**
     * <p>Logins to the application if the user's account exists within the database (csv file in this case).
     * By clicking the {@link #loginButton}, a new {@link Application} frame would be created. If the user doesn't exists in the
     * csv file, the application throws an error message and asks the user to entre valid username and
     * password.</p>
     * <p>In order to find the user from the csv file, the method goes throw every account created and retrieves user's information.
     * Then, it saves the information using the {@link User} class to further utilize the user's info.</p>
     * @see Application
     * @see User
     * @see Menu
     * @version 1.4
     */
    private void loginButtonActionPerformed(ActionEvent evt) {

        // Check if the user actually entered a username or password:
        if (usernameField.getText().equals("USERNAME") || passwordField.getText().equals("PASSWORD"))
            // Throw a warning if no username or password was entered:
            JOptionPane.showMessageDialog(null, "Enter a Valid Username and Password"
                    , "Wrong Username or Password", JOptionPane.ERROR_MESSAGE);

        // If the user entered username and password, check if they're valid:
        else {
            boolean usernameStatus = false; // To verify the user
            try {
                String[] userInfo = new String[4]; // To save user's info
                scanner = new Scanner(userInfoFile); // The file to be scanned
                // While there is an account in the file, retrieve it's info:
                while (scanner.hasNextLine()) {
                    // Get the information of the user:
                    userInfo = scanner.nextLine().split(",");
                    String username = userInfo[0]; // Get the username

                    // If the user exists, set the usernameStatus to true:
                    if (usernameField.getText().equalsIgnoreCase(username) &&
                            passwordField.getText().equals(userInfo[1])) {
                        usernameStatus = true;
                        break; //(optimised)
                    }
                }

                // If the user doesn't exist, show an error message:
                if (!usernameStatus) {
                    JOptionPane.showMessageDialog(null,
                            "<HTML>The Username and Password you entered was not correct!<br>" +
                                    "If you don't have an account signup FOR FREE :)"
                            , "Wrong Username or Password", JOptionPane.ERROR_MESSAGE);
                }

                // If the user exists, go to the create a new Application frame:
                else {
                    //region The look and feel of the Application frame.
                    try {
                        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                            if ("Metal".equals(info.getName())) {
                                UIManager.setLookAndFeel(info.getClassName());
                                break;
                            }
                        }
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                    //endregion

                    // Save user's info using a newly created user instance:
                    user = new User(userInfo[0], userInfo[2], Integer.parseInt(userInfo[3]));

                    // Create and display the Application frame:
                    application = new Application();
                    EventQueue.invokeLater(() -> application.setVisible(true));

                    // Dispose the login frame as it is no longer needed:
                    dispose();
                }

            } catch (FileNotFoundException e) { // handle the errors with the file
                JOptionPane.showMessageDialog(null, "<HTML>The Application is hacked!<br>Contact the Developer ASAP!"
                        , "The Application is hacked!", JOptionPane.ERROR_MESSAGE);

                // Exist the program and show the error on the console:
                System.out.println("Something's Wrong with the File");
                e.printStackTrace();
                System.exit(0);
            }
        }
    }

    /**
     * <p>Created a new account for the user using their email address. If the username already exists,
     * the user will be prompted to entre another username. Also, empty fields and invalid email address
     * will prompt an error message to the user.</p>
     * <p>If the user clicks the {@link #signUpButton}, the user info will be added to the end of the csv file
     * holding the accounts info with a default score of 0.</p>
     * @version 1.3
     */
    private void signUpButtonActionPerformed(ActionEvent evt) {

        try {
            boolean isUserAlreadyExist = false; // To check is the username already exists
            scanner = new Scanner(userInfoFile);// The file to be scanned
            // While there is an account in the file, retrieve it's info:
            while (scanner.hasNextLine()) {
                // Get the information of the user:
                String[] userInfo = scanner.nextLine().split(",");
                String username = userInfo[0]; // Get the username

                // If the user exists, set the usernameStatus to true:
                if (createUsernameField.getText().equalsIgnoreCase(username)) {
                    isUserAlreadyExist = true;
                    break; //(Optimized)
                }
            }

            // If the user doesn't exist, show an error message:
            if (isUserAlreadyExist) {
                JOptionPane.showMessageDialog(null,
                        "The Username Already Exists"
                        , "Wrong Username", JOptionPane.ERROR_MESSAGE);
                return; // Return signUpButtonActionPerformed method
            }

        } catch (FileNotFoundException e) { // handle the errors with the file
            JOptionPane.showMessageDialog(null, "<HTML>The Application is hacked!<br>Contact the Developer ASAP!"
                    , "The Application is hacked!", JOptionPane.ERROR_MESSAGE);

            // Exist the program and show the error on the console:
            System.out.println("Something's Wrong with the File");
            e.printStackTrace();
            System.exit(0);
        }

        // Check if the user actually entered a username, password or email:
        if (createUsernameField.getText().equals("NEW USERNAME")
                || createPasswordField.getText().equals("NEW PASSWORD")
                || createEmailField.getText().equals("NEW EMAIL ADDRESS"))

            // Throw a warning if no username, password or email was entered:
            JOptionPane.showMessageDialog(null, "Enter valid information!"
                    , "Wrong Information", JOptionPane.ERROR_MESSAGE);

        // Check if the user utilized space in username, password or email. If so, throw an invalid information error.
        else if (createUsernameField.getText().contains(" ")
                || createPasswordField.getText().contains(" ")
                || createEmailField.getText().contains(" "))
            // Throw a warning if the fields contain "space":
            JOptionPane.showMessageDialog(null, "Enter valid information!"
                    , "Wrong Information", JOptionPane.ERROR_MESSAGE);

        else if (!createEmailField.getText().contains("@"))
            // Throw a warning if the email field doesn't have "@" sign:
            JOptionPane.showMessageDialog(null, "Enter a valid email address!"
                    , "Wrong Email Address", JOptionPane.ERROR_MESSAGE);

        // If the new username, password and email address are ok, add the new user to the csv file:
        else {
            try {
                FileWriter csvWriter = new FileWriter("src/CulminatingTask/UserInfo.csv", true);
                csvWriter.append(createUsernameField.getText());
                csvWriter.append(",");
                csvWriter.append(createPasswordField.getText());
                csvWriter.append(",");
                csvWriter.append(createEmailField.getText());
                csvWriter.append(",");
                csvWriter.append("0");
                csvWriter.append("\n");
                csvWriter.flush();
                csvWriter.close();

                // Show the user that their account is successfully created:
                JOptionPane.showMessageDialog(null, "Your account is Successfully created!"
                        , "Account Created", JOptionPane.INFORMATION_MESSAGE);

                /* Go to the login panel */
                createUsernameField.setText("NEW USERNAME"); // TO clear the field
                createPasswordField.setText("NEW PASSWORD"); // TO clear the field
                createEmailField.setText("NEW EMAIL ADDRESS"); // TO clear the field
                goToPanel(loginPanel);

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

    /**
     * <p>Shows the user's account's username and password if the user provides the corresponding
     * correct email address registered on the application.</p>
     * <p>The user can entre a valid email address and the application will go through the accounts info and
     * find the email address. Then the username and password of that email address will be shown to the user.
     * Of course, all of this will happen if the user pushes {@link #recoverAccountButton}.</p>
     * @version 1.3
     */
    private void recoverAccountButtonActionPerformed(ActionEvent evt) {

        if (!emailAddressField.getText().contains("@")) {
            // Throw a warning if the email field doesn't have "@" sign:
            JOptionPane.showMessageDialog(null, "Enter a valid email address!"
                    , "Wrong Email Address", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            boolean isUserAlreadyExist = false; // If the user exists in the csv file
            scanner = new Scanner(userInfoFile);// The file to be scanned
            String[] userInfo = new String[3];
            // While there is an account in the file, retrieve it's info:
            while (scanner.hasNextLine()) {
                // Get the information of the user:
                userInfo = scanner.nextLine().split(",");
                String emailAddress = userInfo[2]; // Get the username

                // If the user exists, set the usernameStatus to true:
                if (emailAddressField.getText().equalsIgnoreCase(emailAddress)) {
                    isUserAlreadyExist = true;
                    break;
                }
            }

            // If the user doesn't exist, show an error message:
            if (isUserAlreadyExist) {
                JOptionPane.showMessageDialog(null,
                        "<HTML>Since this is the most secure application in all around the world,<br>" +
                                "<HTML>Here is the Username and Password for the provided Email Address:<br><br>" +
                                "USERNAME: " + userInfo[0] + "<HTML><br>PASSWORD: " + userInfo[1]
                        , "UserInfo", JOptionPane.INFORMATION_MESSAGE);

                /* Go to the login panel */
                emailAddressField.setText("NEW USERNAME"); // TO clear the field
                goToPanel(loginPanel);
                return;
            }
            // If there is no username associated with the provided email address, show an error to the user:
            JOptionPane.showMessageDialog(null,
                    "A user with the provided email address doesn't exist!"
                    , "UserInfo", JOptionPane.ERROR_MESSAGE);

        } catch (FileNotFoundException e) { // handle the errors with the file
            JOptionPane.showMessageDialog(null, "<HTML>The Application is hacked!<br>Contact the Developer ASAP!"
                    , "The Application is hacked!", JOptionPane.ERROR_MESSAGE);

            // Exist the program and show the error on the console:
            System.exit(0);
            System.out.println("Something's Wrong with the File");
            e.printStackTrace();
        }
    }
}