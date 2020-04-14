package com.capg.myapp;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {

	private static EntityManagerFactory emf =
	          Persistence.createEntityManagerFactory("pu");

	public static void main(String[] args) {
		     try {
	    	
	    	doRemove();
	    	
	    	
	      } finally {
	    	  emf.close();
	      }
	  }

	  private static void doSave() {
		  //to create the entitymanager we need to create the entitymanagerfactory		  
	      System.out.println("1 "+emf);
	      EntityManager em = emf.createEntityManager();
	      System.out.println("2 "+em);
	      DaignosticCenter dc = new DaignosticCenter("sharda","corona");
	    //  dc.setId(1003);
	      System.out.println(" 3 "+dc);
	    // we need to use transaction to save the data in db for that begin and commit method should be used  
	      em.getTransaction().begin();
	      System.out.println(" 4 Transaction started ");
	      em.persist(dc );
	      System.out.println("inside transaction");
	      System.out.println(" 5 Persist called ");
	      em.getTransaction().commit();
	      System.out.println(" 6 commit ");
	      em.close();
	      System.out.println("closed ");
	  }
	  
	  private static void doGet()
	  { System.out.println("1 "+emf);
      EntityManager em1 = emf.createEntityManager();	
      System.out.println("2 "+em1);
      // to get the values we should the find method with (classname.class,primarykey)
      DaignosticCenter dc1=em1.find(DaignosticCenter.class, 1001);
      System.out.println(dc1);
      em1.close();
 
	  }
	  
	  private static void doUpdate()
	  { System.out.println("1 "+emf);
      EntityManager em2 = emf.createEntityManager();	
      System.out.println("2 "+em2);
      Scanner sc=new Scanner(System.in);
      System.out.println("what you want to update enter the primary key and column name");
      String pk=sc.nextLine();
      int id=Integer.parseInt(pk);
      String col_name=sc.nextLine();
     
      DaignosticCenter dc2=em2.find(DaignosticCenter.class,id);
    
      em2.getTransaction().begin();
      
      System.out.println("transcation started");
      if(col_name.contentEquals("test"))
      {
    	  System.out.println("enter the test name");
    	  String t=sc.nextLine();
    	  dc2.setTest(t);
      }
      
      if(col_name.contentEquals("center"))
      {
    	  System.out.println("enter the center name");
    	  String center=sc.nextLine();
    	  dc2.setCenter(center);
      }
      
      em2.getTransaction().commit();
      System.out.println("  committed  ");
    
     
      // to get the values we should the find method with (classname.class,primarykey)
      System.out.println(dc2);
      
      em2.close();
 
	  }
	  
	  private static void doRemove()
	  { System.out.println("1 "+emf);
      EntityManager em3 = emf.createEntityManager();	
      System.out.println("2 "+em3);
      Scanner sc=new Scanner(System.in);
      System.out.println("what you want to update enter the primary key ");
      String pk=sc.nextLine();
      int id=Integer.parseInt(pk);
      DaignosticCenter dc3=em3.find(DaignosticCenter.class,id);
    
      em3.getTransaction().begin();
      
      System.out.println("transcation started");
      
      if(dc3.getId()==(id))
      { 
    	  em3.remove(dc3);
    	  
      }
      em3.getTransaction().commit();
      System.out.println("  committed  ");
    
     
      // to get the values we should the find method with (classname.class,primarykey)
      System.out.println(dc3);
      
      em3.close();
 
	  }
}
