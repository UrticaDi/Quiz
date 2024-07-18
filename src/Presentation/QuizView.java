package Presentation;

import BusinessLogic.GameController;
import BusinessLogic.Quizitem;

import java.util.Scanner;

public class QuizView
    {

    private GameController _gameController;
    private int _points;
    private Scanner _scanner;


    public QuizView(Scanner scanner)
        {
        _gameController = new GameController();
        this._scanner = scanner;
        }

    public void startNewRound()
        {
        _gameController.startRound();
        System.out.println("------------------------------------------");
        System.out.println();
        System.out.println("Runde " + _gameController.getRoundCounter());
        _points = 0;
        }

    // Method to play the game
    public void playGame()
        {
        for (Quizitem item : _gameController.getQuizitems())
            {
            System.out.println("------------------------------------------");
            System.out.println(item.toString());
            boolean answerIsCorrect = chooseAnswer(item);
            if (answerIsCorrect)
                {
                System.out.println("Das ist korrekt!");
                _points++;
                } else
                {
                System.out.println("Das war leider falsch. Die richtige Antwort ist " + item.getCorrectAnswerText());
                }
            }
        }

    private boolean chooseAnswer(Quizitem quizitem)
        {
        boolean answerIsCorrect = false;
        boolean inputIsInvalid;

        do
            {
            try
                {
                int userSelection = _scanner.nextInt();
                answerIsCorrect = _gameController.checkAnswer(userSelection, quizitem);
                inputIsInvalid = false;
                } catch (Exception e)
                {
                System.out.println("Bitte machen Sie eine gültige Eingabe. " +
                        "Bitte geben Sie eine Zahl zwischen 1 und " + quizitem.getAnswersCount() + ".");
                _scanner.nextLine();
                inputIsInvalid = true;
                }

            } while (inputIsInvalid);

        return answerIsCorrect;
        }

    public void endRound()
        {
        _gameController.addPoints(_points);
        System.out.println("Du hast " + _points + " Punkte.");
        }
    }
