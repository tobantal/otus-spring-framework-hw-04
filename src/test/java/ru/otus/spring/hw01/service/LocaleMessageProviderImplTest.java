package ru.otus.spring.hw01.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

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
	
	@DisplayName("правильно получать сообщение, учитывая локаль")
	@Test
	public void checkGetMessageFromLocaleMessageProviderImpl() {
		Locale locale = new Locale("en", "US");
		String code = "qwery";
		String[] args = {"a", "b", "c"};
		given(localeInfo.getLocale()).willReturn(locale);
		given(messageSource.getMessage(code, args, locale)).willReturn("xyz");
		assertEquals("xyz", localeMessageProvider.getMessage(code, args));
	}

}
