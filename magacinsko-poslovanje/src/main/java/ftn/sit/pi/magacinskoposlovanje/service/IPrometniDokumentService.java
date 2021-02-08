package ftn.sit.pi.magacinskoposlovanje.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;

public interface IPrometniDokumentService {

	PrometniDokument getById(Integer idPrometnogDokumenta);
	Page<PrometniDokument> getAll(@Param("sifraMagacina") Integer sifraMagacina, @Param("idGodine") Integer idGodine,Pageable pageable);
	Page<PrometniDokument> getAll(@Param("sifraMagacina") Integer sifraMagacina, @Param("idGodine") Integer idGodine, @Param("sifraPartnera") Integer sifraPartnera ,Pageable pageable);
	Page<PrometniDokument> getByPrijemnica(Pageable pageable);
	Page<PrometniDokument> getByOtpremnica(Pageable pageable);

	PrometniDokument add(PrometniDokument prometniDokument);
	PrometniDokument update(PrometniDokument prometniDokument);
	
	void delete(PrometniDokument prometniDokument);
	void deleteById(Integer idPrometnogDokumenta);
}
