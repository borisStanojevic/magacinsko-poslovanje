package ftn.sit.pi.magacinskoposlovanje.dto.converters;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.sit.pi.magacinskoposlovanje.domain.AnalitikaMagacinskeKartice;
import ftn.sit.pi.magacinskoposlovanje.dto.AnalitikaMagacinskeKarticeDTO;

@Component
public class AnalitikaMagacinskeKarticeToDTO implements Converter<AnalitikaMagacinskeKartice, AnalitikaMagacinskeKarticeDTO> {

	@Autowired
	MagacinskaKarticaToDTO magKartToDTO;
	
	@Override
	public AnalitikaMagacinskeKarticeDTO convert(AnalitikaMagacinskeKartice source) {
		
		if(source == null) {
			return null;
		}
		AnalitikaMagacinskeKarticeDTO analitikaDTO = new AnalitikaMagacinskeKarticeDTO();
		analitikaDTO.setIdAnalitike(source.getIdAnalitike());
		analitikaDTO.setCena(source.getCena());
		analitikaDTO.setDatumNastanka(source.getDatumNastanka());
		analitikaDTO.setKolicina(source.getKolicina());
		analitikaDTO.setSmer(source.getSmer());
		analitikaDTO.setTipPrometa(source.getTipPrometa());
		analitikaDTO.setVrednost(source.getVrednost());
		//analitikaDTO.setMagacinskaKartica(magKartToDTO.convert(source.getMagacinskaKartica()));
	
		return analitikaDTO;
	}
	
	public Set<AnalitikaMagacinskeKarticeDTO> convert(Set<AnalitikaMagacinskeKartice> source) {
		Set<AnalitikaMagacinskeKarticeDTO> analitikeMagKart = new HashSet<AnalitikaMagacinskeKarticeDTO>();
		for(AnalitikaMagacinskeKartice a : source) {
			analitikeMagKart.add(convert(a));
		}
		return analitikeMagKart;
	}
}
