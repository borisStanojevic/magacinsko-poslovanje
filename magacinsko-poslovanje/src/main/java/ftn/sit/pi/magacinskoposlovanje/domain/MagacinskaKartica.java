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

	private Double cena;

	@Column(name = "KOLICINA_IZLAZA")
	private Double kolicinaIzlaza;

	@Column(name = "KOLICINA_POCETNOG_STANJA")
	private Double kolicinaPocetnogStanja;

	@Column(name = "KOLICINA_ULAZA")
	private Double kolicinaUlaza;

	@Column(name = "REDNI_BR_MAGACINSKE_KAR")
	private Integer redniBrMagacinskeKar;

	@Column(name = "UKUPNA_KOLICINA")
	private Double ukupnaKolicina;

	@Column(name = "UKUPNA_VREDNOST")
	private Double ukupnaVrednost;

	@Column(name = "VREDNOST_IZLAZA")
	private Double vrednostIzlaza;

	@Column(name = "VREDNOST_POCETNOG_STANJA")
	private Double vrednostPocetnogStanja;

	@Column(name = "VREDNOST_ULAZA")
	private Double vrednostUlaza;

	// bi-directional many-to-one association to AnalitikaMagacinskeKartice
	@OneToMany(mappedBy = "magacinskaKartica", fetch = FetchType.EAGER)
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
/*
	@Version
	private Integer version;
	*/
	@Column(name = "DELETED", columnDefinition = "tinyint(1) default 0")
	private boolean deleted;

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