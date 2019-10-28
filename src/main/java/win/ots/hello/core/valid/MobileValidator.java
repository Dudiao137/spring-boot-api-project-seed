package win.ots.hello.core.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author : sy.wang
 * @date : 2019-10-28
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {

    private Pattern pattern;

    @Override
    public void initialize(Mobile mobile) {
        pattern = Pattern.compile(mobile.regexp());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return pattern.matcher(value).matches();
    }
}
