package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;

public interface IStavkaPrometnogDokumentaService {
	
	StavkaPrometnogDokumenta getById(Integer idStavkePrometnogDokumenta);
	Page<StavkaPrometnogDokumenta> getAll(Pageable pageable);
	Page<StavkaPrometnogDokumenta> getAll(@Param("idPrometnogDokumenta") Integer idPrometnogDokumenta, Pageable pageable);

	StavkaPrometnogDokumenta add(StavkaPrometnogDokumenta stavkaPrometnogDokumenta);
	StavkaPrometnogDokumenta update(StavkaPrometnogDokumenta stavkaPrometnogDokumenta);
	
	void delete(StavkaPrometnogDokumenta stavkaPrometnogDokumenta);
	void deleteById(Integer idStavkePrometnogDokumenta);

}
