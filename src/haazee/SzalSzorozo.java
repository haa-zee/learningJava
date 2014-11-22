package haazee;
import java.util.*;

class Szal implements Runnable {
	
	ArrayList<Integer> ll;
	
	Szal(ArrayList<Integer> pll){
		this.ll = pll;
	}
	public synchronized void run(){
		for( int i=0; i<1000; i++){
			if(ll.size()>0){
				ll.add(ll.get(ll.size()-1)+1);
			} else {
				ll.add(1);
			}
		}
	}
}
public class SzalSzorozo {
	
	protected synchronized void syncPrint(Object o){
		System.out.println(o);
	}
	
	protected void start(){
		ArrayList<Integer> ll=new ArrayList<Integer>();
		
		Thread[] ts=new Thread[5];
		try {
			for (Thread thread : ts) {
				thread=new Thread(new Szal(ll));
				thread.start();
			}
			
			try {
				for(Thread thread : ts) {
					thread.join();
				}
			} catch (Exception e) {
				this.syncPrint(e);
			}
		} catch (Error e){
			syncPrint(e);
		}
		syncPrint(ll);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SzalSzorozo sz=new SzalSzorozo();
		sz.start();

	}

}
