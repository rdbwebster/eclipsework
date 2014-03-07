package com.oracle.cache.store;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class LloydTest {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		String host = "localhost";
		String ip = "1521";
		String username = "shopping";
		String password = "shopping";
		String sid = "demo";
		String url="jdbc:oracle:thin:@"+host+":"+ip+":"+sid;
		
		
		try {
			CustomerDataCacheLoader loader = new CustomerDataCacheLoader(url, username, password);
			String myKey = "C1000" ;
			loader.load(myKey);
			
			
			Collection c = new ArrayList();
            c.add("C1001");
            c.add("C1002");
            c.add("C1003");
            c.add("C1004");
			
			loader.loadAll(c);
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
