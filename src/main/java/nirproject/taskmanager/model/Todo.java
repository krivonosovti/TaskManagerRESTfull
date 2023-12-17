package nirproject.taskmanager.model;

import nirproject.taskmanager.entity.TodoEntity;

import java.util.Date;

public class Todo {
    private Long id;
    private String title;
    private String completed;
    private String description;
    private String executor;
    private Date expected_date;

    private Date real_date;

    private Integer priority;
    private Long time;


    public static Todo toModel(TodoEntity entity){
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setDescription(entity.getDescription());
        model.setCompleted(entity.getCompleted());
        model.setExecutor(entity.getExecutor());
        model.setExpected_date(entity.getExpected_date());
        model.setReal_date(entity.getReal_date());
        model.setPriority(entity.getPriority());
        model.setTime(entity.getTime());
        return model;
    }
    public Todo() {
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Date getExpected_date() {
        return expected_date;
    }

    public void setExpected_date(Date expected_date) {
        this.expected_date = expected_date;
    }

    public Date getReal_date() {
        return real_date;
    }

    public void setReal_date(Date real_date) {
        this.real_date = real_date;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String isCompleted() {
        return completed;
    }

    public void setCompleted(String pleted) {
        this.completed = completed;
    }
}
