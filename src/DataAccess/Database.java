package DataAccess;

import BusinessLogic.Answer;
import BusinessLogic.AnswerFactory;
import BusinessLogic.AnswerType;
import BusinessLogic.Quizitem;

import java.util.ArrayList;
import java.util.List;

public class Database
    {

    private static Database _instance;
    private List<Quizitem> _quizItems;
    private int _totalPoints;
    private int _rounds;

    private Database()
        {
        _rounds = 0;
        _totalPoints = 0;
        _quizItems = new ArrayList<>();
        initializeQuizitems();
        }

    public static Database getInstance()
        {
        if (_instance == null)
            {
            _instance = new Database();
            }
        return _instance;
        }

    private List<Quizitem> initializeQuizitems()
        {


        Answer firstCorrect = AnswerFactory.createAnswer(AnswerType.CORRECTANSWER, "Mond");
        Answer[] firstWrong = {AnswerFactory.createAnswer(AnswerType.WRONGANSWER, "Sputnik"),
                AnswerFactory.createAnswer(AnswerType.WRONGANSWER, "Venus"),
                AnswerFactory.createAnswer(AnswerType.WRONGANSWER, "Sonne")};
        Quizitem firstQuestion = new Quizitem("Wie heißt der natürliche Satellit der Erde?", firstCorrect, firstWrong);
        _quizItems.add(firstQuestion);

        Answer secondCorrect = AnswerFactory.createAnswer(AnswerType.CORRECTANSWER, "Madrid");
        Answer[] secondWrong = {AnswerFactory.createAnswer(AnswerType.WRONGANSWER, "Barcelona"),
                AnswerFactory.createAnswer(AnswerType.WRONGANSWER, "Palma"),
                AnswerFactory.createAnswer(AnswerType.WRONGANSWER, "Rom")};
        Quizitem secondQuestion = new Quizitem("Was ist die Hauptstadt Spaniens?", secondCorrect, secondWrong);
        _quizItems.add(secondQuestion);

        Answer thirdCorrect = AnswerFactory.createAnswer(AnswerType.CORRECTANSWER, "26");
        Answer[] thirdWrong = {AnswerFactory.createAnswer(AnswerType.WRONGANSWER, "33"),
                AnswerFactory.createAnswer(AnswerType.WRONGANSWER, "14"),
                AnswerFactory.createAnswer(AnswerType.WRONGANSWER, "30")};
        Quizitem thirdQuestion = new Quizitem("Wie viele Buchstaben hat das englische Alphabet?", thirdCorrect, thirdWrong);
        _quizItems.add(thirdQuestion);

        Answer fourthCorrect = AnswerFactory.createAnswer(AnswerType.CORRECTANSWER, "Computergestützte Vertriebsinformationssysteme");
        Answer[] fourthWrong = {AnswerFactory.createAnswer(AnswerType.WRONGANSWER, "Champions of very intelligent software"),
                AnswerFactory.createAnswer(AnswerType.WRONGANSWER, "Chaos in der virtuellen Sandkiste"),
                AnswerFactory.createAnswer(AnswerType.WRONGANSWER, "Chronische Obsession für verrückte Internetvideos")};
        Quizitem fourthQuestion = new Quizitem("Was heißt die Abkürzung Covis?", fourthCorrect, fourthWrong);
        _quizItems.add(fourthQuestion);

        return _quizItems;
        }

    public List<Quizitem> getAllQuizitems()
        {
        return _quizItems;
        }

    public int getTotalPoints()
        {
        return _totalPoints;
        }

    public void addPoints(int points)
        {
        Database.getInstance()._totalPoints += points;
        }

    public int getRounds()
        {
        return _rounds;
        }

    public void increaseRounds()
        {
        Database.getInstance()._rounds++;
        }


    }
