import java.util.concurrent.Semaphore;

public class Labeller implements Runnable{
	private Semaphore labeller;
	
	public Labeller (Semaphore labeller) {
		this.labeller = labeller;
	}
	
	@Override
	public void run() {
		for (int i = 0;;i++) {
			try {
				labeller.acquire();
				System.out.println("Labeller: Box - "+ i + " labelled");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
