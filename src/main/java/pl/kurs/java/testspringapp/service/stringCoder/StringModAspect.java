package pl.kurs.java.testspringapp.service.stringCoder;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pl.kurs.java.testspringapp.model.StringForm;

import java.util.Objects;

@Aspect
@Component
public class StringModAspect {

    @Around("execution(* modify(..))")
    public StringForm modifyAdvice(ProceedingJoinPoint joinPoint) {
        long startTime = System.nanoTime();
        StringForm proceed = null;
        try {
            proceed = (StringForm) joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        Objects.requireNonNull(proceed).setTime((endTime - startTime));
        return proceed;
    }
}
