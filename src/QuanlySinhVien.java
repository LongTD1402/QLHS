import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanlySinhVien {
	
	//load Data=============================
	
	void loadDatasv(ArrayList<SinhVien> dsSv){
		BufferedReader bfr= null;
		try {
			FileReader frd=new FileReader("D:\\Java50Core\\Bài cuối khóa J50_core\\QuanLySinhVien\\dataOrigin\\sinhvien.txt");
			bfr=new BufferedReader(frd);
			String line;
			SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
			while((line=bfr.readLine())!=null) {
				String[] part=line.split(";");
				String maSv=part[0];
				String hd=part[1];
				String ten=part[2];
				String sn=part[3];
				String gt=part[4];
				SinhVien newSv= new SinhVien(maSv,hd,ten,sn,gt);
				dsSv.add(newSv);
			}
			dsSv.remove(0);//xóa dòng đầu tiên trong file khỏi list
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
	
	//THÊM Sinh viên=====================================================
	
	void themSV(ArrayList<SinhVien> dsSv) {
		Scanner input = new Scanner(System.in);
		SinhVien sv = null;
		String hd = null;
		String ten=null;
		String sn = null;
		do {
			try {
				sv = new SinhVien("","","","","");
				int m=Integer.parseInt(dsSv.get(dsSv.size()-1).getMsv().replaceAll("SV",""));
				String mSV=String.format("SV%05d",(m+1));
				sv.setMsv(mSV);
				if(hd == null) {
					System.out.print("Nhập họ đệm:");
					hd = input.nextLine();
					sv.setHoDem(hd);
				}else {
					sv.setHoDem(hd);
				}
				if (ten == null) {
					System.out.print("Nhập tên:");
					ten = input.nextLine();
					sv.setTen(ten);
				}else {
					sv.setTen(ten);
				}
				if (sn == null) {
					System.out.print("Nhập ngày sinh:");
					sn = input.nextLine();
					sv.setNgaySinh(sn);
				}else {
					sv.setNgaySinh(sn);
				}
				System.out.print("Nhập giới tính:");
				String gt = input.nextLine();
				sv.setGioiTinh(gt);
				dsSv.add(sv);
			}catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Nhập lại:");
				sv = null;
				if(e instanceof NameException) {
					hd = null;
				}
				if(e instanceof NameException) {
					ten = null;
				}
				if(e instanceof ParseException) {
					sn=null;
				}
			}
		}while(sv == null);
		BufferedWriter bfw=null;
		try {
			FileWriter wr = new FileWriter("D:\\Java50Core\\Bài cuối khóa J50_core\\QuanLySinhVien\\dataOrigin\\sinhvien.txt",true);
			bfw = new BufferedWriter(wr);
				bfw.write(sv.toString());
				bfw.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(bfw!= null) {
				try {
					bfw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//SỬA thông tin Sinh Viên=====================================================
	
	void suaSv(ArrayList<SinhVien> dsSv) {
		Scanner input=new Scanner(System.in);
		String msv;
		int dem;
		do {
			dem=0;
			System.out.println("Nhập MÃ SINH VIÊN cần SỬA:");
			msv=input.nextLine();
			for (int i=0;i<dsSv.size();i++) {
				if(msv.equals(dsSv.get(i).getMsv())==true) {
					break;
				}else {
					dem++;
				}
			}
			if(dem>=dsSv.size()) {
				System.out.println("(!!!)Không có Sinh Viên này");
			}
			
		}while(dem>=dsSv.size());
		SinhVien sv = null;
		String hd = null;
		String ten=null;
		String sn = null;
		msv=dsSv.get(dem).getMsv();
		do {
			try {
				sv = new SinhVien("","","","","");
				sv.setMsv(msv);
				if(hd == null) {
					System.out.print("Nhập họ đệm:");
					hd = input.nextLine();
					sv.setHoDem(hd);
				}else {
					sv.setHoDem(hd);
				}
				if (ten == null) {
					System.out.print("Nhập tên:");
					ten = input.nextLine();
					sv.setTen(ten);
				}else {
					sv.setTen(ten);
				}
				if (sn == null) {
					System.out.print("Nhập ngày sinh:");
					sn = input.nextLine();
					sv.setNgaySinh(sn);
				}else {
					sv.setNgaySinh(sn);
				}
				System.out.print("Nhập giới tính:");
				String gt = input.nextLine();
				sv.setGioiTinh(gt);
				dsSv.set(dem,sv);
			}catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Nhập lại:");
				sv = null;
				if(e instanceof NameException) {
					hd = null;
				}
				if(e instanceof NameException) {
					ten = null;
				}
				if(e instanceof ParseException) {
					sn=null;
				}
			}
		}while(sv == null);
		try {
			File oldFile= new File("D:\\Java50Core\\Bài cuối khóa J50_core\\QuanLySinhVien\\dataOrigin\\sinhvien.txt");
			if(oldFile.delete()) {//xóa file cũ thay bằng file mới giống tên
				File newFile= new File("D:\\\\Java50Core\\\\Bài cuối khóa J50_core\\\\QuanLySinhVien\\\\dataOrigin\\\\sinhvien.txt");
				BufferedWriter bfw=null;
				try {
					FileWriter wr = new FileWriter(newFile,true);
					bfw = new BufferedWriter(wr);
					for (SinhVien sinhVien : dsSv) {
						bfw.write(sinhVien.toString());
						bfw.newLine();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					if(bfw!= null) {
						try {
							bfw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//XÓA Sinh Viên========================================================
	
	void xoaSV(ArrayList<SinhVien> dsSv,ArrayList<Diem> dsDiem) {
		Scanner input=new Scanner(System.in);
		String msv;
		int dem;
		do {
			dem=0;
			System.out.println("Nhập MÃ SINH VIÊN cần XÓA:");
			msv=input.nextLine();
			for (int i=0;i<dsSv.size();i++) {
				if(msv.equals(dsSv.get(i).getMsv())==true) {
					int d=0;
					for (Diem diem : dsDiem) {
						if(diem.getMaSV().equals(dsSv.get(dem).getMsv())==true) {
							System.out.println("(!!!)Không thể Xóa sinh viên ĐÃ HỌC.");
							break;
						}else {
							d++;	
						}
					}if(d>=dsDiem.size()) {
						String ma=dsSv.get(dem).getMsv();
						dsSv.remove(dem);
						System.out.println("(#)XÓA thành công Sinh viên: "+ma);
					}
					break;
				}else {
					dem++;
				}
			}
			if(dem>=dsSv.size()) {
				System.out.println("(!!!)Không có Sinh Viên này");
			}
		}while(dem>=dsSv.size());
		try {
			File oldFile= new File("D:\\Java50Core\\Bài cuối khóa J50_core\\QuanLySinhVien\\dataOrigin\\sinhvien.txt");
			if(oldFile.delete()) {//xóa file cũ thay bằng file mới giống tên
				File newFile= new File("D:\\\\Java50Core\\\\Bài cuối khóa J50_core\\\\QuanLySinhVien\\\\dataOrigin\\\\sinhvien.txt");
				BufferedWriter bfw=null;
				try {
					FileWriter wr = new FileWriter(newFile,true);
					bfw = new BufferedWriter(wr);
					for (SinhVien sinhVien : dsSv) {
						bfw.write(sinhVien.toString());
						bfw.newLine();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					if(bfw!= null) {
						try {
							bfw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//HIỂN THỊ danh sách sinh viên========================================
	
	void hienThidsSv(ArrayList<SinhVien> dsSv) {
		Comparator<SinhVien> comp= new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				return o1.getTen().compareTo(o2.getTen());
			}
		};
		dsSv.sort(comp);
		int soTrang=dsSv.size()/30;
		if(soTrang==0) {
			for (SinhVien sinhVien : dsSv) {
				sinhVien.showInfo();
			}
		}else {
			for(int i=0;i<soTrang;i++) {
				for (int j = 30*i; j < 30*(i+1); j++) {
					dsSv.get(j).showInfo();
					}
				Scanner input =new Scanner(System.in);
				System.out.println("└──────────┴──────────────────────┴────────────────┴────────────┴───────────┘");
				System.out.println("====================================["+(i+1)+"/"+(soTrang+1)+"]===================================");
				int chon=-1;
					try {
						System.out.println("[]Phím bất kì để chuyển trang tiếp");
						System.out.println("0.Thoát.");
						System.out.print("[]Chọn:");
						chon=input.nextInt();
					}catch(InputMismatchException e) {
						System.out.println("");
						input.nextLine();
					}
				if(chon==0) {
					break;
				}
				if(i==soTrang-1) {
					for (int j = 30*soTrang; j < dsSv.size(); j++) {
						dsSv.get(j).showInfo();
					}
					System.out.println("└──────────┴──────────────────────┴────────────────┴────────────┴───────────┘");
					System.out.println("====================================["+(soTrang+1)+"/"+(soTrang+1)+"]===================================");
					System.out.println("(!!!)==>Không thể chuyển trang tiếp");
					break;
				}
			}
		}
		Comparator<SinhVien> comp2=new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				int msv1=Integer.parseInt(o1.getMsv().replaceAll("SV",""));
				int msv2=Integer.parseInt(o2.getMsv().replaceAll("SV",""));
				return msv1>msv2?1:-1;
			}
		};
		dsSv.sort(comp2);
	}
}
