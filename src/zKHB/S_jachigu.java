//package zKHB;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
////import java.util.Vector;
//
//import db.DB;
////import main.MainListGAP;
//
//public class S_jachigu {
//	
//	
//	
//	private S_MainListGAP vo;
//
//	public ArrayList<S_MainListGAP> getvillage(){
//		
////		Vector<String> jachiguvector = new Vector<>();	
//		ArrayList<S_MainListGAP> villagelist = new ArrayList<S_MainListGAP>();
//	
//		vo = new S_MainListGAP();
//		
//		String checkingid = vo.getId();
//		String sql1 = "select village from Residence where city = (select user_residence from User where user_id = '" + checkingid + "')";
//		ResultSet rs = DB.DBselect(sql1);
//		System.out.println(vo.getId());
//		
//		
//		try {
//			while(rs.next()) {
//				System.out.println(rs);
//				String jachigu = rs.getString("village");
//				System.out.println(jachigu);
//				
//				
//				vo.setVillage(jachigu);
//				
//				villagelist.add(vo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return villagelist;
//	}
//}
