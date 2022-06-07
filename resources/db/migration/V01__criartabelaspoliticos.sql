create table tb_endereco (
id BIGINT AUTO_INCREMENT PRIMARY KEY, 
logradouro VARCHAR(100) not null,
numero VARCHAR(10) not null,
cidade VARCHAR(100) not null,
estado VARCHAR(100) not null,
cep VARCHAR(8) NOT NULL
);


create table tb_cargo (
id BIGINT AUTO_INCREMENT PRIMARY KEY, 
nome VARCHAR(100) not null,
descricao LONGTEXT
);

create table tb_partido (
id BIGINT AUTO_INCREMENT PRIMARY KEY, 
sigla VARCHAR(100) not null,
nome VARCHAR(100)
);

create table tb_pessoa (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100) not null,
cpf VARCHAR(100) not null,
telefone VARCHAR(100) not null,
partido_id BIGINT,
cargo_id BIGINT not null,
foto VARCHAR(100) not null,
atribuicao VARCHAR(50),
endereco_id BIGINT NOT NULL
);

create table tb_processos (
id BIGINT AUTO_INCREMENT PRIMARY KEY, 
numero INT not null,
pessoa_id BIGINT NOT NULL,
descricao LONGTEXT not null
);

create table tb_projetolei (
id BIGINT AUTO_INCREMENT PRIMARY KEY, 
numero INT not null,
data DATE not null,
descricao LONGTEXT not null,
pessoa_id BIGINT NOT NULL
);



Alter table tb_pessoa add foreign key(cargo_id) references tb_cargo(id);
Alter table tb_pessoa add foreign key(partido_id) references tb_partido(id);
Alter table tb_processos add foreign key(pessoa_id) references tb_pessoa(id);
Alter table tb_projetolei add foreign key(pessoa_id) references tb_pessoa(id);
Alter table tb_pessoa add foreign key(endereco_id) references tb_endereco(id);



Insert into tb_cargo(id , nome , descricao ) values (1, 'Vereador', 'Ao vereador cabe elaborar as leis municipais e fiscalizar a atuação do Executivo – no caso, o prefeito. São os vereadores que propõem, discutem e aprovam as leis a serem aplicadas no município.');

Insert into tb_cargo(id , nome , descricao ) values (2, 'Governador', 'Governador é o cargo político que representa o poder executivo na esfera dos Estados e do Distrito Federal. É função do governador: a direção da administração estadual e a representação do Estado em suas relações jurídicas, políticas e administrativas, defendendo seus interesses junto à Presidência e buscando investimentos.');

Insert into tb_cargo(id , nome , descricao ) values (3, 'Deputado Estadual', 'Poder Legislativo- Câmara dos Deputados.');

Insert into tb_cargo(id , nome , descricao ) values (4, 'Deputado Federal', 'Poder Legislativo do Brasil  formado pelo Senado Federal.');

Insert into tb_cargo(id , nome , descricao ) values (5, 'Senador', 'Processar e julgar o presidente e o vice-presidente da República nos crimes de responsabilidade, bem como os ministros de Estado e os comandantes da Marinha, do Exército e da Aeronáutica nos crimes da mesma natureza conexos com aqueles');                      
                       
Insert into tb_cargo(id , nome , descricao ) values (6 , 'Ministro' , 'Um ministro é o membro de um governo nacional ou, ocasionalmente, subnacional, com importantes funções executivas.');

Insert into tb_cargo(id , nome , descricao ) values (7 , 'Prefeito' , 'O prefeito é o cargo político responsável pela gestão dos municípios no Brasil, e, portanto, esse cargo representa o Executivo na esfera municipal.');

Insert into tb_cargo(id , nome , descricao ) values (8 , 'Presidente' , 'O presidente é a autoridade máxima do Poder Executivo e da República, cabendo-lhe as tarefas de chefe de Estado e chefe de governo. ');




Insert into tb_partido(sigla , nome ) values ('NDA', 'Sem registro de partido');
Insert into tb_partido( sigla , nome ) values ('PSDB', 'Partido da Social Democracia Brasileira');
Insert into tb_partido(sigla , nome ) values ('PP', 'Partido Progressista');
Insert into tb_partido(sigla , nome ) values ('Patriota', 'Partido PATRIOTA');
Insert into tb_partido(sigla , nome ) values ('DEM', 'Partido Democratas');
Insert into tb_partido(sigla , nome ) values ('MDB', 'Partido do Movimento Democrático Brasileiro');
Insert into tb_partido(sigla , nome ) values ('PL', 'Partido Liberal');
Insert into tb_partido(sigla , nome ) values ('PSL', 'Partido Social Liberal');
Insert into tb_partido( sigla , nome ) values ('PODEMOS', 'Podemos');

