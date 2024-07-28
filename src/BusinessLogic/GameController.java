package BusinessLogic;

import DataAccess.FileQuizRepository;
import DataAccess.IQuizItemRepository;


import java.io.IOException;
import java.util.List;

/**
 * The GameController class manages the game logic, including starting rounds,
 * checking answers, and keeping track of points and rounds.
 */
public class GameController
{

    private IQuizItemRepository _repository;
    private int _totalPoints;
    private int _rounds;

    private List<Quizitem> _quizitems;

    public GameController()
    {
        _totalPoints = 0;
        _repository = new FileQuizRepository();
    }

    /**
     * Starts a new round by increasing the round count and fetching quiz items from the repository.
     *
     * @throws IOException if an I/O error occurs while fetching quiz items
     */
    public void startRound() throws IOException
    {
        increaseRounds();
        _quizitems = getRepository().findAll();
    }

    /**
     * Gets the list of quiz items for the current round.
     *
     * @return list of quiz items
     */
    public List<Quizitem> getQuizitems()
    {
        return _quizitems;
    }

    /**
     * Checks if the user's selected answer for a quiz item is correct.
     *
     * @param userSelection the user's selected answer index
     * @param quizitem      the quiz item being answered
     * @return true if the selected answer is correct, false otherwise
     * @throws Exception if an error occurs while checking the answer
     */
    public boolean checkAnswer(int userSelection, Quizitem quizitem) throws Exception
    {
        return quizitem.checkUserAnswer(userSelection);
    }

    /**
     * Calculates the percentage of correct answers across all rounds.
     *
     * @return the percentage of correct answers
     */
    public float getPercentage()
    {
        if (getRounds() != 0)
        {
            int maxPossiblePoints = _quizitems.size() * getRounds();
            return ((float) getTotalPoints() / maxPossiblePoints) * 100;
        }
        return 0;
    }

    /**
     * Gets the quiz item repository.
     *
     * @return the quiz item repository
     */
    public IQuizItemRepository getRepository()
    {
        return _repository;
    }

    /**
     * Gets the total points scored by the player.
     *
     * @return the total points
     */
    public int getTotalPoints()
    {
        return _totalPoints;
    }

    /**
     * Adds points to the total score.
     *
     * @param points the points to add
     */
    public void addPoints(int points)
    {
        _totalPoints += points;
    }

    /**
     * Gets the number of rounds played.
     *
     * @return the number of rounds
     */
    public int getRounds()
    {
        return _rounds;
    }

    /**
     * Increases the number of rounds played by one.
     */
    public void increaseRounds()
    {
        _rounds++;
    }
}
