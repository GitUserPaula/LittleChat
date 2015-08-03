
package littlechat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Connector extends Thread {
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader inputSocket;
    private DataOutputStream output;
    private BufferedReader input;
    final int port = 8180;
    
    public Connector (String ip) {
        try {
        this.s = new Socket (ip,this.port);
        //input of data for reading messages 
        this.inputSocket = new InputStreamReader (s.getInputStream());
        this.input = new BufferedReader (inputSocket);
        //output of data for sending messages
        this.output = new DataOutputStream(s.getOutputStream());
        this.output.writeUTF("Connected- \n");
        
    }catch (Exception e){
        e.printStackTrace();
    }
    }
    public void run (){
        String text;
        while (true){
        try {
            text= input.readLine();
            ClientWindow.jTextArea1.setText(ClientWindow.jTextArea1.getText()+"\n"+text);
        } catch (IOException e ){
            e.printStackTrace();
        }
    }
    }
    public void sendMsg (String msg){
        System.out.println ("Sending");
        try{
        this.output = new DataOutputStream (s.getOutputStream())  ;  
        this.output.writeUTF(msg);
        
    }catch (IOException e) {
        System.out.println("Problem with sending message");
    }
    }
    public String readMsg (String msg){
     try {
         return input.readLine();
     } catch (IOException e){
         e.printStackTrace();
     }
     return null;
    }
    public void disconnect (){
        try {
        s.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            ss.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    
}
