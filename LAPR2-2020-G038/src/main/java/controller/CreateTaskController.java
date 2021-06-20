package controller;

import backlog.TaskList_IO;
import model.Collaborator;
import model.NotFoundException;
import model.Organization;
import model.Platform;
import model.RegistOfOrganization;
import model.Task;
import model.TaskList;

/**
 *
 * @author LAPR2-2020-G038
 */
public class CreateTaskController {

    private RegistOfOrganization rOO;
    private Organization org;
    private TaskList tl;
    private Task task;

    public void startProcessOfAddTask(Collaborator colab) throws NotFoundException {
      
        setrOO(Platform.getRegistOfOrganization());
        setOrg(getrOO().getOrganizationByEmailCollaborator(colab.getEmail()));
        setTl(getOrg().getTaskList());
    }

     public void addNewTask(String id, String briefDescription, int timeDuration, double costPerHour, String taskCategory) {
        setTask(getTl().addnewTask(id, briefDescription, timeDuration, costPerHour, taskCategory));
        getTl().validateTask(getTask());
        getTl().addTask(task);
    }

    public boolean registsTask() {
        boolean validate = getTl().validateTask(getTask());
        if (validate) {
            boolean check = getTl().addTask(getTask());
            if (check) {
                TaskList_IO output = new TaskList_IO();
                check = output.write(String.format("%s.tl", getOrg().getNIF()), getTl());
                return check;
            }

        }
        return false;
    }

    /**
     * @return the rOO
     */
    public RegistOfOrganization getrOO() {
        return rOO;
    }

    /**
     * @param rOO the rOO to set
     */
    public void setrOO(RegistOfOrganization rOO) {
        this.rOO = rOO;
    }

    /**
     * @return the org
     */
    public Organization getOrg() {
        return org;
    }

    /**
     * @param org the org to set
     */
    public void setOrg(Organization org) {
        this.org = org;
    }

    /**
     * @return the tl
     */
    public TaskList getTl() {
        return tl;
    }

    /**
     * @param tl the tl to set
     */
    public void setTl(TaskList tl) {
        this.tl = tl;
    }

    /**
     * @return the task
     */
    public Task getTask() {
        return task;
    }

    /**
     * @param task the task to set
     */
    public void setTask(Task task) {
        this.task = task;
    }

}
