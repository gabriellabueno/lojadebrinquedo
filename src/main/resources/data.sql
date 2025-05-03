
INSERT INTO category (name, image_url) VALUES
        ('Bonecos', 'https://rihappy.vtexassets.com/arquivos/ids/6545800-800-auto'),
        ('Carros de Brinquedo', 'https://rihappy.vtexassets.com/arquivos/ids/338641-800-auto'),
        ('Esportes', 'https://rihappy.vtexassets.com/arquivos/ids/6202962-800-auto'),
        ('Jogos de Tabuleiro', 'https://rihappy.vtexassets.com/arquivos/ids/5787817-800-auto'),
        ('Pelúcias', 'https://rihappy.vtexassets.com/arquivos/ids/6155000-800-auto');

INSERT INTO toy (id, name, price, brand, image_url, description, category_id) VALUES
      -- Categoria: Bonecos
      (1111, 'Boneco Homem-Aranha', 49.90, 'Marvel', 'https://rihappynovo.vtexassets.com/arquivos/ids/4912807-800-auto', 'Boneco articulado do Homem-Aranha com teias removíveis.', 1),
      (2222, 'Boneco Batman', 59.90, 'DC Comics', 'https://rihappynovo.vtexassets.com/arquivos/ids/6168307-800-auto', 'Batman articulado com capa removível e acessórios.', 1),
      (3333, 'Boneco Capitão América', 54.90, 'Marvel', 'https://rihappy.vtexassets.com/arquivos/ids/7079413', 'Boneco articulado do Capitão América com escudo removível.', 1),
      (4444, 'Boneco Mulher-Maravilha', 52.90, 'DC Comics', ' https://rihappy.vtexassets.com/arquivos/ids/6168352', 'Boneca articulada da Mulher-Maravilha com laço da verdade.', 1),
      (5555, 'Boneco Hulk', 49.90, 'Marvel', ' https://rihappy.vtexassets.com/arquivos/ids/6242042', 'Boneco do Hulk com detalhes realistas e articulações móveis.', 1),
      (6666, 'Boneco Superman', 57.90, 'DC Comics', 'https://rihappy.vtexassets.com/arquivos/ids/6170744', 'Boneco articulado do Superman com capa esvoaçante.', 1),

      -- Categoria: Carros de brinquedo
      (7777, 'Carrinho Controle Remoto', 139.90, 'Hot Wheels', 'https://rihappy.vtexassets.com/arquivos/ids/5923252-800-auto', 'Carrinho esportivo com controle remoto rápido e ágil.', 2),
      (8888, 'Miniatura Conversível', 89.90, 'Maisto', 'https://rihappy.vtexassets.com/arquivos/ids/6653481', 'Miniatura detalhada de um carro conversível prata.', 2),
      (9999, 'Miniatura Monster Truck', 129.90, 'Express Wheels', 'https://rihappy.vtexassets.com/arquivos/ids/6349275', 'Carrinho Monster Truck com suspensão elevada e pneus grandes.', 2),
      (10101010, 'Miniatura Lamborghini', 99.90, 'Maisto', 'https://rihappy.vtexassets.com/arquivos/ids/7471009', 'Miniatura detalhada de um Lamborghini laranja.', 2),
      (11111111, 'Carrinho de Corrida Fórmula 1', 109.90, 'Bburago', ' https://rihappy.vtexassets.com/arquivos/ids/5999446', 'Réplica de carro de Fórmula 1 com detalhes aerodinâmicos.', 2),
      (12121212, 'Miniatura Jeep', 94.90, 'Maisto', 'https://rihappy.vtexassets.com/arquivos/ids/6967744', 'Miniatura de Jeep off-road com detalhes robustos e pneus realistas.', 2),

      -- Categoria: Esportes
      (13131313, 'Bola de Futebol', 39.90, 'Penalty', 'https://rihappynovo.vtexassets.com/arquivos/ids/7088506-800-auto', 'Bola de futebol com tamanho e peso adaptados para crianças pequenas.', 3),
      (14141414, 'Kit Ping Pong', 120.00, 'Go Play', 'https://rihappynovo.vtexassets.com/arquivos/ids/503809-800-auto', 'Conjunto com duas raquetes leves e bolas macias para iniciantes.', 3),
      (15151515, 'Bola de Basquete', 44.90, 'Penalty', 'https://rihappynovo.vtexassets.com/arquivos/ids/7793487', 'Bola de basquete leve para crianças, ideal para quadras internas.', 3),
      (16161616, 'Kit Arco e Flecha', 89.90, 'Goal Kids', 'https://rihappynovo.vtexassets.com/arquivos/ids/7996512', 'Kit com arco, flechas com ventosas e alvo para prática segura.', 3),
      (17171717, 'Patins', 149.90, 'Rollerblade', ' https://rihappynovo.vtexassets.com/arquivos/ids/8159264', 'Patins ajustáveis com rodas macias para iniciantes.', 3),
      (18181818, 'Skate', 99.90, 'Cks Brinquedos', 'https://rihappy.vtexassets.com/arquivos/ids/6355944', 'Skate com design colorido e rodas reforçadas para crianças.', 3),

      -- Categoria: Jogos de tabuleiro
      (19191919, 'Banco Imobiliário', 79.99, 'Estrela', 'https://rihappynovo.vtexassets.com/arquivos/ids/5993500-800-auto', 'Jogo clássico onde os jogadores compram e vendem propriedades.', 4),
      (20202020, 'Detetive', 69.90, 'Estrela', 'https://rihappynovo.vtexassets.com/arquivos/ids/7222716-800-auto', 'Jogo de estratégia e investigação para resolver mistérios.', 4),
      (21212121, 'Jogo da Vida', 89.99, 'Estrela', 'https://rihappynovo.vtexassets.com/arquivos/ids/1636489', 'Jogo clássico onde os jogadores vivem diferentes fases da vida.', 4),
      (22222222, 'War', 99.90, 'Grow', 'https://rihappynovo.vtexassets.com/arquivos/ids/5904211', 'Jogo de estratégia de conquista de territórios.', 4),
      (23232323, 'Imagem & Ação', 69.90, 'Grow', 'https://rihappynovo.vtexassets.com/arquivos/ids/6792887', 'Jogo de mímicas e desenhos para diversão em grupo.', 4),
      (24242424, 'Cara a Cara', 59.90, 'Estrela', 'https://rihappynovo.vtexassets.com/arquivos/ids/346281', 'Jogo de adivinhação onde jogadores descobrem personagens com perguntas.', 4),

      -- Categoria: Pelúcias
      (25252525, 'Ursinho Teddy', 49.90, 'Fofy Toys', 'https://rihappynovo.vtexassets.com/arquivos/ids/385199-800-auto', 'Ursinho de pelúcia macio ideal para crianças pequenas.', 5),
      (26262626, 'Pokémon Pikachu', 59.99, 'Nintendo', 'https://rihappynovo.vtexassets.com/arquivos/ids/6164121-800-auto', 'Pelúcia do personagem Pikachu da série Pokémon.', 5),
      (27272727, 'Coelho Flofy', 44.90, 'Fofy Toys', 'https://rihappy.vtexassets.com/arquivos/ids/6205634', 'Coelho de pelúcia macio, perfeito para abraços.', 5),
      (28282828, 'Baby Yoda', 69.99, 'Star Wars', ' https://rihappy.vtexassets.com/arquivos/ids/6123169', 'Pelúcia do Baby Yoda da série Star Wars.', 5),
      (29292929, 'Unicórnio Brilhante', 54.90, 'Fofy Toys', 'https://rihappy.vtexassets.com/arquivos/ids/8121184', 'Unicórnio de com chifre brilhante e cores vibrantes.', 5),
      (30303030, 'Leão Simba', 64.90, 'Disney', 'https://rihappy.vtexassets.com/arquivos/ids/8207021', 'Pelúcia do Simba, personagem de O Rei Leão, macia e detalhada.', 5);
