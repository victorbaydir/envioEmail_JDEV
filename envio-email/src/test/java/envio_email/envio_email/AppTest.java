package envio_email.envio_email;



/**
 * O Maven é um "gerenciador de projetos". Ele já contém alguns arquivos e confiurações pré-definidas
 * Baixei o projeto maven para evitar baixar as dependências, como o pom.xml. No maven já vem pronto
 */
public class AppTest {
	
	
	@org.junit.Test
	public void enviarEmailCadastrado() throws InterruptedException {
		enviarEmailVO email = new enviarEmailVO("teste_developer@hotmail.com", 
				"luciferreina666", 
				"victorbaydir@hotmail.com, victorotimizeti@gmail.com",
				"VICTOR BAYDIR", "TESTE ENVIO", 
				"SUCESSO!!!");
		
		email.enviarEmail();
		Thread.sleep(5000);
		
	}
   
}
