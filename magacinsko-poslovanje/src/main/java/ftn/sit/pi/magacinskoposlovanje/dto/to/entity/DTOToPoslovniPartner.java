package ftn.sit.pi.magacinskoposlovanje.dto.to.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovniPartner;
import ftn.sit.pi.magacinskoposlovanje.dto.PoslovniPartnerDTO;

@Component
public class DTOToPoslovniPartner implements Converter<PoslovniPartnerDTO, PoslovniPartner> {

	@Autowired
	DTOToMesto toMesto;
	
	@Override
	public PoslovniPartner convert(PoslovniPartnerDTO source) {
		if(source == null) {
			return null;
		}
		PoslovniPartner poslovniPartner = new PoslovniPartner();
		poslovniPartner.setSifraPartnera(source.getSifraPartnera());
		poslovniPartner.setAdresaPoslovnogPartnera(source.getAdresaPoslovnogPartnera());
		poslovniPartner.setNazivPartnera(source.getNazivPartnera());
		poslovniPartner.setPib(source.getPib());
		poslovniPartner.setTipPartnera(source.getTipPartnera());
		poslovniPartner.setMesto(toMesto.convert(source.getMesto()));
		return poslovniPartner;
	}
}
