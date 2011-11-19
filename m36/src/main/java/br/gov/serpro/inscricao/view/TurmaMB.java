package br.gov.serpro.inscricao.view;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.serpro.inscricao.business.TurmaBC;
import br.gov.serpro.inscricao.entity.Aluno;

@ViewController
public class TurmaMB {

	@Inject
	TurmaBC turmaBC;
	
	public List<Aluno> getAlunosMatriculados() {
		return turmaBC.obterAlunosMatriculados();
	}
}
