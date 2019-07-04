package ru.otus.spring.hw01;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.otus.spring.hw01.dao.AnswerDaoImpl;
import ru.otus.spring.hw01.dao.CsvDao;
import ru.otus.spring.hw01.dao.QuestionDaoImpl;
import ru.otus.spring.hw01.dao.TaskDao;

@Import({AnswerDaoImpl.class, QuestionDaoImpl.class})
@Configuration
public class ConfigAnswersAndQuestionsSuppliersTest {

    @Bean
    public TaskDao tasksSupplier() {
    	return Mockito.mock(CsvDao.class);
    }

}