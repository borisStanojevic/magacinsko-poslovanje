package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;

@Repository
public interface StavkaPrometnogDokumentaRepository
		extends PagingAndSortingRepository<StavkaPrometnogDokumenta, Integer> {
	
	@Query("SELECT spd FROM StavkaPrometnogDokumenta spd WHERE spd.prometniDokument.idPrometnogDokumenta = :idPrometnogDokumenta")
	Page<StavkaPrometnogDokumenta> findAll(@Param("idPrometnogDokumenta") Integer idPrometnogDokumenta, Pageable pageable);
	
	StavkaPrometnogDokumenta findByIdStavkePrometnogDokumenta(Integer idStavkePrometnogDokumenta);
	void deleteByIdStavkePrometnogDokumenta(Integer idStavkePrometnogDokumenta);

}
