package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovniPartner;

@Repository
public interface PoslovniPartnerRepository extends PagingAndSortingRepository<PoslovniPartner, Integer> {
	
	PoslovniPartner findBySifraPartnera(Integer sifraPartnera);
	void deleteBySifraPartnera(Integer sifraPartnera);
	
}
