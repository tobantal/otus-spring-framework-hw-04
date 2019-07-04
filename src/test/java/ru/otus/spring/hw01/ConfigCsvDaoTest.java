package ru.otus.spring.hw01;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import ru.otus.spring.hw01.dao.CsvDao;
import ru.otus.spring.hw01.source.LocaleInfo;

@Import(CsvDao.class)
@PropertySource("classpath:application.yml")
@Configuration
public class ConfigCsvDaoTest {
	
    @Bean
    public LocaleInfo localeInfo() {
        return Mockito.mock(LocaleInfo.class);
    }
    
}