package ftn.sit.pi.magacinskoposlovanje.service;

import java.io.FileNotFoundException;
import java.io.OutputStream;

import net.sf.jasperreports.engine.JRException;

public interface ILagerListaIzvestajService {
	byte[] generisiIzvestaj(int idMagacina, int poslovnaGodina) throws FileNotFoundException, JRException;
}
