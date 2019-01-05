package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.AnalitikaMagacinskeKartice;

public interface IAnalitikaMagacinskeKarticeService {

	AnalitikaMagacinskeKartice getById(Integer idAnalitike);
	Page<AnalitikaMagacinskeKartice> getAll(Pageable pageable);
	
	AnalitikaMagacinskeKartice add(AnalitikaMagacinskeKartice analitikaMagacinskeKartice);
	AnalitikaMagacinskeKartice update(AnalitikaMagacinskeKartice analitikaMagacinskeKartice);
	
	void delete(AnalitikaMagacinskeKartice analitikaMagacinskeKartice);
	void deleteById(Integer idAnalitike);
	
}
