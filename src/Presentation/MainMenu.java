package Presentation;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The MainMenu class handles the main menu interactions of the quiz application.
 * It displays the menu options, captures user input, and directs the flow of the application
 * based on the user's choices.
 */
public class MainMenu
{

    // Constants for menu options
    private final int _START = 1;
    private final int _RESULTS = 2;
    private final int _EXIT = 3;

    // Scanner for user input
    private Scanner _scanner = new Scanner(System.in);
    private QuizView _quizView;

    /**
     * Constructor initializes QuizView with the scanner for user input.
     */
    public MainMenu()
    {
        _quizView = new QuizView(_scanner);
    }

    /**
     * Utility method to print a line separator for better readability in the console.
     */
    public static void lines()
    {
        System.out.println("------------------------------------------");
        System.out.println();
    }

    /**
     * Method to start the program and handle the main menu navigation.
     * It continuously shows the menu and processes user input until the user chooses to exit.
     *
     * @throws IOException if there is an issue during quiz operations
     */
    public void start() throws IOException
    {
        this.showWelcomeText();
        boolean exit = false;
        while (!exit)
        {
            this.showMenu();
            switch (this.checkInput())
            {
                // Start a new round of the quiz game
                case _START:
                    _quizView.startNewRound();
                    _quizView.playGame();
                    _quizView.endRound();
                    continue;

                    // Show total and average points
                case _RESULTS:
                    _quizView.showTotalPoints();
                    _quizView.showAveragePoints();
                    continue;

                    // Exit the application
                case _EXIT:
                    exit = true;
                    continue;

                    // Show error message for invalid input
                default:
                    this.showErrorMessage();
            }
        }
    }

    /**
     * Method to display a welcome message to the user.
     */
    public void showWelcomeText()
    {
        lines();
        System.out.println("\t\t\tWillkommen! Let's play!");
        lines();
    }

    /**
     * Method to display the main menu options to the user.
     */
    public void showMenu()
    {
        System.out.println("Bitte treffen Sie Ihre Auswahl: ");
        lines();
        System.out.println("(1) Spiel starten");
        System.out.println("(2) Gesamtspielstand anzeigen");
        System.out.println("(3) Spiel beenden");
        System.out.print("Ihre Auswahl: ");
        System.out.println();
    }

    /**
     * Method to check and validate user input for menu selection.
     * It continues to prompt the user until a valid input is provided.
     *
     * @return int representing the user's menu choice
     */
    public int checkInput()
    {

        int choice = 0;
        boolean exception;

        do
        {
            try
            {
                choice = _scanner.nextInt();
                exception = false;
            } catch (InputMismatchException e)
            {
                _scanner.next();
                exception = true;
                showErrorMessage();
            }
        } while (exception);
        return choice;
    }

    /**
     * Method to display an error message for invalid menu selection input.
     */
    public void showErrorMessage()
    {
        System.out.println("Bitte machen Sie eine korrekte Eingabe. Wählen Sie zwischen: \n " +
                "(1) Spiel starten\n " +
                "(2) Gesamtspielstand anzeigen \n " +
                "(3) Spiel beenden\n" +
                "Ihre Auswahl: ");
    }

}

