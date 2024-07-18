package Presentation;

import BusinessLogic.GameController;

public class TotalPointsView
    {

    private GameController _gameController;

    public TotalPointsView()
        {

        _gameController = new GameController();
        }

    public void showTotalPoints()
        {

        System.out.println("Deine Gesamtpunktzahl ist: " + _gameController.getTotalPoints());
        }

    public void showAveragePoints()
        {

        System.out.println("Du hast bisher " + _gameController.getPercentage() + " % der Fragen richtig beantwortet");


        }
    }
