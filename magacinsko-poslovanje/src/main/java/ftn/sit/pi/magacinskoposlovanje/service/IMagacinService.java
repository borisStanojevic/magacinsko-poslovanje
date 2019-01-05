package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;

public interface IMagacinService {
	
	Magacin getById(Integer sifraMagacina);
	Page<Magacin> getAll(Pageable pageable);

	Magacin add(Magacin magacin);
	Magacin update(Magacin magacin);
	
	void delete(Magacin magacin);
	void deleteById(Integer sifraMagacina);

}
