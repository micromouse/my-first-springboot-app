package com.studies.myfirstspringbootapp.web.Basic.Annotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * UseCase注解跟踪测试
 */
public class UseCaseTrackerTest {
    /**
     * 跟踪用户注解成功
     */
    @Test
    public void track_usecase_annotation_success() {
        List<Integer> useCases = IntStream.range(47, 51)
                .boxed()
                .collect(Collectors.toList());

        //输出符合条件的用例注解
        for (Method method : PasswordUtils.class.getDeclaredMethods()) {
            UseCase useCase = method.getAnnotation(UseCase.class);
            if (useCase != null) {
                System.out.printf("Found Use Case [%d:%s]%n", useCase.id(), useCase.description());
                useCases.remove(Integer.valueOf(useCase.id()));
            }
        }

        //输出未找到的用例注解
        String nomatchIds = useCases.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.printf("Missing use case [%s]", nomatchIds);
    }

}

/**
 * 用例注解
 * Target(value = {ElementType.METHOD}) : 只能用在方法上(如果想要将注解应用于所有的ElementType，那么可以省去@Target 注解，但是这并不常见)
 * Retention(RetentionPolicy.RUNTIME) ：VM 将在运行期也保留注解，因此可以通过反射机制读取注解的信息。
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface UseCase {
    int id();

    String description() default "no description";
}

class PasswordUtils {
    @UseCase(id = 47, description = "Passwords muse contain  at least  one numeric")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}