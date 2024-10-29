/*
�䱸����
- ���� ���� �ý����� Theater Ŭ������ �ۼ��ϰ� TheaterTest Ŭ������ �׽�Ʈ�Ѵ�.
- TheaterTest Ŭ�������� Theater Ŭ������ ��ü�� �����ϰ� ���忹��ý����� �����Ų��.
- Theater Ŭ������ ��� �ʵ�� private ����� �����Ѵ�.
- �����ڴ� ����Ʈ �����ڸ� �����Ͽ� 2�� �̻� �ߺ� �����Ѵ�.
- ���� ���� �ý����� �޴��� ����(1), ��ȸ(2), ���(3), ����(4)�� �ִ�.
- ������ �� ���� �� �ڸ��� ������ �� �ְ� �¼� Ÿ��(A��(1), B��(2))�� �¼� ��ȣ(1~10)�� ������� �Է� �޾� �����Ѵ�. 
    ��, �̹� ����� �¼��� ������ �� ����. ���� �Ŀ��� ����� �¼�Ÿ���� �¼� ��Ȳ�� ǥ���Ѵ�.
- ��ȸ�� ��� Ÿ���� �¼� ��Ȳ�� ǥ���Ѵ�. (�����¼� 1, �����¼� 0)
- ��Ҵ� ����� �¼� Ÿ�԰� �¼� ��ȣ�� ������� �Է� �޾� ����Ѵ�. 
    ��, ������� ���� �¼��� ����� �� ����. 
    ��� �Ŀ��� ��ҵ� �¼� Ÿ���� �¼� ��Ȳ�� ǥ���Ѵ�.
- ����� ��� �� ���� Ÿ�԰� ���� ��ȣ�� ��� ���� �޽����� ����ϰ� ����ڰ� �ٽ� �Է��ϵ��� �Ѵ�.
- ���� �䱸�� ���� ������ ���α׷��� �ݺ� �����ϰ� ���� �䱸�� ���α׷��� �����Ѵ�.
- ���α׷��� ���� ���� �����Ͽ� ���� ���� �ý��� ���α׷��� �ۼ��Ѵ�.
- ��������: TheaterTest.java
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
		System.out.println("���� �¼� ���� �ý����Դϴ�.");
	}

	
	//�¼� ��ȸ
	public void Show() {
		for (int i = 0; i<SeatT.length; i++)
		System.out.println(SeatT[i]);
		
		System.out.print("A��: ");
		for (int i = 0; i<10; i++)
		System.out.print(seats[0][i] + " ");
		
		System.out.println();
		System.out.println(SeatT[0]);
		
		System.out.print("B��: ");
		for (int i = 0; i<10; i++)
		System.out.print(seats[1][i] + " ");
		
		System.out.println();
		System.out.println(SeatT[0]);
	}
	
	// �¼� ���� ��Ȳ
	public void Seat() {
		System.out.println("�¼� ���� ��Ȳ�Դϴ�. (���¼�:0, �����¼�:1)");
		Show();
	}
	
	// �¼� ����
	public void Reserve() {
		Seat();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�¼� ������ �����մϴ�.");
		
		err = false;
		while (!err) {
			System.out.print("�¼� ����� �����ϼ���(A��:1, B��:2): ");
			int grade = sc.nextInt();
			System.out.print("�¼� ��ȣ�� �����ϼ���(1~10): ");
			int col = sc.nextInt();
			
			try {
				sold = seats[grade-1][col-1];
			}
			catch(ArrayIndexOutOfBoundsException e) {
				err = true;
			}
			
			if (err==false) {
			  if (sold==1)
				  System.out.println("�̹� ����� �¼��Դϴ�.");
				
			  else {
				seats[grade-1][col-1] = 1;
				for (int i = 0; i<SeatT.length; i++)
					System.out.println(SeatT[i]);
				
				if (grade==1)
					System.out.print("A��: ");
				else
					System.out.print("B��: ");
				
				for (int i = 0; i<10; i++)
				System.out.print(seats[grade-1][i] + " ");
	
				System.out.println();
				System.out.println(SeatT[0]);
				System.out.println("����Ǿ����ϴ�.");
				err = true;
			  }
			}
			else {
				System.out.println("���� �߻�! �ٽ� �Է��ϼ���.");
				err=false;
			}
		}
	}
	
	//�¼� ���
	public void Cancel() {
		Seat();
		Scanner s = new Scanner(System.in);
		
		System.out.println("�¼� ��Ҹ� �����մϴ�.");
		
		err = false;
		int sum = 0;
		for (int i=0; i<10; i++) {
			sum = sum + seats[0][i]+seats[1][i];
		}
		if (sum==0) {
			System.out.println("����� �˼��� �����ϴ�.");
			err = true;
		}
		else 
			err = false;
		
		while (!err) {
			System.out.print("�¼� ����� �����ϼ���(A��:1, B��:2): ");
			int grade = s.nextInt();
			System.out.print("�¼� ��ȣ�� �����ϼ���(1~10): ");
			int col = s.nextInt();
			
			try {
				sold = seats[grade-1][col-1];
			}
			catch(ArrayIndexOutOfBoundsException e) {
				err = true;
			}
			
			if (err==false) {
				  if (sold==0)
					  System.out.println("����� �¼��� �����ϴ�.");
					
				  else {
					seats[grade-1][col-1] = 0;
					for (int i = 0; i<SeatT.length; i++)
						System.out.println(SeatT[i]);
					
					if (grade==1)
						System.out.print("A��: ");
					else
						System.out.print("B��: ");
					
					for (int i = 0; i<10; i++)
					System.out.print(seats[grade-1][i] + " ");
		
					System.out.println();
					System.out.println(SeatT[0]);
					System.out.println("��ҵǾ����ϴ�.");
					err = true;
				  }
				}
			else {
				System.out.println("���� �߻�! �ٽ� �Է��ϼ���.");
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
			System.out.print("��ȣ�� �����ϼ���(����:1, ��ȸ:2, ���:3, ����:4): ");
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
				System.out.println("�ý����� �����մϴ�.");
				book = false;
				break;
			
			default:
				System.out.println("���� : �Է��� �� ���� �����Դϴ�. �ٽ� �Է��ϼ���.");
				break;
			}
		}
		

	}

}
