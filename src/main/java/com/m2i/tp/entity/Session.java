package com.m2i.tp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter @Setter
@NamedQuery(name="Session.findBySessionBySeId" ,query="SELECT se FROM Session se WHERE se.spectacle.id= ?1")
public class Session {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long date;
	private Long startime;
	private Long nbRemainingPlace;
	
	@ManyToOne
	@JoinColumn(name="refSpectacle")
	private Spectacle spectacle;
	
	public Session() {
		super();
	}

	public Session(Long id, Long date, Long startime, Long nbRemainingPlace) {
		super();
		this.id = id;
		this.date = date;
		this.startime = startime;
		this.nbRemainingPlace = nbRemainingPlace;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", date=" + date + ", startime=" + startime + ", nbRemainingPlace="
				+ nbRemainingPlace + "]";
	}
	
	
	

}
