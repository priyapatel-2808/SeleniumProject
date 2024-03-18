package utils;

import java.io.IOException;

public class GetUserDetailsUtility {
	private static String dataPath = "C:\\Users\\Priya\\eclipse-workspace\\SeleniumFramework2\\src\\main\\resources\\testdata\\loginData.properties";
	
	
	public static String getUserName(String userID) {
		try {
			String userName=PropertyReadWrite.readProperty(dataPath,userID);		
			return userName;
		}catch(IOException io) {
			return "";
		}
		
		
	}
     public static String getPassword(String passwordID) {
    	 try {
    		 String password = PropertyReadWrite.readProperty(dataPath, passwordID);
        	 return password;
    	 }catch (IOException io) {
    		 return "";
		}
    	 
	}

}
