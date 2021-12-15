import java.util.InputMismatchException;

public class MonHoc {
	private String mMH;
	private String tenMH;
	private String heSodiem;
	
	public MonHoc(String mMH, String tenMH, String heSodiem) {
		super();
		this.mMH = mMH;
		this.tenMH = tenMH;
		this.heSodiem = heSodiem;
	}
	public String getmMH() {
		return mMH;
	}
	public void setmMH(String mMH) {
		this.mMH = mMH;
	}
	public String getTenMH() {
		return tenMH;
	}
	public void setTenMH(String tenMH) throws NameException{
		if(tenMH.isEmpty()) {
			throw new NameException("(!!!)Tên môn học không được để trống");
		}
		this.tenMH = tenMH;
	}
	public String getHeSodiem() {
		return heSodiem;
	}
	public void setHeSodiem(String heSodiem) throws InputMismatchException,NumberException{
		if(Double.parseDouble(heSodiem)<0) {
			throw new NumberException("(!!!)Hệ số điểm phải >0");
		}
		this.heSodiem = heSodiem;
	}
	@Override
	public String toString() {
		return mMH+";"+tenMH+";"+heSodiem;
	}
	public void showInfo() {
		System.out.println( mMH+";"+tenMH+";"+heSodiem);
	}
	
}
