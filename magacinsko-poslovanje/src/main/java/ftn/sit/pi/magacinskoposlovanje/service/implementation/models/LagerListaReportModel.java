package ftn.sit.pi.magacinskoposlovanje.service.implementation.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LagerListaReportModel {
	public static final String MAGACIN_REPORT_TEMPLATE_KEY = "magacin";
	public static final String POSLOVNA_GODINA_REPORT_TEMPLATE_KEY = "poslovnaGodina";
	
	private String magacin;
	private int poslovnaGodina;
	private List<LagerListaStavkaReportModel> stavke;
}
