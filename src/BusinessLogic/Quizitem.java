package BusinessLogic;

import java.time.Instant;
import java.util.Random;

/**
 * The Quizitem class represents a single quiz question along with its answers.
 * It handles the initialization of the question, the correct answer, and multiple wrong answers,
 * and provides methods to shuffle and check answers.
 */
public class Quizitem
{

    private static Random _random = new Random(Instant.EPOCH.toEpochMilli());
    private String _question;
    private Answer _correctAnswer;
    private Answer[] _mixedAnswers;


    public Quizitem(String question, Answer correctAnswer, Answer[] wrongAnswers)
    {
        this._question = question;
        this._correctAnswer = correctAnswer;

        _mixedAnswers = new Answer[1 + wrongAnswers.length];
        _mixedAnswers[0] = correctAnswer;
        for (int i = 0; i < wrongAnswers.length; i++)
        {
            _mixedAnswers[i + 1] = wrongAnswers[i];
        }
        this.shuffleArray(_mixedAnswers);
    }

    /**
     * Method to shuffle the array of answers to randomize their order.
     *
     * @param array the array of answers to shuffle
     */
    private static void shuffleArray(Answer[] array)
    {
        for (int i = array.length - 1; i > 0; i--)
        {
            int index = _random.nextInt(i + 1);
            Answer temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    /**
     * Method to output the question and its associated answers as a string.
     *
     * @return the formatted string of the question and answers
     */
    @Override
    public String toString()
    {
        String newLine = System.lineSeparator();
        String output = _question + newLine;

        // Append each answer option to the output string
        for (int i = 1; i <= _mixedAnswers.length; i++)
        {
            output += i + ") " + _mixedAnswers[i - 1].getText() + newLine;
        }
        return output;
    }

    /**
     * Method to check if the user's selected answer is correct.
     *
     * @param userSelection the index of the user's selected answer
     * @return boolean indicating if the selected answer is correct
     */
    public boolean checkUserAnswer(int userSelection)
    {
        Answer selectedAnswer = _mixedAnswers[userSelection - 1];
        return selectedAnswer.isCorrect();
    }

    /**
     * Method to get the text of the correct answer.
     *
     * @return the text of the correct answer
     */
    public String getCorrectAnswerText()
    {
        return _correctAnswer.getText();
    }

    /**
     * Method to get the count of answers.
     *
     * @return the number of answers available for the quiz item
     */
    public int getAnswersCount()
    {
        return _mixedAnswers.length;
    }
}
