package ftn.sit.pi.magacinskoposlovanje.entities;

import java.io.Serializable;
import javax.persistence.*;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	public PoslovniPartner addPoslovniPartneri(PoslovniPartner poslovniPartneri) {
		getPoslovniPartneri().add(poslovniPartneri);
		poslovniPartneri.setMesto(this);

		return poslovniPartneri;
	}

	public PoslovniPartner removePoslovniPartneri(PoslovniPartner poslovniPartneri) {
		getPoslovniPartneri().remove(poslovniPartneri);
		poslovniPartneri.setMesto(null);

		return poslovniPartneri;
	}

	public Set<Preduzece> getPreduzeca() {
		return this.preduzeca;
	}

	public void setPreduzeca(Set<Preduzece> preduzeca) {
		this.preduzeca = preduzeca;
	}

	public Preduzece addPreduzeca(Preduzece preduzeca) {
		getPreduzeca().add(preduzeca);
		preduzeca.setMesto(this);

		return preduzeca;
	}

	public Preduzece removePreduzeca(Preduzece preduzeca) {
		getPreduzeca().remove(preduzeca);
		preduzeca.setMesto(null);

		return preduzeca;
	}

}