package org.hbrs.se1.ws23.uebung4;

import java.util.List;

public class UserStoryView {

    public void dump(List<UserStory> userStoryList) {
        for (UserStory userStory : userStoryList) {
            System.out.println(userStory.toString());
        }
    }

}
