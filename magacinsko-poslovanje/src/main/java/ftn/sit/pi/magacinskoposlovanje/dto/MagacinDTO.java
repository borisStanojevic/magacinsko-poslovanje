package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.Magacin;

public class MagacinDTO implements Serializable {

	private Integer sifraMagacina;
	private String nazivMagacina;
	private PreduzeceDTO preduzece;
	private RadnikDTO radnik;
	private Set<MagacinskaKarticaDTO> magacinskeKartice;
	private Set<PrometniDokumentDTO> prometniDokument;
	
	public static Set<MagacinDTO> convert(Set<Magacin> magacinEntitySet) {
		Set<MagacinDTO> magacinDTOSet = new HashSet<>();
		Iterator<Magacin> iterator = magacinEntitySet.iterator();
		while (iterator.hasNext()) {
			Magacin magacin = (Magacin) iterator.next();
			MagacinDTO magacinDTO = new MagacinDTO(magacin);
			magacinDTOSet.add(magacinDTO);			
		}
		return magacinDTOSet;
	}
	
	public MagacinDTO() {		
	}

	public MagacinDTO(Integer sifraMagacina, String nazivMagacina, PreduzeceDTO preduzece, RadnikDTO radnik,
			Set<MagacinskaKarticaDTO> magacinskeKartice, Set<PrometniDokumentDTO> prometniDokument) {
		super();
		this.sifraMagacina = sifraMagacina;
		this.nazivMagacina = nazivMagacina;
		this.preduzece = preduzece;
		this.radnik = radnik;
		this.magacinskeKartice = magacinskeKartice;
		this.prometniDokument = prometniDokument;
	}

	public MagacinDTO(Magacin magacin) {
		this(magacin.getSifraMagacina(), magacin.getNazivMagacina(), new PreduzeceDTO(magacin.getPreduzece()), new RadnikDTO(magacin.getRadnik()), 
				MagacinskaKarticaDTO.convert(magacin.getMagacinskeKartice()), PrometniDokumentDTO.convert(magacin.getPrometniDokumenti()));
	}

	public Integer getSifraMagacina() {
		return sifraMagacina;
	}

	public void setSifraMagacina(Integer sifraMagacina) {
		this.sifraMagacina = sifraMagacina;
	}

	public String getNazivMagacina() {
		return nazivMagacina;
	}

	public void setNazivMagacina(String nazivMagacina) {
		this.nazivMagacina = nazivMagacina;
	}

	public PreduzeceDTO getPreduzece() {
		return preduzece;
	}

	public void setPreduzece(PreduzeceDTO preduzece) {
		this.preduzece = preduzece;
	}

	public RadnikDTO getRadnik() {
		return radnik;
	}

	public void setRadnik(RadnikDTO radnik) {
		this.radnik = radnik;
	}

	public Set<MagacinskaKarticaDTO> getMagacinskeKartice() {
		return magacinskeKartice;
	}

	public void setMagacinskeKartice(Set<MagacinskaKarticaDTO> magacinskeKartice) {
		this.magacinskeKartice = magacinskeKartice;
	}

	public Set<PrometniDokumentDTO> getPrometniDokument() {
		return prometniDokument;
	}

	public void setPrometniDokument(Set<PrometniDokumentDTO> prometniDokument) {
		this.prometniDokument = prometniDokument;
	}
	
	
}
