package fileupload;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/fileupload2.do")
public class FileUpload2 extends HttpServlet {
	final static String UPLOAD_DIRPATH="\\updnpath";
//	final static String UPLOAD_DIRPATH=".\\"; // eclipse.exe 파일이 있는 곳에 저장됨 ㅋㅎ
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected String realPath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURL = request.getRequestURI();
		String realPath = getServletContext().getRealPath(requestURL);
		String cntxpath = getServletContext().getContextPath();
		String reqtPath = request.getContextPath();
		
		Set<String> resPaths = getServletContext().getResourcePaths("/");
		
		if(resPaths!= null) {// 경로 찍어보기?
			for(String resPath : resPaths) {
				System.out.println("resPath: "+resPath);
			}//for
			
		}//if
		System.out.println(" ");
		System.out.println("[FileUplond2] realpath: "+realPath);
		System.out.println("[FileUplond2] cntxpath: "+cntxpath);
		System.out.println("[FileUplond2] reqtPath: "+reqtPath);
		
		return realPath;
	}
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		realPath(request,response);
		
		// encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// file upload
		File uploadDirPath = new File(UPLOAD_DIRPATH); // 해당 경로에 이미지 저장
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(uploadDirPath); // 파일을 저장할 디렉토리
		factory.setSizeThreshold(1024*1024); // 1mb
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request); // 파라미터를 List 객체로 얻음
			
			for(int cnt=0; cnt<items.size(); cnt++) {
				FileItem fileItem = items.get(cnt);
				if(fileItem.isFormField() != true) {
					if(fileItem.getSize() >0) {
						
						int index = fileItem.getName().lastIndexOf("\\"); // Windows 경로
						System.out.println("getSize() >0 일 때 index: "+index); 
						
						if(index == -1) {
							index = fileItem.getName().lastIndexOf("/");// Unix 경로
						}
						
						String filename = fileItem.getName().substring(index+1); // 전체 경로에서 파일만 추출
						String filepath = uploadDirPath +"\\"+ filename; // 파일 저장 위치
						File uploadFile = new File(filepath);
						fileItem.write(uploadFile);
						
						System.out.printf("[Fileupload] fileItem.getName(): %s\n", fileItem.getName());
						System.out.printf("[Fileupload] file경로: %s file이름: %s\n", uploadDirPath, filename);
						System.out.printf("[Fileupload] jsp 의 name_필드이름: %s \n", fileItem.getFieldName()); // jsp 의 name
						System.out.printf("[Fileupload] filesize: %s byte\n", fileItem.getSize()); // 바이트
						
					}// getSize
					
				}// isFormField
				
				else {
					System.out.println("[filditem]: "+fileItem.getFieldName()+ ", "+fileItem.getString("UTF-8"));
				}
				
			}// for
			
		}// try
		catch(Exception e) {
			System.out.println("fileupload: "+ e.getMessage());
		}//catch
		
		response.sendRedirect("fileupresult.jsp?msg='파일 업로드를 성공했습니다.''");
	}// doProcess

}
