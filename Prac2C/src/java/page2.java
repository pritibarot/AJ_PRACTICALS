import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class page2 extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet page2</title>");            
            out.println("</head>");
            out.println("<body bgcolor=red>");
            HttpSession hs=request.getSession(false);
            out.println("Welcome again "+hs.getAttribute("uname")+" on page2");
            int visit=Integer.parseInt((String)hs.getAttribute("visit"))+1;
            out.println("<h1>You visited "+visit+" Times</h1>");
            hs.setAttribute("visit",""+visit);
            out.println("<h1>Your session id is "+hs.getId()+"</h1>");
            out.println("<h1>You logged in at "+new java.util.Date(hs.getCreationTime())+"</h1>");
            out.println("<h1><a href=page1>Click here to visit page1</a></h1><br>");
            out.println("<h1><a href=page3>Click here to visit page3</a></h1><br>");
            out.println("<h1><a href=page4>Click here to visit page4</a></h1><br>");
            out.println("<h1><a href=LogoutServlet>Click here to terminate</a></h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
