import java.util.Scanner; 
package com.InvalidMyException;

public class Student {

	 static int flag=0;
//	 int StudentID;
//	 String StudentName;
//	 int marks;
//	 
	    Scanner studentId = new Scanner(System.in);
	    System.out.println("Enter Student ID");

	    int StudentID = studentId.nextLine();  
	    System.out.println("Student ID is:" + StudentID); 
	    
	       
	    
	    Scanner studentName = new Scanner(System.in);
	    System.out.println("Enter Student Name");

	    String StudentName = studentName.nextLine();  
	    System.out.println("Student Name is:" + StudentName); 
	    
	    
	    Scanner marks = new Scanner(System.in);
	    System.out.println("Enter Marks");

	    int Marks = marks.nextLine();  
	    System.out.println("Marks is:" + Marks); 
	 
	 try {
			
			if(Marks > 100 || Marks < 0 )
				throw new MyException();
		}
		
		catch(NumberIsInvalidException e) {
			flag=1;
			System.out.println("Exception : "+ e);
		}
	    
	 finally {
		 studentId.close();
		}
			
}
