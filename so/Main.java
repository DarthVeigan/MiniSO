package so;

public class Main {
	
	public static void main(String[] args) {
		int tamanhoMemoria = 40;
		int processos = 2;
		
		SO so = new SO(tamanhoMemoria);
		so.init(processos);
	}

}
