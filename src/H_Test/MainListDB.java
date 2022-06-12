package H_Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;

public class MainListDB {
	public ArrayList<MainListGAP> getUserList(){
		
		ArrayList<MainListGAP> list = new ArrayList<MainListGAP>();
		
		String sql = "SELECT * from Post";
		ResultSet rs = DB.DBselect(sql);
		
		try {
			while(rs.next()) {
				String title = rs.getString("post_title");
				String price = rs.getString("post_price");
				String state = rs.getString("post_state");
				String term = rs.getString("post_term");
				String name = rs.getString("user_name");
				String content = rs.getString("post_memo");

				MainListGAP vo = new MainListGAP();
				
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setState(state);
				vo.setTerm(term);
				vo.setName(name);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println(e + "= > getUserList Fail");
		}
		return list;
	}
}
