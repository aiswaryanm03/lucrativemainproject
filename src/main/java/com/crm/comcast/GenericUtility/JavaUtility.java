package com.crm.comcast.GenericUtility;
/**
 * in this class will use methods coming from java
 * @author Aishwarya
 *
 */
import java.util.Random;

/**
 * it is used to generate Random Number
 */


public class JavaUtility {
	public int CreateRandomNumber()
	{
		Random random=new Random();
		int Randomnum =random.nextInt(10000);
		return Randomnum;
	}
	

	

}

		