
package com.topgear.qa.commons;

import java.io.FileWriter;


public class flatfile {

	public static void flat(String txt)  {
		
		try{
			FileWriter outp= new FileWriter(System.getProperty("user.dir")+"//Output.txt");
		
		outp.write(txt);
		   outp.close();    
    }
 catch(Exception e){System.out.println(e);}    
    System.out.println("Success...");    
}
	
}