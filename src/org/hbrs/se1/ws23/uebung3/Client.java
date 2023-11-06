package org.hbrs.se1.ws23.uebung3;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung2.MemberView;

public class Client {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        MemberView memberView = new MemberView();
        Container container = Container.getInstance();
        ConcreteMember conMember = new ConcreteMember(0);
        ConcreteMember conMember1 = new ConcreteMember(1);
        ConcreteMember conMember2 = new ConcreteMember(2);
        container.addMember(conMember);
        container.addMember(conMember1);
        container.addMember(conMember2);
        container.store();
        memberView.dump(container.getCurrentlist());
        Main.main(args);
    }
}
