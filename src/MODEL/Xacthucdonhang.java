package MODEL;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="xacthucdonhang")
public class Xacthucdonhang  {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String id_user ;
	private int id_donhang ;
	private String maxacthuc ;
	private String tinhtrang ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public int getId_donhang() {
		return id_donhang;
	}
	public void setId_donhang(int id_donhang) {
		this.id_donhang = id_donhang;
	}
	public String getMaxacthuc() {
		return maxacthuc;
	}
	public void setMaxacthuc(String maxacthuc) {
		this.maxacthuc = maxacthuc;
	}
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	
	
	
}
