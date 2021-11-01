insert into domain (name) values ('Banco de Dados');
insert into domain (name) values ('LDAP');

insert into system_user (name, login, password, domain_id, last_acess) values ('Cal Lightman', 'cal', '123', 1, CURRENT_TIMESTAMP);
insert into system_user (name, login, password, domain_id, last_acess) values ('Gillian Foster', 'gillian', '123', 1, CURRENT_TIMESTAMP);
insert into system_user (name, login, password, domain_id, last_acess) values ('Ria Torres', 'ria', '123', 1, CURRENT_TIMESTAMP);
insert into system_user (name, login, password, domain_id, last_acess) values ('Eli Locker', 'eli', '123', 1, CURRENT_TIMESTAMP);
insert into system_user (name, login, password, domain_id, last_acess) values ('Emily Lightman', 'emily', '123', 1, CURRENT_TIMESTAMP);

insert into configuration (user_id, receiveNotifications, logoutAutomatically) values (1, false, false);