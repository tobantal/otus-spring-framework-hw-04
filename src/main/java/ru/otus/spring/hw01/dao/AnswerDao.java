package ru.otus.spring.hw01.dao;

import java.util.Queue;

import ru.otus.spring.hw01.dto.Twit;

public interface AnswerDao {
	
	Queue<Twit> getAnswers();

}
