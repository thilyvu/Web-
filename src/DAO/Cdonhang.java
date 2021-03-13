package DAO;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import MODEL.Donhang;
import UTL.map;

public class Cdonhang {
	@SuppressWarnings("unchecked")
	public static ArrayList<Donhang> Getdonhang ()
	{
		 Transaction transaction = null;
	         ArrayList<Donhang> list = null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an Donhang object
	            
	            String hql = "FROM Donhang";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    list = (ArrayList<Donhang>)query.getResultList();
	          

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
	public static ArrayList<Donhang> ds10Donhang (int vt)
	{
		 Transaction transaction = null;
	         ArrayList<Donhang> list = null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an Donhang object
	            
	            String hql = "FROM Donhang";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setFirstResult(vt*10);
	    	    query.setMaxResults(10);
	    	    list = (ArrayList<Donhang>)query.getResultList();
	          

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
	            // get an Donhang object
	            
	            String hql = "Select count(sp.id_donhang) FROM Donhang as sp ";
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
	public static int tongspbyuser (String user)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an Donhang object
	            
	            String hql = "Select count(sp.id_donhang) FROM Donhang as sp where id_user=:id";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("id", user);
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
	@SuppressWarnings("unchecked")
	public static ArrayList<Donhang> getAlldonhangbyuser (String id,int vt)
	{
		 Transaction transaction = null;
		 ArrayList<Donhang> x=null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an Donhang object
	            
	            String hql = "FROM Donhang as dh where dh.id_user=:id";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("id", id);
	    	   // query.setFirstResult(vt*10);
	    	    //query.setMaxResults(10);
	    	    x=(ArrayList<Donhang>)query.getResultList();
	    	    
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

	public static Donhang getdonhangbyid (int iddh)
	{
		 Transaction transaction = null;
		Donhang x=null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an Donhang object
	            
	            String hql = "FROM Donhang as dh where dh.id_donhang=:id";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("id", iddh);
	    	    x=(Donhang)query.getSingleResult();
	    	    
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
	public static int themdonhang (Donhang dh)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	           i= (int) session.save(dh);
	            
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
	public static int xoadonhang (int id)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "delete from Donhang as dh where id_donhang=:id";
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
	public static int suadonhang (Donhang dh)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	        
	           session.update(dh);
	            
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
	public static int suadonhangbyid (int iddh,String trangthai,String ghichu)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "update Donhang set tinhtrang=:tt where id_donhang=:id";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	   query.setParameter("id", iddh);
	    	   query.setParameter("tt", trangthai);
	    	  // query.setParameter("gc", ghichu);
	    	   query.executeUpdate();
	            
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
	public static int getiddonhangbyuser(String id_user)
	{
		Transaction transaction = null;
        int i=0;
        Session session=null;
       try  {
       	session = map.getSessionFactory().openSession();
           // start a transaction
           transaction = session.beginTransaction();
           // get an user object
           
           String hql = "select id_donhang FROM Donhang where tinhtrang=-1 and id_user=:id";
   	    @SuppressWarnings("rawtypes")
			Query query = session.createQuery(hql);
   	    	query.setParameter("id", id_user);
   	    	i=(int)query.getSingleResult();
   	    	
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
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Object[]> kiemtrasoluong (String json)
	{
		 Transaction transaction = null;
	         ArrayList<Object[]> list = null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an Donhang object
	            
	            String hql = "CALL kiemtraloi(:json)";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createNativeQuery(hql);
	    	    query.setParameter("json", json);
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
