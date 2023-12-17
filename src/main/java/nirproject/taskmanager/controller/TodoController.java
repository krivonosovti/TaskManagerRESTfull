package nirproject.taskmanager.controller;

import nirproject.taskmanager.entity.TodoEntity;
import nirproject.taskmanager.exception.UserNotFoundException;
import nirproject.taskmanager.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long userId)
    {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        }
        catch(Exception e)
        {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("/completed")  // из отмененной в завершенную нельзя и аналог
    public ResponseEntity completedTodo(@RequestParam Long id)
    {
        try {
            return ResponseEntity.ok(todoService.complete(id));
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("/doing")
    public ResponseEntity processingTodo(@RequestParam Long id)
    {
        try {
            return ResponseEntity.ok(todoService.set_in_process(id));
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PutMapping("/cancel")
    public ResponseEntity canceledTodo(@RequestParam Long id)
    {
        try {
            return ResponseEntity.ok(todoService.set_cancel(id));
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity qetOneTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.getOne(id));
        }
        catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTodo (@PathVariable Long id){
        try {
            return ResponseEntity.ok(todoService.delete(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
    @PatchMapping("/{id}/description")
    public ResponseEntity changeTodosDescription(@RequestBody TodoEntity changes,@PathVariable Long id)
    {
        try {
            return ResponseEntity.ok(todoService.changeDescription(changes,id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
    @PatchMapping("/{id}/expected_date")
    public ResponseEntity changeTodosExpected_date(@RequestBody TodoEntity changes,@PathVariable Long id)
    {
        try {
            return ResponseEntity.ok(todoService.changeExpected_date(changes,id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }

}
