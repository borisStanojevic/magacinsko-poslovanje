package ftn.sit.pi.magacinskoposlovanje.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the artikal database table.
 * 
 */
@Entity
@NamedQuery(name="Artikal.findAll", query="SELECT a FROM Artikal a")
public class Artikal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SIFRA_ARTIKLA")
	private int sifraArtikla;

	@Column(name="NAZIV_ARTIKLA")
	private String nazivArtikla;

	//bi-directional many-to-one association to JedinicaMere
	@ManyToOne
	@JoinColumn(name="ID_JED_MERE")
	private JedinicaMere jedinicaMere;

	//bi-directional many-to-one association to KategorijaArtikala
	@ManyToOne
	@JoinColumn(name="ID_KATEGORIJE")
	private KategorijaArtikala kategorijaArtikala;

	//bi-directional many-to-one association to MagacinskaKartica
	@OneToMany(mappedBy="artikal")
	private Set<MagacinskaKartica> magacinskeKartice;

	//bi-directional many-to-one association to StavkePrometnogDokumenta
	@OneToMany(mappedBy="artikal")
	private Set<StavkePrometnogDokumenta> stavkePrometnogDokumenta;

	public Artikal() {
	}

	public int getSifraArtikla() {
		return this.sifraArtikla;
	}

	public void setSifraArtikla(int sifraArtikla) {
		this.sifraArtikla = sifraArtikla;
	}

	public String getNazivArtikla() {
		return this.nazivArtikla;
	}

	public void setNazivArtikla(String nazivArtikla) {
		this.nazivArtikla = nazivArtikla;
	}

	public JedinicaMere getJedinicaMere() {
		return this.jedinicaMere;
	}

	public void setJedinicaMere(JedinicaMere jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}

	public KategorijaArtikala getKategorijaArtikala() {
		return this.kategorijaArtikala;
	}

	public void setKategorijaArtikala(KategorijaArtikala kategorijaArtikala) {
		this.kategorijaArtikala = kategorijaArtikala;
	}

	public Set<MagacinskaKartica> getMagacinskeKartice() {
		return this.magacinskeKartice;
	}

	public void setMagacinskeKartice(Set<MagacinskaKartica> magacinskeKartice) {
		this.magacinskeKartice = magacinskeKartice;
	}

	public MagacinskaKartica addMagacinskeKartice(MagacinskaKartica magacinskeKartice) {
		getMagacinskeKartice().add(magacinskeKartice);
		magacinskeKartice.setArtikal(this);

		return magacinskeKartice;
	}

	public MagacinskaKartica removeMagacinskeKartice(MagacinskaKartica magacinskeKartice) {
		getMagacinskeKartice().remove(magacinskeKartice);
		magacinskeKartice.setArtikal(null);

		return magacinskeKartice;
	}

	public Set<StavkePrometnogDokumenta> getStavkePrometnogDokumenta() {
		return this.stavkePrometnogDokumenta;
	}

	public void setStavkePrometnogDokumenta(Set<StavkePrometnogDokumenta> stavkePrometnogDokumenta) {
		this.stavkePrometnogDokumenta = stavkePrometnogDokumenta;
	}

	public StavkePrometnogDokumenta addStavkePrometnogDokumenta(StavkePrometnogDokumenta stavkePrometnogDokumenta) {
		getStavkePrometnogDokumenta().add(stavkePrometnogDokumenta);
		stavkePrometnogDokumenta.setArtikal(this);

		return stavkePrometnogDokumenta;
	}

	public StavkePrometnogDokumenta removeStavkePrometnogDokumenta(StavkePrometnogDokumenta stavkePrometnogDokumenta) {
		getStavkePrometnogDokumenta().remove(stavkePrometnogDokumenta);
		stavkePrometnogDokumenta.setArtikal(null);

		return stavkePrometnogDokumenta;
	}

}