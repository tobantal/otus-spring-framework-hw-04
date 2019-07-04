package ru.otus.spring.hw01;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.otus.spring.hw01.dao.AnswerDao;
import ru.otus.spring.hw01.service.AnswerTesterImpl;

@Import(AnswerTesterImpl.class)
@Configuration
public class ConfigAnswerTesterImplTest {
	
    @Bean
    public AnswerDao answersSupplier() {
    	return Mockito.mock(AnswerDao.class);
    }

}