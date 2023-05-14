package envio_email.envio_email;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.Test;

public class enviarEmailVO {
	
	private String username = "";
	private String password = "";
	private String listaEmails = "";
	private String nomeRemetente = "";
	private String assunto = "";
	private String texto = "";
	
	 public enviarEmailVO(String username, String password, String listaEmails, String nomeRemetente, String assunto, String texto) {
			
		 this.username = username;
		 this.password = password;
		 this.listaEmails = listaEmails;
		 this.nomeRemetente = nomeRemetente;
		 this.assunto = assunto;
		 this.texto = texto;
		 
	 }
	
	public void enviarEmail() {
		
		try {
			/*Nessa parte, estamos acessando a "classe" Properties e atribuindo seus valores
			 * para o envio dos emails.*/
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "outlook.office365.com");
			properties.put("mail.smtp.port", "587");
			properties.put("mail.smtp.socketFactory.port", "587");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");/*classe de conexão ao smtp*/
		
			/*Agora criamos a sessão, que usará as propriedades definidas anteriormente 
			 * para conectar ao servidor do email e obter uma resposta*/
			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			
			/*No método Adress colocamos o "endereço, ou seja, para onde o email será enviado*/
			Address[] toUser = InternetAddress.parse(listaEmails);
			
			/*Tendo a sessão pronta, eu coloco uma mensagem que irá recebê-la*/
			Message mensagem = new MimeMessage(session);
			mensagem.setFrom(new InternetAddress(username,nomeRemetente));
			mensagem.setRecipients(Message.RecipientType.TO, toUser);
			
			
			mensagem.setSubject(assunto);
			mensagem.setContent(texto, "text/html; charset=utf-8");
			
			Transport.send(mensagem);
			System.out.println("Email enviado!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
