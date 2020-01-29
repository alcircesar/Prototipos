package br.com.prototipos.tasks;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.prototipos.tasks.controller.TaskController;

public class JUnitControllerTest {

    @Test
    public void testHomeController() {
        TaskController taskController = new TaskController();
        String result = taskController.home();
        assertThat(result, containsString("tasks"));
    }
}