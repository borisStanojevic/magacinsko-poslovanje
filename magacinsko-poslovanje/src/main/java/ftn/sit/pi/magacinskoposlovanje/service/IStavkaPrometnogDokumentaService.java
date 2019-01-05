package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;

public interface IStavkaPrometnogDokumentaService {
	
	StavkaPrometnogDokumenta getById(Integer idStavkePrometnogDokumenta);
	Page<StavkaPrometnogDokumenta> getAll(Pageable pageable);

	StavkaPrometnogDokumenta add(StavkaPrometnogDokumenta stavkaPrometnogDokumenta);
	StavkaPrometnogDokumenta update(StavkaPrometnogDokumenta stavkaPrometnogDokumenta);
	
	void delete(StavkaPrometnogDokumenta stavkaPrometnogDokumenta);
	void deleteById(Integer idStavkePrometnogDokumenta);

}
