<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

        <h2 align="center">Tipos de Movimentos</h2>
        <table id="datatable" class="table table-striped table-bordered basic-datatable">
            <thead class="thead-dark">
                <tr>
                    <th align="left">ID</th>
                    <th align="left">Descricao</th>
                    <th align="right"></th>
                    <th align="right"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="tipomovimento" items="${tipomovimentos}">
                    <tr>
                        <td align="left">${tipomovimento.idTipoMovimento}</td>
                        <td align="left">${tipomovimento.descricao}</td>
                        <td align="center">
                            <a href="
                               ${pageContext.request.contextPath}/TipoMovimentoExcluir?idTipoMovimento=${tipomovimento.idTipoMovimento}">
                                <button class="btn btn-group-lg btn-danger">
                                    Excluir
                                </button>
                            </a>
                        </td> 
                        <td align="center">
                            <a href="
                               ${pageContext.request.contextPath}/TipoMovimentoCarregar?idTipoMovimento=${tipomovimento.idTipoMovimento}">
                            <button class="btn btn-group-lg btn-success">
                                    Alterar
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div align="center">
            <a href="${pageContext.request.contextPath}/TipoMovimentoNovo">
                <button class="btn btn-primary btn-lg">
                    Novo Cadastro
                </button>
            </a>
            <br>
            <br>
            <a href="index.jsp" class="btn">
                <button type="button" class="btn btn-primary btn-sm">
                    Retorne a p�gina inicial
                </button>
            </a>
            <br>
           
          
        </div>

        <script>
            $(document).ready(function() {
                console.log('entrei ready');
                $('#datatable').DataTable({
                    "oLanguage":{
                        "sProcessing": "Processando...",
                        "sLenghtMenu": "Mostrar _MENU_ registros",
                        "sZeroRecords": "Nenhum registro encontrado.",
                        "sInfo": "Mostrando de _START_ at� _END_ de _TOTAL_ registros",
                        "sInfoEmpty": "Mostrando de 0 at� 0 de 0 registros",
                        "sInfoFiltered": "",
                        "sInfoPostfix": "",
                        "sSearch": "Buscar: ",
                        "sUrl": "",
                    "oPaginate":{
                        "sFirst": "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext": "Seguinte",
                        "sLast": "�ltimo"
                    }    
                    }
                });
            });
        </script>
        
        <%@include file="/footer.jsp" %>