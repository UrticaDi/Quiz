package Presentation;

import BusinessLogic.GameController;
import BusinessLogic.Quizitem;

import java.io.IOException;
import java.util.Scanner;

/**
 * The QuizView class handles the presentation and interaction of the quiz game with the user.
 * It communicates with the GameController to manage game logic, including starting new rounds,
 * playing the game, handling user inputs, and displaying results.
 */

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

    /**
     * Starts a new round of the quiz game. Resets the points and informs the user of the current round.
     *
     * @throws IOException if there is an issue starting a new round
     */
    public void startNewRound() throws IOException
    {
        _gameController.startRound();
        System.out.println("------------------------------------------");
        System.out.println();
        System.out.println("Runde " + _gameController.getRounds());
        _points = 0;
    }

    /**
     * Plays the quiz game by iterating through each quiz item and processing user answers.
     */
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

    /**
     * Handles user input to choose an answer for a given quiz item.
     * Continues to prompt the user until valid input is provided.
     *
     * @param quizitem The quiz item to answer
     * @return boolean indicating whether the user's answer was correct
     */
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

    /**
     * Ends the current round, adds the points scored to the total, and displays the points scored in the round.
     */
    public void endRound()
    {
        _gameController.addPoints(_points);
        System.out.println("Du hast " + _points + " Punkte.");
    }

    /**
     * Displays the total points scored across all rounds.
     */
    public void showTotalPoints()
    {
        System.out.println("Deine Gesamtpunktzahl ist: " + _gameController.getTotalPoints());
    }

    /**
     * Displays the percentage of questions answered correctly.
     */
    public void showAveragePoints()
    {
        System.out.println("Du hast bisher " + _gameController.getPercentage() + " % der Fragen richtig beantwortet");
    }

}
