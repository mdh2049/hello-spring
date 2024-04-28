
package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
// @Component AOP의 대상이 되는 이런 코드 자체가 없기 때문에 문제가 발생하지 않았습니다.
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*(..))&& !target(hello.hellospring.SpringConfig)\"") // package하위에 다 적용해라
                                                                                                 // claa,packacge 명 가능
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            Object result = joinPoint.proceed();// 다음 메소드로 진행
            return result;
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
