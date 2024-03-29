package com.oracle.cache.store;

//import java.math.BigDecimal;
//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.oracle.cache.demo.ProspectData;

//import oracle.jdbc.internal.OracleTypes;

public class ProspectDataCacheLoader extends AbstractOracleStore {

	private static final String COL_ID   = "ID" ;
	private static final String COL_BUSINESS_NAME = "BUSINESS_NAME" ;
	private static final String COL_BUSINESS_OWNER_FIRST = "BUSINESS_OWNER_FIRST" ;
	private static final String COL_BUSINESS_OWNER_LAST = "BUSINESS_OWNER_LAST" ;	
	private static final String COL_OWNER_EMAIL  = "OWNER_EMAIL" ;
	private static final String COL_INDUSTRY_ID = "INDUSTRY_ID" ;
	private static final String COL_LATITUDE = "LATITUDE" ;
	private static final String COL_LONGITUDE = "LONGITUDE" ;
	
	private static final String VIEW_NAME = "PROSPECTS" ;

	private static final String SQL_SELECT = "SELECT " 
	+ "b." + COL_ID + ","
	+ "b." + COL_BUSINESS_NAME + ","
	+ "b." + COL_BUSINESS_OWNER_FIRST + ","	
	+ "b." + COL_BUSINESS_OWNER_LAST + ","	
	+ "b." + COL_OWNER_EMAIL + ","
	+ "b." + COL_INDUSTRY_ID + "," 
	+ "b." + COL_LATITUDE + "," 
	+ "b." + COL_LONGITUDE 
	+
	" FROM " +
	VIEW_NAME + " b " ;
   //SELECT b.* FROM prospects b WHERE ID IN (10000,10001,10002);
	
	private static final String SQL_FETCH_ALL = SQL_SELECT ;
	private static final String SQL_FETCH_SOME = SQL_FETCH_ALL + "WHERE ID IN (%s)" ;
	
	    public ProspectDataCacheLoader(String sUrl, String sUsername, String sPassword) throws SQLException
		{
	    	super(sUrl, sUsername, sPassword);
		}

	    // ----- CacheLoader interface -------------------------------------------

	    @SuppressWarnings({ "unchecked", "rawtypes" })
	    public Object load(Object oKey)
	    {
	    	Collection collection = new ArrayList(1);
	    	collection.add(oKey);
	    	Map map = this.loadAll(collection);
	    	Set entries = map.entrySet();
	    	Iterator iter = entries.iterator();
	    	while (iter.hasNext())
	    	{
	    		return ((Entry)iter.next()).getValue();
	    	}
	    	
	    	return null;
	    }
	    
		/**
		* {@inheritDoc}
		*/
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Map loadAll(Collection colKeys)
		{
			//Map mapResults = new HashMap(colKeys.size());
			//FIX TO FETCH ONLY ROWS FROM THE KEYS
			Map mapResults = new HashMap();
			Connection connection = null;
			//Statement statement = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
		
			Set<Integer> ids = new HashSet<Integer>() ;
			
			Iterator itr = colKeys.iterator();

			while (itr.hasNext()) {
				
				Object element = itr.next();
				Integer key ;
				if (element instanceof Integer){
					key = (Integer)element;
					ids.add(key.intValue());
				} else {
					ids.add((Integer) itr.next());
				}
				
				
				
				
			}
			
			
			try
		    {
				connection = getConnection();			
				String sql = String.format(SQL_FETCH_SOME, preparePlaceHolders(ids.size()));
				System.out.println(sql);
				
				ps = connection.prepareStatement(sql);
				setValues(ps, ids.toArray());
				rs = ps.executeQuery();

				while(rs.next()) {
					
					int prospectID = rs.getInt(COL_ID);				
					String businessName = rs.getString(COL_BUSINESS_NAME);
					String businessOwnerFirst = rs.getString(COL_BUSINESS_OWNER_FIRST);
					String businessOwnerLast = rs.getString(COL_BUSINESS_OWNER_LAST);
					int industryID = rs.getInt(COL_INDUSTRY_ID);
					double latitude = rs.getDouble(COL_LATITUDE);
					double longitude = rs.getDouble(COL_LONGITUDE);
					String ownerEmail = rs.getString(COL_OWNER_EMAIL);

					// set values on the new event
					ProspectData event = new ProspectData();
					event.setProspectID(prospectID);
					event.setBusinessName(businessName);
					event.setBusinessOwnerFirst(businessOwnerFirst);
					event.setBusinessOwnerLast(businessOwnerLast);
					event.setIndustryID(industryID);
					event.setLatitude(latitude);
					event.setLongitude(longitude);
					event.setOwnerEmail(ownerEmail);
		
					mapResults.put( prospectID, event );
					//System.out.println("RESULT: " + event.toString());
		    	}
				
				return mapResults;
		    }
			catch (SQLException e)
			{
				log(e);
				throw new RuntimeException(e);
			}
			finally
			{
				if (ps != null)
				{
					try { ps.close(); } catch (SQLException e) {}
				}
				if (connection != null)
				{
					try { connection.close(); } catch (SQLException e) {}
				}
			}
		}
		
		
		public static String preparePlaceHolders(int length) {
		    StringBuilder builder = new StringBuilder(length * 2 - 1);
		    for (int i = 0; i < length; i++) {
		        if (i > 0) builder.append(',');
		        builder.append('?');
		    }
		    return builder.toString();
		}

		public static void setValues(PreparedStatement preparedStatement, Object... values) throws SQLException {
		    for (int i = 0; i < values.length; i++) {
		        preparedStatement.setObject(i + 1, values[i]);
		    }
		}

	}
