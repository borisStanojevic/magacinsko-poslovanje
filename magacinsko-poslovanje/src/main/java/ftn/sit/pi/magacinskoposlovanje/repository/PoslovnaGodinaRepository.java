package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovnaGodina;

@Repository
public interface PoslovnaGodinaRepository extends PagingAndSortingRepository<PoslovnaGodina, Integer> {
	
	PoslovnaGodina findByIdGodine(Integer idGodine);
	void deleteByIdGodine(Integer idGodine);
	
}
