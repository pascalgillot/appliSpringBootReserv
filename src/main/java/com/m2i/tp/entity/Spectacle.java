package com.m2i.tp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@NamedQuery(name="Spectacle.findSpectaclesByCatId",query="SELECT s FROM Spectacle s WHERE s.categorie.id = ?1")
public class Spectacle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private Integer duration;
	private Integer price;
	private Integer nbPlace;
	
	@ManyToOne
	@JoinColumn(name="refCategorie")//nom de la colonne clef etrangere
	@JsonIgnore
	private Categorie categorie;
	
	
	public Spectacle() {
		super();
	}


	public Spectacle(Long id, String title, String description, Integer duration, Integer price, Integer nbPlace) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.duration = duration;
		this.price = price;
		this.nbPlace = nbPlace;
	}


	@Override
	public String toString() {
		return "Spectacle [id=" + id + ", title=" + title + ", description=" + description + ", duration=" + duration
				+ ", price=" + price + ", nbPlace=" + nbPlace + "]";
	}
	
	
	
	
	
}
