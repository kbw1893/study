package notice.model.dao;

import java.util.*;
import java.io.*;
import java.sql.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import notice.model.vo.Notice;

public class NoticeDao {
	public NoticeDao(){}
	
	//notice 테이블의 전체 행을 조회하는 메소드
	public List<Notice> selectAll(){
		List<Notice> list = null;
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
			
			list = session.selectList("selectAll");
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		
		return list;
	}
	
	//글번호를 가지고 한 행의 정보를 조회하는 메소드
	public Notice selectOne(int no){
		Notice n = null;
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
			
			n = session.selectOne("selectNO", no);
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		
		return n;
	}
	
	//글번호에 대한 한 행의 정보를 삭제하는 메소드
	public int deleteNotice(int no){
		int result = 0;
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
			
			result = session.delete("deleteRow", no);
			session.commit();
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		
		return result;
	}
	
	//글수정 처리 메소드
	public int updateNotice(Notice n){
		int result = 0;
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
			
			result = session.update("updateRow", n);
			session.commit();
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		
		return result;
	}
	
	//새 글 추가용 메소드
	public int insertNotice(Notice n){
		int result = 0;
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
			
			result = session.insert("insertRow", n);
			session.commit();
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		
		return result;
	}
	
	//제목 검색 메소드
	public List<Notice> searchTitle(String word){
		List<Notice> list = null;
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
			
			list = session.selectList("selectTitle", word);
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(session != null)
				session.close();
		}
		
		return list;
	}
	
}









