package MODEL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="donhang")
public class Donhang {
	private float tong_thanh_toan  ;
	private String sdt ;
	private String diachi ; 
	private String tinhtrang ;
	@Column(nullable = true)
	private Integer  id_voucher  ;
	private String id_user ;
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_donhang  ;
	private String thoigian;
	
	
	public Donhang() {}

	
	public Donhang(float tong_thanh_toan, String sdt, String diachi, String tinhtrang, int id_voucher, String id_user,
			int id_donhang, String thoigian) {
		super();
		this.tong_thanh_toan = tong_thanh_toan;
		this.sdt = sdt;
		this.diachi = diachi;
		this.tinhtrang = tinhtrang;
		this.id_voucher = id_voucher;
		this.id_user = id_user;
		this.id_donhang = id_donhang;
		this.thoigian = thoigian;
	}


	public String getThoigian() {
		return thoigian;
	}
	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}
	public int getId_donhang() {
		return id_donhang;
	}
	public void setId_donhang(int id_donhang) {
		this.id_donhang = id_donhang;
	}
	public float getTong_thanh_toan() {
		return tong_thanh_toan;
	}
	public void setTong_thanh_toan(float tong_thanh_toan) {
		this.tong_thanh_toan = tong_thanh_toan;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public int getId_voucher() {
		return id_voucher;
	}
	public void setId_voucher(int id_voucher) {
		this.id_voucher = id_voucher;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

}
