package ftn.sit.pi.magacinskoposlovanje.dto.to.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;
import ftn.sit.pi.magacinskoposlovanje.dto.MagacinDTO;

@Component
public class DTOToMagacin implements Converter<MagacinDTO, Magacin> {

	@Autowired
	DTOToPreduzece dtoToPreduzece;
	
	
	@Override
	public Magacin convert(MagacinDTO source) {
		if(source == null) {
			return null;
		}
		Magacin magacin = new Magacin();
		magacin.setSifraMagacina(source.getSifraMagacina());
		magacin.setNazivMagacina(source.getNazivMagacina());
		magacin.setPreduzece(dtoToPreduzece.convert(source.getPreduzece()));
		//magacin.getRadnik();
		return magacin;
		
	}
}
