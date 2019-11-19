CREATE TABLE usuario (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    email VARCHAR(300) NOT NULL,
    senha VARCHAR(16) NOT NULL,
    estrelas DECIMAL(3,2),
    foto MEDIUMBLOB,
    created_at DATETIME NOT NULL,
    updated_at DATETIME
) Engine = InnoDB Default Charset = utf8;

CREATE TABLE publicacao (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(144) NOT NULL,
    descricao TEXT,
    cep CHAR(8) NOT NULL,
    numero VARCHAR(10),
    complemento VARCHAR(144),
    created_at DATETIME NOT NULL,
    updated_at DATETIME,
    fk_usuario_id BIGINT(20) NOT NULL,
    
    FOREIGN KEY(fk_usuario_id) REFERENCES usuario(id)
) Engine = InnoDB Default Charset = utf8;

CREATE TABLE foto (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    arquivo MEDIUMBLOB NOT NULL,
    fk_publicacao_id BIGINT(20) NOT NULL,
    FOREIGN KEY(fk_publicacao_id) REFERENCES publicacao(id)
) Engine = InnoDB Default Charset = utf8;