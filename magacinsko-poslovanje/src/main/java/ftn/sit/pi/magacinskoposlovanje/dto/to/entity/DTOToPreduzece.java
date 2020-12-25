package ftn.sit.pi.magacinskoposlovanje.dto.to.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.Preduzece;
import ftn.sit.pi.magacinskoposlovanje.dto.PreduzeceDTO;

@Component
public class DTOToPreduzece implements Converter<PreduzeceDTO, Preduzece> {
	
	@Autowired
	DTOToMesto dtoToMesto;
	
	@Override
	public Preduzece convert(PreduzeceDTO source) {
		if(source == null) {
			return null;
		}
		Preduzece preduzece = new Preduzece();
		preduzece.setSifraPreduzeca(source.getSifraPreduzeca());
		preduzece.setAdresaPreduzeca(source.getAdresaPreduzeca());
		preduzece.setNazivPreduzeca(source.getNazivPreduzeca());
		preduzece.setPib(source.getPib());
		//magacini
		//preduzece.set
		return preduzece;
	}

}
