
package littlechat;


public class LittleChatClient {

    public static Connector server;
    public static Connector client;
    public static void main(String[] args) {
       
        ClientWindow client = new ClientWindow ();
        client.setVisible(true);
        
    }
    public static void initClient (String ip){
        client = new Connector (ip);
        client.start();
    }
}
