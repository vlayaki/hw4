package ru.otus.homework4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.homework4.config.YamlProps;
import ru.otus.homework4.dao.QuizDao;

import java.util.List;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
public class CsvQuizDaoTest {
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public YamlProps yamlProps() {
            YamlProps res = Mockito.mock(YamlProps.class);
            Mockito.when(res.getQuizQuestionsFileName()).thenReturn("test-questions.csv");
            Mockito.when(res.getLocale()).thenReturn(new Locale("en"));
            return res;
        }
    }

    @Autowired
    QuizDao quizDao;

    @Test
    public void shouldReturnQuestionsFromFile() {
        List<String> questions = quizDao.getQuestions();
        assertThat(questions, hasSize(5));
        assertThat(questions, contains("Test question1", "Test question2", "Test question3", "Test question4", "Test question5"));
    }
}

