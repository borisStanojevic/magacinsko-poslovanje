package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;
import ftn.sit.pi.magacinskoposlovanje.repository.StavkaPrometnogDokumentaRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IStavkaPrometnogDokumentaService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class StavkaPrometnogDokumentaService implements IStavkaPrometnogDokumentaService {

	@Autowired
	private StavkaPrometnogDokumentaRepository stavkaPromDokRepository;

	
	@Override
	@Transactional(readOnly = true)
	public StavkaPrometnogDokumenta getById(Integer idStavkePrometnogDokumenta) {
		return stavkaPromDokRepository.findByIdStavkePrometnogDokumenta(idStavkePrometnogDokumenta);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<StavkaPrometnogDokumenta> getAll(Pageable pageable) {
		return stavkaPromDokRepository.findAll(pageable);
	}
	

	@Override
	public Page<StavkaPrometnogDokumenta> getAll(@Param("idPrometnogDokumenta") Integer idPrometnogDokumenta, Pageable pageable) {
		return stavkaPromDokRepository.findAll(idPrometnogDokumenta, pageable);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public StavkaPrometnogDokumenta add(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		return stavkaPromDokRepository.save(stavkaPrometnogDokumenta);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public StavkaPrometnogDokumenta update(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		StavkaPrometnogDokumenta stavkaPromDokToBeDeleted = stavkaPromDokRepository.findByIdStavkePrometnogDokumenta(stavkaPrometnogDokumenta.getIdStavkePrometnogDokumenta());
		stavkaPromDokRepository.delete(stavkaPromDokToBeDeleted);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(Integer idStavkePrometnogDokumenta) {
		stavkaPromDokRepository.deleteByIdStavkePrometnogDokumenta(idStavkePrometnogDokumenta);
	}

	
	
	
}
