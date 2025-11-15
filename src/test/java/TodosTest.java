import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TodosTest {

    @Test
    public void shouldSearchTasksWhenQueryMatches() {

        SimpleTask simpleTask = new SimpleTask(1, "Купить Хлеб");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555, "Обсуждение", "Проект Хлеб", "завтра");


        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("Хлеб");

        Assertions.assertEquals(3, result.length);
    }
    @Test
    public void shouldFindOnlyOneTask() {
        SimpleTask task1 = new SimpleTask(1, "Позвонить маме");
        SimpleTask task2 = new SimpleTask(2, "Написать другу");

        Todos todos = new Todos();
        todos.add(task1);
        todos.add(task2);

        Task[] result = todos.search("маме");

        Assertions.assertEquals(1, result.length);
        Assertions.assertEquals(task1, result[0]);
    }

    @Test
    public void shouldFindTasksFromDifferentTypes() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить Молоко");
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Meeting meeting = new Meeting(555, "Обсуждение Молоко", "Проект", "завтра");

        Todos todos = new Todos();
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] result = todos.search("Молоко");

        Assertions.assertEquals(3, result.length);
    }
}
