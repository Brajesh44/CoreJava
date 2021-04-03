package Executor.Framework;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


class Result 
{
    private String name;
    private String timestamp;
 
    public Result(String name, String timestamp) {
        super();
        this.name = name;
        this.timestamp = timestamp;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getTimestamp() {
        return timestamp;
    }
 
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
 
    @Override
    public String toString() {
        return "Result [name=" + name + ", value=" + timestamp + "]";
    }
}

class Task implements Callable<Result> 
{
    private final String name;
 
    public Task(String name) {
        this.name = name;
    }
 
    @Override
    public Result call() throws Exception 
    {
        System.out.printf("%s: Staring\n", this.name);
 
        try {
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        return new Result(this.name, LocalDateTime.now().toString());
    }
}

public class InvokeAllMethod {
	public static void main(String[] args) throws InterruptedException 
    {
        ExecutorService executor = (ExecutorService) Executors.newFixedThreadPool(2);
 
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task-" + i);
            taskList.add(task);
        }
         
        //Execute all tasks and get reference to Future objects
        List<Future<Result>> resultList = null;
 
        try {
            resultList = executor.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        executor.shutdown();
 
        System.out.println("\n========Printing the results======");
         
        for (int i = 0; i < resultList.size(); i++) {
            Future<Result> future = resultList.get(i);
            try {
                Result result = future.get();
                System.out.println(result.getName() + ": " + result.getTimestamp());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
