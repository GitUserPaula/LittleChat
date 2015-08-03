
package littlechatserver;

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
    
    public Connector (String name){
        super (name);
    }
    public void sendMsg (String msg){
        try {
            this.output.writeUTF(msg+ "\n");
        } catch (IOException e){
            e.printStackTrace();
        }
        
        }
    public void run (){
        
        String text = "text";
        try {
            this.ss = new ServerSocket (port);
            this.s = ss.accept();
            //reading msg
            this.inputSocket = new InputStreamReader (s.getInputStream());
            this.input = new BufferedReader (inputSocket);
            //sending msg
            this.output = new DataOutputStream (s.getOutputStream());
            while (true){
                text = this.input.readLine();
                System.out.println(text);
                ServerWindow.jTextArea1.setText(ServerWindow.jTextArea1.getText() + "\n" + text);
            }
                      
            
            
        } catch (IOException e ){
            System.out.println("Error");
        }
        }
        public String readMsg (){
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

    void main() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
    
    
    

