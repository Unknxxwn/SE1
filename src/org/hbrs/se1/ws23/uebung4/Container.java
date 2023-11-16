package org.hbrs.se1.ws23.uebung4;

import org.hbrs.se1.ws23.uebung2.ContainerException;
import java.util.ArrayList;
import java.util.List;

import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;

public class Container {
    PersistenceStrategyStream<UserStory> pStrategyStream = new PersistenceStrategyStream<>();
    List<UserStory> userStoryList = new ArrayList<>();

    /**
     * Die Methode addUserStory() fügt ein UserStory-Objekt in den Container ein
     * 
     * @param userStory
     * @throws ContainerException
     */
    public void addUserStory(UserStory userStory) throws ContainerException {

        for (UserStory userStory1 : userStoryList) {
            if (userStory1.getID() == userStory.getID()) {
                throw new ContainerException(String.format("Das UserStory-Objekt mit der ID %s ist bereits vorhanden!",
                        userStory.getID()));
            }
        }
        userStoryList.add(userStory);

    }

    /**
     * Die Methode deleteUserStory() löscht das userStory-Objekt() mit der
     * angegebenen
     * id aus dem Container
     * 
     * @param id
     * @return
     */
    public String deleteUserStory(int id) {
        for (UserStory userStory : userStoryList) {
            if (userStory.getID() == id) {
                userStoryList.remove(userStory);
                return String.format("Das UserStory-Objekt mit der ID %s wurde gelöscht", id);
            }
        }
        return String.format("Es gibt kein UserStory-Objekt mit der ID %s", id);
    }

    /**
     * Methode size() gibt die anzahl der Objekte im Container wieder
     * 
     * @return
     */
    public Integer size() {
        return userStoryList.size();
    }

    /**
     * Methode store() speichert die Liste der userStory-Objekte in einer Datei ab
     * 
     * @throws Exception
     */
    public void store() throws Exception {
        pStrategyStream.save(userStoryList);
    }

    /**
     * Methoder load() lädt die Liste der userStory-Objekte aus der Datei in den
     * Container
     * 
     * @throws Exception
     */
    public void load() throws Exception {
        userStoryList = pStrategyStream.load();
    }

    public List<UserStory> getCurrentlist() {
        return userStoryList;
    }

    /*
     * Singleton Pattern für den Container
     */
    private static Container instance;

    private Container() {
    }

    /**
     * die Methode sichert das nur ein Container zur Runtime gibt
     * 
     * @return instance
     */
    public static synchronized Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }
}
