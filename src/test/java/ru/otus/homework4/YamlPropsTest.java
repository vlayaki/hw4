package ru.otus.homework4;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.otus.homework4.config.YamlProps;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class YamlPropsTest {
    @Test
    @Parameters({
            "ru, questions_ru.csv",
            "en, questions_en.csv"
    })
    public void shouldReturnCorrectFileName(String locale, String expectedFileName) {
        YamlProps yamlProps = new YamlProps();
        yamlProps.setLocale(locale);
        assertThat(yamlProps.getQuizQuestionsFileName(), equalTo(expectedFileName));
    }
}
