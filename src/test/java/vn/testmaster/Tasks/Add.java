package vn.testmaster.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import vn.testmaster.ui.TODOPAGE;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Add implements Task {
    public static Performable theListOfTasks(List<String> tasks) {
        return instrumented(Add.class, tasks);
    }

    public Add(List<String> tasks){
        this.todotasks = tasks;
    }

    private List<String> todotasks;

    @Override
    @Step("{0} added the list of todo task are #todotasks")
    public <T extends Actor> void performAs(T actor) {
        for (String task : this.todotasks) {
            actor.attemptsTo(
                    Enter.theValue(task).into(TODOPAGE.TASK_INPUT).thenHit(Keys.ENTER)
            );
        }
    }
}
