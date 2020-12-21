package ftn.sit.pi.magacinskoposlovanje.dto.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;
import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.dto.MagacinDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.MagacinskaKarticaDTO;

@Component
public class MagacinToDTO implements Converter<Magacin, MagacinDTO> {
	
	@Autowired
	PrometniDokumentToDTO promDokToDTO;
	
	@Autowired
	PreduzeceToDTO preduzeceToDTO;
	
	@Autowired
	MagacinskaKarticaToDTO magKarticaToDTO;

	@Override
	public MagacinDTO convert(Magacin source) {
		
		if(source == null) {
			return null;
		}
		
		MagacinDTO magacinDTO = new MagacinDTO();
		magacinDTO.setNazivMagacina(source.getNazivMagacina());
		magacinDTO.setSifraMagacina(source.getSifraMagacina());
		magacinDTO.setPreduzece(preduzeceToDTO.convert(source.getPreduzece()));
		magacinDTO.setPrometniDokument(promDokToDTO.convert(source.getPrometniDokumenti()));
		//magacinDTO.setMagacinskeKartice(magKarticaToDTO.convert(source.getMagacinskeKartice()));
		return magacinDTO;
	}


	public Set<MagacinDTO> convert(Set<Magacin> source){
		Set<MagacinDTO> magacini = new HashSet<MagacinDTO>();
		for(Magacin m : source) {
			magacini.add(convert(m));
		}
		return magacini;
	}


}
