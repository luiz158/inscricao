package br.gov.serpro.inscricao.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.serpro.inscricao.entity.Aluno;

@PersistenceController
public class AlunoDAO extends JPACrud<Aluno, Integer>{
	
//	@Inject
//	private EntityManager em;
//	
//	public void insert(Aluno aluno) {
//		em.persist(aluno);
//	}
//	
//	public List<Aluno> findAll() {
//		return em.createQuery("select a from Aluno a").getResultList();
//	}

}
