package com.m2i.tp.rest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.tp.entity.Categorie;
import com.m2i.tp.entity.Spectacle;
import com.m2i.tp.service.ServiceSpectacle;




	@RestController //classe de WS REST avec spring MVC (cas particulier de @Component)
	@RequestMapping(value="/rest/spectacle" , headers="Accept=application/json")
	@CrossOrigin(origins = "*")//en mode dev //pour autoriser des appels ajax provenant
	                          //d'autres origines (exemple entreprise amie , ...)

	public class ServiceRestCtrl {		
		@Autowired
		private ServiceSpectacle serviceSpectacle; //service métier à injecter/utiliser
		
		
		@PostConstruct
		public void initJeuxDeDonneesEnModeDeveloppementPourCompenserBaseVide() {
			Categorie c1 = new Categorie(null,"theatre");	serviceSpectacle.ajoutCategorie(c1);
			Spectacle s1 = new Spectacle(null,"s1","description s1",90, 20 , 250);
			serviceSpectacle.ajoutSpectacle(s1, c1.getId());
			Spectacle s2 = new Spectacle(null,"s2","description s2",120, 30 , 200);
			serviceSpectacle.ajoutSpectacle(s2, c1.getId());
		}
		
		
		//URL = http://localhost:8080/spectacleSpringBoot/rest/spectacle/1
		@RequestMapping(value="/{idSpectacle}" , method=RequestMethod.GET)
		public Spectacle getSpectacleByNum(@PathVariable("idSpectacle") Long idSpectacle) {
			return null; //serviceSpectacle..(idSpectacle);
		}
		
		//URL = http://localhost:8080/spectacleSpringBoot/rest/spectacle/1
		@RequestMapping(value="/{idSpectacle}" , method=RequestMethod.DELETE)
		public void deleteSpectacleByNum(@PathVariable("idSpectacle") Long idSpectacle) {
				//....
		}
		
		//URL = http://localhost:8080/spectacleSpringBoot/rest/spectacle
		// ou   http://localhost:8080/spectacleSpringBoot/rest/spectacle?categorieId=1
		@RequestMapping(value="" , method=RequestMethod.GET)
		public List<Spectacle> getSpectaclesByCategoryId(
				@RequestParam(name="categorieId", required=false)Long categorieId){
			if(categorieId==null) {
			    //return serviceSpectacle.rechercherTousLesSpectacles();
				return null;
			}
			else {
				return serviceSpectacle.findSpectablesSelonCategorie(categorieId);
			}
		}

	}