package hello;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TodoTaskController {
    private HashMap<Long,TodoTask> todoList = new HashMap<Long, TodoTask>();
    private AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/api/tasks/{id}",method = RequestMethod.GET)
    public TodoTask getTodoTask(@PathVariable long id){
        return todoList.get(id);
    }
    @RequestMapping(path = "/api/tasks/",method = RequestMethod.GET)
    public HashMap<Long,TodoTask> getTodoTasks(){
        return todoList;
    }
    @RequestMapping(path = "/api/tasks/",method = RequestMethod.POST)
    public TodoTask postTodoTask(@RequestParam String content){
        TodoTask todoTask = new TodoTask(counter.incrementAndGet(),content);
        todoList.put(todoTask.getId(),todoTask);
        return todoTask;
    }

    @RequestMapping(path = "/api/tasks/{id}",method = RequestMethod.DELETE)
    public TodoTask deleteTodoTask(@PathVariable long id){
        TodoTask todoTask = todoList.get(id);
        todoList.remove(id);
        return todoTask;
    }

}
