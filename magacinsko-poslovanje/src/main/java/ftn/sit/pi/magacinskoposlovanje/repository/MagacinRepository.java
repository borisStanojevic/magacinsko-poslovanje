package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;

@Repository
public interface MagacinRepository extends PagingAndSortingRepository<Magacin, Integer> {
	
	Magacin findBySifraMagacina(Integer sifraMagacina);
	void deleteBySifraMagacina(Integer sifraMagacina);
}
