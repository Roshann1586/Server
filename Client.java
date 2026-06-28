import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class Client{
    public static void main(String[] args){
        try{
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to Server!");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            RecieveRunnable recieveRunnable = new RecieveRunnable(input);
            Thread recieveThread = new Thread(recieveRunnable);
            recieveThread.start();
            while(true){
                String message = sc.nextLine();
                System.out.println("You : " + message);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}