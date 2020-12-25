package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = "Mesto.findAll", query = "SELECT m FROM Mesto m")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Mesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "POSTANSKI_BROJ")
	private String postanskiBroj;
	
	@NotBlank(message = "Morate navesti drzavu")
	private String drzava;

	@Column(name = "NAZIV_MESTA")
	@NotBlank(message = "Morate navesti naziv mesta")
	private String nazivMesta;

	// bi-directional many-to-one association to PoslovniPartner
	@OneToMany(mappedBy = "mesto")
	private Set<PoslovniPartner> poslovniPartneri = new HashSet<>();

	// bi-directional many-to-one association to Preduzece
	@OneToMany(mappedBy = "mesto")
	private Set<Preduzece> preduzeca = new HashSet<>();
	
	@Column(name = "DELETED", columnDefinition = "tinyint(1) default 0")
	private boolean deleted;

	public PoslovniPartner addPoslovniPartner(PoslovniPartner poslovniPartner) {
		getPoslovniPartneri().add(poslovniPartner);
		poslovniPartner.setMesto(this);

		return poslovniPartner;
	}

	public PoslovniPartner removePoslovniPartner(PoslovniPartner poslovniPartner) {
		getPoslovniPartneri().remove(poslovniPartner);
		poslovniPartner.setMesto(null);

		return poslovniPartner;
	}

	public Preduzece addPreduzece(Preduzece preduzece) {
		getPreduzeca().add(preduzece);
		preduzece.setMesto(this);

		return preduzece;
	}

	public Preduzece removePreduzeca(Preduzece preduzeca) {
		getPreduzeca().remove(preduzeca);
		preduzeca.setMesto(null);

		return preduzeca;
	}

}