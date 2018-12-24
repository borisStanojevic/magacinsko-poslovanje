package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.entities.PoslovniPartner;

public class PoslovniPartnerDTO implements Serializable {
	
	private Integer sifraPartnera;
	private String adresaPoslovnogPartnera;
	private String nazivPartnera;
	private String pib;
	private String tipPartnera;
	private MestoDTO mesto;
	private Set<PrometniDokumentDTO> prometniDokumenti;
	
	
	public static Set<PoslovniPartnerDTO> convert(Set<PoslovniPartner> poslovniPartnerEntitySet) {
		Set<PoslovniPartnerDTO> poslovniPartnerDTOSet = new HashSet<>();
		Iterator<PoslovniPartner> iterator = poslovniPartnerEntitySet.iterator();
		while (iterator.hasNext()) {
			PoslovniPartner poslovniPartner = (PoslovniPartner) iterator.next();
			PoslovniPartnerDTO poslovniPartnerDTO = new PoslovniPartnerDTO(poslovniPartner);
			poslovniPartnerDTOSet.add(poslovniPartnerDTO);			
		}
		return poslovniPartnerDTOSet;
	}
	
	
	public PoslovniPartnerDTO() {		
	}

	public PoslovniPartnerDTO(Integer sifraPartnera, String adresaPoslovnogPartnera, String nazivPartnera, String pib,
			String tipPartnera, MestoDTO mesto, Set<PrometniDokumentDTO> prometniDokumenti) {
		super();
		this.sifraPartnera = sifraPartnera;
		this.adresaPoslovnogPartnera = adresaPoslovnogPartnera;
		this.nazivPartnera = nazivPartnera;
		this.pib = pib;
		this.tipPartnera = tipPartnera;
		this.mesto = mesto;
		this.prometniDokumenti = prometniDokumenti;
	}

	public PoslovniPartnerDTO(PoslovniPartner poslovniPartner) {
		this(poslovniPartner.getSifraPartnera(), poslovniPartner.getAdresaPoslovnogPartnera(), poslovniPartner.getNazivPartnera(), poslovniPartner.getPib(), 
				poslovniPartner.getTipPartnera(), new MestoDTO(poslovniPartner.getMesto()), PrometniDokumentDTO.convert(poslovniPartner.getPrometniDokumenti()));
	}


	public Integer getSifraPartnera() {
		return sifraPartnera;
	}

	public void setSifraPartnera(Integer sifraPartnera) {
		this.sifraPartnera = sifraPartnera;
	}

	public String getAdresaPoslovnogPartnera() {
		return adresaPoslovnogPartnera;
	}

	public void setAdresaPoslovnogPartnera(String adresaPoslovnogPartnera) {
		this.adresaPoslovnogPartnera = adresaPoslovnogPartnera;
	}

	public String getNazivPartnera() {
		return nazivPartnera;
	}

	public void setNazivPartnera(String nazivPartnera) {
		this.nazivPartnera = nazivPartnera;
	}

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getTipPartnera() {
		return tipPartnera;
	}

	public void setTipPartnera(String tipPartnera) {
		this.tipPartnera = tipPartnera;
	}

	public MestoDTO getMesto() {
		return mesto;
	}

	public void setMesto(MestoDTO mesto) {
		this.mesto = mesto;
	}

	public Set<PrometniDokumentDTO> getPrometniDokumenti() {
		return prometniDokumenti;
	}

	public void setPrometniDokumenti(Set<PrometniDokumentDTO> prometniDokumenti) {
		this.prometniDokumenti = prometniDokumenti;
	}
	
	
	
}
