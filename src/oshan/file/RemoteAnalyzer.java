package oshan.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoteAnalyzer {
	final static String FIND = "cmd.exe /C netstat -n | find \":3389\" | find \"ESTABLISHED\"";
	
	public static void main(String[] args) {
		try {
			String line = null;
			Process host = Runtime.getRuntime().exec(FIND);
			BufferedReader in = new BufferedReader(new InputStreamReader(host.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(host.getErrorStream()));
			
			System.out.println("POSSIBLE CONNECTIONS:\n");
            while ((line = in.readLine()) != null) {
            	System.out.println(line);
            }
            
            //System.out.println("Here is the standard error of the command (if any):\n");
            while ((line = stdError.readLine()) != null) {
                System.out.println(line);
            }

            //int returnCode = host.waitFor();
            //System.out.println("Catalina return code = " + returnCode);
            host.destroy();
            in.close();
            stdError.close();
            System.out.println("\nEND OF FIND METHOD");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
