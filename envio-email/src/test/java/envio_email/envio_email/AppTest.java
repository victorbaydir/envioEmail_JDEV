package envio_email.envio_email;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * O Maven é um "gerenciador de projetos". Ele já contém alguns arquivos e confiurações pré-definidas
 * Baixei o projeto maven para evitar baixar as dependências, como o pom.xml. No maven já vem pronto
 */
public class AppTest {
	
	
	@org.junit.Test
	public void enviarEmailCadastrado() throws IOException {
		StringBuilder htmlContent = new StringBuilder();
		String line = "";
		FileReader htmlArquivo = new FileReader("C:\\Users\\victo\\eclipse-workspace\\front\\html\\index.html");
		BufferedReader htmlBuffered = new BufferedReader(htmlArquivo);
		
		while((line = htmlBuffered.readLine()) != null) {
			htmlContent.append(line);
		}
		
//		htmlContent.append("<button style=\"background-color=\"gray\"\"><a  target=\"_blank\" href=\"https://www.marcusmanilius.com\" >CLIQUE AQUI</a></button>");
		
		enviarEmailVO email = new enviarEmailVO("teste_developer@hotmail.com", 
				"luciferreina666", 
				"victorbaydir@hotmail.com, victorotimizeti@gmail.com",
				"VICTOR BAYDIR", "TESTE ENVIO",
				htmlContent.toString());
		
		email.enviarEmail();
		
	}
   
}
