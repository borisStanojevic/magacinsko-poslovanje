package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = "Preduzece.findAll", query = "SELECT p FROM Preduzece p")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Preduzece implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SIFRA_PREDUZECA")
	private Integer sifraPreduzeca;

	@Column(name = "ADRESA_PREDUZECA")
	private String adresaPreduzeca;

	@Column(name = "NAZIV_PREDUZECA")
	@NotBlank(message = "Morate navesti naziv preduzeca")
	private String nazivPreduzeca;

	@NotBlank(message = "Morate navesti PIB preduzeca")
	@Size(min=8, max=8, message = "PIB mora sadrzati tacno 8 cifara")
	private String pib;

	/*// bi-directional many-to-one association to KategorijaArtikala
	@OneToMany(mappedBy = "preduzece")
	private Set<KategorijaArtikala> kategorijeArtikala = new HashSet<>();
*/
	// bi-directional many-to-one association to Magacin
	@OneToMany(mappedBy = "preduzece")
	private Set<Magacin> magacini = new HashSet<>();

	// bi-directional many-to-one association to Mesto
	@ManyToOne
	@JoinColumn(name = "POSTANSKI_BROJ")
	private Mesto mesto;

	// bi-directional many-to-one association to Radnik
	@ManyToOne
	@JoinColumn(name = "ID_RADNIKA")
	private Radnik radnik;

	@Version
	private Integer version;

/*	public KategorijaArtikala addKategorijaArtikala(KategorijaArtikala kategorijaArtikala) {
		getKategorijeArtikala().add(kategorijaArtikala);
		kategorijaArtikala.setPreduzece(this);

		return kategorijaArtikala;
	}

	public KategorijaArtikala removeKategorijaArtikala(KategorijaArtikala kategorijaArtikala) {
		getKategorijeArtikala().remove(kategorijaArtikala);
		kategorijaArtikala.setPreduzece(null);

		return kategorijaArtikala;
	}*/

	public Magacin addMagacin(Magacin magacin) {
		getMagacini().add(magacin);
		magacin.setPreduzece(this);

		return magacin;
	}

	public Magacin removeMagacin(Magacin magacin) {
		getMagacini().remove(magacin);
		magacin.setPreduzece(null);

		return magacin;
	}

}