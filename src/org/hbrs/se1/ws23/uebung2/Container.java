package org.hbrs.se1.ws23.uebung2;

import java.util.ArrayList;
import java.util.List;

public class Container {

    List<Member> memberList = new ArrayList<Member>();

    public void addMember(Member concretMember) throws ContainerException {

        for (Member member : memberList) {
            if (member.getID() == concretMember.getID()) {
                throw new ContainerException(String.format("Das Member-Objekt mit der ID %s ist bereits vorhanden!",
                        concretMember.getID()));
            }
        }
        memberList.add(concretMember);

    }

    public String deleteMember(int id) {
        for (Member member : memberList) {
            if (member.getID() == id) {
                memberList.remove(member);
                return String.format("Das Member-Objekt mit der ID %s wurde gelöscht", id);
            }
        }
        return String.format("Es gibt kein Member-Objekt mit der ID %s", id);
    }

    public Integer size() {
        return memberList.size();
    }

    public void store() throws Exception {

    }

    public void load() throws Exception {

    }

    // Singleton Pattern
    private static Container instance;

    private Container() {
    }

    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }
}
