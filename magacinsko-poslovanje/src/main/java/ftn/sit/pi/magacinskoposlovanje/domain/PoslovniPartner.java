package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="poslovni_partner")
@NamedQuery(name="PoslovniPartner.findAll", query="SELECT p FROM PoslovniPartner p")
public class PoslovniPartner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SIFRA_PARTNERA")
	private Integer sifraPartnera;

	@Column(name="ADRESA_POSLOVNOG_PARTNERA")
	private String adresaPoslovnogPartnera;

	@Column(name="NAZIV_PARTNERA")
	private String nazivPartnera;

	private String pib;

	@Column(name="TIP_PARTNERA")
	private TipPartnera tipPartnera;

	//bi-directional many-to-one association to Mesto
	@ManyToOne
	@JoinColumn(name="POSTANSKI_BROJ")
	private Mesto mesto;

	//bi-directional many-to-one association to PrometniDokument
	@OneToMany(mappedBy="poslovniPartner")
	private Set<PrometniDokument> prometniDokumenti;

	public PoslovniPartner() {
	}

	public Integer getSifraPartnera() {
		return this.sifraPartnera;
	}

	public void setSifraPartnera(Integer sifraPartnera) {
		this.sifraPartnera = sifraPartnera;
	}

	public String getAdresaPoslovnogPartnera() {
		return this.adresaPoslovnogPartnera;
	}

	public void setAdresaPoslovnogPartnera(String adresaPoslovnogPartnera) {
		this.adresaPoslovnogPartnera = adresaPoslovnogPartnera;
	}

	public String getNazivPartnera() {
		return this.nazivPartnera;
	}

	public void setNazivPartnera(String nazivPartnera) {
		this.nazivPartnera = nazivPartnera;
	}

	public String getPib() {
		return this.pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public TipPartnera getTipPartnera() {
		return this.tipPartnera;
	}

	public void setTipPartnera(TipPartnera tipPartnera) {
		this.tipPartnera = tipPartnera;
	}

	public Mesto getMesto() {
		return this.mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	public Set<PrometniDokument> getPrometniDokumenti() {
		return this.prometniDokumenti;
	}

	public void setPrometniDokumenti(Set<PrometniDokument> prometniDokumenti) {
		this.prometniDokumenti = prometniDokumenti;
	}

	public PrometniDokument addPrometniDokument(PrometniDokument prometniDokument) {
		getPrometniDokumenti().add(prometniDokument);
		prometniDokument.setPoslovniPartner(this);

		return prometniDokument;
	}

	public PrometniDokument removePrometniDokument(PrometniDokument prometniDokument) {
		getPrometniDokumenti().remove(prometniDokument);
		prometniDokument.setPoslovniPartner(null);

		return prometniDokument;
	}

}