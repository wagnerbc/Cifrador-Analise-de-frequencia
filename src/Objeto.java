
public class Objeto implements Comparable<Objeto>{

	char caracter;
	double indice;
	
	
	public Objeto(char caracter, double indice) {
		this.caracter = caracter;
		this.indice = indice;
	}


	@Override
	public int compareTo(Objeto o) {
		if(this.indice < o.indice){
			return 1;
		}
		if (this.indice > o.indice) {
			return -1;
		}
		return 0;
	}
	
	
}
