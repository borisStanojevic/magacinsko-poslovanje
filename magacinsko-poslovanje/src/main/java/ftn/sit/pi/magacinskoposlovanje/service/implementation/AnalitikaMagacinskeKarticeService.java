package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ftn.sit.pi.magacinskoposlovanje.domain.AnalitikaMagacinskeKartice;
import ftn.sit.pi.magacinskoposlovanje.repository.AnalitikaMagacinskeKarticeRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IAnalitikaMagacinskeKarticeService;

public class AnalitikaMagacinskeKarticeService implements IAnalitikaMagacinskeKarticeService {

	@Autowired
	private AnalitikaMagacinskeKarticeRepository analitikaMagKartRepository;

	@Override
	public AnalitikaMagacinskeKartice getById(Integer idAnalitike) {
		return analitikaMagKartRepository.findByIdAnalitike(idAnalitike);
	}

	@Override
	public Page<AnalitikaMagacinskeKartice> getAll(Pageable pageable) {
		return analitikaMagKartRepository.findAll(pageable);
	}

	@Override
	public AnalitikaMagacinskeKartice add(AnalitikaMagacinskeKartice analitikaMagacinskeKartice) {
		return analitikaMagKartRepository.save(analitikaMagacinskeKartice);
	}

	@Override
	public AnalitikaMagacinskeKartice update(AnalitikaMagacinskeKartice analitikaMagacinskeKartice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(AnalitikaMagacinskeKartice analitikaMagacinskeKartice) {
		AnalitikaMagacinskeKartice analitikaMagKartToBeDeleted = analitikaMagKartRepository.findByIdAnalitike(analitikaMagacinskeKartice.getIdAnalitike());
		analitikaMagKartRepository.delete(analitikaMagKartToBeDeleted);
	}

	@Override
	public void deleteById(Integer idAnalitike) {
		analitikaMagKartRepository.deleteByIdAnalitike(idAnalitike);
	}
	
	
}
