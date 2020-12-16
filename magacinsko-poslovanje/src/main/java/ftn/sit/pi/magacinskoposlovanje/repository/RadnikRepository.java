package ftn.sit.pi.magacinskoposlovanje.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.Radnik;

@Repository
public interface RadnikRepository extends PagingAndSortingRepository<Radnik, Integer> {

	Radnik findByIdRadnika(Integer idRadnika);
	void deleteByIdRadnika(Integer idRadnika);
	
	Optional<Radnik> findByUsername(String username);
	Boolean existsByUsername(String username);
}
