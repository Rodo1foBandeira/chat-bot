import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import com.server.Server.IChat;


public class main {

	public static void main(String[] args) {
		try {	
			IChat objChat = (IChat) Naming.lookup("rmi://localhost:8282/chat");
			
			String ultimaMensagem = "";
			while (!ultimaMensagem.equals("Xau")){				
				ultimaMensagem = objChat.retrieveMessage();				
				objChat.sendMessage(JOptionPane.showInputDialog(ultimaMensagem));
			}			
			
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(RemoteException e) {
			e.printStackTrace();
		} catch(NotBoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
