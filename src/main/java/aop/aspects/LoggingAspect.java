package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Aspect
@Order(1)
public class LoggingAspect {

    @Pointcut("execution(* aop.UniLibrary.*(..))")
    private void allMethodsFromUniLibrary() {}

    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
    private void returnMagazineFromUniLibrary() {}

    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
    private void allMethodsExceptReturnMagazineFromUniLibrary() {}


    @Before( "allMethodsExceptReturnMagazineFromUniLibrary()" )
    public void beforeAllMethodsExceptReturnMagazineFromUniLibrary() {
        System.out.println("beforeAllMethodsExceptReturnMagazineFromUniLibrary: writing Log #10");
    }

    @Pointcut("execution(* aop.UniLibrary.get*())")
    private void allGetMethodsFromUniLibrary() {}

    @Pointcut("execution(* aop.UniLibrary.return*())")
    private void allReturnMethodsFromUniLibrary() {}

    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    private void allGetAndReturnMethodsFromUniLibrary() {}

    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnLoggingAdvice() {
        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
    }

    @Before("allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetAndReturnLoggingAdvice() {
        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
    }

    @Before("aop.aspects.MyPointcuts.allGetMethods()")
    public void beforeGetLoggingAdvice() {
        System.out.println("beforeGetLoggingAdvice: попытка получить книгу/журнал");
    }

    @Before("execution(* returnBook())")
    public void beforeReturnBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка вернуть книгу");
    }

}
