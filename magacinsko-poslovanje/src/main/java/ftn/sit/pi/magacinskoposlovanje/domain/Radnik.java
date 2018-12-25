package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


@Entity
@NamedQuery(name="Radnik.findAll", query="SELECT r FROM Radnik r")
public class Radnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RADNIKA")
	private Integer idRadnika;

	@Column(name="IME_PREZIME")
	private String imePrezime;

	private String password;

	private String username;

	//bi-directional many-to-one association to Magacin
	@OneToMany(mappedBy="radnik")
	private Set<Magacin> magacini;

	//bi-directional many-to-one association to Preduzece
	@OneToMany(mappedBy="radnik")
	private Set<Preduzece> preduzeca;

	public Radnik() {
	}

	public Integer getIdRadnika() {
		return this.idRadnika;
	}

	public void setIdRadnika(Integer idRadnika) {
		this.idRadnika = idRadnika;
	}

	public String getImePrezime() {
		return this.imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Magacin> getMagacini() {
		return this.magacini;
	}

	public void setMagacini(Set<Magacin> magacini) {
		this.magacini = magacini;
	}

	public Magacin addMagacin(Magacin magacin) {
		getMagacini().add(magacin);
		magacin.setRadnik(this);

		return magacin;
	}

	public Magacin removeMagacin(Magacin magacin) {
		getMagacini().remove(magacin);
		magacin.setRadnik(null);

		return magacin;
	}

	public Set<Preduzece> getPreduzeca() {
		return this.preduzeca;
	}

	public void setPreduzeca(Set<Preduzece> preduzeca) {
		this.preduzeca = preduzeca;
	}

	public Preduzece addPreduzece(Preduzece preduzece) {
		getPreduzeca().add(preduzece);
		preduzece.setRadnik(this);

		return preduzece;
	}

	public Preduzece removePreduzece(Preduzece preduzece) {
		getPreduzeca().remove(preduzece);
		preduzece.setRadnik(null);

		return preduzece;
	}

}