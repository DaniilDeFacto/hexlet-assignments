package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> results = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(address) == null) {
                        results.add(field.getName());
                    }
                } catch (IllegalAccessException exception) {
                    throw new RuntimeException(exception);
                }
            }
        }
        return results;
    }
    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> results = new HashMap<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            List<String> errorsMessages = new ArrayList<>();
            boolean haveErrors = false;
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(address);
            } catch (IllegalAccessException exception) {
                throw new RuntimeException(exception);
            }
            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                haveErrors = true;
                errorsMessages.add("can not be null");
            }
            if (field.isAnnotationPresent(MinLength.class)) {
                MinLength minLengthInfo = field.getAnnotation(MinLength.class);
                int minLength = minLengthInfo.minLength();
                String strValue = value.toString();
                if (strValue.length() < minLength) {
                    haveErrors = true;
                    errorsMessages.add("length less than " + minLength);
                }
            }
            if (haveErrors) {
                results.put(field.getName(), errorsMessages);
            }
        }
        return results;
    }
}
// END
