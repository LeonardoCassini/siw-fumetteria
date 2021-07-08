package it.uniroma3.siw.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.spring.model.Credenziali;
import it.uniroma3.siw.spring.repository.CredenzialiRepository;

@Service
public class CredenzialiService {

	 	@Autowired
	    protected PasswordEncoder passwordEncoder;

		@Autowired
		protected CredenzialiRepository credentialsRepository;
		
		@Transactional
		public Credenziali getCredenzialiById(Long id) {
			Optional<Credenziali> result = this.credentialsRepository.findById(id);
			return result.orElse(null);
		}
		
		@Transactional
		public Credenziali getCredenzialiByUsername(String username) {
			Optional<Credenziali> result = this.credentialsRepository.findByUsername(username);
			return result.orElse(null);
		}
			
	    @Transactional
	    public Credenziali saveCredentials(Credenziali credentials) {
	        credentials.setRole(Credenziali.DEFAULT_ROLE);
	        credentials.setPassword(this.passwordEncoder.encode(credentials.getPassword()));
	        return this.credentialsRepository.save(credentials);
	    }
}
