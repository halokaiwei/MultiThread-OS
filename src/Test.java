import java.util.concurrent.Semaphore;

public class Test {
	public static void main(String[] agrs) {
		Semaphore semA = new Semaphore(0, true);
		Semaphore semB = new Semaphore(0, true);
		Semaphore semAss = new Semaphore(0, true);
		Semaphore semPStor = new Semaphore (0, true);
		Semaphore semPack = new Semaphore (0, true);
		Semaphore semLabel = new Semaphore(0,true);
		ComponentA pA = new ComponentA(semA);
		ComponentB pB = new ComponentB(semB);
		Assembler pAss = new Assembler(semA, semB, semPStor);
		ProductStorage pPS= new ProductStorage(semPStor, semPack);
		Packer pP = new Packer (semPack, semLabel);
		Labeller pL = new Labeller (semLabel);
		new Thread(pA).start();
		new Thread(pB).start();
		new Thread(pAss).start();
		new Thread(pPS).start();
		new Thread(pP).start();
		new Thread(pL).start();
	}
}
