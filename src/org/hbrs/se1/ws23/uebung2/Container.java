package org.hbrs.se1.ws23.uebung2;

import java.util.ArrayList;
import java.util.List;

public class Container {

    List<Member> memberList = new ArrayList<Member>();

    public void addMember(Member concretMember) {
        try {
            for (Member member : memberList) {
                if (member.getID() == concretMember.getID()) {
                    throw new ContainerException(String.format("Das Member-Objekt mit der ID %s ist bereits vorhanden!",
                            concretMember.getID()));
                }
            }
            memberList.add(concretMember);

        } catch (ContainerException e) {
            System.out.println(e);
        }
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

    public void dump() {
        for (Member member : memberList) {
            System.out.println(member.toString());
        }
    }

    public Integer size() {
        return memberList.size();
    }
}
