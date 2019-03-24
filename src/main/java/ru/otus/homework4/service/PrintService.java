package ru.otus.homework4.service;


import ru.otus.homework4.pojo.UserInfo;

import java.util.Map;

public interface PrintService {
    String getPrintResultsAsString(UserInfo userInfo, Map<String, String> questionsToAnswers);
}
