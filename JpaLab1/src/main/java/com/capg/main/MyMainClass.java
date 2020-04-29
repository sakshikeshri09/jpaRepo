package com.capg.main;

import java.math.BigInteger;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cap.Author;



public class MyMainClass {

	 static EntityManagerFactory emf= Persistence.createEntityManagerFactory("pu");
	
	public static void main(String[] args) {
		 
			try {	//Add();
			//doUpdate();
			//doRemove();
			doGet();
			}
			finally
			{
				emf.close();
			}
		
	

		
	}
	
	public static void fetch() {
		System.out.println("hii");
	}

	public static void Add()
	{
		EntityManager em1=emf.createEntityManager();
		BigInteger b=new BigInteger("9898700678");
		Author a =new Author("shivam","suman",b);
		System.out.println(" outside trasaction----");
		em1.getTransaction().begin();
		System.out.println(" started trasaction");
		System.out.println(a);
		em1.persist(a);
		System.out.println("hello");
		em1.getTransaction().commit();
		System.out.println(" commit trasaction");
		em1.close();
		
		
	}
	
	 public static void doUpdate()
	  { System.out.println("1 "+emf);
     EntityManager em2 = emf.createEntityManager();	
     System.out.println("2 "+em2);
     Scanner sc=new Scanner(System.in);
     System.out.println("what you want to update enter the primary key and column name");
     String pk=sc.nextLine();
     int i=Integer.parseInt(pk);
     String colname=sc.nextLine();
     
     Author a=em2.find(Author.class,i);
     
     em2.getTransaction().begin(); 
     System.out.println("transcation started");
     if(colname.contentEquals("lastName"))
     {
   	  System.out.println("enter the last name");
   	  String t=sc.nextLine();
   	  a.setLastName(t);
     }
     
     if(colname.contentEquals("firstName"))
     {
   	  System.out.println("enter the first name");
   	  String center=sc.nextLine();
   	  a.setFirstName(center);
     }
     
     em2.getTransaction().commit();
     System.out.println("  committed---  ");
   
    
     // to get the values we should the find method with (classname.class,primarykey)
     System.out.println(a);
     
     em2.close();

	  }
	  
	 public static void doRemove()
	  { System.out.println("1 "+emf);
     EntityManager em3 = emf.createEntityManager();	
     System.out.println("2 "+em3);
     Scanner sc=new Scanner(System.in);
     System.out.println("what you want to remove enter the primary key ");
     String pk=sc.nextLine();
     int id=Integer.parseInt(pk);
     Author dc3=em3.find(Author.class,id);
   
     em3.getTransaction().begin();
     
     System.out.println("transcation started");
     
     if(dc3.getAuthorId()==(id))
     { 
   	  em3.remove(dc3);
   	  
     }
     em3.getTransaction().commit();
     System.out.println("  committed  ");
   
    
     // to get the values we should the find method with (classname.class,primarykey)
     System.out.println(dc3);
     
     em3.close();

	  }
	
	 public static void doGet()
	  { System.out.println("1 "+emf);
     EntityManager em1 = emf.createEntityManager();	
     System.out.println("2 "+em1);
     
     System.out.println("Enter the Author id");
     // to get the values we should the find method with (classname.class,primarykey)
     Scanner sc=new Scanner(System.in);
    // System.out.println("Enter the Author id");
     String pk=sc.nextLine();
     int i=Integer.parseInt(pk);
     Author dc1=em1.find(Author.class,i);
     System.out.println(dc1);
     em1.close();

	  }
	
	
}


