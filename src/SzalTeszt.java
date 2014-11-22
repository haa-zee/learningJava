import java.lang.Thread;
import java.util.ArrayList;


public class SzalTeszt {

	static volatile boolean stopThreads=false;
	
	public void met1(){
		ArrayList<Thread> t=new ArrayList<Thread>();
		
		for(int i=0; i<4; i++){
			t.add(new Thread(new Szalnakvalo()));
		}
		
		for(Thread threadInstance : t){
			threadInstance.start();
		}
		
		try {
			Thread.sleep(15000);
			stopThreads=true;
			for(Thread threadInstance : t){
				threadInstance.join();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Egy teszt arra, hogy javaban nincs GIL, mint pythonban vagy ruby-ban
		 * ha annyi szálat indítok, ahány processzormag tartozik a géphez, akkor valamennyi 
		 * mag 100%-on fog pörögni, míg ugyanezt pythonban megcsinálva, csak egy mag tud dolgozni.
		 */
		SzalTeszt s=new SzalTeszt();
		s.met1();
	}

}

class Szalnakvalo implements Runnable {
	
	long n;

	Szalnakvalo() {
		System.out.println("Szál inicializálva:"+Thread.currentThread().getName());
		this.n=0;
	}
	
	
	public void run(){
		System.out.println("Szál elindítva:"+Thread.currentThread().getName());
		while(!SzalTeszt.stopThreads){
			this.n++;
		}
		System.out.println(Thread.currentThread().getName()+" : "+this.n);
	}
}