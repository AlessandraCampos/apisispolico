CREATE TABLE tb_perfil
(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(255) NOT NULL
);


CREATE TABLE tb_usuario
(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(255) NOT NULL,
senha VARCHAR(255) NOT NULL,
perfil_id BIGINT,
FOREIGN KEY(perfil_id) REFERENCES tb_perfil(id)
);

Insert into tb_perfil ( id , nome) values (1, 'Admin');
Insert into tb_perfil ( id , nome) values (2, 'User');


Insert into tb_usuario ( username , senha , perfil_id) values ( 'Admin','$2a$10$4GRLI8R1pDVjvFd.GsM.2u3mVc42w2u9oqg8xBybtb0WqXB24zlcy',1);
