package test.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HexValidator implements ConstraintValidator<HexValidation,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("#[0-9A-Fa-f]{6}"); // проверяем на HEX Value (начинается на #, содержит латинские буквы с A до F и цифры, длина 6 символов)
    }
}
