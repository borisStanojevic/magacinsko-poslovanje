package ftn.sit.pi.magacinskoposlovanje;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ftn.sit.pi.magacinskoposlovanje.domain.AnalitikaMagacinskeKartice;

@SpringBootApplication
@EnableTransactionManagement
public class MagacinskoPoslovanjeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagacinskoPoslovanjeApplication.class, args);
	}

}
