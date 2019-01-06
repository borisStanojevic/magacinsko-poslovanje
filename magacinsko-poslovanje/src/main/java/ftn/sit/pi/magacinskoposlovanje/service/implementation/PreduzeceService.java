package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.Preduzece;
import ftn.sit.pi.magacinskoposlovanje.repository.PreduzeceRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IPreduzeceService;

@Service
@Transactional
public class PreduzeceService implements IPreduzeceService {

	@Autowired
	private PreduzeceRepository preduzeceRepository;

	
	@Override
	@Transactional(readOnly = true)
	public Preduzece getById(Integer sifraPreduzeca) {
		return preduzeceRepository.findBySifraPreduzeca(sifraPreduzeca);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Preduzece> getAll(Pageable pageable) {
		return preduzeceRepository.findAll(pageable);
	}

	@Override
	public Preduzece add(Preduzece preduzece) {
		return preduzeceRepository.save(preduzece);
	}

	@Override
	public Preduzece update(Preduzece preduzece) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Preduzece preduzece) {
		Preduzece preduzeceToBeDeleted = preduzeceRepository.findBySifraPreduzeca(preduzece.getSifraPreduzeca());
		preduzeceRepository.delete(preduzeceToBeDeleted);
	}

	@Override
	public void deleteById(Integer sifraPreduzeca) {
		preduzeceRepository.deleteBySifraPreduzeca(sifraPreduzeca);
	}

	
}
