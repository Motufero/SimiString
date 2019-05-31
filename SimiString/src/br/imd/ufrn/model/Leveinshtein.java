package br.imd.ufrn.model;


/**
 * Classe responsável por verificar similaridade entre duas Strings
 * Codigo obtido em: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EditDistance.java
 *
 * @author Saulo Gabriel
 */


public class Leveinshtein {

	
/**
 * 	
 * @param str1 Texto 1
 * @param str2 Texto 2
 * @return numero de inserções, deleções ou substituições necessárias para transformar 
 * texto 1 em texto 2
 */
	
	public int checkDistance(char[] str1, char[] str2){
	        int temp[][] = new int[str1.length+1][str2.length+1];
	        
	        for(int i=0; i < temp[0].length; i++){
	            temp[0][i] = i;
	        }
	        
	        for(int i=0; i < temp.length; i++){
	            temp[i][0] = i;
	        }
	        
	        for(int i=1;i <=str1.length; i++){
	            for(int j=1; j <= str2.length; j++){
	                if(str1[i-1] == str2[j-1]){
	                    temp[i][j] = temp[i-1][j-1];
	                }else{
	                    temp[i][j] = 1 + min(temp[i-1][j-1], temp[i-1][j], temp[i][j-1]);
	                }
	            }
	        }
	        
	        return temp[str1.length][str2.length];
	        
	    }

	/**
	 * Funçao para calcular valor minimo (serve apenas para auxiliar Leveinshtein)
	 * 
	 */
	
	public int min(int val1, int val2, int val3) {
		if (val1 <= val2 && val1 <= val3) {
			return val1;
		}
		if (val2 <= val1 && val2 <= val3) {
			return val2;
		}else {
			return val3;
		}
		
	}
	 
	/**
	 * Função que vai dar o percentual de quanto uma String é semelhante a outra
	 * @param leveinVar valor resultado da função Leveinshtein
	 * @param tamanho1 tamanho da primeira String
	 * @param tamaho2 tamanho da segunda String
	 * @return
	 */
	public float indiceSimil(int leveinVar, int tamanho1, int tamanho2) {
		if(tamanho1>=tamanho2) {
			return ((float)tamanho1/(tamanho1+leveinVar));
		} else {
			return ((float)tamanho2/(tamanho1+leveinVar));
		}
		
	}
	
	
	
}
