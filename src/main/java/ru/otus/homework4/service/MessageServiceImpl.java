package ru.otus.homework4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.homework4.config.YamlProps;

@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageSource messageSource;
    private final YamlProps yamlProps;

    @Override
    public String getMessage(String s) {
        return messageSource.getMessage(s, null, yamlProps.getLocale());
    }

    @Override
    public String getMessage(String s, Object... args) {
        return messageSource.getMessage(s, args, yamlProps.getLocale());
    }
}
