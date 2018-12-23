package ftn.sit.pi.magacinskoposlovanje.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the radnik database table.
 * 
 */
@Entity
@NamedQuery(name="Radnik.findAll", query="SELECT r FROM Radnik r")
public class Radnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_RADNIKA")
	private int idRadnika;

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

	public int getIdRadnika() {
		return this.idRadnika;
	}

	public void setIdRadnika(int idRadnika) {
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

	public Magacin addMagacini(Magacin magacini) {
		getMagacini().add(magacini);
		magacini.setRadnik(this);

		return magacini;
	}

	public Magacin removeMagacini(Magacin magacini) {
		getMagacini().remove(magacini);
		magacini.setRadnik(null);

		return magacini;
	}

	public Set<Preduzece> getPreduzeca() {
		return this.preduzeca;
	}

	public void setPreduzeca(Set<Preduzece> preduzeca) {
		this.preduzeca = preduzeca;
	}

	public Preduzece addPreduzeca(Preduzece preduzeca) {
		getPreduzeca().add(preduzeca);
		preduzeca.setRadnik(this);

		return preduzeca;
	}

	public Preduzece removePreduzeca(Preduzece preduzeca) {
		getPreduzeca().remove(preduzeca);
		preduzeca.setRadnik(null);

		return preduzeca;
	}

}