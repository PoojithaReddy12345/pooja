package GenericLibraries;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random; 
/**
 * This class contains reusable methods to perform  java related operations
 * @author 91889
 */

     public class JavaUtility 
     {
	/**
	 * This method fetches current date and time
	 * @return
	 */
      public String getCurrrentTime()
      {
	    Date date= new Date();
	    SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YY_hh_mm_ss");
	    return sdf.format(date);
      }
/*
 * This method is used to wait for specified amount of time
 * @param time
 */
      public void pause(long time)
      {
	     try 
	     {
		  Thread.sleep(time);
	     }
         catch(InterruptedException e)
     	{
	     e.printStackTrace();
     	}
	  }
/**
 * This method generates random number within the specified limit
 * @param limit
 * @return
 */
        public int generaterandomNum(int limit) 
        {
	    Random random=new Random();
	    return random.nextInt(limit);
        }
     }
