package ftn.sit.pi.magacinskoposlovanje.dto.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.Preduzece;
import ftn.sit.pi.magacinskoposlovanje.dto.PreduzeceDTO;

@Component
public class PreduzeceToDTO implements Converter<Preduzece, PreduzeceDTO> {

	@Autowired
	MestoToDTO mestoToDTO;

	@Override
	public PreduzeceDTO convert(Preduzece source) {
		if(source == null) {
			return null;
		}
		
		PreduzeceDTO predDTO = new PreduzeceDTO();
		predDTO.setSifraPreduzeca(source.getSifraPreduzeca());
		predDTO.setAdresaPreduzeca(source.getAdresaPreduzeca());
		predDTO.setNazivPreduzeca(source.getNazivPreduzeca());
		predDTO.setPib(source.getPib());
		predDTO.setNazivMesta(source.getMesto().getNazivMesta());
		//predDTO.setMesto(mestoToDTO.convert(source.getMesto()));
		//kategorija artikala
		//magacindto
		//radnikdto
		
		return predDTO;
	}
	
	public Set<PreduzeceDTO> convert(Set<Preduzece> source){
		Set<PreduzeceDTO> prometniDokumenti = new HashSet<PreduzeceDTO>();
		for(Preduzece pd : source) {
			prometniDokumenti.add(convert(pd));
		}
		return prometniDokumenti;
	}



}
