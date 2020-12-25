package ftn.sit.pi.magacinskoposlovanje.dto.to.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;
import ftn.sit.pi.magacinskoposlovanje.dto.StavkaPrometnogDokumentaDTO;

@Component
public class DTOToStavkaPrometnogDokumenta implements Converter<StavkaPrometnogDokumentaDTO, StavkaPrometnogDokumenta> {

	@Autowired
	DTOToArtikal dtoToArtikal;
	
	@Override
	public StavkaPrometnogDokumenta convert(StavkaPrometnogDokumentaDTO source) {
		if(source == null) {
			return null;
		}
		StavkaPrometnogDokumenta stavka = new StavkaPrometnogDokumenta();
		stavka.setIdStavkePrometnogDokumenta(source.getIdStavkePrometnogDokumenta());
		stavka.setCena(source.getCena());
		stavka.setKolicina(source.getKolicina());
		stavka.setVrednost(source.getVrednost());
		stavka.setArtikal(dtoToArtikal.convert(source.getArtikal()));
		return stavka;
	}
}
