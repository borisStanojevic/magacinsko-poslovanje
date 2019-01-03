package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "stavke_prometnog_dokumenta")
@NamedQuery(name = "StavkaPrometnogDokumenta.findAll", query = "SELECT s FROM StavkaPrometnogDokumenta s")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class StavkaPrometnogDokumenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_STAVKE_PROMETNOG_DOKUMENTA")
	private Integer idStavkePrometnogDokumenta;

	private BigDecimal cena;

	private BigDecimal kolicina;

	private BigDecimal vrednost;

	// bi-directional many-to-one association to Artikal
	@ManyToOne
	@JoinColumn(name = "SIFRA_ARTIKLA")
	private Artikal artikal;

	// bi-directional many-to-one association to PrometniDokument
	@ManyToOne
	@JoinColumn(name = "ID_PROMETNOG_DOKUMENTA")
	private PrometniDokument prometniDokument;

	@Version
	private Integer version;

}