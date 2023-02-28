package test.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FIOValidator implements ConstraintValidator<FIOValidation, String> {
    @Override
    public boolean isValid(String fio, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        for (char a : fio.toCharArray()) {
            if (Character.UnicodeBlock.of(a) != Character.UnicodeBlock.CYRILLIC && a != ' ' || !Character.isLetter(a) && a != ' ') { // если какой-то символ в строке не русский и не равен пробелу или не является буквой
                result = false;
                break;
            }
        }
        return result;
    }
}
