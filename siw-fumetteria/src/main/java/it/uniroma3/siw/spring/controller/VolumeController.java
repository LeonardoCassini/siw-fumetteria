package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import it.uniroma3.siw.spring.service.VolumeService;


@RestController
public class VolumeController 
{
	@Autowired
	private VolumeService volumeService;
}
