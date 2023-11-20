package org.hbrs.se1.ws23.uebung4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * UserStoryTest
 */
public class UserStoryTest {
    private Container container;
    private UserStory uStory;
    private UserStory uStory1;

    // Testing functionalities of the Container
    @BeforeEach
    void setUp() {
        container = Container.getInstance();
        uStory = new UserStory("t", "t", "t", 0, 1, 1, 1, 1, "t");
        uStory1 = new UserStory("t", "t", "t", 1, 1, 1, 1, 1, "t");
    }

    @Test
    public void isContainerEmpty() {
        try {
            assertEquals(0, container.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddNullStory() {
        try {
            container.addUserStory(null);
            assertEquals(0, container.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddStory() {
        try {
            container.addUserStory(uStory);
            assertEquals(1, container.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testaddTwoStories() {
        try {
            container.addUserStory(uStory);
            container.addUserStory(uStory1);
            assertEquals(2, container.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddAndDeleteStory() {
        try {
            container.addUserStory(uStory);
            container.deleteUserStory(0);
            assertEquals(0, container.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Testing UserStory
    @Test
    public void testCalcOfPrio() {
        // arrange
        UserStory uCalculate = new UserStory(null, null, null, 0, 1, 1, 1, 1, null);
        // act
        // assert
        assertEquals(1, uCalculate.getPrio());
    }

}
