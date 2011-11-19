package br.gov.serpro.inscricao.view;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.serpro.inscricao.business.TurmaBC;
import br.gov.serpro.inscricao.entity.Aluno;

@ViewController
public class TurmaMB {

	@Inject
	TurmaBC turmaBC;
	
	//@Inject
	//FacesContext facesContext;
	
	private String nomeAluno;
	
	public void matricular() {
		turmaBC.matricular(new Aluno(nomeAluno));
		//facesContext.addMessage("sucesso", new FacesMessage("Cadastro realizado com sucesso"));
	}
	
	public List<Aluno> getAlunosMatriculados() {
		return turmaBC.obterAlunosMatriculados();
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
}
