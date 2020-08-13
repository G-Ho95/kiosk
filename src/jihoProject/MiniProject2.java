package jihoProject;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MiniProject2 extends JFrame {
	JLabel fList = new JLabel("���ϸ��");
	JLabel fList2 = new JLabel("���ϳ���");
	List list = new List();
	JButton bt = new JButton("��");
	JButton del = new JButton("���������");
	JButton fileDel = new JButton("���ϻ���");
	JTextArea fArea = new JTextArea();
	JScrollPane sc = new JScrollPane(fArea);

	public MiniProject2() {
		super("�������� ����Ʈ");
		setLayout(null);
		fList.setBounds(30, 20, 70, 30);
		fList2.setBounds(250, 20, 70, 30);
		list.setBounds(30, 50, 150, 400);
		bt.setBounds(190, 230, 50, 50);
		del.setBounds(430, 15, 100, 30);
		fileDel.setBounds(90, 15, 90, 30);// �̰�
		fArea.setBounds(250, 50, 280, 400);
		sc.setBounds(250, 50, 280, 400);
		add(sc);
		add(fList);
		add(fList2);
		add(list);
		add(bt);
		add(del);
		add(fileDel);
		File f = new File("C:\\����");
		if (f.isDirectory()) {
			File[] fileList = f.listFiles();
			for (File tFile : fileList) {
				list.add(tFile.getName());
			}
		}
		setSize(600, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedReader br;
				if (e.getSource() == bt) { // ȭ��ǥ��ư ������ ���ϳ��� �����ֱ�
					try {
						br = new BufferedReader(new FileReader("C:\\����\\" + list.getSelectedItem()));
						while (true) { // �ФФ�
							String a = br.readLine();
							if (a == null)
								break;
							fArea.append(a + "\n");
						}
						br.close();
					} catch (IOException ie) {
						System.out.println(ie.getMessage());
					}
				} else if (e.getSource() == del) { // �ؽ�Ʈ ���� �����
					fArea.setText("");
				} else if (e.getSource() == fileDel) { // ������ ���� �����
					File f=new File("C:\\����\\"+ list.getSelectedItem());
					f.delete();
					list.remove(list.getSelectedItem());
					JOptionPane.showMessageDialog(MiniProject2.this, "���� ������ �Ϸ�Ǿ����ϴ�.");
				}
			}
		};
		bt.addActionListener(listener);
		del.addActionListener(listener);
		fileDel.addActionListener(listener);
	}
}
