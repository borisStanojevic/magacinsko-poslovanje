package ftn.sit.pi.magacinskoposlovanje.dto.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.JedinicaMere;
import ftn.sit.pi.magacinskoposlovanje.dto.JedinicaMereDTO;

@Component
public class JedinicaMereToDTO implements Converter<JedinicaMere, JedinicaMereDTO> {

	@Autowired
	ArtikalToDTO artikalToDTO;
	
	@Override
	public JedinicaMereDTO convert(JedinicaMere source) {
		
		if(source == null) {
			return null;
		}
		JedinicaMereDTO jedinicaMereDTO = new JedinicaMereDTO();
		jedinicaMereDTO.setIdJedMere(source.getIdJedMere());
		jedinicaMereDTO.setNazivJediniceMere(source.getNazivJediniceMere());
		//jedinicaMereDTO.setArtikli(artikalToDTO.convert(source.getArtikli()));
		
		return jedinicaMereDTO;
	}
	
	public Set<JedinicaMereDTO> convert(Set<JedinicaMere> source) {
		Set<JedinicaMereDTO> jediniceMere = new HashSet<JedinicaMereDTO>();
		for(JedinicaMere jm : source) {
			jediniceMere.add(convert(jm));
		}
		return jediniceMere;
	}
}
