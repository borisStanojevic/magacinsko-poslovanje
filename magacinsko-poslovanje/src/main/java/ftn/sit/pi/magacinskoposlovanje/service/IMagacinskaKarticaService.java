package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;

public interface IMagacinskaKarticaService {
	
	MagacinskaKartica getById(Integer idMagacinskeKartice);
	Page<MagacinskaKartica> getAll(Pageable pageable);

	MagacinskaKartica add(MagacinskaKartica magacinskaKartica);
	MagacinskaKartica update(MagacinskaKartica magacinskaKartica);
	
	void delete(MagacinskaKartica magacinskaKartica);
	void deleteById(Integer idMagacinskeKartice);

}