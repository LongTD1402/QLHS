import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		QuanlySinhVien qlSv=new QuanlySinhVien();
		ArrayList<SinhVien> listSv=new ArrayList<SinhVien>();
		qlSv.loadDatasv(listSv);
		
		QuanLyMonHoc qlMh=new QuanLyMonHoc();
		ArrayList<MonHoc> listMh=new ArrayList<MonHoc>();
		qlMh.loadDataMH(listMh);
		
		QuanLyDiem qlDiem=new QuanLyDiem();
		ArrayList<Diem> listDiem=new ArrayList<Diem>();
		qlDiem.loadDatadiem(listDiem);
		
		printMenu(qlSv,listSv,qlMh, listMh, qlDiem, listDiem);
	}
	private static void printMenu(QuanlySinhVien qlSv,ArrayList<SinhVien> dsSv,QuanLyMonHoc qlMh,
			ArrayList<MonHoc> dsMh,QuanLyDiem qlDiem,ArrayList<Diem> dsDiem) {
		int chon=-1;
		Scanner input=new Scanner(System.in);
		do {
			System.out.println("┌──────────────────────────────────────┐");
			System.out.println("│                MENU                  │");//Menu chính
			System.out.println("├──────────────────────────────────────┤");
			System.out.println("│1.Cập nhật danh sách                  │");
			System.out.println("│2.Hiển thị bảng điểm                  │");
			System.out.println("│3.Tìm kiếm                            │");
			System.out.println("│0.Thoát                               │");
			System.out.println("└──────────────────────────────────────┘");
			try {
				System.out.print("[]Nhập lựa chọn:");
				chon=input.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("(!!!)Nhập sai (@_@)-->Nhập lại:");
				input.nextLine();
			}
			switch (chon) {
			case 1:
				printMenu1(qlSv,dsSv,qlMh, dsMh, qlDiem, dsDiem);
				break;
			case 2:
				printMenu2(qlSv, dsSv, qlMh, dsMh, qlDiem, dsDiem);
				break;
			case 3:
				printMenu3(qlSv, dsSv, qlMh, dsMh, qlDiem, dsDiem);
				break;
			case 0:
				break;
			default:
				System.out.println("(!!!)Không có lựa chọn này!");
			}
		}while(chon!=0);
	}

	private static void printMenu1(QuanlySinhVien qlSv,ArrayList<SinhVien> dsSv,QuanLyMonHoc qlMh,
			ArrayList<MonHoc> dsMh,QuanLyDiem qlDiem,ArrayList<Diem> dsDiem) {     // Menu CẬP NHẬT DANH SÁCH
		int chon1=-1;
		Scanner input1=new Scanner(System.in);
		do {
			System.out.println("┌──────────────────────────────────────┐");
			System.out.println("│         CẬP NHẬT DANH SÁCH           │");
			System.out.println("├──────────────────────────────────────┤");
			System.out.println("│1.Cập nhật danh sách sinh viên        │");
			System.out.println("│2.Hiển thị danh sách môn học          │");
			System.out.println("│0.Trở về MENU trước                   │");
			System.out.println("└──────────────────────────────────────┘");
			try {
				System.out.print("[]Nhập lựa chọn:");
				chon1=input1.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("(!!!)Nhập sai (@_@)-->Nhập lại:");
				input1.nextLine();
			}
			switch(chon1) {
			case 1:
				printMenu11(qlSv,dsSv,qlMh, dsMh, qlDiem, dsDiem);
				break;
			case 2:
				printMenu12( qlSv, dsSv, qlMh, dsMh, qlDiem, dsDiem);
				break;
			case 0:
				System.out.println("(!!!)Trở về ^");
				printMenu(qlSv,dsSv, qlMh, dsMh, qlDiem, dsDiem);
			}
		}while(chon1!=0);
	}

	private static void printMenu11(QuanlySinhVien qlSv,ArrayList<SinhVien> dsSv,QuanLyMonHoc qlMh,
			ArrayList<MonHoc> dsMh,QuanLyDiem qlDiem,ArrayList<Diem> dsDiem) {   //Menu CẬP NHẬT DANH SÁCH SINH VIÊN
		int chon11=-1;
		Scanner input11=new Scanner(System.in);
		do {
			System.out.println("┌──────────────────────────────────────┐");
			System.out.println("│          DANH SÁCH SINH VIÊN         │");
			System.out.println("├──────────────────────────────────────┤");
			System.out.println("│1.Thêm sinh viên                      │");
			System.out.println("│2.Sửa thông tin sinh viên             │");
			System.out.println("│3.Xóa sinh viên                       │");
			System.out.println("│4.Hiển thị danh sách                  │");
			System.out.println("│0.Trở về MENU trước                   │");
			System.out.println("└──────────────────────────────────────┘");
			System.out.print("[]Nhập lựa chọn:");
			try {
				chon11=input11.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("(!!!)Nhập sai (@_@)-->Nhập lại:");
				input11.nextLine();
			}
			switch(chon11) {
			case 1:
				qlSv.themSV(dsSv);
				System.out.println("(#)THÊM thành công:D");
				
				break;
			case 2:
				qlSv.suaSv(dsSv);
				System.out.println("(#)SỬA thành công");
				break;
			case 3:
				qlSv.xoaSV(dsSv,dsDiem);
				break;
			case 4:
				System.out.println("*Danh sách SINH VIÊN sắp xếp theo tên:");
				System.out.println("┌──────────┬──────────────────────┬────────────────┬────────────┬───────────┐");
				System.out.println("│  Mã SV   │        Họ đệm        │      Tên       │  Ngày sinh │ Giới tính │");
//				System.out.println("├──────────┼──────────────────────┼────────────────┼────────────┼───────────┤");
				qlSv.hienThidsSv(dsSv);
				break;
			case 0:
				System.out.println("Trở về ^");
				printMenu1(qlSv,dsSv,null, null, null, dsDiem);
			}
		}while(chon11!=0);
	}

	private static void printMenu12(QuanlySinhVien qlSv,ArrayList<SinhVien> dsSv,QuanLyMonHoc qlMh,
			ArrayList<MonHoc> dsMh,QuanLyDiem qlDiem,ArrayList<Diem> dsDiem) {      //Menu CẬP NHẬT DANH SACH MÔN HỌC
		int chon12=-1;
		Scanner input12=new Scanner(System.in);
		do {
			System.out.println("┌──────────────────────────────────────┐");
			System.out.println("│          DANH SÁCH MÔN HỌC           │");
			System.out.println("├──────────────────────────────────────┤");
			System.out.println("│1.Hiển thị danh sách                  │");
			System.out.println("│0.Trở về MENU trước                   │");
			System.out.println("└──────────────────────────────────────┘");
			System.out.print("[]Nhập lựa chọn:");
			try {
				chon12=input12.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("(!!!)Nhập sai (@_@)-->Nhập lại:");
				input12.nextLine();
			}
			switch(chon12) {
			case 1:
				qlMh.hienThidsmonhoc(dsMh);
				break;
			case 0:
				System.out.println("(!!!)Trở về ^");
				printMenu1 (qlSv, dsSv, qlMh, dsMh, qlDiem, dsDiem);
			}
		}while(chon12!=0);
	}

	

	private static void printMenu2(QuanlySinhVien qlSv,ArrayList<SinhVien> dsSv,QuanLyMonHoc qlMh,
			ArrayList<MonHoc> dsMh,QuanLyDiem qlDiem,ArrayList<Diem> dsDiem) {    //Menu BẢNG ĐIỂM
		int chon2=-1;
		Scanner input2=new Scanner(System.in);
		do {
			System.out.println("┌──────────────────────────────────────┐");
			System.out.println("│              BẢNG ĐIỂM               │");
			System.out.println("├──────────────────────────────────────┤");
			System.out.println("│1.Bảng điểm theo danh sách sinh viên  │");
			System.out.println("│0.Trở về MENU trước                   │");
			System.out.println("└──────────────────────────────────────┘");
			System.out.print("[]Nhập lựa chọn:");
			try {
				chon2=input2.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("(!!!)Nhập sai (@_@)-->Nhập lại:");
				input2.nextLine();
			}
			switch(chon2) {
			case 1:
				qlDiem.hienThidsDiem(dsSv, dsMh, dsDiem);
				break;
			case 2:
				System.out.println("thực hiện case 2");
				break;
			case 0:
				System.out.println("(!!!)Trở về ^");
				printMenu( qlSv, dsSv, qlMh, dsMh, qlDiem, dsDiem);
			}
		}while (chon2!=0);
	}

	private static void printMenu3(QuanlySinhVien qlSv,ArrayList<SinhVien> dsSv,QuanLyMonHoc qlMh,
			ArrayList<MonHoc> dsMh,QuanLyDiem qlDiem,ArrayList<Diem> dsDiem) {     //Menu TÌM KIẾM
		int chon3=-1;
		Scanner input3= new Scanner(System.in);
		do {
			System.out.println("┌──────────────────────────────────────┐");
			System.out.println("│               TÌM KIẾM               │");
			System.out.println("├──────────────────────────────────────┤");
			System.out.println("│1.Tìm kiếm theo MÃ sinh viên          │");
			System.out.println("│2.Tìm kiếm theo TÊN sinh viên         │");
			System.out.println("│0.Trở về MENU trước                   │");
			System.out.println("└──────────────────────────────────────┘");
			System.out.print("[]Nhập lựa chọn:");
			try {
				chon3=input3.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("(!!!)Nhập sai (@_@)-->Nhập lại:");
				input3.nextLine();
			}
			switch(chon3) {
			case 1:
				Scanner input301=new Scanner(System.in);
				int dem=0;
				System.out.println("Nhập mã sinh viên cần tìm:");
				String msv=input301.nextLine();
				for (SinhVien sv : dsSv) {
					if(msv.equals(sv.getMsv())==true) {
						qlDiem.thongTinSV(sv, dsMh, dsDiem);
						break;
					}else {
								dem++;
						}
				}
				if(dem>=dsSv.size()) {
					System.out.println("(!!!)Không có mã sinh viên này.");
				}
				break;
			case 2:
				Scanner input302=new Scanner(System.in);
				System.out.print("[]Nhập tên sinh viên:");
				String ten=input302.nextLine();
				System.out.println("Danh sách sinh viên có tên ["+ten+"]:");
				System.out.println("┌──────────┬──────────────────────┬────────────────┬────────────┬───────────┐");
				System.out.println("│  Mã SV   │        Họ đệm        │      Tên       │  Ngày sinh │ Giới tính │");
				qlDiem.dsSinhvientheoTEN(ten,dsSv,dsMh,dsDiem);
				break;
			case 0:
				System.out.println("(!!!)Trở về ^");
				printMenu(qlSv, dsSv, qlMh, dsMh, qlDiem, dsDiem);
			}
		}while (chon3!=0);
	}

}
