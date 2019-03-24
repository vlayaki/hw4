package ru.otus.homework4.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties
public class YamlProps {

    private static final String FILE_PREFIX = "questions";
    private String locale;

    public Locale getLocale() {
        return new Locale(locale);
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getQuizQuestionsFileName(){
        return FILE_PREFIX + "_" + locale.toString() + ".csv";
    }
}
