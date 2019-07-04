package ru.otus.spring.hw01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Twit {
	
	@Getter private final Long id;
	@Getter private final String text;

}
