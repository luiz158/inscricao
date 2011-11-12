package br.gov.serpro.inscricao.exception;

import br.gov.frameworkdemoiselle.exception.ApplicationException;

@ApplicationException(rollback=true)
public class TurmaException extends RuntimeException {
	public TurmaException() {
		super("Erro na matrícula!!!");
	}

}