Insert into tb_endereco(logradouro , numero , cidade, estado, cep) values ('Rua Das Flores', '254', 'São Paulo', 'SP', '03570180');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Rua Maria Candida', '280', 'São Paulo', 'SP', '02071002');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Rua Oswald Andrade', '1080', 'São Paulo', 'SP', '03071002');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Rua das Margaridas', '14', 'São Paulo', 'SP', '08071022');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Rua Machado de Assis', '300', 'São Paulo', 'SP', '09071035');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Rua Joselino de Souza', '1204', 'Brasilia', 'DF', '08071035');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Asa Sul Quadra 5', '104', 'Brasilia', 'DF', '08071030');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Centro Quadra 4', '568', 'Brasilia', 'DF', '05081040');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Rua Salim Farah', '858', 'Sao Paulo', 'SP', '07081080');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Avenida Brasil', '227', 'Rio de Janeiro', 'RJ', '09081080');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Rua Janio Quadros', '157', 'Rio de Janeiro', 'RJ', '04071020');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Rua Jucelino kubitschek', '441', 'Goiania', 'GO', '03071060');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Rua Elis Regina', '651', 'Brasilia', 'DF', '02071030');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Quinta da Magnolia', '1051', 'Brasilia', 'DF', '06071070');
INSERT INTO `tb_endereco` (`logradouro`, `numero`, `cidade`, `estado`, `cep`) VALUES ('Rua Guido Nunes', '152', 'Rio de Janeiro', 'RJ', '04071028');

Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Thammy Miranda','61892900009','11925252525',1,1,'https://img.estadao.com.br/thumbs/640/resources/jpg/2/3/1553276565832.jpg','Sem atribuicao', 1);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Fernando Holiday','33246633002','11985858585',4,1,'https://www.saopaulo.sp.leg.br/wp-content/uploads/2017/01/holliday-nova.jpg','Sem atribuicao', 2);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Milton Leite','99852336037','11974747474',5,1,'https://www.saopaulo.sp.leg.br/wp-content/uploads/2014/10/thumbnail_milton-leite.jpg','Sem atribuicao', 3);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Ronaldo Ramos Caiado','03502560048','11942524252',5,2,'https://www.senado.leg.br/senadores/img/fotos-oficiais/senador456.jpg','Nda', 12);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Cláudio Castro','81768352003','11932323232',7,2,'https://fotospublicas.com/wp-content/uploads/2021/05/51150881853_74b6c79fa7_k-1024x577.jpg','Nda', 10);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Arthur Durval','67099390066','1188888888',5,3,'https://www3.al.sp.gov.br/repositorio/deputadoPortal/fotos/20190315-170109-id=543-GRD.jpg','Sem atribuicao', 4);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Janaína Paschoal','01989092098','11747474748',8,3,'https://www3.al.sp.gov.br/repositorio/deputadoPortal/fotos/20210723-200434-id=524-PEQ.jpg','Líder', 5);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Celina Leão','00780390024','11972728585',3,4,'https://www.camara.leg.br/internet/deputado/bandep/pagina_do_deputado/204380.jpg','Sem atribuicao', 6);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Luis Miranda','39052314098','11962728686',5,4,'https://www.camara.leg.br/internet/deputado/bandep/pagina_do_deputado/204381.jpg','Sem atribuicao', 8);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Mara Gabrilli','63521475000','6133032191',2,5,'https://www.camara.leg.br/internet/deputado/bandep/160565.jpgmaior.jpg','Sem atribuicao', 7);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Jorge Kajuru','51811051065','6133032844',9,5,'https://www.senado.leg.br/senadores/img/fotos-oficiais/senador5895.jpg','Sem atribuicao', 13);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Tarcísio Gomes de Freitas','85191107039','6133032833',1,6,'https://img.estadao.com.br/resources/jpg/6/4/1625246474346.jpg','Ministro da Infraestrutura', 14);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Augusto Heleno','94117832018','6133032814',4,6,'http://www.eb.mil.br/image/journal/article?img_id=13017447&t=1616503085343.jpg','Gabinete de Segurança Institucional', 12);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Ricardo Nunes','32703888023','1133052522',6,7,'https://www.saopaulo.sp.leg.br/wp-content/uploads/2014/10/ricardo-nunes.jpg','Prefeito de São Paulo', 9);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Eduardo Paes','29048535026','2123055881',2,7,'https://www.camara.leg.br/internet/deputado/bandep/74683.jpgmaior.jpg','Prefeito do Rio de janeiro', 11);
Insert into tb_pessoa(nome , cpf , telefone ,partido_id,cargo_id, foto, atribuicao,endereco_id) values ('Jair Messias Bolsonaro','59906148020','21974747474',1,8,'https://cdn.oantagonista.com/uploads/2020/12/jair-bolsonaro-17.dez_.2020.jpg','Presidente da República', 15);


