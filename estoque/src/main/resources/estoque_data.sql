INSERT INTO ES01FILIAL (ES01_VARCHAR_NOME) VALUES ('NOSSO CHEFF');

INSERT INTO ES02PRODUTO (PK02_VARCHAR_NOME, FK02_01_INT_IDFILIAL) VALUES ('MAÇÃ', 1);
INSERT INTO ES02PRODUTO (PK02_VARCHAR_NOME, FK02_01_INT_IDFILIAL) VALUES ('PIZZA', 1);

INSERT INTO ES05ESTOQUE (ES05_INT_QUANTIDADE, FK05_02_INT_IDPRODUTO) VALUES (10, 1);
INSERT INTO ES05ESTOQUE (ES05_INT_QUANTIDADE, FK05_02_INT_IDPRODUTO) VALUES (30, 2);
