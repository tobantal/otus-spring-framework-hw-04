package ru.otus.spring.hw01.source;

import java.util.Locale;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
@ConfigurationProperties("locale-info")
@Setter
public class LocaleInfoImpl implements LocaleInfo {
	
	private String language;
	private String country;

	@Override
	public Locale getLocale() {
		return new Locale(language, country);
	}

}
