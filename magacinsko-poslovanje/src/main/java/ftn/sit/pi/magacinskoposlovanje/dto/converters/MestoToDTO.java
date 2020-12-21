package ftn.sit.pi.magacinskoposlovanje.dto.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.Mesto;
import ftn.sit.pi.magacinskoposlovanje.domain.Preduzece;
import ftn.sit.pi.magacinskoposlovanje.dto.MestoDTO;
import ftn.sit.pi.magacinskoposlovanje.dto.PreduzeceDTO;

@Component
public class MestoToDTO implements Converter<Mesto, MestoDTO> {
	
	@Autowired
	PoslovniPartnerToDTO poslPToDTO;
	@Autowired
	PreduzeceToDTO preduzeceToDTO;

	@Override
	public MestoDTO convert(Mesto source) {
		
		if(source == null) {
			return null;
		}
		MestoDTO mestoDTO = new MestoDTO();
		mestoDTO.setPostanskiBroj(source.getPostanskiBroj());
		mestoDTO.setDrzava(source.getDrzava());
		mestoDTO.setNazivMesta(source.getNazivMesta());
		//mestoDTO.setPoslovniPartner(poslPToDTO.convert(source.getPoslovniPartneri()));
		mestoDTO.setPreduzeca(preduzeceToDTO.convert(source.getPreduzeca()));

		return mestoDTO;
		
	}
	
	public Set<MestoDTO> convert(Set<Mesto> source){
		Set<MestoDTO> mesta = new HashSet<MestoDTO>();
		for(Mesto m : source) {
			mesta.add(convert(m));
		}
		return mesta;
	}

	
	

}
