import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import com.server.Server.IChat;


public class main {	

	public static void main(String[] args) {
		try {	
			IChat objChat = (IChat) Naming.lookup("rmi://localhost:8282/chat");
			
			JButton botaoEntrar = new JButton("Entrar");
			JButton botaoSair = new JButton("Sair");
			
			TextField caixaEnvio = new TextField();
			caixaEnvio.setPreferredSize(new Dimension(800,25));
			
			JTextArea mensagens = new JTextArea();
			mensagens.setPreferredSize(new Dimension(800,300));
			//mensagens.setEnabled(false);

			JPanel painel = new JPanel();
			painel.setPreferredSize(new Dimension(800,600));
			
			painel.add(mensagens);
			painel.add(caixaEnvio);
			painel.add(botaoEntrar);
			painel.add(botaoSair);
			
			
			KeyAdapter enviarMsg = new KeyAdapter() {
			      
			      public void keyPressed(KeyEvent e) {
			    	  try {
			    		  if(e.getKeyCode() == e.VK_ENTER){  
				    		  objChat.sendMessage(caixaEnvio.getText());
				    		  caixaEnvio.setText("");
				    		  mensagens.setText(mensagens.getText() + objChat.retrieveMessage() + "\n");
				          }   
			    	  }catch(Exception ex){
			    		  ex.printStackTrace();
			    	  }
			    	  
			      }
			    };
			
			
			ActionListener sairListener = new ActionListener() {
				  public void actionPerformed(ActionEvent e) {
					  try {
						  objChat.sair();
					  }catch(Exception ex){
						  ex.printStackTrace();
					  }
					  
					  System.exit(0);
				  }
				};
				
			caixaEnvio.addKeyListener(enviarMsg);

			botaoSair.addActionListener(sairListener);
			
			JFrame janela = new JFrame("Client");
			
			janela.add(painel);
			//janela.add(areaDeTexto);
			
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			janela.pack();
			janela.setVisible(true);
			
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
