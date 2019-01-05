package ftn.sit.pi.magacinskoposlovanje.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ftn.sit.pi.magacinskoposlovanje.domain.KategorijaArtikala;

@Repository
public interface KategorijaArtikalaRepository extends PagingAndSortingRepository<KategorijaArtikala, Integer> {
	
	KategorijaArtikala findByIdKategorije(Integer idKategorije);
<<<<<<< HEAD
=======
	void deleteByIdKategorije(Integer idKategorije);
>>>>>>> 6b033200d45f6e00a493e1d847fd6213c598d9ec
}
