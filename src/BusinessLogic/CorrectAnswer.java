package BusinessLogic;

public class CorrectAnswer extends Answer
{
    public CorrectAnswer(String text)
    {
        super(text);
    }

    @Override
    public boolean isCorrect()
    {
        return true;
    }
}
