import java.util.concurrent.Semaphore;

public class Assembler implements Runnable{
	private Semaphore compA;
	private Semaphore compB;
	private Semaphore pStorage;
	
	public Assembler ( Semaphore compA, Semaphore compB, Semaphore pStorage) {
		this.compA = compA;
		this.compB = compB;
		this.pStorage = pStorage;
	}
	
	@Override
	public void run() {
		for (int i = 1;;i++) {
			try {
				
				if(!compA.hasQueuedThreads() || !compB.hasQueuedThreads()) {
					System.out.println("Assembler: waiting for components.");
				}
				compA.acquire();
				compB.acquire();
				Thread.sleep(2000);
				System.out.println("Assembler: Product - "+ i + " completed.");
				pStorage.release();
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
