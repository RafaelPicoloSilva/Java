package br.com.estoque.controller.tipoproduto;

import br.com.estoque.dao.TipoProdutoDAO;
import br.com.estoque.dao.GenericDAO;
import br.com.estoque.model.TipoProduto;
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
@WebServlet(name = "TipoProdutoCadastrar", urlPatterns = {"/TipoProdutoCadastrar"})
public class TipoProdutoCadastrar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idTipoProduto = Integer.parseInt(request.getParameter("idtipoproduto"));
        String descricao = request.getParameter("descricao");
        String mensagem = null;
        
        TipoProduto oTipoProduto = new TipoProduto();
        oTipoProduto.setIdTipoProduto(idTipoProduto);
        oTipoProduto.setDescricao(descricao);
        try{
            GenericDAO dao = new TipoProdutoDAO();
            if (dao.cadastrar(oTipoProduto)) {
                mensagem = "Tipo Produto cadastrado com sucesso!";
            } else  {
                mensagem = "Problemas ao cadastrar Tipo Produto. Verifique os dados informados e tente novamente!"; 
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("TipoProdutoListar");
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar TipoProduto! Erro: " +ex.getMessage());
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
