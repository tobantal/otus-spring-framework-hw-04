package ru.otus.spring.hw01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

import ru.otus.spring.hw01.service.Examinator;

@PropertySource("classpath:application.yml")
@EnableAspectJAutoProxy
@ComponentScan
@SpringBootApplication
public class SpringBootYmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootYmlApplication.class, args).getBean(Examinator.class).takeAnExam();
	}

}
