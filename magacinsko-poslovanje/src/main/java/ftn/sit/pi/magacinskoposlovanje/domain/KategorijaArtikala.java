package ftn.sit.pi.magacinskoposlovanje.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "kategorija_artikala")
@NamedQuery(name = "KategorijaArtikala.findAll", query = "SELECT k FROM KategorijaArtikala k")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class KategorijaArtikala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_KATEGORIJE")
	private Integer idKategorije;

	@Column(name = "NAZIV_KATEGORIJE")
	private String nazivKategorije;

	// bi-directional many-to-one association to Artikal
	@OneToMany(mappedBy = "kategorijaArtikala")
	private Set<Artikal> artikli = new HashSet<>();

	// bi-directional many-to-one association to Preduzece
	@ManyToOne
	@JoinColumn(name = "SIFRA_PREDUZECA")
	private Preduzece preduzece;

	@Version
	private Integer version;

	public Artikal addArtikal(Artikal artikal) {
		getArtikli().add(artikal);
		artikal.setKategorijaArtikala(this);

		return artikal;
	}

	public Artikal removeArtikal(Artikal artikal) {
		getArtikli().remove(artikal);
		artikal.setKategorijaArtikala(null);

		return artikal;
	}

}