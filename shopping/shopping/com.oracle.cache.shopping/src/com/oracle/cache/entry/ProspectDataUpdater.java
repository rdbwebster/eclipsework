package com.oracle.cache.entry;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import com.tangosol.util.InvocableMap;
import com.tangosol.util.processor.AbstractProcessor;

import com.oracle.cache.demo.ProspectData;

public class ProspectDataUpdater extends AbstractProcessor implements Serializable, PortableObject {
	
    // ----- data members -------------------------------------------

	private static final long serialVersionUID = 1L;
	private ProspectData d ;
	
	// ----- constructors -------------------------------------------

    public ProspectDataUpdater(){
    }

    public ProspectDataUpdater(ProspectData d){
    	
    	this.d = d ; 
    	//TODO: comment this out when done testing
    	System.out.println("Incoming ProspectData: " + d.toString());
    }

    // ----- InvocableMap.EntryProcessor interface ------------------
    
    public Object process(InvocableMap.Entry entry) {
    	   	    	
    	Long days = null ;
    	if (entry.isPresent()) {    		
    		days = processExistingEntry((ProspectData) entry.getValue());    	
    	} else {
    		processNoPreviousEntry();
    		days = null ;
	
    	}
    			
    	return days ;
    	
    }
	
    	
    public Long processExistingEntry(ProspectData prev) {
		
    	Long days = null ;
    	//TODO: comment out when done testing
    	System.out.println("Entry is Present! " + prev.toString());
		if (prev != null){
			
			Date lastEmailDate = prev.getLastEmailSentDate() ;
			if (lastEmailDate != null){
				Date secondDate = Calendar.getInstance().getTime() ;
				long diff = getDateDiff(lastEmailDate,secondDate,TimeUnit.DAYS);
				days = new Long(diff);
				System.out.println("The number of days since the last email is: " + days);
			}
					
		} 
		return days ;
    }
    
    public void processNoPreviousEntry() {
    	
    	//TODO: comment out when done testing
    	System.out.println("CACHE: No Entry: " + d.getProspectID());
    	
    	d.setLastEmailSentDate(Calendar.getInstance().getTime());
    	
    }
    
    
	public void readExternal(PofReader in) throws IOException {
		this.d = (ProspectData) in.readObject(0);
	}

	public void writeExternal(PofWriter out) throws IOException {
		out.writeObject(0, this.d);
	}
	
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}

  
}
