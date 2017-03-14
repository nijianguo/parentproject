package reg.nijg.transfer.notify;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StartUpSocketListener implements StartUpEventListener{
  
	private  Boolean onListened ;
	
	@Override
	public void handleEvent(StartUpEvent event) {
		// TODO Auto-generated method stub
        
		try {
			startSocketListener();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void startSocketListener() throws IOException{
		ServerSocket serverSocket = new ServerSocket(9000);
		while(onListened){
			try {
				Socket socket=serverSocket.accept();
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Object obj = ois.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		serverSocket.close();
	}
	
	
	
	
	
	
}
