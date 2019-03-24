package ru.otus.homework4.service;

import lombok.extern.slf4j.Slf4j;
import org.jline.reader.LineReader;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ru.otus.homework4.dao.QuizDao;
import ru.otus.homework4.pojo.UserInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class QuizServiceImpl implements QuizService {

    private final QuizDao quizDao;
    private final PrintService printService;
    private final MessageService messageService;
    private final LineReader lineReader;

    public QuizServiceImpl(QuizDao quizDao, PrintService printService, MessageService messageService, @Lazy LineReader lineReader) {
        this.quizDao = quizDao;
        this.printService = printService;
        this.messageService = messageService;
        this.lineReader = lineReader;
    }

    @Override
    public void startQuiz() {
        UserInfo userInfo = collectUserInfo();
        Map<String, String> questionsToAnswers = conductQuiz();
        log.info(printService.getPrintResultsAsString(userInfo, questionsToAnswers));
    }

    private UserInfo collectUserInfo() {
        String firstName = askQuestion(messageService.getMessage("msg.name.first"));
        String lastName = askQuestion(messageService.getMessage("msg.name.last"));
        return new UserInfo(firstName, lastName);
    }

    private Map<String, String> conductQuiz() {
        log.info(messageService.getMessage("msg.answer.questions"));
        List<String> questions = quizDao.getQuestions();
        Map<String, String> questionsToAnswers = new LinkedHashMap<>();
        for (String question : questions) {
            questionsToAnswers.put(question, askQuestion(question));
        }
        return questionsToAnswers;
    }

    private String askQuestion(String question) {
        return this.lineReader.readLine("\n" + question + " > ");
    }
}
