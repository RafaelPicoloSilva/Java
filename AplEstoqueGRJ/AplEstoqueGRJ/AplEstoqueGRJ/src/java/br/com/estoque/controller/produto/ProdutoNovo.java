/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.controller.produto;

import br.com.estoque.dao.TipoProdutoDAO;
import br.com.estoque.dao.UnidadeMedidaDAO;
import br.com.estoque.model.Produto;
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
@WebServlet(name = "ProdutoNovo", urlPatterns = {"/ProdutoNovo"})
public class ProdutoNovo extends HttpServlet {

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
        
       try{
        Produto oProduto = new Produto();
        request.setAttribute("produto", oProduto);
        TipoProdutoDAO oTipoProdutoDAO = new TipoProdutoDAO();
            request.setAttribute("tipoprodutos", oTipoProdutoDAO.listar());
            
            UnidadeMedidaDAO oUnidadeMedidaDAO = new UnidadeMedidaDAO();
            request.setAttribute("unidademedidas", oUnidadeMedidaDAO.listar());
            
        request.getRequestDispatcher("/cadastros/produto/produtoCadastrar.jsp").forward(request, response);
       } catch (Exception ex){
           System.out.println("Erro ao cadastrar nova produto!" +ex.getMessage());
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
