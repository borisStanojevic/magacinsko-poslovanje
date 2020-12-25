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
@NamedQuery(name = "Magacin.findAll", query = "SELECT m FROM Magacin m")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Magacin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SIFRA_MAGACINA")
	private Integer sifraMagacina;

	@Column(name = "NAZIV_MAGACINA")
	@NotBlank(message = "Morate navesti naziv magacina")
	private String nazivMagacina;

	// bi-directional many-to-one association to Preduzece
	@ManyToOne
	@JoinColumn(name = "SIFRA_PREDUZECA")
	private Preduzece preduzece;

	// bi-directional many-to-one association to Radnik
	@ManyToOne
	@JoinColumn(name = "ID_RADNIKA")
	private Radnik radnik;

	// bi-directional many-to-one association to MagacinskaKartica
	@OneToMany(mappedBy = "magacin")
	private Set<MagacinskaKartica> magacinskeKartice = new HashSet<>();

	// bi-directional many-to-one association to PrometniDokument
	@OneToMany(mappedBy = "magacin")
	private Set<PrometniDokument> prometniDokumenti = new HashSet<>();

	@Version
	private Integer version;
	
	@Column(name = "DELETED", columnDefinition = "tinyint(1) default 0")
	private boolean deleted;

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