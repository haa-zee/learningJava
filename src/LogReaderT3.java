import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LogReaderT3 {

	void runTest(String fileName){
		ArrayList<String> logRecords=new ArrayList<String>();
		long start,end;
		Scanner sc;
		
		start=System.currentTimeMillis();
		
		try {
			sc = new Scanner( new File(fileName));
			sc.useDelimiter("\n");
			while( sc.hasNext() ){
				logRecords.add(sc.next());
			}
			sc.close();
		} catch(IOException ex) {
			
		} finally {
		}
		
		end=System.currentTimeMillis();
		System.out.println(logRecords.size());
		System.out.println("Elapsed time: "+(end-start)+"ms");
		
		int n1=0;
		int n2=0;
		
		start=System.currentTimeMillis();
		Pattern pat=Pattern.compile("^(.{11})\\s(\\d\\d:\\d\\d:\\d\\d)\\s(\\S+)\\s(\\w+\\.\\w+)\\s(\\w+):\\s+(ACCEPT|REJECT|DROP)\\s+.*?" );
		for(String s: logRecords){
			Matcher mat=pat.matcher(s);
			if(mat.find()){
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
		LogReaderT3 l=new LogReaderT3();
		l.runTest("/home/haazee/kern.log");
	}

}
