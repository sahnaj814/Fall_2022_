package day2_10022;

import java.util.ArrayList;

public class T3_ForLoop_ArrayList {


    public static void main(String[] args) {
        //declare and define the arraylist for zip code
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11218");
        zipCode.add("10001");
        zipCode.add("11219");
        zipCode.add("11377");
        zipCode.add("10002");
        zipCode.add("11217");
        zipCode.add("11376");
        //call for loop to print out zip code values from the array list

        //if you want to control the end pont by number, the put actual number instead of zipcode.size()
        for (int i=0; i < zipCode.size(); i++){
            //print out each zipcode automatically
            System.out.println("zip code: " + zipCode.get(i));

        }//end of loop

    }//end of for main
}//end of jav class
