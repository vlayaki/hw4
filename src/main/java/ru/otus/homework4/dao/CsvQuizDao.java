package ru.otus.homework4.dao;

import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.homework4.config.YamlProps;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CsvQuizDao implements QuizDao {
    private final YamlProps yamlProps;

    @Override
    public List<String> getQuestions() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream(yamlProps.getQuizQuestionsFileName());
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(is))) {
            return csvReader.readAll().
                    stream().
                    map(line -> line[0]).
                    collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
