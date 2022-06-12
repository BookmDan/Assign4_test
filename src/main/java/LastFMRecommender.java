//
//package main.java;


import java.io.*;
import java.util.*;

public class LastFMRecommender implements FMRecommenderInterface {
    @Override
    public int[] listFriends(int user) {
        return null;
    }

    /**
     *  prints the user1’s friends in
     * common with user2
     *
     */

    @Override
    public int[]  commonFriends(int user1, int user2){
        return null;
    }

    /**
     *  prints the list of artists listened
     * by both users
     */

    @Override
    public int[] listArtists(int user1, int user2){
        return null;
    }


    @Override
    public int[] listTop10(){
        return null;
    }
    // user-artists.dat

    @Override
    public String[] recommend10(int user){
        return null;
    }
// user-artists.dat

    // artist.dat

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("user_friends.dat"));
        int[] data = new int[100];
        int i = 0;
        while (scanner.hasNextInt()) {
            data[i++] = scanner.nextInt();

            System.out.println(data[i]);

            scanner.close();
        }
    }
}
