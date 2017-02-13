package notice.model.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import notice.model.vo.User;

public class UserDao {
	public UserDao(){}
	
	public User loginCheck(String uid, String upwd){
		User loginUser = null;
		String config = "mybatis/data/mybatis-config.xml";
		
		//파일 읽기용 객체
		Reader reader = null;
		//db connection 역할의 객체
		SqlSession session = null;
		
		try{
			//config 파일의 내용을 읽음
			reader = Resources.getResourceAsReader(config);
			
			//db 와 연결 처리함
			session = new SqlSessionFactoryBuilder()
							.build(reader).openSession();
			
			loginUser = (User)session.selectOne("selectID", new User(uid, upwd, null));
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		
		return loginUser;
	}
}
