package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.Mesto;
import ftn.sit.pi.magacinskoposlovanje.repository.MestoRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IMestoService;

@Service
@Transactional
public class MestoService implements IMestoService {

	@Autowired
	private MestoRepository mestoRepository;

	@Override
	public Mesto getById(String postanskiBroj) {
		return mestoRepository.findByPostanskiBroj(postanskiBroj);
	}

	@Override
	public Page<Mesto> getAll(Pageable pageable) {
		return mestoRepository.findAll(pageable);
	}

	@Override
	public Mesto add(Mesto mesto) {
		return mestoRepository.save(mesto);
	}

	@Override
	public Mesto update(Mesto mesto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Mesto mesto) {
		Mesto mestoToBeDeleted = mestoRepository.findByPostanskiBroj(mesto.getPostanskiBroj());
		mestoRepository.delete(mestoToBeDeleted);
	}

	@Override
	public void deleteById(String postanskiBroj) {
		mestoRepository.deleteByPostanskiBroj(postanskiBroj);
	}
	
	
	
}
