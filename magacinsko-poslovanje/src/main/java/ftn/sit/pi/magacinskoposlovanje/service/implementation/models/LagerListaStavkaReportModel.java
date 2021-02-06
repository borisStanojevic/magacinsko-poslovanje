package ftn.sit.pi.magacinskoposlovanje.service.implementation.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LagerListaStavkaReportModel {
	private int redniBroj;
	private String artikal;
	private double cena;
	private double kolicina;
	private double vrednost;
}
