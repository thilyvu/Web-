package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import MODEL.Xacthucuser;
import UTL.map;

public class Cxacthucuser {
	public static Xacthucuser Getxacthucbyid (int id)
	{
		 Transaction transaction = null;
		 Xacthucuser x=null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "FROM Xacthucuser as sp where id=:idx ";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("idx", id);
	    	    x=(Xacthucuser)query.getSingleResult();
	    	    
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
	public static int themxacthuc (Xacthucuser xt)
	{
		 Transaction transaction = null;
		 		int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            i=(int)session.save(xt);
	    	    
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
	public static int xoaxacthuc (Xacthucuser xt)
	{
		 Transaction transaction = null;
		 		int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	           session.delete(xt);
	    	    
	            // commit transaction
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
	public static int suaxacthuc (Xacthucuser xt)
	{
		 Transaction transaction = null;
		 		int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	           session.update(xt);
	    	    
	            // commit transaction
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
}
