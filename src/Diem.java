
public class Diem {
	private String maSV;
	private String maMH;
	private String diem;
	
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getMaMH() {
		return maMH;
	}
	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}
	public String getDiem() {
		return diem;
	}
	public void setDiem(String diem) throws NumberException,NameException {
		if(diem.isEmpty()) {
			throw new NameException("(!!!)Điểm không được để trống.");
		}
		boolean check=true;
		for (int i = 0; i < diem.length(); i++) {
			if(!Character.isDigit(diem.charAt(i))) {
				check=false;
			}
		}
		if(check==false) {
			throw new NumberException("(!!!)Điểm phải là số.");
		}
		if(Integer.parseInt(diem)<0||Integer.parseInt(diem)>10) {
			throw new NumberException("(!!!)Lỗi (0<Điểm <10)");
		}
		this.diem = diem;
	}
	public Diem(String maSV, String maMH, String diem) {
		this.maSV = maSV;
		this.maMH = maMH;
		this.diem = diem;
	}
	void showInfo() {
		System.out.println(maSV+";"+maMH+";"+diem);
	}
	@Override
	public String toString() {
		
		return maSV+";"+maMH+";"+diem;
	}
	
}
