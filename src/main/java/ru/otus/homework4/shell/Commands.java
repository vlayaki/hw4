package ru.otus.homework4.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.homework4.service.QuizService;

@ShellComponent
public class Commands {

    @Autowired
    QuizService quizService;

    @ShellMethod(value = "Starts quiz", key = "start")
    public void startQuiz(){
        quizService.startQuiz();
    }
}
