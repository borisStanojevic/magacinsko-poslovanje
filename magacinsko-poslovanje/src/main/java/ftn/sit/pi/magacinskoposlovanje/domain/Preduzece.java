package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


@Entity
@NamedQuery(name="Preduzece.findAll", query="SELECT p FROM Preduzece p")
public class Preduzece implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SIFRA_PREDUZECA")
	private Integer sifraPreduzeca;

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

	public Integer getSifraPreduzeca() {
		return this.sifraPreduzeca;
	}

	public void setSifraPreduzeca(Integer sifraPreduzeca) {
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

	public KategorijaArtikala addKategorijaArtikala(KategorijaArtikala kategorijaArtikala) {
		getKategorijeArtikala().add(kategorijaArtikala);
		kategorijaArtikala.setPreduzece(this);

		return kategorijaArtikala;
	}

	public KategorijaArtikala removeKategorijaArtikala(KategorijaArtikala kategorijaArtikala) {
		getKategorijeArtikala().remove(kategorijaArtikala);
		kategorijaArtikala.setPreduzece(null);

		return kategorijaArtikala;
	}

	public Set<Magacin> getMagacini() {
		return this.magacini;
	}

	public void setMagacini(Set<Magacin> magacini) {
		this.magacini = magacini;
	}

	public Magacin addMagacin(Magacin magacin) {
		getMagacini().add(magacin);
		magacin.setPreduzece(this);

		return magacin;
	}

	public Magacin removeMagacin(Magacin magacin) {
		getMagacini().remove(magacin);
		magacin.setPreduzece(null);

		return magacin;
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