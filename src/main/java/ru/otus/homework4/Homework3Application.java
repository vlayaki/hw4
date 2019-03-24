package ru.otus.homework4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.otus.homework4.config.YamlProps;

import java.io.IOException;

@SpringBootApplication
@EnableConfigurationProperties(YamlProps.class)
public class Homework3Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Homework3Application.class, args);
    }

}
