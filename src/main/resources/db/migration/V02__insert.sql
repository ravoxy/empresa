INSERT into usuario (id_usuario,email,senha,status_usuario, version, situacao) values (nextval('empr_usuario_empresaesa_id_usuario_empresa_seq'),'teste@hot.com',123,'nd',now(),'ATIVO');
INSERT into usuario (id_usuario,email,senha,status_usuario, version, situacao) values (nextval('empr_usuario_empresaesa_id_usuario_empresa_seq'),'teste1@hot.com',124,'sem',now(),'ATIVO');

INSERT into empresa (id_empresa, descricao, version, situacao) values (nextval('empr_usuario_empresaesa_id_usuario_empresa_seq'),'Totem',now(),'ATIVO');
INSERT into empresa (id_empresa, descricao, version, situacao) values (nextval('empr_usuario_empresaesa_id_usuario_empresa_seq'),'Totem2',now(),'ATIVO');