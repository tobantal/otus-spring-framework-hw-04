package ru.otus.spring.hw01.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.Locale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;

import ru.otus.spring.hw01.ConfigLocaleMessageProviderImplTest;
import ru.otus.spring.hw01.source.LocaleMessageProvider;

@SpringBootTest
@ContextConfiguration(classes = ConfigLocaleMessageProviderImplTest.class)
@DisplayName("Класс LocaleMessageProviderImpl должен ")
public class LocaleMessageProviderImplTest {

	@Autowired
	private LocaleMessageProvider localeMessageProvider;
	
	@Autowired
	private MessageSource messageSource;
	
	
	@DisplayName("правильно определять локаль из application.properties")
	@Test
	public void checkGetLocaleFromLocaleMessageProviderImpl() {
		Locale locale = localeMessageProvider.getLocale();
		assertEquals("en", locale.getLanguage());
		assertEquals("US", locale.getCountry());
	}

	@DisplayName("правильно получать сообщение, учитывая локаль")
	@Test
	public void checkGetMessageFromLocaleMessageProviderImpl() {
		Locale locale = localeMessageProvider.getLocale();
		String code = "qwery";
		String[] args = {"a", "b", "c"};
		given(messageSource.getMessage(code, args, locale)).willReturn("xyz");
		assertEquals("xyz", localeMessageProvider.getMessage(code, args));
	}

}
