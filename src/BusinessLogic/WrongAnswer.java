package BusinessLogic;

public class WrongAnswer extends Answer
    {

    public WrongAnswer(String text)
        {
        super(text);
        }

    @Override
    public boolean isCorrect()
        {
        return false;
        }

    }
