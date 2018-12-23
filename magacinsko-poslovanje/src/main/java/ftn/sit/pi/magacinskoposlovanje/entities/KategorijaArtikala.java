package ftn.sit.pi.magacinskoposlovanje.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the kategorija_artikala database table.
 * 
 */
@Entity
@Table(name="kategorija_artikala")
@NamedQuery(name="KategorijaArtikala.findAll", query="SELECT k FROM KategorijaArtikala k")
public class KategorijaArtikala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_KATEGORIJE")
	private int idKategorije;

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
	}

	public int getIdKategorije() {
		return this.idKategorije;
	}

	public void setIdKategorije(int idKategorije) {
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

	public Artikal addArtikli(Artikal artikli) {
		getArtikli().add(artikli);
		artikli.setKategorijaArtikala(this);

		return artikli;
	}

	public Artikal removeArtikli(Artikal artikli) {
		getArtikli().remove(artikli);
		artikli.setKategorijaArtikala(null);

		return artikli;
	}

	public Preduzece getPreduzece() {
		return this.preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

}