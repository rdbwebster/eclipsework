package com.oracle.cache.demo;

import java.io.IOException;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

public class BusinessUnitData implements PortableObject  {

	protected int businessUnit ;
	protected int regionID ; 
	protected int industryID ;
	protected String unitName ;
	protected String ownerEmail ;
	
	public BusinessUnitData() {
		super();
	}

	

	public int getRegionID() {
		return regionID;
	}
	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}
	public int getIndustryID() {
		return industryID;
	}
	public void setIndustryID(int industryID) {
		this.industryID = industryID;
	}
	
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	
	public void readExternal(PofReader in) throws IOException {
		businessUnit = in.readInt(0);
		regionID = in.readInt(1);
		industryID = in.readInt(2);	
		unitName = in.readString(3);
		ownerEmail = in.readString(4);
		
	}

	public void writeExternal(PofWriter out) throws IOException {
		out.writeInt(0, businessUnit);
		out.writeInt(1, regionID);
		out.writeInt(2, industryID);
		out.writeString(3, unitName);
		out.writeString(4, ownerEmail);
	}



	public int getBusinessUnit() {
		return businessUnit;
	}



	public void setBusinessUnit(int businessUnit) {
		this.businessUnit = businessUnit;
	}



	public String getOwnerEmail() {
		return ownerEmail;
	}



	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}



	@Override
	public String toString() {
		return "BusinessUnitData [businessUnit=" + businessUnit + ", regionID="
				+ regionID + ", industryID=" + industryID + ", unitName="
				+ unitName + ", ownerEmail=" + ownerEmail + "]";
	}
	
	
	
}
