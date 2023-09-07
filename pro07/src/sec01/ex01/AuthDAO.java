package sec01.ex01;

import java.sql.ResultSet;

public class AuthDAO extends DBInitializer {

	public AuthDAO() {
		super();
	}

	public boolean login(String id, String pwd) {
		boolean flag = false;

		try {
			conn = dataFactory.getConnection();
			String query = "SELECT * FROM t_member WHERE id=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				String userId = rs.getString("id");
				String userPwd = rs.getString("pwd");
				
				if (userId.equals(id) && userPwd.equals(pwd)) {
					System.out.println("로그인 성공");
					flag = true;
				}
			}

			rs.close();
			pstmt.close();
			conn.close();

			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}

}
