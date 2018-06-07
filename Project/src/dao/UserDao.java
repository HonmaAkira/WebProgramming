package dao;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import model.User;

public class UserDao {

	private static final String Id = null;

	public User FindbyLogininfo(String loginId, String password) {
		Connection con = null;
		try {
			//データベースへ接続
			con = DBmanager.getConnection();
			//sql文を準備
			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";
			//SELECTを実行し、結果票を取得
			PreparedStatement prstmt = con.prepareStatement(sql);
			prstmt.setString(1, loginId);
			prstmt.setString(2, changePass(password));
			ResultSet rs = prstmt.executeQuery();

			if (!rs.next()) {
				return null;
			}
			int id = rs.getInt("id");
			String loginIdDate = rs.getString("login_id");
			String passDate = rs.getString("password");
			String name = rs.getString("name");
			Date birthDate = rs.getDate("birth_date");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");
			User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> FindAll() {
		Connection con = null;
		List<User> userlist = new ArrayList<User>();

		try {
			con = DBmanager.getConnection();

			String sql = "SELECT * FROM user WHERE id>1";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String login_id = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, login_id, name, birthDate, password, createDate, updateDate);

				userlist.add(user);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userlist;
	}

	public List<User> FindSearch(String loginId, String userName,String Birth1,String Birth2) {
		Connection con = null;
		List<User> userlist = new ArrayList<User>();

		try {
			con = DBmanager.getConnection();

			String sql = "SELECT * FROM user WHERE id>1";

			if(!loginId.equals("")) {
				sql += " AND login_id = '" + loginId + "'";
			}else if(!userName.equals("")) {
				sql += " AND name LIKE '%"+userName+"%'";
			}else if(!Birth1.equals("") ) {
				sql += " AND birth_date >='"+Birth1+"'";
			}else if(!Birth2.equals("")) {
				sql += " AND birth_date <='"+ Birth2+"'";
			}




			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String login_id = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, login_id, name, birthDate, password, createDate, updateDate);

				userlist.add(user);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userlist;
	}


	public void IncreaseUser(String loginId, String username, String birth, String password) {
		Connection con = null;
		try {
			//データベースへ接続
			con = DBmanager.getConnection();
			//sql文を準備

			String sql = "INSERT INTO user (login_id,name,birth_date,password,create_date,update_date)VALUES"
					+ " (?, ?, ?, ?, now(), now())";

			PreparedStatement prstmt = con.prepareStatement(sql);
			prstmt.setString(1, loginId);
			prstmt.setString(2, username);
			prstmt.setString(3, birth);
			prstmt.setString(4, changePass(password));

			int rs = prstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return;
				}
			}
		}
	}

	public User Findid(String id) {
		Connection con = null;
		try {
			con = DBmanager.getConnection();

			String sql = "SELECT * FROM user WHERE id =?";
			PreparedStatement prstmt = con.prepareStatement(sql);
			prstmt.setString(1, id);
			ResultSet rs = prstmt.executeQuery();

			if (!rs.next()) {
				return null;
			}
			int iddate = rs.getInt("id");
			String login_id = rs.getString("login_id");
			String name = rs.getString("name");
			Date birthDate = rs.getDate("birth_date");
			String password = rs.getString("password");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");
			User user = new User(iddate, login_id, name, birthDate, password, createDate, updateDate);

			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void Daleteid(String Id) {
		Connection con = null;

		try {
			con = DBmanager.getConnection();

			String sql = "DELETE FROM user WHERE id =?";
			PreparedStatement prstmt = con.prepareStatement(sql);
			prstmt.setString(1, Id);

			int rs = prstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void Updatepass(String pass) {
		Connection con = null;

		try {
			con = DBmanager.getConnection();

			String sql = "UPDATE user SET password =? WHERE id";
			PreparedStatement prstmt = con.prepareStatement(sql);

			prstmt.setString(1, pass);

			int rs = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public User Findlogin_id(String login_id) {
		Connection con = null;
		try {
			con = DBmanager.getConnection();

			String sql = "SELECT * FROM user WHERE login_id =?";
			PreparedStatement prstmt = con.prepareStatement(sql);
			prstmt.setString(1, login_id);
			ResultSet rs = prstmt.executeQuery();

			if (!rs.next()) {
				return null;
			}
			int iddate = rs.getInt("id");
			String login_Id = rs.getString("login_id");
			String name = rs.getString("name");
			Date birthDate = rs.getDate("birth_date");
			String password = rs.getString("password");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");
			User user = new User(iddate, login_Id, name, birthDate, password, createDate, updateDate);

			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void  AllUpdate(String password,String name,String birth,String id) {
		Connection con = null;
		try {
			con = DBmanager.getConnection();
			String sql = "UPDATE user SET password=?, name=?, birth_date=?, update_date=now() WHERE id=?";
			PreparedStatement prstmt = con.prepareStatement(sql);
			prstmt.setString(1,changePass(password));
			prstmt.setString(2,name);
			prstmt.setString(3,birth);
			prstmt.setString(4,id);


			int rs = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}

	}
	public void  NonPassUpdate(String name,String birth,String id) {
		Connection con = null;
		try {
			con = DBmanager.getConnection();
			String sql = "UPDATE user SET name=?, birth_date=?, update_date=now() WHERE id=?";
			PreparedStatement prstmt = con.prepareStatement(sql);

			prstmt.setString(1,name);
			prstmt.setString(2,birth);
			prstmt.setString(3,id);


			int rs = prstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private String changePass(String password) {
		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);
		//標準出力
		System.out.println(result);
		return result;
	}

}