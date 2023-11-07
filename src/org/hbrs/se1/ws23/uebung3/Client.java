package org.hbrs.se1.ws23.uebung3;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung2.MemberView;

public class Client {

    public static void main(String[] args) throws Exception {
        MemberView memberView = new MemberView();
        Container container = Container.getInstance();
        ConcreteMember conMember = new ConcreteMember(0);
        ConcreteMember conMember1 = new ConcreteMember(1);
        ConcreteMember conMember2 = new ConcreteMember(2);
        container.addMember(conMember);
        container.addMember(conMember1);
        container.addMember(conMember2);
        System.out.println("to see if list is not empty :)");
        memberView.dump(container.getCurrentlist());
        System.out.println("container.store()");
        container.store();
    }
}
