package Presentation;

import java.io.IOException;

/**
 * The Main class serves as the entry point for the quiz application.
 * It initializes the main menu and starts the application.
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        MainMenu mainMenu = new MainMenu();
        mainMenu.start();
    }
}