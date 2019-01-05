package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovniPartner;

public interface IPoslovniPartnerService {
	
	PoslovniPartner getById(Integer sifraPartnera);
	Page<PoslovniPartner> getAll(Pageable pageable);

	PoslovniPartner add(PoslovniPartner poslovniPartner);
	PoslovniPartner update(PoslovniPartner PoslovniPartner);
	
	void delete(PoslovniPartner poslovniPartner);
	void deleteById(Integer sifraPartnera);

}
