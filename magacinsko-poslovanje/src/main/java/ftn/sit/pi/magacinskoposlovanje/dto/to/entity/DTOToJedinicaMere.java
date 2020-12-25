package ftn.sit.pi.magacinskoposlovanje.dto.to.entity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.JedinicaMere;
import ftn.sit.pi.magacinskoposlovanje.dto.JedinicaMereDTO;

@Component
public class DTOToJedinicaMere implements Converter<JedinicaMereDTO, JedinicaMere> {

	@Override
	public JedinicaMere convert(JedinicaMereDTO source) {
		if(source == null) {
			return null;
		}
		JedinicaMere jedinicaMere = new JedinicaMere();
		jedinicaMere.setIdJedMere(source.getIdJedMere());
		jedinicaMere.setNazivJediniceMere(source.getNazivJediniceMere());
		return jedinicaMere;
	}
}
