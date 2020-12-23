package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.Mesto;
import ftn.sit.pi.magacinskoposlovanje.repository.MestoRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IMestoService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class MestoService implements IMestoService {

	@Autowired
	private MestoRepository mestoRepository;

	
	@Override
	@Transactional(readOnly = true)
	public Mesto getById(String postanskiBroj) {
		return mestoRepository.findByPostanskiBroj(postanskiBroj);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Mesto> getAll(Pageable pageable) {
		return mestoRepository.findAll(pageable);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Mesto add(Mesto mesto) {
		return mestoRepository.save(mesto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Mesto update(Mesto mesto) {

		Mesto mestoForEdit = mestoRepository.findByPostanskiBroj(mesto.getPostanskiBroj());
		mestoForEdit.setDrzava(mesto.getDrzava());
		mestoForEdit.setNazivMesta(mesto.getNazivMesta());
		return mestoRepository.save(mestoForEdit);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Mesto mesto) {
		Mesto mestoToBeDeleted = mestoRepository.findByPostanskiBroj(mesto.getPostanskiBroj());
		mestoRepository.delete(mestoToBeDeleted);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(String postanskiBroj) {
		mestoRepository.deleteByPostanskiBroj(postanskiBroj);
	}
	
	
	
}
