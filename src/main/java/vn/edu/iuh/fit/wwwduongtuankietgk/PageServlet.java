package vn.edu.iuh.fit.wwwduongtuankietgk;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.wwwduongtuankietgk.models.Candidate;
import vn.edu.iuh.fit.wwwduongtuankietgk.services.CandidateService;
import vn.edu.iuh.fit.wwwduongtuankietgk.services.Impl.CandidateServicesImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "pageServlet", value = "/page")
public class PageServlet extends HttpServlet {
    private String message;
    
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
            try{
                String action = req.getParameter("action");
                if(action == null){
                    PrintWriter out = resp.getWriter();
                    out.println("<html><body>");
                    out.println("<h1>" + message + "</h1>");
                    out.println("</body></html>");
                    return;
                }switch (action){
                    case "home" : {
                        PrintWriter out = resp.getWriter();
                        out.println("<html><body>");
                        out.println("<h1> Home </h1>");
                        out.println("</body></html>");
                    }
                    case "candidate":
                        handleActionCandidate(req, resp);
                        break;
                    case "detail-candidate":
                        handleActionCandidateDetail(req, resp);
                        break;
                    case "handleGetReport1":
                        handleGetReport1(req,resp);
                        break;
                    case "handleGetReport2":
                        handleGetReport2(req,resp);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
    }

    private void handleGetReport2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CandidateService service = new CandidateServicesImpl();
        List<Candidate> candidates = service.findCandidateHasEmail();
        req.setAttribute("candidates", candidates);

        String page = "/Report/report2.jsp";
        forwardToPage(page, req, resp);
    }

    private void handleGetReport1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page = "/Report/report1.jsp";
        forwardToPage(page, req, resp);
    }

    private void handleActionCandidateDetail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        long can_id = Long.parseLong(req.getParameter("id"));
        CandidateService service = new CandidateServicesImpl();
        Candidate candidate = service.getCandidateDetail(can_id);
        System.out.println(candidate);
        req.setAttribute("candidate", candidate);
        String page = "/Candidate/candidate_detail.jsp";
        forwardToPage(page, req, resp);
    }

    private void handleActionCandidate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CandidateService service = new CandidateServicesImpl();
        List<Candidate> candidates = service.getAllCandidate();
        req.setAttribute("candidates", candidates);
        String page = "/Candidate/candidate.jsp";
        forwardToPage(page, req, resp);
    }

    private void forwardToPage(String page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(page).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String action = req.getParameter("action");
            if(action == null){
                PrintWriter out = resp.getWriter();
                out.println("<html><body>");
                out.println("<h1>" + message + "</h1>");
                out.println("</body></html>");
                return;
            }
            switch (action){
                case "report1" : {
                    handleReportFillterCandidateByRole(req,resp);
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    private void handleReportFillterCandidateByRole(HttpServletRequest req, HttpServletResponse resp) {

    }
}
