import java.util.ArrayList;

public class Listazo {
	
	void lista(){
		ArrayList<String> al;
		
		al=new ArrayList<String>();
		al.add("Elso");
		al.add("Masodik");
		al.add("Harmadik");
		
		for(String s : al){
			System.out.println(s);
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Listazo l=new Listazo();
		l.lista();
	}

}
