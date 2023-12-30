import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPEcho {

    private Socket socket;

    public TCPEcho(String host, int port){
        socket = null;

        try{
            socket = new Socket(host, port);
        }catch(UnknownHostException e){
            System.err.println("Server not found " + e.getMessage());
        }catch (IOException e){
            System.out.println("I/O error: " + e.getMessage());
        }
    }

    public void sendData(String a, String b){
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter data to the server:");

                StringBuilder dataToSend = new StringBuilder();

                // Solicitar e concatenar o endereço do servidor
                System.out.print("Enter server name or IP address: ");
                a = stdin.readLine();
                dataToSend.append(a.append("\n"));

                // Solicitar e concatenar a porta
                System.out.print("Enter port: ");
                dataToSend.append(stdin.readLine()).append("\n");

                // Solicitar e concatenar a string
                System.out.print("Enter string: ");
                dataToSend.append(stdin.readLine()).append("\n");

                // Solicitar e concatenar a palavra-chave
                System.out.print("Enter keyword: ");
                dataToSend.append(stdin.readLine()).append("\n");

                // Enviar a string concatenada para o servidor
                out.println(dataToSend);

                // Aguardar e imprimir resposta do servidor
                System.out.println(in.readLine());

            System.out.println("Closing client...");
            in.close();
            out.close();
            stdin.close();
            socket.close();
        }catch(UnknownHostException l){
                System.err.println("Server not found " + l.getMessage());
        }catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }


    public static void main(String[] args){

        int port = Integer.parseInt(args[1]);
        if(port >= 1024 && port <= 49151){
            TCPEcho clientSide = new TCPEcho(args[0],port);
            clientSide.sendData(args[2],args[3]);
        }else {
            System.err.println("“Invalid port number. \n" +
                    "Terminating!");
            System.exit(1);
        }


    }





}
