package com.softserve.itacademy.model;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskTests {

    private static State firstState;
    private static State secondState;
    private static Task validTask;

    @BeforeAll
    static void init(){
        firstState = new State();
        firstState.setName("FIRST");
        secondState = new State();
        secondState.setName("SECOND");
        validTask = new Task();
        validTask.setName("Task1");
        validTask.setPriority(Priority.LOW);
        validTask.setTodo("");
        validTask.setState(firstState);
    }

}
