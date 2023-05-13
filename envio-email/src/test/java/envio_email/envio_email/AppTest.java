package envio_email.envio_email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

/**
 * O Maven é um "gerenciador de projetos". Ele já contém alguns arquivos e confiurações pré-definidas
 * Baixei o projeto maven para evitar baixar as dependências, como o pom.xml. No maven já vem pronto
 */
public class AppTest {
	
	private String username = "teste_developer@hotmail.com";
	private String password = "luciferreina666";
	
	@Test
	public void testeEmail() {
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
			Address[] toUser = InternetAddress.parse("victorbaydir@hotmail.com");
			
			/*Tendo a sessão pronta, eu coloco uma mensagem que irá recebê-la*/
			Message mensagem = new MimeMessage(session);
			mensagem.setFrom(new InternetAddress(username));
			mensagem.setRecipients(Message.RecipientType.TO, toUser);
			mensagem.setSubject("TREINAMENTO JDEV TESTE");
			mensagem.setText("Olá mundo");
			
			Transport.send(mensagem);
			System.out.println("Email enviado!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   
}
