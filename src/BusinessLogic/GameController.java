package BusinessLogic;

import DataAccess.Database;

import java.util.List;

public class GameController
    {

    private Database _database;

    private List<Quizitem> _quizitems;

    public GameController()
        {
        this._database = Database.getInstance();
        }

    public void startRound()
        {
        _database.increaseRounds();
        _quizitems = _database.getAllQuizitems();
        }

    public int getRoundCounter()
        {
        return _database.getRounds();
        }

    public List<Quizitem> getQuizitems()
        {
        return _quizitems;
        }

    public boolean checkAnswer(int userSelection, Quizitem quizitem) throws Exception
        {
        return quizitem.checkUserAnswer(userSelection);
        }

    public int getTotalPoints()
        {
        return _database.getTotalPoints();
        }

    public void addPoints(int points)
        {
        _database.addPoints(points);
        }

    public float getPercentage()
        {
        if (_database.getRounds() != 0)
            {
            int maxPossiblePoints = _database.getAllQuizitems().size() * _database.getRounds();
            return ((float) _database.getTotalPoints() / maxPossiblePoints) * 100;
            }
        return 0;
        }
    }
