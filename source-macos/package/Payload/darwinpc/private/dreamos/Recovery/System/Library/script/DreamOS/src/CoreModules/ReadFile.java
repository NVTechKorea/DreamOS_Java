package CoreModules;
import java.io.*;
import java.util.Scanner;

import CoreServices.PanicHandler;
public class ReadFile{
	public ReadFile(){}
	@SuppressWarnings("resource")
	public String initiate(String path){
		String data = null;
		String process = "Reading file: " + path;
		try{
			File dir = new File(path);
			if(dir.isDirectory()){
				System.out.println("READER [ERROR]: Requested path is not a file; is a directory.");
				data = " ";
			}else if(!dir.exists()){
				System.out.println("READER [ERROR]: Requested path does not exist.");
				System.out.println("READER [LOG]: Error while reading: " + path);
				data = " ";
			}else{
				BufferedReader breader = null;
				breader = new BufferedReader(new FileReader(path));
				data = breader.readLine();
			}
		}catch(Exception e){
			System.out.println("READER [ERROR]");
			PanicHandler ea = new PanicHandler();
			ea.initiate(e, process, false);
		}
		return data;
	}
	 public boolean checkConnection(String process) {
	    	System.out.println("READER [NOTIFY]: Process " + process + " is trying to access Read permission. Type yes to authorize, type n to reject.");
	    	Scanner input = new Scanner(System.in);
	    	String i = input.nextLine();
	    	input.close();
	    	if(i.equals("yes")) {
	    		return true;
	    	}else {
	    		return false;
	    	}
	    }
}