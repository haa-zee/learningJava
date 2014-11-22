import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.*;


public class LogReader_and_just_reader {

	private void runTest(){
		int n=0;
		long start, end;
		
		start=System.currentTimeMillis();
		System.out.println("cwd:"+System.getProperty("user.dir"));
		try {
			Path logFile=Paths.get("kern.log");
			BufferedReader br=Files.newBufferedReader(logFile, StandardCharsets.UTF_8);
			for(String s; (s=br.readLine())!=null; ){
				n++;
			}
		} catch(Exception e){
			System.out.println(e);
			
		}
		end=System.currentTimeMillis();
		System.out.println("Line count:"+n);
		System.out.println("Elapsed time:"+(end-start)+" ms");
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogReader_and_just_reader l=new LogReader_and_just_reader();
		l.runTest();
		
	}

}
