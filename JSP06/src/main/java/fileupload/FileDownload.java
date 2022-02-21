package fileupload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/filedownload")
public class FileDownload extends HttpServlet {
       final static String UPLOAD_DIRPATH="C:\\Users\\user\\VscodeProjects\\";

    public FileDownload() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[fileDownload] get:/filednload.do");
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[fileDownload] post:/filednload.do");
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// file download
		String filename = (String)request.getParameter("filename");
		String downfile = UPLOAD_DIRPATH + filename; // 다운로드 경로 + 파일이름
		
		System.out.println("[fileDownload] filename: "+filename);

//		File file = new File(downfile);
		
		try {
			OutputStream out = response.getOutputStream();
			FileInputStream inFile = new FileInputStream(new File(downfile));
			byte[] readBuff = new byte[8192]; //8kb
			
			while(true) {
				int readlen = inFile.read(readBuff);
				if(readlen < 0) {
					break;
				}
				out.write(readBuff,0,readlen);
			}//while
			inFile.close();
			out.close();
			
		}//try
		
		catch(FileNotFoundException e) {
			System.out.println("[fileDownload] downfile: "+downfile);
			System.out.println("[fileDownload] FileNotFoundException: "+e.getMessage());
		}//catch
		
		
		
	}// doProcess

}
