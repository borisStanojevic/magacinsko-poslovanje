package ftn.sit.pi.magacinskoposlovanje.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the magacin database table.
 * 
 */
@Entity
@NamedQuery(name="Magacin.findAll", query="SELECT m FROM Magacin m")
public class Magacin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SIFRA_MAGACINA")
	private int sifraMagacina;

	@Column(name="NAZIV_MAGACINA")
	private String nazivMagacina;

	//bi-directional many-to-one association to Preduzece
	@ManyToOne
	@JoinColumn(name="SIFRA_PREDUZECA")
	private Preduzece preduzece;

	//bi-directional many-to-one association to Radnik
	@ManyToOne
	@JoinColumn(name="ID_RADNIKA")
	private Radnik radnik;

	//bi-directional many-to-one association to MagacinskaKartica
	@OneToMany(mappedBy="magacin")
	private Set<MagacinskaKartica> magacinskeKartice;

	//bi-directional many-to-one association to PrometniDokument
	@OneToMany(mappedBy="magacin")
	private Set<PrometniDokument> prometniDokumenti;

	public Magacin() {
	}

	public int getSifraMagacina() {
		return this.sifraMagacina;
	}

	public void setSifraMagacina(int sifraMagacina) {
		this.sifraMagacina = sifraMagacina;
	}

	public String getNazivMagacina() {
		return this.nazivMagacina;
	}

	public void setNazivMagacina(String nazivMagacina) {
		this.nazivMagacina = nazivMagacina;
	}

	public Preduzece getPreduzece() {
		return this.preduzece;
	}

	public void setPreduzece(Preduzece preduzece) {
		this.preduzece = preduzece;
	}

	public Radnik getRadnik() {
		return this.radnik;
	}

	public void setRadnik(Radnik radnik) {
		this.radnik = radnik;
	}

	public Set<MagacinskaKartica> getMagacinskeKartice() {
		return this.magacinskeKartice;
	}

	public void setMagacinskeKartice(Set<MagacinskaKartica> magacinskeKartice) {
		this.magacinskeKartice = magacinskeKartice;
	}

	public MagacinskaKartica addMagacinskeKartice(MagacinskaKartica magacinskeKartice) {
		getMagacinskeKartice().add(magacinskeKartice);
		magacinskeKartice.setMagacin(this);

		return magacinskeKartice;
	}

	public MagacinskaKartica removeMagacinskeKartice(MagacinskaKartica magacinskeKartice) {
		getMagacinskeKartice().remove(magacinskeKartice);
		magacinskeKartice.setMagacin(null);

		return magacinskeKartice;
	}

	public Set<PrometniDokument> getPrometniDokumenti() {
		return this.prometniDokumenti;
	}

	public void setPrometniDokumenti(Set<PrometniDokument> prometniDokumenti) {
		this.prometniDokumenti = prometniDokumenti;
	}

	public PrometniDokument addPrometniDokumenti(PrometniDokument prometniDokumenti) {
		getPrometniDokumenti().add(prometniDokumenti);
		prometniDokumenti.setMagacin(this);

		return prometniDokumenti;
	}

	public PrometniDokument removePrometniDokumenti(PrometniDokument prometniDokumenti) {
		getPrometniDokumenti().remove(prometniDokumenti);
		prometniDokumenti.setMagacin(null);

		return prometniDokumenti;
	}

}