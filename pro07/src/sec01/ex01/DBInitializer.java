package sec01.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBInitializer {

	protected DataSource dataFactory;
	protected Connection conn;
	protected PreparedStatement pstmt;
	
	protected DBInitializer() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