Insert into tb_projetolei   (numero , data , descricao , pessoa_id) values (728 ,'2021-10-26' ,'Institui o Programa Jovem Capitalista, com o objetivo de promover a educação financeira e empreendedora no âmbito das escolas de Ensino Médio vinculadas à Secretaria da Educação.', 6);
INSERT INTO `tb_projetolei` (`numero`, `data`, `descricao`, `pessoa_id`) VALUES (711, '2021-10-19', 'Denomina Professora Heley de Abreu Silva Batista a Escola Estadual Paulo Freire Educador, em Osasco.', 6);
INSERT INTO `tb_projetolei` (`numero`, `data`, `descricao`, `pessoa_id`) VALUES (1082, '2021-02-19', 'Dispõe sobre a inclusão de medidas de capacitação socioemocional no projeto', 1);
INSERT INTO `tb_projetolei` (`numero`, `data`, `descricao`, `pessoa_id`) VALUES (504, '2021-02-19', 'ALTERA A REDAÇÃO DO ARTIGO 1º DA LEI 11.359 DE MAIO DE 1993 E DÁ OUTRAS PROVIDÊNCIAS.PROÍBE A REALIZAÇÃO DE RODEIOS, TOURADAS OU EVENTOS SIMILARES.', 2);
INSERT INTO `tb_projetolei` (`numero`, `data`, `descricao`, `pessoa_id`) VALUES (662, '2021-02-19', 'ESTABELECE NORMAS GERAIS DE SEGURANÇA EM BOATES, CASAS NOTURNAS E DEMAIS ESTABELECIMENTOS ABERTOS AO PÚBLICO E DÁ OUTRAS PROVIDÊNCIAS.', 3);
INSERT INTO `tb_projetolei` (`numero`, `data`, `descricao`, `pessoa_id`) VALUES (766, '2021-05-05', 'emenda  para garantir que as famílias habilitadas para fins de adoção tenham prioridade na obtenção da guarda', 7);
INSERT INTO `tb_projetolei` (`numero`, `data`, `descricao`, `pessoa_id`) VALUES (8266, '2021-02-20', 'emenda para prevenir o esquecimento também de crianças no interior de veículos', 7);
INSERT INTO `tb_projetolei` (`numero`, `data`, `descricao`, `pessoa_id`) VALUES (15, '2021-10-18', 'Emenda dispõe sobre a concessão do Abono-FUNDEB aos profissionais da educação básica da rede estadual de ensino, na forma que especifica', 7);

INSERT INTO `tb_processos` ( `numero`, `pessoa_id`, `descricao`) VALUES (322, 6, 'Desvio de verbas para Covid-19');
INSERT INTO `tb_processos` ( `numero`, `pessoa_id`, `descricao`) VALUES (05820, 11, 'Cumprimento Provisório de Sentença - Indenização por Dano Moral');
INSERT INTO `tb_processos` ( `numero`, `pessoa_id`, `descricao`) VALUES (05844, 3, 'Desvio de verbas para Covid-19');
INSERT INTO `tb_processos` ( `numero`, `pessoa_id`, `descricao`) VALUES (08820, 4, 'Corrupçao passiva');
INSERT INTO `tb_processos` ( `numero`, `pessoa_id`, `descricao`) VALUES (03524, 6, 'Desvio de verbas Educacao');
INSERT INTO `tb_processos` ( `numero`, `pessoa_id`, `descricao`) VALUES (004412, 9, 'Prevaricacao');

