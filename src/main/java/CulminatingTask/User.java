package CulminatingTask;

/**
 * <b><i>User Information</i></b>
 * <p>This class will hold the information of the user. The user info will be obtained from {@link Login} and
 * will be utilized by classes such as {@link LearnSorting}, {@link PlaySorting} and {@link Profile}.</p>
 * @see LearnSorting
 * @see PlaySorting
 * @see Profile
 */
public class User {

    private String username;
    private String emailAddress;
    private int score;
    private int oldScore; // To find out if the user's score has changed after the time they launched the application

    User(String username, String emailAddress, int score) {
        this.username = username;
        this.score = score;
        this.oldScore = score;
        this.emailAddress = emailAddress;
    }

    /**
     *
     * @return the score of the user so far.
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @return the username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return the email address of the user.
     */
    public String getEmailAddress() { return emailAddress; }

    /**
     * Adds the points earned from a game to the user's score.
     * @param addedScore the points gained from a game
     */
    public void addToScore(int addedScore) { score += addedScore; }

    /**
     * If user gains points while working with the application, this method returns true.
     * @return true if the user's score had changed
     */
    public boolean isScoreChanged() { return score != oldScore; }
}
