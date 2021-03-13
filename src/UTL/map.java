package UTL;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import MODEL.*;


public class map {
	private static SessionFactory sessionFactory;

	 public static SessionFactory getSessionFactory() {
	  if (sessionFactory == null) {
	   try {
	    Configuration configuration = new Configuration();

	    // Hibernate settings equivalent to hibernate.cfg.xml's properties
	    Properties settings = new Properties();
	    settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	    settings.put(Environment.URL, "jdbc:mysql://65.19.141.67:3306/songoku2_demo");
	    settings.put(Environment.USER, "songoku2_linh");
	    settings.put(Environment.PASS, "@7rPMdW8i5mSKAZ");
	    settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

	    settings.put(Environment.SHOW_SQL, "true");

	  //  settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	    //settings.put(Environment.HBM2DDL_AUTO, "create-drop");

	    configuration.setProperties(settings);
	    configuration.addAnnotatedClass(Xacthucdonhang.class);
	    configuration.addAnnotatedClass(Xacthucuser.class);
	    configuration.addAnnotatedClass(Loai.class);
	    configuration.addAnnotatedClass(User.class);
	    configuration.addAnnotatedClass(Sanpham.class);
	    configuration.addAnnotatedClass(Donhang.class);
	    configuration.addAnnotatedClass(Giohang.class);
	    configuration.addAnnotatedClass(Chitietdonhang.class);
	    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	      .applySettings(configuration.getProperties()).build();
	    System.out.println("Hibernate Java Config serviceRegistry created");
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;

	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	  }
	  return sessionFactory;
	 }
}
