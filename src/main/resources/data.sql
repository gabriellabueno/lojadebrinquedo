INSERT INTO category (name) VALUES
        ('Bonecos'),
        ('Carros de brinquedo'),
        ('Esportes'),
        ('Jogos de tabuleiro'),
        ('Pelúcias');

INSERT INTO toy (name, price, brand, image, description) VALUES
        -- Categoria: Bonecos
        ('Boneco Homem-Aranha', 49.90, 'Marvel', 'https://rihappynovo.vtexassets.com/arquivos/ids/4912807', 'Boneco articulado do Homem-Aranha com teias removíveis.'),
        ('Boneco Batman', 59.90, 'DC Comics', 'https://rihappynovo.vtexassets.com/arquivos/ids/6168307', 'Batman articulado com capa removível e acessórios.'),
        
        -- Categoria: Carros de brinquedo
        ('Carrinho Controle Remoto', 139.90, 'Hot Wheels', 'https://rihappy.vtexassets.com/arquivos/ids/5923252', 'Carrinho esportivo com controle remoto rápido e ágil.'),
        ('Miniatura Conversível', 89.90, 'Maisto', 'https://rihappynovo.vtexassets.com/arquivos/ids/5999184', 'Miniatura detalhada de um carro conversível branco.'),
        
        -- Categoria: Esportes
        ('Bola de Futebol Infantil', 39.90, 'Penalty', 'https://rihappynovo.vtexassets.com/arquivos/ids/7088506', 'Bola de futebol com tamanho e peso adaptados para crianças pequenas.'),
        ('Kit Ping Pong Infantil', 120.00, 'Go Play', 'https://rihappynovo.vtexassets.com/arquivos/ids/503809', 'Conjunto com duas raquetes leves e bolas macias para iniciantes.'),
        
        -- Categoria: Jogos de tabuleiro
        ('Banco Imobiliário', 79.99, 'Estrela', 'https://rihappynovo.vtexassets.com/arquivos/ids/5993500', 'Jogo clássico onde os jogadores compram e vendem propriedades.'),
        ('Detetive', 69.90, 'Estrela', 'https://rihappynovo.vtexassets.com/arquivos/ids/7222716', 'Jogo de estratégia e investigação para resolver mistérios.'),
        
        -- Categoria: Pelúcias
        ('Ursinho Teddy', 49.90, 'Fofy Toys', 'https://rihappynovo.vtexassets.com/arquivos/ids/385199', 'Ursinho de pelúcia macio ideal para crianças pequenas.'),
        ('Pelúcia Pokémon Pikachu', 59.99, 'Nintendo', 'https://rihappynovo.vtexassets.com/arquivos/ids/6164121', 'Pelúcia do personagem Pikachu da série Pokémon.');

INSERT INTO store (fk_id_toy, fk_id_category) VALUES
          (1, 1), -- Homem-Aranha - Bonecos
          (2, 1), -- Batman - Bonecos
          (3, 2), -- Carrinho Controle Remoto - Carros de brinquedo
          (4, 2), -- Miniatura Ferrari - Carros de brinquedo
          (5, 3), -- Bola de Futebol Infantil - Esportes
          (6, 3), -- Kit Raquete de Tênis Infantil - Esportes
          (7, 4), -- Banco Imobiliário - Jogos de tabuleiro
          (8, 4), -- Detetive - Jogos de tabuleiro
          (9, 5), -- Ursinho Teddy - Pelúcias
          (10, 5); -- Pelúcia Pokémon Pikachu - Pelúcias
