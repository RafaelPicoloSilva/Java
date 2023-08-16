package br.com.estoque.controller.movimentoestoque;

import br.com.estoque.dao.TipoMovimentoDAO;
import br.com.estoque.dao.FuncionarioDAO;
import br.com.estoque.dao.MovimentoEstoqueDAO;
import br.com.estoque.dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Cliente
 */
@WebServlet(name = "MovimentoEstoqueCarregar", urlPatterns = {"/MovimentoEstoqueCarregar"})
public class MovimentoEstoqueCarregar extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        try{
            int idMovimento = Integer.parseInt(request.getParameter("idMovimento"));
            
            MovimentoEstoqueDAO oMovimentoEstoqueDAO = new MovimentoEstoqueDAO();
            
            request.setAttribute("movimentoestoque", oMovimentoEstoqueDAO.carregar(idMovimento));
            
            ProdutoDAO oProdutoDAO = new ProdutoDAO();
            request.setAttribute("produtos", oProdutoDAO.listar());
            
            TipoMovimentoDAO oTipoMovimentoDAO = new TipoMovimentoDAO();
            request.setAttribute("tipomovimentos", oTipoMovimentoDAO.listar());
            
            FuncionarioDAO oFuncionarioDAO = new FuncionarioDAO();
            request.setAttribute("funcionarios", oFuncionarioDAO.listar());
            
            request.getRequestDispatcher("/cadastros/movimentoestoque/movimentoestoqueCadastrar.jsp").forward(request, response);
        }catch(Exception ex){
            System.out.println("Erro ao carregar MovimentoEstoque"+ex.getMessage());
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
