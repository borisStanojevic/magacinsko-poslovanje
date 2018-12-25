package ftn.sit.pi.magacinskoposlovanje.domain;

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
	private Integer sifraArtikla;

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
	private Set<StavkaPrometnogDokumenta> stavkePrometnogDokumenta;

	public Artikal() {
	}

	public Integer getSifraArtikla() {
		return this.sifraArtikla;
	}

	public void setSifraArtikla(Integer sifraArtikla) {
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

	public MagacinskaKartica addMagacinskaKartica(MagacinskaKartica magacinskaKartice) {
		getMagacinskeKartice().add(magacinskaKartice);
		magacinskaKartice.setArtikal(this);

		return magacinskaKartice;
	}

	public MagacinskaKartica removeMagacinskaKartica(MagacinskaKartica magacinskaKartica) {
		getMagacinskeKartice().remove(magacinskaKartica);
		magacinskaKartica.setArtikal(null);

		return magacinskaKartica;
	}

	public Set<StavkaPrometnogDokumenta> getStavkePrometnogDokumenta() {
		return this.stavkePrometnogDokumenta;
	}

	public void setStavkePrometnogDokumenta(Set<StavkaPrometnogDokumenta> stavkePrometnogDokumenta) {
		this.stavkePrometnogDokumenta = stavkePrometnogDokumenta;
	}

	public StavkaPrometnogDokumenta addStavkaPrometnogDokumenta(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		getStavkePrometnogDokumenta().add(stavkaPrometnogDokumenta);
		stavkaPrometnogDokumenta.setArtikal(this);

		return stavkaPrometnogDokumenta;
	}

	public StavkaPrometnogDokumenta removeStavkaPrometnogDokumenta(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		getStavkePrometnogDokumenta().remove(stavkaPrometnogDokumenta);
		stavkaPrometnogDokumenta.setArtikal(null);

		return stavkaPrometnogDokumenta;
	}

}