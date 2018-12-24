package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.entities.PoslovnaGodina;

public class PoslovnaGodinaDTO implements Serializable {

	private Integer idGodine;
	private Date godina;
	private Byte zakljucena;
	private Set<MagacinskaKarticaDTO> magacinskeKartice;
	private Set<PrometniDokumentDTO> prometniDokumenti;
	
	
	public static Set<PoslovnaGodinaDTO> convert(Set<PoslovnaGodina> poslovnaGodinaEntitySet) {
		Set<PoslovnaGodinaDTO> poslovnaGodinaDTOSet = new HashSet<>();
		Iterator<PoslovnaGodina> iterator = poslovnaGodinaEntitySet.iterator();
		while (iterator.hasNext()) {
			PoslovnaGodina poslovnaGodina = (PoslovnaGodina) iterator.next();
			PoslovnaGodinaDTO poslovnaGodinaDTO = new PoslovnaGodinaDTO(poslovnaGodina);
			poslovnaGodinaDTOSet.add(poslovnaGodinaDTO);			
		}
		return poslovnaGodinaDTOSet;
	}
	
	
	public PoslovnaGodinaDTO() {		
	}

	public PoslovnaGodinaDTO(Integer idGodine, Date godina, Byte zakljucena,
			Set<MagacinskaKarticaDTO> magacinskeKartice, Set<PrometniDokumentDTO> prometniDokumenti) {
		super();
		this.idGodine = idGodine;
		this.godina = godina;
		this.zakljucena = zakljucena;
		this.magacinskeKartice = magacinskeKartice;
		this.prometniDokumenti = prometniDokumenti;
	}

	public PoslovnaGodinaDTO(PoslovnaGodina poslovnaGodina) {
		this(poslovnaGodina.getIdGodine(), poslovnaGodina.getGodina(), poslovnaGodina.getZakljucena(), MagacinskaKarticaDTO.convert(poslovnaGodina.getMagacinskeKartice()), PrometniDokumentDTO.convert(poslovnaGodina.getPrometniDokumenti()));
	}


	public Integer getIdGodine() {
		return idGodine;
	}

	public void setIdGodine(Integer idGodine) {
		this.idGodine = idGodine;
	}

	public Date getGodina() {
		return godina;
	}

	public void setGodina(Date godina) {
		this.godina = godina;
	}

	public Byte getZakljucena() {
		return zakljucena;
	}

	public void setZakljucena(Byte zakljucena) {
		this.zakljucena = zakljucena;
	}

	public Set<MagacinskaKarticaDTO> getMagacinskeKartice() {
		return magacinskeKartice;
	}

	public void setMagacinskeKartice(Set<MagacinskaKarticaDTO> magacinskeKartice) {
		this.magacinskeKartice = magacinskeKartice;
	}

	public Set<PrometniDokumentDTO> getPrometniDokumenti() {
		return prometniDokumenti;
	}

	public void setPrometniDokumenti(Set<PrometniDokumentDTO> prometniDokumenti) {
		this.prometniDokumenti = prometniDokumenti;
	}
	
	
}
