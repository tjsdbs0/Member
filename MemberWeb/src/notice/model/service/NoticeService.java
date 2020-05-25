package notice.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.ConnectionFactory;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;
import notice.model.vo.PageData;


public class NoticeService {
	
	private ConnectionFactory factory;
	
	public NoticeService() {
		factory = ConnectionFactory.getConnection();
	}
	
	public PageData selectNoticeList(int currentPage) {
		Connection conn = null;
		int recordConutPerPage = 10;
		int naviCountPerPage = 5;
		PageData pd = new PageData();
		ArrayList<Notice> noticeList = null;
	
		try {
			conn = factory.createConnection();
			noticeList 
			= new NoticeDao().selectNoticeList(conn,currentPage,recordConutPerPage);
			pd.setPageList(noticeList);
			pd.setPageNavi(new NoticeDao().getPageNavi(conn, currentPage, recordConutPerPage, naviCountPerPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
		
		
	}
	
	public PageData noticeSearchList(int currentPage, String search) {
		Connection conn = null;
		int recordCountPerPage = 10;
		int naviCountPerPage = 5;
		PageData pd = new PageData();
		
		try {
			conn=factory.createConnection();
			pd.setPageList(new NoticeDao().noticeSearchList(conn,currentPage,recordCountPerPage, search));
			
			pd.setPageNavi(new NoticeDao().getSearchPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage, search));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
		
		
	}
	
	public int insertNotice(String subject, String content, String userId) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new NoticeDao().insertNotice(conn, subject, content, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0) {
			factory.commit(conn);
		}else {
			factory.rollback(conn);
		}
		return result;
	}
	
	public int insertComment(String comment, String userId, int noticeNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new NoticeDao().insertComment(conn, comment, userId, noticeNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0) {
			factory.commit(conn);
		}else {
			factory.rollback(conn);
		}
		return result;
	}
	
	public Notice noticeSelect(int noticeNo) {
		Connection conn = null;
		Notice notice = null;
		ArrayList<NoticeComment> cmtList = null;
		try {
		conn = factory.createConnection();
		notice = new NoticeDao().noticeSelect(conn, noticeNo);
		cmtList = new NoticeDao().noticeComment(conn,noticeNo);
		notice.setComments(cmtList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}
	
	public int modifyNotice(String subject, String content, int noticeNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new NoticeDao().modifyNotice(conn, subject, content, noticeNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0 ) {
			factory.commit(conn);
		}else {
			factory.rollback(conn);
		}
		return result;
	}
	
	public int deleteNotice(int noticeNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new NoticeDao().deleteNotice(conn, noticeNo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0 ) {
			factory.commit(conn);
		}else {
			factory.rollback(conn);
		}
		return result;
	}
	
	public int deleteNoticeComment(int commentNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new NoticeDao().deleteNoticeComment(conn, commentNo);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0 ) {
			factory.commit(conn);
		}else {
			factory.rollback(conn);
		}
		return result;
	}
	
	public int modifyNoticeComment(int commentNo, int noticeNo, String comment) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new NoticeDao().modifyNoticeComment(conn, commentNo, noticeNo,comment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0 ) {
			factory.commit(conn);
		}else {
			factory.rollback(conn);
		}
		return result;
	}
	
	

}
