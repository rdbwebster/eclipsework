package com.oracle.cache.demo;

import java.io.IOException;
import java.util.Date;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;

public class WatchListData implements PortableObject {

	public static int MERCHANT_WATCH = 1 ;
	public static int EMPLOYEE_WATCH = 2 ;	
	
	protected String watchName;
	protected int watchType ;
	protected Date watchTime ;
	protected int thisSentimentScore ;
	protected int incidentCount ;
	protected Date firstIncidentTime ;
	protected Date lastIncidentTime ;
	protected boolean onFraudWatch = false ;
	protected int creditScore = -1 ;
	protected int businessUnit ;
	
	public String getWatchName() {
		return watchName;
	}

	public void setWatchName(String watchName) {
		this.watchName = watchName;
	}

	public int getWatchType() {
		return watchType;
	}

	public void setWatchType(int watchType) {
		this.watchType = watchType;
	}

	public Date getWatchTime() {
		return watchTime;
	}

	public void setWatchTime(Date watchTime) {
		this.watchTime = watchTime;
	}

	public int getThisSentimentScore() {
		return thisSentimentScore;
	}

	public void setThisSentimentScore(int thisSentimentScore) {
		this.thisSentimentScore = thisSentimentScore;
	}

	public int getIncidentCount() {
		return incidentCount;
	}

	public void setIncidentCount(int incidentCount) {
		this.incidentCount = incidentCount;
	}

	public Date getFirstIncidentTime() {
		return firstIncidentTime;
	}

	public void setFirstIncidentTime(Date firstIncidentTime) {
		this.firstIncidentTime = firstIncidentTime;
	}

	public Date getLastIncidentTime() {
		return lastIncidentTime;
	}

	public void setLastIncidentTime(Date lastIncidentTime) {
		this.lastIncidentTime = lastIncidentTime;
	}

	public boolean isOnFraudWatch() {
		return onFraudWatch;
	}

	public void setOnFraudWatch(boolean onFraudWatch) {
		this.onFraudWatch = onFraudWatch;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	
	

	public int getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(int businessUnit) {
		this.businessUnit = businessUnit;
	}

	public void readExternal(PofReader in) throws IOException {
		watchName = in.readString(0);
		watchType = in.readInt(1);
		watchTime = in.readDate(2);
		thisSentimentScore = in.readInt(3);
		incidentCount = in.readInt(4);
		firstIncidentTime = in.readDate(5);
		lastIncidentTime = in.readDate(6);
		onFraudWatch = in.readBoolean(7);
		creditScore = in.readInt(8);
		businessUnit = in.readInt(9);
	}

	public void writeExternal(PofWriter out) throws IOException {
		out.writeString(0, watchName);
		out.writeInt(1, watchType);
		out.writeDate(2, watchTime);
		out.writeInt(3, thisSentimentScore);
		out.writeInt(4, incidentCount);
		out.writeDate(5, firstIncidentTime);
		out.writeDate(6, lastIncidentTime);
		out.writeBoolean(7, onFraudWatch);
		out.writeInt(8, creditScore);
		out.writeInt(9, businessUnit);
	}

	@Override
	public String toString() {
		return "WatchListData [watchName=" + watchName + ", watchType="
				+ watchType + ", watchTime=" + watchTime
				+ ", thisSentimentScore=" + thisSentimentScore
				+ ", incidentCount=" + incidentCount + ", firstIncidentTime="
				+ firstIncidentTime + ", lastIncidentTime=" + lastIncidentTime
				+ ", onFraudWatch=" + onFraudWatch + ", creditScore="
				+ creditScore + ", businessUnit=" + businessUnit + "]";
	}

	


	
}
