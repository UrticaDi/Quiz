package BusinessLogic;

import java.time.Instant;
import java.util.Random;


public class Quizitem
    {

    private static Random _random = new Random(Instant.EPOCH.toEpochMilli());
    private String _question;
    private Answer _correctAnswer;
    private Answer[] _mixedAnswers;


    // Constructor to initialize the quiz item with a question, correct answer and wrong answers
    public Quizitem(String question, Answer correctAnswer, Answer[] wrongAnswers)
        {
        this._question = question;
        this._correctAnswer = correctAnswer;

        // Mixing correct and wrong answers
        _mixedAnswers = new Answer[1 + wrongAnswers.length];
        //adding correct answer
        _mixedAnswers[0] = correctAnswer;
        for (int i = 0; i < wrongAnswers.length; i++)
            {
            _mixedAnswers[i + 1] = wrongAnswers[i];
            }
        this.shuffleArray(_mixedAnswers); // Shuffle to randomize the added answers
        }

    // Method to mix the answers
    private static void shuffleArray(Answer[] array)
        {
        for (int i = array.length - 1; i > 0; i--)
            {
            int index = _random.nextInt(i + 1);
            // Swap array[i] with the element at random index
            Answer temp = array[i];
            array[i] = array[index];
            array[index] = temp;
            }
        }

    //Method to output the questions and to them belonging answers
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

    public boolean checkUserAnswer(int userSelection)
        {
        Answer selectedAnswer = _mixedAnswers[userSelection - 1];
        return selectedAnswer.isCorrect();
        }

    // Method to get the text of the correct answer
    public String getCorrectAnswerText()
        {
        return _correctAnswer.getText();
        }

    public int getAnswersCount()
        {
        return _mixedAnswers.length;
        }
    }
