package Day4_100922;

public class T1_SplitCommand {
    public static void main(String[] args) {
        //declare a string variable
        String message = "My name is John";
        //extract out john from the string and print it
        //call split message by using and print it
        String[] splitMessage = message.split(" ");
        System.out.println("result:"+ splitMessage[3]);

        //extracting each character from a string
        String message2 = "abc";
        String[] splitMesage2 = message2.split("");
        System.out.println("Index 2 is: "+ splitMesage2[1]);

    } // end of main
}// end of java class
