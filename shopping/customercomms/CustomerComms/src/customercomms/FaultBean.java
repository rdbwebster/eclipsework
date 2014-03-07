package customercomms;

import java.io.Serializable;

/*
 * This bean contains the web service fault detail
 */
public class FaultBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8401827847032685439L;
	
	private String message;

    public FaultBean() { }

    public String getMessage() {
          return message;
    }

    public void setMessage(String message) {
          this.message = message;
    }
}