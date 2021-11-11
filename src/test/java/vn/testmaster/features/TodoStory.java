package vn.testmaster.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import vn.testmaster.Actions.Refresh;
import vn.testmaster.Questions.TheListOfToDoTask;
import vn.testmaster.Tasks.Add;
import vn.testmaster.Tasks.Remove;
import vn.testmaster.ui.TODOPAGE;

import java.util.Arrays;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@RunWith(SerenityRunner.class)
public class TodoStory {
    @Managed
    WebDriver herDriver;

    public Actor anna = Actor.named("Anna");
    TODOPAGE TodoPage;
    String[] tasks = {"Go to home", "Go to cinema", "Go to swim"};
    String taskToDelete = "Go to cinema";
    String[] tasksAfterDelete = {"Go to home", "Go to swim"};

    //Define ability for anna
    @Before
    public void initStory() {
        anna.can(BrowseTheWeb.with(herDriver));
    }

    @Test
    @Ignore
    public void Should_see_inputted_task_on_list_of_todo_task() {
        anna.wasAbleTo(Open.browserOn().the(TodoPage));
        anna.attemptsTo(
            Add.theListOfTasks(Arrays.asList(this.tasks)),
            Refresh.thePage()
        );
        anna.should(
                seeThat(
                        TheListOfToDoTask.FromToDoTasks(), containsInAnyOrder(tasks))
        );
    }

    @Test
    public void Should_see_remaining_tasks_after_removed_a_task_from_task_list()
    {
        anna.wasAbleTo(Open.browserOn().the(TodoPage));
        anna.attemptsTo(
            Remove.theTask(this.taskToDelete).fromList(Arrays.asList(this.tasks))
        );
        anna.should(
            seeThat(
                TheListOfToDoTask.FromToDoTasks(), containsInAnyOrder(this.tasksAfterDelete))
        );
    }

}
