package ftn.sit.pi.magacinskoposlovanje.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;
import ftn.sit.pi.magacinskoposlovanje.domain.Status;
import ftn.sit.pi.magacinskoposlovanje.domain.TipPrometnogDokumenta;

public class PrometniDokumentDTO implements Serializable {
	
	private Integer idPrometnogDokumenta;
	private Integer brojPrometnogDokumenta;
	private Date datumFormiranja;
	private Date datumKnjizenja;
	private Integer redniBrojDokumetna;
	private Status status;
	private TipPrometnogDokumenta tipPrometnogDokumenta;
	private MagacinDTO magacin;
	private PoslovnaGodinaDTO poslovnaGodina;
	private PoslovniPartnerDTO poslovniPartner;
	private Set<StavkePrometnogDokumentaDTO> stavkePrometnogDokumenta;
	
	
	public static Set<PrometniDokumentDTO> convert(Set<PrometniDokument> prometniDokumentEntitySet) {
		Set<PrometniDokumentDTO> prometniDokumentDTOSet = new HashSet<>();
		Iterator<PrometniDokument> iterator = prometniDokumentEntitySet.iterator();
		while (iterator.hasNext()) {
			PrometniDokument prometniDokument = (PrometniDokument) iterator.next();
			PrometniDokumentDTO prometniDokumentDTO = new PrometniDokumentDTO(prometniDokument);
			prometniDokumentDTOSet.add(prometniDokumentDTO);			
		}
		return prometniDokumentDTOSet;
	}
	
	
	public PrometniDokumentDTO() {		
	}

	public PrometniDokumentDTO(Integer idPrometnogDokumenta, Integer brojPrometnogDokumenta, Date datumFormiranja,
			Date datumKnjizenja, Integer redniBrojDokumetna, Status status, TipPrometnogDokumenta tipPrometnogDokumenta,
			MagacinDTO magacin, PoslovnaGodinaDTO poslovnaGodina, PoslovniPartnerDTO poslovniPartner,
			Set<StavkePrometnogDokumentaDTO> stavkePrometnogDokumenta) {
		super();
		this.idPrometnogDokumenta = idPrometnogDokumenta;
		this.brojPrometnogDokumenta = brojPrometnogDokumenta;
		this.datumFormiranja = datumFormiranja;
		this.datumKnjizenja = datumKnjizenja;
		this.redniBrojDokumetna = redniBrojDokumetna;
		this.status = status;
		this.tipPrometnogDokumenta = tipPrometnogDokumenta;
		this.magacin = magacin;
		this.poslovnaGodina = poslovnaGodina;
		this.poslovniPartner = poslovniPartner;
		this.stavkePrometnogDokumenta = stavkePrometnogDokumenta;
	}

	public PrometniDokumentDTO(PrometniDokument prometniDokument) {
		this(prometniDokument.getIdPrometnogDokumenta(), prometniDokument.getBrojPrometnogDokumenta(), prometniDokument.getDatumFormiranja(), 
				prometniDokument.getDatumKnjizenja(), prometniDokument.getRedniBrojDokumetna(), prometniDokument.getStatus(), prometniDokument.getTipPrometnogDokumenta(), 
				new MagacinDTO(prometniDokument.getMagacin()), new PoslovnaGodinaDTO(prometniDokument.getPoslovnaGodina()), new PoslovniPartnerDTO(prometniDokument.getPoslovniPartner()), 
				StavkePrometnogDokumentaDTO.convert(prometniDokument.getStavkePrometnogDokumenta()));
	}


	public Integer getIdPrometnogDokumenta() {
		return idPrometnogDokumenta;
	}

	public void setIdPrometnogDokumenta(Integer idPrometnogDokumenta) {
		this.idPrometnogDokumenta = idPrometnogDokumenta;
	}

	public Integer getBrojPrometnogDokumenta() {
		return brojPrometnogDokumenta;
	}

	public void setBrojPrometnogDokumenta(Integer brojPrometnogDokumenta) {
		this.brojPrometnogDokumenta = brojPrometnogDokumenta;
	}

	public Date getDatumFormiranja() {
		return datumFormiranja;
	}

	public void setDatumFormiranja(Date datumFormiranja) {
		this.datumFormiranja = datumFormiranja;
	}

	public Date getDatumKnjizenja() {
		return datumKnjizenja;
	}

	public void setDatumKnjizenja(Date datumKnjizenja) {
		this.datumKnjizenja = datumKnjizenja;
	}

	public Integer getRedniBrojDokumetna() {
		return redniBrojDokumetna;
	}

	public void setRedniBrojDokumetna(Integer redniBrojDokumetna) {
		this.redniBrojDokumetna = redniBrojDokumetna;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TipPrometnogDokumenta getTipPrometnogDokumenta() {
		return tipPrometnogDokumenta;
	}

	public void setTipPrometnogDokumenta(TipPrometnogDokumenta tipPrometnogDokumenta) {
		this.tipPrometnogDokumenta = tipPrometnogDokumenta;
	}

	public MagacinDTO getMagacin() {
		return magacin;
	}

	public void setMagacin(MagacinDTO magacin) {
		this.magacin = magacin;
	}

	public PoslovnaGodinaDTO getPoslovnaGodina() {
		return poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodinaDTO poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

	public PoslovniPartnerDTO getPoslovniPartner() {
		return poslovniPartner;
	}

	public void setPoslovniPartner(PoslovniPartnerDTO poslovniPartner) {
		this.poslovniPartner = poslovniPartner;
	}

	public Set<StavkePrometnogDokumentaDTO> getStavkePrometnogDokumenta() {
		return stavkePrometnogDokumenta;
	}

	public void setStavkePrometnogDokumenta(Set<StavkePrometnogDokumentaDTO> stavkePrometnogDokumenta) {
		this.stavkePrometnogDokumenta = stavkePrometnogDokumenta;
	}
	
	
	
}
