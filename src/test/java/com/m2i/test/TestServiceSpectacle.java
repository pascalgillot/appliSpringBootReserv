package com.m2i.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.m2i.tp.SpectacleSpringBootApp;
import com.m2i.tp.entity.Categorie;
import com.m2i.tp.entity.Spectacle;
import com.m2i.tp.service.ServiceSpectacle;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {SpectacleSpringBootApp.class})
public class TestServiceSpectacle {
	
	@Autowired //relier le composant test au composant à tester
	private ServiceSpectacle servicespectacle; //chose à tester
	
	@Test
	public void testCrudCategorie() {
		Categorie c1 = new Categorie(null,"theatre");	servicespectacle.ajoutCategorie(c1);
		Categorie c2 = new Categorie(null,"concert");	servicespectacle.ajoutCategorie(c2);
		System.out.println("id de c1="+c1.getId());
		
		List<Categorie> listeCategories = servicespectacle.findAllCategorie();
		for(Categorie c : listeCategories) {
			System.out.println("c="+c.toString());
		}
	}
	
	@Test
	public void testSpectaclesSelonCategorie() {
		Categorie c1 = new Categorie(null,"theatre");	servicespectacle.ajoutCategorie(c1);
		Spectacle s1 = new Spectacle(null,"s1","description s1",90, 20 , 250);
		servicespectacle.ajoutSpectacle(s1, c1.getId());
		Spectacle s2 = new Spectacle(null,"s2","description s2",120, 30 , 200);
		servicespectacle.ajoutSpectacle(s2, c1.getId());
		
		List<Spectacle>  listeS = servicespectacle.findSpectablesSelonCategorie(c1.getId());
		Assert.assertTrue(listeS.size()>=2);
		for(Spectacle s : listeS) {
			System.out.println(s);
		}
		
		
	}

}
