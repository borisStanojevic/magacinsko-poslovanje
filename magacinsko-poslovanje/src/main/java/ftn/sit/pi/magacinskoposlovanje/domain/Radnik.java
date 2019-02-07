package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = "Radnik.findAll", query = "SELECT r FROM Radnik r")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Radnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RADNIKA")
	private Integer idRadnika;

	@Column(name = "IME_PREZIME")
	private String imePrezime;
	
	@NotBlank(message = "Morate navesti sifru")
	@Size(min=6, message = "Sifra mora sadrzati minimum 6 karaktera")
	private String password;
	
	@NotBlank(message = "Morate navesti korisnicko ime")
	@Pattern(regexp = "^\\w{6,20}$", message = "Korisnicko ime mora biti izmedju 6 i 20 karaktera, i sadrzati samo slova, cifre i _")
	private String username;

	// bi-directional many-to-one association to Magacin
	@OneToMany(mappedBy = "radnik")
	private Set<Magacin> magacini = new HashSet<>();

	// bi-directional many-to-one association to Preduzece
	@OneToMany(mappedBy = "radnik")
	private Set<Preduzece> preduzeca = new HashSet<>();

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