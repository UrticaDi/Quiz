package DataAccess;

import BusinessLogic.Quizitem;
import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public interface IQuizItemRepository
{
    void create(Quizitem quizitem) throws ExecutionControl.NotImplementedException;

    void update(Quizitem quizitem);

    void delete(int quizitemId);

    Quizitem findById(int quizitemId);

    List<Quizitem> findAll();
}
