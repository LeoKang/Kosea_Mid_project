import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class InsertFrame extends DAO {
	ProductsVO idata;

	JFrame f;
//  �Է� ���̺� 
	DefaultTableModel model;
	JScrollPane sp;
	JTable itable;

//  �г�(Ȯ�� ��ư)
	JPanel p;
	JButton cmt;

	public InsertFrame() {
//		�ʱ�ȭ �� ����

		f = new JFrame(this.toString());
		f.setSize(1000, 500);

		p = new JPanel();
		cmt = new JButton("Ȯ��");

		model = new DefaultTableModel(new String[] { "customer_code", "customer_name", "customer_ID", "address",
				"phone", "zip_code", "custom_clearance_code" }, 100);

		itable = new JTable(model);
		sp = new JScrollPane(itable);

//		�̺�Ʈ ����
		/* ���� ��ư */
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void initFrame() {
		/* �гκ� ��� */
		p.add(cmt);
		/* ������ ��� */
		f.add(p, BorderLayout.SOUTH);
		f.add(sp, BorderLayout.CENTER);

		f.setVisible(true);
	}

	public static void main(String[] args) {
		InsertFrame d = new InsertFrame();
		d.initFrame();
	}
}
