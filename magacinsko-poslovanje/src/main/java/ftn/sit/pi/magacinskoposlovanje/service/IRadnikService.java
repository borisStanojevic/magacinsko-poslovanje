package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.Radnik;

public interface IRadnikService {

	Radnik getById(Integer idRadnika);
	Page<Radnik> getAll(Pageable pageable);

	Radnik add(Radnik radnik);
	Radnik update(Radnik radnik);
	
	void delete(Radnik radnik);
	void deleteById(Integer idRadnika);
}
