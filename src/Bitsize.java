import java.io.UnsupportedEncodingException;

public class Bitsize {

	public static void main(String[] argv){
//		String teszt="ÁrvíztűrőTÜKÖRFÚRÓGÉP";
		String teszt="ŰŐ";
		byte[] n=null;
		
		try {
			n=teszt.getBytes("UTF-16");
		} catch(UnsupportedEncodingException e){
			
		};
		System.out.println("byte length:"+n.length);
		System.out.println("String length:"+teszt.length());
		
		
	}
}
