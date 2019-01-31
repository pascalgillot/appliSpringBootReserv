package com.m2i.tp.service;

import java.util.List;

import com.m2i.tp.entity.Session;
import com.m2i.tp.entity.Spectacle;

public interface ServiceSession {
	public void ajoutSpectacle (Spectacle s);
	public List<Spectacle> findAllSpectacle();
	
	public void ajoutSession (Session se,Long idSpectacle);
	public List<Session> findSessionSelonSpectacle (Long idSpectacle);

}
