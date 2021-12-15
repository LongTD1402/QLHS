import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyDiem {
	
	//Load data Diem======================================================
	
	void loadDatadiem(ArrayList<Diem> dsDiem) {
		BufferedReader bfr= null;
		try {
			FileReader frd=new FileReader("D:\\Java50Core\\Bài cuối khóa J50_core\\QuanLySinhVien\\dataOrigin\\diem.txt");
			bfr=new BufferedReader(frd);
			String line;
			while((line=bfr.readLine())!=null) {
				String[] part=line.split(";");
				String maSv=part[0];
				String maMh=part[1];
				String diem=part[2];
				Diem newDiem= new Diem(maSv,maMh,diem);
				dsDiem.add(newDiem);
			}
			dsDiem.remove(0);//xóa dòng đầu tiên trong file khỏi list
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if (bfr != null) {
				try {
					bfr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//Hiển thị bảng điểm theo danh sách Sinh viên===================================
	
	void hienThidsDiem(ArrayList<SinhVien> dsSv,ArrayList<MonHoc> dsMh,ArrayList<Diem> dsDiem) {
		int soTrang=dsSv.size()/30;
		if(soTrang==0) {
			for (SinhVien sinhVien : dsSv) {
				thongTinSV(sinhVien, dsMh, dsDiem);
			}
		}else {
			for(int i=0;i<soTrang;i++) {
				for (int j = 30*i; j < 30*(i+1); j++) {
					thongTinSV(dsSv.get(j), dsMh, dsDiem);
					}
				Scanner input =new Scanner(System.in);
				System.out.println("--------------------["+(i+1)+"/"+(soTrang+1)+"]--------------------");
				int chon=-1;
					try {
						System.out.println("(!!!)Số bất kì để chuyển trang tiếp");
						System.out.println("0.Thoát.");
						System.out.print("[]Chọn:");
						chon=input.nextInt();
					}catch(InputMismatchException e) {
						System.out.println("(!!!)Nhập sai (@_@)-->Nhập lại:");
						input.nextLine();
					}
				if(chon==0) {
					break;
				}
				if(i==soTrang-1) {
					for (int j = 30*soTrang; j < dsSv.size(); j++) {
						thongTinSV(dsSv.get(j), dsMh, dsDiem);
					}
					System.out.println("--------------------["+(soTrang+1)+"/"+(soTrang+1)+"]--------------------");
					System.out.println("(!!!)==>Không thể chuyển trang tiếp");
					break;
				}
			}
		}
	}
	
	//Bảng thông tin của MỘT Sinh viên==================================================
	
	void thongTinSV(SinhVien sv,ArrayList<MonHoc> dsMh,ArrayList<Diem> dsDiem) {
		String msvZone=" ";
		String hdZone=" ";
		String tenZone=" ";
		String snZone=" ";
		for (int i = 0; i < (9-sv.getMsv().length()); i++) {
			msvZone+=" ";
		}
		for (int i = 0; i <(24-sv.getHoDem().length()); i++) {
			hdZone+=" ";
		}
		for (int i = 0; i < (13-sv.getTen().length()); i++) {
			tenZone+=" ";
		}
		for (int i = 0; i < (15-sv.getNgaySinh().length()); i++) {
			snZone+=" ";
		}
		System.out.println("┌──────────────┬────────────────────────────────────────┬────────────────┐");
		System.out.println("│MSV:"+sv.getMsv()+msvZone+"│"+sv.getHoDem()+" "+sv.getTen()+hdZone+tenZone+"│"+sv.getNgaySinh()+snZone+"│");
		System.out.println("├──────────────┴────────────────────────────────────────┴────────────────┤");
		double tongDiem=0,tongHeso=0;
		for (Diem diem : dsDiem) {
			if(sv.getMsv().equals(diem.getMaSV())==true) {
				for (MonHoc monHoc : dsMh) {
					if(diem.getMaMH().equals(monHoc.getmMH())==true) {
						String mmhZone=" ";
						String tenmhZone=" ";
						String diemZone=" ";
						for (int i = 0; i < (7-monHoc.getmMH().length()); i++) {
							mmhZone+=" ";
						}
						for (int i = 0; i <(50-monHoc.getTenMH().length()); i++) {
							tenmhZone+=" ";
						}
						for (int i = 0; i < (12-diem.getDiem().length()); i++) {
							diemZone+=" ";
						}
						System.out.println("│"+monHoc.getmMH()+mmhZone+monHoc.getTenMH()+tenmhZone+diem.getDiem()+diemZone+"│");
						tongDiem+=Double.parseDouble(diem.getDiem())*Double.parseDouble(monHoc.getHeSodiem());
						tongHeso+=Double.parseDouble(monHoc.getHeSodiem());
					}
				}
			}
		}
		
		if(tongDiem==0) {
			System.out.println("│(!) Sinh viên chưa có điểm môn nào.                                     │");
			System.out.println("├────────────────────────────────────────────────────────────────────────┤");
			System.out.println("│Điểm tổng kết:                                              0           │");
			System.out.println("└────────────────────────────────────────────────────────────────────────┘");
		}else {
			double diemTk=tongDiem/tongHeso;
			System.out.println("├────────────────────────────────────────────────────────────────────────┤");
			System.out.format("│Điểm tổng kết:                                             %.2f         │",diemTk);
			System.out.println("");
			System.out.println("└────────────────────────────────────────────────────────────────────────┘");
		}
		
		System.out.println("---------------------------------------------");
	}
	
	//Danh sách Sinh viên theo TÊN=====================================================
	
	void dsSinhvientheoTEN(String tenSv,ArrayList<SinhVien> sv,ArrayList<MonHoc> dsMh,ArrayList<Diem> dsDiem) {
		ArrayList<SinhVien> list=new ArrayList<SinhVien>();
		int dem=0;
		for (SinhVien sinhVien : sv) {
			if(tenSv.equals(sinhVien.getTen())==true) {
				sinhVien.showInfo();
				list.add(sinhVien);
			}else {
				dem++;
			}
		}
		System.out.println("└──────────┴──────────────────────┴────────────────┴────────────┴───────────┘");
		if(dem>=sv.size()) {
			System.out.println("(!!!)Không có sinh viên này.");
		}else {
			int chon=-1;
			Scanner input=new Scanner(System.in);
			do {
				System.out.println("1.Xem chi tiết");
				System.out.println("0.Thoát");
				try {
					System.out.print("[]Chọn:");
					chon=input.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("(!!!)Nhập sai (@_@)-->Nhập lại:");
					input.nextLine();
				}
				switch(chon) {
				case 1:
					Scanner input2=new Scanner(System.in);
					System.out.print("[]Nhập MÃ SINH VIÊN cần xem chi tiết:");
					String msv=input2.nextLine();
					int c=0;
					for (SinhVien sinhVien : list) {
						if(msv.equals(sinhVien.getMsv())==true) {
							thongTinSV(sinhVien, dsMh, dsDiem);
						}else {
							c++;
						}
						if(c>=list.size()) {
							System.out.println("(!!!)Không có MÃ SINH VIÊN này trong dánh sách các sinh viên có tên ["+tenSv+"].");
						}
					}
					break;
				case 2:
					break;
				}
			}while(chon!=0);
		}
	}
}
