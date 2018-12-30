package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovnaGodina;

@Repository
public interface PoslovnaGodinaRepository extends PagingAndSortingRepository<PoslovnaGodina, Integer> {
	
	void deleteByIdGodine(Integer idGodine);
	
}
