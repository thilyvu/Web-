package DAO;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import UTL.map;

public class Cthongke {
	@SuppressWarnings("unchecked")
	public static ArrayList<Object[]> Loaisanpham ()
	{
		 Transaction transaction = null;
	         ArrayList<Object[]> list = null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an Donhang object
	            
	            String hql = "CALL loaisanpham()";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createNativeQuery(hql);
	    	    //query.setMaxResults(10);
	    	    list = (ArrayList<Object[]>)query.getResultList();
	          

	            // commit transaction
	            transaction.commit();
	            
	            session.close();
	             
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return list;
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<Object[]> Thongke10ngay ()
	{
		 Transaction transaction = null;
	         ArrayList<Object[]> list = null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an Donhang object
	            
	            String hql = "CALL thongke10ngay()";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createNativeQuery(hql);
	    	    //query.setMaxResults(10);
	    	    list = (ArrayList<Object[]>)query.getResultList();
	          

	            // commit transaction
	            transaction.commit();
	            
	            session.close();
	             
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return list;
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<Object[]> top5sanpham ()
	{
		 Transaction transaction = null;
	         ArrayList<Object[]> list = null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an Donhang object
	            
	            String hql = "CALL top5sanpham()";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createNativeQuery(hql);
	    	    //query.setMaxResults(10);
	    	    list = (ArrayList<Object[]>)query.getResultList();
	          

	            // commit transaction
	            transaction.commit();
	            
	            session.close();
	             
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return list;
	}
}
