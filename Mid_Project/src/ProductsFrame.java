import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class ProductsFrame {
	ProductsDAO dao = new ProductsDAO();
	ArrayList<ProductsVo> products = new ArrayList<ProductsVo>();

	JFrame f;

	JPanel p;
	JComboBox<String> cmb;
	JTextField inp;
	JButton cfm;
	JCheckBox chk;

	DefaultTableModel model;
	JScrollPane sp;
	JTable table;

	String column[] = { "product_code", "category", "product_name", "status", "amount", "original_price", "discount",
			"multi_purchase_discount", "discount_rate", "register_date", "shipping" };

	public ProductsFrame() {

		model = new DefaultTableModel(column, 0);
		f = new JFrame("products");

		f.setSize(1000, 500);

		p = new JPanel();
		cmb = new JComboBox<String>();
		cmb.setModel(new DefaultComboBoxModel<String>(column));
		inp = new JTextField("", 30);
		chk = new JCheckBox("검색");

		search();

		table = new JTable(model);

		sp = new JScrollPane(table);

		cfm = new JButton("°Ë»ö");
		cfm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model = (DefaultTableModel) table.getModel();
				model.setNumRows(0);
				search();

				table.setModel(model);
				table.repaint();
			}
		});

	}

	public void initFrame() {
		p.add(cmb);
		p.add(inp);
		p.add(cfm);
		p.add(chk);

		f.add(p, BorderLayout.NORTH);
		f.add(sp, BorderLayout.CENTER);

		f.setVisible(true);
	}

	public void search() {
		products = dao.list(cmb.getSelectedItem().toString(), inp.getText(), chk.isSelected());

		for (int i = 0; i < products.size(); i++) {
			model.addRow(products.get(i).toList());
		}

	}

	public static void main(String[] args) {
		ProductsFrame g = new ProductsFrame();
		g.initFrame();
	}

}
