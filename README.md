# Java_2020



## Sliding Puzzle

Build a sliding puzzle with 3x3 grid.
The game board will have number blocks of 1 to 8, and they will be randomly arranged in the grid board.
The player can click the block. If the block has an empty space next to it, it moves to that empty space. If there is no space, it simply doesn't move.
The goal of the game is to move the blocks in order to make the number aligned in order.
1 2 3
4 5 6
7 8

With the restaret button you can start a new game.




## Theater Reservation Program

/*
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
