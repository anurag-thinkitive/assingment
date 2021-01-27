

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBOPS {

	DAO db = new DAO();
	Statement st;
	PreparedStatement ps;

	public void insertEmp(int id, String name) {

		try {
			ps = db.getPreparedStatement("insert into emp values(?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.execute();

			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteEmp(int id) {

		try {
			ps = db.getPreparedStatement("delete from emp where empid=?");
			ps.setInt(1, id);
			ps.execute();
			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateEmp(int id, String name) {

		try {
			ps = db.getPreparedStatement("update emp set ename=? where empid=?");
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.execute();
			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List displayEmp() {
		List l=new ArrayList();
		st = db.getStatement();

		try {
			ResultSet rs = st.executeQuery("select * from emp");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
				l.add(rs.getInt(1) + " " + rs.getString(2));
			}

			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return l;
	}

}
