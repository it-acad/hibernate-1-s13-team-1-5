package com.softserve.itacademy.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StateTests {

    @Test
    void constraintViolationOnEmptyRoleName() {
        State emptyState = new State();
        emptyState.setName("");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<State>> violations = validator.validate(emptyState);

        assertEquals(1, violations.size());
    }

    @Test
    void stateWithValidName() {
        State state = new State();
        state.setName("Valid_10");
        state.setName("Valid-34");
        state.setName("Valid 12");
        state.setName("v_12");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<State>> violations = validator.validate(state);

        assertEquals(0,violations.size());
    }
}
