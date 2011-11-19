package br.gov.serpro.inscricao.security;

import javax.enterprise.inject.Alternative;

import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.User;

@Alternative
public class Autenticador implements Authenticator {

	@Override
	public boolean authenticate() {
		// TODO Auto-generated method stub
		//return false;
		return true;
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		//return null;
		return new User() {
			
			@Override
			public void setAttribute(Object arg0, Object arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public String getId() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getAttribute(Object arg0) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	@Override
	public void unAuthenticate() {
		// TODO Auto-generated method stub

	}

}
