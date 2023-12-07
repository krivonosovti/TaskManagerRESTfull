package nirproject.taskmanager.model;

import nirproject.taskmanager.entity.UserEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class User {
    private  Long id;
    private String Username;

    private List<Todo> todos;


    public static User toModel (UserEntity entity)
    {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList())); // массив сушности в массив моделей
        return model;
    }
    public User() {

    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }



}