package com.softserve.itacademy.model;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        //validTask.setTodo(new ArrayList<Todo>("","",""));
        validTask.setState(firstState);
    }

    @Test
    void taskWithValidName(){
        Task task = new Task();
        task.setName("One");
        task.setName("Task2");
        task.setName("Task#3");
        task.setState(firstState);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Task>> violations = validator.validate(task);

        assertEquals(0, violations.size());
    }

    @Test
    void createValidTask() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Task>> violations = validator.validate(validTask);

        assertEquals(0, violations.size());
    }

    @ParameterizedTest
    @MethodSource("provideInvalidNameTask")
    void constraintViolationInvalid(String input, String errorValue) {
        Task task = new Task();
        task.setName("Valid-Name");
        task.setPriority(Priority.LOW);
        task.setState(firstState);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Task>> violations = validator.validate(task);

        assertEquals(1, violations.size());
        assertEquals(errorValue, violations.iterator().next().getInvalidValue());
    }

    private static Stream<Arguments> provideInvalidNameTask(){
        return Stream.of(
                Arguments.of("invalidName", "invalidName"),
                Arguments.of("", ""),
                Arguments.of("invalid", "invalid")
        );
    }

}
