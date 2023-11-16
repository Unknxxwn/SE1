package org.hbrs.se1.ws23.uebung4;

public class UserStory {
    // Bestandteile der UserStory
    private String projekt;
    private String titel;
    private String userstory;
    private int id;
    private int mehrwert;
    private int strafe;
    private int risiko;
    private double prio;
    private String epic;
    private int aufwand;

    /*
     * Konstruktor für das UserStory-Objekt
     */
    public UserStory(String projekt, String titel, String userstory, int id, int aufwand, int mehrwert, int strafe,
            int risiko,
            double prio,
            String epic) {
        this.titel = titel;
        this.userstory = userstory;
        this.projekt = projekt;
        this.id = id;
        this.mehrwert = mehrwert;
        this.strafe = strafe;
        this.risiko = risiko;
        this.prio = prio;
        this.epic = epic;
        this.aufwand = aufwand;
    }

    // getter Methoden
    public String getProjekt() {
        return projekt;
    }

    public String getTitel() {
        return titel;
    }

    public String getUserStory() {
        return userstory;
    }

    public int getID() {
        return id;
    }

    public int getMehrwert() {
        return mehrwert;
    }

    public int getStrafe() {
        return strafe;
    }

    public int getRisiko() {
        return risiko;
    }

    public double getPrio() {
        return prio;
    }

    public String getepic() {
        return epic;
    }

    public double getAufwand() {
        return aufwand;
    }

    // setter methoden

    public void setProjekt(String projekt) {
        this.projekt = projekt;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setUserStory(String userstory) {
        this.userstory = userstory;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setMehrwert(int mehrwert) {
        this.mehrwert = mehrwert;
    }

    public void setStrafe(int strafe) {
        this.strafe = strafe;
    }

    public void setRisiko(int risiko) {
        this.risiko = risiko;
    }

    public void setPrio(double prio) {
        this.prio = prio;
    }

    public void setEpic(String epic) {
        this.epic = epic;
    }

    public void setAufwand(int aufwand) {
        this.aufwand = aufwand;
    }
}
