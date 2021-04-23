package controller;

import model.Contract;
import model.ContractDetail;
import model.ExtraService;
import service.IContractDetailService;
import service.IContractService;
import service.IExtraServiceService;
import service.impl.ContractDetailServiceImpl;
import service.impl.ContractServiceImpl;
import service.impl.ExtraServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet", urlPatterns = "/contractdetails")
public class ContractDetailServlet extends HttpServlet {

    IContractDetailService contractDetailService = new ContractDetailServiceImpl();
    IContractService contractService = new ContractServiceImpl();
    IExtraServiceService extraServiceService = new ExtraServiceServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContractDetail(request, response);
                break;
            case "edit":

                break;
            case "delete":

                break;
            case "search":
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":

                break;
            case "view":

                break;
            default:
                listAllContractDetail(request, response);
                break;
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Long contractid = Long.parseLong(request.getParameter("contractid"));
        Long extraserviceid = Long.parseLong(request.getParameter("extraserviceid"));
        Contract contract = contractService.findById(contractid);
        ExtraService extraService = extraServiceService.findById(extraserviceid);

        ContractDetail contractDetail = new ContractDetail(quantity, contract, extraService);
        contractDetailService.save(contractDetail);

        //...

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/contractdetail/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listAllContractDetail(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDetail> contractDetailList = contractDetailService.findAll();
        List<Contract> contractList = contractService.findAll();
        List<ExtraService> extraServiceList = extraServiceService.findAll();

        request.setAttribute("contractDetailList", contractDetailList);
        request.setAttribute("contractList", contractList);
        request.setAttribute("extraServiceList", extraServiceList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/admin/contractdetail/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
