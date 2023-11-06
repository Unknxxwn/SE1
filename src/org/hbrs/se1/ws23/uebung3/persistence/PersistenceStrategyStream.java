package org.hbrs.se1.ws23.uebung3.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.hbrs.se1.ws23.uebung2.MemberView;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException.ExceptionType;

public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {
    MemberView memberView = new MemberView();
    // URL of file, in which the objects are stored
    private String location = "C://Users//coooc//Desktop//Testing//MemberList.txt";
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
        try {
            fileIn = new FileInputStream(location);
            fileOut = new FileOutputStream(location);
            objectIn = new ObjectInputStream(fileIn);
            objectOut = new ObjectOutputStream(fileOut);

        } catch (IOException exception) {
            throw new PersistenceException(ExceptionType.IOException, ":(");
        }

    }

    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {
        try {

            fileIn.close();
            //
            fileOut.flush();
            fileOut.close();
            //
            objectIn.close();
            //
            objectOut.flush();
            objectOut.close();
        } catch (Exception exception) {
            throw new PersistenceException(ExceptionType.IOException, ":(");
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<E> member) throws PersistenceException {
        openConnection();
        try {
            objectOut.writeObject(member);
        } catch (Exception exception) {
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

        openConnection();

        Object obj;
        try {
            obj = objectIn.readObject();

        } catch (Exception e) {
            throw new PersistenceException(ExceptionType.IOException, ":(");
        }

        if (obj instanceof List<?>) {
            List<E> newListe = (List<E>) obj;
            return newListe;
        }

        closeConnection();
        return null;
    }
}
