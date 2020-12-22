package ftn.sit.pi.magacinskoposlovanje.dto.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;
import ftn.sit.pi.magacinskoposlovanje.dto.StavkaPrometnogDokumentaDTO;

@Component
public class StavkaPrometnogDokumentaToDTO implements Converter<StavkaPrometnogDokumenta, StavkaPrometnogDokumentaDTO> {

	@Autowired
	ArtikalToDTO artikalToDTO;
	
	@Autowired
	PrometniDokumentToDTO prometniDokumentToDTO;
	
	@Override
	public StavkaPrometnogDokumentaDTO convert(StavkaPrometnogDokumenta source) {
		
		if(source == null) {
			return null;
		}
		StavkaPrometnogDokumentaDTO stavkaDTO = new StavkaPrometnogDokumentaDTO();
		stavkaDTO.setIdStavkePrometnogDokumenta(source.getIdStavkePrometnogDokumenta());
		stavkaDTO.setCena(source.getCena());
		stavkaDTO.setKolicina(source.getKolicina());
		stavkaDTO.setVrednost(source.getVrednost());
		//stavkaDTO.setArtikal(artikalToDTO.convert(source.getArtikal()));
		//stavkaDTO.setPrometniDokument(prometniDokumentToDTO.convert(source.getPrometniDokument()));
	
		return stavkaDTO;
	}
	
	public Set<StavkaPrometnogDokumentaDTO> convert(Set<StavkaPrometnogDokumenta> source) {
		Set<StavkaPrometnogDokumentaDTO> stavke = new HashSet<StavkaPrometnogDokumentaDTO>();
		for(StavkaPrometnogDokumenta stavka : source) {
			stavke.add(convert(stavka));
		}
		return stavke;
	}
}
