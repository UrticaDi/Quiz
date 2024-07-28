package BusinessLogic;

/**
 * The AnswerFactory class provides static methods to create instances of CorrectAnswer and WrongAnswer.
 */
public class AnswerFactory
{
    /**
     * Creates an instance of CorrectAnswer with the given text.
     *
     * @param text the text of the correct answer
     * @return an instance of CorrectAnswer
     */
    public static Answer createCorrect(String text)
    {
        return new CorrectAnswer(text);
    }

    /**
     * Creates an instance of WrongAnswer with the given text.
     *
     * @param text the text of the wrong answer
     * @return an instance of WrongAnswer
     */
    public static Answer createWrong(String text)
    {
        return new WrongAnswer(text);
    }


}
