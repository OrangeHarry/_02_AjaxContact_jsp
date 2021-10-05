package com.studyajax.contact.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajaxstudy.contact.domain.ContactList;
import com.ajaxstudy.contact.domain.Result;
import com.ajaxstudy.contact.util.Converter;
import com.ajaxstudy.contact.util.SampleDAO;

/**
 * Servlet implementation class ContactUpdateServlet
 */
//list.do : servlet //.do는 붙여도되고 안붙여도 된다. 그냥 읽기 편하게
@WebServlet("/list.do")
public class ContactListServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		// 사용자가 보낸 파라미터 받음
		// request 객체 : 웹브라우저의 요청 정보
		String strPageNo = request.getParameter("pageno");
		String strPageSize = request.getParameter("pagesize");

		int pageno = 0; // 0이면 전체 데이터 조회, 1이상이면 해당 페이지 조회
		int pagesize = 3; // 한 페이지 크기

		// 브라우저가 보내온 페이지의 번호와 페이지 크기를 int로 변환
		try {
			pageno = Integer.parseInt(strPageNo);
		} catch (Exception e) {
			pageno = 0;
			System.out.println("pageno이 없음");
		}

		try {
			pagesize = Integer.parseInt(strPageSize);
		} catch (Exception e) {
			pagesize = 3;
			System.out.println("pagesize가 없음");
		}

		ContactList contactList = null;
		if (pageno == 0) {
			// pageno이 0 이면 전체 연락처 목록 조회
			contactList = SampleDAO.getContacts();
		} else {
			// pageno이 1 이상이면 특정 페이지의 연락처 목록 조희
			contactList = SampleDAO.getContacts(pageno, pagesize);
		}

		// JAVA 객체 -> Json 문자열로 변환
		String json = Converter.convertToJson(contactList);
		
		PrintWriter writer = response.getWriter();
		writer.println(json);
	}
}
