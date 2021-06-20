package model;

import java.io.Serializable;

/**
 * Create a Task
 *
 * @author LAPR2-2020-G038
 */
public class Task implements Serializable {

    /**
     * ID of the Task
     */
    private String id;
    /**
     * Brief Description of the Task
     */
    private String briefDesc;
    /**
     * Time Duration of the Task (in hours)
     */
    private int timeDuration;
    /**
     * Cost Per Hour of the Task (euros)
     */
    private double costPerHour;
    /**
     * Category of the Task
     */
    private String taskCategory;
      /**
     * Freelancer Responsible For Task : null if does not exist yet
     */
    private Freelancer freelancer;


    /**
     * Creates an instance of Task with the parameters:
     * @param id ID of the Task
     * @param briefDesc Brief Description of the Task
     * @param timeDuration Time Duration of the Task (in hours)
     * @param costPerHour Cost Per Hour of the Task (euros)
     * @param taskCategory Category of the Task
     * @param freelancer Freelancer of The task
     */
    public Task(String id, String briefDesc, int timeDuration, double costPerHour, String taskCategory,Freelancer freelancer) {
        setId(id);
        setBriefDesc(briefDesc);
        setTimeDuration(timeDuration);
        setCostPerHour(costPerHour);
        setTaskCategory(taskCategory);
        this.freelancer=freelancer;
    }

   /**
     * Creates an instance of Task with the parameters:
     * @param id ID of the Task
     * @param briefDesc Brief Description of the Task
     * @param timeDuration Time Duration of the Task (in hours)
     * @param costPerHour Cost Per Hour of the Task (euros)
     * @param taskCategory Category of the Task
     **/
       public Task(String id, String briefDesc, int timeDuration, double costPerHour, String taskCategory) {
        setId(id);
        setBriefDesc(briefDesc);
        setTimeDuration(timeDuration);
        setCostPerHour(costPerHour);
        setTaskCategory(taskCategory);
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the briefDesc
     */
    public String getBriefDesc() {
        return briefDesc;
    }

    /**
     * @return the timeDuration
     */
    public int getTimeDuration() {
        return timeDuration;
    }

    /**
     * @return the costPerHour
     */
    public double getCostPerHour() {
        return costPerHour;
    }

    /**
     * @return the taskCategory
     */
    public String getTaskCategory() {
        return taskCategory;
    }

    /**
     *
     * @return the freelancer
     */
    public Freelancer getFreelancer(){
        return freelancer;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id){
        if (id == null || id.trim().isEmpty()) {
            throw new InputTextInvalidException("Invalid ID");
        }
        this.id = id;
    }

    /**
     * @param briefDesc the briefDesc to set
     */
    public void setBriefDesc(String briefDesc){
        if (briefDesc == null || briefDesc.trim().isEmpty()) {
            throw new InputTextInvalidException("Invalid Brief Description");
        }
        this.briefDesc = briefDesc;
    }

    /**
     * @param timeDuration the timeDuration to set
     */
    public void setTimeDuration(int timeDuration) {
        if (timeDuration <= 0) {
            throw new NumberOutOfLimitsException("Invalid Time Duration");
        }
        this.timeDuration = timeDuration;
    }

    /**
     * @param costPerHour the costPerHour to set
     */
    public void setCostPerHour(double costPerHour) {
        if (costPerHour <= 0) {
            throw new NumberOutOfLimitsException("Invalid Time Duration");
        }
        this.costPerHour = costPerHour;
    }

    /**
     * @param taskCategory the taskCategory to set
     */
    public void setTaskCategory(String taskCategory) {
        if (taskCategory == null || taskCategory.trim().isEmpty()) {
            throw new InputTextInvalidException("Invalid Category of Task");
        }
        this.taskCategory = taskCategory;
    }

    /**
     *
     * @param freelancer the freelancer to set
     */
    public void setFreelancer(Freelancer freelancer){
        this.freelancer=freelancer;
    }
    /**
     * Returns a textual description of the Task
     *
     * @return textual description of the Task
     */
  public String toString() {
        return String.format("Task ID: %s\nBrief Description: %s\nTime Duration(hours): %d\nCost Per Hour (euros): %f\nTask Category:%s\n%s", id, briefDesc, timeDuration, costPerHour, taskCategory,freelancer);
    }

}
