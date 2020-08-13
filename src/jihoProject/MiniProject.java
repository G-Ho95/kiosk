package jihoProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

class Menu extends JFrame {
	// 여기서부터 모양임
	JLabel main = new JLabel(new ImageIcon("menu.png")); // 이미지수정하기
	JButton btExit = new JButton("정산");
	JButton btFile = new JButton("파일");
	JButton btExit2 = new JButton("종료");
	JLabel menu1 = new JLabel(new ImageIcon("buger.png"));// 5000원
	JLabel menu1c = new JLabel("수량");
	JTextField cont1 = new JTextField(3);
	JButton bt1 = new JButton("담기");
	JLabel menu2 = new JLabel(new ImageIcon("chicken.png"));
	JLabel menu2c = new JLabel("수량");
	JTextField cont2 = new JTextField(3);
	JButton bt2 = new JButton("담기");
	JLabel menu3 = new JLabel(new ImageIcon("taco.png"));
	JLabel menu3c = new JLabel("수량");
	JTextField cont3 = new JTextField(3);
	JButton bt3 = new JButton("담기");
	JLabel menu4 = new JLabel(new ImageIcon("cola.png"));
	JLabel menu4c = new JLabel("수량");
	JTextField cont4 = new JTextField(3);
	JButton bt4 = new JButton("담기");
	JLabel box = new JLabel(new ImageIcon("selec.png"));
	JTable list;
	JScrollPane jsp;
	Vector<String> colummNames;
	Vector<Vector<String>> rowData;
	Vector<String> v;
	JButton del = new JButton("취소");
	JLabel pay = new JLabel(new ImageIcon("pay.png"));
	JButton card = new JButton("카드결제");
	JButton cash = new JButton("현금결제");
	// 정산금액 구하기
	int cardTot = 0; // 카드매출금액
	int cashTot = 0; // 현금매출금액
	int orderTot = 0; // 손님주문금액
	// 각 메뉴 판매수량 구하기
	int mm1 = 0;
	int mm2 = 0;
	int mm3 = 0;
	int mm4 = 0;
	int mTot = 0; 

