package backlog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.TaskList;

/**
 *
 * @author LAPR2-2020-G038
 */
public class TaskList_IO {
public static final String FILE_NAME = "TaskList_IO.tl";
    public TaskList_IO() {

    }

    public TaskList read(String fileName) {
        return read(new File(fileName));
    }

    public TaskList read(File fileName) {
        TaskList taskList;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(fileName));
            try {
                taskList = (TaskList) in.readObject();
            } finally {
                in.close();
            }
            return taskList;
        } catch (IOException | ClassNotFoundException ex) {
            return new TaskList();
        }
    }

    public TaskList read() {
        TaskList taskList;
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(FILE_NAME));
            try {
                taskList = (TaskList) in.readObject();
            } finally {
                in.close();
            }
            
            return taskList;
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("not again");
            return new TaskList();
        }
    }
  
    public boolean write(String fileName, TaskList taskList) {
        return write(new File(fileName), taskList);
    }
    public boolean write(TaskList taskList) {
        return write(new File(FILE_NAME), taskList);
    }

    public boolean write(File fileName, TaskList taskList) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            try {
                System.out.println(taskList);
                System.out.println("I am here");
                out.writeObject(taskList);
            } finally {
                out.flush();
                out.close();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
