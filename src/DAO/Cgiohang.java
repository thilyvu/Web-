package DAO;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import MODEL.Giohang;

import UTL.map;

public class Cgiohang {

	@SuppressWarnings("unchecked")
	public static ArrayList<Object[]> Getgiohang (String id_user)
	{
		 Transaction transaction = null;
	         ArrayList<Object[]> list = null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an Donhang object
	            
	            String hql = "select gh.id_user,gh.id_sp,gh.soluong,sp.imagesrc,sp.price,sp.ten_sp,sp.sl_con from Giohang as gh,Sanpham as sp where sp.currentSlide=gh.id_sp and gh.id_user=:id";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("id", id_user);
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
	public static int themgiohang (Giohang gh)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            session.save(gh);
	            
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
	public static int xoagiohang (Giohang gh)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "delete from Giohang where id_sp=:idsp and id_user=:iduser";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	   query.setParameter("iduser", gh.getId_user());
	    	   query.setParameter("idsp", gh.getId_sp());
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
	public static int suagiohang (Giohang gh)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	           session.update(gh);
	            
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
}
