package ftn.sit.pi.magacinskoposlovanje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ftn.sit.pi.magacinskoposlovanje.domain.AnalitikaMagacinskeKartice;
import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.MagacinService;

@SpringBootApplication
@EnableTransactionManagement
public class MagacinskoPoslovanjeApplication {
	
	@Autowired
	static MagacinService ms;
	public static void main(String[] args) {
		SpringApplication.run(MagacinskoPoslovanjeApplication.class, args);
	}

}
