import java.io.*;
import gnu.regexp.*;
import java.util.ArrayList;

public class LogReaderT2 {

	void runTest(String fileName){
		ArrayList<String> logRecords=new ArrayList<String>();
		BufferedReader br;
		String nextRec;
		long start,end;
		RE rex=null;
		start=System.currentTimeMillis();
		
		try {
			//br = new BufferedReader(new FileReader(fileName));
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName)), "ISO-8859-1"));
			while( (nextRec=br.readLine()) != null){
				logRecords.add(nextRec);
			}
			br.close();
		} catch(IOException ex) {
			
		} finally {
		}
		
		end=System.currentTimeMillis();
		System.out.println(logRecords.size());
		System.out.println("Elapsed time: "+(end-start)+"ms");
		
		int n1=0;
		int n2=0;
		
		start=System.currentTimeMillis();
		try {
			rex=new RE("^(.{11})\\s(\\d\\d:\\d\\d:\\d\\d)\\s(\\S+)\\s(\\w+\\.\\w+)\\s(\\w+):\\s+(ACCEPT|REJECT|DROP)\\s+");
		} catch (REException e) {
			
		}
		for(String s: logRecords){
			if(rex.isMatch(s)){
				n1++;
			} else {
				n2++;
			}
		}
		System.out.println("Known:"+n1+"  unknown:"+n2);
		end=System.currentTimeMillis();
		System.out.println("Elapsed time: "+(end-start)+"ms");
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogReaderT2 l=new LogReaderT2();
		l.runTest("/home/haazee/logteszt/kern.log.long");
	}

}
