import java.sql.*;
import java.util.*;

public class ProductsDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "kosea";
	String password = "kosea2019a";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<ProductsVo> list(String atr, String tpl, boolean chk) {
		ArrayList<ProductsVo> list = new ArrayList<ProductsVo>();
		try {
			connDB();
			String query = "SELECT * FROM products ORDER BY product_code";
			if (tpl.isEmpty()) {
				query = "SELECT * FROM products ORDER BY product_code";
			} else {
				switch (atr) {
				case "product_code":
				case "amount":
				case "original_price":
				case "discount":
				case "multi_purchase_discount":
				case "discount_rate":
					query = "SELECT * FROM products WHERE " + atr + " = " + tpl + " ORDER BY product_code";
					break;
				case "category":
				case "product_name":
				case "status":
				case "register_date":
				case "shipping":
					if (chk) {
						query = "SELECT * FROM products WHERE (" + atr + " LIKE '%" + tpl + "' OR " + atr + " LIKE '"
								+ tpl + "%' OR " + atr + " LIKE '%" + tpl + "%') ORDER BY product_code";
					} else {
						query = "SELECT * FROM products WHERE " + atr + " = '" + tpl.toUpperCase()
								+ "' ORDER BY product_code";
					}
					break;
				default:
				}
			}

			System.out.println("SQL> " + query);
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int pcode = rs.getInt("product_code");
				String category = rs.getString("category");
				String pname = rs.getString("product_name");
				String status = rs.getString("status");
				int amount = rs.getInt("amount");
				int org_price = rs.getInt("original_price");
				int discount = rs.getInt("discount");
				int mul_dc = rs.getInt("multi_purchase_discount");
				double dc_rate = rs.getDouble("discount_rate");
				String reg_date = rs.getString("register_date");
				String shipping = rs.getString("shipping");
				ProductsVo data = new ProductsVo(pcode, category, pname, status, amount, org_price, discount, mul_dc,
						dc_rate, reg_date, shipping);
				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
