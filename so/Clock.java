package so;

public class Clock extends Thread {
	
	private SO so;
	private int contador;
	
	public Clock(SO so) {
		this.so = so;
	}
	
	public void run() {
		while (this.so.isRunning()) {
			// Pra não ser muito rápido
			try {
				Thread.sleep(SO.DELAY_CLOCK);
			} catch (Exception e) {
				
			}
			
			contador += 1;
			this.so.clock(contador);
		}
	}

}
