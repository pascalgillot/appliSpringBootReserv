package com.m2i.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.dao.DaoCategorie;
import com.m2i.tp.dao.DaoSpectacle;
import com.m2i.tp.entity.Categorie;
import com.m2i.tp.entity.Spectacle;

@Service //service spring
@Transactional //pour commit/rollback automatiques
public class ServiceSpectacleImpl implements ServiceSpectacle {
	
	@Autowired //injection de dépendance (relier 2 composants "spring" ensemble)
	private DaoSpectacle daoSpectable;
	
	@Autowired //injection de dépendance (relier 2 composants "spring" ensemble)
	private DaoCategorie daoCategorie;

	@Override
	public void ajoutCategorie(Categorie c) {
		daoCategorie.save(c);
	}

	@Override
	public List<Categorie> findAllCategorie() {
		return (List<Categorie>) daoCategorie.findAll();
	}

	@Override
	public void ajoutSpectacle(Spectacle s, Long idCategorie) {
		Categorie categorieExistante = daoCategorie.findById(idCategorie).get();
		
		s.setCategorie(categorieExistante); //on relie le nouveau spectacle à la categorieExistante
		
		daoSpectable.save(s);//on moement ou l'onjet java s (de type spectacle) sera sauvegardé en base
		                     //la clef etrangère (précisée via @Joincolumn) sera mise à jour
	}

	@Override
	public List<Spectacle> findSpectablesSelonCategorie(Long idCategorie) {
		return daoSpectable.findSpectaclesByCatId(idCategorie);
	}

}
