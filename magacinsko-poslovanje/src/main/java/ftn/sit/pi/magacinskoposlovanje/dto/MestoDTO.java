package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.Mesto;

public class MestoDTO implements Serializable {

	private String postanskiBroj;
	private String drzava;
	private String nazivMesta;
	private Set<PoslovniPartnerDTO> poslovniPartner;
	private Set<PreduzeceDTO> preduzeca;
	
	public static Set<MestoDTO> convert(Set<Mesto> mestoEntitySet) {
		Set<MestoDTO> mestoDTOSet = new HashSet<>();
		Iterator<Mesto> iterator = mestoEntitySet.iterator();
		while (iterator.hasNext()) {
			Mesto mesto = (Mesto) iterator.next();
			MestoDTO mestoDTO = new MestoDTO(mesto);
			mestoDTOSet.add(mestoDTO);			
		}
		return mestoDTOSet;
	}
	
	public MestoDTO() {		
	}

	public MestoDTO(String postanskiBroj, String drzava, String nazivMesta, Set<PoslovniPartnerDTO> poslovniPartner,
			Set<PreduzeceDTO> preduzeca) {
		super();
		this.postanskiBroj = postanskiBroj;
		this.drzava = drzava;
		this.nazivMesta = nazivMesta;
		this.poslovniPartner = poslovniPartner;
		this.preduzeca = preduzeca;
	}

	public MestoDTO(Mesto mesto) {
		this(mesto.getPostanskiBroj(), mesto.getDrzava(), mesto.getNazivMesta(), PoslovniPartnerDTO.convert(mesto.getPoslovniPartneri()), PreduzeceDTO.convert(mesto.getPreduzeca()));
	}

	public String getPostanskiBroj() {
		return postanskiBroj;
	}

	public void setPostanskiBroj(String postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getNazivMesta() {
		return nazivMesta;
	}

	public void setNazivMesta(String nazivMesta) {
		this.nazivMesta = nazivMesta;
	}

	public Set<PoslovniPartnerDTO> getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(Set<PoslovniPartnerDTO> poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public Set<PreduzeceDTO> getPreduzeca() {
		return preduzeca;
	}

	public void setPreduzeca(Set<PreduzeceDTO> preduzeca) {
		this.preduzeca = preduzeca;
	}
	
	
}
