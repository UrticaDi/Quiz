package BusinessLogic;

/**
 * The WrongAnswer class extends the Answer class to represent a wrong quiz answer.
 */
public class WrongAnswer extends Answer
{

    public WrongAnswer(String text)
    {
        super(text);
    }

    /**
     * Method to determine if the answer is correct.
     *
     * @return false as this class represents a wrong answer
     */
    @Override
    public boolean isCorrect()
    {
        return false;
    }

}
