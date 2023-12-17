package nirproject.taskmanager.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
//@Table(name = "todo")
public class TodoEntity implements Comparable<TodoEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String completed = "Open";//in_process, closed, deleted - ?
    private String description = null;
    private String executor;

    private Date created_date;
    private Date expected_date = null;
    private Integer priority = 1;

    private Date real_date = null;

    private Long time = null;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public TodoEntity() {
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
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

    public String getDescription() {
        return description;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }
    public void setDescription(String description) {
        this.description = description;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public int compareTo(TodoEntity o) {
        if(priority == o.getPriority()){ return 0;}
        if (priority < o.getPriority()) {return -1;}
        return 1;
    }
}
