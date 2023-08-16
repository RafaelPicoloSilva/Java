<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarProduto" action="ProdutoCadastrar"
      method="POST">
    
    <div class="form-group">
    <table align="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastro de Produtos
                </th>
            </tr>
            <tr>
                <th colspan="2" align="center">
                    ${mensagem}
                </th>
            </tr>
        </thead>
        <tbody>
            <tr><td>ID: </td>
                <td><input type="text" name="idproduto" id="idproduto" value="${produto.idProduto}" readonly="readonly" 
                           class="form-control" style="pointer-events: none;"/></td></tr>
            <tr><td>Nome Produto: </td>
                <td><input type="text" name="nomeproduto" id="nomeproduto" value="${produto.nomeProduto}"
                           size="50" maxlength="50" class="form-control"/></td></tr>
            <tr><td>Ultimo Preço Pago: </td>
                <td><input type="text" name="ultimoprecopago" id="ultimoprecopago" value="${produto.ultimoPrecoPago}"
                           size="50" maxlength="50" class="form-control"/></td></tr>
            <tr><td>Saldo Atual: </td>
                <td><input type="text" name="saldoatual" id="saldoatual" value="${produto.saldoAtual}"
                           size="50" maxlength="50" class="form-control"/></td></tr>
            <tr><td>Tipo Produto: </td>
                <td>
                    <select name="idtipoproduto" id="idtipoproduto" class="form-control">
                        <option value="">
                            Selecione
                        </option>
                        <c:forEach var="tipoproduto" items="${tipoprodutos}">
                            <option value="${tipoproduto.idTipoProduto}"
                                    ${Produto.tipoproduto.idtipoproduto == tipoproduto.idTipoProduto ? "selected" : ""}>
                                    ${tipoproduto.descricao}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr><td>Unidade Medida: </td>
                <td>
                    <select name="idunidademedida" id="idunidademedida" class="form-control">
                        <option value="">
                            Selecione
                        </option>
                         <c:forEach var="unidademedida" items="${unidademedidas}">
                            <option value="${unidademedida.idUnidadeMedida}"
                                    ${Produto.unidademedida.idunidademedida == unidademedida.idUnidadeMedida ? "selected" : ""}>
                                    ${unidademedida.descricao}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr><td colspan="2" align="center" style="padding: 20px">
                    <input type="submit" name="cadastar" id="cadastrar" value="Cadastrar" class="btn btn-outline-primary btn-lg"/>
                    
                    <input type="reset" name="limpar" id="limpar" value="Limpar" class="btn btn-outline-primary btn-lg"/>
                </td></tr>
        
            <tr>
                            <td align="center" colspan="2"><h5><a href="index.jsp">
                    <button type="button" class="btn btn-primary btn-sm">
                    Retorne a página inicial
                    </button>
                        </a></h5></td>
            </tr>
        </tbody>
    </table>
    </div>
</form>
            
                <%@include file="/footer.jsp" %>