package model;

import backlog.TaskList_IO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Create a TaskList
 *
 * @author LAPR2-2020-G038
 */
public class TaskList implements Serializable {

    /**
     * Task List
     */
    private List<Task> taskList;

    /**
     * Builds a TaskList instance
     */
    public TaskList() {
        taskList = new ArrayList<>();
    }

    public TaskList(List<Task> copy) {
        taskList = new ArrayList<>(copy);
    }

    /**
     * Returns a textual description of the TaskList
     *
     * @return textual description of the TaskList
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (Task pos : getTaskList()) {
            s.append(pos);
            s.append("\n");
        }
        return s.toString().trim();
    }

    /**
     * Check is the list is empty
     *
     * @return true if empty, false if not empty
     */
    public boolean isEmpty() {
        return getTaskList().isEmpty();
    }

    public Task addnewTask(String id, String briefDescription, int timeDuration, double costPerHour, String taskCategory) {
        Task task = new Task(id, briefDescription, timeDuration, costPerHour, taskCategory);
        return task;
    }

    /**
     * Add´s a Task to the TaskList
     *
     * @param task Task to add
     * @return true if the task has been added, otherwise false
     */
    public boolean addTask(Task task) {
        return getTaskList().add(task);
    }

    public boolean validateTask(Task task) {
        return getTaskList().contains(task) ? false : true;
    }

    public Task getTaskById(String id) throws NotFoundException {
        for (Task pos : getTaskList()) {
            if (pos.getId().equalsIgnoreCase(id)) {
                return pos;
            }
        }
        throw new NotFoundException("Not Found!");
    }

    /**
     * @return the taskList
     */
    public List<Task> getTaskList() {
        return taskList;
    }

    /**
     * @param taskList the taskList to set
     */
    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

}
