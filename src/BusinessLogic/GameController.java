package BusinessLogic;

import DataAccess.FileQuizRepository;
import DataAccess.IQuizItemRepository;


import java.util.List;

public class GameController
{

    private IQuizItemRepository _repository;
    private int _totalPoints;
    private int _rounds;

    private List<Quizitem> _quizitems;

    public GameController()
    {
        _totalPoints = 0;
        _repository = new FileQuizRepository();    }

    public void startRound()
    {
        increaseRounds();
        _quizitems = getRepository().findAll();
    }

    public List<Quizitem> getQuizitems()
    {
        return _quizitems;
    }

    public boolean checkAnswer(int userSelection, Quizitem quizitem) throws Exception
    {
        return quizitem.checkUserAnswer(userSelection);
    }

    public float getPercentage()
    {
        if (getRounds() != 0)
        {
            int maxPossiblePoints = _quizitems.size() * getRounds();
            return ((float) getTotalPoints() / maxPossiblePoints) * 100;
        }
        return 0;
    }

    public IQuizItemRepository getRepository()
    {
        return _repository;
    }

    public int getTotalPoints()
    {
        return _totalPoints;
    }

    public void addPoints(int points)
    {
        _totalPoints += points;
    }

    public int getRounds()
    {
        return _rounds;
    }

    public void increaseRounds()
    {
        _rounds++;
    }
}
