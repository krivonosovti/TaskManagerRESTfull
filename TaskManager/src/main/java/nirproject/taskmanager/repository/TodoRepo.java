package nirproject.taskmanager.repository;

import nirproject.taskmanager.entity.TodoEntity;
import nirproject.taskmanager.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
    TodoEntity findByTitle(String title);
}
