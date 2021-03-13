package DAO;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import MODEL.User;
import UTL.map;

public class Cuser {
	@SuppressWarnings("unchecked")
	public static ArrayList<User> ds10User (int vt)
	{
		 Transaction transaction = null;
	         ArrayList<User> list = null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "FROM User";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setFirstResult(vt*10);
	    	    query.setMaxResults(10);
	    	    list = (ArrayList<User>)query.getResultList();
	          

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
	            
	            String hql = "Select count(sp.id_user) FROM User as sp ";
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
	public static User getUserbyid (String id,String pass)
	{
		 Transaction transaction = null;
	         User x=null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "FROM User as sp where sp.id_user= :id and pass=:p ";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("id", id);
	    	    query.setParameter("p", pass);
	    	    x=(User)query.getSingleResult();
	    	    
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
	public static User getUser (String id)
	{
		 Transaction transaction = null;
	         User x=null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "FROM User as sp where sp.id_user= :id ";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("id", id);
	    	    x=(User)query.getSingleResult();
	    	    
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
	@SuppressWarnings("unchecked")
	public static ArrayList<User> Searchuser (String find)
	{
		 Transaction transaction = null;
	         ArrayList<User> list = null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "FROM User where id_user like %:@tim% or tenhienthi like %:@tim% or email like %:@tim%";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("@tim", find);
	    	    query.setMaxResults(10);
	    	    list = (ArrayList<User>)query.getResultList();
	          

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
	public static int themUser (User x)
	{
		 Transaction transaction = null;
	         Session session=null;
	         int t=0;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	           
	    	    session.save(x);
	    	    
	            // commit transaction
	            transaction.commit();
	            
	            session.close();
	             t=1;
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return t;
	}
	public static int suaUser (User x)
	{
		 Transaction transaction = null;
	         Session session=null;
	         int t=0;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	           
	    	   session.update(x);
	    	    
	            // commit transaction
	            transaction.commit();
	            
	            session.close();
	             t=1;
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return t;
	}
	public static int suaUserbyid (String id,String kh)
	{
		 Transaction transaction = null;
	         Session session=null;
	         int t=0;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	           
	            String hql = "update User set kichhoat=:kh where id_user=:id";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("id", id);
	    	    query.setParameter("kh", kh);
	    	    query.executeUpdate();
	            // commit transaction
	            transaction.commit();
	            
	            session.close();
	             t=1;
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return t;
	}
}
