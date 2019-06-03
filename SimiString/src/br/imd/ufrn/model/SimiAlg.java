package br.imd.ufrn.model;

public abstract class SimiAlg {
	protected double similarity;
	
	public SimiAlg () {
		similarity = 0;
	}
	
	/**
	 * Função abstrata que servirá para implementar as diversas funções de similaridade
	 * @return 
	 */
	
	public abstract int checkDistance(String text1, String text2);
	
	/**
	 * Função para retornar o indice de similaridade
	 * 
	 * @return similaridade
	 */
	
	public double getSimilarity() {
		return similarity;
	}
	
}
