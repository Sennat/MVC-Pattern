/* ************************************************************************************
 * Copyright (C) Nov 24, 2017, Natnael Alemayehu, All rights Reserved. Unauthorized 
 * copying of this file and/or distributed without, the express permission of 
 * Natnael Alemayehu is strictly prohibited. Written by Natnael Alemayehu 2:05:38 AM.
 * ************************************************************************************
 */

package mvc;

/**
 * A Model class implements Payment class to demonstrate MVC Design Pattern 
 * A model class carrying data for the application
 * @author Natnael Alemayehu
 *
 */
public class Model implements Payment {

	private String studentId;
	private int numberOfcoursses;
	private boolean resident;

	/**
	 * A constructor
	 * @param studentName
	 * @param numberOfcoursses
	 * @param resident
	 */
	public Model(String studentName, int numberOfcoursses, boolean resident) {
		studentName = setStudentId(studentName);
		this.numberOfcoursses = numberOfcoursses;
		this.resident = resident;
	}

	/**
	 * A method format a name the first letter to uppercase
	 * @param studentId the studentName to set
	 */
	public String setStudentId(String studentId) {
		studentId = studentId.toUpperCase();
		studentId = studentId.substring(0, 1).toUpperCase() + studentId.substring(1);
		return studentId;
	}

	/**
	 * Set a number of courses greater than 0 to prevent users enter a negative number
	 * @param numberOfcoursses the numberOfcoursses to set
	 */
	public int setNumberOfcoursses(int numberOfcoursses) {
		if(numberOfcoursses < 0)
			numberOfcoursses = 0;
		return numberOfcoursses;
	}

	/**
	 * A method to calculate the tuition fee based on student status
	 */
	@Override
	public int calculateFees() {
		final int RESIDENT_FEE = 957;
		final int OVERSEAS_FEE = 1230;

		if(resident) {
			return RESIDENT_FEE * numberOfcoursses;

		}else {
			return OVERSEAS_FEE  * numberOfcoursses;

		}

	}
}
