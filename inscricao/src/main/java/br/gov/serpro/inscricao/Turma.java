package br.gov.serpro.inscricao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.exception.ExceptionHandler;
import br.gov.frameworkdemoiselle.stereotype.Controller;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.gov.serpro.inscricao.config.InscricaoConfig;
import br.gov.serpro.inscricao.exception.TurmaException;

@Controller   // para poder utilizar @ExceptionHandler
public class Turma {

	private List<String> alunosMatriculados = new ArrayList<String>();
	
	@Inject
	private Logger logger; // = LoggerFactory.getLogger(Turma.class);
	
	@Inject
	private ResourceBundle bundle;
	
	@Inject
	private InscricaoConfig config;
	
	public void matricular(String aluno) {
		if( estaMatriculado(aluno) ) {
			logger.info(bundle.getString("aluno.ja.matriculado", aluno));
			//throw new RuntimeException();
			throw new TurmaException();
		}
		
		//if( alunosMatriculados.size() >= 5 ) {
		if( alunosMatriculados.size() >= config.getCapacidadeTurma() ) {
			logger.info(bundle.getString("turma.ja.completa", aluno));
			//throw new RuntimeException();
			throw new TurmaException();
		}
		
		alunosMatriculados.add(aluno);
		//System.out.println("Aluno matriculado com sucesso!");
		//logger.info("Aluno matriculado com sucesso!");
		logger.info(bundle.getString("matricula.sucesso", aluno));
	}

	public boolean estaMatriculado(String aluno) {
		return alunosMatriculados.contains(aluno);
	}
	
	@ExceptionHandler     // deve anotar a classe com @Controller
	//public void tratar(RuntimeException e) {
	public void tratar(TurmaException e) {
		logger.warn(bundle.getString("matricula.erro"));
		throw e;
	}

}
