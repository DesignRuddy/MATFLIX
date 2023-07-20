package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect // 관심사 영역 관리 설정
//지금까지 로그를 기록하는 일은 '반복적이면서 핵심 로직도 아니고, 필요기하는 한' 기능이기 때문에
//'관심사'로 간주할 수 있습니다. AOP 개념에서 Advice는 '관심사'를 실제로 구현한 코드입니다.
@Log4j
//@Component는 AOP와는 관계가 없지만 스프링에서 빈(bean)으로 인식하기 위해서 사용합니다.
@Component
public class LogAdvice {
	
	// 아래 logBefor() 메서드는 @Before 어노테이션을 적용하고 있습니다.
	// @Before는 BeforeAdvice를 구현한 메서드에 추가합니다.
	// 다른 @After, @AfterReturning, @AfterThrowin, @Around 역시
	// 동일한 방식으로 적용합니다.
	// @Befor 내부의 'execution...' 문자열은 AspectJ의 표현식(expression)
	// 입니다. 'execution'의 경우 접근 제한자와 특정 클래스의 메서드를 지정할 수 있습니다.
	// 맨 앞의 '*'는 접근 제한자를 의미하며, 맨 뒤의 '*'는 클래스의 이름과 메서드의
	// 이름을 의미합니다.
	@Before("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("=======================================");
	}
	
	// logBeforeWithParam()에서는 'execution'으로 시작하는 Pointcut 설정에
	// doAdd() 메서드를 명시하고, 파라미터의 타입을 지정합니다.
	// 뒤쪽에 '&& args (...' 부분에는 변수명을 지정하는데, 이 두가지 정보를 이용해서
	// logBeforeWithParam() 메서드의 파라미터를 설정하게 됩니다.
	// '&& args'를 이용하는 설정은 간단한 파라미터를 찾아서 기록할 때는 유용하지만
	// 파라미터가 다른 여러 종류의 메서드에 적용하는 데는 간단하지 않다는 단점이 있습니다.
	// 이 문제는 @Around와 ProceedingJoinPoint를 이용해서 해결할 수 있습니다.
	@Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) {
		log.info("str1 입니다! : " + str1);
		log.info("str2 입니다! : " + str2);
	}

	// Page460 AOP의 @AfterThrowing 어노테이션은 지정된 대상이 예외를 발생한 후에
	// 동작하면서 문제를 찾을 수 있도록 도와줄 수 있습니다.
	// logException() 메서드에 적용된 @AfterThrowing은 'pointcut'과
	// 'throwing' 속성을 지정하고 변수 이름을 'exception'으로 지정합니다.
	// 테스트 코드에서는 고의적으로 예외가 발생할 만한 코드를 작성해서 테스트합니다.
	@AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))", throwing = "exception")
	public void logException(Exception exception) {
		log.info("Exception...!!!");
		log.info("exception : " + exception);
	}
	
	// Page461 : @Around는 직접 대상 메서드를 실행할 수 있는 권한을 가지고 있고,
	//           메서드의 실행 전과 실행 후에 처리가 가능합니다.
	// ProceedingJoinPoint는 @Around와 같이 결합해서 파라미터나 예외 등을
	// 처리할 수 있습니다.
	// logTime() 메서드의 Pointcut 설정은 '...SampleService*.*(..)'로
	// 지정합니다. logTime() 메서드는 특별하게 ProceedingJoinPoint라는
	// 파라미터를 지정하는데, ProceedingJoinPoint는 AOP의 대상이 되는 Target이나
	// 파라미터 등을 파악할 뿐만 아니라, 직접 실행을 결정할 수도 있습니다.
	// @Before 등과 달리 @Around가 적용되는 메서드의 경우에는 리턴 타입이 void가 아닌
	// 타입으로 설정하고, 메서드의 실행 결과 역시 직접 반환하는 형태로 작성해야만 합니다.
	// 실행 결과를 확인할 때, @Around가 먼저 동작하고, @Before 등이 실행된 후에
	// 메서드가 실행되는데 걸린 시간이 로그로 기록되는 것을 확인해 보시기 바랍니다.
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		log.info("Target : " + pjp.getTarget());
		log.info("Param : " + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		
		try {
			result = pjp.proceed();
		} catch (Throwable e) {			
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		log.info("TIME : " + (end - start));		
		
		return result;		
	}	
}



