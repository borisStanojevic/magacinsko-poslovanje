package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.domain.PrometniDokument;
import ftn.sit.pi.magacinskoposlovanje.domain.StavkaPrometnogDokumenta;
import ftn.sit.pi.magacinskoposlovanje.repository.MagacinskaKarticaRepository;
import ftn.sit.pi.magacinskoposlovanje.repository.PrometniDokumentRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IPrometniDokumentIzvestajService;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.models.LagerListaReportModel;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.models.LagerListaStavkaReportModel;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.models.PrometniDokumentReportModel;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.models.PrometniDokumentStavkaReportModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class PrometniDokumentIzvestajService implements IPrometniDokumentIzvestajService {
	private static final String REPORT_TEMPLATE_NAME = "prometni-dokument";

	@Autowired
	private PrometniDokumentRepository prometniDokumentRepository;

	@Override
	public byte[] generisiIzvestaj(int idPrometnogDokumenta) throws FileNotFoundException, JRException {
		File reportTemplateFile = loadReportTemplateFile(REPORT_TEMPLATE_NAME);

		JasperReport compiledReport = compileReport(reportTemplateFile.getAbsolutePath());

		JasperPrint filledReport = fillReport(compiledReport, idPrometnogDokumenta);

		return JasperExportManager.exportReportToPdf(filledReport);

	}

	private File loadReportTemplateFile(String fileName) throws FileNotFoundException {
		File reportTemplateFile = ResourceUtils.getFile("classpath:" + fileName + ".jrxml");

		return reportTemplateFile;
	}

	private JasperReport compileReport(String reportTemplateFileAbsolutePath) throws JRException {
		JasperReport compiledReport = JasperCompileManager.compileReport(reportTemplateFileAbsolutePath);

		return compiledReport;
	}

	private JasperPrint fillReport(JasperReport compiledReport, int idPrometnogDokumenta) throws JRException {
		PrometniDokument prometniDokument = prometniDokumentRepository.findByIdPrometnogDokumenta(idPrometnogDokumenta); 

		PrometniDokumentReportModel prometniDokumentReportModel = new PrometniDokumentReportModel();
		prometniDokumentReportModel.setBrojPrometnogDokumenta(prometniDokument.getBrojPrometnogDokumenta());
		prometniDokumentReportModel.setMagacin(prometniDokument.getMagacin().getNazivMagacina());
		prometniDokumentReportModel.setDatumFormiranja(prometniDokument.getDatumFormiranja().toString());
		prometniDokumentReportModel.setPoslovnaGodina(prometniDokument.getPoslovnaGodina().getIdGodine());
		prometniDokumentReportModel.setPoslovniPartner(prometniDokument.getPoslovniPartner().getSifraPartnera());
		prometniDokumentReportModel.setStatus(prometniDokument.getStatus().toString());
		prometniDokumentReportModel.setTipPrometnogDokumenta(prometniDokument.getTipPrometnogDokumenta().toString());
		
		List<PrometniDokumentStavkaReportModel> prometniDokumentStavkaReportModels = new ArrayList<>();
		int i = 0;
		for (StavkaPrometnogDokumenta stavkaPrometnogDokumenta : prometniDokument.getStavkePrometnogDokumenta()) {
			prometniDokumentStavkaReportModels.add(createStavkaPrometnogDokumentaReportModelFromStavkaPrometnogDokumenta(stavkaPrometnogDokumenta, ++i));
		}
		prometniDokumentReportModel.setStavke(prometniDokumentStavkaReportModels);

		Map<String, Object> parameters = new HashMap<>();

		parameters.put(PrometniDokumentReportModel.BROJ_PROMETNOG_DOKUMENTA_REPORT_TEMPLATE_KEY,
				prometniDokumentReportModel.getBrojPrometnogDokumenta());
		parameters.put(PrometniDokumentReportModel.DATUM_FORMIRANJA_REPORT_TEMPLATE_KEY,

				prometniDokumentReportModel.getDatumFormiranja());

		parameters.put(PrometniDokumentReportModel.MAGACIN_REPORT_TEMPLATE_KEY,

				prometniDokumentReportModel.getMagacin());

		parameters.put(PrometniDokumentReportModel.POSLOVNA_GODINA_REPORT_TEMPLATE_KEY,

				prometniDokumentReportModel.getPoslovnaGodina());

		parameters.put(PrometniDokumentReportModel.POSLOVNI_PARTNER_REPORT_TEMPLATE_KEY,
				prometniDokumentReportModel.getPoslovniPartner());
		
		parameters.put(PrometniDokumentReportModel.STATUS_REPORT_TEMPLATE_KEY, prometniDokumentReportModel.getStatus());

		parameters.put(PrometniDokumentReportModel.TIP_PROMETNOG_DOKUMENTA_REPORT_TEMPLATE_KEY,
				prometniDokumentReportModel.getTipPrometnogDokumenta());

		JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(
				prometniDokumentReportModel.getStavke());

		JasperPrint filledReport = JasperFillManager.fillReport(compiledReport, parameters, jrBeanCollectionDataSource);

		return filledReport;
	}

	private PrometniDokumentStavkaReportModel createStavkaPrometnogDokumentaReportModelFromStavkaPrometnogDokumenta(StavkaPrometnogDokumenta stavkaPrometnogDokumenta, int redniBroj) {
		PrometniDokumentStavkaReportModel prometniDokumentStavkaReportModel = new PrometniDokumentStavkaReportModel();


		prometniDokumentStavkaReportModel.setRedniBrojStavkePrometnogDokumenta(redniBroj);
		prometniDokumentStavkaReportModel.setArtikal(stavkaPrometnogDokumenta.getArtikal().getNazivArtikla());
		prometniDokumentStavkaReportModel.setCena(stavkaPrometnogDokumenta.getCena());
		prometniDokumentStavkaReportModel.setKolicina(stavkaPrometnogDokumenta.getKolicina());
		prometniDokumentStavkaReportModel.setVrednost(stavkaPrometnogDokumenta.getVrednost());


		return prometniDokumentStavkaReportModel;
	}
}
