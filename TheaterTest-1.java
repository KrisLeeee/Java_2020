/*
요구사항
- 극장 예약 시스템을 Theater 클래스로 작성하고 TheaterTest 클래스로 테스트한다.
- TheaterTest 클래스에서 Theater 클래스의 객체를 생성하고 극장예약시스템을 실행시킨다.
- Theater 클래스의 모든 필드는 private 멤버로 지정한다.
- 생성자는 디폴트 생성자를 포함하여 2개 이상 중복 정의한다.
- 극장 예약 시스템의 메뉴는 예약(1), 조회(2), 취소(3), 종료(4)가 있다.
- 예약은 한 번에 한 자리만 예약할 수 있고 좌석 타입(A석(1), B석(2))과 좌석 번호(1~10)를 순서대로 입력 받아 예약한다. 
    단, 이미 예약된 좌석은 예약할 수 없다. 예약 후에는 예약된 좌석타입의 좌석 현황을 표시한다.
- 조회는 모든 타입의 좌석 현황을 표시한다. (예약좌석 1, 오픈좌석 0)
- 취소는 예약된 좌석 타입과 좌석 번호를 순서대로 입력 받아 취소한다. 
    단, 예약되지 않은 좌석은 취소할 수 없다. 
    취소 후에는 취소된 좌석 타입의 좌석 현황을 표시한다.
- 예약과 취소 시 없는 타입과 없는 번호의 경우 오류 메시지를 출력하고 사용자가 다시 입력하도록 한다.
- 종료 요구가 있을 때까지 프로그램을 반복 실행하고 종료 요구에 프로그램을 종료한다.
- 프로그램의 실행 예를 참고하여 극장 예약 시스템 프로그램을 작성한다.
- 제출파일: TheaterTest.java
*/
import java.util.*;

class Theater {
	private boolean err, book;
	private int sold, sum;
	private int[][] seats = new int[2][10];
	private String[] SeatT = {"-------------------------",
							  "    1 2 3 4 5 6 7 8 9 10",
							  "-------------------------"};
	
	public Theater(int sold) {
		this.sold = sold;
	}
	
	public Theater() {
		this(0);
		System.out.println("극장 좌석 예약 시스템입니다.");
	}

	
	//좌석 조회
	public void Show() {
		for (int i = 0; i<SeatT.length; i++)
		System.out.println(SeatT[i]);
		
		System.out.print("A석: ");
		for (int i = 0; i<10; i++)
		System.out.print(seats[0][i] + " ");
		
		System.out.println();
		System.out.println(SeatT[0]);
		
		System.out.print("B석: ");
		for (int i = 0; i<10; i++)
		System.out.print(seats[1][i] + " ");
		
		System.out.println();
		System.out.println(SeatT[0]);
	}
	
	// 좌석 예약 현황
	public void Seat() {
		System.out.println("좌석 예약 현황입니다. (빈좌석:0, 예약좌석:1)");
		Show();
	}
	
	// 좌석 예약
	public void Reserve() {
		Seat();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("좌석 예약을 진행합니다.");
		
		err = false;
		while (!err) {
			System.out.print("좌석 등급을 선택하세요(A석:1, B석:2): ");
			int grade = sc.nextInt();
			System.out.print("좌석 번호를 선택하세요(1~10): ");
			int col = sc.nextInt();
			
			try {
				sold = seats[grade-1][col-1];
			}
			catch(ArrayIndexOutOfBoundsException e) {
				err = true;
			}
			
			if (err==false) {
			  if (sold==1)
				  System.out.println("이미 예약된 좌석입니다.");
				
			  else {
				seats[grade-1][col-1] = 1;
				for (int i = 0; i<SeatT.length; i++)
					System.out.println(SeatT[i]);
				
				if (grade==1)
					System.out.print("A석: ");
				else
					System.out.print("B석: ");
				
				for (int i = 0; i<10; i++)
				System.out.print(seats[grade-1][i] + " ");
	
				System.out.println();
				System.out.println(SeatT[0]);
				System.out.println("예약되었습니다.");
				err = true;
			  }
			}
			else {
				System.out.println("오류 발생! 다시 입력하세요.");
				err=false;
			}
		}
	}
	
	//좌석 취소
	public void Cancel() {
		Seat();
		Scanner s = new Scanner(System.in);
		
		System.out.println("좌석 취소를 진행합니다.");
		
		err = false;
		int sum = 0;
		for (int i=0; i<10; i++) {
			sum = sum + seats[0][i]+seats[1][i];
		}
		if (sum==0) {
			System.out.println("취소할 죄석이 없습니다.");
			err = true;
		}
		else 
			err = false;
		
		while (!err) {
			System.out.print("좌석 등급을 선택하세요(A석:1, B석:2): ");
			int grade = s.nextInt();
			System.out.print("좌석 번호를 선택하세요(1~10): ");
			int col = s.nextInt();
			
			try {
				sold = seats[grade-1][col-1];
			}
			catch(ArrayIndexOutOfBoundsException e) {
				err = true;
			}
			
			if (err==false) {
				  if (sold==0)
					  System.out.println("예약된 좌석이 없습니다.");
					
				  else {
					seats[grade-1][col-1] = 0;
					for (int i = 0; i<SeatT.length; i++)
						System.out.println(SeatT[i]);
					
					if (grade==1)
						System.out.print("A석: ");
					else
						System.out.print("B석: ");
					
					for (int i = 0; i<10; i++)
					System.out.print(seats[grade-1][i] + " ");
		
					System.out.println();
					System.out.println(SeatT[0]);
					System.out.println("취소되었습니다.");
					err = true;
				  }
				}
			else {
				System.out.println("오류 발생! 다시 입력하세요.");
				err=false;
			}
			
		}
		
	}
	
}

public class TheaterTest {

	public static void main(String[] args) {
		
		Scanner number = new Scanner(System.in);
		Theater obj = new Theater();
		
		boolean book = true;
		while (book) {
			System.out.print("번호를 선택하세요(예약:1, 조회:2, 취소:3, 종료:4): ");
			int n = number.nextInt();
			
			switch (n) {
			case 1:
				obj.Reserve();
				break;
			
			case 2:
				obj.Show();
				break;
			
			case 3:
				obj.Cancel();
				break;
			
			case 4:
				System.out.println("시스템을 종료합니다.");
				book = false;
				break;
			
			default:
				System.out.println("오류 : 입력할 수 없는 숫자입니다. 다시 입력하세요.");
				break;
			}
		}
		

	}

}
