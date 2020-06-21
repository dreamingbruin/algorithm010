package Common;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;

public class Tests {

    public static void execute(Class<?> clazz, Pair<?, ?>... pairs) {
        System.out.println(String.format("Testing class: [%s]", clazz));
        Optional<Method> optionalMethod = Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .filter(method -> !Modifier.isStatic(method.getModifiers()))
                .findFirst();
        Method executionMethod = optionalMethod.orElseThrow(() ->
                new RuntimeException(String.format("No public method found in [%s]", clazz)));
        for (Pair<?, ?> pair : pairs) {
            try {
                Object instance = clazz.getDeclaredConstructor().newInstance();
                Object key = pair.getKey();
                boolean isKeyArray = key.getClass().isArray();
                Object result = !isKeyArray ?
                        executionMethod.invoke(instance, key) :
                        executionMethod.invoke(instance, (Object[]) key);
                if (result == null) {
                    result = inspectResultFromKey(key);
                    if (result == null) {
                        throw new RuntimeException("No valid result if found");
                    }
                }
                Object value = pair.getValue();
                boolean isValueArray = value.getClass().isArray();
                boolean matched = isValueArray ? Arrays.equals(toObjectArray(value), toObjectArray(result)) : value.equals(result);
                if (!matched) {
                    throw new RuntimeException(String.format("Failed execution: Parameter: [%s], " +
                                    "Expected result: [%s], Actual result: [%s]",
                            isKeyArray ? Arrays.toString(toObjectArray(key)) : key,
                            isValueArray ? Arrays.toString(toObjectArray(value)) : value,
                            isValueArray ? Arrays.toString(toObjectArray(result)) : result));
                }
            } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                    InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static Object inspectResultFromKey(Object key) {
        if (key.getClass().isArray()) {
            for (Object obj : (Object[]) key) {
                if (obj.getClass().isArray()) {
                    return obj;
                }
            }
        }
        return null;
    }

    private static Object[] toObjectArray(Object obj) {
        int length = Array.getLength(obj);
        Object[] ret = new Object[length];
        for (int i = 0; i < length; i++) {
            ret[i] = Array.get(obj, i);
        }
        return ret;
    }

}
