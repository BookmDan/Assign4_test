// Daniel Oh
// Performs several methods related to LastFM lists search and relations.

import java.io.*;
import java.util.*;
public class LastFMRecommender implements FMRecommenderInterface {

    private static HashMap<Integer, List<Integer>> userFriends;
    private static HashMap<Integer, List<Integer>> userArtist;

    private static HashMap<Integer, Integer> top10;
//    map = new HashMap<String, List<String>>();
//    top10 = new HashMap<String, List<String>>();


    @Override
    // goes through user_friends.dat
    // returns list from map
    public int[] listFriends(int userId) {

        // create empty arraylist called friendsList
        ArrayList<Integer> friendsList = new ArrayList<>();

        scanUserFriends();
        // goes through iterator and if key = userId
        // add to friendsList array
        Iterator friendsListIterator = userFriends.entrySet().iterator();
        while(friendsListIterator.hasNext()) {
            Map.Entry mapElement
                    = (Map.Entry)hmIterator.next();
            if(mapElement.getKey() == userId) {
                friendsList.add(mapElement.getValue());
            }
            else continue;
        }

        return friendsList;
    }

    /**
     *  prints the user1’s friends in
     * common with user2
     *
     */

    @Override
    public int[]  commonFriends(int user1, int user2){
        // create empty arraylist called commonFriendsList
        ArrayList<Integer> commonFriendsList = new ArrayList<>();

        // new hashmap for user1
        user1Friends = new HashMap<Integer, Integer>();
        // new hashmap for user2
        user2Friends = new HashMap<Integer, Integer>();

        // scans each userId and stores key, value
        user1Friends.put(scanUserFriends(user1));
        user2Friends.put(scanUserFriends(user2));

        // if the value in user1Friends == value in user2Friends, add to commonFrinedslist
        // not sure if this logic is correct
        for(int each: userFriends){
            if (user1Friends.getValue(each) == user2Friends.getValue(each)){
                commonFriendsList.add(user1Friends.getValue());
            }
        }
        return commonFriendsList;
    }

    public void scanUserFriends(userId) throws FileNotFoundException {
        // new hashmap called userFriends
        userFriends = new HashMap<Integer, Integer>();

        // read through user_friends.dat file
        BufferedReader buf = new BufferedReader(new FileReader("user_friends.dat"));
        String lineJustFetched = null;
        String[] wordsArray;

        // split by two columns
        // first is key second is value
        // store in hashmap
        while(true) {
            lineJustFetched = buf.readLine();
            if (lineJustFetched == null) {
                break;
            } else {
                wordsArray = lineJustFetched.split("\t");
                int key = wordsArray[0];
                int value = wordsArray[1];
                userFriends.put(key, value);
            }
        }
    }

    public void scanUserArtists(userId) throws FileNotFoundException {
        // new hashmap called userFriends
        userArtist = new HashMap<Integer, Integer>();

        // read through user_friends.dat file
        BufferedReader buf = new BufferedReader(new FileReader("user_artists.dat"));
        String lineJustFetched = null;
        String[] wordsArray;

        // split by two columns
        // first is key
        // second is artistId
        // store in hashmap
        while(true) {
            lineJustFetched = buf.readLine();
            if (lineJustFetched == null) {
                break;
            } else {
                wordsArray = lineJustFetched.split("\t");
                int key = wordsArray[0];
                int value = wordsArray[1];
                userArtist.put(key, value);
            }
        }
    }
    /**
     *  prints the list of artists listened
     * by both users
     */

    @Override
    public int[] listArtists(int user1, int user2){


        // create empty arraylist called commonArtists
        ArrayList<Integer> commonArtists = new ArrayList<>();

        // new hashmap for user1
        user1Arists = new HashMap<Integer, Integer>();
        // new hashmap for user2
        user2Arists = new HashMap<Integer, Integer>();

        // scans each userId and stores key, value
        user1Arists.put(scanUserArtists(user1));
        user2Arists.put(scanUserArtists(user2));

        // if the value in user1Arists == value in user2Arists, add to commonArtists
        // not sure if this logic is correct
        for(int each: userFriends){
            if (user1Arists.getValue(each) == user2Arists.getValue(each)){
                commonArtists.add(user1Friends.getValue());
            }
        }
        return commonArtists;
    }


    @Override
    // max value using user-artists.dat
    //sort by weight and return list of key: artistId, value: weight
    public int[] listTop10() {
        // create map
        top10 = new HashMap<Integer, Integer>();

        // read through user_friends.dat file
        BufferedReader buf = new BufferedReader(new FileReader("user_artists.dat"));
        String lineJustFetched = null;
        String[] wordsArray;

        // split by two columns
        // first is artistId
        // second is weight or streams / plays
        // store in top10 hashmap
        while (true) {
            lineJustFetched = buf.readLine();
            if (lineJustFetched == null) {
                break;
            } else {
                // stores artist id as key and weight for value
                wordsArray = lineJustFetched.split("\t");
                int key = wordsArray[1];
                int value = wordsArray[2];
                top10.put(key, value);
            }
        }
        // returns sorted key, value and prints
        top10.sortByValue(true);
    }

    public void sortByValue(boolean order)
    {
    //convert HashMap into List
        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(map.entrySet());
    //sorting the list elements
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2)
            {
                if (order)
                {
    //compare two object and return an integer
                    return o1.getValue().compareTo(o2.getValue());}
                else
                {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });
    //prints the sorted HashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        printMap(sortedMap);
    }
    //method for printing the elements
    public void printMap(Map<String, Integer> map)
    {
        System.out.println("Artist\t Number of Streaming Plays ");
        for (Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() +"\t"+entry.getValue());
        }
        System.out.println("\n");
    }

    @Override
    // map of lists -> key: userId, value: list(friendId)
    // use listTop10() to find of user, then update as you progress through friends and updates
    // listTop10() until you reach end of friends of User
    public String[] recommend10(int user){
        // new userFriends map
        userFriends = new HashMap<String, List<String>>();


        //returns list of friends of user and adds to map
        userFriends.put(user, listFriends(user));

        // map of lists -> key: userId, value: list(friendId)
        // update listTop10 as you traverse through map
        // every time it adds to listTop10, it is then sorted through again and produces a new listTop10() and
        // at each iteration prints out the top 10
        for (int each: userFriends) {
            listTop10() = listTop10() + each.listTop10();
        }
        System.out.println("Top 10 most popular artists listened by user and his/her friends:");
        System.out.println(listtop10());
    }
}
