package vn.edu.iuh.fit.wwwduongtuankietgk;

import java.io.*;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.wwwduongtuankietgk.models.Candidate;
import vn.edu.iuh.fit.wwwduongtuankietgk.services.CandidateService;
import vn.edu.iuh.fit.wwwduongtuankietgk.services.Impl.CandidateServicesImpl;

@WebServlet(name = "pageServlet", value = "/page")
public class PageServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try{
        String action = request.getParameter("action");
        if(action == null) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + message + "</h1>");
            out.println("</body></html>");
            return;
        }

        switch (action){
            case "home": {
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h1> Home </h1>");
                out.println("</body></html>");
            }
            case "candidate":
                handleActionCandidate(request, response);
                break;
            case "detail-candidate":
                handleActionCandidateDetail(request, response);
                break;
            case "report1":
                handleGetReport1(request,response);
                break;
            case "report2":
                handleGetReport2(request,response);
                break;
        }
        }catch (Exception e){
            e.printStackTrace();
        }

        // Hello

    }

    private void handleGetReport2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CandidateService service = new CandidateServicesImpl();
        List<Candidate> candidates = service.findCandidateHasEmail();
        request.setAttribute("candidates",candidates);
        String page = "/report/report2.jsp";
        forwardToPage(page, request,response);
    }

    private void handleGetReport1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = "/report/report1.jsp";
        forwardToPage(page, request,response);
    }

    private void handleActionCandidateDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        long can_id = Long.parseLong(request.getParameter("id"));
        CandidateService service = new CandidateServicesImpl();
        Candidate candidate = service.getCandidateDetail(can_id);
        System.out.println(candidate);
        request.setAttribute("candidate", candidate);
        String page = "/candidate/candidate_detail.jsp";
        forwardToPage(page, request, response);
    }

    private void handleActionCandidate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CandidateService service = new CandidateServicesImpl();
        List<Candidate> candidates = service.getAllCandidate();
        request.setAttribute("candidates", candidates);
        String page = "/candidate/candidate.jsp";
        forwardToPage(page, request, response);
    }

    private void forwardToPage(String page, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(page).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        try{
            String action = request.getParameter("action");
            if(action == null) {
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h1>" + message + "</h1>");
                out.println("</body></html>");
                return;
            }
            switch (action){
                case "report1":
                    handleReportFillerCandidateByRole(request, response);
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void handleReportFillerCandidateByRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CandidateService service = new CandidateServicesImpl();
        int role = Integer.parseInt(request.getParameter("role"));
        System.out.println(role);
        List<Candidate> candidatesByRole = service.findCandidateByRole(role);
        request.setAttribute("candidates", candidatesByRole);
        String page = "/report/report1.jsp";
        System.out.println(candidatesByRole);
        forwardToPage(page, request, response);
//        response.sendRedirect();
    }

    public void destroy() {

    }
}