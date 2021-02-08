package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;
import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;

@Repository
public interface MagacinskaKarticaRepository extends PagingAndSortingRepository<MagacinskaKartica, Integer> {
	
	MagacinskaKartica findByIdMagacinskeKartice(Integer idMagacinskeKartice);
	void deleteByIdMagacinskeKartice(Integer idMagacinskeKartice);
	
	@Query("SELECT mk FROM MagacinskaKartica mk WHERE mk.magacin.sifraMagacina = :sifraMagacina"
			+ " AND mk.poslovnaGodina.idGodine = :idGodine")
	Page<MagacinskaKartica> findAll(@Param("sifraMagacina") Integer sifraMagacina, @Param("idGodine") Integer idGodine, Pageable pageable);
	
	@Query("SELECT mk FROM MagacinskaKartica mk WHERE mk.magacin.sifraMagacina = :sifraMagacina"
			+ " AND mk.poslovnaGodina.idGodine = :idGodine")
	Page<MagacinskaKartica> findAll(@Param("sifraMagacina") Integer sifraMagacina, @Param("idGodine") Integer idGodine);
	
	@Query("SELECT mk FROM MagacinskaKartica mk WHERE mk.artikal.sifraArtikla = :sifraArtikla")
	MagacinskaKartica getBySifraArtikla(@Param("sifraArtikla") Integer sifraArtikla);
	
}
