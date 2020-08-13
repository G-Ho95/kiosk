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
	// ���⼭���� �����
	JLabel main = new JLabel(new ImageIcon("menu.png")); // �̹��������ϱ�
	JButton btExit = new JButton("����");
	JButton btFile = new JButton("����");
	JButton btExit2 = new JButton("����");
	JLabel menu1 = new JLabel(new ImageIcon("buger.png"));// 5000��
	JLabel menu1c = new JLabel("����");
	JTextField cont1 = new JTextField(3);
	JButton bt1 = new JButton("���");
	JLabel menu2 = new JLabel(new ImageIcon("chicken.png"));
	JLabel menu2c = new JLabel("����");
	JTextField cont2 = new JTextField(3);
	JButton bt2 = new JButton("���");
	JLabel menu3 = new JLabel(new ImageIcon("taco.png"));
	JLabel menu3c = new JLabel("����");
	JTextField cont3 = new JTextField(3);
	JButton bt3 = new JButton("���");
	JLabel menu4 = new JLabel(new ImageIcon("cola.png"));
	JLabel menu4c = new JLabel("����");
	JTextField cont4 = new JTextField(3);
	JButton bt4 = new JButton("���");
	JLabel box = new JLabel(new ImageIcon("selec.png"));
	JTable list;
	JScrollPane jsp;
	Vector<String> colummNames;
	Vector<Vector<String>> rowData;
	Vector<String> v;
	JButton del = new JButton("���");
	JLabel pay = new JLabel(new ImageIcon("pay.png"));
	JButton card = new JButton("ī�����");
	JButton cash = new JButton("���ݰ���");
	// ����ݾ� ���ϱ�
	int cardTot = 0; // ī�����ݾ�
	int cashTot = 0; // ���ݸ���ݾ�
	int orderTot = 0; // �մ��ֹ��ݾ�
	// �� �޴� �Ǹż��� ���ϱ�
	int mm1 = 0;
	int mm2 = 0;
	int mm3 = 0;
	int mm4 = 0;
	int mTot = 0; 

	public Menu() {
		super("��ȣ������Ʈ");
		setLayout(null);
		colummNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		colummNames.add("ǰ��");
		colummNames.add("����");
		colummNames.add("�ܰ�");
		colummNames.add("�Ѿ�");
		list = new JTable(rowData, colummNames);
		jsp = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(50, 595, 270, 150);
		add(jsp);
		add(main).setBounds(0, 20, 300, 80); // ���� ���߿� ����
		add(btExit).setBounds(265, 52, 70, 40); // �����ư
		add(btFile).setBounds(345, 52, 70, 40); // ���Ϲ�ư
		add(btExit2).setBounds(425, 52, 70, 40); // �����ư
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
		add(box).setBounds(50, 560, 180, 30);// �����Ѹ޴� �̹��� ���߿� ����
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

				if (e.getSource() == bt1) { // 1���޴�(�ܹ���,5000��)���
					v = new Vector<String>();
					if (cont1.getText().equals("")) {
						noCount();
						return;
					}
					try {
						mTot = Integer.parseInt(cont1.getText());
					} catch (NumberFormatException ne) {
						JOptionPane.showMessageDialog(Menu.this, "���ڸ� �Է����ּ���");
						cont1.setText("");
						return;
					}
					if (mTot <= 0) {
						JOptionPane.showMessageDialog(Menu.this, "1�� �̻��� ������ �Է����ּ���.");
						cont1.setText("");
						return;
					}

					int orderPlus = meneSum(cont1.getText(), 5000);
					orderTot += orderPlus;

					plusList("�ܹ���", cont1.getText(), "5000");
					list.updateUI();
					cont1.setText("");

				} else if (e.getSource() == bt2) {// 2���޴�(ġŲ,8000��)���
					v = new Vector<String>();
					if (cont2.getText().equals("")) {
						noCount();
						return;
					}
					try {
						mTot = Integer.parseInt(cont2.getText());
					} catch (NumberFormatException ne) {
						JOptionPane.showMessageDialog(Menu.this, "���ڸ� �Է����ּ���");
						cont2.setText("");
						return;
					}
					if (mTot <= 0) {
						JOptionPane.showMessageDialog(Menu.this, "1�� �̻��� ������ �Է����ּ���.");
						cont2.setText("");
						return;
					}
					int orderPlus = meneSum(cont2.getText(), 8000);
					orderTot += orderPlus;
					plusList("ġŲ", cont2.getText(), "8000");
					list.updateUI();
					cont2.setText("");
				} else if (e.getSource() == bt3) {// 3���޴�(Ÿ��,6500��)���
					v = new Vector<String>();
					if (cont3.getText().equals("")) {
						noCount();
						return;
					}
					try {
						mTot = Integer.parseInt(cont3.getText());
					} catch (NumberFormatException ne) {
						JOptionPane.showMessageDialog(Menu.this, "���ڸ� �Է����ּ���");
						cont3.setText("");
						return;
					}

					if (mTot <= 0) {
						JOptionPane.showMessageDialog(Menu.this, "1�� �̻��� ������ �Է����ּ���.");
						cont3.setText("");
						return;
					}
					int orderPlus = meneSum(cont3.getText(), 6500);
					orderTot += orderPlus;
					plusList("Ÿ��", cont3.getText(), "6500");
					list.updateUI();
					cont3.setText("");
				} else if (e.getSource() == bt4) {// 4���޴�(�ݶ�,2000��)���
					v = new Vector<String>();
					if (cont4.getText().equals("")) {
						noCount();
						return;
					}
					try {
						mTot = Integer.parseInt(cont4.getText());
					} catch (NumberFormatException ne) {
						JOptionPane.showMessageDialog(Menu.this, "���ڸ� �Է����ּ���");
						cont4.setText("");
						return;
					}

					if (mTot <= 0) {
						JOptionPane.showMessageDialog(Menu.this, "1�� �̻��� ������ �Է����ּ���.");
						cont4.setText("");
						return;
					}
					int orderPlus = meneSum(cont4.getText(), 2000);
					orderTot += orderPlus;
					plusList("�ݶ�", cont4.getText(), "2000");
					list.updateUI();
					cont4.setText("");
				} else if (e.getSource() == del) {// ��ҹ�ư

					int selection = list.getSelectedRow();
					if (list.getSelectedRow() == -1) { // ����ó��
						JOptionPane.showMessageDialog(Menu.this, "������ �޴��� �������ּ���!");
						return;
					}

					try {
						rowData.remove(selection);
					} catch (Exception ie) {
						JOptionPane.showMessageDialog(Menu.this, "������ �޴��� �������ּ���!");
					}

					orderTot = 0;
					list.updateUI();
				} else if (e.getSource() == card) { // ī�������ư
					if (orderTot == 0) {
						JOptionPane.showMessageDialog(Menu.this, "������ �޴��� ����ּ���~!");
						return;
					}
					int result = JOptionPane.showConfirmDialog(Menu.this, "�����ݾ��� " + orderTot + "�� �Դϴ�.", "ī�����",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) { // ��
						cardTot += orderTot; // ī�� ���� ���ϱ�
						menuCount();
						JOptionPane.showMessageDialog(Menu.this, "�����Ǿ����ϴ�! �ȳ���������~!");
						rowData.removeAllElements();// ������ �Ǹ� ����Ʈ ��ü �����
						list.updateUI();
					} else {
						return;
					}
					orderTot = 0;// �մ� �����ݾ� �ٽ� 0���� �ʱ�ȭ��
				} else if (e.getSource() == cash) { // ���ݰ�����ư
					if (orderTot == 0) {
						JOptionPane.showMessageDialog(Menu.this, "������ �޴��� ����ּ���~!");
						return;
					}
					String input = JOptionPane.showInputDialog(Menu.this,
							"�����ݾ��� " + orderTot + "�� �Դϴ�. ������ �ݾ��� �Է��ϼ���.  ");
					if (input.equals("")) {
						JOptionPane.showMessageDialog(Menu.this, "���� ���ּ���!!!");
						return;
					}
					int money = Integer.parseInt(input);
					if (money > orderTot) { // ������ ũ��
						int a = money - orderTot;
						cashTot += orderTot;// �ֹ��ݾ� ���ݸ��⿡ ���ϱ�
						JOptionPane.showMessageDialog(Menu.this, "�Ž����� " + a + "�� ��������~");
						JOptionPane.showMessageDialog(Menu.this, "�����մϴ�! �ȳ���������!");
						
						menuCount();
						orderTot = 0;// �մ԰����ݾ� �ٽ� �ʱ�ȭ
						rowData.removeAllElements();// ������ �Ǹ� ����Ʈ ��ü �����
						list.updateUI();
					} else if (money == orderTot) {// �ݾ��� ������
						JOptionPane.showMessageDialog(Menu.this, "�����մϴ�! �ȳ���������!");
						cashTot += orderTot;
						orderTot = 0;// �մ԰����ݾ� �ٽ� �ʱ�ȭ
						menuCount();
						rowData.removeAllElements();// ������ �Ǹ� ����Ʈ ��ü �����
						list.updateUI();
					} else if (money < orderTot) {// �ݾ��� ������
						JOptionPane.showMessageDialog(Menu.this, "���� �����մϴ�!!!!�� ���ּ���!");
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
				if (e.getSource() == btExit) { // �����ư
					String pw = JOptionPane.showInputDialog(Menu.this, "������ ��ȣ�� �Է����ּ���.");
					if (pw == null)
						return;
					if (pw.equals("1234")) {
						JOptionPane.showMessageDialog(Menu.this,
								"ī�����:" + cardTot + "\n" + "���ݸ���:" + cashTot + "\n" + "�� �����:" + allTot); // �� ����� �����ֱ�
						Date today = new Date();
						SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
						String dd = date.format(today); // ��¥
						try {
							File f = new File("C:\\����");
							if (f.exists()) { // ���� ���ó�¥�� ������
								BufferedWriter bw = new BufferedWriter(new FileWriter(f + "\\" + dd + ".txt"));
								bw.write("ī����� : " + cardTot + "��\r\n");
								bw.write("���ݸ��� : " + cashTot + "��\r\n");
								bw.write("�Ѹ��� : " + allTot + "��\r\n");
								bw.write("�ܹ��� �Ǹż���:" + mm1 + "��\r\n");
								bw.write("ġŲ �Ǹż���:" + mm2 + "��\r\n");
								bw.write("Ÿ�� �Ǹż���:" + mm3 + "��\r\n");
								bw.write("�ݶ� �Ǹż���:" + mm4 + "��\r\n");
								bw.flush();
								bw.close();
								JOptionPane.showMessageDialog(Menu.this, "�������� ����Ϸ�!");
							} else {
								f.mkdirs(); // ������ ������ �ǵ�
								BufferedWriter bw = new BufferedWriter(new FileWriter(f + "\\" + dd + ".txt"));
								bw.write("ī����� : " + cardTot + "��\r\n");
								bw.write("���ݸ��� : " + cashTot + "��\r\nn");
								bw.write("�Ѹ��� : " + allTot + "��\r\n");
								bw.write("�ܹ��� �Ǹż���:" + mm1 + "��\r\n");
								bw.write("ġŲ �Ǹż���:" + mm2 + "��\r\n");
								bw.write("Ÿ�� �Ǹż���:" + mm3 + "��\r\n");
								bw.write("�ݶ� �Ǹż���:" + mm4 + "��\r\n");
								bw.flush();
								bw.close();
								JOptionPane.showMessageDialog(Menu.this, "�������� ����Ϸ�!");
							}
						} catch (IOException ie) {
							System.out.println(ie.getMessage());
						}
					} else if (!pw.equals("1234")) {
						JOptionPane.showMessageDialog(Menu.this, "�����ڹ�ȣ�� Ʋ�Ƚ��ϴ�.");
					}

				} else if (e.getSource() == btFile) { // ���Ϲ�ư
					String pw = JOptionPane.showInputDialog(Menu.this, "������ ��ȣ�� �Է����ּ���.");
					if (pw == null)
						return;
					if (pw.equals("1234")) {
						new MiniProject2();
					} else if (!pw.equals("1234")) {
						JOptionPane.showMessageDialog(Menu.this, "�����ڹ�ȣ�� Ʋ�Ƚ��ϴ�.");
					}
				} else if (e.getSource() == btExit2) { // ��������ư
					String pw = JOptionPane.showInputDialog(Menu.this, "������ ��ȣ�� �Է����ּ���.");
					if (pw == null)
						return;
					if (pw.equals("1234")) {
						int result = JOptionPane.showConfirmDialog(Menu.this, "��縦 �����ұ��?!", "����â",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.YES_OPTION) { // ��
							JOptionPane.showMessageDialog(Menu.this, "��縦 �����մϴ�!!!");
							System.exit(0);
						} else if (result == JOptionPane.NO_OPTION) { // �ƴϿ�
							return;
						}
					} else if (!pw.equals("1234")) {
						JOptionPane.showMessageDialog(Menu.this, "�����ڹ�ȣ�� Ʋ�Ƚ��ϴ�.");
					}
				}
			}
		};
		btExit.addActionListener(listener2);
		btFile.addActionListener(listener2);
		btExit2.addActionListener(listener2);
	}

	public void noCount() { // �����Է�xâ�����°� �޼ҵ�
		JOptionPane.showMessageDialog(Menu.this, "������ �Է����ּ���!!!");
	}
	
	public void menuCount(){ //���޴� �Ǹż��� ���ϴ� �޼ҵ�
		for(int i=0;i<rowData.size();i++) {
			Vector<String> f=rowData.get(i);
			if(f.get(0).equals("�ܹ���")) {
				int b=Integer.parseInt(f.get(1));
				mm1=+b;
			}else if(f.get(0).equals("ġŲ")) {
				int b=Integer.parseInt(f.get(1));
				mm2=+b;
			}else if(f.get(0).equals("Ÿ��")) {
				int b=Integer.parseInt(f.get(1));
				mm3=+b;
			}else if(f.get(0).equals("�ݶ�")) {
				int b=Integer.parseInt(f.get(1));
				mm4=+b;
			}
		}
	}

	public void plusList(String mName, String cM, String p) { // ����Ʈ�� �߰��ϴ°� �޼ҵ�
		v.add(mName);// �޴��̸�
		v.add(cM);// ����
		v.add(p + "��");// ����
		int a = Integer.parseInt(cM);
		int b = Integer.parseInt(p);
		int tot1 = a * b;
		String tot2 = Integer.toString(tot1);
		v.add(tot2 + "��");
		rowData.add(v); // ���� ����� ���� rowData�� ���
	}

	public int meneSum(String countM, int pri) {// �޴�ī��Ʈ, �� �޴�����
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
