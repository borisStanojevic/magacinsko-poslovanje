package ftn.sit.pi.magacinskoposlovanje.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the preduzece database table.
 * 
 */
@Entity
@NamedQuery(name="Preduzece.findAll", query="SELECT p FROM Preduzece p")
public class Preduzece implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SIFRA_PREDUZECA")
	private int sifraPreduzeca;

	@Column(name="ADRESA_PREDUZECA")
	private String adresaPreduzeca;

	@Column(name="NAZIV_PREDUZECA")
	private String nazivPreduzeca;

	private String pib;

	//bi-directional many-to-one association to KategorijaArtikala
	@OneToMany(mappedBy="preduzece")
	private Set<KategorijaArtikala> kategorijeArtikala;

	//bi-directional many-to-one association to Magacin
	@OneToMany(mappedBy="preduzece")
	private Set<Magacin> magacini;

	//bi-directional many-to-one association to Mesto
	@ManyToOne
	@JoinColumn(name="POSTANSKI_BROJ")
	private Mesto mesto;

	//bi-directional many-to-one association to Radnik
	@ManyToOne
	@JoinColumn(name="ID_RADNIKA")
	private Radnik radnik;

	public Preduzece() {
	}

	public int getSifraPreduzeca() {
		return this.sifraPreduzeca;
	}

	public void setSifraPreduzeca(int sifraPreduzeca) {
		this.sifraPreduzeca = sifraPreduzeca;
	}

	public String getAdresaPreduzeca() {
		return this.adresaPreduzeca;
	}

	public void setAdresaPreduzeca(String adresaPreduzeca) {
		this.adresaPreduzeca = adresaPreduzeca;
	}

	public String getNazivPreduzeca() {
		return this.nazivPreduzeca;
	}

	public void setNazivPreduzeca(String nazivPreduzeca) {
		this.nazivPreduzeca = nazivPreduzeca;
	}

	public String getPib() {
		return this.pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public Set<KategorijaArtikala> getKategorijeArtikala() {
		return this.kategorijeArtikala;
	}

	public void setKategorijeArtikala(Set<KategorijaArtikala> kategorijeArtikala) {
		this.kategorijeArtikala = kategorijeArtikala;
	}

	public KategorijaArtikala addKategorijeArtikala(KategorijaArtikala kategorijeArtikala) {
		getKategorijeArtikala().add(kategorijeArtikala);
		kategorijeArtikala.setPreduzece(this);

		return kategorijeArtikala;
	}

	public KategorijaArtikala removeKategorijeArtikala(KategorijaArtikala kategorijeArtikala) {
		getKategorijeArtikala().remove(kategorijeArtikala);
		kategorijeArtikala.setPreduzece(null);

		return kategorijeArtikala;
	}

	public Set<Magacin> getMagacini() {
		return this.magacini;
	}

	public void setMagacini(Set<Magacin> magacini) {
		this.magacini = magacini;
	}

	public Magacin addMagacini(Magacin magacini) {
		getMagacini().add(magacini);
		magacini.setPreduzece(this);

		return magacini;
	}

	public Magacin removeMagacini(Magacin magacini) {
		getMagacini().remove(magacini);
		magacini.setPreduzece(null);

		return magacini;
	}

	public Mesto getMesto() {
		return this.mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	public Radnik getRadnik() {
		return this.radnik;
	}

	public void setRadnik(Radnik radnik) {
		this.radnik = radnik;
	}

}