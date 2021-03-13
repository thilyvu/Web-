package MODEL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sanpham")
public class Sanpham {
	public Sanpham() {}
	public Sanpham(int currentSlide, float price, String numberofstart, String nha_sx, int sl_con, String mota,
			int soluong_daban, int id_loai, String ten_sp, String imagesrc, String mau) {
		super();
		this.currentSlide = currentSlide;
		this.price = price;
		this.numberofstart = numberofstart;
		this.nha_sx = nha_sx;
		this.sl_con = sl_con;
		this.mota = mota;
		this.soluong_daban = soluong_daban;
		this.id_loai = id_loai;
		this.ten_sp = ten_sp;
		this.imagesrc = imagesrc;
		this.mau = mau;
	}
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_sp")
	private int currentSlide;
	@Column(name="gia")
	private float price;
	@Column(name="sao")
	private String numberofstart;
	private String nha_sx ;
	private int sl_con;
	private String mota ;
	private int soluong_daban ;

	private int id_loai;
	private String ten_sp ;
	@Column(name="hinhanh")
	private String imagesrc;
	private String mau;
	
	public String getMau() {
		return mau;
	}
	public void setMau(String mau) {
		this.mau = mau;
	}
	public int getCurrentSlide() {
		return currentSlide;
	}
	public void setCurrentSlide(int currentSlide) {
		this.currentSlide = currentSlide;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getNumberofstart() {
		return numberofstart;
	}
	public void setNumberofstart(String numberofstart) {
		this.numberofstart = numberofstart;
	}
	public String getNha_sx() {
		return nha_sx;
	}
	public void setNha_sx(String nha_sx) {
		this.nha_sx = nha_sx;
	}
	public int getSl_con() {
		return sl_con;
	}
	public void setSl_con(int sl_con) {
		this.sl_con = sl_con;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public int getSoluong_daban() {
		return soluong_daban;
	}
	public void setSoluong_daban(int soluong_daban) {
		this.soluong_daban = soluong_daban;
	}
	public int getId_loai() {
		return id_loai;
	}
	public void setId_loai(int id_loai) {
		this.id_loai = id_loai;
	}
	public String getTen_sp() {
		return ten_sp;
	}
	public void setTen_sp(String ten_sp) {
		this.ten_sp = ten_sp;
	}
	public String getImagesrc() {
		return imagesrc;
	}
	public void setImagesrc(String imagesrc) {
		this.imagesrc = imagesrc;
	}
}