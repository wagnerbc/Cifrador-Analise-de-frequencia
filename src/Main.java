import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {

	static String frase = "g5Bt5 t54yvtz3v4A5 wrG t53 7Bv r9 6v995r9 9v 9z4Ar3 58xB2y59r9. dBzA5 t54yvtz3v4A5, 7Bv 9v 9z4Ar3 yB3z2uv9. Vy r99z3 7Bv r9 v96zxr9 9v3 x8r59 v8xBv3 uv9uv4y59r3v4Av r trsvtr 6r8r 5 tvB, v47Br4A5 r9 tyvzr9 r9 srzEr3 6r8r r Av88r, 9Br 3rv. cv54r8u5 Ur mz4tz";

	static String fraseOriginal = frase;
	
	
	static int y = frase.length();
	static int[] controle = new int[y];
	
	static List<Objeto> lista = new ArrayList<Objeto>();
	static List<Objeto> frequencia = new ArrayList<Objeto>();
	static List<Objeto> fraseCifrada = new ArrayList<Objeto>();
	
	
	
	
	public static void main(String[] args) {
	
		AnaliseFrequencia();

	}	
	
	/* engloba os demais métodos */
	public static void AnaliseFrequencia(){
		
		preencheFraseCifrada();
		preencheListaFrequencia();
		preencheListaOcorrencia();
		
		
		Collections.sort(frequencia);
		System.out.println("Frequência ordenada");
		for(Objeto obj: frequencia){
			System.out.println(obj.caracter + " --> " + obj.indice);
		}
		
		Collections.sort(lista);
		System.out.println("Lista ordenada");
		for(Objeto obj: lista){
			System.out.println(obj.caracter + " --> " + obj.indice);
		}	
		
		replaceAll(fraseCifrada,lista,frequencia);
		
		
		Scanner read = new Scanner(System.in);
		String old;
		String novo;
		while(true){
			System.out.println("Frase Cifrada: " + fraseOriginal);
			System.out.println("Frase:         " + frase);
			
			System.out.println("-------- TROCAR DE NOVO --------");
			System.out.println("Caracter a ser trocado: ");
			old = read.nextLine();
			System.out.println("Caracter a ser inserido: ");
			novo = read.nextLine();
			novo = novo.toUpperCase();
			frase = trocaIndividual(old.charAt(0), novo.charAt(0));
		}
	}
	
	
	/* Preenche a lista "frequencia" com a porcentagem referente à
	   frequencia de cada letra do alfabeto, conforme a tabela */
	public static void preencheListaFrequencia(){
		String caracter = "abcdefghijklmnopqrstuvwxyz";
		double[] a = {14.63, 1.04, 3.88, 4.99,12.57, 1.02, 1.30, 1.28, 6.18, 0.40, 0.02, 2.78, 4.74, 5.05, 10.73, 2.52, 1.20, 6.53, 7.81, 4.34, 4.63, 1.67, 0.01, 0.21, 0.01, 0.47};
		
		for(int i = 0; i < caracter.length(); i += 1){
			Objeto f = new Objeto(caracter.charAt(i), a[i]);
			frequencia.add(f);
		}
	}
	
	/* Preenche a lista "lista" com a quantidade de ocorrências de cada caracter da frase cifrada */
	public static void preencheListaOcorrencia(){
		
		int contador = 0; // controla a inserção dos caracteres na lista
		
		for(int i = 0; i < frase.length(); i += 1){
			if((frase.charAt(i) != ' ') && (frase.charAt(i) != '.') && (frase.charAt(i) != ',')){
				for(Objeto obj: lista){		// percorre a lista verificando se o caracter já foi inserido
					if(frase.charAt(i) == obj.caracter){	//caso já tenha sido inserido, incrementa o índice
						contador = 1;	//
						obj.indice+=1;
						break;
					}
				}
								
				if(contador == 0){ 	// insere um novo caracter na lista, juntamente com a quantidade atual (1)
					Objeto obj = new Objeto(frase.charAt(i),1);
					lista.add(obj);
				}else{
					contador = 0;
				}
			}
		}
	}
	
	/* preenche a lista "fraseCifrada" */
	public static void preencheFraseCifrada(){
				
		for(int i = 0; i < frase.length(); i += 1){
			Objeto f = new Objeto(frase.charAt(i), 0);
			fraseCifrada.add(f);
		}
	}
	
	
	/* realiza a troca dos caracteres */
	public static String troca(char alvo, char novoChar){
		
		List<Objeto> frase_cifrada = fraseCifrada;
		
		for(Objeto obj : frase_cifrada){
			if((obj.caracter == alvo) && (obj.indice == 0)){
				obj.caracter = novoChar;
				obj.indice = 1;
			}
		}
		
		String fraseAlterada = "";
		for(Objeto obj : frase_cifrada){
			fraseAlterada += obj.caracter;
		}
		
		return fraseAlterada;
	}
	
	public static String trocaIndividual(char alvo, char novoChar){
				
		List<Objeto> frase_cifrada = fraseCifrada;
		
		
		for(Objeto obj : frase_cifrada){
			if(obj.caracter == alvo){
				obj.caracter = novoChar;
			}
		}
		
		String fraseAlterada = "";
		for(Objeto obj : frase_cifrada){
			fraseAlterada += obj.caracter;
		}
		
		return fraseAlterada;
		
	}
	
	
	public static void replaceAll(List<Objeto> frase_cifrada, List<Objeto> lista, List<Objeto> frequencia){
				
		String lista1 = "";
		for(Objeto obj: lista){
			lista1 += obj.caracter;
		}
		
		String lista2 = "";
		for(Objeto obj: frequencia){
			lista2 += obj.caracter;
		}
		
		System.out.println(lista1);
		System.out.println(lista2);
			
		for(int i = 0; i < lista2.length(); i ++){
			frase = troca(lista1.charAt(i),lista2.charAt(i));
		}
	}
}
/*
 * o s
 * r n 
 * u t
 * n m
 * s o
 * l q
 * m c
 * d u
 * c h
 * h l
 * j m
 * g d
 * t r
 * v g
 * b p
 * q b
 * k x
 * w l
 * y d
 * */