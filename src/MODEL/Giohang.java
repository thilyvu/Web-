package MODEL;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="giohang")
public class Giohang implements Serializable{
		@Id
		private String id_user;
		@Id
		private int id_sp;
		private int soluong;
		
		public Giohang() {}
		
		public Giohang(String id_user, int id_sp, int soluong) {
			super();
			this.id_user = id_user;
			this.id_sp = id_sp;
			this.soluong = soluong;
		}
		
		public String getId_user() {
			return id_user;
		}
		public void setId_user(String id_user) {
			this.id_user = id_user;
		}
		public int getId_sp() {
			return id_sp;
		}
		public void setId_sp(int id_sp) {
			this.id_sp = id_sp;
		}
		public int getSoluong() {
			return soluong;
		}
		public void setSoluong(int soluong) {
			this.soluong = soluong;
		}
				
		
}
