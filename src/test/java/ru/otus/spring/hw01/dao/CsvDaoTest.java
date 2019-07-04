package ru.otus.spring.hw01.dao;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.Locale;
import java.util.Queue;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import ru.otus.spring.hw01.ConfigCsvDaoTest;
import ru.otus.spring.hw01.domain.Task;
import ru.otus.spring.hw01.exception.ColumnNumberException;
import ru.otus.spring.hw01.exception.CsvFileNotFoundException;
import ru.otus.spring.hw01.service.LocaleMessageProvider;


@SpringBootTest
@ContextConfiguration(classes = ConfigCsvDaoTest.class)
@DisplayName("Класс CsvDao должен ")
class CsvDaoTest {
	
	@Autowired
    ApplicationContext context;
	
	@Autowired
    LocaleMessageProvider fakeLocaleMessageProvider;
	
	@Autowired
	TaskDao tasksSupplier;
    
    @Test
    @DisplayName("выдавать корректные задачи из корректного csv-файла")
    void correct_loading_of_the_file() {
    	given(fakeLocaleMessageProvider.getLocale()).willReturn(new Locale("en", "US"));
        Queue<Task> queue = tasksSupplier.getTasks();
        BiPredicate<Task, Integer> p = (t, i) -> t.getId() == i && t.getQuestion().equals("Task" + i) && t.getAnswer().equals("Answer" + i);
        assertTrue(IntStream.rangeClosed(1, 5).allMatch(i -> p.test(queue.poll(), i)));
        assertNull(queue.poll());
    }
    
    @Test
    @DisplayName("выбрасывать ColumnNumberException при чтении csv-файла со столбцами длины < 3")
    void shouldThrowColumnNumberException() {
    	given(fakeLocaleMessageProvider.getLocale()).willReturn(new Locale("ex", "ColumnNumberException"));
        assertThatThrownBy(tasksSupplier::getTasks).isInstanceOf(ColumnNumberException.class);
    }
    
    @Test
    @DisplayName("выбрасывать NullPointerException при чтении csv-файла со столбцами == null")
    void shouldThrowNullPointerException() {
    	given(fakeLocaleMessageProvider.getLocale()).willReturn(new Locale("ex", "NullPointerException"));
        assertThatThrownBy(tasksSupplier::getTasks).isInstanceOf(NullPointerException.class);
    }
    
    
    @Test
    @DisplayName("выбрасывать NumberFormatException при чтении csv-файла с нечисловым id")
    void shouldThrowNumberFormatException() {
    	given(fakeLocaleMessageProvider.getLocale()).willReturn(new Locale("ex", "NumberFormatException"));
    	assertThatThrownBy(tasksSupplier::getTasks).isInstanceOf(NumberFormatException.class);
    }
    
    @Test
    @DisplayName("выбрасывать CsvFileNotFoundException, если csv-файла не существует")
    void shouldThrowFileNotFoundException() {
    	given(fakeLocaleMessageProvider.getLocale()).willReturn(new Locale("ex", "CsvFileNotFoundException"));
    	assertThatThrownBy(tasksSupplier::getTasks).isInstanceOf(CsvFileNotFoundException.class);
    }
    
}
