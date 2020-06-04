package ru.otus.spring.hw01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.otus.spring.hw01.service.Examinator;

@SpringBootApplication
public class SpringBootYmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootYmlApplication.class, args).getBean(Examinator.class).takeAnExam();
	}

}
