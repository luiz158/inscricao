package br.gov.serpro.inscricao;

import junit.framework.Assert;

import org.junit.Test;

public class TurmaTest {
	
	@Test
	public void matricularAlunoComSucesso() {
		Turma turma = new Turma();
		
		turma.matricular("Santos Dumont");
		Assert.assertTrue(turma.estaMatriculado("Santos Dumont"));
	}

	@Test
	public void falhaAoTentarMatricularAlunoDuplicado() {
	}

	@Test
	public void falhaAoTentarMatricularAlunoNaTurmaCheia() {
	}

}
