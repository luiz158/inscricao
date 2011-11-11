package br.gov.serpro.inscricao;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class TurmaTest {
	
	@Inject
	Turma turma;
	
	@Test
	public void matricularAlunoComSucesso() {
		//Turma turma = new Turma();
		
		turma.matricular("Santos Dumont");
		Assert.assertTrue(turma.estaMatriculado("Santos Dumont"));
	}

	@Test(expected=RuntimeException.class)
	public void falhaAoTentarMatricularAlunoDuplicado() {
		turma.matricular("Aluno Duplicado");
		turma.matricular("Aluno Duplicado");
	}

	@Test(expected=RuntimeException.class)
	public void falhaAoTentarMatricularAlunoNaTurmaCheia() {
		for( int i = 1; i<=5 ; i++ ) {
			turma.matricular("Aluno " + i);
		}
		turma.matricular("Aluno 6");
	}

}
