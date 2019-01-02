package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.Mesto;

@Repository
public interface MestoRepository extends PagingAndSortingRepository<Mesto, String> {
	
	void deleteByPostanskiBroj(String postanskiBroj);
	
}