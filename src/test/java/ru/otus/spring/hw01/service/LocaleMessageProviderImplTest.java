package ru.otus.spring.hw01.service;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;

import ru.otus.spring.hw01.ConfigLocaleMessageProviderImplTest;
import ru.otus.spring.hw01.source.LocaleInfo;
import ru.otus.spring.hw01.source.LocaleMessageProvider;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@ContextConfiguration(classes = ConfigLocaleMessageProviderImplTest.class)
@DisplayName("Класс LocaleMessageProviderImpl должен ")
public class LocaleMessageProviderImplTest {

	@Autowired
	private LocaleMessageProvider localeMessageProvider;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private LocaleInfo localeInfo;
	
	
	@DisplayName("правильно определять локаль из application.yml")
	@Test
	public void checkGetLocaleFromLocaleMessageProviderImpl() {
		Locale locale = localeInfo.getLocale();
		assertEquals("en", locale.getLanguage());
		assertEquals("US", locale.getCountry());
	}

	@DisplayName("правильно получать сообщение, учитывая локаль")
	@Test
	public void checkGetMessageFromLocaleMessageProviderImpl() {
		Locale locale = localeInfo.getLocale();
		String code = "qwery";
		String[] args = {"a", "b", "c"};
		given(messageSource.getMessage(code, args, locale)).willReturn("xyz");
		assertEquals("xyz", localeMessageProvider.getMessage(code, args));
	}

}
