package MODEL;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	private String id_user;
	private String pass ;
	private String sdt ;
	private int soluongsp ;
	private String permission ;
	private String tenhienthi ;
	private String avatar ;
	private String diachi ;
	private String ngaysinh ;
	private String email ;
	private String kichhoat;
	
	
	public String getKichhoat() {
		return kichhoat;
	}

	public void setKichhoat(String kichhoat) {
		this.kichhoat = kichhoat;
	}

	public User() {}
	
	public User(String id_user, String pass, String sdt, int soluongsp, String permission, String tenhienthi,
			String avatar, String diachi, String ngaysinh, String email) {
		super();
		this.id_user = id_user;
		this.pass = pass;
		this.sdt = sdt;
		this.soluongsp = soluongsp;
		this.permission = permission;
		this.tenhienthi = tenhienthi;
		this.avatar = avatar;
		this.diachi = diachi;
		this.ngaysinh = ngaysinh;
		this.email = email;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public int getSoluongsp() {
		return soluongsp;
	}
	public void setSoluongsp(int soluongsp) {
		this.soluongsp = soluongsp;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getTenhienthi() {
		return tenhienthi;
	}
	public void setTenhienthi(String tenhienthi) {
		this.tenhienthi = tenhienthi;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
