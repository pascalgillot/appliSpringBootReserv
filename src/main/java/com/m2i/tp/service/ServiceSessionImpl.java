package com.m2i.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.m2i.tp.dao.DaoSession;
import com.m2i.tp.dao.DaoSpectacle;
import com.m2i.tp.entity.Session;
import com.m2i.tp.entity.Spectacle;

public class ServiceSessionImpl implements ServiceSession {
	@Autowired
	private DaoSession daoSession;
	@Autowired
	private DaoSpectacle daoSpectacle;

	@Override
	public void ajoutSpectacle(Spectacle s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Spectacle> findAllSpectacle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajoutSession(Session se, Long idSpectacle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Session> findSessionSelonSpectacle(Long idSpectacle) {
		// TODO Auto-generated method stub
		return null;
	}

}
