package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "message")
   private String message;
   
   @ManyToOne
   @JoinColumn(name = "id")
   private User notifiedUser;
   
   @ManyToOne
   @JoinColumn(name = "id")
   private User notifierUser;
   
   @ManyToOne
   @JoinColumn(name = "id")
   private Posting donation;
   
   @ManyToOne
   @JoinColumn(name = "id")
   private Posting request;
   
   public Notification() {
   }

   public Notification(Integer id, String message, User notifiedUser, User notifierUser, Posting donation, Posting request) {
      this.id = id;
      this.message = message;
      this.notifiedUser = notifiedUser;
      this.notifierUser = notifierUser;
      this.donation = donation;
      this.request = request;
   }

   public Notification(String message, User notifiedUser, User notifierUser, Posting donation, Posting request) {
	   this.message = message;
	   this.notifiedUser = notifiedUser;
	   this.notifierUser = notifierUser;
	   this.donation = donation;
	   this.request = request;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   public User getNotifier() {
      return notifierUser;
   }

   public void setNotifier(User notifier) {
      this.notifierUser = notifier;
   }
   
   public User getNotified() {
	   return notifiedUser;
   }

   public void setNotified(User notified) {
	   this.notifiedUser = notified;
   }
   
   public Posting getDonation() {
	   return donation;
   }

   public void setDonation(Posting donation) {
	   this.donation = donation;
   }

   public Posting getRequest() {
	   return request;
   }

   public void setRequestion(Posting request) {
	   this.request = request;
   }
   
   @Override
   public String toString() {
      return "Notification message:" + this.message + ". From User ID " + this.notifierUser + " to User ID " + this.notifiedUser;
   }
}