package com.apiapp.apirest.config;

import org.hibernate.envers.RevisionListener;

import com.apiapp.apirest.Entities.audit.Revision;

public class CustomRevisionListener implements RevisionListener {

	//va a ser el encargado de realizar una revision cada vez que se haga una consulta
	public void newRevision(Object revisionEntity) { 
		final Revision revision = (Revision) revisionEntity;
	}
	
}
