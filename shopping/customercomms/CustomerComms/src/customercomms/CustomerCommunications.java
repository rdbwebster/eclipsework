package customercomms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.jws.*;


/*
 * The Customer Communications Service returns a customer's
 * registered preferences related to marketing communications from our company.
 * @author Bob Webster
 * @version 1.0, Feb 2014
 * 
 * http://10.0.2.15:8001/CustomerComms/CustomerCommunicationsService?Tester
 * http://10.0.2.15:8001/CustomerComms/CustomerCommunicationsService?WSDL
 */

@WebService
public class CustomerCommunications {

  HashMap<String, CustomerPreferences> preferences;

  public CustomerCommunications() {
    super();
    initialize();
  }

  /*
  * Initializes test data 
  */
  private void initialize() {
    preferences = new HashMap<String, CustomerPreferences>();
    preferences.put("1",    new CustomerPreferences("1", "Y", "N", "Y", "Y", "Y", "Y" ,"Y", "Y","Y"));
    preferences.put("2",    new CustomerPreferences("2", "Y", "Y", "Y", "Y", "Y", "Y" ,"Y", "Y","Y"));
    preferences.put("3",    new CustomerPreferences("3", "Y", "Y", "N", "Y", "N", "Y" ,"N", "Y","Y"));
    preferences.put("4",    new CustomerPreferences("4", "Y", "Y", "Y", "Y", "Y", "Y" ,"Y", "NY","Y"));
    preferences.put("5",    new CustomerPreferences("5", "Y", "N", "Y", "Y", "N", "Y" ,"Y", "Y","Y"));
    preferences.put("123",  new CustomerPreferences("123", "Y", "Y", "Y", "Y", "Y", "N" ,"Y", "Y","Y"));
    preferences.put("1234", new CustomerPreferences("1234", "Y", "Y", "Y", "Y", "Y", "Y" ,"Y", "Y","Y"));
   
  }

  /*
  * Returns  the communications preference for the specified customer
  * @param   customerId   the customer number
  * @return  a CustomerPreferences object containing the customer's communication preferences
  */

    @WebMethod
    @WebResult(name="CustomerCommPreferences")
    public CustomerPreferences getCustomerPreferences(@WebParam(name="customerId") String customerId) throws CustomerCommunicationsFault {

    if(customerId == null || customerId.length() == 0)
    {
      FaultBean fb = new FaultBean();
      fb.setMessage("customerId cannot be null");
      throw new CustomerCommunicationsFault("Customer number cannot null", fb);
    }


    // Return customer preference or null object
    
    CustomerPreferences result = preferences.get(customerId);

    return result;
  }


    

    /*
    * Returns  a list of known customer numbers
    * @return  a string list containing known customer numbers
    */
    @WebMethod
    @WebResult(name="CustomerIdList")
    public List<String>  getCustomers()  {

       Set<String> keys = preferences.keySet();
       ArrayList<String> keyList = new ArrayList<String>();
       keyList.addAll(keys);
       return keyList;

    }


    /*
    * A main() method that can be used for simple unit testing.
    * The test can be run from the command line.
    * It can also be run from within JDeveloper
    * by right clicking on the DepartmentFinder.java node in the Application Navigator
    * and choosing Run.
    * The test output will appear in the JDeveloper log window
    */

    
    public static void main(String args[]) {

    	CustomerCommunications cf = new CustomerCommunications();

      try {

        // Positive Test
        System.out.println("Finding known customer 2");
        System.out.println(cf.getCustomerPreferences("2"));
        System.out.println("Test Passed" + "\n");


        // Negative Test
        System.out.println("Finding unknown customer 88");
        CustomerPreferences prefs = cf.getCustomerPreferences("88");
        if(prefs == null)
        {
            System.out.println("Test Passed" + "\n");
        }
          else System.out.println("Test Failed, returned department for nonexistent department number" + "\n");


      }
      catch (CustomerCommunicationsFault f1){
            System.out.println("Caught Exception: "  + f1.getDescription());
            System.out.println("Test Passed" + "\n");
          }


      try {
          // Negative Test
          System.out.println("Finding with null customerId");
          System.out.println(cf.getCustomerPreferences(null));
          System.out.println("Test Failed" + "\n");
      }

      catch (CustomerCommunicationsFault f2){
            System.out.println("Caught Exception: " + f2.getDescription());
            System.out.println("Test Passed" + "\n");
          }


    }
}