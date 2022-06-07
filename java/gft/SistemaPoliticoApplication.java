package gft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SistemaPoliticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaPoliticoApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("Gft2021"));
	}

}
