package nirproject.taskmanager.service;

import nirproject.taskmanager.entity.TodoEntity;
import nirproject.taskmanager.entity.UserEntity;
import nirproject.taskmanager.exception.UserNotFoundException;
import nirproject.taskmanager.model.Todo;
import nirproject.taskmanager.model.User;
import nirproject.taskmanager.repository.TodoRepo;
import nirproject.taskmanager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Date;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        todo.setExecutor(user.getUsername());
        Date now = new Date();
        todo.setCreated_date(now);
        return Todo.toModel(todoRepo.save(todo));
    }


    public Todo complete (Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted("Closed");
    //  Date now = new Date();
    //  todo.setReal_date(now);
    //  todo.setTime(now.getTime() - todo.getCreated_date().getTime());
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo set_in_process (Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted("In process");
        Date now = new Date();
        todo.setReal_date(now);
        todo.setTime(now.getTime() - todo.getCreated_date().getTime());
        return Todo.toModel(todoRepo.save(todo));
    }


    public Todo set_cancel (Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted("Deleted");
        Date now = new Date();
        todo.setReal_date(now);
        todo.setTime(now.getTime() - todo.getCreated_date().getTime());
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo getOne (Long id) throws UserNotFoundException {
        TodoEntity todo = todoRepo.findById(id).get();
        if(todo == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return Todo.toModel(todo);
    }
    public Long delete(Long id){
        todoRepo.deleteById(id);
        return id;
    }
    public Todo changeDescription(TodoEntity changes,Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setDescription(changes.getDescription());
        return Todo.toModel(todoRepo.save(todo));
    }
    public Todo changeExpected_date(TodoEntity changes,Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setExpected_date(changes.getExpected_date());
        return Todo.toModel(todoRepo.save(todo));
    }


}
