package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.KategorijaArtikala;
import ftn.sit.pi.magacinskoposlovanje.repository.KategorijaArtikalaRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IKategorijaArtikalaService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class KategorijaArtikalaService implements IKategorijaArtikalaService {

	@Autowired
	private KategorijaArtikalaRepository kategorijaArtikalaRepository;

	@Override
	@Transactional(readOnly = true)
	public KategorijaArtikala getById(Integer idKategorije) {
		return kategorijaArtikalaRepository.findByIdKategorije(idKategorije);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<KategorijaArtikala> getAll(Pageable pageable) {
		return kategorijaArtikalaRepository.findAll(pageable);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public KategorijaArtikala add(KategorijaArtikala kategorijaArtikala) {
		return kategorijaArtikalaRepository.save(kategorijaArtikala);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public KategorijaArtikala update(KategorijaArtikala kategorijaArtikala) {
		KategorijaArtikala kategorijaToBeUpdated = kategorijaArtikalaRepository
				.findByIdKategorije(kategorijaArtikala.getIdKategorije());
		kategorijaToBeUpdated.setNazivKategorije(kategorijaArtikala.getNazivKategorije());
		return kategorijaArtikalaRepository.save(kategorijaToBeUpdated);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(KategorijaArtikala kategorijaArtikala) {
		KategorijaArtikala kategorijaToBeDeleted = kategorijaArtikalaRepository
				.findByIdKategorije(kategorijaArtikala.getIdKategorije());
		kategorijaArtikalaRepository.delete(kategorijaToBeDeleted);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(Integer idKategorije) {
		kategorijaArtikalaRepository.deleteById(idKategorije);
	}
}
