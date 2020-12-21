package ftn.sit.pi.magacinskoposlovanje.dto.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.PoslovnaGodina;
import ftn.sit.pi.magacinskoposlovanje.dto.PoslovnaGodinaDTO;

@Component
public class PoslovnaGodinaToDTO implements Converter<PoslovnaGodina, PoslovnaGodinaDTO> {

	@Autowired
	MagacinskaKarticaToDTO magacinskaToDTO;
	
	@Autowired
	PrometniDokumentToDTO promDokToDTO;
	
	@Override
	public PoslovnaGodinaDTO convert(PoslovnaGodina source) {
		if(source == null) {
			return null;
		}
		
		PoslovnaGodinaDTO poslGodDTO = new PoslovnaGodinaDTO();
		poslGodDTO.setIdGodine(source.getIdGodine());
		poslGodDTO.setGodina(source.getGodina());
		poslGodDTO.setZakljucena(source.getZakljucena());
		poslGodDTO.setMagacinskeKartice(magacinskaToDTO.convert(source.getMagacinskeKartice()));
		//poslGodDTO.setPrometniDokumenti(promDokToDTO.convert(source.getPrometniDokumenti()));
		
		return poslGodDTO;
	}
	
	public Set<PoslovnaGodinaDTO> convert(Set<PoslovnaGodina> source){
		Set<PoslovnaGodinaDTO> poslovneGodine = new HashSet<PoslovnaGodinaDTO>();
		for(PoslovnaGodina pg : source) {
			poslovneGodine.add(convert(pg));
		}
		return poslovneGodine;
	}
	
	

}
