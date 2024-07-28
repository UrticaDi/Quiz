package BusinessLogic;

/**
 * The CorrectAnswer class extends the Answer class to represent a correct quiz answer.
 */
public class CorrectAnswer extends Answer
{
    public CorrectAnswer(String text)
    {
        super(text);
    }

    /**
     * Method to determine if the answer is correct.
     *
     * @return true as this class represents a correct answer
     */
    @Override
    public boolean isCorrect()
    {
        return true;
    }
}
