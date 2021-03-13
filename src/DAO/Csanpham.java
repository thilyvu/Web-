package DAO;

import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import MODEL.Sanpham;
import UTL.map;

public class Csanpham {
	@SuppressWarnings("unchecked")
	public static ArrayList<Sanpham> dssanpham ()
	{
		 Transaction transaction = null;
	         ArrayList<Sanpham> list = null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "FROM Sanpham";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    list = (ArrayList<Sanpham>)query.getResultList();
	          

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
	public static ArrayList<Sanpham> ds10sanpham (int vt)
	{
		 Transaction transaction = null;
	         ArrayList<Sanpham> list = null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "FROM Sanpham";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setFirstResult(vt*10);
	    	    query.setMaxResults(10);
	    	    list = (ArrayList<Sanpham>)query.getResultList();
	          

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
	public static int tongsp ()
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "Select count(sp.currentSlide) FROM Sanpham as sp ";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    Object list2 = query.getSingleResult();
	    	    
	    	    i=Integer.parseInt(list2.toString());
	            // commit transaction
	            transaction.commit();
	            
	            session.close();
	           
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return i;
	}
	
	public static int themsp (Sanpham sp)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	           i= (int) session.save(sp);
	            
	            transaction.commit();
	            
	            session.close();
	           
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return i;
	}
	public static int suasp (Sanpham sp)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	          session.update(sp);
	            
	            transaction.commit();
	            
	            session.close();
	           i=1;
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return i;
	}
	public static int xoasp (int id)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "delete from Sanpham as sp where sp.currentSlide= :id";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	   query.setParameter("id", id);
	    	   i=query.executeUpdate();
	            
	            transaction.commit();
	            
	            session.close();
	            
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return i;
	}

	public static Sanpham getspbyid (int id)
	{
		 Transaction transaction = null;
	         Sanpham x=null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "FROM Sanpham as sp where sp.currentSlide= :id";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("id", id);
	    	   
	    	    x=(Sanpham)query.getSingleResult();
	    	    
	            // commit transaction
	            transaction.commit();
	            
	            session.close();
	            
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return x;
	}
}
