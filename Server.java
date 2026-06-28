import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server{
    public static void main(String[] args){
        try{
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server Started...");
            System.out.println("Wating for client...");
            Socket socket = server.accept();
            System.out.println("Client Connected!");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            RecieveRunnable recieveRunnable = new RecieveRunnable(input);
            Thread recieveThread = new Thread(recieveRunnable);
            recieveThread.start();
            while(true){
                String message = input.readLine();
                if(message.equals(null)){
                    break;
                }
                else{
                    System.out.println("Client Says : " + message);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}