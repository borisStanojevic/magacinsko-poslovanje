package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import ftn.sit.pi.magacinskoposlovanje.domain.Artikal;

public interface IArtikalService {
	
	Artikal getById(Integer sifraArtikla);
	Page<Artikal> getAll(Pageable pageable);
	Page<Artikal> getAll(@Param("idKategorije") Integer idKategorije, Pageable pageable);

	Artikal add(Artikal artikal);
	Artikal update(Artikal artikal);
	
	void deleteById(Integer sifraArtikla);
	Artikal update(Integer sifraArtikla);
	Artikal delete(Integer sifraArtikla);
	
}
