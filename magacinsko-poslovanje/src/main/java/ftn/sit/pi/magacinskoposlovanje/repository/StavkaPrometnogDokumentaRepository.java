package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;

@Repository
public interface StavkaPrometnogDokumentaRepository
		extends PagingAndSortingRepository<StavkaPrometnogDokumenta, Integer> {
	
	void deleteByIdStavkePrometnogDokumenta(Integer idStavkePrometnogDokumenta);

}
