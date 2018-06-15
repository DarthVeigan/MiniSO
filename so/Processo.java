package so;

public class Processo extends Thread {
	
	private SO so;
	private FabricaDeEntradas fabrica;
	
	public Processo(SO so, FabricaDeEntradas fabrica) {
		this.fabrica = fabrica;
		this.so = so;
	}
	
	@Override
	public void run() {
		System.out.println(this.fabrica.getNewEntrada());
		String[] entradas = this.fabrica.getNewEntrada().split(",");
		
		for (String entrada : entradas) {
			String[] operacao = entrada.split("-");
			
			int posicao = Integer.parseInt(operacao[0]);
			String tipo = operacao[1];
			// int valor = Integer.parseInt(operacao[2]);
			
			if (tipo.equals("R")) {
				this.so.lerValor(posicao);
			} else if (tipo.equals("W")) {
				this.so.gravarValor(posicao);
			}
			
			// Pra não ser muito rápido
			try {
				Thread.sleep(SO.DELAY_PROCESSO);
			} catch (Exception e) {
				
			}
		}
		
		this.so.encerrarProcesso(this);
	}
	
	

}
