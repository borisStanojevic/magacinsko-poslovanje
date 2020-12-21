package ftn.sit.pi.magacinskoposlovanje.dto.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovniPartner;
import ftn.sit.pi.magacinskoposlovanje.dto.PoslovniPartnerDTO;

@Component
public class PoslovniPartnerToDTO implements Converter<PoslovniPartner, PoslovniPartnerDTO> {

	@Autowired
	PrometniDokumentToDTO promDokToDTO;
	
	@Autowired
	MestoToDTO mestoToDTO;
	
	
	
	@Override
	public PoslovniPartnerDTO convert(PoslovniPartner source) {
		
		if(source == null) {
			return null;
		}
		PoslovniPartnerDTO poslPDTO = new PoslovniPartnerDTO();
		
		poslPDTO.setSifraPartnera(source.getSifraPartnera());
		poslPDTO.setAdresaPoslovnogPartnera(source.getAdresaPoslovnogPartnera());
		poslPDTO.setNazivPartnera(source.getNazivPartnera());
		poslPDTO.setPib(source.getPib());
		poslPDTO.setTipPartnera(source.getTipPartnera());
		poslPDTO.setMesto(mestoToDTO.convert(source.getMesto()));
		//poslPDTO.setPrometniDokumenti(promDokToDTO.convert(source.getPrometniDokumenti()));
		
		return poslPDTO;
		
		
	}
	
	
	public Set<PoslovniPartnerDTO> convert(Set<PoslovniPartner> source){
		Set<PoslovniPartnerDTO> prometniDokumenti = new HashSet<PoslovniPartnerDTO>();
		for(PoslovniPartner pd : source) {
			prometniDokumenti.add(convert(pd));
		}
		return prometniDokumenti;
	}
	
	

}
