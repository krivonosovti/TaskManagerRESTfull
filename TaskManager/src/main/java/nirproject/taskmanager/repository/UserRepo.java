package nirproject.taskmanager.repository;

import nirproject.taskmanager.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String user);
}