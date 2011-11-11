package br.gov.serpro.inscricao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.stereotype.Controller;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.gov.serpro.inscricao.config.InscricaoConfig;
import br.gov.serpro.inscricao.entity.Aluno;
import br.gov.serpro.inscricao.exception.TurmaException;

@Controller   // para poder utilizar @ExceptionHandler
public class Turma {

	//private List<String> alunosMatriculados = new ArrayList<String>();
	//private List<Aluno> alunosMatriculados = new ArrayList<Aluno>();
	
	@Inject
	private Logger logger; // = LoggerFactory.getLogger(Turma.class);
	
	@Inject
	private ResourceBundle bundle;
	
	@Inject
	private InscricaoConfig config;
	
	@Inject
	private EntityManager em;   // obs.: pode ser injectado em EM devido à extensão demoiselle-jpa
	
	@Transactional
	public void matricular(Aluno aluno) {
		if( estaMatriculado(aluno) ) {
			logger.info(bundle.getString("aluno.ja.matriculado", aluno.getNome()));
			//throw new RuntimeException();
			throw new TurmaException();
		}
		
		//if( alunosMatriculados.size() >= 5 ) {
		//if( alunosMatriculados.size() >= config.getCapacidadeTurma() ) {
		if( obterAlunosMatriculados().size() >= config.getCapacidadeTurma() ) {
			logger.info(bundle.getString("turma.ja.completa", aluno.getNome()));
			//throw new RuntimeException();
			throw new TurmaException();
		}
		
		//alunosMatriculados.add(aluno);
		//em.getTransaction().begin();
		em.persist(aluno);
		//em.getTransaction().commit();
		
		//System.out.println("Aluno matriculado com sucesso!");
		//logger.info("Aluno matriculado com sucesso!");
		logger.info(bundle.getString("matricula.sucesso", aluno.getNome()));
	}
	
	public boolean estaMatriculado(Aluno aluno) {
		//return alunosMatriculados.contains(aluno);
		return obterAlunosMatriculados().contains(aluno);
	}
	
	@ExceptionHandler     // deve anotar a classe com @Controller
	//public void tratar(RuntimeException e) {
	public void tratar(TurmaException e) {
		logger.warn(bundle.getString("matricula.erro"));
		throw e;
	}
	
	public List<Aluno> obterAlunosMatriculados() {
		return em.createQuery("select a from Aluno a").getResultList();
	}

}
