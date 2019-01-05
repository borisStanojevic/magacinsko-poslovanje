package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;

@Repository
public interface MagacinRepository extends PagingAndSortingRepository<Magacin, Integer> {
	
	Magacin findBySifraMagacina(Integer sifraMagacina);
<<<<<<< HEAD
=======
	void deleteBySifraMagacina(Integer sifraMagacina);
>>>>>>> 6b033200d45f6e00a493e1d847fd6213c598d9ec
}
