package com.m2i.tp.service;

import java.util.List;

import com.m2i.tp.entity.Categorie;
import com.m2i.tp.entity.Spectacle;

//interface (contrat) de service 
//business-service (service métier)
public interface ServiceSpectacle {
	    public void ajoutCategorie(Categorie c);
		public List<Categorie> findAllCategorie();
		
		 public void ajoutSpectacle(Spectacle s,Long idCategorie);
		 public List<Spectacle> findSpectablesSelonCategorie(Long idCategorie);
}
