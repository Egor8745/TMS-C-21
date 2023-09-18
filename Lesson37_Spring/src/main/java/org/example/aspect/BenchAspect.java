package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BenchAspect {
    @Pointcut("@annotation(org.example.configuration.Benchmark)")
    public void pointcut() {}

    @Around("pointcut()")
    public Object process(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        Object process = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("Bench time for" + methodName + " = " + (end - start));
        return process;


    }
}
