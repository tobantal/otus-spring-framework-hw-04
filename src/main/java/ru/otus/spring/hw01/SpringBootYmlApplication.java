package ru.otus.spring.hw01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import ru.otus.spring.hw01.service.Examinator;

@PropertySource("classpath:application.yml")
@EnableAspectJAutoProxy
@ComponentScan
@SpringBootApplication
public class SpringBootYmlApplication {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setBasename("/i18n/bundle");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootYmlApplication.class, args);

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringBootYmlApplication.class)) {

			context.getBean(Examinator.class).takeAnExam();
		}
	}

}
