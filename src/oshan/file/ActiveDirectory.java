package oshan.file;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class ActiveDirectory {
	public static void main(String[] args) {

		// Set up environment for creating initial context
		Hashtable<String, String> env = new Hashtable<String, String>(11);
		env.put(Context.INITIAL_CONTEXT_FACTORY, 
		    "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://localhost:389/o=JNDITutorial");

		// Authenticate as S. User and password "mysecret"
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, "cn=oshan, ou=NewHires, o=JNDITutorial");
		env.put(Context.SECURITY_CREDENTIALS, "appleapple");

		try {
		    // Create initial context
		    DirContext ctx = new InitialDirContext(env);

		    System.out.println(ctx.lookup("ou=NewHires"));

		    // do something useful with ctx

		    // Close the context when we're done
		    ctx.close();
		} catch (NamingException e) {
		    e.printStackTrace();
		}
	    }
}
