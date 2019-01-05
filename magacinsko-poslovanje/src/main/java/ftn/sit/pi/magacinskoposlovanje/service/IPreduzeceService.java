package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.Preduzece;

public interface IPreduzeceService {
	
	Preduzece getById(Integer sifraPreduzeca);
	Page<Preduzece> getAll(Pageable pageable);

	Preduzece add(Preduzece preduzece);
	Preduzece update(Preduzece preduzece);
	
	void delete(Preduzece preduzece);
	void deleteById(Integer sifraPreduzeca);

}
