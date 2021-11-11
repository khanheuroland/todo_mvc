package vn.testmaster.ui;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://todomvc.com/examples/angularjs/#/")
public class TODOPAGE extends PageObject {
    public static final Target TASK_INPUT = Target.the("Todo task input")
            .located(By.cssSelector("input.new-todo"));
    public static final Target TASK_ITEMS = Target.the("Inputted Todo Task")
            .located(By.cssSelector("ul.todo-list li label"));
    public static final Target TASK_TO_REMOVE = Target.the("Task to remove with name {0}")
            .locatedBy("//label[text()=\"{0}\"]");
    public static final Target TASK_TO_REMOVE_DELETE = Target.the("Delete button")
            .locatedBy("//label[text()=\"{0}\"]/../button");

}
