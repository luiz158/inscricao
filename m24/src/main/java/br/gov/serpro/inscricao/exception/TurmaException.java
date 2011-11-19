package br.gov.serpro.inscricao.exception;

import br.gov.frameworkdemoiselle.exception.ApplicationException;

@ApplicationException(rollback=false)
public class TurmaException extends RuntimeException {

}
