package ru.otus.spring.hw01.repository;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Supplier;

import org.springframework.stereotype.Repository;

import ru.otus.spring.hw01.dao.TaskDao;
import ru.otus.spring.hw01.domain.Task;
import ru.otus.spring.hw01.dto.Twit;

@Repository("answersSupplier")
public class AnswersSupplier implements Supplier<Queue<Twit>> {

	private final TaskDao tasksSupplier;
	
	public AnswersSupplier(TaskDao tasksSupplier) {
		this.tasksSupplier = tasksSupplier;
	}

	@Override
	public Queue<Twit> get() {
		Queue<Task> tasks = tasksSupplier.getTasks();
		Queue<Twit> answers = new LinkedList<Twit>();
		Task task;
		while ((task = tasks.poll()) != null) {
			answers.add(new Twit(task.getId(), task.getAnswer()));
		}
		return answers;
	}

}
