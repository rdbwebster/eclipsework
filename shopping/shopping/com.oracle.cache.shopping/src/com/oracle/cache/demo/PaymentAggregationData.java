package com.oracle.cache.demo;

import java.io.IOException;
import java.math.BigDecimal;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

public class PaymentAggregationData implements PortableObject  {

	protected Integer industryID ;
	protected Integer regionID ;
	protected BigDecimal amount ;
	
	public PaymentAggregationData() {
		super();
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "PaymentAggregationData [industryID=" + industryID
				+ ", regionID=" + regionID + ", amount=" + amount + "]";
	}
	
	public void readExternal(PofReader in) throws IOException {
		regionID = in.readInt(0);
		industryID = in.readInt(1);	
	    amount = in.readBigDecimal(2);
		
	}

	public void writeExternal(PofWriter out) throws IOException {		
		out.writeInt(0, regionID);
		out.writeInt(1, industryID);
		out.writeBigDecimal(2, amount);
	}
	
	
}
