INSERT INTO category (name) VALUES
        ('Bonecos'),
        ('Carros de brinquedo'),
        ('Esportes'),
        ('Jogos de tabuleiro'),
        ('Pelúcias');

INSERT INTO toy (name, price, brand, image, description) VALUES
        -- Categoria: Bonecos
        ('Boneco Homem-Aranha', 49.90, 'Marvel', 'spiderman.png', 'Boneco articulado do Homem-Aranha com teias removíveis.'),
        ('Boneco Batman', 59.90, 'DC Comics', 'batman.png', 'Batman articulado com capa removível e acessórios.'),
        
        -- Categoria: Carros de brinquedo
        ('Carrinho Controle Remoto', 139.90, 'Hot Wheels', 'carro-controle.png', 'Carrinho esportivo com controle remoto rápido e ágil.'),
        ('Miniatura Ferrari', 89.90, 'Maisto', 'ferrari-mini.png', 'Miniatura detalhada de uma clássica Ferrari vermelha.'),
        
        -- Categoria: Esportes
        ('Bola de Futebol Infantil', 39.90, 'Penalty', 'bola-futebol.png', 'Bola de futebol com tamanho e peso adaptados para crianças pequenas.'),
        ('Kit Raquete de Tênis Infantil', 120.00, 'Wilson', 'kit-tenis.png', 'Conjunto com duas raquetes leves e bolas macias para iniciantes.'),
        
        -- Categoria: Jogos de tabuleiro
        ('Banco Imobiliário', 79.99, 'Estrela', 'banco-imobiliario.png', 'Jogo clássico onde os jogadores compram e vendem propriedades.'),
        ('Detetive', 69.90, 'Estrela', 'detetive.png', 'Jogo de estratégia e investigação para resolver mistérios.'),
        
        -- Categoria: Pelúcias
        ('Ursinho Teddy', 49.90, 'Fofy Toys', 'ursinho-teddy.png', 'Ursinho de pelúcia macio ideal para crianças pequenas.'),
        ('Pelúcia Pokémon Pikachu', 59.99, 'Nintendo', 'pikachu-peluche.png', 'Pelúcia oficial do personagem Pikachu da série Pokémon.');

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