	public Menu() {
		super("지호프로젝트");
		setLayout(null);
		colummNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		colummNames.add("품명");
		colummNames.add("수량");
		colummNames.add("단가");
		colummNames.add("총액");
		list = new JTable(rowData, colummNames);
		jsp = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(50, 595, 270, 150);
		add(jsp);
		add(main).setBounds(0, 20, 300, 80); // 맨위 나중에 수정
		add(btExit).setBounds(265, 52, 70, 40); // 정산버튼
		add(btFile).setBounds(345, 52, 70, 40); // 파일버튼
		add(btExit2).setBounds(425, 52, 70, 40); // 종료버튼
		add(menu1).setBounds(50, 100, 170, 170);
		add(menu1c).setBounds(50, 250, 100, 100);
		add(cont1).setBounds(100, 285, 50, 30);
		add(bt1).setBounds(155, 285, 60, 30);
		add(menu2).setBounds(330, 100, 170, 170);
		add(menu2c).setBounds(330, 250, 100, 100);
		add(cont2).setBounds(380, 285, 50, 30);
		add(bt2).setBounds(435, 285, 60, 30);
		add(menu3).setBounds(50, 330, 170, 170);
		add(menu3c).setBounds(50, 480, 100, 100);
		add(cont3).setBounds(100, 515, 50, 30);
		add(bt3).setBounds(155, 515, 60, 30);
		add(menu4).setBounds(330, 330, 170, 170);
		add(menu4c).setBounds(330, 480, 100, 100);
		add(cont4).setBounds(380, 515, 50, 30);
		add(bt4).setBounds(435, 515, 60, 30);
		add(box).setBounds(50, 560, 180, 30);// 선택한메뉴 이미지 나중에 수정
		add(del).setBounds(240, 560, 80, 30);
		add(pay).setBounds(350, 560, 160, 30);
		add(card).setBounds(350, 595, 160, 60);
		add(cash).setBounds(350, 680, 160, 60);
		setSize(580, 800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == bt1) { // 1번메뉴(햄버거,5000원)담기
					v = new Vector<String>();
					if (cont1.getText().equals("")) {
						noCount();
						return;
					}
					try {
						mTot = Integer.parseInt(cont1.getText());
					} catch (NumberFormatException ne) {
						JOptionPane.showMessageDialog(Menu.this, "숫자만 입력해주세요");
						cont1.setText("");
						return;
					}
					if (mTot <= 0) {
						JOptionPane.showMessageDialog(Menu.this, "1개 이상의 개수를 입력해주세요.");
						cont1.setText("");
						return;
					}

					int orderPlus = meneSum(cont1.getText(), 5000);
					orderTot += orderPlus;

					plusList("햄버거", cont1.getText(), "5000");
					list.updateUI();
					cont1.setText("");

				} else if (e.getSource() == bt2) {// 2번메뉴(치킨,8000원)담기
					v = new Vector<String>();
					if (cont2.getText().equals("")) {
						noCount();
						return;
					}
					try {
						mTot = Integer.parseInt(cont2.getText());
					} catch (NumberFormatException ne) {
						JOptionPane.showMessageDialog(Menu.this, "숫자만 입력해주세요");
						cont2.setText("");
						return;
					}
					if (mTot <= 0) {
						JOptionPane.showMessageDialog(Menu.this, "1개 이상의 개수를 입력해주세요.");
						cont2.setText("");
						return;
					}
					int orderPlus = meneSum(cont2.getText(), 8000);
					orderTot += orderPlus;
					plusList("치킨", cont2.getText(), "8000");
					list.updateUI();
					cont2.setText("");
				} else if (e.getSource() == bt3) {// 3번메뉴(타코,6500원)담기
					v = new Vector<String>();
					if (cont3.getText().equals("")) {
						noCount();
						return;
					}
					try {
						mTot = Integer.parseInt(cont3.getText());
					} catch (NumberFormatException ne) {
						JOptionPane.showMessageDialog(Menu.this, "숫자만 입력해주세요");
						cont3.setText("");
						return;
					}

					if (mTot <= 0) {
						JOptionPane.showMessageDialog(Menu.this, "1개 이상의 개수를 입력해주세요.");
						cont3.setText("");
						return;
					}
					int orderPlus = meneSum(cont3.getText(), 6500);
					orderTot += orderPlus;
					plusList("타코", cont3.getText(), "6500");
					list.updateUI();
					cont3.setText("");
				} else if (e.getSource() == bt4) {// 4번메뉴(콜라,2000원)담기
					v = new Vector<String>();
					if (cont4.getText().equals("")) {
						noCount();
						return;
					}
					try {
						mTot = Integer.parseInt(cont4.getText());
					} catch (NumberFormatException ne) {
						JOptionPane.showMessageDialog(Menu.this, "숫자만 입력해주세요");
						cont4.setText("");
						return;
					}

					if (mTot <= 0) {
						JOptionPane.showMessageDialog(Menu.this, "1개 이상의 개수를 입력해주세요.");
						cont4.setText("");
						return;
					}
					int orderPlus = meneSum(cont4.getText(), 2000);
					orderTot += orderPlus;
					plusList("콜라", cont4.getText(), "2000");
					list.updateUI();
					cont4.setText("");
				} else if (e.getSource() == del) {// 취소버튼

					int selection = list.getSelectedRow();
					if (list.getSelectedRow() == -1) { // 예외처리
						JOptionPane.showMessageDialog(Menu.this, "삭제할 메뉴를 선택해주세요!");
						return;
					}

					try {
						rowData.remove(selection);
					} catch (Exception ie) {
						JOptionPane.showMessageDialog(Menu.this, "삭제할 메뉴를 선택해주세요!");
					}

					orderTot = 0;
					list.updateUI();
				} else if (e.getSource() == card) { // 카드결제버튼
					if (orderTot == 0) {
						JOptionPane.showMessageDialog(Menu.this, "결제할 메뉴를 담아주세요~!");
						return;
					}
					int result = JOptionPane.showConfirmDialog(Menu.this, "결제금액은 " + orderTot + "원 입니다.", "카드결제",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) { // 뉑
						cardTot += orderTot; // 카드 매출 더하기
						menuCount();
						JOptionPane.showMessageDialog(Menu.this, "결제되었습니다! 안녕히가세요~!");
						rowData.removeAllElements();// 결제다 되면 리스트 전체 지우기
						list.updateUI();
					} else {
						return;
					}
					orderTot = 0;// 손님 결제금액 다시 0으로 초기화함
				} else if (e.getSource() == cash) { // 현금결제버튼
					if (orderTot == 0) {
						JOptionPane.showMessageDialog(Menu.this, "결제할 메뉴를 담아주세요~!");
						return;
					}
					String input = JOptionPane.showInputDialog(Menu.this,
							"결제금액은 " + orderTot + "원 입니다. 지불할 금액을 입력하세요.  ");
					if (input.equals("")) {
						JOptionPane.showMessageDialog(Menu.this, "돈을 내주세여!!!");
						return;
					}
					int money = Integer.parseInt(input);
					if (money > orderTot) { // 낸돈이 크면
						int a = money - orderTot;
						cashTot += orderTot;// 주문금액 현금매출에 더하기
						JOptionPane.showMessageDialog(Menu.this, "거스름돈 " + a + "원 받으세요~");
						JOptionPane.showMessageDialog(Menu.this, "감사합니다! 안녕히가세요!");
						
						menuCount();
						orderTot = 0;// 손님결제금액 다시 초기화
						rowData.removeAllElements();// 결제다 되면 리스트 전체 지우기
						list.updateUI();
					} else if (money == orderTot) {// 금액이 같으면
						JOptionPane.showMessageDialog(Menu.this, "감사합니다! 안녕히가세요!");
						cashTot += orderTot;
						orderTot = 0;// 손님결제금액 다시 초기화
						menuCount();
						rowData.removeAllElements();// 결제다 되면 리스트 전체 지우기
						list.updateUI();
					} else if (money < orderTot) {// 금액이 작으면
						JOptionPane.showMessageDialog(Menu.this, "돈이 부족합니다!!!!더 내주세요!");
					}
				}
			}
		};
		bt1.addActionListener(listener);
		bt2.addActionListener(listener);
		bt3.addActionListener(listener);
		bt4.addActionListener(listener);
		del.addActionListener(listener);
		card.addActionListener(listener);
		cash.addActionListener(listener);
		ActionListener listener2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int allTot = cardTot + cashTot;
				if (e.getSource() == btExit) { // 정산버튼
					String pw = JOptionPane.showInputDialog(Menu.this, "관리자 번호를 입력해주세요.");
					if (pw == null)
						return;
					if (pw.equals("1234")) {
						JOptionPane.showMessageDialog(Menu.this,
								"카드매출:" + cardTot + "\n" + "현금매출:" + cashTot + "\n" + "총 매출액:" + allTot); // 총 매출액 보여주기
						Date today = new Date();
						SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
						String dd = date.format(today); // 날짜
						try {
							File f = new File("C:\\정산");
							if (f.exists()) { // 파일 오늘날짜로 저장함
								BufferedWriter bw = new BufferedWriter(new FileWriter(f + "\\" + dd + ".txt"));
								bw.write("카드매출 : " + cardTot + "원\r\n");
								bw.write("현금매출 : " + cashTot + "원\r\n");
								bw.write("총매출 : " + allTot + "원\r\n");
								bw.write("햄버거 판매수량:" + mm1 + "개\r\n");
								bw.write("치킨 판매수량:" + mm2 + "개\r\n");
								bw.write("타코 판매수량:" + mm3 + "개\r\n");
								bw.write("콜라 판매수량:" + mm4 + "개\r\n");
								bw.flush();
								bw.close();
								JOptionPane.showMessageDialog(Menu.this, "정산파일 저장완료!");
							} else {
								f.mkdirs(); // 파일이 없으면 맨듬
								BufferedWriter bw = new BufferedWriter(new FileWriter(f + "\\" + dd + ".txt"));
								bw.write("카드매출 : " + cardTot + "원\r\n");
								bw.write("현금매출 : " + cashTot + "원\r\nn");
								bw.write("총매출 : " + allTot + "원\r\n");
								bw.write("햄버거 판매수량:" + mm1 + "개\r\n");
								bw.write("치킨 판매수량:" + mm2 + "개\r\n");
								bw.write("타코 판매수량:" + mm3 + "개\r\n");
								bw.write("콜라 판매수량:" + mm4 + "개\r\n");
								bw.flush();
								bw.close();
								JOptionPane.showMessageDialog(Menu.this, "정산파일 저장완료!");
							}
						} catch (IOException ie) {
							System.out.println(ie.getMessage());
						}
					} else if (!pw.equals("1234")) {
						JOptionPane.showMessageDialog(Menu.this, "관리자번호가 틀렸습니다.");
					}

				} else if (e.getSource() == btFile) { // 파일버튼
					String pw = JOptionPane.showInputDialog(Menu.this, "관리자 번호를 입력해주세요.");
					if (pw == null)
						return;
					if (pw.equals("1234")) {
						new MiniProject2();
					} else if (!pw.equals("1234")) {
						JOptionPane.showMessageDialog(Menu.this, "관리자번호가 틀렸습니다.");
					}
				} else if (e.getSource() == btExit2) { // 장사종료버튼
					String pw = JOptionPane.showInputDialog(Menu.this, "관리자 번호를 입력해주세요.");
					if (pw == null)
						return;
					if (pw.equals("1234")) {
						int result = JOptionPane.showConfirmDialog(Menu.this, "장사를 종료할까요?!", "종료창",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) { // 뉑
							JOptionPane.showMessageDialog(Menu.this, "장사를 종료합니다!!!");
							System.exit(0);
						} else if (result == JOptionPane.NO_OPTION) { // 아니오
							return;
						}
					} else if (!pw.equals("1234")) {
						JOptionPane.showMessageDialog(Menu.this, "관리자번호가 틀렸습니다.");
					}
				}
			}
		};
		btExit.addActionListener(listener2);
		btFile.addActionListener(listener2);
		btExit2.addActionListener(listener2);
	}

	public void noCount() { // 숫자입력x창나오는거 메소드
		JOptionPane.showMessageDialog(Menu.this, "수량을 입력해주세요!!!");
	}
	
	public void menuCount(){ //각메뉴 판매수량 구하는 메소드
		for(int i=0;i<rowData.size();i++) {
			Vector<String> f=rowData.get(i);
			if(f.get(0).equals("햄버거")) {
				int b=Integer.parseInt(f.get(1));
				mm1=+b;
			}else if(f.get(0).equals("치킨")) {
				int b=Integer.parseInt(f.get(1));
				mm2=+b;
			}else if(f.get(0).equals("타코")) {
				int b=Integer.parseInt(f.get(1));
				mm3=+b;
			}else if(f.get(0).equals("콜라")) {
				int b=Integer.parseInt(f.get(1));
				mm4=+b;
			}
		}
	}

	public void plusList(String mName, String cM, String p) { // 리스트에 추가하는거 메소드
		v.add(mName);// 메뉴이름
		v.add(cM);// 개수
		v.add(p + "원");// 가격
		int a = Integer.parseInt(cM);
		int b = Integer.parseInt(p);
		int tot1 = a * b;
		String tot2 = Integer.toString(tot1);
		v.add(tot2 + "원");
		rowData.add(v); // 위에 저장된 백터 rowData에 담기
	}

	public int meneSum(String countM, int pri) {// 메뉴카운트, 각 메뉴가격
		int con = Integer.parseInt(countM);
		int m1 = pri * con;
		return m1;
	}
}

public class MiniProject {
	public static void main(String[] args) {
		new Menu();
		// new MiniProject2();
	}
}
