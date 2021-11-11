package vn.testmaster.Tasks;

import com.openhtmltopdf.simple.extend.form.FormFieldState;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import vn.testmaster.Actions.Refresh;
import vn.testmaster.ui.TODOPAGE;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Remove implements Task {
    String taskToRemove;
    List<String> taskList;

    public static RemoveBuilder theTask(String taskToDelete) {
        return new RemoveBuilder(taskToDelete);
    }

    public Remove(String taskToRemove, List<String> lstTasks)
    {
        this.taskToRemove = taskToRemove;
        this.taskList = lstTasks;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Add.theListOfTasks(this.taskList),
            MoveMouse.to(TODOPAGE.TASK_TO_REMOVE.of(this.taskToRemove)),
            Click.on(TODOPAGE.TASK_TO_REMOVE_DELETE.of(this.taskToRemove)),
            Refresh.thePage()
        );
    }

    public static class RemoveBuilder
    {
        private String taskToRemove;
        public RemoveBuilder(String taskToRemove)
        {
            this.taskToRemove = taskToRemove;
        }

        public Performable fromList(List<String> listTasks) {
            return instrumented(Remove.class, taskToRemove, listTasks);
        }
    }
}
