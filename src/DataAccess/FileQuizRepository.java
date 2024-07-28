package DataAccess;

import BusinessLogic.Quizitem;
import BusinessLogic.AnswerFactory;
import BusinessLogic.Answer;
import jdk.jshell.spi.ExecutionControl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The FileQuizRepository class implements the IQuizItemRepository interface to provide
 * file-based storage and retrieval of quiz items. It handles reading from and writing to
 * a text file to manage quiz data.
 */
public class FileQuizRepository implements IQuizItemRepository
{
    private final String data = "Data.txt";
    private final String delimiter = ";";
    private final String correctAnswerMarker = "*";
    private File file;

    /**
     * Constructor initializes the file instance for the repository.
     */
    public FileQuizRepository()
    {
        this.file = new File(data);
    }

    /**
     * Method to create a new quiz item in the repository.
     * Currently not implemented.
     *
     * @param quizitem the quiz item to create
     * @throws ExecutionControl.NotImplementedException if the method is called
     */
    @Override
    public void create(Quizitem quizitem) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TO DO");
    }

    @Override
    public void update(Quizitem quizitem) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TO DO");
    }

    @Override
    public void delete(int quizitemId) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TO DO");
    }

    /**
     * Method to find and return all quiz items from the repository.
     * Reads the data from a file and parses it into quiz items.
     *
     * @return a list of all quiz items
     * @throws IOException if there is an issue reading the file
     */
    @Override
    public List<Quizitem> findAll() throws IOException
    {
        List<Quizitem> quizitems = new ArrayList<>();
        int j;

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = reader.readLine()) != null)
        {
            String[] data = line.split(delimiter);
            String question = data[1].trim();

            Answer correct = null;
            Answer[] wrong = new Answer[3];
            j = 0;
            for (int i = 2; i <= data.length - 1; i++)
            {
                String textAnswer = data[i].trim();
                if (textAnswer.endsWith(correctAnswerMarker))
                {
                    correct = AnswerFactory.createCorrect(textAnswer.substring(0, textAnswer.length() - 1));
                } else
                {
                    wrong[j] = AnswerFactory.createWrong(textAnswer);
                    j++;
                }

            }
            quizitems.add(new Quizitem(question, correct, wrong));
        }

        return quizitems;
    }


}
