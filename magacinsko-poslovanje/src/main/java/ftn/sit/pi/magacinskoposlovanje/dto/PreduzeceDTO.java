package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.Preduzece;

public class PreduzeceDTO implements Serializable {

	private Integer sifraPreduzeca;
	private String adresaPreduzeca;
	private String nazivPreduzeca;
	private String pib; 
	private Set<KategorijaArtikalaDTO> kategorijeArtikala;
	private Set<MagacinDTO> magacini;
	private MestoDTO mesto;
	private RadnikDTO radnik;
	
	
	public static Set<PreduzeceDTO> convert(Set<Preduzece> preduzeceEntitySet) {
		Set<PreduzeceDTO> preduzeceDTOSet = new HashSet<>();
		Iterator<Preduzece> iterator = preduzeceEntitySet.iterator();
		while (iterator.hasNext()) {
			Preduzece preduzece = (Preduzece) iterator.next();
			PreduzeceDTO preduzeceDTO = new PreduzeceDTO(preduzece);
			preduzeceDTOSet.add(preduzeceDTO);			
		}
		return preduzeceDTOSet;
	}
	
	
	public PreduzeceDTO() {		
	}

	public PreduzeceDTO(Integer sifraPreduzeca, String adresaPreduzeca, String nazivPreduzeca, String pib,
			Set<KategorijaArtikalaDTO> kategorijeArtikala, Set<MagacinDTO> magacini, MestoDTO mesto, RadnikDTO radnik) {
		super();
		this.sifraPreduzeca = sifraPreduzeca;
		this.adresaPreduzeca = adresaPreduzeca;
		this.nazivPreduzeca = nazivPreduzeca;
		this.pib = pib;
		this.kategorijeArtikala = kategorijeArtikala;
		this.magacini = magacini;
		this.mesto = mesto;
		this.radnik = radnik;
	}

	public PreduzeceDTO(Preduzece preduzece) {
		this(preduzece.getSifraPreduzeca(), preduzece.getAdresaPreduzeca(), preduzece.getNazivPreduzeca(), preduzece.getPib(), 
				KategorijaArtikalaDTO.convert(preduzece.getKategorijeArtikala()), MagacinDTO.convert(preduzece.getMagacini()), 
				new MestoDTO(preduzece.getMesto()), new RadnikDTO(preduzece.getRadnik()));
	}


	public Integer getSifraPreduzeca() {
		return sifraPreduzeca;
	}

	public void setSifraPreduzeca(Integer sifraPreduzeca) {
		this.sifraPreduzeca = sifraPreduzeca;
	}

	public String getAdresaPreduzeca() {
		return adresaPreduzeca;
	}

	public void setAdresaPreduzeca(String adresaPreduzeca) {
		this.adresaPreduzeca = adresaPreduzeca;
	}

	public String getNazivPreduzeca() {
		return nazivPreduzeca;
	}

	public void setNazivPreduzeca(String nazivPreduzeca) {
		this.nazivPreduzeca = nazivPreduzeca;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public Set<KategorijaArtikalaDTO> getKategorijeArtikala() {
		return kategorijeArtikala;
	}

	public void setKategorijeArtikala(Set<KategorijaArtikalaDTO> kategorijeArtikala) {
		this.kategorijeArtikala = kategorijeArtikala;
	}

	public Set<MagacinDTO> getMagacini() {
		return magacini;
	}

	public void setMagacini(Set<MagacinDTO> magacini) {
		this.magacini = magacini;
	}

	public MestoDTO getMesto() {
		return mesto;
	}

	public void setMesto(MestoDTO mesto) {
		this.mesto = mesto;
	}

	public RadnikDTO getRadnik() {
		return radnik;
	}

	public void setRadnik(RadnikDTO radnik) {
		this.radnik = radnik;
	}
	
	
	
}
