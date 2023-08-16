/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estoque.dao;

/**
 *
 * @author FEF
 */
import br.com.estoque.model.Funcionario;
import br.com.estoque.model.MovimentoEstoque;
import br.com.estoque.model.Produto;
import br.com.estoque.model.TipoMovimento;
import br.com.estoque.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class MovimentoEstoqueDAO implements GenericDAO {
    private Connection conexao;
    
    public MovimentoEstoqueDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }
    
    @Override
    public Boolean cadastrar(Object objeto) {
       MovimentoEstoque oMovimentoEstoque = (MovimentoEstoque) objeto;
        Boolean retorno = false;
        if (oMovimentoEstoque.getIdMovimento()== 0) {
            retorno = this.inserir(oMovimentoEstoque);
        } else {
            retorno = this.alterar(oMovimentoEstoque);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        MovimentoEstoque oMovimentoEstoque = (MovimentoEstoque) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into movimentoestoque (entradasaida, documento, data, quantidade, valormovimento, idproduto, idtipomovimento, idfuncionario) values (?,?,?,?,?,?,?,?)";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oMovimentoEstoque.getEntradaSaida());
            stmt.setString(2, oMovimentoEstoque.getDocumento());
            stmt.setString(3, oMovimentoEstoque.getData());
            stmt.setDouble(4, oMovimentoEstoque.getQuantidade());
            stmt.setDouble(5, oMovimentoEstoque.getValorMovimento());
            stmt.setInt(6, oMovimentoEstoque.getProduto().getIdProduto());
            stmt.setInt(7, oMovimentoEstoque.getTipoMovimento().getIdTipoMovimento());
            stmt.setInt(8, oMovimentoEstoque.getFuncionario().getIdFuncionario());
            stmt.execute();
            conexao.commit();
            return true;
        } catch (Exception ex){
            try{
                System.out.println("Problemas ao cadastrar o Movimento! Erro: "+ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch(Exception e){
                System.out.println("Erro: "+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        MovimentoEstoque oMovimentoEstoque = (MovimentoEstoque) objeto;
        PreparedStatement stmt = null;
        String sql = "update movimentoestoque set entradasaida=?, documento=?, data=?, quantidade=?, valormovimento=?, "
                + "idproduto=?, idtipomovimento=?, idfuncionario=? where idmovimento=?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oMovimentoEstoque.getEntradaSaida());
            stmt.setString(2, oMovimentoEstoque.getDocumento());
            stmt.setString(3, oMovimentoEstoque.getData());
            stmt.setDouble(4, oMovimentoEstoque.getQuantidade());
            stmt.setDouble(5, oMovimentoEstoque.getValorMovimento());
            stmt.setInt(6, oMovimentoEstoque.getProduto().getIdProduto());
            stmt.setInt(7, oMovimentoEstoque.getTipoMovimento().getIdTipoMovimento());
            stmt.setInt(8, oMovimentoEstoque.getFuncionario().getIdFuncionario());
            stmt.setInt(9, oMovimentoEstoque.getIdMovimento());
            stmt.execute();
            conexao.commit();
            return true;
        } catch(Exception ex){
            try{
                System.out.println("Problemas ao alterar Movimento! Erro: "+ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            } catch(SQLException e){
                System.out.println("Erro: "+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idMovimento = numero;
        PreparedStatement stmt = null;
        
        String sql = "delete from movimentoestoque where idmovimento= ?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idMovimento);
            stmt.execute();
            conexao.commit();
            return true;
            
        }catch (Exception ex){
            System.out.println("Problemas ao excluir Movimento! Erro: "
                +ex.getMessage());
            try{
                conexao.rollback();
            } catch (SQLException e){
                System.out.println("Erro rollback "+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public Object carregar(int numero) {
        int idMovimento = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MovimentoEstoque oMovimentoEstoque = null;
        String sql="select * from movimentoestoque where idmovimento=?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idMovimento);
            rs=stmt.executeQuery();
            while (rs.next()){
                oMovimentoEstoque = new MovimentoEstoque();
                oMovimentoEstoque.setIdMovimento(rs.getInt("idMovimento"));
                oMovimentoEstoque.setEntradaSaida(rs.getString("entradasaida"));
                oMovimentoEstoque.setDocumento(rs.getString("documento"));
                oMovimentoEstoque.setData(rs.getString("data"));
                oMovimentoEstoque.setQuantidade(rs.getDouble("quantidade"));
                oMovimentoEstoque.setValorMovimento(rs.getDouble("valormovimento"));
                
                ProdutoDAO oProdutoDAO = new ProdutoDAO();
                oMovimentoEstoque.setProduto((Produto) oProdutoDAO.carregar(rs.getInt("idproduto")));
                
                TipoMovimentoDAO oTipoMovimentoDAO = new TipoMovimentoDAO();
                oMovimentoEstoque.setTipoMovimento((TipoMovimento) oTipoMovimentoDAO.carregar(rs.getInt("idtipomovimento")));
                
                FuncionarioDAO oFuncionarioDAO = new FuncionarioDAO();
                oMovimentoEstoque.setFuncionario((Funcionario) oFuncionarioDAO.carregar(rs.getInt("idfuncionario")));
                                                                    
            }
            return oMovimentoEstoque;
        }catch (Exception ex){
            System.out.println("Problemas ao carregar Movimento do Estoque! Erro: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Object> listar() {
     List<Object> resultado = new ArrayList<>();  
      PreparedStatement stmt = null;
      ResultSet rs = null;
      String sql = "Select * from movimentoestoque order by idmovimento";
      try{
          stmt = conexao.prepareStatement(sql);
          rs=stmt.executeQuery();
          while(rs.next()){
              MovimentoEstoque oMovimentoEstoque = new MovimentoEstoque();
              oMovimentoEstoque.setIdMovimento(rs.getInt("idMovimento"));
              oMovimentoEstoque.setEntradaSaida(rs.getString("entradasaida"));
              oMovimentoEstoque.setDocumento(rs.getString("documento"));
              oMovimentoEstoque.setData(rs.getString("data"));
              oMovimentoEstoque.setQuantidade(rs.getDouble("quantidade"));
              oMovimentoEstoque.setValorMovimento(rs.getDouble("valormovimento"));
                                 
              ProdutoDAO oProdutoDAO = null;
              try{
                  oProdutoDAO = new ProdutoDAO();
              }catch(Exception ex){
                  System.out.println("Erro ao buscar Produto"+ex.getMessage());
                  ex.printStackTrace();
              }
              oMovimentoEstoque.setProduto((Produto) oProdutoDAO.carregar(rs.getInt("idproduto")));
                  
              TipoMovimentoDAO oTipoMovimentoDAO = null;
              try{
                  oTipoMovimentoDAO = new TipoMovimentoDAO();
              }catch(Exception ex){
                  System.out.println("Erro ao buscar o Tipo do Movimento"+ex.getMessage());
                  ex.printStackTrace();
              }
              oMovimentoEstoque.setTipoMovimento((TipoMovimento) oTipoMovimentoDAO.carregar(rs.getInt("idtipomovimento")));
              
              FuncionarioDAO oFuncionarioDAO = null;
              try{
                  oFuncionarioDAO = new FuncionarioDAO();
              } catch(Exception ex){
                  System.out.println("Erro ao buscar Funcionario"+ex.getMessage());
                  ex.printStackTrace();
              }
              oMovimentoEstoque.setFuncionario((Funcionario) oFuncionarioDAO.carregar(rs.getInt("idfuncionario")));
              resultado.add(oMovimentoEstoque);
                   
             
          }
      }catch(SQLException ex){
          System.out.println("Problemas ao listar Movimento do Estoque! Erro: " +ex.getMessage());          
      }
      return resultado;
    }
}
