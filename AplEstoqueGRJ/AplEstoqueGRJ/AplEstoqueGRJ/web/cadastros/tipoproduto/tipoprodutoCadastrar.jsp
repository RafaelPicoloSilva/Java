<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<form name="cadastrartipoproduto" action="TipoProdutoCadastrar"
      method="POST">
    
    <div class="form-group">
    <table align="center" border="0">
        <thead>
            <tr>
                <th colspan="2" align="center">
                    Cadastro de Tipo de Produto
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
                <td><input type="text" name="idtipoproduto" id="idtipoproduto" value="${tipoproduto.idTipoProduto}" readonly="readonly"
                           class="form-control" style="pointer-events: none;"/></td></tr>
            <tr><td>Descri��o: </td>
                <td><input type="text" name="descricao" id="descricao" value="${tipoproduto.descricao}"
                           size="50" maxlength="50" class="form-control"/></td></tr>
            
            <tr><td colspan="2" align="center" style="padding: 20px">
                    <input type="submit" name="cadastar" id="cadastrar" value="Cadastrar" class="btn btn-outline-primary btn-lg"/>
                    
                    <input type="reset" name="limpar" id="limpar" value="Limpar" class="btn btn-outline-primary btn-lg"/>
                </td></tr>
        
            <tr>
                            <td align="center" colspan="2"><h5><a href="index.jsp">
                    <button type="button" class="btn btn-primary btn-sm">
                    Retorne a p�gina inicial
                    </button>
                        </a></h5></td>
            </tr>
        </tbody>
    </table>
    </div>
</form>
            
                <%@include file="/footer.jsp" %>