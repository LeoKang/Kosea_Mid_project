import java.util.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CustomerFrame extends TableFrame {
//	DAO VO 인스턴스
	CustomerDAO dao = new CustomerDAO();
	ArrayList<CustomerVO> customer = new ArrayList<CustomerVO>();

	public CustomerFrame() {
		super();
		
		search();
		table = new JTable(model);
		sp = new JScrollPane(table);
	}

//	SELECT 결과 조회
	public void search() {
		customer = dao.list(cmb.getSelectedItem().toString(), inp.getText(), chk.isSelected());

		for (int i = 0; i < customer.size(); i++) {
			model.addRow(customer.get(i).toList());
		}

	}

	public String toString() {
		return "customer";
	}

	@Override
	public void setColumn() {
		column = new String[] { "customer_code", "customer_name", "customer_ID", "address", "phone", "zip_code",
				"custom_clearance_code" };

	}
}
