package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.Artikal;

//PagingAndSorting naslijedjuje CrudReposityory pa ima sve metode tog interfejsa
@Repository
public interface ArtikalRepository extends PagingAndSortingRepository<Artikal, Integer>
{
	// S save(S entity) - Sacuvava entitet, metoda za add i update operacije
	// Optional<T> findById(Integer primaryKey)
	// Iterable<T> findAll(); - Vraca sve entitete specificne za ovaj repozitorijum, Iterable - bilo koja kolekcija kroz koju se moze iterirati
	// Long count(); - Broj entiteta
	// void delete(T entity);
	// boolean exists(Integer primaryKey);
	
	// I metode PagingAndSortingRepository
	// Iterable<T> findAll(Sort sort);
	// Page<T> findAll(Pageable pageable);
	
	Artikal findBySifraArtikla(Integer sifraArtikla);
}
