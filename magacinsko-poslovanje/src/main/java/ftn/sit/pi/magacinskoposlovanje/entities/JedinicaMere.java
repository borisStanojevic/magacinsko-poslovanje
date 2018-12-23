package ftn.sit.pi.magacinskoposlovanje.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the jedinica_mere database table.
 * 
 */
@Entity
@Table(name="jedinica_mere")
@NamedQuery(name="JedinicaMere.findAll", query="SELECT j FROM JedinicaMere j")
public class JedinicaMere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_JED_MERE")
	private int idJedMere;

	@Column(name="NAZIV_JEDINICE_MERE")
	private String nazivJediniceMere;

	//bi-directional many-to-one association to Artikal
	@OneToMany(mappedBy="jedinicaMere")
	private Set<Artikal> artikli;

	public JedinicaMere() {
	}

	public int getIdJedMere() {
		return this.idJedMere;
	}

	public void setIdJedMere(int idJedMere) {
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

	public Artikal addArtikli(Artikal artikli) {
		getArtikli().add(artikli);
		artikli.setJedinicaMere(this);

		return artikli;
	}

	public Artikal removeArtikli(Artikal artikli) {
		getArtikli().remove(artikli);
		artikli.setJedinicaMere(null);

		return artikli;
	}

}