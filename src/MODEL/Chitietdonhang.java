package MODEL;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="chitietdonhang")
public class Chitietdonhang implements Serializable {
	@Id
	private int id_donhang ;
	@Id
	private int id_sp ;
	private float gia ;
	private String ghichu ;
	private int soluong ;
	private String size_mau ;
	public Chitietdonhang() {}
	public Chitietdonhang(int id_donhang, int id_sp, int soluong) {
		super();
		this.id_donhang = id_donhang;
		this.id_sp = id_sp;
		this.soluong = soluong;
	}
	public int getId_donhang() {
		return id_donhang;
	}
	public void setId_donhang(int id_donhang) {
		this.id_donhang = id_donhang;
	}
	public int getId_sp() {
		return id_sp;
	}
	public void setId_sp(int id_sp) {
		this.id_sp = id_sp;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getSize_mau() {
		return size_mau;
	}
	public void setSize_mau(String size_mau) {
		this.size_mau = size_mau;
	}
	
	
	
}
