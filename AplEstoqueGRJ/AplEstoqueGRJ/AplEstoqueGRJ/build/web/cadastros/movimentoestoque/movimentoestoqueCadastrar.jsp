<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrarMovimentoEstoque" action="MovimentoEstoqueCadastrar"
      method="POST">
    
    <div class="form-group">
    <table align="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastrar Movimento de Estoque
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
                <td><input type="text" name="idmovimento" id="idmovimento" value="${movimentoestoque.idMovimento}" readonly="readonly" class="form-control" 
                           style="pointer-events: none;"/></td></tr>
            
            <tr><td>Entrada/Saida: </td>
                <td><input type="text" name="entradasaida" id="entradasaida" value="${movimentoestoque.entradaSaida}"
                           size="50" maxlength="50" class="form-control"/></td></tr>
            <tr><td>Documento: </td>
                <td><input type="text" name="documento" id="documento" value="${movimentoestoque.documento}"
                           size="50" maxlength="50" class="form-control"/></td></tr>
            <tr><td>Data: </td>
                <td><input type="text" name="data" id="data" value="${movimentoestoque.data}"
                           size="50" maxlength="50" class="form-control"/></td></tr>
            <tr><td>Quantidade: </td>
                <td><input type="text" name="quantidade" id="quantidade" value="${movimentoestoque.quantidade}"
                           size="50" maxlength="50" class="form-control"/></td></tr>
            <tr><td>Valor Movimento: </td>
                <td><input type="text" name="valormovimento" id="valormovimento" value="${movimentoestoque.valorMovimento}"
                           size="50" maxlength="50" class="form-control"/></td></tr>
            <tr><td>Produto: </td>
                <td>
                    <select name="idproduto" id="idproduto" class="form-control">
                        <option value="">
                            Selecione
                        </option>
                        <c:forEach var="produto" items="${produtos}">
                            <option value="${produto.idProduto}"
                                    ${MovimentoEstoque.produto.idproduto == produto.idProduto? "selected" : ""}>
                                    ${produto.nomeProduto}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr><td>Tipo Movimento: </td>
                <td>
                    <select name="idtipomovimento" id="idtipomovimento" class="form-control">
                        <option value="">
                            Selecione
                        </option>
                        <c:forEach var="tipomovimento" items="${tipomovimentos}">
                            <option value="${tipomovimento.idTipoMovimento}"
                                    ${MovimentoEstoque.tipomovimento.idtipomovimento == tipomovimento.idTipoMovimento? "selected" : ""}>
                                    ${tipomovimento.descricao}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr><td>Funcionario: </td>
                <td>
                    <select name="idfuncionario" id="idfuncionario" class="form-control">
                        <option value="">
                            Selecione
                        </option>
                        <c:forEach var="funcionario" items="${funcionarios}">
                            <option value="${funcionario.idFuncionario}"
                                    ${MovimentoEstoque.funcionario.idfuncionario == funcionario.idFuncionario? "selected" : ""}>
                                    ${funcionario.nomeFuncionario}
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