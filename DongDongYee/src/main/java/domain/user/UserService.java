package domain.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {
    private Connection conn; //db 접근 객체
    private PreparedStatement pstmt;
    private ResultSet rs; // db 결과를 담는 객체

    public UserService() {
        try {
            String dbURL = "jdbc:mysql://localhost:3306/dongdongdb"; //mySQL 서버의 BBS DB 접근 경로
            String dbID = "dong"; //계정
            String dbPassword = "0000"; //비밀번호
            Class.forName("com.mysql.cj.jdbc.Driver"); //mysql에 접속을 도와주는 라이브러리
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int login(String userID, String userPassword) {
        String SQL = "SELECT UserPassword FROM DD_USER WHERE UserID = ?";
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, userID); //sql Injection 공격 방어 수단 : 1번째 물음표에 userID 입력
            rs = pstmt.executeQuery(); // 쿼리 실행
            if (rs.next()) {
                if (rs.getString(1).equals(userPassword)) // rs.getString(1) : select된 첫번째 컬럼
                    return 1; //로그인 성공
                else
                    return 0; // 비밀번호 틀림
            }
            return -1; // 아이디 없음
        } catch (Exception e) {
            e.printStackTrace();

        }
        return -2; //DB 오류
    }

    public int isEmailTaken(String email) {
        String checkEmailSQL = "SELECT COUNT(*) FROM DD_USER WHERE UserEmail = ?";
        return isTaken(email, checkEmailSQL);
    }

    public int isIdTaken(String id) {
        String checkIdSQL = "SELECT COUNT(*) FROM DD_USER WHERE UserId = ?";
        return isTaken(id, checkIdSQL);
    }

    public int isNickNameTaken(String nickName) {
        String checkNickNameSQL = "SELECT COUNT(*) FROM DD_USER WHERE UserNickname = ?";
        return isTaken(nickName, checkNickNameSQL);
    }

    public int isTaken(String tryName, String trySQL) {
        try {
            PreparedStatement checkStmt = conn.prepareStatement(trySQL);
            checkStmt.setString(1, tryName);
            ResultSet rsName = checkStmt.executeQuery();
            if (rsName.next()) {
                if (rsName.getInt(1) > 0) {
                    return 1; // 중복되면 -1 반환
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -2; // DB 오류
        }
        return -1;
    }

    public int join(User user) {
        //등록
        String joinSQL = "INSERT INTO DD_USER VALUES(?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(joinSQL);
            pstmt.setString(1, user.getUserID());
            pstmt.setString(2, user.getUserPassword());
            pstmt.setString(3, user.getUserEmail());
            pstmt.setString(4, user.getUserNickname());
            return pstmt.executeUpdate(); // 0이상 값이 return된 경우 성공
        } catch (Exception e) {
            e.printStackTrace();

        }
        return -1; //DB 오류
    }
}
