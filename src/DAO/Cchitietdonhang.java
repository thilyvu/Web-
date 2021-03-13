package DAO;

import java.util.ArrayList;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import MODEL.Chitietdonhang;

import MODEL.Giohang;
import UTL.map;

public class Cchitietdonhang {
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Object[]> GetAllChitietbyDonhang (int iddh,String id_user)
	{
		 Transaction transaction = null;
	         ArrayList<Object[]> list = null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            
	            String hql = "select ct.id_donhang,ct.id_sp,ct.gia,ct.ghichu,ct.soluong,ct.size_mau,sp.ten_sp,sp.imagesrc\r\n"
	            		+ "from Sanpham as sp,Chitietdonhang as ct,Donhang as dh\r\n"
	            		+ "where sp.currentSlide=ct.id_sp and ct.id_donhang=dh.id_donhang and dh.id_user=:id and dh.id_donhang=:iddh";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("id", id_user);
	    	    query.setParameter("iddh", iddh);
	    	    list = (ArrayList<Object[]>)query.getResultList();
	          
	            
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
	public static ArrayList<Object[]> GetChitietbyidDonhang (int iddh)
	{
		 Transaction transaction = null;
	         ArrayList<Object[]> list = null;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            String hql = "select ct.id_donhang,ct.id_sp,ct.gia,ct.ghichu,ct.soluong,ct.size_mau,sp.ten_sp,sp.imagesrc\r\n"
	            		+ "from Sanpham as sp,Chitietdonhang as ct,Donhang as dh\r\n"
	            		+ "where sp.currentSlide=ct.id_sp and ct.id_donhang=dh.id_donhang and dh.id_donhang=:iddh";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("iddh", iddh);
	    	    list = (ArrayList<Object[]>)query.getResultList();
	          
	            
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
	public static int themdsChitietdh (int id_donhang,ArrayList<Chitietdonhang> list,String id_user)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            ArrayList<Giohang> listgh=new ArrayList<Giohang>();
	            for (Chitietdonhang x:list)
	            {
	            	session.save(x);
	            	Giohang t=new Giohang();
	            	t.setId_sp(x.getId_sp());
	            	t.setId_user(id_user);
	            	listgh.add(t);
	            }
	            for(Giohang x: listgh)
	            {
					  session.delete(x);
	            }
	            String hql = "update Donhang set tinhtrang=0 where id_donhang=:iddh";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("iddh", id_donhang);
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
	public static int themchitiet (Chitietdonhang ct,int iddh)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            session.save(ct);
	            String hql = "update Donhang set tinhtrang=0 where id_donhang=:iddh";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	    query.setParameter("iddh", iddh);
	    	   	query.executeUpdate();
	            
	            transaction.commit();
	            
	            session.close();
	            i=1;
	           
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            //e.printStackTrace();
	           
	            throw e;
	        }
	        return i;
	}
	public static int xoachitiet (Chitietdonhang ct)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            String hql = "delete from Chitietdonhang as ct where ct where ct.id_donhang=:iddh and ct.id_sp=:idsp";
	    	    @SuppressWarnings("rawtypes")
				Query query = session.createQuery(hql);
	    	   query.setParameter("iddh", ct.getId_donhang());
	    	   query.setParameter("idsp", ct.getId_sp());
	    	   i=query.executeUpdate();
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
	public static int suachitiet (Chitietdonhang ct)
	{
		 Transaction transaction = null;
	         int i=0;
	         Session session=null;
	        try  {
	        	session = map.getSessionFactory().openSession();
	            // start a transaction
	            transaction = session.beginTransaction();
	            // get an user object
	            session.update(ct);
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
