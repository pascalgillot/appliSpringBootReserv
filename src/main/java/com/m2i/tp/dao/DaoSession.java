package com.m2i.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.m2i.tp.entity.Session;


/*
 * DAO = Data Access Object (objet technique qui sert à déclencher des traitements "CRUD" sur la base de données)
 *     d'un point de vue JEE/spring , c'est un sous service falculatif (mais hyper conseillé ) en arrière plan des services métiers
 */

// extends CrudRepository<TypeDeEntity,TypeDeId> avec Spring-Data-Jpa

public interface DaoSession extends CrudRepository <Session ,Long> {
	
	
	List<Session> findBySessionBySeId (Long idSpectacle);
	// codé via NamedQuery(name="Session.findBySessionBySeId" ,query="SELECT se FROM Session se WHERE se.spectacle.id= ?1")

}
