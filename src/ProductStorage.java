import java.util.concurrent.Semaphore;

public class ProductStorage implements Runnable{
	private Semaphore pStor;
	private Semaphore pack;
	
	public ProductStorage (Semaphore pStor, Semaphore pack) {
		this.pStor = pStor;
		this.pack = pack;
	}
	
	@Override
	public void run() {
		int count = 0;
		for (int i = 1 ;; i++) {
			try {
				if(!pStor.hasQueuedThreads()) {
					System.out.println("Product Storage: waiting for assembler");
				}
				pStor.acquire();
				System.out.println("Product Storage: Product - "+ i + " produced");
				count++;
				if(count%6 == 0) {
					pack.release();
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
