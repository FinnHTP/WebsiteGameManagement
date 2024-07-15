-- Bảng Game type --
INSERT INTO gametypes VALUES ('Action Game');
INSERT INTO gametypes VALUES ('Adventure Game');
INSERT INTO gametypes VALUES ('Shooter Game');
INSERT INTO gametypes VALUES ('Fighting Game');
INSERT INTO gametypes VALUES ('Survival Game');
INSERT INTO gametypes VALUES ('Rhythm Game');
INSERT INTO gametypes VALUES ('Survival Shooter Game');
INSERT INTO gametypes VALUES ('Horror Game');
INSERT INTO gametypes VALUES ('Interactive Novel Game');
INSERT INTO gametypes VALUES ('Interactive Film Game');
INSERT INTO gametypes VALUES ('Real-Time 3D Survival Game');
INSERT INTO gametypes VALUES ('Action RPG (Role-Playing Game)');
INSERT INTO gametypes VALUES ('MMORPG (Massively Multiplayer Online Role-Playing Game)');
INSERT INTO gametypes VALUES ('Grid-Based RPG (Role-Playing Game)');
INSERT INTO gametypes VALUES ('MOBA (Multiplayer Online Battle Arena)');

-- Bảng Game --
INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES
(
  'Grand Theft Auto V is an action-adventure game played from either a first-person or third-person perspective. Players complete missions—linear scenarios with set objectives—to progress through the story.',
  'gta-v.jpg',
  'Grand Theft Auto V',
  150000,
  '2013-09-17',
  1,
  '1.0',
  1
),
(
  'Pokemon is a series of video games developed by Game Freak and published by Nintendo and The Pokémon Company under the Pokémon media franchise.',
  'pokemon.jpg',
  'Pokemon',
  120000,
  '1996-02-27',
  1,
  '1.0',
  2
),
(
  'Elden Ring is an action role-playing game developed by FromSoftware and published by Bandai Namco Entertainment.',
  'elden-ring.jpg',
  'Elden Ring',
  250000,
  '2022-02-25',
  1,
  '1.0',
  1
),
(
  'Naruto Shippuden: Ultimate Ninja Storm 3 is a fighting game developed by CyberConnect2 and published by Bandai Namco Games.',
  'naruto-shippuden-3.jpg',
  'Naruto Shippuden: Ultimate Ninja Storm 3',
  110000,
  '2013-03-05',
  1,
  '1.0',
  4
),
(
  'Red Dead Redemption 2 is a Western-themed action-adventure game. Played from a first or third-person perspective, the game is set in an open-world environment featuring single-player and online multiplayer components.',
  'red-dead-redemption-2.jpg',
  'Red Dead Redemption 2',
  180000,
  '2018-10-26',
  1,
  '1.0',
  1
),
(
  'Rainbow Six Siege is an online tactical shooter video game developed by Ubisoft Montreal and published by Ubisoft.',
  'rainbow-six-siege.jpg',
  'Rainbow Six Siege',
  140000,
  '2015-12-01',
  1,
  '1.0',
  4
),
(
  'Hero Siege is a Hack ''n'' Slash game with roguelike- and RPG elements. Annihilate hordes of enemies, grow your talent tree, grind better loot, and explore up to 7 Acts enhanced with beautiful Pixel Art graphics!',
  'hero-siege.jpg',
  'Hero Siege',
  90000,
  '2014-01-29',
  1,
  '1.0',
  1
),
(
  'Dragon Ball FighterZ is a 2.5D fighting game developed by Arc System Works and published by Bandai Namco Entertainment.',
  'dragon-ball-fighterz.jpg',
  'Dragon Ball FighterZ',
  160000,
  '2018-01-26',
  1,
  '1.0',
  4
),
(
  'ARK: Survival Evolved is an action-adventure survival game set in an open world environment with a dynamic day-night cycle and played either from a third-person or first-person perspective.',
  'ark.jpg',
  'ARK: Survival Evolved',
  130000,
  '2017-08-29',
  1,
  '1.0',
  6
),
(
  'FaceRig is a program that aims to enable anyone with a webcam to digitally embody awesome characters. The output can be streamed in real-time, used for live performances, or just saved as a video file.',
  'facerig.jpg',
  'FaceRig',
  80000,
  '2015-07-07',
  1,
  '1.0',
  7
);

-- Bảng Rank type --
insert into ranktypes (name, price) values ('Bronze', 10000), ('Silver', 50000), ('Gold', 100000);






-- Grand Theft Auto V - Minimum
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'NVIDIA 9800 GT 1GB / AMD HD 4870 1GB (DX 10, 10.1, 11)',
  '4 GB RAM',
  'Windows 8.1 64 Bit, Windows 8 64 Bit, Windows 7 64 Bit Service Pack 1, Windows Vista 64 Bit Service Pack 2* (*NVIDIA video card recommended if running Vista OS)',
  'Intel Core 2 Quad CPU Q6600 @ 2.40GHz (4 CPUs) / AMD Phenom 9850 Quad-Core Processor (4 CPUs) @ 2.5GHz',
  '65 GB available space',
  1
);

-- Grand Theft Auto V - Recommended
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'NVIDIA GTX 660 2GB / AMD HD7870 2GB',
  '8 GB RAM',
  'Windows 8.1 64 Bit, Windows 8 64 Bit, Windows 7 64 Bit Service Pack 1',
  'Intel Core i5 3470 @ 3.2GHz (4 CPUs) / AMD X8 FX-8350 @ 4GHz (8 CPUs)',
  '65 GB available space',
  1
);

