package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ftn.sit.pi.magacinskoposlovanje.domain.Radnik;

public interface RadnikRepository extends PagingAndSortingRepository<Radnik, Integer> {

	Radnik findByIdRadnika(Integer idRadnika);
	void deleteByIdRadnika(Integer idRadnika);
}
