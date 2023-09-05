import java.util.concurrent.Semaphore;

public class Packer implements Runnable{
	private Semaphore packer;
	private Semaphore label;
	
	public Packer (Semaphore pack, Semaphore label) {
		this.packer = pack;
		this.label = label;
	}
	
	@Override
	public void run () {
		for (int i = 1;; i++) {
			try {
				packer.acquire();
				Thread.sleep(2000);
				System.out.print("Packer : Box- " + i + " packed.");
				label.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
