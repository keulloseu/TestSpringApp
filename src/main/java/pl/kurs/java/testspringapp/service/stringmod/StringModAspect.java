package pl.kurs.java.testspringapp.service.stringmod;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pl.kurs.java.testspringapp.model.StringModForm;

import java.util.Objects;

@Aspect
@Component
public class StringModAspect {

    @Around("execution(* modify(..))")
    public StringModForm modifyAdvice(ProceedingJoinPoint joinPoint) {
        long startTime = System.nanoTime();
        StringModForm proceed = null;
        try {
            proceed = (StringModForm) joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        Objects.requireNonNull(proceed).setTime((endTime - startTime));
        return proceed;
    }
}
