package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;

public interface IMagacinService {
	
	Magacin getById(Integer sifraMagacina);
	Page<Magacin> getAll(Pageable pageable);
<<<<<<< HEAD
	
=======

>>>>>>> 6b033200d45f6e00a493e1d847fd6213c598d9ec
	Magacin add(Magacin magacin);
	Magacin update(Magacin magacin);
	
	void delete(Magacin magacin);
	void deleteById(Integer sifraMagacina);
<<<<<<< HEAD
=======

>>>>>>> 6b033200d45f6e00a493e1d847fd6213c598d9ec
}
