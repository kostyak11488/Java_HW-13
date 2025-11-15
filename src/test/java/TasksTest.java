import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchSimpleTaskWhenQueryInTitle() {
        SimpleTask task = new SimpleTask(1, "Сделать зарядку");
        Assertions.assertTrue(task.matches("зарядку"));
        Assertions.assertFalse(task.matches("Олег"));
    }

    @Test
    public void shouldMatchEpicWhenQueryInSubtasks() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(23, subtasks);

        Assertions.assertTrue(epic.matches("Яйца"));
        Assertions.assertFalse(epic.matches("Сок"));
    }

}
