package BusinessLogic;

public abstract class Answer
{
    protected String text;

    public Answer(String text)
    {
        this.text = text;
    }

    public abstract boolean isCorrect();

    public String getText()
    {
        return this.text;
    }
}
