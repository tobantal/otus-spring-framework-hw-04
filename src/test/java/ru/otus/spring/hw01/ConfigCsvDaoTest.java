package ru.otus.spring.hw01;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import ru.otus.spring.hw01.dao.CsvDao;
import ru.otus.spring.hw01.source.LocaleMessageProvider;
import ru.otus.spring.hw01.source.LocaleMessageProviderImpl;

@Import(CsvDao.class)
@PropertySource("classpath:application.yml")
@Configuration
public class ConfigCsvDaoTest {
	
    @Bean
    public LocaleMessageProvider fakeLocaleMessageProvider() {
        return Mockito.mock(LocaleMessageProviderImpl.class);
    }
    
}