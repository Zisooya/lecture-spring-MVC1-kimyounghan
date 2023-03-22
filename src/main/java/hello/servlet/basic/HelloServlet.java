package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 애노테이션으로 서블릿을 실행할 수 있다.
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // 매핑된 url로 이 서블릿이 호출되면 이 service 메서드가 호출됨.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // 웹브라우저 url창에서 쿼리파라미터 보낸 후 조회해보기
        // => request.getParameter()로 조회한다.
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 응답 메세지 보내기
        // 1. 단순 문자로 보내는 설정
        response.setContentType("text/plain");
        // 2. 인코딩 정보 설정
        response.setCharacterEncoding("utf-8");
        // 3.  response.getWriter().write(): HTTP메세지 바디에 데이터가 들어가게 해줌.
        response.getWriter().write("hello " + username);
    }

}
