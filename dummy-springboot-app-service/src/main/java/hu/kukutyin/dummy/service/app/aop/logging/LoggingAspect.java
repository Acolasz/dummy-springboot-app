package hu.kukutyin.dummy.service.app.aop.logging;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Setter
@Getter
@Aspect
public class LoggingAspect {

    private String message;

    @Pointcut("@annotation(Log)")
    public void logPointcut() {
    }

    @Before("logPointcut()")
    public void logAllMethodCallsAdvice(JoinPoint joinPoint) {
        log.info("{}", joinPoint.getSignature().toShortString());
        this.setMessage(joinPoint.getSignature().toShortString());
        for (Object arg : joinPoint.getArgs()) {
            log.info("{}", arg);
        }
    }
}
