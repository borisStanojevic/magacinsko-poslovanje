package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.Mesto;

public interface IMestoService {
	
	Mesto getById(String postanskiBroj);
	Page<Mesto> getAll(Pageable pageable);
	
	Mesto add(Mesto mesto);
	Mesto update(Mesto mesto);
	
	void delete(Mesto mesto);
	void deleteById(String postanskiBroj);

}
