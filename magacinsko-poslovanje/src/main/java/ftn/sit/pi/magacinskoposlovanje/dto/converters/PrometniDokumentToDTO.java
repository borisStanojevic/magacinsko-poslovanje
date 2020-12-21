package ftn.sit.pi.magacinskoposlovanje.dto.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;
import ftn.sit.pi.magacinskoposlovanje.dto.PrometniDokumentDTO;

@Component
public class PrometniDokumentToDTO implements Converter<PrometniDokument, PrometniDokumentDTO> {

	@Autowired
	PoslovnaGodinaToDTO poslGodToDTO;
	
	@Autowired
	PoslovniPartnerToDTO poslPartnerToDTO;
	
	@Override
	public PrometniDokumentDTO convert(PrometniDokument source) {
		
		if(source == null) {
			return null;
		}
		
		PrometniDokumentDTO promDTO = new PrometniDokumentDTO();
		promDTO.setIdPrometnogDokumenta(source.getIdPrometnogDokumenta());
		promDTO.setBrojPrometnogDokumenta(source.getBrojPrometnogDokumenta());
		promDTO.setDatumFormiranja(source.getDatumFormiranja());
		promDTO.setDatumKnjizenja(source.getDatumKnjizenja());
		promDTO.setRedniBrojDokumetna(source.getRedniBrojDokumetna());
		promDTO.setStatus(source.getStatus());
		promDTO.setTipPrometnogDokumenta(source.getTipPrometnogDokumenta());
		//.setPoslovnaGodina(poslGodToDTO.convert(source.getPoslovnaGodina()));
		promDTO.setPoslovniPartner(poslPartnerToDTO.convert(source.getPoslovniPartner()));
		
		
		return promDTO;
	}
	
	public Set<PrometniDokumentDTO> convert(Set<PrometniDokument> source){
		Set<PrometniDokumentDTO> prometniDokumenti = new HashSet<PrometniDokumentDTO>();
		for(PrometniDokument pd : source) {
			prometniDokumenti.add(convert(pd));
		}
		return prometniDokumenti;
	}
	
	

}
