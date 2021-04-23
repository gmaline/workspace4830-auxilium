/**
 */
package util;

import java.util.List;

import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.mysql.jdbc.PreparedStatement;

import datamodel.Role;
import datamodel.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
	
   static SessionFactory sessionFactory = null;
   
   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<User> listUsers() {  //Retrieve Data
      List<User> resultList = new ArrayList<User>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> users = session.createQuery("FROM User").list(); //From NameofDataModel
         for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {
            User user = (User) iterator.next();
            resultList.add(user);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<User> listUsers(String email) { //Find User by Email
      List<User> resultList = new ArrayList<User>();

      Session session = getSessionFactory().openSession();
      Transaction tx = null;

      try {
         tx = session.beginTransaction();
         List<?> users = session.createQuery("FROM User").list();
         for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {
            User user = (User) iterator.next();
            if (user.getEmail().startsWith(email)) {
               resultList.add(user);
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }
   
   public static Posting FindListing(int itemId) { //Find Posting by ID
	      Posting result = null; //new Posting();

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         List<?> posts = session.createQuery("FROM Posting").list();
	         for (Iterator<?> iterator = posts.iterator(); iterator.hasNext();) {
	            Posting post = (Posting) iterator.next();
	            if (post.getId() == itemId) {
	               result = post;
	               break;
	            }
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return result;
	   }
   
   public static List<Posting> FindListing(String keyword) { //Find Posting by keyword
	      List<Posting> resultList = new ArrayList<Posting>();

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      
	      try {
	    	  
	         tx = session.beginTransaction();
	         String select = keyword.isEmpty() ? "" : " WHERE name LIKE '%" + keyword + "%'"; 
	         List<?> posts = session.createQuery("FROM Posting" + select ).list();
	         
	         for (Iterator<?> iterator = posts.iterator(); iterator.hasNext();) {
	        	 Posting post = (Posting) iterator.next();
	             if (post.getName().contains(keyword)) {
	                resultList.add(post);
	             }
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }
   
   public static User FindUser(String email) { //Find User by email
	      User result = new User();

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         List<?> users = session.createQuery("FROM User").list();
	         for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {
	            User user = (User) iterator.next();
	            if (user.getEmail().equals(email)) {
	               result = user;
	               break;
	            }
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return result;
	   }
   
   public static void insertNotify(Notification notify) {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
		   session.save(notify);
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null) {
			   tx.rollback();
		   }
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
   }
   
 public static List<Notification> getNotificationsForUser(User user) {
	 List<Notification> resultList = new ArrayList<Notification>();

     Session session = getSessionFactory().openSession();
     Transaction tx = null;

     try {
        tx = session.beginTransaction();
        List<?> notifications = session.createQuery("FROM Notification").list();
        for (Iterator<?> iterator = notifications.iterator(); iterator.hasNext();) {
           Notification notif = (Notification) iterator.next();
           if (notif.getNotified().getId() == user.getId()) {
        	   resultList.add(notif);
           }
        }
        tx.commit();
     } catch (HibernateException e) {
        if (tx != null)
           tx.rollback();
        e.printStackTrace();
     } finally {
        session.close();
     }
     return resultList;
  }
 
 public static List<Notification> getNotificationsByPost(Posting post) {
	 List<Notification> resultList = new ArrayList<Notification>();

     Session session = getSessionFactory().openSession();
     Transaction tx = null;

     try {
        tx = session.beginTransaction();
        List<?> notifications = session.createQuery("FROM Notification").list();
        for (Iterator<?> iterator = notifications.iterator(); iterator.hasNext();) {
           Notification notif = (Notification) iterator.next();
           if (notif.getDonation().getId() == post.getId()) {
        	   resultList.add(notif);
           }
        }
        tx.commit();
     } catch (HibernateException e) {
        if (tx != null)
           tx.rollback();
        e.printStackTrace();
     } finally {
        session.close();
     }
     return resultList;
  }
 
 public static Notification getNotificationById(Integer id) {
	 Notification result = new Notification();

     Session session = getSessionFactory().openSession();
     Transaction tx = null;

     try {
        tx = session.beginTransaction();
        List<?> notifications = session.createQuery("FROM Notification WHERE id=" + id).list();
        result = (Notification) notifications.get(0);
        tx.commit();
     } catch (HibernateException e) {
        if (tx != null)
           tx.rollback();
        e.printStackTrace();
     } finally {
        session.close();
     }
     return result;
  }
 
 public static Integer removeNotification(Notification notif) {
	 	Integer result = -1;
	 	
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   
	   try {
	         tx = session.beginTransaction();
	         session.delete(notif);
	         tx.commit();

	   } catch (HibernateException e) {
		   if (tx != null) {
			   tx.rollback();
		   }
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
	   return result;
}
   
 public static Integer removePosting(Posting post) {
	 	Integer result = -1;
	 	
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   
	   try {
	         tx = session.beginTransaction();
	         session.delete(post);
	         tx.commit();

	   } catch (HibernateException e) {
		   if (tx != null) {
			   tx.rollback();
		   }
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
	   return result;
   }
 
 
   public static List<Posting> listPostings() { //Get all postings
	      List<Posting> resultList = new ArrayList<Posting>();

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         List<?> posts = session.createQuery("FROM Posting").list();
	         for (Iterator<?> iterator = posts.iterator(); iterator.hasNext();) {
	            Posting post = (Posting) iterator.next();
	            resultList.add(post);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }
   
   public static void insertPosting(String name, String quality, String description, boolean type, User user ) {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
		   session.save(new Posting(name, quality, description, type, user));
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null) {
			   tx.rollback();
		   }
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
   }


   public static void createUsers(String firstName, String lastName, String email, 
		   String password, Integer age, Role role, Organization organization) {  //Data Insertion
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new User(firstName, lastName, email, password, age, role, organization));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
   
   public static void createOrganizaiton(String name) {  //Data Insertion
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         session.save(new Organization(name));
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
   }
   
   public static void createRole(String name) {  //Data Insertion
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         //TODO handle giving different roles different access.
	         session.save(new Role(name, true, true));
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	   }
   
   public static Role findRole(String roleName) { //Find role by name
	      Role result = null;

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         List<?> roles = session.createQuery("FROM Role").list();
	         for (Iterator<?> iterator = roles.iterator(); iterator.hasNext();) {
	            Role role = (Role) iterator.next();
	            if (role.getName().equals(roleName)) {
	               result = role;
	               break;
	            }
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return result;
	   }
   	
   public static Organization findOrganization(String organizationName) { //Find organization by name
	      Organization result = null;

	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;

	      try {
	         tx = session.beginTransaction();
	         List<?> orgs = session.createQuery("FROM Organization").list();
	         for (Iterator<?> iterator = orgs.iterator(); iterator.hasNext();) {
	            Organization org = (Organization) iterator.next();
	            if (org.getName().equals(organizationName)) {
	               result = org;
	               break;
	            }
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return result;
	   }

}
