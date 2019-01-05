package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;
import ftn.sit.pi.magacinskoposlovanje.repository.StavkaPrometnogDokumentaRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IStavkaPrometnogDokumentaService;

@Service
@Transactional
public class StavkaPrometnogDokumentaService implements IStavkaPrometnogDokumentaService {

	@Autowired
	private StavkaPrometnogDokumentaRepository stavkaPromDokRepository;

	@Override
	public StavkaPrometnogDokumenta getById(Integer idStavkePrometnogDokumenta) {
		return stavkaPromDokRepository.findByIdStavkePrometnogDokumenta(idStavkePrometnogDokumenta);
	}

	@Override
	public Page<StavkaPrometnogDokumenta> getAll(Pageable pageable) {
		return stavkaPromDokRepository.findAll(pageable);
	}

	@Override
	public StavkaPrometnogDokumenta add(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		return stavkaPromDokRepository.save(stavkaPrometnogDokumenta);
	}

	@Override
	public StavkaPrometnogDokumenta update(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		StavkaPrometnogDokumenta stavkaPromDokToBeDeleted = stavkaPromDokRepository.findByIdStavkePrometnogDokumenta(stavkaPrometnogDokumenta.getIdStavkePrometnogDokumenta());
		stavkaPromDokRepository.delete(stavkaPromDokToBeDeleted);
	}

	@Override
	public void deleteById(Integer idStavkePrometnogDokumenta) {
		stavkaPromDokRepository.deleteByIdStavkePrometnogDokumenta(idStavkePrometnogDokumenta);
	}
	
	
	
}
