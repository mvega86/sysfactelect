INSERT INTO admin.companies(id, name, acronym)	VALUES (1, 'Company1', 'C1');
INSERT INTO admin.companies(id, name, acronym)	VALUES (2, 'Company2', 'C2');

INSERT INTO admin.roles(id, name)	VALUES (1, 'Role1');
INSERT INTO admin.roles(id, name)	VALUES (2, 'Role2');

INSERT INTO admin.users(id, id_company, email, lastname, name, password, username) VALUES (1, 1, 'user1@correo.cu', 'Vega', 'Magdiel', 'asJHKJfgfdhgfJHKJHKjhk', 'user1');
INSERT INTO admin.users(id, id_company, email, lastname, name, password, username) VALUES (2, 2, 'user2@correo.cu', 'Viera', 'Maia', 'asJHKJfgfdhgfJHKJHKjhk', 'user2');

INSERT INTO admin.users_roles(id_rol, id_user)	VALUES (1, 1);
INSERT INTO admin.users_roles(id_rol, id_user)	VALUES (2, 2);