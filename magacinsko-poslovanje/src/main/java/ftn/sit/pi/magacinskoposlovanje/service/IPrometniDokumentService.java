package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;

public interface IPrometniDokumentService {

	PrometniDokument getById(Integer idPrometnogDokumenta);
	Page<PrometniDokument> getAll(Pageable pageable);

	PrometniDokument add(PrometniDokument prometniDokument);
	PrometniDokument update(PrometniDokument prometniDokument);
	
	void delete(PrometniDokument prometniDokument);
	void deleteById(Integer idPrometnogDokumenta);
}
