package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;

public class MainListDB {
	private ResultSet rs;

	public ArrayList<MainListGAP> getUserList(String keyword){
		
		ArrayList<MainListGAP> list = new ArrayList<MainListGAP>();

			String sql = "select * from Post where post_title like '%" + keyword + "%'";
			rs = DB.DBselect(sql);

		
		
		try {
			while(rs.next()) {
				String name = rs.getString("user_name");
				String title = rs.getString("post_title");
				String price = rs.getString("post_price");
				String state = rs.getString("post_state");
				String term = rs.getString("post_term");
				String content = rs.getString("post_memo");

				MainListGAP vo = new MainListGAP();
				
				vo.setName(name);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setState(state);
				vo.setTerm(term);
				vo.setContent(content);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println(e + "= > getUserList Fail");
		}
		return list;
	}
}
