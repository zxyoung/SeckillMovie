package com.zhang.movie.tmp;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class UtilsTest {
	
	public static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("zhang");
	public static PersistenceManager pm = pmf.getPersistenceManager();
	
	public static PersistenceManager getPersistenceManager(){
		return pm;
	}
	
	public static Transaction getTransaction(){
		return pm.currentTransaction();
	}
	
	public static void close(){
		pm.close();
		pmf.close();
	}
}
