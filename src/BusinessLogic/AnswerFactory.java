package BusinessLogic;

public class AnswerFactory
{
    public static Answer createAnswer(AnswerType type, String text)
    {
        switch (type)
        {
            case CORRECTANSWER ->
            {
                return new CorrectAnswer(text);
            }
            case WRONGANSWER ->
            {
                return new WrongAnswer(text);
            }
            default ->
            {
                return null;
            }
        }

    }
}
