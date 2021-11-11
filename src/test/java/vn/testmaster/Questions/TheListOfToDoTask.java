package vn.testmaster.Questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;
import vn.testmaster.ui.TODOPAGE;

import java.util.List;

public class TheListOfToDoTask implements Question<List<String>> {
    public static Question<List<String>> FromToDoTasks() {
        return new TheListOfToDoTask();
    }

    @Override
    @Step("{0} see the list of inputted task in the task list")
    public List<String> answeredBy(Actor actor) {
        return Text.of(TODOPAGE.TASK_ITEMS).viewedBy(actor).asList();
    }
}
