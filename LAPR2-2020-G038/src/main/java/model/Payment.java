/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author LAPR2-2020-G038
 */
    public class Payment implements Serializable {

    private String ExecutionDealy;
    private String ExecutionFinishDate;
    private String ExecutionBriefDescription;
    private Task task;
    private Freelancer free;

    public Payment (){
    }
    public Payment (String ExecutionDealy , String ExecutionFinishDate ,String ExecutionBriefDescription , Task task, Freelancer free){
    setExecutionDealy(ExecutionDealy);
    setExecutionFinishDate(ExecutionFinishDate);    
    setTask(task);
    setFree(free);
    setExecutionBriefDescription(ExecutionBriefDescription);
    }
    public double getAmmountCash() {
        
        if (free.getLevelExpert().toString() == "senior") {
           
            return (task.getTimeDuration() * task.getCostPerHour()) * 2;
        }

        return (task.getTimeDuration() * task.getCostPerHour());
    }
    
    @Override
    public String toString(){
        return String.format(task.getId()+" ; "+task.getBriefDesc()+" ; "+task.getCostPerHour()+" ; "+task.getTaskCategory()+" ; "+ExecutionFinishDate+" ; "+ExecutionDealy+" ; "+ExecutionBriefDescription+" ; "+" ; "+free.getId()+" ; "+free.getName()+" ; "+free.getLevelExpert()+" ; "+free.getEmail()+" ; "+free.getNIF()+" ; "+free.getIBAN()+" ; "+free.getAdress()+" ; "+free.getCountry());
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

    /**
     * @return the free
     */
    public Freelancer getFree() {
        return free;
    }

    /**
     * @param free the free to set
     */
    public void setFree(Freelancer free) {
        this.free = free;
    }

    /**
     * @return the ExecutionDealy
     */
    public String getExecutionDealy() {
        return ExecutionDealy;
    }

    /**
     * @param ExecutionDealy the ExecutionDealy to set
     */
    public void setExecutionDealy(String ExecutionDealy) {
        this.ExecutionDealy = ExecutionDealy;
    }

    /**
     * @return the ExecutionFinishDate
     */
    public String getExecutionFinishDate() {
        return ExecutionFinishDate;
    }

    /**
     * @param ExecutionFinishDate the ExecutionFinishDate to set
     */
    public void setExecutionFinishDate(String ExecutionFinishDate) {
        this.ExecutionFinishDate = ExecutionFinishDate;
    }

    /**
     * @return the ExecutionBriefDescription
     */
    public String getExecutionBriefDescription() {
        return ExecutionBriefDescription;
    }

    /**
     * @param ExecutionBriefDescription the ExecutionBriefDescription to set
     */
    public void setExecutionBriefDescription(String ExecutionBriefDescription) {
        this.ExecutionBriefDescription = ExecutionBriefDescription;
    }
}
