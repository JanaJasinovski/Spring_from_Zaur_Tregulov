package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around( "execution(public String returnBook())" )
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();

        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice: было поймано исключение: " + e.getMessage());
            throw e;
//            proceed = "неизвестное название книги";
        }

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
        return proceed;
    }
}
