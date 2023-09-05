import java.util.concurrent.*;

public class ComponentB implements Runnable{
	private Semaphore compB;
	public ComponentB(Semaphore compB) {
		this.compB = compB;
	}
	
	@Override
	public void run() {
		for (int i = 1;;i++ ) { //for (int i = 1;;i++ )
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Component-B: Unit-" + i + " produced");
			compB.release();
		}
	}

}
