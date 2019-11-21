ALTER TABLE usuario DROP COLUMN foto;
ALTER TABLE foto MODIFY COLUMN fk_publicacao_id BIGINT(20);
ALTER TABLE foto ADD COLUMN fk_usuario_id BIGINT(20);
ALTER TABLE foto ADD FOREIGN KEY (fk_usuario_id) REFERENCES usuario(id);