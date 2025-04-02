
INSERT INTO category (name, image) VALUES
        ('Bonecos', 'Bonecos - https://rihappy.vtexassets.com/arquivos/ids/6545800-800-auto'),
        ('Carros de brinquedo', 'https://rihappy.vtexassets.com/arquivos/ids/338641-800-auto'),
        ('Esportes', 'https://rihappy.vtexassets.com/arquivos/ids/6202962-800-auto'),
        ('Jogos de tabuleiro', 'https://rihappy.vtexassets.com/arquivos/ids/5787817-800-auto'),
        ('Pelúcias', 'https://rihappy.vtexassets.com/arquivos/ids/6155000-800-auto');

INSERT INTO toy (name, price, brand, image, description, fk_id_category) VALUES
        -- Categoria: Bonecos
        ('Boneco Homem-Aranha', 49.90, 'Marvel', 'https://rihappynovo.vtexassets.com/arquivos/ids/4912807-800-auto', 'Boneco articulado do Homem-Aranha com teias removíveis.', 1),

        ('Boneco Batman', 59.90, 'DC Comics', 'https://rihappynovo.vtexassets.com/arquivos/ids/6168307-800-auto', 'Batman articulado com capa removível e acessórios.', 1),
        
        -- Categoria: Carros de brinquedo
        ('Carrinho Controle Remoto', 139.90, 'Hot Wheels', 'https://rihappy.vtexassets.com/arquivos/ids/5923252-800-auto', 'Carrinho esportivo com controle remoto rápido e ágil.', 2),

        ('Miniatura Conversível', 89.90, 'Maisto', 'https://rihappynovo.vtexassets.com/arquivos/ids/5999184-800-auto', 'Miniatura detalhada de um carro conversível branco.', 2),
        
        -- Categoria: Esportes
        ('Bola de Futebol Infantil', 39.90, 'Penalty', 'https://rihappynovo.vtexassets.com/arquivos/ids/7088506-800-auto', 'Bola de futebol com tamanho e peso adaptados para crianças pequenas.', 3),

        ('Kit Ping Pong Infantil', 120.00, 'Go Play', 'https://rihappynovo.vtexassets.com/arquivos/ids/503809-800-auto', 'Conjunto com duas raquetes leves e bolas macias para iniciantes.', 3),
        
        -- Categoria: Jogos de tabuleiro
        ('Banco Imobiliário', 79.99, 'Estrela', 'https://rihappynovo.vtexassets.com/arquivos/ids/5993500-800-auto', 'Jogo clássico onde os jogadores compram e vendem propriedades.', 4),
        ('Detetive', 69.90, 'Estrela', 'https://rihappynovo.vtexassets.com/arquivos/ids/7222716-800-auto', 'Jogo de estratégia e investigação para resolver mistérios.', 4),
        
        -- Categoria: Pelúcias
        ('Ursinho Teddy', 49.90, 'Fofy Toys', 'https://rihappynovo.vtexassets.com/arquivos/ids/385199-800-auto', 'Ursinho de pelúcia macio ideal para crianças pequenas.', 5),
        ('Pelúcia Pokémon Pikachu', 59.99, 'Nintendo', 'https://rihappynovo.vtexassets.com/arquivos/ids/6164121-800-auto', 'Pelúcia do personagem Pikachu da série Pokémon.', 5);