-- Pokemon - Minimum
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'Not specified',
  'Not specified',
  'Not specified',
  'Not specified',
  'Not specified',
  2
);

-- Pokemon - Recommended
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'Not specified',
  'Not specified',
  'Not specified',
  'Not specified',
  'Not specified',
  2
);

-- Elden Ring - Minimum
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'NVIDIA GeForce GTX 1060 or AMD Radeon RX 580',
  '16 GB RAM',
  'Windows 10',
  'Intel Core i5-4690 3.5 GHz or AMD Ryzen 3 1300X 3.5 GHz',
  '60 GB available space',
  3
);

-- Elden Ring - Recommended
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'NVIDIA GeForce GTX 1070 or AMD Radeon RX Vega 56',
  '16 GB RAM',
  'Windows 10',
  'Intel Core i7-9700K or AMD Ryzen 7 3700X',
  '60 GB available space',
  3
);

-- Naruto Shippuden: Ultimate Ninja Storm 3 - Minimum
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  '512 MB video cards Pixel Shader 4.0 (Geforce 8xxx-ATI HD2xxx)',
  '2 GB',
  'Windows XP or higher',
  '2.3 GHz Dual Core or AMD equivalent',
  '8 GB available space',
  4
);

-- Naruto Shippuden: Ultimate Ninja Storm 3 - Recommended
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'Not specified',
  'Not specified',
  'Not specified',
  'Not specified',
  'Not specified',
  4
);

-- Red Dead Redemption 2 - Minimum
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'NVIDIA GeForce GTX 1060 6GB / AMD Radeon RX 480 4GB',
  '12 GB',
  'Windows 7 - Service Pack 1 (6.1.7601)',
  'Intel Core i5-2500K / AMD FX-6300',
  '150 GB available space',
  5
);

-- Red Dead Redemption 2 - Recommended
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'NVIDIA GeForce GTX 1060 6GB / AMD Radeon RX 480 4GB',
  '12 GB',
  'Windows 10 - April 2018 Update (v1803)',
  'Intel Core i7-4770K / AMD Ryzen 5 1500X',
  '150 GB available space',
  5
);

-- Rainbow Six Siege - Minimum
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'NVIDIA GeForce GTX 460 / AMD Radeon HD 5770 / Intel HD 4000',
  '8 GB',
  'Windows 7, Windows 8.1, Windows 10 (64bit versions required)',
  'Intel Core i3 560 @ 3.3 GHz or AMD Phenom II X4 945 @ 3.0 GHz',
  '61 GB available space',
  6
);

-- Rainbow Six Siege - Recommended
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'NVIDIA GeForce GTX 670 or AMD Radeon HD 7970 / R9 280 X',
  '8 GB',
  'Windows 7 SP1, Windows 8.1, Windows 10 (64bit versions required)',
  'Intel Core i5-2500K @ 3.3 GHz or better / AMD FX-8120 @ 3.1 GHz or better',
  '61 GB available space',
  6
);

-- Hero Siege - Minimum
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'DirectX 9.0c Compatible GPU',
  '4 GB',
  'Windows 7/8/10',
  'Intel Core i3',
  '800 MB available space',
  7
);

-- Hero Siege - Recommended
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'DirectX 9.0c Compatible GPU',
  '6 GB',
  'Windows 7/8/10',
  'Intel Core i5',
  '800 MB available space',
  7
);

-- Dragon Ball FighterZ - Minimum
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'Radeon HD 6870, 1GB / GeForce GTX 650 Ti, 1GB',
  '4 GB',
  'Windows 7/8/10 (64-bit OS required)',
  'AMD FX-4350, 4.2 GHz / Intel Core i5-3470, 3.20 GHz',
  '6 GB available space',
  8
);

-- Dragon Ball FighterZ - Recommended
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'Radeon HD 7870, 2GB / GeForce GTX 660, 2GB',
  '4 GB',
  'Windows 7/8/10 (64-bit OS required)',
  'AMD Ryzen 5 1400, 3.2 GHz / Intel Core i7-3770, 3.4 GHz',
  '6 GB available space',
  8
);

-- ARK: Survival Evolved - Minimum
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'NVIDIA GTX 670 2GB / AMD Radeon HD 7870 2GB',
  '8 GB',
  'Windows 7/8.1/10 (64-bit versions)',
  'Intel Core i5-2400/AMD FX-8320 or better',
  '60 GB available space',
  9
);

-- ARK: Survival Evolved - Recommended
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'NVIDIA GTX 670 2GB / AMD Radeon HD 7870 2GB',
  '16 GB',
  'Windows 7/8.1/10 (64-bit versions)',
  'Intel Core i5-4670K/AMD Ryzen 5 1500X or better',
  '100 GB available space',
  9
);

-- FaceRig - Minimum
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'Not specified',
  '4 GB',
  'Windows® 7 or later',
  'Not specified',
  '3 GB available space',
  10
);

-- FaceRig - Recommended
INSERT INTO gameSystemRequirements (card, memory, os, processor, storage, game_id)
VALUES
(
  'Not specified',
  '8 GB',
  'Windows® 7 or later',
  'Not specified',
  '3 GB available space',
  10
);



