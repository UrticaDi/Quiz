package DataAccess;

import BusinessLogic.Quizitem;
import jdk.jshell.spi.ExecutionControl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * The IQuizItemRepository interface defines the contract for operations
 * related to managing quiz items in a repository. It includes methods for
 * creating, updating, deleting, and retrieving quiz items.
 */
public interface IQuizItemRepository
{
    /**
     * Creates a new quiz item in the repository.
     *
     * @param quizitem the quiz item to create
     * @throws ExecutionControl.NotImplementedException if the method is not implemented
     */
    void create(Quizitem quizitem) throws ExecutionControl.NotImplementedException;

    void update(Quizitem quizitem) throws ExecutionControl.NotImplementedException;

    void delete(int quizitemId) throws ExecutionControl.NotImplementedException;

    /**
     * Finds and returns all quiz items from the repository.
     *
     * @return a list of all quiz items
     * @throws IOException if there is an issue reading from the repository
     */
    List<Quizitem> findAll() throws IOException;
}
