package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import MODEL.Xacthucdonhang;
import UTL.map;

public class Cxacthucdonhang {
	public static Xacthucdonhang Getxacthuc (String id_user,int iddh)
	{
		 Transaction transaction = null;
		 Xacthucdonhang x=null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "FROM Xacthucdonhang as sp where sp.id_user= :id and sp.id_donhang=:iddh ";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("id", id_user);
	    	    query.setParameter("iddh", iddh);
	    	    x=(Xacthucdonhang)query.getSingleResult();
	    	    
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
	public static Xacthucdonhang Getxacthucbyid (int id)
	{
		 Transaction transaction = null;
		 Xacthucdonhang x=null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "FROM Xacthucdonhang as sp where id=:idx ";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("idx", id);
	    	    x=(Xacthucdonhang)query.getSingleResult();
	    	    
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
	public static int themxacthuc (Xacthucdonhang xt)
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
	public static int xoaxacthuc (Xacthucdonhang xt)
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
	public static int suaxacthuc (Xacthucdonhang xt)
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
