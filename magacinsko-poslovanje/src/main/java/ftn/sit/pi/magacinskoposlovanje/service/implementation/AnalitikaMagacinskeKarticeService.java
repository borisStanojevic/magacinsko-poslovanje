package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ftn.sit.pi.magacinskoposlovanje.domain.AnalitikaMagacinskeKartice;
import ftn.sit.pi.magacinskoposlovanje.repository.AnalitikaMagacinskeKarticeRepository;
import ftn.sit.pi.magacinskoposlovanje.service.IAnalitikaMagacinskeKarticeService;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class AnalitikaMagacinskeKarticeService implements IAnalitikaMagacinskeKarticeService {

	@Autowired
	private AnalitikaMagacinskeKarticeRepository analitikaMagKartRepository;

	
	@Override
	@Transactional(readOnly = true)
	public AnalitikaMagacinskeKartice getById(Integer idAnalitike) {
		return analitikaMagKartRepository.findByIdAnalitike(idAnalitike);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<AnalitikaMagacinskeKartice> getAll(Pageable pageable) {
		return analitikaMagKartRepository.findAll(pageable);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AnalitikaMagacinskeKartice add(AnalitikaMagacinskeKartice analitikaMagacinskeKartice) {
		return analitikaMagKartRepository.save(analitikaMagacinskeKartice);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AnalitikaMagacinskeKartice update(AnalitikaMagacinskeKartice analitikaMagacinskeKartice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(AnalitikaMagacinskeKartice analitikaMagacinskeKartice) {
		AnalitikaMagacinskeKartice analitikaMagKartToBeDeleted = analitikaMagKartRepository.findByIdAnalitike(analitikaMagacinskeKartice.getIdAnalitike());
		analitikaMagKartRepository.delete(analitikaMagKartToBeDeleted);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteById(Integer idAnalitike) {
		analitikaMagKartRepository.deleteByIdAnalitike(idAnalitike);
	}
	
	
}
