package ftn.sit.pi.magacinskoposlovanje.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the magacinska_kartica database table.
 * 
 */
@Entity
@Table(name="magacinska_kartica")
@NamedQuery(name="MagacinskaKartica.findAll", query="SELECT m FROM MagacinskaKartica m")
public class MagacinskaKartica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MAGACINSKE_KARTICE")
	private int idMagacinskeKartice;

	private BigDecimal cena;

	@Column(name="KOLICINA_IZLAZA")
	private BigDecimal kolicinaIzlaza;

	@Column(name="KOLICINA_POCETNOG_STANJA")
	private BigDecimal kolicinaPocetnogStanja;

	@Column(name="KOLICINA_ULAZA")
	private BigDecimal kolicinaUlaza;

	@Column(name="REDNI_BR_MAGACINSKE_KAR")
	private int redniBrMagacinskeKar;

	@Column(name="UKUPNA_KOLICINA")
	private BigDecimal ukupnaKolicina;

	@Column(name="UKUPNA_VREDNOST")
	private BigDecimal ukupnaVrednost;

	@Column(name="VREDNOST_IZLAZA")
	private BigDecimal vrednostIzlaza;

	@Column(name="VREDNOST_POCETNOG_STANJA")
	private BigDecimal vrednostPocetnogStanja;

	@Column(name="VREDNOST_ULAZA")
	private BigDecimal vrednostUlaza;

	//bi-directional many-to-one association to AnalitikaMagacinskeKartice
	@OneToMany(mappedBy="magacinskaKartica")
	private Set<AnalitikaMagacinskeKartice> analitikeMagacinskeKartice;

	//bi-directional many-to-one association to Artikal
	@ManyToOne
	@JoinColumn(name="SIFRA_ARTIKLA")
	private Artikal artikal;

	//bi-directional many-to-one association to Magacin
	@ManyToOne
	@JoinColumn(name="SIFRA_MAGACINA")
	private Magacin magacin;

	//bi-directional many-to-one association to PoslovnaGodina
	@ManyToOne
	@JoinColumn(name="ID_GODINE")
	private PoslovnaGodina poslovnaGodina;

	public MagacinskaKartica() {
	}

	public int getIdMagacinskeKartice() {
		return this.idMagacinskeKartice;
	}

	public void setIdMagacinskeKartice(int idMagacinskeKartice) {
		this.idMagacinskeKartice = idMagacinskeKartice;
	}

	public BigDecimal getCena() {
		return this.cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public BigDecimal getKolicinaIzlaza() {
		return this.kolicinaIzlaza;
	}

	public void setKolicinaIzlaza(BigDecimal kolicinaIzlaza) {
		this.kolicinaIzlaza = kolicinaIzlaza;
	}

	public BigDecimal getKolicinaPocetnogStanja() {
		return this.kolicinaPocetnogStanja;
	}

	public void setKolicinaPocetnogStanja(BigDecimal kolicinaPocetnogStanja) {
		this.kolicinaPocetnogStanja = kolicinaPocetnogStanja;
	}

	public BigDecimal getKolicinaUlaza() {
		return this.kolicinaUlaza;
	}

	public void setKolicinaUlaza(BigDecimal kolicinaUlaza) {
		this.kolicinaUlaza = kolicinaUlaza;
	}

	public int getRedniBrMagacinskeKar() {
		return this.redniBrMagacinskeKar;
	}

	public void setRedniBrMagacinskeKar(int redniBrMagacinskeKar) {
		this.redniBrMagacinskeKar = redniBrMagacinskeKar;
	}

	public BigDecimal getUkupnaKolicina() {
		return this.ukupnaKolicina;
	}

	public void setUkupnaKolicina(BigDecimal ukupnaKolicina) {
		this.ukupnaKolicina = ukupnaKolicina;
	}

	public BigDecimal getUkupnaVrednost() {
		return this.ukupnaVrednost;
	}

	public void setUkupnaVrednost(BigDecimal ukupnaVrednost) {
		this.ukupnaVrednost = ukupnaVrednost;
	}

	public BigDecimal getVrednostIzlaza() {
		return this.vrednostIzlaza;
	}

	public void setVrednostIzlaza(BigDecimal vrednostIzlaza) {
		this.vrednostIzlaza = vrednostIzlaza;
	}

	public BigDecimal getVrednostPocetnogStanja() {
		return this.vrednostPocetnogStanja;
	}

	public void setVrednostPocetnogStanja(BigDecimal vrednostPocetnogStanja) {
		this.vrednostPocetnogStanja = vrednostPocetnogStanja;
	}

	public BigDecimal getVrednostUlaza() {
		return this.vrednostUlaza;
	}

	public void setVrednostUlaza(BigDecimal vrednostUlaza) {
		this.vrednostUlaza = vrednostUlaza;
	}

	public Set<AnalitikaMagacinskeKartice> getAnalitikeMagacinskeKartice() {
		return this.analitikeMagacinskeKartice;
	}

	public void setAnalitikeMagacinskeKartice(Set<AnalitikaMagacinskeKartice> analitikeMagacinskeKartice) {
		this.analitikeMagacinskeKartice = analitikeMagacinskeKartice;
	}

	public AnalitikaMagacinskeKartice addAnalitikeMagacinskeKartice(AnalitikaMagacinskeKartice analitikeMagacinskeKartice) {
		getAnalitikeMagacinskeKartice().add(analitikeMagacinskeKartice);
		analitikeMagacinskeKartice.setMagacinskaKartica(this);

		return analitikeMagacinskeKartice;
	}

	public AnalitikaMagacinskeKartice removeAnalitikeMagacinskeKartice(AnalitikaMagacinskeKartice analitikeMagacinskeKartice) {
		getAnalitikeMagacinskeKartice().remove(analitikeMagacinskeKartice);
		analitikeMagacinskeKartice.setMagacinskaKartica(null);

		return analitikeMagacinskeKartice;
	}

	public Artikal getArtikal() {
		return this.artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}

	public Magacin getMagacin() {
		return this.magacin;
	}

	public void setMagacin(Magacin magacin) {
		this.magacin = magacin;
	}

	public PoslovnaGodina getPoslovnaGodina() {
		return this.poslovnaGodina;
	}

	public void setPoslovnaGodina(PoslovnaGodina poslovnaGodina) {
		this.poslovnaGodina = poslovnaGodina;
	}

}