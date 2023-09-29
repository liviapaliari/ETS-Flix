package br.bosch.ETSFlix;

import br.bosch.ETSFlix.Service.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EtsFlixApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(EtsFlixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}