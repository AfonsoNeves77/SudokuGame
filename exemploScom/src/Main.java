import java.io.*;
import java.net.Socket;
import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {

        String k = "Okay I am bored so bored so fu bored !!";

        System.out.println(stringAnonimizer(k,"Okay"));
        stringRepeater(stringCounter(k,"Okay"));

        /*System.out.write(8);
        System.out.flush();*/

        /*for(int i = 0; i < 127; i++){
            System.out.write(i);
        }
        System.out.flush();

        String byteArray = "Afonso is cool";
        byte[] data = byteArray.getBytes();
        System.out.write(data);

        int[] data = new int[10];

        for (int i = 0; i < data.length; i++){
            data[i] = System.in.read();
        }
        System.out.println("Print --> ");

        for(int i = 0; i < data.length; i++){
            System.out.write(data[i]);
        }
        System.out.flush();


        InputStream inputStream = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\t.txt");

        while(true){
            int datas = inputStream.read();
            if(datas == -1){
                System.out.println("\n In IDE text --> End");
                break;
            }
            else {
                System.out.write(datas);

            }
        }*/

        //FileStreams
        //FileInputStream inputStream = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\t.txt");
        /*for(int n = inputStream.read(); n != -1; n = inputStream.read()){
            System.out.write(n);
        }
        System.out.flush();*/

        //byte[] data = inputStream.readAllBytes();
        //System.out.write(data);

        /*FileOutputStream out = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\t.txt",true);
        while(true){
            int input = System.in.read();
            if(input == 10){
                break;
            }else{
                out.write(input);

            }
        }
        System.out.flush();*/

        //FileInputStream inputStream = new FileInputStream("C:\\Users\\ADMIN\\Desktop\\t.txt");

        /*FileOutputStream out = new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\copyFile.txt",true);
        while(true){

           int input = System.in.read();
            if(input == 'X'){
                break;
            }
            out.write(input);

        }
        System.out.flush();



        //byte[] dataToBeCopied = inputStream.readAllBytes();
        //out.write(dataToBeCopied);

        */

    }
    public static void stringRepeater(int x){
        for(int i = 0; i < x; i++){
            System.out.println("I love Socket programming!!");
        }
    }

    public static String stringAnonimizer(String phrase, String toBeAnon){
        String[] phraseArray = phrase.split(" ");
        for(int i = 0; i < phraseArray.length; i++){
            if(phraseArray[i].equals(toBeAnon)){
              phraseArray[i] = wordAnonimizer(phraseArray[i]);

            }
        }
        return String.join(" ",phraseArray);

    }

    public static String wordAnonimizer(String word){
        char[] wordArray = new char[word.length()];
        for(int i = 0; i < word.length(); i++){
           wordArray[i] = word.charAt(i);
        }
        Arrays.fill(wordArray, 'X');
        return String.valueOf(wordArray);
    }


    public static int stringCounter(String phrase, String toBeAnon){
        int index = 0;
        String[] phraseArray = phrase.split(" ");
        for(int i = 0; i < phraseArray.length; i++){
            if(phraseArray[i].equals(toBeAnon)){
                index++;
            }
        }
        return index;
    }
}