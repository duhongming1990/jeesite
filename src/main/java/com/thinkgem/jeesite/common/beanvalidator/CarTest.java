package com.thinkgem.jeesite.common.beanvalidator;

import com.thinkgem.jeesite.common.mapper.JsonMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/8/30 17:46
 */
public class CarTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
//        validator = new LocalValidatorFactoryBean();
    }

    @Test
    public void manufacturerIsNull() {
        Car car = new Car(null, "DD-AB-123", 3);
        Set<ConstraintViolation<Car>> constraintViolations = validator.validate(car);
        System.out.println("constraintViolations1.get(0).getMessage() = " + constraintViolations.iterator().next().getMessage());

        String s = " a b c ";
        s = s.replaceAll("\\s+","");
        System.out.println("s = " + s);


    }

    public static void validateWithException(Validator validator, Object object, Class<?>... groups)
            throws ConstraintViolationException {
        Set constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

//    @Test
//    public void licensePlateTooShort() {
//        Car car = new Car("Morris", "D", 4);
//
//        Set<ConstraintViolation<Car>> constraintViolations =
//                validator.validate(car);
//
//        assertEquals(1, constraintViolations.size());
//        assertEquals("size must be between 2 and 14", constraintViolations.iterator().next().getMessage());
//    }
//
//    @Test
//    public void seatCountTooLow() {
//        Car car = new Car("Morris", "DD-AB-123", 1);
//
//        Set<ConstraintViolation<Car>> constraintViolations =
//                validator.validate(car);
//
//        assertEquals(1, constraintViolations.size());
//        assertEquals("must be greater than or equal to 2", constraintViolations.iterator().next().getMessage());
//    }
//
//    @Test
//    public void carIsValid() {
//        Car car = new Car("Morris", "DD-AB-123", 2);
//
//        Set<ConstraintViolation<Car>> constraintViolations =
//                validator.validate(car);
//
//        assertEquals(0, constraintViolations.size());
//    }
}