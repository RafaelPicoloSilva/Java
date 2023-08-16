<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1" %>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>


        <h2 align="center">Movimento de Estoque</h2>
        
        <div align="center">
                    <button class="btn btn-secondary btn-sm" onclick="imprimirTabela()">Imprimir</button>
                </div>
        
        <table id="datatable" class="table table-striped table-bordered basic-datatable">
            <thead class="thead-dark">
                <tr>
                    <th align="left">ID</th>
                    <th align="left">Entrada/Saida</th>
                    <th align="left">Documento</th>
                    <th align="left">Data</th>
                    <th align="left">Quantidade</th>
                    <th align="left">Valor Movimento</th>
                    <th align="left">Produto</th>
                    <th align="left">Tipo de Movimento</th>
                    <th align="left">Funcionario</th>
                    <th align="right"></th>
                    <th align="right"></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="movimentoestoque" items="${movimentoestoques}">
                    <tr>
                        <td align="left">${movimentoestoque.idMovimento}</td>
                        <td align="left">${movimentoestoque.entradaSaida}</td>
                        <td align="left">${movimentoestoque.documento}</td>
                        <td align="left">${movimentoestoque.data}</td>
                        <td align="left">${movimentoestoque.quantidade}</td>
                        <td align="left">${movimentoestoque.valorMovimento}</td>
                        <td align="left">${movimentoestoque.produto.nomeProduto}</td>
                        <td aligtn="left">${movimentoestoque.tipoMovimento.descricao}</td>
                        <td aligtn="left">${movimentoestoque.funcionario.nomeFuncionario}</td>
                        <td align="center">
                            <a href="
                               ${pageContext.request.contextPath}/MovimentoEstoqueExcluir?idMovimento=${movimentoestoque.idMovimento}">
                                <button class="btn btn-group-lg btn-danger"/>
                                    Excluir
                                </button>
                            </a>
                        </td> 
                        <td align="center">
                            <a href="
                               ${pageContext.request.contextPath}/MovimentoEstoqueCarregar?idMovimento=${movimentoestoque.idMovimento}">
                                <button class="btn btn-group-lg btn-success"/>
                                    Alterar
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div align="center">
            <a href="${pageContext.request.contextPath}/MovimentoEstoqueNovo">
                <button class="btn btn-primary btn-lg">
                    Novo Cadastro
                </button>
            </a>
            <br>
            <br>
            <a href="index.jsp" class="btn">
                <button type="button" class="btn btn-primary btn-sm">
                    Retorne a página inicial
                </button>
            </a>
            <br>
        </div>
                
                
                
                <script>
                    function imprimirTabela() {
                    window.print();
                    }
                </script>

        <script>
            $(document).ready(function() {
                console.log('entrei ready');
                $('#datatable').DataTable({
                    "oLanguage":{
                        "sProcessing": "Processando...",
                        "sLenghtMenu": "Mostrar _MENU_ registros",
                        "sZeroRecords": "Nenhum registro encontrado.",
                        "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                        "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                        "sInfoFiltered": "",
                        "sInfoPostfix": "",
                        "sSearch": "Buscar: ",
                        "sUrl": "",
                    "oPaginate":{
                        "sFirst": "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext": "Seguinte",
                        "sLast": "Último"
                    }    
                    }
                });
            });
        </script>
        
        <%@include file="/footer.jsp" %>