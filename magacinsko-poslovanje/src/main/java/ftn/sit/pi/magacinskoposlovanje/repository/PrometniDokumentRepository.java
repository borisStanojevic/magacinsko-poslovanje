package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;

@Repository
public interface PrometniDokumentRepository extends PagingAndSortingRepository<PrometniDokument,Integer> {
	
	@Query("SELECT pd FROM PrometniDokument pd WHERE pd.idPrometnogDokumenta = :idPrometnogDokumenta AND pd.deleted = 0")
	PrometniDokument findByIdPrometnogDokumenta(Integer idPrometnogDokumenta);
	void deleteByIdPrometnogDokumenta(Integer idPrometnogDokumenta);
	
	@Query("SELECT pd FROM PrometniDokument pd WHERE pd.magacin.sifraMagacina = :sifraMagacina"
												+ " AND pd.poslovnaGodina.idGodine = :idGodine AND pd.deleted = 0")
	Page<PrometniDokument> findAll(@Param("sifraMagacina") Integer sifraMagacina, @Param("idGodine") Integer idGodine,Pageable pageable);
	
	@Query("SELECT pd FROM PrometniDokument pd WHERE pd.magacin.sifraMagacina = :sifraMagacina"
			+ " AND pd.poslovnaGodina.idGodine = :idGodine AND pd.poslovniPartner.sifraPartnera = :sifraPartnera AND pd.deleted = 0")
	Page<PrometniDokument> findAll(@Param("sifraMagacina") Integer sifraMagacina, @Param("idGodine") Integer idGodine, @Param("sifraPartnera") Integer sifraPartnera ,Pageable pageable);
	
	@Query("SELECT pd FROM PrometniDokument pd WHERE pd.tipPrometnogDokumenta = 'PRIJEMNICA' AND pd.deleted = 0")
	Page<PrometniDokument> findByPrijemnica(Pageable pageable);
	
	@Query("SELECT pd FROM PrometniDokument pd WHERE pd.tipPrometnogDokumenta = 'OTPREMNICA' AND pd.deleted = 0")
	Page<PrometniDokument> findByOtpremnica(Pageable pageable);

	PrometniDokument findTopByOrderByIdPrometnogDokumentaDesc();
}
