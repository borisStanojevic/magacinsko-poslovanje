package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;

@Repository
public interface MagacinskaKarticaRepository extends PagingAndSortingRepository<MagacinskaKartica, Integer> {
	
	MagacinskaKartica findByIdMagacinskeKartice(Integer idMagacinskeKartice);
	void deleteByIdMagacinskeKartice(Integer idMagacinskeKartice);
}
