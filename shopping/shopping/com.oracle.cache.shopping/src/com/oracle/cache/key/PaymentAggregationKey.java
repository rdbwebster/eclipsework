package com.oracle.cache.key;

import java.io.IOException;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

public class PaymentAggregationKey implements PortableObject {

	protected Integer industryID ;
	protected Integer regionID ;
	
	public PaymentAggregationKey() {
		super();
	}
	public PaymentAggregationKey(Integer industryID, Integer regionID) {
		super();
		this.industryID = industryID;
		this.regionID = regionID;
	}
	public Integer getIndustryID() {
		return industryID;
	}
	public void setIndustryID(Integer industryID) {
		this.industryID = industryID;
	}
	public Integer getRegionID() {
		return regionID;
	}
	public void setRegionID(Integer regionID) {
		this.regionID = regionID;
	}

	public void readExternal(PofReader in) throws IOException {
		regionID = in.readInt(0);
		industryID = in.readInt(1);	
	}

	public void writeExternal(PofWriter out) throws IOException {		
		out.writeInt(0, regionID);
		out.writeInt(1, industryID);
	}
	
	@Override
	public String toString() {
		return "PaymentAggregationKey [industryID=" + industryID
				+ ", regionID=" + regionID + "]";
	}
	
	
	
	
}
