package model;

import backlog.TaskList_IO;
import java.io.Serializable;

/**
 * Create a Organization
 *
 * @author LAPR2-2020-G038
 */
public class Organization implements Serializable {

    /**
     * Designation of the Organization
     */
    private String designation;

    /**
     * NIF of the Organization
     */
    private String NIF;
    /**
     * Manager of the Organization
     */
    private Manager man;
    /**
     * Collaborator of the Organization
     */
    private Collaborator colab;
    private TaskList taskList;

    /**
     * Builds an Organization instance using parameter her designation
     *
     * @param designation Designation of the Organization
     */
    public Organization(String designation, String NIF) {
        setDesignation(designation);
        setNIF(NIF);
        taskList = new TaskList();
        setTaskList(String.format("%s.tl", NIF));
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @return the NIF
     */
    public String getNIF() {
        return NIF;
    }

    /**
     * @return the man
     */
    public Manager getMan() {
        return new Manager(man);
    }

    /**
     * @return the colab
     */
    public Collaborator getColab() {
        return new Collaborator(colab);
    }

    /**
     * @return the taskList
     */
    public TaskList getTaskList() {
        return taskList;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        if (designation == null || designation.trim().isEmpty()) {
            throw new InvalidDesignationException("Choose another designation for the Organization!");
        }
        this.designation = designation;
    }

    /**
     * @param NIF the NIF to set
     */
    public void setNIF(String NIF) {
        if (NIF == null || NIF.trim().isEmpty()) {
            throw new InputTextInvalidException("Invalid NIF");
        }
        this.NIF = NIF;
    }

    /**
     * @param man the man to set
     */
    public void setMan(Manager man) {
        this.man = new Manager(man);
    }

    /**
     * @param colab the colab to set
     */
    public void setColab(Collaborator colab) {
        this.colab = new Collaborator(colab);
    }

    /**
     * @param taskList the taskList to set
     */
    public void setTaskList(String fileName) {
        TaskList_IO input = new TaskList_IO();
        this.taskList = input.read(fileName);

    }

    /**
     * Returns a textual description of the Organization
     *
     * @return textual description of the Organization
     */
    @Override
    public String toString() {
        return String.format("Organization: %s\nNIF: %s", designation, NIF);
    }

    /**
     * Compare Organization with the object received
     *
     * @param otherObject or object to compare with Organization.
     * @return true if the object received is an equivalent Organization and
     * false otherwise
     */
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        Organization otherOrganization = (Organization) otherObject;
        return designation.equalsIgnoreCase(otherOrganization.designation) && NIF.equalsIgnoreCase(otherOrganization.NIF);
    }

    public Manager newManager(String nameMan, String emailMan) {
        Manager man = new Manager(nameMan, emailMan);
        setMan(man);
        return man;
    }

    public Collaborator newCollaborator(String nameColab, String emailColab) {
        Collaborator colab = new Collaborator(nameColab, emailColab);
        setColab(colab);
        return colab;
    }

    public double costPerHour(Task task) {
        return task.getCostPerHour();
    }

    public int timeDuration(Task task) {
        return task.getTimeDuration();
    }
}
