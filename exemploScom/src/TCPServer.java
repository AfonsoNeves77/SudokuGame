import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TCPServer {

    private ServerSocket socket;

    public TCPServer(int port){
       socket = null;
        try {
            socket = new ServerSocket(port);
        }catch (IOException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void connectionToServer(){

        Socket clientSocket = null;

        while(true){
            try{
                clientSocket = socket.accept();
                System.out.println("Connected to " + clientSocket.getInetAddress().getHostAddress() + "  " + clientSocket.getPort());
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                String inputLine;

                while((inputLine = in.readLine()) != null) {
                    String[] parts = inputLine.split("\n", 4);
                    if (parts.length == 2) {

                        String originalString = parts[2];
                        String keyword = parts[3];

                        // Replace occurrences of the keyword
                        String modifiedString = originalString.replace(keyword, "XXXXXX");

                        // Print the modified string
                        System.out.println(modifiedString);

                        // Respond to the client
                        out.println(modifiedString);
                    } else {
                        out.println("Invalid input format. Please provide the required input.");
                    }
                }

                System.out.println("Client exiting...");
                in.close();
                out.close();
                clientSocket.close();

            }catch (IOException e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }


        }

    }

    public void stringRepeater(int x){
        for(int i = 0; i < x; i++){
            System.out.println("I love Socket programming!!");
        }
    }

    public String stringAnonimizer(String phrase, String toBeAnon){
        String[] phraseArray = phrase.split(" ");
        for(int i = 0; i < phraseArray.length; i++){
            if(phraseArray[i].equals(toBeAnon)){
                phraseArray[i] = wordAnonimizer(phraseArray[i]);

            }
        }
        return String.join(" ",phraseArray);

    }

    public String wordAnonimizer(String word){
        char[] wordArray = new char[word.length()];
        for(int i = 0; i < word.length(); i++){
            wordArray[i] = word.charAt(i);
        }
        Arrays.fill(wordArray, 'X');
        return String.valueOf(wordArray);
    }


    public int stringCounter(String phrase, String toBeAnon){
        int index = 0;
        String[] phraseArray = phrase.split(" ");
        for(int i = 0; i < phraseArray.length; i++){
            if(phraseArray[i].equals(toBeAnon)){
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args ){
        if(args.length < 1){
            System.err.println("ERRO");
        }

        int port = Integer.parseInt(args[0]);

        TCPServer serverSide = new TCPServer(port);

        serverSide.connectionToServer();
    }

}
