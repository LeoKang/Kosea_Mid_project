import java.util.*;

public class ProductsTest {
	public static void main(String[] args) {
		ProductsDAO dao = new ProductsDAO();
		ArrayList<ProductsVo> list = dao.list("", "", false);
		
		for (int i = 0; i < list.size(); i++) {
			ProductsVo data = (ProductsVo) list.get(i);
			Object[] tmp = data.toList();
			for(Object j : tmp) {
				System.out.println(j);
			}
		}
	}
}
