package oshan.mstsc;
import java.io.IOException;

/*
 * @author Oshan
 * */

public class MSTSC extends CRI{
	
	public static void run(){
		
		try {
			Process p = Runtime.getRuntime().exec("cmdkey /generic:"+IP+" /user:"+UN+" /pass:"+PW );
			p.destroy();
			System.out.println("PHASE 1");

			Runtime.getRuntime().exec("mstsc /v: "+IP+" /f /console");
			System.out.println("PHASE 2");

			Thread.sleep(10000);
			
			// deleting credentials
			Process p1 = Runtime.getRuntime().exec("cmdkey /delete:"+IP);
			p1.destroy();
			System.out.println("PHASE 3");
		} catch (IOException e) {
			System.out.println("IO : " + e.getMessage());
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("IE : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
