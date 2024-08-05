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
('Build bridges, grow towers, terraform terrain, and fuel flying machines in the stunning followup to the multi-award winning World of Goo.',
        'worldofgoo2.jpeg',
        'World of Goo 2',
        313000,
        '2024-08-02',
        1,
        '1.0',
        2); 
INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES 
('Overlay custom crosshairs on every game you play. Choose from thousands of unique crosshairs created by the Crosshair X community or design your own using the designer.',
        'crosshair.png',
        'Crosshair X',
        84000,
        '2020-08-17',
        1,
        '1.0',
        3); 
        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES 
('Overlay custom crosshairs on every game you play. Choose from thousands of unique crosshairs created by the Crosshair X community or design your own using the designer.',
        'crosshair.png',
        'Crosshair X',
        84000,
        '2020-08-17',
        1,
        '1.0',
        3); 
  INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('Horizon Forbidden West™ Complete Edition takes you into a vast open world with dramatic battles and exciting exploration in a post-apocalyptic future. Featuring stunning graphics and expanded content, this is the complete edition of the acclaimed game.',
        'horizon.jpg',
        'Horizon Forbidden West™ Complete Edition',
        499000,
        '2024-08-10',
        1,
        '1.0',
        12);
INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('In "Suicide Squad: Kill the Justice League", players take on the role of the infamous Suicide Squad members tasked with defeating the corrupted Justice League. This action-packed game features a blend of chaotic combat and strategic gameplay.',
        'suicidesquad.jpeg',
        'Suicide Squad: Kill the Justice League',
        699000,
        '2024-08-15',
        1,    
        '1.0',
        4);

INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"F1® Manager 2024" offers players the chance to step into the shoes of a team principal, managing every aspect of a Formula 1 team, from car development to race strategy. This latest edition features enhanced graphics, more detailed management options, and up-to-date team and driver information.',
        'f1manager.jpeg',
        'F1® Manager 2024',
        799000,       -- Adjust the price as needed
        '2024-08-20', -- Adjust the release date as needed
        1,            -- Status set to 1 (bit type, represents active or released)
        '1.0',        -- Adjust the version as needed
        1);
        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('In "Hades," you play as Zagreus, the son of Hades, trying to escape the Underworld. This critically acclaimed rogue-like dungeon crawler features fast-paced combat, rich narrative, and stunning art.',
        'hades.jpeg',
        'Hades',
        399000,        -- Adjust the price as needed
        '2024-08-01',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        12); 
        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Banishers: Ghost of New Eden" is an action-adventure game where players hunt down malevolent spirits and explore a richly detailed, haunted world. It combines immersive storytelling with thrilling combat mechanics.',
        'banishers.jpeg',
        'Banishers: Ghost of New Eden',
        549000,        -- Adjust the price as needed
        '2024-09-15',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        7);
        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Intonight" is an immersive adventure game where players navigate a dystopian world filled with intrigue and danger. The game features an engaging storyline and intricate gameplay mechanics.',
        'intonight.jpeg',
        'Intonight',
        459000,        -- Adjust the price as needed
        '2024-08-25',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        5);
        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Pacific Drive" offers a thrilling survival experience in a post-apocalyptic coastal setting. Players must navigate through treacherous environments and manage limited resources.',
        'pacific.jpeg',
        'Pacific Drive',
        399000,        -- Adjust the price as needed
        '2024-09-01',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        7);

INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"SKULL AND BONES" is a high-seas adventure game that allows players to command their own pirate ship, engage in naval combat, and explore a vast open world full of danger and treasure.',
        'skull.jpeg',
        'SKULL AND BONES',
        699000,        -- Adjust the price as needed
        '2024-09-10',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        4);  
      INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Manor Lords" is a grand strategy game that combines city-building and real-time tactical combat. Players manage their own medieval manor and lead their forces in epic battles.',
        'manor.jpeg',
        'Manor Lords',
        549000,        -- Adjust the price as needed
        '2024-09-20',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        15);

        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Taxi Life: A City Driving Simulator" offers a realistic driving experience where players take on the role of a taxi driver navigating a bustling city. The game features detailed urban environments and dynamic driving challenges.',
        'taxilife.jpeg',
        'Taxi Life: A City Driving Simulator',
        349000,        -- Adjust the price as needed
        '2024-08-30',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        1);

        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Tomb Raider I-III Remastered Starring Lara Croft" brings the classic Tomb Raider games into high definition with updated graphics and improved gameplay. Players can relive the iconic adventures of Lara Croft in a modernized format.',
        'tombraider.jpeg',
        'Tomb Raider I-III Remastered Starring Lara Croft',
        499000,        -- Adjust the price as needed
        '2024-09-05',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        12);

        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"For Honor" is a melee combat game where players choose from various historical warriors to battle in intense, strategic fights. The game features a blend of swordplay, tactical combat, and multiplayer modes.',
        'forhonor.jpeg',
        'For Honor',
        399000,        -- Adjust the price as needed
        '2024-09-15',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        4);

INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Darkblade Ascent" is an action RPG where players ascend through dark and dangerous dungeons, battling fierce enemies and collecting powerful loot. The game features engaging combat and intricate dungeon design.',
        'darkblade.jpeg',
        'Darkblade Ascent',
        459000,        -- Adjust the price as needed
        '2024-09-25',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        12); 
        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Fallout 4" is an open-world RPG set in a post-apocalyptic wasteland where players explore, build settlements, and engage in deep narrative choices. The game features a vast open world with rich storytelling and immersive gameplay.',
        'fallout4.jpeg',
        'Fallout 4',
        499000,        -- Adjust the price as needed
        '2024-08-30',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        12); 
        
        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('Thank Goodness Youre Here is a charming and humorous adventure game where players help quirky characters in a whimsical world through various puzzles and tasks. The game combines engaging storylines with creative problem-solving.',
        'thankgoodness.jpeg',
        'Thank Goodness Youre Here',
        399000,        -- Adjust the price as needed
        '2024-09-01',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        5);            -- Assuming the ID for 'Adventure Game' is 5

        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Dying Light" is an open-world survival horror game where players navigate a city overrun by zombies, utilizing parkour skills and combat to survive. The game features dynamic day-night cycles and intense gameplay.',
        'dyinglight.jpeg',
        'Dying Light',
        449000,        -- Adjust the price as needed
        '2024-09-05',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        7); 

      INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Prince of Persia: The Lost Crown" is an action-adventure game set in a richly detailed Persian world. Players embark on a quest to uncover lost secrets and restore balance through a combination of platforming and combat.',
        'princeofpersia.jpeg',
        'Prince of Persia: The Lost Crown',
        499000,        -- Adjust the price as needed
        '2024-08-25',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        12); 
          INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
  VALUES ('"F1® 24" is a racing simulation game that captures the excitement and intensity of Formula 1 racing. Players can experience realistic driving physics, detailed car models, and immersive tracks from the F1 circuit.',
          'f1.jpeg',
          'F1® 24',
          599000,        -- Adjust the price as needed
          '2024-09-01',  -- Adjust the release date as needed
          1,             -- Status set to 1 (bit type, represents active or released)
          '1.0',         -- Adjust the version as needed
          1); 

          INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"A Way Out" is a cooperative action-adventure game where players work together to escape from prison and unravel a gripping story. The game emphasizes teamwork and features split-screen gameplay.',
        'a-way-out.jpg',
        'A Way Out',
        499000,        -- Adjust the price as needed
        '2024-08-20',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        5);
        
        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Need for Speed™ Heat Deluxe Edition" is an action-packed racing game that lets players explore a vibrant city while participating in high-stakes races and illegal street racing events. The Deluxe Edition includes exclusive content and bonus items.',
        'need-for-speed-deluxe.jpg',
        'Need for Speed™ Heat Deluxe Edition',
        699000,        -- Adjust the price as needed
        '2024-09-10',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        1);

        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Kenshi" is an open-world RPG that offers a unique blend of sandbox gameplay and strategic elements. Players build their own factions, explore a vast world, and engage in complex survival mechanics.',
        'kenshi.jpeg',
        'Kenshi',
        399000,        -- Adjust the price as needed
        '2024-08-15',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        12);

        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"HomeWorld 3" is a real-time strategy game set in space where players command fleets of ships and engage in large-scale space battles. The game features intricate tactical gameplay and a compelling story.',
        'homeworld-3.jpeg',
        'HomeWorld 3',
        549000,        -- Adjust the price as needed
        '2024-09-25',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        15); 

        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Need for Speed™ Most Wanted" is a high-octane racing game featuring an open-world environment where players compete in thrilling street races and evade the police. The game emphasizes customization and illicit racing.',
        'need-for-speed.jpeg',
        'Need for Speed™ Most Wanted',
        499000,        -- Adjust the price as needed
        '2024-08-25',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        1);            -- Assuming the ID for 'Simulation Game' is 1, if this game fits the category

  INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Expeditions - A MudRunner Game" is a simulation game that challenges players to navigate through rugged terrains and overcome difficult driving conditions using various off-road vehicles. The game features realistic physics and dynamic environments.',
        'expeditions.jpeg',
        'Expeditions - A MudRunner Game',
        399000,        -- Adjust the price as needed
        '2024-09-10',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        1); 

        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Fabledom" is a city-building simulation game where players construct and manage a fantasy kingdom. The game combines elements of strategy and management with a charming and whimsical setting.',
        'fabledom.jpeg',
        'Fabledom',
        349000,        -- Adjust the price as needed
        '2024-08-20',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        1);

        INSERT INTO games (description_game, image, name, price, release_date, status, version, game_type_id)
VALUES ('"Battlefield™ 1 Revolution" is a first-person shooter set during World War I, offering a comprehensive experience with a mix of large-scale battles, immersive environments, and historical accuracy. The Revolution Edition includes all major expansions and bonus content.',
        'battlefield-1.jpeg',
        'Battlefield™ 1 Revolution',
        699000,        -- Adjust the price as needed
        '2024-09-15',  -- Adjust the release date as needed
        1,             -- Status set to 1 (bit type, represents active or released)
        '1.0',         -- Adjust the version as needed
        3);

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



