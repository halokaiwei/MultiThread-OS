import java.util.concurrent.*;

public class ComponentA implements Runnable{
	Semaphore compA;
	public ComponentA (Semaphore compA) {
		this.compA = compA;
	}
	
	@Override
	public void run() {
		for (int i = 1;;i++ ) { 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Component-A: Unit-" + i + " produced");
			compA.release();
		}
	}

}
