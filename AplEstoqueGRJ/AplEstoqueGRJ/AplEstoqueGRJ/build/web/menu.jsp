
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Menu</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/MovimentoEstoqueListar">Movimento de Estoque</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Cadastros
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/ProdutoListar">Produto</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/UnidadeMedidaListar">Unidade de Medida</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/FuncionarioListar">Funcionario</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/TipoProdutoListar">Tipo de Produto</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/TipoMovimentoListar">Tipo de Movimento</a>
                </div>             
            </li>
            
            
        </ul>
    </div>
</nav>