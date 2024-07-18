package DataAccess;

import BusinessLogic.Quizitem;

import java.util.List;

public interface IQuizItemRepository
{
    void create(Quizitem quizitem);

    void update(Quizitem quizitem);

    void delete(int quizitemId);

    Quizitem findById(int quizitemId);

    List<Quizitem> findAll();
}
