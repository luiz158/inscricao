package br.gov.serpro.inscricao;

import java.util.ArrayList;
import java.util.List;

public class Turma {

	private List<String> alunosMatriculados = new ArrayList<String>();
	
	public void matricular(String aluno) {
		alunosMatriculados.add(aluno);
	}

	public boolean estaMatriculado(String aluno) {
		return alunosMatriculados.contains(aluno);
	}

}
