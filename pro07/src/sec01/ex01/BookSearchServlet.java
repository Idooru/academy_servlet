package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookSearchServlet
 */
@WebServlet("/book")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		BookDAO dao = new BookDAO();

		String _bookName = request.getParameter("bookname");
		List<BookVO> bookList = dao.searchBook(_bookName);

		PrintWriter out = response.getWriter();

		out.print("<h1>검색 결과</h1>");

		if (bookList.size() == 0) {
			out.print("<h3>검색 결과가 없습니다.</h3>");
			return;
		}

		out.print("<table border=1><tr>");
		out.print("<td>아이디</td><td>책이름</td><td>출판사</td><td>가격</td>");

		bookList.stream().forEach((BookVO bookVO) -> {
			int bookId = bookVO.getBookId();
			String bookName = bookVO.getBookName();
			String bookCompany = bookVO.getBookCompany();
			int bookPrice = bookVO.getBookPrice();

			out.print("<tr>");
			out.printf("<td>%s</td>", bookId);
			out.printf("<td>%s</td>", bookName);
			out.printf("<td>%s</td>", bookCompany);
			out.printf("<td>%s</td>", bookPrice);
			out.print("</tr>");
		});

		out.print("</tr></table>");
	}

}