package ru.otus.spring.hw01.source;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component("messageSource")
@ConfigurationProperties("message-source")
public class MessageSourceImpl extends ReloadableResourceBundleMessageSource {
	
}
