package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prometni_dokument")
@NamedQuery(name = "PrometniDokument.findAll", query = "SELECT p FROM PrometniDokument p")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PrometniDokument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PROMETNOG_DOKUMENTA")
	private Integer idPrometnogDokumenta;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BROJ_PROMETNOG_DOKUMENTA")
	private Integer brojPrometnogDokumenta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATUM_FORMIRANJA")
	private Date datumFormiranja;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATUM_KNJIZENJA")
	private Date datumKnjizenja;
/*
	@Column(name = "REDNI_BROJ_DOKUMETNA")
	private Integer redniBrojDokumenta;
*/	
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "TIP_PROMETNOG_DOKUMENTA")
	@Enumerated(EnumType.STRING)
	private TipPrometnogDokumenta tipPrometnogDokumenta;

	// bi-directional many-to-one association to Magacin
	@ManyToOne
	@JoinColumn(name = "SIFRA_MAGACINA")
	private Magacin magacin;

	// bi-directional many-to-one association to PoslovnaGodina
	@ManyToOne
	@JoinColumn(name = "ID_GODINE")
	private PoslovnaGodina poslovnaGodina;

	// bi-directional many-to-one association to PoslovniPartner
	@ManyToOne
	@JoinColumn(name = "SIFRA_PARTNERA")
	private PoslovniPartner poslovniPartner;

	// bi-directional many-to-one association to StavkePrometnogDokumenta
	@OneToMany(mappedBy = "prometniDokument", fetch = FetchType.EAGER)
	private Set<StavkaPrometnogDokumenta> stavkePrometnogDokumenta = new HashSet<>();

	@Version
	private Integer version;
	
	@Column(name = "DELETED", columnDefinition = "tinyint(1) default 0")
	private boolean deleted;

	public StavkaPrometnogDokumenta addStavkaPrometnogDokumenta(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		getStavkePrometnogDokumenta().add(stavkaPrometnogDokumenta);
		stavkaPrometnogDokumenta.setPrometniDokument(this);

		return stavkaPrometnogDokumenta;
	}

	public StavkaPrometnogDokumenta removeStavkaPrometnogDokumenta(StavkaPrometnogDokumenta stavkaPrometnogDokumenta) {
		getStavkePrometnogDokumenta().remove(stavkaPrometnogDokumenta);
		stavkaPrometnogDokumenta.setPrometniDokument(null);

		return stavkaPrometnogDokumenta;
	}

}