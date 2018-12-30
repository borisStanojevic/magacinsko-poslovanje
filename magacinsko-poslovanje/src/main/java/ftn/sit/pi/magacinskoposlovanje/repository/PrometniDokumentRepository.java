package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;

@Repository
public interface PrometniDokumentRepository extends PagingAndSortingRepository<PrometniDokument,Integer> {
	
	void deleteByIdPrometnogDokumenta(Integer idPrometnogDokumenta);
	
}
