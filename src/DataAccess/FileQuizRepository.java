package DataAccess;

import BusinessLogic.Quizitem;
import BusinessLogic.AnswerFactory;
import BusinessLogic.Answer;
import jdk.jshell.spi.ExecutionControl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileQuizRepository implements IQuizItemRepository
{
    private final String data = "Data.txt";
    private final String delimiter = ";";
    private final String correctAnswerMarker = "*";
    private File file;

    public FileQuizRepository()
    {
        this.file = new File(data);
    }

    @Override
    public void create(Quizitem quizitem) throws ExecutionControl.NotImplementedException
    {
        throw new ExecutionControl.NotImplementedException("TO DO");
    }

    @Override
    public void update(Quizitem quizitem)
    {
    }

    @Override
    public void delete(int quizitemId)
    {
    }

    @Override
    public Quizitem findById(int quizitemId)
    {
        return null;
    }

    @Override
    public List<Quizitem> findAll()
    {
        List<Quizitem> quizitems = new ArrayList<>();
        int j;

        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] data = line.split(delimiter);
                String question = data[1].trim();

                Answer correct = null;
                Answer[] wrong = new Answer[3];
                j = 0;
                for (int i = 2; i <= 5; i++)
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
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return quizitems;
    }



}
