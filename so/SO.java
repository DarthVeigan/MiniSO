package so;

import java.util.ArrayList;
import java.util.List;

public class SO {
	
	public static final int DELAY_CLOCK = 500;
	public static final int DELAY_PROCESSO = (DELAY_CLOCK * 2);
	
	private int tamanhoMemoria;
	private List<Processo> processos;
	
	public SO(int tamanhoMemoria) {
		this.tamanhoMemoria = tamanhoMemoria;
		this.processos = new ArrayList<Processo>();
	}
	
	public void init(int processos) {
		for (int i = 0; i < processos; ++i) {
			FabricaDeEntradas fabrica = new FabricaDeEntradas(this.tamanhoMemoria);
			Processo processo = new Processo(this, fabrica);
			this.processos.add(processo);
		}
		
		// Clock tem de ser iniciado após os processos estarem na array
		Clock clock = new Clock(this);
		clock.start();
		
		// Inicia os processos depois do clock (por conta dos bits)
		for (Processo processo : this.processos) {
			processo.start();
		}
	}
	
	public void clock(int tempo) {
		// Reseta o bit referenciado/modificado
	}
	
	public void lerValor(int posicao) {
		System.out.println("Ler na pos: " + posicao);
	}
	
	public void gravarValor(int posicao) {
		System.out.println("Escrever na pos: " + posicao);
	}
	
	public void encerrarProcesso(Processo processo) {
		this.processos.remove(processo);
	}
	
	public boolean isRunning() {
		return !this.processos.isEmpty();
	}

}
