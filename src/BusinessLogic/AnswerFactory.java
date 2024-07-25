package BusinessLogic;

public class AnswerFactory
{
    public static Answer createCorrect(String text)
    {
        return new CorrectAnswer(text);
    }

    public static Answer createWrong(String text)
    {
        return new WrongAnswer(text);
    }


}
