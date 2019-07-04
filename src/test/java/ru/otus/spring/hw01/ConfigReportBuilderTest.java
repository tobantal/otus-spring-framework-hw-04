package ru.otus.spring.hw01;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.otus.spring.hw01.service.ReportBuilderImpl;
import ru.otus.spring.hw01.source.LocaleMessageProvider;
import ru.otus.spring.hw01.source.LocaleMessageProviderImpl;

@Import(ReportBuilderImpl.class)
@Configuration
public class ConfigReportBuilderTest {
	
    @Bean
    public LocaleMessageProvider fakeLocaleMessageProvider() {
        return Mockito.mock(LocaleMessageProviderImpl.class);
    }

}
