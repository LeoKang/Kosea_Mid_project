import java.sql.*;

public abstract class DAO {
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String USER = "kosea";
	private final String PASSWORD = "kosea2019a";

	protected Connection con;
	protected Statement stmt;
	protected ResultSet rs;

	public void connDB() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
