package br.gov.serpro.inscricao;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.serpro.inscricao.business.TurmaBC;
import br.gov.serpro.inscricao.entity.Aluno;
import br.gov.serpro.inscricao.exception.TurmaException;

@RunWith(DemoiselleRunner.class)
public class TurmaTest {
	
	@Inject
	TurmaBC turmaBC;
	
	@Inject
	SecurityContext securityContext;
	
	@Before
	public void setUp() {
		securityContext.login();
	}
	
	@Test
	public void matricularAlunoComSucesso() {
		//Turma turma = new Turma();
		Aluno aluno = new Aluno("Santos Dumont");
		turmaBC.matricular(aluno);
		Assert.assertTrue(turmaBC.estaMatriculado(aluno));
	}

	//@Test(expected=RuntimeException.class)
	@Test(expected=TurmaException.class)
	public void falhaAoTentarMatricularAlunoDuplicado() {
		Aluno aluno = new Aluno("Nome Duplicado");
		turmaBC.matricular(aluno);
		turmaBC.matricular(aluno);
	}

	//@Test(expected=RuntimeException.class)
	@Test(expected=TurmaException.class)
	public void falhaAoTentarMatricularAlunoNaTurmaCheia() {
		for( int i = 1; i<=5 ; i++ ) {
			turmaBC.matricular(new Aluno("Aluno " + i));
		}
		turmaBC.matricular(new Aluno("Aluno 6"));
	}

}
