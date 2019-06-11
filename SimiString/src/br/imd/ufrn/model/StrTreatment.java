package br.imd.ufrn.model;

import java.security.NoSuchAlgorithmException;

/**
 * Interface que as funções de tratamento de Strings devem implementar
 * @author Saulo Gabriel
 * 
 */


public interface StrTreatment {

	String textSimplify(String text);
	String textSimplify(String text, int wordLen);
	String textCrypt(String text)throws NoSuchAlgorithmException;
	
	
}
