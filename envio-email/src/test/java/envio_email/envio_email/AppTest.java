package envio_email.envio_email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

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
			properties.put("mail.smtp.starttls", "true");
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
		
			System.out.println(session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   
}
