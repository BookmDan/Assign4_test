
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;
import LastFMRecommender.java;

public class LastFMRecommenderTest {

//    private LastFMRecommenderTest manipulatedstring;
//
//    @BeforeEach
//    public void setUp() {
//        manipulatedstring = new StringManipulation();
//    }
//
//    @AfterEach
//    public void tearDown() {
//        manipulatedstring = null;
//    }

    @Test
    public void test1() {
        int[] friendsTest = {275, 428, 515, 761, 831, 909, 1209, 1210, 1230, 1327, 1585, 1625, 1869};
        assertEquals(listFriends(2), friendsTest);
    }

    @Test
    public void connectionsTest() {
        int[] user2 = {275, 428, 515, 761, 831, 909, 1209, 1210, 1230, 1327, 1585, 1625, 1869};
        int[] user3 = {275, 255, 460, 837, 1740, 1801, 1975};
        assertEquals(commonFriends(2, 3), 275);
    }
}