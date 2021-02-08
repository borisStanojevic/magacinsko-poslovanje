package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovniPartner;

@Repository
public interface PoslovniPartnerRepository extends PagingAndSortingRepository<PoslovniPartner, Integer> {
	
	PoslovniPartner findBySifraPartnera(Integer sifraPartnera);
	
	@Query("SELECT p FROM PoslovniPartner p WHERE p.tipPartnera != 'KUPAC'")
	Page<PoslovniPartner> findByTipPartneraD(Pageable pageable);
	
	@Query("SELECT p FROM PoslovniPartner p WHERE p.tipPartnera != 'DOBAVLJAC'")
	Page<PoslovniPartner> findByTipPartneraK(Pageable pageable);

	void deleteBySifraPartnera(Integer sifraPartnera);
	
	Page<PoslovniPartner> findAllByDeletedFalse(Pageable pageable);
	
}
