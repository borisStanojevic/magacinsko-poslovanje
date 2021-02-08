package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;

public interface IMagacinskaKarticaService {
	
	MagacinskaKartica getById(Integer idMagacinskeKartice);
	Page<MagacinskaKartica> getAll(@Param("sifraMagacina") Integer sifraMagacina, @Param("idGodine") Integer idGodine, Pageable pageable);
	MagacinskaKartica getBySifraArtikla(Integer sifraArtikla);

	MagacinskaKartica add(MagacinskaKartica magacinskaKartica);
	MagacinskaKartica update(MagacinskaKartica magacinskaKartica);
	
	void delete(MagacinskaKartica magacinskaKartica);
	void deleteById(Integer idMagacinskeKartice);

}
