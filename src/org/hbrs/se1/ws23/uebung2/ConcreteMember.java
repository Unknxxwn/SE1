package org.hbrs.se1.ws23.uebung2;

import java.io.Serializable;

public class ConcreteMember implements Member, Serializable {
    // Attribute
    private int memberId;

    // Konstruktor für Member
    public ConcreteMember(int passedId) {
        this.memberId = passedId;
    }

    @Override
    public Integer getID() {
        return memberId;
    }

    @Override
    public String toString() {
        return String.format("Member (ID %s)", memberId);
    }
}
