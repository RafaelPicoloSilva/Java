package br.com.estoque.controller.movimentoestoque;

import br.com.estoque.dao.GenericDAO;
import br.com.estoque.dao.MovimentoEstoqueDAO;
import br.com.estoque.model.Produto;
import br.com.estoque.model.TipoMovimento;
import br.com.estoque.model.Funcionario;
import br.com.estoque.model.MovimentoEstoque;
import br.com.estoque.model.UnidadeMedida;
import br.com.estoque.model.TipoProduto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MovimentoEstoqueCadastrar", urlPatterns = {"/MovimentoEstoqueCadastrar"})
public class MovimentoEstoqueCadastrar extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idMovimento = Integer.parseInt(request.getParameter(("idmovimento")));
        String entradaSaida = request.getParameter("entradasaida");
        String documento = request.getParameter("documento");
        String data = request.getParameter("data");
        Double quantidade = Double.parseDouble(request.getParameter("quantidade"));
        Double valorMovimento = Double.parseDouble(request.getParameter("valormovimento"));
        int idProduto = Integer.parseInt(request.getParameter("idproduto"));
        int idTipoMovimento = Integer.parseInt(request.getParameter("idtipomovimento"));
        int idFuncionario = Integer.parseInt(request.getParameter("idfuncionario"));
        String mensagem = null;
        
        try{
            
            MovimentoEstoque oMovimentoEstoque = new MovimentoEstoque();
            oMovimentoEstoque.setIdMovimento(idMovimento);
            oMovimentoEstoque.setEntradaSaida(entradaSaida);
            oMovimentoEstoque.setDocumento(documento);
            oMovimentoEstoque.setData(data);
            oMovimentoEstoque.setQuantidade(quantidade);
            oMovimentoEstoque.setValorMovimento(valorMovimento);
            oMovimentoEstoque.setProduto(new Produto(idProduto, "", 0.0, 0.0, new TipoProduto(), new UnidadeMedida()));
            oMovimentoEstoque.setTipoMovimento(new TipoMovimento(idTipoMovimento, ""));            
            oMovimentoEstoque.setFuncionario(new Funcionario(idFuncionario, ""));            
            
            GenericDAO dao = new MovimentoEstoqueDAO();
            if (dao.cadastrar(oMovimentoEstoque)) {
                mensagem = "MovimentoEstoque cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar MovimentoEstoque. Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("MovimentoEstoqueListar");
        }catch(Exception ex){
            System.out.println("Problemas no Servlet ao cadastrar MovimentoEstoque! Erro: "+ex.getMessage());
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
