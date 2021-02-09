package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.JedinicaMere;

public interface IJedinicaMereService {
	
	JedinicaMere getById(Integer idJedMere);
	Page<JedinicaMere> getAll(Pageable pageable);
	
	JedinicaMere add(JedinicaMere jedinicaMere);
	//JedinicaMere update(JedinicaMere jedinicaMere);
	
	void delete(JedinicaMere jedinicaMere);
	void deleteById(Integer idJedMere);
	JedinicaMere update(Integer idJediniceMere);

}
