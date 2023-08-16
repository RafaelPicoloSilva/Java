/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  FEF
 * Created: 01/06/2023
 */

CREATE TABLE tipoproduto (
    idtipoproduto serial primary key,
    descricao varchar(100)
);

CREATE TABLE unidademedida (
    idunidademedida serial primary key,
    descricao varchar(100),
    sigla varchar(2)
);

CREATE TABLE produto (
    idproduto serial primary key,
    nomeproduto varchar(100),
    ultimoprecopago numeric,
    saldoatual numeric,
    idtipoproduto integer,
    idunidademedida integer,
    foreign key (idtipoproduto) references tipoproduto (idtipoproduto),
    foreign key (idunidademedida) references unidademedida (idunidademedida)
);

CREATE TABLE tipomovimento (
	idtipomovimento serial primary key,
	descricao varchar(100)
);

CREATE TABLE funcionario (
	idfuncionario serial primary key,
	nomefuncionario varchar(100)
);

CREATE TABLE movimentoestoque (
	idmovimento serial primary key,
	entradasaida varchar(1),
	documento varchar(100),
	data varchar(10),
	quantidade numeric,
	valormovimento numeric,
	idproduto integer,
	idtipomovimento integer,
	idfuncionario integer,
	foreign key (idproduto) references produto (idproduto),
	foreign key (idtipomovimento) references tipomovimento (idtipomovimento),
	foreign key (idfuncionario) references funcionario (idfuncionario)
);


CREATE OR REPLACE FUNCTION atualizaestoque() RETURNS TRIGGER AS 
$$
BEGIN
	IF NEW.entradasaida = 'E' THEN
		UPDATE produto SET saldoatual = (saldoatual + NEW.quantidade)
		WHERE produto.idproduto = NEW.idproduto;
	ELSE
		UPDATE produto SET saldoatual = (saldoatual - NEW.quantidade)
		WHERE produto.idproduto = NEW.idproduto;
	END IF;
	RETURN NULL;
END
$$ LANGUAGE plpgsql;

CREATE TRIGGER atualizaestoque
AFTER INSERT OR UPDATE 
ON movimentoestoque
FOR EACH ROW
EXECUTE FUNCTION atualizaestoque();




