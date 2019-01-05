package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.KategorijaArtikala;

public interface IKategorijaArtikalaService {
	
	KategorijaArtikala getById(Integer idKategorije);
	Page<KategorijaArtikala> getAll(Pageable pageable);
	
	KategorijaArtikala add(KategorijaArtikala kategorijaArtikala);
	KategorijaArtikala update(KategorijaArtikala kategorijaArtikala);
	
	void delete(KategorijaArtikala kategorijaArtikala);
	void deleteById(Integer idKategorije);

}
