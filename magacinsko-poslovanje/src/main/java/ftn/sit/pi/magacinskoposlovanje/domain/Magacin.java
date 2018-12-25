package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


@Entity
@NamedQuery(name="Magacin.findAll", query="SELECT m FROM Magacin m")
public class Magacin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SIFRA_MAGACINA")
	private Integer sifraMagacina;

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

	public Integer getSifraMagacina() {
		return this.sifraMagacina;
	}

	public void setSifraMagacina(Integer sifraMagacina) {
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

	public MagacinskaKartica addMagacinskaKartica(MagacinskaKartica magacinskaKartica) {
		getMagacinskeKartice().add(magacinskaKartica);
		magacinskaKartica.setMagacin(this);

		return magacinskaKartica;
	}

	public MagacinskaKartica removeMagacinskaKartica(MagacinskaKartica magacinskaKartica) {
		getMagacinskeKartice().remove(magacinskaKartica);
		magacinskaKartica.setMagacin(null);

		return magacinskaKartica;
	}

	public Set<PrometniDokument> getPrometniDokumenti() {
		return this.prometniDokumenti;
	}

	public void setPrometniDokumenti(Set<PrometniDokument> prometniDokumenti) {
		this.prometniDokumenti = prometniDokumenti;
	}

	public PrometniDokument addPrometniDokument(PrometniDokument prometniDokument) {
		getPrometniDokumenti().add(prometniDokument);
		prometniDokument.setMagacin(this);

		return prometniDokument;
	}

	public PrometniDokument removePrometniDokument(PrometniDokument prometniDokument) {
		getPrometniDokumenti().remove(prometniDokument);
		prometniDokument.setMagacin(null);

		return prometniDokument;
	}

}