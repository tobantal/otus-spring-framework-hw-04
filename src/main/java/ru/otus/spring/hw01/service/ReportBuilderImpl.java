package ru.otus.spring.hw01.service;

import org.springframework.stereotype.Service;

import ru.otus.spring.hw01.source.LocaleMessageProvider;

@Service
public class ReportBuilderImpl implements ReportBuilder {
	
	private final LocaleMessageProvider localeMessageProvider;

	public ReportBuilderImpl(LocaleMessageProvider localeMessageProvider) {
		this.localeMessageProvider = localeMessageProvider;
	}
	
	@Override
	public String buildReport(String firstName, String lastName, String grade) {
		return localeMessageProvider.getMessage("report.template", new String[]{firstName, lastName, grade});
	}

}
