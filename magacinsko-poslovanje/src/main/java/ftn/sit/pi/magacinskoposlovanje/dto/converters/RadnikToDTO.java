package ftn.sit.pi.magacinskoposlovanje.dto.converters;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import ftn.sit.pi.magacinskoposlovanje.domain.Radnik;
import ftn.sit.pi.magacinskoposlovanje.dto.RadnikDTO;

@Component
public class RadnikToDTO implements Converter<Radnik, RadnikDTO> {

	@Autowired
	MagacinToDTO magaciniToDTO;
	
	@Autowired
	PreduzeceToDTO preduzeceToDTO;
	
	@Override
	public RadnikDTO convert(Radnik source) {
		
		if(source == null) {
			return null;
		}
		RadnikDTO radnikDTO = new RadnikDTO();
		radnikDTO.setIdRadnika(source.getIdRadnika());
		radnikDTO.setImePrezime(source.getImePrezime());
		radnikDTO.setUsername(source.getUsername());
		radnikDTO.setPassword(source.getPassword());
		radnikDTO.setMagacini(magaciniToDTO.convert(source.getMagacini()));
		radnikDTO.setPreduzeca(preduzeceToDTO.convert(source.getPreduzeca()));
		
		return radnikDTO;
	}
	
	public Set<RadnikDTO> convert(Set<Radnik> source) {
		Set<RadnikDTO> radnici = new HashSet<RadnikDTO>();
		for(Radnik r : source) {
			radnici.add(convert(r));
		}
		return radnici;
	}
}
 