package pl.kurs.java.testspringapp.service.stringmod;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pl.kurs.java.testspringapp.model.StringModForm;

import java.util.Objects;

@Aspect
@Component
@RequiredArgsConstructor
public class StringModAspect {
    private final StringModForm form;

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
