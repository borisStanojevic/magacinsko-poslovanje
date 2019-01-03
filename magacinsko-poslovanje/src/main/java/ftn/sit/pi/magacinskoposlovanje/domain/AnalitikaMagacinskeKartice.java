package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "analitika_magacinske_kartice")
@NamedQuery(name = "AnalitikaMagacinskeKartice.findAll", query = "SELECT a FROM AnalitikaMagacinskeKartice a")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AnalitikaMagacinskeKartice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ANALITIKE")
	private Integer idAnalitike;

	private BigDecimal cena;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATUM_NASTANKA")
	private Date datumNastanka;

	private BigDecimal kolicina;

	private Smer smer;

	@Column(name = "TIP_PROMETA")
	private TipPrometa tipPrometa;

	private BigDecimal vrednost;

	// bi-directional many-to-one association to MagacinskaKartica
	@ManyToOne
	@JoinColumn(name = "ID_MAGACINSKE_KARTICE")
	private MagacinskaKartica magacinskaKartica;

	@Version
	private Integer version;

}