package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="kategorija_artikala")
@NamedQuery(name="KategorijaArtikala.findAll", query="SELECT k FROM KategorijaArtikala k")
public class KategorijaArtikala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_KATEGORIJE")
	private Integer idKategorije;

	@Column(name="NAZIV_KATEGORIJE")
	private String nazivKategorije;

	//bi-directional many-to-one association to Artikal
	@OneToMany(mappedBy="kategorijaArtikala")
	private Set<Artikal> artikli;

	//bi-directional many-to-one association to Preduzece
	@ManyToOne
	@JoinColumn(name="SIFRA_PREDUZECA")
	private Preduzece preduzece;

	public KategorijaArtikala() {
		artikli = new HashSet<>();
	}

	public Integer getIdKategorije() {
		return this.idKategorije;
	}

	public void setIdKategorije(Integer idKategorije) {
		this.idKategorije = idKategorije;
	}

	public String getNazivKategorije() {
		return this.nazivKategorije;
	}

	public void setNazivKategorije(String nazivKategorije) {
		this.nazivKategorije = nazivKategorije;
	}

	public Set<Artikal> getArtikli() {
		return this.artikli;
	}

	public void setArtikli(Set<Artikal> artikli) {
		this.artikli = artikli;
	}

	public Artikal addArtikal(Artikal artikal) {
		getArtikli().add(artikal);
		artikal.setKategorijaArtikala(this);

		return artikal;
	}

	public Artikal removeArtikal(Artikal artikal) {
		getArtikli().remove(artikal);
		artikal.setKategorijaArtikala(null);

		return artikal;
	}

	public Preduzece getPreduzece() {
		return this.preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

}