package com.oracle.cache.demo;

import java.io.IOException;
import java.util.Date;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

public class ProspectData implements PortableObject  {

	public int prospectID ;
	public String businessName ;
	public String businessOwnerFirst ;
	public String businessOwnerLast ;
	public int industryID ;
	public double latitude ;
	public double longitude ;
	public String ownerEmail ;
	public Date lastEmailSentDate ;
	
	public ProspectData() {
		super();
	}

	
	public void readExternal(PofReader in) throws IOException {
		prospectID = in.readInt(0);
		businessName = in.readString(1);
		businessOwnerFirst = in.readString(2);
		businessOwnerLast = in.readString(3);;
		industryID = in.readInt(4);	
		latitude = in.readDouble(5);
		longitude = in.readDouble(6);
		ownerEmail = in.readString(7);
		lastEmailSentDate = in.readDate(8);
		
	}

	public void writeExternal(PofWriter out) throws IOException {
		out.writeInt(0, prospectID);
		out.writeString(1, businessName);
		out.writeString(2, businessOwnerFirst);
		out.writeString(3, businessOwnerLast);	
		out.writeInt(4, industryID);
		out.writeDouble(5, latitude);
		out.writeDouble(6, longitude);
		out.writeString(7, ownerEmail);
		out.writeDate(8, lastEmailSentDate);
	}


	public int getProspectID() {
		return prospectID;
	}


	public void setProspectID(int prospectID) {
		this.prospectID = prospectID;
	}


	public String getBusinessName() {
		return businessName;
	}


	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}


	public String getBusinessOwnerFirst() {
		return businessOwnerFirst;
	}


	public void setBusinessOwnerFirst(String businessOwnerFirst) {
		this.businessOwnerFirst = businessOwnerFirst;
	}


	public String getBusinessOwnerLast() {
		return businessOwnerLast;
	}


	public void setBusinessOwnerLast(String businessOwnerLast) {
		this.businessOwnerLast = businessOwnerLast;
	}


	public int getIndustryID() {
		return industryID;
	}


	public void setIndustryID(int industryID) {
		this.industryID = industryID;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public String getOwnerEmail() {
		return ownerEmail;
	}


	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public Date getLastEmailSentDate() {
		return lastEmailSentDate;
	}


	public void setLastEmailSentDate(Date lastEmailSentDate) {
		this.lastEmailSentDate = lastEmailSentDate;
	}


	@Override
	public String toString() {
		return "ProspectData [prospectID=" + prospectID + ", businessName="
				+ businessName + ", businessOwnerFirst=" + businessOwnerFirst
				+ ", businessOwnerLast=" + businessOwnerLast + ", industryID="
				+ industryID + ", latitude=" + latitude + ", longitude="
				+ longitude + ", ownerEmail=" + ownerEmail
				+ ", lastEmailSentDate=" + lastEmailSentDate + "]";
	}
	
	
	
	
}
