import java.io.BufferedReader;
public class RecieveRunnable implements Runnable{
    BufferedReader input;
    public RecieveRunnable(BufferedReader input){
        this.input = input;
    }
    @Override
    public void run(){
        try{
            while(true){
                String message = input.readLine();
                if(message==null){
                    break;
                }
                System.out.println(message);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}