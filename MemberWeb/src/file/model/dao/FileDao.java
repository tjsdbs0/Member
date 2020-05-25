package file.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import file.model.vo.FileData;

public class FileDao {
	public int uploadFile(Connection conn, FileData fileData) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "insert into filetbl values(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileData.getFileName());
			pstmt.setString(2, fileData.getFilePath());
			pstmt.setLong(3, fileData.getFileSize());
			pstmt.setString(4, fileData.getFileUser());
			pstmt.setTimestamp(5,  fileData.getUploadTime());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<FileData> selectFileList(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FileData> list = new ArrayList<FileData>();
		String query = "select * from filetbl where fileuser =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				FileData data = new FileData();
				data.setFileName(rset.getString("filename"));
				data.setFilePath(rset.getString("filepath"));
				data.setFileSize(rset.getLong("filesize"));
				data.setFileUser(rset.getString("fileuser"));
				data.setUploadTime(rset.getTimestamp("uploadtime"));
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return list;
	}
	
	public int deleteFile(Connection conn, String filePath) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete filetbl where filepath=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, filePath);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
		
	}

}
