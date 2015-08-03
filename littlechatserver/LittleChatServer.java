
package littlechatserver;


public class LittleChatServer {

     public static Connector server;
     public static Connector client;
    public static void main(String[] args) {
       ServerWindow server = new ServerWindow ();
        server.setVisible(true);
        
    }
    public static void initServer (String ip){
        server = new Connector (ip);
        server.start();
    }  
}
