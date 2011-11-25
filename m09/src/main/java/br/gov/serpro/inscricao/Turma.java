package br.gov.serpro.inscricao;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;

import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class Turma {

	private List<String> alunosMatriculados = new ArrayList<String>();
	
	@Inject
	private Logger logger; // = LoggerFactory.getLogger(Turma.class);
	
	@Inject
	private ResourceBundle bundle;
	
	public void matricular(String aluno) {
		alunosMatriculados.add(aluno);
		//System.out.println("Aluno matriculado com sucesso!");
		//logger.info("Aluno matriculado com sucesso!");
		logger.info(bundle.getString("matricula.sucesso"));
	}

	public boolean estaMatriculado(String aluno) {
		return alunosMatriculados.contains(aluno);
	}

}