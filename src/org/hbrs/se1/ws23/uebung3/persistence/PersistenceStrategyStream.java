package org.hbrs.se1.ws23.uebung3.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import org.hbrs.se1.ws23.uebung2.MemberView;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException.ExceptionType;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E>, Serializable {
    MemberView memberView = new MemberView();
    // URL of file, in which the objects are stored
    private String location = "C://Users//coooc//Desktop//Testing//MemberList.txt";
    File file = new File(location);
    // Stream objects
    private FileInputStream fileIn = null;
    private FileOutputStream fileOut = null;
    private ObjectInputStream objectIn = null;
    private ObjectOutputStream objectOut = null;

    // Backdoor method used only for testing purposes, if the location should be
    // changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try
    // this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and
     * Output-Stream)
     * In case of having problems while opening the streams, leave the code in
     * methods load
     * and save.
     */
    public void openConnection() throws PersistenceException {
        System.out.println("couldnt be implemented due to problems");
    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {
        try {

            if (fileOut != null) {
                fileOut.flush();
                fileOut.close();
            }
            if (objectOut != null) {
                objectOut.close();
            }
            if (fileIn != null) {
                fileIn.close();
            }
            if (objectIn != null) {
                objectIn.close();
            }
        } catch (IOException exception) {
            throw new PersistenceException(ExceptionType.IOException, ":(");
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<E> member) throws PersistenceException {

        try {
            fileOut = new FileOutputStream(location);
            objectOut = new ObjectOutputStream(fileOut);
            if (!file.exists()) {
                file.createNewFile();
            }
            objectOut.writeObject(member);
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new PersistenceException(ExceptionType.IOException, ":(");
        }
        closeConnection();
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */

    @SuppressWarnings("unchecked")
    public List<E> load() throws PersistenceException {
        try {
            fileIn = new FileInputStream(location);
            objectIn = new ObjectInputStream(fileIn);
            return (List<E>) objectIn.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException(ExceptionType.IOException, ":(");
        } finally {
            closeConnection();
        }
        // return null;
    }
}
