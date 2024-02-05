INSERT INTO admin.companies(id, name, acronym)	VALUES ('550e8400-e29b-41d4-a716-446655440001', 'Company1', 'C1');
INSERT INTO admin.companies(id, name, acronym)	VALUES ('550e8400-e29b-41d4-a716-446655440002', 'Company2', 'C2');

INSERT INTO admin.roles(id, name)	VALUES (0, 'ROLE_USER');
INSERT INTO admin.roles(id, name)	VALUES (1, 'ROLE_ADMIN');

INSERT INTO admin.users(id, id_company, email, lastname, name, password, username) VALUES ('f47ac10b-58cc-4372-a567-0e02b2c3d480', '550e8400-e29b-41d4-a716-446655440001', 'user1@correo.cu', 'Vega', 'Magdiel', 'asJHKJfgfdhgfJHKJHKjhk', 'user1');
INSERT INTO admin.users(id, id_company, email, lastname, name, password, username) VALUES ('f47ac10b-58cc-4372-a567-0e02b2c3d481', '550e8400-e29b-41d4-a716-446655440002', 'user2@correo.cu', 'Viera', 'Maia', 'asJHKJfgfdhgfJHKJHKjhk', 'user2');

INSERT INTO admin.users_roles(id_rol, id_user)	VALUES (0, 'f47ac10b-58cc-4372-a567-0e02b2c3d480');
INSERT INTO admin.users_roles(id_rol, id_user)	VALUES (1, 'f47ac10b-58cc-4372-a567-0e02b2c3d481');

INSERT INTO invoice.commercial(id, id_user, email, name, last_name)	VALUES ('f47ac10b-58cc-4372-a567-0e02b2c3d483', 'f47ac10b-58cc-4372-a567-0e02b2c3d480', 'pepe@sargueyo', 'pepe', 'perez');
INSERT INTO invoice.commercial(id, id_user, email, name, last_name)	VALUES ('f47ac10b-58cc-4372-a567-0e02b2c3d484', 'f47ac10b-58cc-4372-a567-0e02b2c3d481', 'pepe1@sargueyo', 'pepe1', 'perez1');

INSERT INTO invoice.products(id, name, description, price)	VALUES ('f47ac10b-58cc-4372-a567-0e02b2c3d473', 'Memoria Ram', 'Memoria de 2GB', 36.2);
INSERT INTO invoice.products(id, name, description, price)	VALUES ('f47ac10b-58cc-4372-a567-0e02b2c3d464', 'Memoria Ram', 'Memoria de 1GB', 30.0);
INSERT INTO invoice.products(id, name, description, price)	VALUES ('f47ac10b-58cc-4372-a567-0e02b2c3d364', 'Disco duro', 'SSD 500GB', 102.45);

INSERT INTO invoice.invoices(type, serial, date, id_commercial, description, subtotal, discount, surcharge, total, currency, status)	VALUES ('FA', 24031000, '2024-03-05', 'f47ac10b-58cc-4372-a567-0e02b2c3d483', 'Compra de memoria', 72.4, 0, 0, 72.4, 'EURO', 'Finished');
INSERT INTO invoice.invoices(type, serial, date, id_commercial, description, subtotal, discount, surcharge, total, currency, status)	VALUES ('FA', 24031001, '2024-03-05', 'f47ac10b-58cc-4372-a567-0e02b2c3d484', 'Compra de memoria', 90.0, 0, 0, 90.0, 'USD', 'Finished');

INSERT INTO invoice.invoices_products(type_invoice, serial_invoice, id_product, cant)	VALUES ('FA', 24031000, 'f47ac10b-58cc-4372-a567-0e02b2c3d473', 2);
INSERT INTO invoice.invoices_products(type_invoice, serial_invoice, id_product, cant)	VALUES ('FA', 24031001, 'f47ac10b-58cc-4372-a567-0e02b2c3d464', 3);
