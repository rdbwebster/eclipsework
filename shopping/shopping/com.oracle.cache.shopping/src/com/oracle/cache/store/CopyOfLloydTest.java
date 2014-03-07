package com.oracle.cache.store;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class CopyOfLloydTest {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		String host = "localhost";
		String ip = "1521";
		String username = "bpmidc";
		String password = "bpmidc";
		String sid = "XE";
		String url="jdbc:oracle:thin:@"+host+":"+ip+":"+sid;
		
		
		try {
			ProspectDataCacheLoader loader = new ProspectDataCacheLoader(url, username, password);
			int myKey = 10000 ;
			loader.load(myKey);
			
			Collection c = new ArrayList();
            c.add(10000);
            c.add(10001);
            c.add(10002);
            c.add(10003);
			
			loader.loadAll(c);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
