import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;

public class CopyOfLogReaderT1 {

	void runTest(String fileName){
		
		ArrayList<String> logRecords=new ArrayList<String>();
		BufferedReader br;
		String nextRec;
		long start,end,n;
		
		start=System.currentTimeMillis();
		n=0;
		try {
			//br = new BufferedReader(new FileReader(fileName));
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName)), "ISO-8859-1"));
			while( (nextRec=br.readLine()) != null){
				n++;
			}
			br.close();
		} catch(IOException ex) {
			
		} finally {
		}
		
		end=System.currentTimeMillis();
		System.out.println(n);
		System.out.println("Elapsed time: "+(end-start)+"ms");
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyOfLogReaderT1 l=new CopyOfLogReaderT1();
		l.runTest("kern.log");
	}

}
