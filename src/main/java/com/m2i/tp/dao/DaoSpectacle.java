package com.m2i.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.m2i.tp.entity.Spectacle;

/*
 * DAO = Data Access Object (objet technique qui sert à déclencher des traitements "CRUD" sur la base de données)
 *     d'un point de vue JEE/spring , c'est un sous service falculatif (mais hyper conseillé ) en arrière plan des services métiers
 */

// extends CrudRepository<TypeDeEntity,TypeDeId> avec Spring-Data-Jpa
public interface DaoSpectacle extends CrudRepository<Spectacle,Long> {

	
   //sans rien faire de plus , on hérite des méthodes pré-codées suivantes:
	// .findById() renvoyant en V5 Optional<Spectacle> sur lequel il faudra appeler .get() ou bien .orElse(null) pour récupérer le spectacle
	// .findAll()
	// .deleteById()
	// .save() au sens saveOrUpdate()
	
	
	List<Spectacle> findSpectaclesByCatId(Long idCategorie);
	//codé via @NamedQuery(name="Spectacle.findSpectaclesByCatId",query="SELECT s FROM Spectacle s WHERE s.categorie.id = ?1")
}
