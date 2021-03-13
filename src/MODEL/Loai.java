package MODEL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loai")
public class Loai {
	@Id
	private int id_loai ;
	private String tenloai ;
	public int getId_loai() {
		return id_loai;
	}
	public void setId_loai(int id_loai) {
		this.id_loai = id_loai;
	}
	public String getTenloai() {
		return tenloai;
	}
	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
	
	
}
