package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;

@Repository
public interface MagacinRepository extends PagingAndSortingRepository<Magacin, Integer> {
	
	Magacin findBySifraMagacina(Integer sifraMagacina);
	
	// 100 - sifra preduzeca
	@Query("SELECT m FROM Magacin m WHERE m.preduzece.sifraPreduzeca = 100")
	Page<Magacin> findAll(Pageable pageable);
}
