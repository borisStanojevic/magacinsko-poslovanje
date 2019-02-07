package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.KategorijaArtikala;

@Repository
public interface KategorijaArtikalaRepository extends PagingAndSortingRepository<KategorijaArtikala, Integer> {
	
	KategorijaArtikala findByIdKategorije(Integer idKategorije);
	
	@Query("SELECT k FROM KategorijaArtikala k WHERE k.preduzece.sifraPreduzeca = 100")
	Page<KategorijaArtikala> getAll(Pageable pageable);
	
}
