import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyMonHoc {
	
	//Load data Môn học======================================
	
	void loadDataMH(ArrayList<MonHoc> dsMh) {
		BufferedReader bfr= null;
		try {
			FileReader frd=new FileReader("D:\\Java50Core\\Bài cuối khóa J50_core\\QuanLySinhVien\\dataOrigin\\monhoc.txt");
			bfr=new BufferedReader(frd);
			String line;
			while((line=bfr.readLine())!=null) {
				String[] part=line.split(";");
				String maMh=part[0];
				String tenMh=part[1];
				String heSo=part[2];
				MonHoc newMh= new MonHoc(maMh,tenMh,heSo);
				dsMh.add(newMh);
			}
			dsMh.remove(0);//xóa dòng đầu tiên trong file khỏi list
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
	
	//THÊM Môn học==============================================
	
//	void themMh(ArrayList<MonHoc> dsMh) {
//		Scanner input = new Scanner(System.in);
//		MonHoc mh = null;
//		String ma = null;
//		String ten=null;
//		do {
//			try {
//				mh = new MonHoc("","","");
//				int m=Integer.parseInt(dsMh.get(dsMh.size()-1).getmMH());
//				String mmh=String.format("%03d",(m+1));
//				mh.setmMH(mmh);
//				if(ten == null) {
//					System.out.print("Nhập TÊN môn học:");
//					ten = input.nextLine();
//					mh.setTenMH(ten);
//				}else {
//					mh.setTenMH(ten);
//				}
//				System.out.print("Nhập hệ số điểm:");
//				String hs = input.nextLine();
//				mh.setHeSodiem(hs);
//				dsMh.add(mh);
//			}catch (Exception e) {
//				System.out.println(e.getMessage());
//				System.out.println("Nhập lại:");
//				mh = null;
//				if(e instanceof NameException) {
//					ten = null;
//				}
//			}
//		}while(mh == null);
//		BufferedWriter bfw=null;
//		try {
//			FileWriter wr = new FileWriter("D:\\Java50Core\\Bài cuối khóa J50_core\\QuanLySinhVien\\dataOrigin\\monhoc.txt",true);
//			bfw = new BufferedWriter(wr);
//				bfw.write(mh.toString());
//				bfw.newLine();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			if(bfw!= null) {
//				try {
//					bfw.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		System.out.println("(#)THÊM thành công môn học");
//	}
//	
//	//SỬA thông tin Môn học================================================
//	
//	void suaMh() {
//		
//	}
//	void xoaMh() {
//		
//	}
	
	
	//HIỂN THỊ danh sách Môn học============================================
	
	void hienThidsmonhoc(ArrayList<MonHoc> dsMh) {
		Comparator<MonHoc> comp= new Comparator<MonHoc>() {

			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				return o1.getTenMH().compareTo(o2.getTenMH());
			}
		};
		dsMh.sort(comp);
		int soTrang=dsMh.size()/30;
		if (soTrang==0) {
			for (MonHoc monHoc : dsMh) {
				monHoc.showInfo();
			}
			System.out.println("-----------------[1/1]------------------------");
		}else {
			for(int i=0;i<soTrang;i++) {
				for (int j = 30*i; j < 30*(i+1); j++) {
					dsMh.get(j).showInfo();
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
					for (int j = 30*soTrang; j < dsMh.size(); j++) {
						dsMh.get(j).showInfo();
					}
					System.out.println("--------------------["+(soTrang+1)+"/"+(soTrang+1)+"]--------------------");
					System.out.println("(!!!)==>Không thể chuyển trang tiếp");
					break;
				}
			}
		}
		Comparator<MonHoc> comp2=new Comparator<MonHoc>() {
			
			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				int mmh1=Integer.parseInt(o1.getmMH());
				int mmh2=Integer.parseInt(o2.getmMH());
				return mmh1>mmh2?1:-1;
			}
		};
	}
}
