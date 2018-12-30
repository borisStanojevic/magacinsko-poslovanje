package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.AnalitikaMagacinskeKartice;

@Repository
public interface AnalitkaMagacinskeKarticeRepository extends PagingAndSortingRepository<AnalitikaMagacinskeKartice, Integer> {
	
	void deleteByIdAnalitike(Integer idAnalitike);
	
}
