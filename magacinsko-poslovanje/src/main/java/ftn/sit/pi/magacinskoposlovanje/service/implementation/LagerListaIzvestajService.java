package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import ftn.sit.pi.magacinskoposlovanje.domain.MagacinskaKartica;
import ftn.sit.pi.magacinskoposlovanje.repository.MagacinskaKarticaRepository;
import ftn.sit.pi.magacinskoposlovanje.service.ILagerListaIzvestajService;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.models.LagerListaReportModel;
import ftn.sit.pi.magacinskoposlovanje.service.implementation.models.LagerListaStavkaReportModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Transactional
public class LagerListaIzvestajService implements ILagerListaIzvestajService {
	private static final String REPORT_TEMPLATE_NAME = "lager-lista";

	@Autowired
	private MagacinskaKarticaRepository magacinskaKarticaRepository;

	@Override
	public byte[] generisiIzvestaj(int idMagacina, int poslovnaGodina)
				  throws FileNotFoundException, JRException {
		File reportTemplateFile = loadReportTemplateFile(REPORT_TEMPLATE_NAME);

		JasperReport compiledReport = compileReport(reportTemplateFile.getAbsolutePath());

		JasperPrint filledReport = fillReport(compiledReport, idMagacina, poslovnaGodina);

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

	@SuppressWarnings("deprecation")
	private JasperPrint fillReport(JasperReport compiledReport, int idMagacina, int poslovnaGodina) throws JRException {
		Iterable<MagacinskaKartica> magacinskeKartice = magacinskaKarticaRepository.findAll(idMagacina, poslovnaGodina);
		
		LagerListaReportModel lagerListaReportModel = new LagerListaReportModel();

		List<LagerListaStavkaReportModel> lagerListaStavkaReportModels = new ArrayList<>();		
		for (MagacinskaKartica magacinskaKartica : magacinskeKartice) {
			if(lagerListaReportModel.getMagacin() == null) {
				lagerListaReportModel.setMagacin(magacinskaKartica.getMagacin().getNazivMagacina());
			}
			if(lagerListaReportModel.getPoslovnaGodina() == 0) {
				lagerListaReportModel.setPoslovnaGodina(magacinskaKartica.getPoslovnaGodina().getGodina().getYear());
			}
			
			lagerListaStavkaReportModels.add(createLagerListaStavkaReportModelFromMagacinskaKartica(magacinskaKartica));
		}
		
		JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(
				lagerListaReportModel.getStavke());

		Map<String, Object> parameters = new HashMap<>();

		parameters.put(LagerListaReportModel.MAGACIN_REPORT_TEMPLATE_KEY, lagerListaReportModel.getMagacin());
		parameters.put(LagerListaReportModel.POSLOVNA_GODINA_REPORT_TEMPLATE_KEY,
				lagerListaReportModel.getPoslovnaGodina());

		JasperPrint filledReport = JasperFillManager.fillReport(compiledReport, parameters, jrBeanCollectionDataSource);

		return filledReport;
	}

//	private LagerListaReportModel createLagerListaReportModel() {
//		LagerListaReportModel reportModel = new LagerListaReportModel();
//		reportModel.setMagacin("MojMagacin");
//		reportModel.setPoslovnaGodina(2021);
//		reportModel.setStavke(createStavkeLagerListe());
//
//		return reportModel;
//	}

//	private List<LagerListaStavkaReportModel> createStavkeLagerListe() {
//		List<LagerListaStavkaReportModel> stavkeLagerListe = new ArrayList<>(10);
//
//		for (int i = 0; i < 10; i++) {
//			LagerListaStavkaReportModel lagerListaStavkaReportModel = new LagerListaStavkaReportModel();
//
//			lagerListaStavkaReportModel.setRedniBroj(i + 1);
//			lagerListaStavkaReportModel.setArtikal("Artikal " + (i + 1));
//			lagerListaStavkaReportModel.setCena(new Random().nextDouble());
//			lagerListaStavkaReportModel.setKolicina(new Random().nextDouble());
//			lagerListaStavkaReportModel.setVrednost(new Random().nextDouble());
//
//			stavkeLagerListe.add(lagerListaStavkaReportModel);
//		}
//
//		return stavkeLagerListe;
//	}
	
	private LagerListaStavkaReportModel createLagerListaStavkaReportModelFromMagacinskaKartica(MagacinskaKartica magacinskaKartica) {
		LagerListaStavkaReportModel lagerListaStavkaReportModel = new LagerListaStavkaReportModel();
		
		lagerListaStavkaReportModel.setRedniBroj(magacinskaKartica.getRedniBrMagacinskeKar());
		lagerListaStavkaReportModel.setArtikal(magacinskaKartica.getArtikal().getNazivArtikla());
		lagerListaStavkaReportModel.setCena(magacinskaKartica.getCena());
		lagerListaStavkaReportModel.setKolicina(magacinskaKartica.getUkupnaKolicina());
		lagerListaStavkaReportModel.setVrednost(magacinskaKartica.getUkupnaVrednost());
		
		return lagerListaStavkaReportModel;
	}
	
}
