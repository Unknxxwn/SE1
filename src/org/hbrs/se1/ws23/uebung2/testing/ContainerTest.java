package org.hbrs.se1.ws23.uebung2.testing;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.junit.jupiter.api.Test;

/**
 * ContainerTest
 */
public class ContainerTest {

    @Test
    public void aPositiveTest_addMember_doesItaddaMember() {
        // arrange
        Container container = new Container();
        ConcreteMember conMember = new ConcreteMember(1);
        // act
        container.addMember(conMember);
        // assert
        assertEquals(1, conMember.getID());
    }

    @Test
    public void aNegativeTest_addMember_doesIThrow() {
        // arrange
        Container container = new Container();
        ConcreteMember conMember = new ConcreteMember(1);
        ConcreteMember conMember1 = new ConcreteMember(1);
        // act
        container.addMember(conMember);

        // arrange
        // cant get the asserthrows to work:
        // The method assertThrows(Class<ContainerException>, ThrowingRunnable) is
        // ambiguous for the type ContainerTest
        // assertThrows(ContainerException.class, container.addMember(conMember1));
    }

    @Test
    public void aPositiveTest_deleteMember() {
        // arrange
        Container container = new Container();
        ConcreteMember conMember = new ConcreteMember(1);
        ConcreteMember conMember1 = new ConcreteMember(2);
        // act
        container.addMember(conMember);
        container.addMember(conMember1);
        container.deleteMember(2);
        // assert
        assertEquals(1, container.size());
    }

    @Test
    public void aPositiveTest_2deleteMember() {
        // arrange
        Container container = new Container();
        ConcreteMember conMember = new ConcreteMember(1);
        ConcreteMember conMember1 = new ConcreteMember(2);
        // act
        container.addMember(conMember);
        container.addMember(conMember1);
        container.deleteMember(2);
        container.deleteMember(1);
        // assert
        assertEquals(0, container.size());
    }

    @Test
    public void aPositiveTestWithEmptyContainer_deleteMember() {
        // arrange
        Container container = new Container();
        ConcreteMember conMember = new ConcreteMember(1);
        container.addMember(conMember);
        // act

        // assert
        assertEquals(String.format("Das Member-Objekt mit der ID %s wurde gelöscht", conMember.getID()),
                container.deleteMember(1));
    }

    @Test
    public void aNegativeTest_deleteMember() {
        // arrange
        Container container = new Container();
        ConcreteMember conMember = new ConcreteMember(1);
        container.addMember(conMember);
        // act
        container.deleteMember(1);
        // assert
        assertEquals(String.format("Es gibt kein Member-Objekt mit der ID %s", conMember.getID()),
                container.deleteMember(1));
    }

    @Test
    public void aPositiveTest_dump() {
        // arrange
        Container container = new Container();
        ConcreteMember conMember = new ConcreteMember(1);
        container.addMember(conMember);
        // act
        // assert
        assertEquals(String.format("Member (ID %s)", conMember.getID()), conMember.toString());
    }

    @Test
    public void aPositiveTest_size() {
        // arrange
        Container container = new Container();
        ConcreteMember conMember = new ConcreteMember(1);
        container.addMember(conMember);
        // act
        // assert
        assertEquals(1, container.size());
    }

    @Test
    public void aPositiveTestWith0_size() {
        // arrange
        Container container = new Container();
        ConcreteMember conMember = new ConcreteMember(1);
        // act
        // assert
        assertEquals(0, container.size());
    }

    @Test
    public void aPositiveTestWithAddDeleteMember_size() {
        // arrange
        Container container = new Container();
        ConcreteMember conMember = new ConcreteMember(1);
        // act
        container.addMember(conMember);
        container.deleteMember(1);
        // assert
        assertEquals(0, container.size());
    }
}
