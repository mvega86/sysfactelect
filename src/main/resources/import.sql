INSERT INTO admin.companies(id, name, acronym)	VALUES ('550e8400-e29b-41d4-a716-446655440001', 'Company1', 'C1');
INSERT INTO admin.companies(id, name, acronym)	VALUES ('550e8400-e29b-41d4-a716-446655440002', 'Company2', 'C2');

INSERT INTO admin.roles(id, name)	VALUES (1, 'Role1');
INSERT INTO admin.roles(id, name)	VALUES (2, 'Role2');

INSERT INTO admin.users(id, id_company, email, lastname, name, password, username) VALUES ('f47ac10b-58cc-4372-a567-0e02b2c3d480', '550e8400-e29b-41d4-a716-446655440001', 'user1@correo.cu', 'Vega', 'Magdiel', 'asJHKJfgfdhgfJHKJHKjhk', 'user1');
INSERT INTO admin.users(id, id_company, email, lastname, name, password, username) VALUES ('f47ac10b-58cc-4372-a567-0e02b2c3d481', '550e8400-e29b-41d4-a716-446655440002', 'user2@correo.cu', 'Viera', 'Maia', 'asJHKJfgfdhgfJHKJHKjhk', 'user2');

INSERT INTO admin.users_roles(id_rol, id_user)	VALUES (1, 'f47ac10b-58cc-4372-a567-0e02b2c3d480');
INSERT INTO admin.users_roles(id_rol, id_user)	VALUES (2, 'f47ac10b-58cc-4372-a567-0e02b2c3d481');

INSERT INTO invoice.commercial(id, id_user, email, name, last_name)	VALUES ('f47ac10b-58cc-4372-a567-1e02b2c3d480', 'f47ac10b-58cc-4372-a567-0e02b2c3d480', "pepe@sargueyo", "pepe", "perez");
INSERT INTO invoice.commercial(id, id_user, email, name, last_name)	VALUES ('f47ac10b-58cc-4372-a567-1e02b2c3d481', 'f47ac10b-58cc-4372-a567-1e02b2c3d481', "pepe1@sargueyo", "pepe1", "perez1");
