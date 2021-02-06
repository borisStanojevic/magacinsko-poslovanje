package ftn.sit.pi.magacinskoposlovanje.dto.converters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.dto.MagacinskaKarticaDTO;

@Component
public class MagacinskaKarticaToDTO implements Converter<MagacinskaKartica, MagacinskaKarticaDTO> {

	@Autowired
	MagacinToDTO magacinToDTO;
	
	@Autowired
	PoslovnaGodinaToDTO poslGodToDTO;
	
	@Autowired
	AnalitikaMagacinskeKarticeToDTO analitikaToDTO;
	
	@Autowired
	ArtikalToDTO artikalToDTO;
	
	@Override
	public MagacinskaKarticaDTO convert(MagacinskaKartica source) {
		if(source == null) {
			return null;
		}
		
		MagacinskaKarticaDTO magDTO = new MagacinskaKarticaDTO();
		magDTO.setIdMagacinskeKartice(source.getIdMagacinskeKartice());
		magDTO.setCena(source.getCena());
		magDTO.setKolicinaIzlaza(source.getKolicinaIzlaza());
		magDTO.setKolicinaPocetnogStanja(source.getKolicinaPocetnogStanja());
		magDTO.setKolicinaUlaza(source.getKolicinaUlaza());
		magDTO.setRedniBrMagacinskeKar(source.getRedniBrMagacinskeKar());
		magDTO.setUkupnaKolicina(source.getUkupnaKolicina());
		magDTO.setUkupnaVrednost(source.getUkupnaVrednost());
		magDTO.setVrednostIzlaza(source.getVrednostIzlaza());
		magDTO.setVrednostUlaza(source.getVrednostUlaza());
		magDTO.setVrednostPocetnogStanja(source.getVrednostPocetnogStanja());
		magDTO.setVrednostUlaza(source.getVrednostUlaza());
		magDTO.setArtikal(artikalToDTO.convert(source.getArtikal()));
		magDTO.setAnalitikeMagacinskeKartice(analitikaToDTO.convert(source.getAnalitikeMagacinskeKartice()));
		//analitika magacinske kartice
		//magDTO.setMagacin(magacinToDTO.convert(source.getMagacin()));
		magDTO.setPoslovnaGodina(poslGodToDTO.convert(source.getPoslovnaGodina()));
		return magDTO;
	}
	
	
	public Set<MagacinskaKarticaDTO> convert(Set<MagacinskaKartica> source){
		Set<MagacinskaKarticaDTO> magacinskeKartice = new HashSet<MagacinskaKarticaDTO>();
		for(MagacinskaKartica mk : source) {
			magacinskeKartice.add(convert(mk));
		}
		return magacinskeKartice;
	}
	
	public List<MagacinskaKartica> convertSetToList(Set<MagacinskaKartica> set){
        // create an empty list 
        List<MagacinskaKartica> list = new ArrayList<>(); 
  
        // push each element in the set into the list 
        for (MagacinskaKartica a : set) 
            list.add(a); 
  
        // return the list 
        return list; 
	}
	

}
