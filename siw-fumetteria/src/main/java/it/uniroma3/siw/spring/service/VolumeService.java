package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.spring.model.Volume;
import it.uniroma3.siw.spring.repository.VolumeRepository;

@Service
public class VolumeService 
{
	@Autowired
	protected VolumeRepository volumeRepository;
	
	@Transactional
	public Volume getVolume(String id)
	{
		Optional<Volume> result = this.volumeRepository.findById(id);
		return result.orElse(null);
	}
	
	@Transactional
	public Volume saveVolume(Volume volume) 
	{
		return this.volumeRepository.save(volume);
	}
	
	public  boolean duplicato(Volume volume)
	{
		List<Volume>result=this.volumeRepository.findByIsbn(volume.getIsbn());
		if(result.size()>0)
		{
			return true;
		}
		return false;
	}
	
}