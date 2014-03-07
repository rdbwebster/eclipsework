package customercomms;

/*
 * The DepartmentDetails class represents the details of a department within an organization
 * @author Bob Webster
 * @version 1.0, April 2010
 */
  public class CustomerPreferences {

	String customerId;
	
    String acceptMarketingEmail;
    String acceptMarketingSMS;
    String acceptMarketingMail;
    
    String acceptNewsEmail;
    String acceptNewsSMS;
    String acceptNewsMail;
    
    String acceptSalesEmail;
    String acceptSalesSMS;
    String acceptSalesMail;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getAcceptMarketingEmail() {
		return acceptMarketingEmail;
	}
	public void setAcceptMarketingEmail(String acceptMarketingEmail) {
		this.acceptMarketingEmail = acceptMarketingEmail;
	}
	public String getAcceptMarketingSMS() {
		return acceptMarketingSMS;
	}
	public void setAcceptMarketingSMS(String acceptMarketingSMS) {
		this.acceptMarketingSMS = acceptMarketingSMS;
	}
	public String getAcceptMarketingMail() {
		return acceptMarketingMail;
	}
	public void setAcceptMarketingMail(String acceptMarketingMail) {
		this.acceptMarketingMail = acceptMarketingMail;
	}
	public String getAcceptNewsEmail() {
		return acceptNewsEmail;
	}
	public void setAcceptNewsEmail(String acceptNewsEmail) {
		this.acceptNewsEmail = acceptNewsEmail;
	}
	public String getAcceptNewsSMS() {
		return acceptNewsSMS;
	}
	public void setAcceptNewsSMS(String acceptNewsSMS) {
		this.acceptNewsSMS = acceptNewsSMS;
	}
	public String getAcceptNewsMail() {
		return acceptNewsMail;
	}
	public void setAcceptNewsMail(String acceptNewsMail) {
		this.acceptNewsMail = acceptNewsMail;
	}
	public String getAcceptSalesEmail() {
		return acceptSalesEmail;
	}
	public void setAcceptSalesEmail(String acceptSalesEmail) {
		this.acceptSalesEmail = acceptSalesEmail;
	}
	public String getAcceptSalesSMS() {
		return acceptSalesSMS;
	}
	public void setAcceptSalesSMS(String acceptSalesSMS) {
		this.acceptSalesSMS = acceptSalesSMS;
	}
	public String getAcceptSalesMail() {
		return acceptSalesMail;
	}
	public void setAcceptSalesMail(String acceptSalesMail) {
		this.acceptSalesMail = acceptSalesMail;
	}
	@Override
	public String toString() {
		return "CustomerPreferences [customerId=" + customerId
				+ ", acceptMarketingEmail=" + acceptMarketingEmail
				+ ", acceptMarketingSMS=" + acceptMarketingSMS
				+ ", acceptMarketingMail=" + acceptMarketingMail
				+ ", acceptNewsEmail=" + acceptNewsEmail + ", acceptNewsSMS="
				+ acceptNewsSMS + ", acceptNewsMail=" + acceptNewsMail
				+ ", acceptSalesEmail=" + acceptSalesEmail
				+ ", acceptSalesSMS=" + acceptSalesSMS + ", acceptSalesMail="
				+ acceptSalesMail + "]";
	}
	public CustomerPreferences(String customerId, String acceptMarketingEmail,
			String acceptMarketingSMS, String acceptMarketingMail,
			String acceptNewsEmail, String acceptNewsSMS,
			String acceptNewsMail, String acceptSalesEmail,
			String acceptSalesSMS, String acceptSalesMail) {
		super();
		this.customerId = customerId;
		this.acceptMarketingEmail = acceptMarketingEmail;
		this.acceptMarketingSMS = acceptMarketingSMS;
		this.acceptMarketingMail = acceptMarketingMail;
		this.acceptNewsEmail = acceptNewsEmail;
		this.acceptNewsSMS = acceptNewsSMS;
		this.acceptNewsMail = acceptNewsMail;
		this.acceptSalesEmail = acceptSalesEmail;
		this.acceptSalesSMS = acceptSalesSMS;
		this.acceptSalesMail = acceptSalesMail;
	}
	public CustomerPreferences() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((acceptMarketingEmail == null) ? 0 : acceptMarketingEmail
						.hashCode());
		result = prime
				* result
				+ ((acceptMarketingMail == null) ? 0 : acceptMarketingMail
						.hashCode());
		result = prime
				* result
				+ ((acceptMarketingSMS == null) ? 0 : acceptMarketingSMS
						.hashCode());
		result = prime * result
				+ ((acceptNewsEmail == null) ? 0 : acceptNewsEmail.hashCode());
		result = prime * result
				+ ((acceptNewsMail == null) ? 0 : acceptNewsMail.hashCode());
		result = prime * result
				+ ((acceptNewsSMS == null) ? 0 : acceptNewsSMS.hashCode());
		result = prime
				* result
				+ ((acceptSalesEmail == null) ? 0 : acceptSalesEmail.hashCode());
		result = prime * result
				+ ((acceptSalesMail == null) ? 0 : acceptSalesMail.hashCode());
		result = prime * result
				+ ((acceptSalesSMS == null) ? 0 : acceptSalesSMS.hashCode());
		result = prime * result
				+ ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerPreferences other = (CustomerPreferences) obj;
		if (acceptMarketingEmail == null) {
			if (other.acceptMarketingEmail != null)
				return false;
		} else if (!acceptMarketingEmail.equals(other.acceptMarketingEmail))
			return false;
		if (acceptMarketingMail == null) {
			if (other.acceptMarketingMail != null)
				return false;
		} else if (!acceptMarketingMail.equals(other.acceptMarketingMail))
			return false;
		if (acceptMarketingSMS == null) {
			if (other.acceptMarketingSMS != null)
				return false;
		} else if (!acceptMarketingSMS.equals(other.acceptMarketingSMS))
			return false;
		if (acceptNewsEmail == null) {
			if (other.acceptNewsEmail != null)
				return false;
		} else if (!acceptNewsEmail.equals(other.acceptNewsEmail))
			return false;
		if (acceptNewsMail == null) {
			if (other.acceptNewsMail != null)
				return false;
		} else if (!acceptNewsMail.equals(other.acceptNewsMail))
			return false;
		if (acceptNewsSMS == null) {
			if (other.acceptNewsSMS != null)
				return false;
		} else if (!acceptNewsSMS.equals(other.acceptNewsSMS))
			return false;
		if (acceptSalesEmail == null) {
			if (other.acceptSalesEmail != null)
				return false;
		} else if (!acceptSalesEmail.equals(other.acceptSalesEmail))
			return false;
		if (acceptSalesMail == null) {
			if (other.acceptSalesMail != null)
				return false;
		} else if (!acceptSalesMail.equals(other.acceptSalesMail))
			return false;
		if (acceptSalesSMS == null) {
			if (other.acceptSalesSMS != null)
				return false;
		} else if (!acceptSalesSMS.equals(other.acceptSalesSMS))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}
    

    
  }