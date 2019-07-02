package ru.otus.spring.hw01.loggin;

import java.util.Queue;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ru.otus.spring.hw01.dto.Twit;
import ru.otus.spring.hw01.exception.TwitIdMatchedException;

@Aspect
@Service
public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@SuppressWarnings("unchecked")
	@Around("execution(java.util.Queue<ru.otus.spring.hw01.dto.Twit> ru.otus.spring.hw01.service.UserAnswersSupplier.get())")
	public Queue<Twit> checkUserInput(ProceedingJoinPoint proceedingJoinPoint) {
		logger.info(">>> Spring AOP start: checkUserInput");
		
		try {
			Queue<Twit> usersAnswers = (Queue<Twit>) proceedingJoinPoint.proceed();
			Twit firstElement = usersAnswers.peek();

			if (isFirstName(firstElement)) {
				throw new TwitIdMatchedException();
			}
			logger.info(">>> Spring AOP finished: checkUserInput");

			return usersAnswers;

		} catch (Throwable e) {
			throw new TwitIdMatchedException();
		}

	}
	
	private boolean isFirstName(Twit twit) {
		return !twit.getId().equals(-2L);
	}

}
