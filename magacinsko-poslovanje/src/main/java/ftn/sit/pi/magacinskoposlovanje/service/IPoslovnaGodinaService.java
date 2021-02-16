package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovnaGodina;
import ftn.sit.pi.magacinskoposlovanje.domain.exception.ZakljucivanjePoslovneGodineException;

public interface IPoslovnaGodinaService {

	PoslovnaGodina getById(Integer idGodine);
	Page<PoslovnaGodina> getAll(Pageable pageable);
	PoslovnaGodina getByZakljucena(Boolean isZakljucena);

	PoslovnaGodina add(PoslovnaGodina poslovnaGodina);
	PoslovnaGodina update(PoslovnaGodina poslovnaGodina);
	
	void delete(PoslovnaGodina poslovnaGodina);
	void deleteById(Integer idGodine);
	void zakljuciPoslovnuGodinu(int idTrenutnePoslovneGodine) throws ZakljucivanjePoslovneGodineException;
}
