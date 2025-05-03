INSERT INTO category (name, image) VALUES
                                       ('Bonecos', '/images/categories/bonecos.jpg'),
                                       ('Carros de Brinquedo', '/images/categories/carros.jpg'),
                                       ('Esportes', '/images/categories/esportes.jpg'),
                                       ('Jogos de Tabuleiro', '/images/categories/jogos-de-tabuleiro.jpg'),
                                       ('Pelúcias', '/images/categories/pelucias.jpg');

INSERT INTO toy (id, name, price, brand, image, description, category_id) VALUES
                                      -- Categoria: Bonecos
                                      (1111, 'Boneco Homem-Aranha', 49.90, 'Marvel', '/images/toys/homem-aranha.jpg', 'Boneco articulado do Homem-Aranha com teias removíveis.', 1),
                                      (2222, 'Boneco Batman', 59.90, 'DC Comics', '/images/toys/batman.jpg', 'Batman articulado com capa removível e acessórios.', 1),
                                      (3333, 'Boneco Capitão América', 54.90, 'Marvel', '/images/toys/capitao-america.jpg', 'Boneco articulado do Capitão América com escudo removível.', 1),
                                      (4444, 'Boneco Mulher-Maravilha', 52.90, 'DC Comics', '/images/toys/mulher-maravilha.jpg', 'Boneca articulada da Mulher-Maravilha com laço da verdade.', 1),
                                      (5555, 'Boneco Hulk', 49.90, 'Marvel', '/images/toys/hulk.jpg', 'Boneco do Hulk com detalhes realistas e articulações móveis.', 1),
                                      (6666, 'Boneco Superman', 57.90, 'DC Comics', '/images/toys/superman.jpg', 'Boneco articulado do Superman com capa esvoaçante.', 1),

                                      -- Categoria: Carros de brinquedo
                                      (7777, 'Carrinho Controle Remoto', 139.90, 'Hot Wheels', '/images/toys/carro-de-controle-remoto.jpg', 'Carrinho esportivo com controle remoto rápido e ágil.', 2),
                                      (8888, 'Miniatura Conversível', 89.90, 'Maisto', '/images/toys/conversivel.jpg', 'Miniatura detalhada de um carro conversível prata.', 2),
                                      (9999, 'Miniatura Monster Truck', 129.90, 'Express Wheels', '/images/toys/monster-truck.jpg', 'Carrinho Monster Truck com suspensão elevada e pneus grandes.', 2),
                                      (10101010, 'Miniatura Lamborghini', 99.90, 'Maisto', '/images/toys/lamborghini.jpg', 'Miniatura detalhada de um Lamborghini laranja.', 2),
                                      (11111111, 'Carrinho de Corrida Fórmula 1', 109.90, 'Bburago', '/images/toys/carro-f1.jpg', 'Réplica de carro de Fórmula 1 com detalhes aerodinâmicos.', 2),
                                      (12121212, 'Miniatura Jeep', 94.90, 'Maisto', '/images/toys/jeep.jpg', 'Miniatura de Jeep off-road com detalhes robustos e pneus realistas.', 2),

                                      -- Categoria: Esportes
                                      (13131313, 'Bola de Futebol', 39.90, 'Penalty', '/images/toys/bola-de-futebol.jpg', 'Bola de futebol com tamanho e peso adaptados para crianças pequenas.', 3),
                                      (14141414, 'Kit Ping Pong', 120.00, 'Go Play', '/images/toys/ping-pong.jpg', 'Conjunto com duas raquetes leves e bolas macias para iniciantes.', 3),
                                      (15151515, 'Bola de Basquete', 44.90, 'Penalty', '/images/toys/bola-de-basquete.jpg', 'Bola de basquete leve para crianças, ideal para quadras internas.', 3),
                                      (16161616, 'Kit Arco e Flecha', 89.90, 'Goal Kids', '/images/toys/arco-e-flecha.jpg', 'Kit com arco, flechas com ventosas e alvo para prática segura.', 3),
                                      (17171717, 'Patins', 149.90, 'Rollerblade', '/images/toys/patins.jpg', 'Patins ajustáveis com rodas macias para iniciantes.', 3),
                                      (18181818, 'Skate', 99.90, 'Cks Brinquedos', '/images/toys/skate.jpg', 'Skate com design colorido e rodas reforçadas para crianças.', 3),

                                      -- Categoria: Jogos de tabuleiro
                                      (19191919, 'Banco Imobiliário', 79.99, 'Estrela', '/images/toys/banco-imobiliario.jpg', 'Jogo clássico onde os jogadores compram e vendem propriedades.', 4),
                                      (20202020, 'Detetive', 69.90, 'Estrela', '/images/toys/detetive.jpg', 'Jogo de estratégia e investigação para resolver mistérios.', 4),
                                      (21212121, 'Jogo da Vida', 89.99, 'Estrela', '/images/toys/jogo-da-vida.jpg', 'Jogo clássico onde os jogadores vivem diferentes fases da vida.', 4),
                                      (22222222, 'War', 99.90, 'Grow', '/images/toys/war.jpg', 'Jogo de estratégia de conquista de territórios.', 4),
                                      (23232323, 'Imagem & Ação', 69.90, 'Grow', '/images/toys/imagem-e-acao.jpg', 'Jogo de mímicas e desenhos para diversão em grupo.', 4),
                                      (24242424, 'Cara a Cara', 59.90, 'Estrela', '/images/toys/cara-a-cara.jpg', 'Jogo de adivinhação onde jogadores descobrem personagens com perguntas.', 4),

                                      -- Categoria: Pelúcias
                                      (25252525, 'Ursinho Teddy', 49.90, 'Fofy Toys', '/images/toys/urso.jpg', 'Ursinho de pelúcia macio ideal para crianças pequenas.', 5),
                                      (26262626, 'Pokémon Pikachu', 59.99, 'Nintendo', '/images/toys/pikachu.jpg', 'Pelúcia do personagem Pikachu da série Pokémon.', 5),
                                      (27272727, 'Coelho Flofy', 44.90, 'Fofy Toys', '/images/toys/coelho.jpg', 'Coelho de pelúcia macio, perfeito para abraços.', 5),
                                      (28282828, 'Baby Yoda', 69.99, 'Star Wars', '/images/toys/yoda.jpg', 'Pelúcia do Baby Yoda da série Star Wars.', 5),
                                      (29292929, 'Unicórnio Brilhante', 54.90, 'Fofy Toys', '/images/toys/unicornio.jpg', 'Unicórnio de com chifre brilhante e cores vibrantes.', 5),
                                      (30303030, 'Leão Simba', 64.90, 'Disney', '/images/toys/simba.jpg', 'Pelúcia do Simba, personagem de O Rei Leão, macia e detalhada.', 5);