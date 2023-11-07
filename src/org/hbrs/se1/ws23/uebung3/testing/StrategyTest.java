package org.hbrs.se1.ws23.uebung3.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung2.Member;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.Test;

public class StrategyTest<E> {
    private Container container = Container.getInstance();
    private Container container2 = Container.getInstance();

    Member conMember = new ConcreteMember(1);
    Member conMember2 = new ConcreteMember(2);

    @Test
    public void test1() {
        if (container == container2) {
            return;
        }
        throw new IllegalArgumentException();
    }

    @Test // (expected = UnsupportedOperationException.class)
    public void persStrategyMongoException() {
        try {
            PersistenceStrategy<E> pStrategy = new PersistenceStrategyMongoDB<>();
            pStrategy.openConnection();
        } catch (PersistenceException exception) {
            exception.printStackTrace();
        } catch (UnsupportedOperationException exception) {
            return;
        }
    }

    @Test
    public void testAufFalscheLocation() {
        try {
            PersistenceStrategyStream<E> pStrategy = new PersistenceStrategyStream<E>();
            pStrategy.setLocation("C:/NOTAGOODPATH");
            pStrategy.openConnection();
            throw new IllegalArgumentException();
        } catch (PersistenceException exception) {
            return;
        }

    }

    @Test
    public void roundTripTest() {
        try {
            container.addMember(conMember);
            assertEquals(container.size(), 1);
            container.store();
            container.deleteMember(1);
            assertEquals(container.size(), 0);
            container.load();
            assertEquals(container.size(), 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
