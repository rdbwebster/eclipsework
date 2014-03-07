package com.oracle.cache.entry;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import com.tangosol.util.InvocableMap;
import com.tangosol.util.processor.AbstractProcessor;

import com.oracle.cache.demo.WatchListData;

public class WatchListDataUpdater extends AbstractProcessor implements Serializable, PortableObject {
	
    // ----- data members -------------------------------------------

	private static final long serialVersionUID = 1L;
	private WatchListData d ;
	
	// ----- constructors -------------------------------------------

    public WatchListDataUpdater(){
    }

    public WatchListDataUpdater(WatchListData d){
    	
    	this.d = d ; 
    	//TODO: comment this out when done testing
    	System.out.println("Incoming WatchListData: " + d.toString());
    }

    // ----- InvocableMap.EntryProcessor interface ------------------
    
    public Object process(InvocableMap.Entry entry) {
    	   	    	
    	boolean addEntry = true ;
    	if (entry.isPresent()) {    		
    		addEntry = processExistingEntry((WatchListData) entry.getValue());    	
    	} else {
    		addEntry = processNoPreviousEntry();
	
    	}
    	if (addEntry){
			entry.setValue(d);
		}
    	return d ;
    	
    }
	
    	
    public boolean processExistingEntry(WatchListData prev) {
		
    	boolean addEntry = true ;
    	//TODO: comment out when done testing
    	System.out.println("Entry is Present! " + prev.toString());
		if (prev != null){
			
			d.setIncidentCount(prev.getIncidentCount() + 1) ;
			if (d.getIncidentCount() == 1){
				d.setFirstIncidentTime(Calendar.getInstance().getTime());
			} else {
				d.setFirstIncidentTime(prev.getFirstIncidentTime());				
			}
			d.setLastIncidentTime(Calendar.getInstance().getTime());
			d.setThisSentimentScore(d.getThisSentimentScore());
			d.setWatchName(prev.getWatchName());
			d.setWatchTime(prev.getWatchTime());
			d.setWatchType(prev.getWatchType());
			d.setCreditScore(prev.getCreditScore());
			d.setOnFraudWatch(prev.isOnFraudWatch());
			d.setBusinessUnit(prev.getBusinessUnit());
					
		} 
		return addEntry ;
    }
    
    public boolean processNoPreviousEntry() {
    	
    	boolean addEntry = true ;
    	//TODO: comment out when done testing
    	System.out.println("CACHE: No Entry: " + d.getWatchName());
		
    	
    	// A cool idea would be to add people with bad sentiment scores 
    	// even if they weren't on the watchlist.
    	// Need to check "OnFraudWatch" in the downstream CQL queries.
    	
    	d.setIncidentCount(1) ;
    	d.setFirstIncidentTime(Calendar.getInstance().getTime());
		d.setLastIncidentTime(Calendar.getInstance().getTime());
		d.setThisSentimentScore(d.getThisSentimentScore());
		d.setWatchName(d.getWatchName());
		d.setWatchTime(d.getWatchTime());
		d.setWatchType(d.getWatchType());
		d.setCreditScore(-1);
		d.setOnFraudWatch(false);
		d.setBusinessUnit(d.getBusinessUnit());
		
		
    	return addEntry ;
    	
    }
    
    
	public void readExternal(PofReader in) throws IOException {
		this.d = (WatchListData) in.readObject(0);
	}

	public void writeExternal(PofWriter out) throws IOException {
		out.writeObject(0, this.d);
	}
	


  
}
