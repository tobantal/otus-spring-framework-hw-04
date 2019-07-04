package ru.otus.spring.hw01.source;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

@Component
public class LocaleMessageProviderImpl implements LocaleMessageProvider {

	private final MessageSource messageSource;
	private final LocaleInfo localeInfo;

	public LocaleMessageProviderImpl(MessageSource messageSource, LocaleInfo localeInfo) {
		this.messageSource = messageSource;
		this.localeInfo = localeInfo;
	}

	@Override
	public String getMessage(String code, Object[] args) throws NoSuchMessageException {
		return messageSource.getMessage(code, args, localeInfo.getLocale());
	}

}
