package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the mesto database table.
 * 
 */
@Entity
@NamedQuery(name="Mesto.findAll", query="SELECT m FROM Mesto m")
public class Mesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="POSTANSKI_BROJ")
	private String postanskiBroj;

	private String drzava;

	@Column(name="NAZIV_MESTA")
	private String nazivMesta;

	//bi-directional many-to-one association to PoslovniPartner
	@OneToMany(mappedBy="mesto")
	private Set<PoslovniPartner> poslovniPartneri;

	//bi-directional many-to-one association to Preduzece
	@OneToMany(mappedBy="mesto")
	private Set<Preduzece> preduzeca;

	public Mesto() {
		poslovniPartneri = new HashSet<>();
		preduzeca = new HashSet<>();
	}

	public String getPostanskiBroj() {
		return this.postanskiBroj;
	}

	public void setPostanskiBroj(String postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}

	public String getDrzava() {
		return this.drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getNazivMesta() {
		return this.nazivMesta;
	}

	public void setNazivMesta(String nazivMesta) {
		this.nazivMesta = nazivMesta;
	}

	public Set<PoslovniPartner> getPoslovniPartneri() {
		return this.poslovniPartneri;
	}

	public void setPoslovniPartneri(Set<PoslovniPartner> poslovniPartneri) {
		this.poslovniPartneri = poslovniPartneri;
	}

	public PoslovniPartner addPoslovniPartner(PoslovniPartner poslovniPartner) {
		getPoslovniPartneri().add(poslovniPartner);
		poslovniPartner.setMesto(this);

		return poslovniPartner;
	}

	public PoslovniPartner removePoslovniPartner(PoslovniPartner poslovniPartner) {
		getPoslovniPartneri().remove(poslovniPartner);
		poslovniPartner.setMesto(null);

		return poslovniPartner;
	}

	public Set<Preduzece> getPreduzeca() {
		return this.preduzeca;
	}

	public void setPreduzeca(Set<Preduzece> preduzeca) {
		this.preduzeca = preduzeca;
	}

	public Preduzece addPreduzece(Preduzece preduzece) {
		getPreduzeca().add(preduzece);
		preduzece.setMesto(this);

		return preduzece;
	}

	public Preduzece removePreduzeca(Preduzece preduzeca) {
		getPreduzeca().remove(preduzeca);
		preduzeca.setMesto(null);

		return preduzeca;
	}

}