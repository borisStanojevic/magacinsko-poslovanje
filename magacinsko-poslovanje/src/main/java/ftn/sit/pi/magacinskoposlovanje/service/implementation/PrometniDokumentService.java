package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;
import ftn.sit.pi.magacinskoposlovanje.repository.PrometniDokumentRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IPrometniDokumentService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class PrometniDokumentService implements IPrometniDokumentService {

	@Autowired
	private PrometniDokumentRepository prometniDokumentRepository;

	
	@Override
	@Transactional(readOnly = true)
	public PrometniDokument getById(Integer idPrometnogDokumenta) {
		return prometniDokumentRepository.findByIdPrometnogDokumenta(idPrometnogDokumenta);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<PrometniDokument> getAll(@Param("sifraMagacina") Integer sifraMagacina, @Param("idGodine") Integer idGodine,Pageable pageable)
	{
		return prometniDokumentRepository.findAll(sifraMagacina, idGodine, pageable);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<PrometniDokument> getAll(@Param("sifraMagacina") Integer sifraMagacina, @Param("idGodine") Integer idGodine, @Param("sifraPartnera") Integer sifraPartnera,Pageable pageable)
	{
		return prometniDokumentRepository.findAll(sifraMagacina, idGodine, sifraPartnera, pageable);
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrometniDokument add(PrometniDokument prometniDokument) {
		return prometniDokumentRepository.save(prometniDokument);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrometniDokument update(PrometniDokument prometniDokument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(PrometniDokument prometniDokument) {
		PrometniDokument prometniDokumentToBeDeleted = prometniDokumentRepository.findByIdPrometnogDokumenta(prometniDokument.getIdPrometnogDokumenta());
		prometniDokumentRepository.delete(prometniDokumentToBeDeleted);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(Integer idPrometnogDokumenta) {
		prometniDokumentRepository.deleteByIdPrometnogDokumenta(idPrometnogDokumenta);
	}
	

}
