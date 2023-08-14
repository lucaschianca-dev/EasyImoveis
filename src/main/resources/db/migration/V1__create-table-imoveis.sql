CREATE TABLE imoveis (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         descricao TEXT,
                         preco FLOAT,
                         tamanho VARCHAR(50),
                         cep VARCHAR(10),
                         cidade VARCHAR(255),
                         bairro VARCHAR(255),
                         rua VARCHAR(255),
                         numero VARCHAR(20),
                         permuta BOOLEAN,
                         corretor_parceiro VARCHAR(255),
                         numero_de_quartos VARCHAR(10),
                         numero_de_garagem VARCHAR(10)
);
