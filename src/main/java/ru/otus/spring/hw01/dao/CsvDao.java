package ru.otus.spring.hw01.dao;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Supplier;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import ru.otus.spring.hw01.domain.Task;
import ru.otus.spring.hw01.exception.ColumnNumberException;
import ru.otus.spring.hw01.exception.CsvFileNotFoundException;
import ru.otus.spring.hw01.service.LocaleMessageProvider;

@Component
@ConfigurationProperties("application")
public class CsvDao implements TaskDao {
	
	private String delimeter = ";";

	private final LocaleMessageProvider localeMessageProvider;

	public CsvDao(LocaleMessageProvider localeMessageProvider) {
		this.localeMessageProvider = localeMessageProvider;

	}

	@Override
	public Queue<Task> getTasks() {
		InputStream inputStream = getCsvFileInputStreamOrThrow(getCsvPath());

		Queue<Task> queue = new LinkedList<>();

		try (Scanner scanner = new Scanner(inputStream);) {
			while (scanner.hasNextLine()) {
				Task task = taskParseOrThrow(scanner.nextLine());
				queue.add(task);
			}
		}
		return queue;
	}
	
	private String getCsvPath() {
		return "tasks_" + localeMessageProvider.getLocale().getLanguage() + "_"
				+ localeMessageProvider.getLocale().getCountry()+ ".csv";
	}

	private InputStream getCsvFileInputStreamOrThrow(String csvPath) {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(csvPath);
		if (inputStream == null) {
			throw new CsvFileNotFoundException(csvPath + " not found");
		}
		return inputStream;
	}

	private Task taskParseOrThrow(String line) {
		String[] args = line.split(delimeter);
		if (args.length != 3) {
			throw new ColumnNumberException();
		}
		if (StringUtils.isEmpty(args[0]) || StringUtils.isEmpty(args[1]) || StringUtils.isEmpty(args[2])) {
			throw new NullPointerException();
		}
		return new Task(Long.parseLong(args[0]), args[1], args[2]);
	}

}
