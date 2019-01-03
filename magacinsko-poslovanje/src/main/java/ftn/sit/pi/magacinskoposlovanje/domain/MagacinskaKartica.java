package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "magacinska_kartica")
@NamedQuery(name = "MagacinskaKartica.findAll", query = "SELECT m FROM MagacinskaKartica m")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MagacinskaKartica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MAGACINSKE_KARTICE")
	private Integer idMagacinskeKartice;

	private BigDecimal cena;

	@Column(name = "KOLICINA_IZLAZA")
	private BigDecimal kolicinaIzlaza;

	@Column(name = "KOLICINA_POCETNOG_STANJA")
	private BigDecimal kolicinaPocetnogStanja;

	@Column(name = "KOLICINA_ULAZA")
	private BigDecimal kolicinaUlaza;

	@Column(name = "REDNI_BR_MAGACINSKE_KAR")
	private Integer redniBrMagacinskeKar;

	@Column(name = "UKUPNA_KOLICINA")
	private BigDecimal ukupnaKolicina;

	@Column(name = "UKUPNA_VREDNOST")
	private BigDecimal ukupnaVrednost;

	@Column(name = "VREDNOST_IZLAZA")
	private BigDecimal vrednostIzlaza;

	@Column(name = "VREDNOST_POCETNOG_STANJA")
	private BigDecimal vrednostPocetnogStanja;

	@Column(name = "VREDNOST_ULAZA")
	private BigDecimal vrednostUlaza;

	// bi-directional many-to-one association to AnalitikaMagacinskeKartice
	@OneToMany(mappedBy = "magacinskaKartica")
	private Set<AnalitikaMagacinskeKartice> analitikeMagacinskeKartice = new HashSet<>();

	// bi-directional many-to-one association to Artikal
	@ManyToOne
	@JoinColumn(name = "SIFRA_ARTIKLA")
	private Artikal artikal;

	// bi-directional many-to-one association to Magacin
	@ManyToOne
	@JoinColumn(name = "SIFRA_MAGACINA")
	private Magacin magacin;

	// bi-directional many-to-one association to PoslovnaGodina
	@ManyToOne
	@JoinColumn(name = "ID_GODINE")
	private PoslovnaGodina poslovnaGodina;

	@Version
	private Integer version;

	public AnalitikaMagacinskeKartice addAnalitikaMagacinskeKartice(
			AnalitikaMagacinskeKartice analitikaMagacinskeKartice) {
		getAnalitikeMagacinskeKartice().add(analitikaMagacinskeKartice);
		analitikaMagacinskeKartice.setMagacinskaKartica(this);

		return analitikaMagacinskeKartice;
	}

	public AnalitikaMagacinskeKartice removeAnalitikaMagacinskeKartice(
			AnalitikaMagacinskeKartice analitikaMagacinskeKartice) {
		getAnalitikeMagacinskeKartice().remove(analitikaMagacinskeKartice);
		analitikaMagacinskeKartice.setMagacinskaKartica(null);

		return analitikaMagacinskeKartice;
	}

}