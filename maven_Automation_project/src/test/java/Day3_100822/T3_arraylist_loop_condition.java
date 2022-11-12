package Day3_100822;



import java.util.ArrayList;

public class T3_arraylist_loop_condition {
    public static void main(String[] args) {
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("Bangladesh");
        countries.add("India");
        countries.add("Australia");

        //iterate through the Arraylist and only print if the country is USA or Australia

        for (int i = 0; i<countries.size();i++){
            /*
            if(countries.get(i)=="USA"){
                System.out.println("Country is USA");
            }
            else if(countries.get(i)== "Australia"){
                System.out.println("Country is Australia");
            }
         */
            if(countries.get(i)=="USA" || countries.get(i)=="Australia"){//simpler version
                System.out.println("Country is "+countries.get(i));
            }
        }
    }


}// end of java class
