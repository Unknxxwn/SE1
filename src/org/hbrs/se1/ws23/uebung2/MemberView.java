package org.hbrs.se1.ws23.uebung2;

import java.util.ArrayList;

public class MemberView {
    public void dump(ArrayList<Member> memberList) {
        for (Member member : memberList) {
            System.out.println(member.toString());
        }
    }
}
