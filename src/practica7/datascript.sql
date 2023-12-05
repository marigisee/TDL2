-- Agregar información a la tabla 'pais'
INSERT INTO `pais` (`nombre`, `idioma`) VALUES
                                            ('Argentina', 'Español'),
                                            ('Brazil', 'Portugués'),
                                            ('Germany', 'Alemán');

-- Agregar información a la tabla 'futbolista'
INSERT INTO `futbolista` (`nombre`, `apellido`, `docIdentidad`, `telefono`, `email`, `idpais`) VALUES
                                                                                                   ('Lionel', 'Messi', '123456789', '1234567890', 'messi@example.com', 1), -- El '1' corresponde a Argentina en la tabla 'pais'
                                                                                                   ('Neymar', 'Jr', '987654321', '9876543210', 'neymar@example.com', 2);  -- El '2' corresponde a Brazil en la tabla 'pais'

-- Agregar información a la tabla 'sede'
INSERT INTO `sede` (`nombre`, `capacidad`, `idpais`) VALUES
                                                         ('Estadio Monumental', 80000, 1),  -- El '1' corresponde a Argentina en la tabla 'pais'
                                                         ('Maracanã', 78000, 2);           -- El '2' corresponde a Brazil en la tabla 'pais'
