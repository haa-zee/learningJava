import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;

public class LogReaderT4 {

	void runTest(String fileName, int bufferSize, String pattern){
		ArrayList<String> logRecords=new ArrayList<String>();
		BufferedReader br;
		String nextRec;
		long start,end;
		System.out.println("File:"+fileName);
		System.out.println("Pattern: "+pattern);
		System.out.println("Buffer: "+bufferSize);
		start=System.currentTimeMillis();
		
		try {
			//br = new BufferedReader(new FileReader(fileName));
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName)), "ISO-8859-1"), bufferSize);
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
		Pattern pat=Pattern.compile(pattern);
		for(int i=0; i<10; i++){
			for(String s: logRecords){
				Matcher mat=pat.matcher(s);
				if(mat.find()){
					n1++;
				} else {
					n2++;
				}
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
		int bufferSize=8192;
		String pattern="^(.{11})\\s(\\d\\d:\\d\\d:\\d\\d)\\s(\\S+)\\s(\\w+\\.\\w+)\\s(\\w+):\\s+(ACCEPT|REJECT|DROP)\\s+(.*+)$";
		if(args.length>0) bufferSize=Integer.parseInt(args[0]);
		if(args.length>1) pattern=args[1];
		
		LogReaderT4 l=new LogReaderT4();
		l.runTest("/home/haazee/kern.log", bufferSize, pattern);
	}

}
