package ftn.sit.pi.magacinskoposlovanje.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ftn.sit.pi.magacinskoposlovanje.domain.Radnik;
import ftn.sit.pi.magacinskoposlovanje.repository.RadnikRepository;
import ftn.sit.pi.magacinskoposlovanje.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	RadnikRepository radnikRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Radnik radnik = radnikRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with that username"));
		
		return UserDetailsImpl.build(radnik);
	}

}
