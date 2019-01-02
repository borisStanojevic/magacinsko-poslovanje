package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.Artikal;

public interface IArtikalService {
	
	Artikal getById(Integer sifraArtikla);
	Page<Artikal> getAll(Pageable pageable);

	Artikal add(Artikal artikal);
	Artikal update(Artikal artikal);
	
	void delete(Artikal artikal);
	void deleteById(Integer sifraArtikla);
	
}
