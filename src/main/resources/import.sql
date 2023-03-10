drop table if exists carro cascade;
drop table if exists cliente cascade;
drop table if exists aluguel;

CREATE TABLE carro (id SERIAL NOT NULL, autonomia VARCHAR(255) NOT NULL, combustivel VARCHAR(255) NOT NULL, descricao VARCHAR(255) NOT NULL, disponibilidade BOOLEAN, modelo VARCHAR(255) NOT NULL, motor VARCHAR(255) NOT NULL, nome VARCHAR(255) NOT NULL, placa VARCHAR(255) NOT NULL, potencia VARCHAR(255) NOT NULL, taxa FLOAT(53) NOT NULL, valor_dia FLOAT(53) NOT NULL, PRIMARY KEY (id));

CREATE TABLE cliente (id SERIAL NOT NULL, is_admin BOOLEAN, cpf VARCHAR(255) NOT NULL, nome VARCHAR(255) NOT NULL, email VARCHAR(255) , senha VARCHAR(255) NOT NULL, PRIMARY KEY (id));

CREATE TABLE aluguel (cliente_id INTEGER NOT NULL, carro_id INTEGER NOT NULL, FOREIGN KEY (cliente_id) REFERENCES cliente (id), FOREIGN KEY (carro_id) REFERENCES carro (id));

INSERT INTO carro (id, autonomia, combustivel, descricao, disponibilidade, modelo, motor, nome, placa, potencia, taxa, valor_dia) VALUES (1001, '800 km', 'Gasolina', 'Carro de passeio', true, 'Fusca', '1.6', 'VW Fusca', 'ABC-1234', '60 cv', 5.0, 80.0);

INSERT INTO carro (id, autonomia, combustivel, descricao, disponibilidade, modelo, motor, nome, placa, potencia, taxa, valor_dia) VALUES (1002, '1000 km', 'Etanol', 'Carro esportivo', true, 'Mustang', '5.0', 'Ford Mustang', 'DEF-5678', '450 cv', 20.0, 250.0);

INSERT INTO carro (id, autonomia, combustivel, descricao, disponibilidade, modelo, motor, nome, placa, potencia, taxa, valor_dia) VALUES (1003, '500 km', 'Diesel', 'SUV', true, 'Tiguan', '2.0', 'VW Tiguan', 'GHI-9012', '180 cv', 15.0, 200.0);

INSERT INTO cliente (id, is_admin, cpf, nome, email, senha) VALUES (1001, true, '999.999.999-99', 'admin', 'admin@admin.com', 'admin');