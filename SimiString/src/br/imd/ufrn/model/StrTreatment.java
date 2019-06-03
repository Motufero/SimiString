package br.imd.ufrn.model;

import java.security.NoSuchAlgorithmException;


public interface StrTreatment {

	String textSimplify(String text);
	String textSimplify(String text, int wordLen);
	String textCrypt(String text)throws NoSuchAlgorithmException;
	
	
}
