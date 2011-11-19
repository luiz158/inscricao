package br.gov.serpro.inscricao.security;

import javax.enterprise.inject.Alternative;

import br.gov.frameworkdemoiselle.security.Authorizer;

@Alternative
public class Autorizador implements Authorizer {

	@Override
	public boolean hasPermission(String arg0, String arg1) {
		// TODO Auto-generated method stub
		//return false;
		return true;
	}

	@Override
	public boolean hasRole(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
