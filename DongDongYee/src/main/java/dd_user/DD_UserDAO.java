package dd_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 

public class DD_UserDAO {
	private Connection conn; //db 접근 객체 
	private PreparedStatement pstmt;
	private ResultSet rs; // db 결과를 담는 객체
	
	public DD_UserDAO() { // dao 생성자에서 db connection 
		try {
			String dbURL = "jdbc:mysql://localhost:3306/dongdongdb"; //mySQL 서버의 BBS DB 접근 경로
			String dbID = "dong"; //계정
			String dbPassword = "1234"; //비밀번호
			Class.forName("com.mysql.jdbc.Driver"); //mysql에 접속을 도와주는 라이브러리 
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// 로그인 기능 
	public int login(String UserID, String UserPassword) {
		String SQL = "SELECT UserPassword FROM DD_USER WHERE UserID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, UserID); //sql Injection 공격 방어 수단 : 1번째 물음표에 userID 입력
			rs = pstmt.executeQuery(); // 쿼리 실행 
			if (rs.next()) {
				if (rs.getString(1).equals(UserPassword)) // rs.getString(1) : select된 첫번째 컬럼
					return 1; //로그인 성공
				else
					return 0; // 비밀번호 틀림
			}
			return -1; // 아이디 없음 
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return -2; //DB 오류 
	}
	
	public int join(DD_User user) {
	    // 이메일 중복 체크
	    String checkEmailSQL = "SELECT COUNT(*) FROM DD_USER WHERE UserEmail = ?";
	    try {
	        PreparedStatement checkEmailStmt = conn.prepareStatement(checkEmailSQL);
	        checkEmailStmt.setString(1, user.getUserEmail());
	        ResultSet rsEmail = checkEmailStmt.executeQuery();
	        if (rsEmail.next()) {
	            if (rsEmail.getInt(1) > 0) {
	                return -2; // 이메일이 중복되면 -2 반환
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1; // DB 오류
	    }
		
		// 중복 닉네임 체크
	    String checkSQL = "SELECT COUNT(*) FROM DD_USER WHERE UserNickname = ?";
	    try {
	        PreparedStatement checkStmt = conn.prepareStatement(checkSQL);
	        checkStmt.setString(1, user.getUserNickname());
	        ResultSet rs = checkStmt.executeQuery();
	        if (rs.next()) {
	            if (rs.getInt(1) > 0) {
	                return -3; // 닉네임이 중복되면 -3 반환
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1; // DB 오류
	    }
	    
	    //등록
		String SQL = "INSERT INTO DD_USER VALUES(?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserEmail());
			pstmt.setString(4, user.getUserNickname());
			return pstmt.executeUpdate(); // 0이상 값이 return된 경우 성공 
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return -1; //DB 오류 
	}
}
