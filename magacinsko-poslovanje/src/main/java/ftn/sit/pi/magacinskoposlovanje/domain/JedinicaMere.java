package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="jedinica_mere")
@NamedQuery(name="JedinicaMere.findAll", query="SELECT j FROM JedinicaMere j")
public class JedinicaMere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_JED_MERE")
	private Integer idJedMere;

	@Column(name="NAZIV_JEDINICE_MERE")
	private String nazivJediniceMere;

	//bi-directional many-to-one association to Artikal
	@OneToMany(mappedBy="jedinicaMere")
	private Set<Artikal> artikli;

	public JedinicaMere() {
		artikli = new HashSet<>();
	}

	public Integer getIdJedMere() {
		return this.idJedMere;
	}

	public void setIdJedMere(Integer idJedMere) {
		this.idJedMere = idJedMere;
	}

	public String getNazivJediniceMere() {
		return this.nazivJediniceMere;
	}

	public void setNazivJediniceMere(String nazivJediniceMere) {
		this.nazivJediniceMere = nazivJediniceMere;
	}

	public Set<Artikal> getArtikli() {
		return this.artikli;
	}

	public void setArtikli(Set<Artikal> artikli) {
		this.artikli = artikli;
	}

	public Artikal addArtikal(Artikal artikal) {
		getArtikli().add(artikal);
		artikal.setJedinicaMere(this);

		return artikal;
	}

	public Artikal removeArtikal(Artikal artikal) {
		getArtikli().remove(artikal);
		artikal.setJedinicaMere(null);

		return artikal;
	}

}