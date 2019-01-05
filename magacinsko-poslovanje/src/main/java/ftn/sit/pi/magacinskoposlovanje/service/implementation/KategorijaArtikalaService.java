package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
<<<<<<< HEAD
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
=======
>>>>>>> 6b033200d45f6e00a493e1d847fd6213c598d9ec

import ftn.sit.pi.magacinskoposlovanje.domain.KategorijaArtikala;
import ftn.sit.pi.magacinskoposlovanje.repository.KategorijaArtikalaRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IKategorijaArtikalaService;

<<<<<<< HEAD
@Transactional
@Service
=======
>>>>>>> 6b033200d45f6e00a493e1d847fd6213c598d9ec
public class KategorijaArtikalaService implements IKategorijaArtikalaService {

	@Autowired
	private KategorijaArtikalaRepository kategorijaArtikalaRepository;
<<<<<<< HEAD
	
=======
>>>>>>> 6b033200d45f6e00a493e1d847fd6213c598d9ec

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
<<<<<<< HEAD
		KategorijaArtikala kategorijaToBeUpdated = kategorijaArtikalaRepository.findByIdKategorije(kategorijaArtikala.getIdKategorije());
		kategorijaToBeUpdated.setNazivKategorije(kategorijaArtikala.getNazivKategorije());
		return kategorijaArtikalaRepository.save(kategorijaToBeUpdated);
=======
		// TODO Auto-generated method stub
		return null;
>>>>>>> 6b033200d45f6e00a493e1d847fd6213c598d9ec
	}

	@Override
	public void delete(KategorijaArtikala kategorijaArtikala) {
<<<<<<< HEAD
		KategorijaArtikala kategorijaToBeDeleted = kategorijaArtikalaRepository
				.findByIdKategorije(kategorijaArtikala.getIdKategorije());
=======
		KategorijaArtikala kategorijaToBeDeleted = kategorijaArtikalaRepository.findByIdKategorije(kategorijaArtikala.getIdKategorije());
>>>>>>> 6b033200d45f6e00a493e1d847fd6213c598d9ec
		kategorijaArtikalaRepository.delete(kategorijaToBeDeleted);
	}

	@Override
	public void deleteById(Integer idKategorije) {
<<<<<<< HEAD
		kategorijaArtikalaRepository.deleteById(idKategorije);
	}

=======
		kategorijaArtikalaRepository.deleteByIdKategorije(idKategorije);
	}
	
	
	
>>>>>>> 6b033200d45f6e00a493e1d847fd6213c598d9ec
}
