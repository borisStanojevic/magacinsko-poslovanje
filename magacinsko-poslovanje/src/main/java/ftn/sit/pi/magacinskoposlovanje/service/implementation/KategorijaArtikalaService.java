package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.KategorijaArtikala;
import ftn.sit.pi.magacinskoposlovanje.repository.KategorijaArtikalaRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IKategorijaArtikalaService;

public class KategorijaArtikalaService implements IKategorijaArtikalaService {

	@Autowired
	private KategorijaArtikalaRepository kategorijaArtikalaRepository;

	@Override
	public KategorijaArtikala getById(Integer idKategorije) {
		return kategorijaArtikalaRepository.findByIdKategorije(idKategorije);
	}

	@Override
	public Page<KategorijaArtikala> getAll(Pageable pageable) {
		return kategorijaArtikalaRepository.findAll(pageable);
	}

	@Override
	public KategorijaArtikala add(KategorijaArtikala kategorijaArtikala) {
		return kategorijaArtikalaRepository.save(kategorijaArtikala);
	}

	@Override
	public KategorijaArtikala update(KategorijaArtikala kategorijaArtikala) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(KategorijaArtikala kategorijaArtikala) {
		KategorijaArtikala kategorijaToBeDeleted = kategorijaArtikalaRepository.findByIdKategorije(kategorijaArtikala.getIdKategorije());
		kategorijaArtikalaRepository.delete(kategorijaToBeDeleted);
	}

	@Override
	public void deleteById(Integer idKategorije) {
		kategorijaArtikalaRepository.deleteByIdKategorije(idKategorije);
	}
	
	
	
}
