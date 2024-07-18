package Presentation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu
    {


    private final int _START = 1;
    private final int _RESULTS = 2;
    private final int _EXIT = 3;
    private Scanner _scanner = new Scanner(System.in);
    private QuizView _quizView;
    private TotalPointsView _totalPointsView;


    public MainMenu()
        {
        _quizView = new QuizView(_scanner);
        _totalPointsView = new TotalPointsView();
        }

    public static void lines()
        {
        System.out.println("------------------------------------------");
        System.out.println();
        }

    // Method to start the program
    public void start()
        {
        this.showWelcomeText();
        boolean exit = false;
        while (!exit)
            {
            this.showMenu();
            switch (this.checkInput())
                {
                case _START:
                    _quizView.startNewRound();
                    _quizView.playGame();
                    _quizView.endRound();
                    continue;
                case _RESULTS:
                    _totalPointsView.showTotalPoints();
                    _totalPointsView.showAveragePoints();
                    continue;
                case _EXIT:
                    exit = true;
                    continue;
                default:
                    this.showErrorMessage();
                }
            }
        }

    public void showWelcomeText()
        {
        lines();
        System.out.println("\t\t\tWillkommen! Let's play!");
        lines();
        }

    // Method to show the main menu
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

    // Method to check and validate user input for menu selection
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

    // Method to show the error message if user choiceinvalid
    public void showErrorMessage()
        {
        System.out.println("Bitte machen Sie eine korrekte Eingabe. Wählen Sie zwischen: \n " +
                "(1) Spiel starten\n " +
                "(2) Gesamtspielstand anzeigen \n " +
                "(3) Spiel beenden\n" +
                "Ihre Auswahl: ");
        }

    }

