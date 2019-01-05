package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.JedinicaMere;

@Repository
public interface JedinicaMereRepository extends PagingAndSortingRepository<JedinicaMere, Integer> {
	
	JedinicaMere findByIdJedMere(Integer idJedMere);
	void deleteByIdJedMere(Integer idJedMere);
	
}
