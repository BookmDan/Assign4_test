public interface FMRecommenderInterface {

/**
 * This is an interface for music streaming service
 *
 */


    /**
     * prints the list of friends of the given user
     *
     * @return list of int
     */
    int[] listFriends(int userId);

    /**
     *  prints the user1’s friends in
     * common with user2
     *
     * @param list of int
     */

    int[]  commonFriends(int user1, int user2);

    /**
     *  prints the list of artists listened
     * by both users
     *
     * @param list of int
     */

    int[] listArtists(int user1, int user2);

    /**
     *  prints the list of top 10 most popular artists listened by all
     * users
     *
     * @param list of int
     */

    int[] listTop10();
    // user-artists.dat
    /**
     *   recommends 10 most popular artists listened by
     * the given user and his/her friends.
     *
     * @param list of int
     */

    String[] recommend10(int user);
// user-artists.dat

    // artist.dat

}