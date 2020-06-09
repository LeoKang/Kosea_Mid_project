import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class InsertFrame extends DAO {
	ProductsVO idata;

	JFrame f;
//  입력 테이블 
	DefaultTableModel model;
	JScrollPane sp;
	JTable itable;

//  패널(확인 버튼)
	JPanel p;
	JButton cmt;

	public InsertFrame() {
//		초기화 블럭 시작

		f = new JFrame(this.toString());
		f.setSize(1000, 500);

		p = new JPanel();
		cmt = new JButton("확인");

		model = new DefaultTableModel(new String[] { "customer_code", "customer_name", "customer_ID", "address",
				"phone", "zip_code", "custom_clearance_code" }, 100);

		itable = new JTable(model);
		sp = new JScrollPane(itable);

//		이벤트 설정
		/* 종료 버튼 */
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void initFrame() {
		/* 패널부 출력 */
		p.add(cmt);
		/* 프레임 출력 */
		f.add(p, BorderLayout.SOUTH);
		f.add(sp, BorderLayout.CENTER);

		f.setVisible(true);
	}

	public static void main(String[] args) {
		InsertFrame d = new InsertFrame();
		d.initFrame();
	}
}
