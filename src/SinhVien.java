import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SinhVien {
	private String mSV;
	private String hoDem;
	private String tenSV;
	private String ngaySinh;
	private String gioiTinh;
	public String getMsv() {
		return mSV;
	}
	public void setMsv(String mSV) {
		this.mSV = mSV;
	}
	public String getHoDem() {
		return hoDem;
	}
	public void setHoDem(String hoDem) throws NameException {
		if(hoDem.replaceAll(" ","").isEmpty()) {
			throw new NameException("(!!!)Họ đệm không được để trống.");
		}
		for (char c : hoDem.toCharArray()) {
			if(Character.isDigit(c)==true) {
				throw new NameException("(!!!)Họ đệm không được chứa chữ số");
				}
			}
		if(hoDem.length()>25) {
			throw new NameException("(!!!)Họ đệm dài quớ.");
		}
		this.hoDem = hoDem;
	}
	public String getTen() {
		return tenSV;
	}
	public void setTen(String tenSV) throws NameException{
		if(tenSV.contains(" ")) {
			throw new NameException("(!!!)Tên không được có dấu cách.");
		}
		if(tenSV.isEmpty()) {
			throw new NameException("(!!!)Tên không được để trống");
		}
		for (char c : tenSV.toCharArray()) {
			if(Character.isDigit(c)==true) {
				throw new NameException("(!!!)Tên không được chứa chữ số");
				}
			}
		if(tenSV.length()>15) {
			throw new NameException("(!!!)Tên dài quớ.");
		}
			if(tenSV.charAt(0)>91) {
				throw new NameException("(!!!)Cần viết hoa chữ cái đầu.");
		}
		this.tenSV = tenSV;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) throws ParseException {
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		Date sn=sdf.parse(ngaySinh);
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) throws NameException{
		int check=-1;
		if(gioiTinh.toLowerCase().equals("nam")==false && gioiTinh.toLowerCase().equals("nữ")==false) {
			throw new NameException("(!!!)Nhập sai(Nhập Nam/Nữ).");
		}
		this.gioiTinh = gioiTinh;
	}
	void showInfo() {
		String msvZone="";
		String hdZone="";
		String tenZone=" ";
		String snZone=" ";
		String gtZone=" ";
		for (int i = 0; i < (10-mSV.length()); i++) {
			msvZone+=" ";
		}
		for (int i = 0; i <(22-hoDem.length()); i++) {
			hdZone+=" ";
		}
		for (int i = 0; i < (15-tenSV.length()); i++) {
			tenZone+=" ";
		}
		for (int i = 0; i < (11-ngaySinh.length()); i++) {
			snZone+=" ";
		}
		for (int i = 0; i < (10-gioiTinh.length()); i++) {
			gtZone+=" ";
		}
		//System.out.println("┌──────────┬──────────────────────┬────────────────┬────────────┬───────────┐");
		System.out.println("├──────────┼──────────────────────┼────────────────┼────────────┼───────────┤");
		System.out.println("│"+mSV+msvZone+"│"+hoDem+hdZone+"│"+tenSV+tenZone+"│"+ngaySinh+snZone+"│"+gioiTinh+gtZone+"│");
		
	}

	public SinhVien(String mSV, String hoDem, String tenSV, String ngaySinh, String gioiTinh) {
		this.mSV = mSV;
		this.hoDem = hoDem;
		this.tenSV = tenSV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}
	@Override
	public String toString() {
		return mSV+";"+hoDem+";"+tenSV+";"+ngaySinh+";"+gioiTinh;
	}
}
