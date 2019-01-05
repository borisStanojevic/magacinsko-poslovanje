package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.KategorijaArtikala;

@Repository
public interface KategorijaArtikalaRepository extends PagingAndSortingRepository<KategorijaArtikala, Integer> {
	
	KategorijaArtikala findByIdKategorije(Integer idKategorije);
}
