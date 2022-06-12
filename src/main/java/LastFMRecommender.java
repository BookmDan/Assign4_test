// Daniel Oh
// Performs several methods related to LastFM lists search and relations.

import java.io.*;
import java.util.*;
public class LastFMRecommender implements FMRecommenderInterface {
    @Override
    public int[] listFriends(int user) {
        //
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

    public void scanMethod(String file) throws FileNotFoundException {

        try{
            BufferedReader buf = new BufferedReader(new FileReader(file));
            ArrayList<String> words = new ArrayList<>();
            String lineJustFetched = null;
            String[] wordsArray;

            while(true){
                lineJustFetched = buf.readLine();
                if(lineJustFetched == null){
                    break;
                }else{
                    wordsArray = lineJustFetched.split("\t");
                    for(String each : wordsArray){
                        if(!"".equals(each)){
                            words.add(each);
                        }
                    }
                }
            }

            for(String each : words){
                System.out.println(each);
            }

            buf.close();

        }catch(Exception e){
            e.printStackTrace();
        }


        Scanner scanner = new Scanner(new File(file));
        int[] data = new int[100000];
        int i = 0;
        while (scanner.hasNextInt()) {
            data[i++] = scanner.nextInt();

            //System.out.println(data[i]);

            scanner.close();
        }
    }
// user-artists.dat

    // artist.dat

}
