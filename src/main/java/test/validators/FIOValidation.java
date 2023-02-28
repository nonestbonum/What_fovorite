package test.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FIOValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FIOValidation {
    String message() default "Не должно содержать символов. Должно быть на русском языке";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
