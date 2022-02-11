INSERT INTO tb_user (name, email, password, created_At) VALUES ('Bob', 'bob@gmail.com', '$2a$12$6UXYXC8mhQh6cP8TCezVM.AUzNsS93qQ8/jl9oB4j7eCaudxnvT2S', NOW())
INSERT INTO tb_user (name, email, password, created_At) VALUES ('Ana', 'ana@gmail.com', '$2a$12$NUG7oPxu7T7z1iya/Pmp7.c8MVfQ2imgw8hqPryclxZfqKuWxHJwG', NOW())

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN')
INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR')
INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR')
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER')

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2)

INSERT INTO tb_genre (name) VALUES ('Ação')
INSERT INTO tb_genre (name) VALUES ('Comédia')
INSERT INTO tb_genre (name) VALUES ('Drama')
INSERT INTO tb_genre (name) VALUES ('Terror')

INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('The Witcher', 'The Witcher', 2019, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg', 'O mutante Geralt de Rívia é um caçador de monstros que luta para encontrar seu lugar num mundo onde as pessoas muitas vezes são mais perversas que as criaturas selvagens.', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('Venom', 'Venom: Tempo de Carnificina', 2021, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/vIgyYkXkg6NC2whRbYjBD7eb3Er.jpg', 'O jovem - prestes a se tornar um serial killer - Cletus Kasady e sua namorada Frances Barrison estão sendo levados por policiais para um instituto contra a vontade deles. Mas ambos possuem dois symbiontes que os ajudam a fugir do local. Agora, no tempo presente, um ano após os acontecimentos de Venom (2018), Eddie Brock  e o symbionte Venom estão tendo dificuldades em se acostumar um com o outro. Eddie está tentando voltar com sua carreira como jornalista e para sua sorte, um detetive o aborda para entrevistar Kasady, agora preso e indo para o corredor da morte, que só quer dar entrevista se for com Eddie. Após a entrevista, Eddie e Venom acabam levando fama ao descobrirem mais das vítimas de Kasady antes que ele seja levado para a injeção da morte. Mas, no dia em que Kasady iria pagar por seus crimes, sua execução falha e seu symbionte Carnage o faz escapar da prisão. Agora, Carange e Kasady estão atrás de Venom e Eddie.', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('Shang-Chi', 'Shang-Chi e a lenda dos dez aneis', 2021, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/cinER0ESG0eJ49kXlExM0MEWGxW.jpg', 'Em Shang-Chi e a Lenda dos Dez Anéis, Shang-Chi (Simu Liu) é um jovem chinês que abandonou seu país e seu pai, que lhe treinou desde criança nas artes marciais para ser um assassino ao seu dispor. Seu pai porta Dez Anéis que lhe dão poderes e longevidade, vivendo por séculos. Porém ao conhecer a mãe de Shang-Chi, ele se apaixona e tenta mudar sua vida, mas ela morre anos depois de dar a luz para a irmã mais nova de Shang-Chi, voltando causar tumulto na China. Após completar 18 anos, Shang-chi foge de seu pai em uma missão que vingaria a morte de sua mãe, mas o passado segue Shang-Chi e agora seu pai está atrás do colar que poderia resgatar sua falecida mãe. Mas o que o pai de Shang-Chi não sabe é que o mal está à espreita e ele está caindo na armadilha de um antigo e poderoso mal.', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('Matrix', 'Matrix Resurrections', 2021, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/hv7o3VgfsairBoQFAawgaQ4cR1m.jpg', 'Matrix: Resurrections é o novo filme da franquia Matrix, continuando a saga de Neo (Keanu Reeves) em sua busca pela libertação das pessoas aprisionadas mentalmente pelas máquinas. Se passando 20 anos após os acontecimentos de de Matrix Revolutions, Neo vive uma vida aparentemente comum sob sua identidade original como Thomas A. Anderson em São Francisco, Califórnia, com um terapeuta que lhe prescreve pílulas azuis para neutralizar as coisas estranhas e não naturais que ele ocasionalmente vislumbra em sua mente. Ele também conhece uma mulher que parece ser Trinity (Carrie Anne-Moss), mas nenhum deles se reconhece. No entanto, quando uma nova versão de Morpheus oferece a ele a pílula vermelha e reabre sua mente para o mundo da Matrix, que se tornou mais seguro e perigoso nos anos desde a infecção de Smith, Neo volta a se juntar a um grupo de rebeldes para lutar contra um novo e maois perigoso inimigo e livrar todos da Matrix novamente.', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('Django Livre', 'Django Livre', 2013, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/2oZklIzUbvZXXzIFzv7Hi68d6xf.jpg', 'Django (Jamie Foxx) é um escravo liberto cujo passado brutal com seus antigos proprietários leva-o ao encontro do caçador de recompensas alemão Dr. King Schultz (Christoph Waltz). Schultz está em busca dos irmãos assassinos Brittle, e somente Django pode levá-lo a eles. O pouco ortodoxo Schultz compra Django com a promessa de libertá-lo quando tiver capturado os irmãos Brittle, vivos ou mortos.', 3)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('Titanic', 'Titanic', 1998, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/yDI6D5ZQh67YU4r2ms8qcSbAviZ.jpg', 'Jack Dawson (Leonardo DiCaprio) é um jovem aventureiro que, na mesa de jogo, ganha uma passagem para a primeira viagem do transatlântico Titanic. Trata-se de um luxuoso e imponente navio, anunciado na época como inafundável, que parte para os Estados Unidos. Nele está também Rose DeWitt Bukater (Kate Winslet), a jovem noiva de Caledon Hockley (Billy Zane). Rose está descontente com sua vida, já que sente-se sufocada pelos costumes da elite e não ama Caledon. Entretanto, ela precisa se casar com ele para manter o bom nome da família, que está falida. Um dia, desesperada, Rose ameaça se atirar do Titanic, mas Jack consegue demovê-la da ideia. Pelo ato ele é convidado a jantar na primeira classe, onde começa a se tornar mais próximo de Rose. Logo eles se apaixonam, despertando a fúria de Caledon. A situação fica ainda mais complicada quando o Titanic se choca com um iceberg, provocando algo que ninguém imaginava ser possível: o naufrágio do navio.', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('O Lobo de Wall Street', 'O Lobo de Wall Street', 2014, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/cWUOv3H7YFwvKeaQhoAQTLLpo9Z.jpg', 'Durante seis meses, Jordan Belfort (Leonardo DiCaprio) trabalhou duro em uma corretora de Wall Street, seguindo os ensinamentos de seu mentor Mark Hanna (Matthew McConaughey). Quando finalmente consegue ser contratado como corretor da firma, acontece o Black Monday, que faz com que as bolsas de vários países caiam repentinamente. Sem emprego e bastante ambicioso, ele acaba trabalhando para uma empresa de fundo de quintal que lida com papéis de baixo valor, que não estão na bolsa de valores. É lá que Belfort tem a ideia de montar uma empresa focada neste tipo de negócio, cujas vendas são de valores mais baixos mas, em compensação, o retorno para o corretor é bem mais vantajoso. Ao lado de Donnie (Jonah Hill) e outros amigos dos velhos tempos, ele cria a Stratton Oakmont, uma empresa que faz com que todos enriqueçam rapidamente e, também, levem uma vida dedicada ao prazer.', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('Aves de Rapina', 'Aves de Rapina: Arlequina e sua Emancipação Fantabulosa', 2020, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jiqD14fg7UTZOT6qgvzTmfRYpWI.jpg', 'Em Aves de Rapina - Arlequina e sua Emancipação Fantabulosa, Arlequina (Margot Robbie), Canário Negro (Jurnee Smollett-Bell), Caçadora (Mary Elizabeth Winstead), Cassandra Cain e a policial Renée Montoya (Rosie Perez) formam um grupo inusitado de heroínas. Quando um perigoso criminoso começa a causar destruição em Gotham, as cinco mulheres precisam se unir para defender a cidade', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('Rogue One', 'Rogue One: Uma História Star Wars', 2016, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/6t8ES1d12OzWyCGxBeDYLHoaDrT.jpg', 'Em Rogue One: Uma História Star Wars, Jyn Erso (Felicity Jones) foi afastada de seu pai, Galen (Mads Mikkelsen), ainda criança, devido à exigência do diretor Krennic (Ben Mendelsohn) que ele trabalhasse na construção da arma mais poderosa do Império, a Estrela da Morte. Criada por Saw Gerrera (Forest Whitaker), ela teve que aprender a sobreviver por conta própria ao completar 16 anos. Já adulta, Jyn é resgatada da prisão pela Aliança Rebelde, que deseja ter acesso a uma mensagem enviada por seu pai a Gerrera. Com a promessa de liberdade ao término da missão, ela aceita trabalhar ao lado do capitão Cassian Andor (Diego Luna) e do robô K-2SO.', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('Star Wars', 'Star Wars: A Guerra dos Clones', 2008, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/uK15I3sGd8AudO9z6J6vi0HH1UU.jpg', 'O Grande Exército da República, liderado pelos Mestres Jedi Yoda, Mace Windu, Obi-Wan Kenobi e outros, deve lutar contra o Exército dos Separatistas, para defender a união democrática e a estabilidade política da galáxia. Nos campos de batalha, eles enfrentam o ardiloso Dooku, o vingativo General Grievous e a implacável Asajj Ventress. Nos bastidores, o Senador Palpatine manipula os eventos a seu favor.', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('Star Wars', 'Star Wars: Episódio I - A Ameaça Fantasma', 1999, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/36LnijfQCOC89rCMOhn2OINXROI.jpg', 'Em Star Wars: Episódio I, quando a maquiavélica Federação Comercial planeja invadir o pacífico planeta Naboo, o guerreiro Jedi Qui-Gon Jinn (Liam Neeson) e seu aprendiz Obi-Wan Kenobi (Ewan McGregor) embarcam em uma aventura para tentar salvar o planeta. Viajam com eles a jovem Rainha Amidala (Natalie Portman), que é visada pela Federação pois querem forçá-la a assinar um tratado político. Eles têm de viajar para os distantes planetas Tatooine e Coruscant em uma desesperada tentativa de salvar o mundo de Darth Sidious (Ian McDiarmid), o demoníaco líder da Federação que sempre surge em imagens tridimensionais (a ameaça fantasma). Durante a viagem, Qui-Gon Jinn conhece um garoto de nove anos que deseja treiná-lo para ser tornar um Jedi, pois o menino tem todas as qualidades para isto. Mas o tempo revelará que nem sempre as coisas são o que aparentam.', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('Vingadores', 'Vingadores: Ultimato', 2019, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg', 'Em Vingadores: Ultimato, após Thanos eliminar metade das criaturas vivas em Vingadores: Guerra Infinita, os heróis precisam lidar com a dor da perda de amigos e seus entes queridos. Com Tony Stark (Robert Downey Jr.) vagando perdido no espaço sem água nem comida, o Capitão América/Steve Rogers (Chris Evans) e a Viúva Negra/Natasha Romanov (Scarlett Johansson) precisam liderar a resistência contra o titã louco.', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('Thor', 'Thor', 2011, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/cDJ61O1STtbWNBwefuqVrRe3d7l.jpg', 'Thor (Chris Hemsworth) estava prestes a receber o comando de Asgard das mãos de seu pai Odin (Anthony Hopkins) quando forças inimigas quebraram um acordo de paz. Disposto a se vingar do ocorrido, o jovem guerreiro desobedece as ordens do rei e quase dá início a uma nova guerra entre os reinos. Enfurecido com a atitude do filho e herdeiro, Odin retira seus poderes e o expulsa para a Terra. Lá, Thor acaba conhecendo a cientista Jane Foster (Natalie Portman) e precisa recuperar seu martelo, enquanto seu irmão Loki (Tom Hiddleston) elabora um plano para assumir o poder. Mas os guerreiros do Deus do Trovão fazem a mesma viagem para buscar o amigo e impedir que isso aconteça. Só que eles não vieram sozinhos e o inimigo está presente para uma batalha que está apenas começando.', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('Cisne Negro', 'Cisne Negro', 2011, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/hqh5O4KssfJWI62HGAgrjHXbxhD.jpg', 'Beth MacIntyre (Winona Ryder), a primeira bailarina de uma companhia, está prestes a se aposentar. O posto fica com Nina (Natalie Portman), mas ela possui sérios problemas pessoais, especialmente com sua mãe (Barbara Hershey). Pressionada por Thomas Leroy (Vincent Cassel), um exigente diretor artístico, ela passa a enxergar uma concorrência desleal vindo de suas colegas, em especial Lilly (Mila Kunis). Em meio a tudo isso, busca a perfeição nos ensaios para o maior desafio de sua carreira: interpretar a Rainha Cisne em uma adaptação de "O Lago dos Cisnes".', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('O Silêncio dos Inocentes', 'O Silêncio dos Inocentes', 1991, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/mfwq2nMBzArzQ7Y9RKE8SKeeTkg.jpg', 'A agente do FBI, Clarice Starling (Jodie Foster) é ordenada a encontrar um assassino que arranca a pele de suas vítimas. Para entender como ele pensa, ela procura o periogoso psicopata, Hannibal Lecter (Anthony Hopkins), encarcerado sob a acusação de canibalismo.', 1)
INSERT INTO tb_movie(title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('Clube da Luta', 'Clube da Luta', 1999, 'https://www.themoviedb.org/t/p/w533_and_h300_bestv2/hZkgoQYus5vegHoetLkCJzb17zJ.jpg', 'Jack (Edward Norton) é um executivo jovem, trabalha como investigador de seguros, mora confortavelmente, mas ele está ficando cada vez mais insatisfeito com sua vida medíocre. Para piorar ele está enfrentando uma terrível crise de insônia, até que encontra uma cura inusitada para o sua falta de sono ao frequentar grupos de auto-ajuda. Nesses encontros ele passa a conviver com pessoas problemáticas como a viciada Marla Singer (Helena Bonham Carter) e a conhecer estranhos como Tyler Durden (Brad Pitt). Misterioso e cheio de ideias, Tyler apresenta para Jack um grupo secreto que se encontra para extravasar suas angústias e tensões através de violentos combates corporais.', 1)


INSERT INTO tb_review (text, movie_id, user_id, created_At) VALUES ('Bom', 1, 2, NOW())
INSERT INTO tb_review (text, movie_id, user_id, created_At) VALUES ('Otimo', 1, 2, NOW())
INSERT INTO tb_review (text, movie_id, user_id, created_At) VALUES ('Bom', 2, 2, NOW())
INSERT INTO tb_review (text, movie_id, user_id, created_At) VALUES ('Bom', 10, 2, NOW())
INSERT INTO tb_review (text, movie_id, user_id, created_At) VALUES ('Otimo', 11, 2, NOW())

