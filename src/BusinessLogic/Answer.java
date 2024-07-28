package BusinessLogic;

/**
 * The Answer class is an abstract base class representing a quiz answer.
 * It contains the common properties and methods for different types of answers.
 */
public abstract class Answer
{
    protected String text;

    public Answer(String text)
    {
        this.text = text;
    }

    /**
     * Abstract method to determine if the answer is correct.
     *
     * @return boolean indicating if the answer is correct
     */
    public abstract boolean isCorrect();

    /**
     * Gets the text of the answer.
     *
     * @return the text of the answer
     */
    public String getText()
    {
        return this.text;
    }
}
