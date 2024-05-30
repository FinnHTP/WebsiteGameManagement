-- Bảng Game type --
insert into gametypes values ('Game hành động');
insert into gametypes values ('Game phiêu lưu');
insert into gametypes values ('Game bắn súng');
insert into gametypes values ('Game đối kháng');
insert into gametypes values ('Game sinh tồn');
insert into gametypes values ('Game âm nhạc giai điệu');
--7
insert into gametypes values ('Game bắn súng sinh tồn');
--8
insert into gametypes values ('Game kinh dị');
--9
insert into gametypes values ('Game tiểu thuyết tương tác');
--10
insert into gametypes values ('Game điện ảnh tương tác');
--11
insert into gametypes values ('Game 3D sinh tồn thời gian thực');
--12
insert into gametypes values ('Game nhập vai hành động');
--13
insert into gametypes values ('Game nhập vai trực tuyến');
--14
insert into gametypes values ('Game nhập vai dạng lưới');
--15
insert into gametypes values ('Game chiến thuật Moba');

-- Bảng Game --
insert into games values ('Diablo Immortal là một tựa game nhập vai có cốt truyện vô cùng hấp dẫn và đầy kịch tính. Để bắt đầu trò chơi, bạn sẽ phải lựa chọn 1 trong 6 nhân vật, tương ứng với 6 class: Barbarian, Monk, Witcher, Demon Hunter, Crusader và Necromancer. Những nhân vật này sẽ có chiêu thức, lối chơi và bộ kỹ năng khác nhau. Trong quá trình chơi, bạn sẽ phải thực hiện nhiệm vụ thu thập những mảnh vỡ từ các viên đá Stoneworld đặt tại những vị trí khác nhau, với các mức độ từ dễ đến khó.','Diablo',800000,'03-20-2018',1,'Version 2.0.1',1);
insert into games values ('Dark Sword 2 là tựa game lấy bối cảnh từ tương lai, nơi mà khoa học và công nghệ đã phát triển đến đỉnh cao với sự xuất hiện của nhiều người máy tối tân. Tuy nhiên, bọn người máy khi được nâng cấp và cải tiến đã dần mất kiểm soát, bắt đầu tấn công con người, phá hủy các thành phố và biến những nơi chúng đi qua trở nên hoàng tàn. Cùng với nhiều người chơi khác, bạn sẽ hóa thân thành một chiến binh anh hùng thực thụ để chống lại cỗ máy hung tàn đáng sợ và giữ vững bình yên cho nhân loại. ','Dark Sword 2',700000,'02-17-2019',1,'Version 2.3.1',1);
insert into games values ('Câu chuyện trong Genshin Impact bắt đầu từ một biến cố bất ngờ, hai anh em đã phải chiến đấu với nữ thần vô danh và nhân vật của người chơi bị đẩy lạc vào thế giới Teyvat bí ẩn. Tại đây, bạn sẽ trải qua cuộc hành trình khám phá lục địa rộng lớn, kết giao bạn bè, đi tìm 7 vị thần Nguyên tố để đến cuối cùng gặp lại người anh em thất lạc của mình.','Genshin Impact',1200000,'01-20-2020',1,'Version 1.5.7',12);
insert into games values ('Kể từ khi ra mắt, Talion đã nhận được nhiều đánh giá cao cho cốt truyện kịch tính, hấp dẫn và được so sánh với những bộ phim bom tấn kinh điển hiện nay. Bước vào Talion, người chơi sẽ tham gia vào một chuỗi nhiệm vụ có cấp độ từ dễ đến khó nhằm khám phá toàn bộ thế giới game. Để hoàn thành mỗi nhiệm vụ trong khoảng thời gian nhanh nhất, bạn cần phải tư duy và đưa ra được chiến lược hợp lý.','Tailon',500000,'11-01-2018',0,'Version 1.8.6',1);
insert into games values ('Final Fantasy được xây dựng theo phong cách Nhật Bản, gây sốt với tạo hình nhân vật đẹp mắt cùng các kỹ năng, chiêu thức ấn tượng. Đến với Final Fantasy, bạn sẽ phải tham gia các nhiệm vụ cá nhân hoặc cùng với đồng đội thực hiện những trận chiến có cấp độ từ đơn giản đến khó. Đồng thời, đừng quên thu thập thêm nhiều vàng, kinh nghiệm để có thể nâng cao level và nâng cấp thêm trang bị, vật phẩm của mình nữa nhé.','Final Fantasy',200000,'09-15-2021',0,'Version 2.8.1',1);	
insert into games values ('Dungeon Hunter 5 cho phép bạn hóa thân thành một chiến binh tinh nhuệ và di chuyển qua 5 vùng đất khác nhau nhằm tiêu diệt bọn quái vật đáng sợ còn sót lại trên Trái Đất, bảo vệ bình yên cho nhân loại. Để chiến đấu với quái, bạn có thể lựa chọn 1 trong 5 loại vũ khí như song đao, kiếm, trường thương, cung và gậy phép.','Dungeon Hunter 5',0,'10-02-2019',0,'Version 2.0.0',1);
insert into games values ('Warface là một tựa game bắn súng có giao diện vô cùng bắt mắt, hiện đại và chân thực đang nhận được đánh giá cao của các game thủ. Đến với Warface Mobile, bạn sẽ trải nghiệm một khung cảnh mưa bom, bão đạn, các vụ nổ diễn ra liên tiếp và những pha giao tranh vô cùng kịch tính, đẹp mắt. ','warface',100000,'03-20-2019',1,'Version 2.0.0',1);
insert into games values ('Shadowblood là tựa game sở hữu đồ họa 3D bắt mắt, và hàng loạt những pha giao tranh máu lửa diễn ra liên tục. Đến với Shadowblood, bạn sẽ hóa thân thành chiến binh anh hùng, tham gia vào cuộc chiến chống lại các thế lực bóng tối, đứng lên đấu tranh và bảo vệ nền hòa bình của thế giới. Suốt trên đường di chuyển, bạn sẽ phải chiến đấu qua 100 cấp độ thử thách khác nhau trong mode Campaign với vô vàn quái vật dị hợm và boss nguy hiểm.','Shadowblood',400000,'05-20-2021',1,'Version 2.1.3',1);
insert into games values ('Nhân vật chính của tựa game này là Dante. Anh là một thợ săn quỷ đang cố gắng và nỗ lực hết sức mình để chống lại những cuộc xâm lăng của loài quỷ đến Trái Đất. Đúng như thể loại game hành động, trò chơi này chủ yếu tập trung vào các cuộc chiến đấu. Trong game, người chơi phải cố gắng thực hiện được nhiều combo chiến đấu để hạ gục nhiều kẻ thù cùng một lúc.','Devil May Cry Series',105000,'03-20-2023',1,'Version 1.0.3',1);
insert into games values ('Bối cảnh của game là một thế giới ảo của năm 1960. Nhân vật chính của trò chơi này là Jack. Anh may mắn sống sót sau một vụ rơi máy bay kinh hoàng xuống biển, và tại đây anh đã phát hiện ra một thành phố dưới lòng đại dương Rapture. Nơi đây tồn tại nhiều kẻ sát nhân điên loạn và bạn phải làm sao để sinh tồn ở đây.','BioShock Series ',345500,'06-08-2022',1,'Version 1.9.0',1);


INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES
('Magic World là game phiêu lưu vào thế giới huyền bí với những sinh vật thần thoại và phép thuật cổ xưa, nơi bạn phải khám phá những bí mật ẩn giấu và chiến đấu với kẻ thù nguy hiểm.', 'Magic World', 699000, '01/15/2020', 1, '2.0.5', 2),
('Exploring Relics là game thám hiểm các di tích cổ đại và giải mã những bí ẩn của nền văn minh đã mất, cùng với những pha hành động kịch tính và những câu đố hóc búa.', 'Exploring Relics', 700000, '02/20/2020', 1, '1.2.5', 2),
('Magical land kể về một cuộc phiêu lưu đầy màu sắc qua các vùng đất kỳ diệu, nơi bạn sẽ gặp gỡ các nhân vật huyền thoại và đối mặt với những thử thách đầy cam go.', 'Magical Land', 90000, '03/10/2023', 0, '1.0.8', 2),
('Save The Princess kể về hành trình qua các vương quốc cổ tích để giải cứu công chúa bị bắt cóc bởi phù thủy độc ác, với các màn chơi hấp dẫn và đa dạng.', 'Save The Princess', 899000, '04/05/2022', 1, '2.0.6', 2),
('Phiêu lưu vào lòng đất sâu thẳm để tìm kiếm kho báu huyền thoại và đối mặt với những sinh vật kỳ dị và những cạm bẫy chết người.', 'Kho Báu Lòng Đất', 499000, '05/18/2024', 0, '1.1.5', 2),
('Khám phá những hòn đảo bí ẩn với các nền văn minh bí ẩn và kho báu vô giá, cùng những trận chiến với hải tặc và sinh vật biển khổng lồ.', 'Đảo Bí Ẩn', 749000, '06/12/2024', 1, '1.1.8', 2),
('Cuộc phiêu lưu thời gian quay ngược lại thời kỳ khủng long, nơi bạn phải sinh tồn và khám phá thế giới tiền sử đầy nguy hiểm.', 'Thời Kỳ Khủng Long', 649000, '07/22/2020', 0, '2.0', 2),
('Thám hiểm các tàn tích của một nền văn minh cổ đại bị lãng quên dưới lòng đại dương, với những bí mật và nguy hiểm rình rập.', 'Tàn Tích Dưới Biển', 799000, '08/30/2021', 1, '2.2', 2),
('Phiêu lưu vào khu rừng rậm nhiệt đới đầy bí ẩn, nơi bạn phải chiến đấu với thú hoang dã và khám phá những bí mật của rừng xanh.', 'Rừng Nhiệt Đới', 559000, '09/14/2022', 0, '1.0', 2),
('Cuộc hành trình xuyên sa mạc hoang vu để tìm kiếm thành phố vàng huyền thoại, đối mặt với những thử thách khắc nghiệt của thiên nhiên.', 'Thành Phố Vàng', 999000, '10/06/2022', 1, '2.0', 2),
('Phiêu lưu vào các vùng đất băng giá để tìm kiếm bí mật của vương quốc băng và chiến đấu với những quái vật băng giá.', 'Vương Quốc Băng', 659000, '11/25/2022', 1, '2.1.0', 2),
('Một cuộc phiêu lưu ma quái trong lâu đài ma ám, nơi bạn phải khám phá những bí ẩn và tiêu diệt các hồn ma đáng sợ.', 'Lâu Đài Ma Ám', 579000, '12/31/2022', 0, '1.1.9', 2),
('Phiêu lưu vào vũ trụ bao la để khám phá những hành tinh kỳ lạ và đối mặt với những sinh vật ngoài hành tinh.', 'Khám Phá Vũ Trụ', 899000, '01/14/2023', 1, '1.5.0', 2),
('Cuộc phiêu lưu qua các vùng đất kỳ lạ và kỳ diệu để tìm kiếm những kho báu bị lãng quên và giải mã những bí mật cổ xưa.', 'Vùng Đất Kỳ Lạ', 619000, '02/28/2023', 0, '1.2', 2),
('Một cuộc hành trình đầy mạo hiểm qua các vùng đất hoang sơ để tìm kiếm những di tích bí ẩn và đối mặt với những nguy hiểm tiềm ẩn.', 'Vùng Đất Hoang Sơ', 729000, '03/19/2023', 1, '1.4', 2);



INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES
('Battlefield Warfare: Game bắn súng góc nhìn thứ nhất với các trận chiến quy mô lớn, nơi bạn có thể chiến đấu trên các mặt trận khác nhau với nhiều loại vũ khí hiện đại.', 'Battlefield Warfare', 0, '01/15/2018', 1, '2.0.2', 3),
('Sniper Elite: Một game bắn tỉa chân thực, nơi bạn phải thực hiện các nhiệm vụ ám sát từ xa với độ chính xác cao và tính toán đường đạn chi tiết.', 'Sniper Elite', 600000, '02/20/2019', 1, '1.2.3', 3),
('Urban Combat: Trải nghiệm các trận đấu súng căng thẳng trong môi trường đô thị, với các chiến dịch giải cứu con tin và ngăn chặn khủng bố.', 'Urban Combat', 500000, '03/10/2020', 0, '2.0.5', 3),
('Desert Storm: Chiến đấu trong các sa mạc nóng bỏng với các phương tiện chiến đấu hiện đại và đối đầu với các lực lượng kẻ thù nguy hiểm.', 'Desert Storm', 1000000, '04/05/2021', 1, '2.0.0', 3),
('Night Ops: Các nhiệm vụ bắn súng ban đêm với thiết bị nhìn đêm và các chiến thuật đặc biệt để tiêu diệt kẻ thù trong bóng tối.', 'Night Ops', 99000, '05/18/2022', 0, '1.9', 3),
('Space Marines: Cuộc chiến trong không gian với các loại vũ khí công nghệ cao và chiến đấu chống lại các sinh vật ngoài hành tinh.', 'Space Marines', 899000, '06/12/2022', 1, '1.3.8', 3),
('Zombie Apocalypse: Sống sót trong thế giới đầy rẫy xác sống, với các nhiệm vụ giải cứu và tiêu diệt lũ zombie khát máu.', 'Zombie Apocalypse', 799000, '07/22/2023', 0, '1.0.5', 3),
('Stealth Assassin: Trở thành sát thủ chuyên nghiệp, thực hiện các nhiệm vụ ám sát mà không bị phát hiện và thoát khỏi hiện trường an toàn.', 'Stealth Assassin', 669000, '04/30/2024', 1, '1.0.0', 3),
('Warzone Frontline: Chiến đấu trên tiền tuyến với các trận địa khác nhau và phối hợp cùng đồng đội để giành chiến thắng.', 'Warzone Frontline', 749000, '09/14/2018', 0, '2.8.5', 3),
('Alien Invasion: Chống lại cuộc xâm lược của người ngoài hành tinh với các vũ khí tối tân và bảo vệ Trái Đất khỏi sự diệt vong.', 'Alien Invasion', 899000, '10/06/2017', 1, '2.5.8', 3),
('Jungle Strike: Các cuộc chiến trong rừng rậm nhiệt đới với các nhiệm vụ phá hủy căn cứ địch và giải cứu con tin.', 'Jungle Strike', 649000, '11/25/2022', 1, '2.1.0', 3),
('Counter Attack: Tham gia các trận đấu súng đối kháng với các đội nhóm khác, sử dụng chiến thuật và kỹ năng cá nhân để giành chiến thắng.', 'Counter Attack', 799000, '12/31/2017', 0, '1.1.0', 3),
('Future Combat: Chiến đấu trong thế giới tương lai với các vũ khí và công nghệ tiên tiến, chống lại các thế lực xấu xa.', 'Future Combat', 899000, '01/14/2019', 1, '3.0', 3),
('Post-Apocalyptic Wars: Sinh tồn và chiến đấu trong thế giới hậu tận thế, nơi tài nguyên khan hiếm và kẻ thù ở khắp nơi.', 'Post-Apocalyptic Wars', 799000, '02/28/2020', 0, '1.2.0', 3),
('Virtual Reality Shooter: Trải nghiệm bắn súng thực tế ảo với độ chân thực cao và các môi trường chiến đấu đa dạng.', 'Virtual Reality Shooter', 999000, '03/19/2021', 1, '1.4.3', 3);


INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES
('Mortal Clash: Một game đối kháng đỉnh cao với các nhân vật mạnh mẽ và chiêu thức độc đáo. Chiến đấu trong các đấu trường khác nhau và thể hiện kỹ năng chiến đấu của bạn.', 'Mortal Clash', 500000, '01/15/2017', 1, '2.8.4', 4),
('Ultimate Brawl: Trải nghiệm các trận đấu đối kháng với đồ họa ấn tượng và hệ thống chiến đấu phong phú. Mỗi nhân vật có kỹ năng và phong cách chiến đấu riêng.', 'Ultimate Brawl', 1400000, '02/20/2018', 1, '2.2.0', 4),
('Dragon Fighters: Tham gia các trận đấu đối kháng với các chiến binh rồng. Mỗi nhân vật có sức mạnh và kỹ năng đặc biệt, mang lại những trận đấu kịch tính.', 'Dragon Fighters', 1200000, '03/10/2019', 0, '2.0.0', 4),
('Street Champions: Chiến đấu trên đường phố với các võ sĩ đường phố chuyên nghiệp. Sử dụng các kỹ năng võ thuật để đánh bại đối thủ và trở thành nhà vô địch.', 'Street Champions', 0, '04/05/2020', 1, '2.0.8', 4),
('Arena Masters: Đối kháng trong các đấu trường lớn với những võ sĩ hàng đầu thế giới. Thể hiện kỹ năng chiến đấu và chiến lược để giành chiến thắng.', 'Arena Masters', 0, '05/18/2021', 0, '2.5.0', 4),
('Samurai Duel: Trải nghiệm các trận đấu đối kháng thời kỳ samurai với những thanh kiếm sắc bén và kỹ năng chiến đấu cổ xưa. Mỗi trận đấu là một cuộc chiến sống còn.', 'Samurai Duel', 800000, '06/12/2022', 1, '2.5.6', 4),
('Combat Legends: Chiến đấu với những huyền thoại võ thuật trong các trận đấu đối kháng căng thẳng. Mỗi huyền thoại có kỹ năng và chiến thuật độc đáo.', 'Combat Legends', 200000, '07/22/2023', 0, '1.0.6', 4),
('Ninja Showdown: Trở thành ninja và tham gia các trận đấu đối kháng tốc độ cao. Sử dụng các kỹ năng và vũ khí ninja để đánh bại đối thủ.', 'Ninja Showdown', 199000, '01/30/2024', 1, '1.0', 4),
('Gladiator Arena: Chiến đấu như một đấu sĩ La Mã trong các đấu trường cổ đại. Sử dụng kỹ năng và chiến thuật để tồn tại và chiến thắng.', 'Gladiator Arena', 70000, '09/14/2022', 0, '1.5.0', 4),
('Hero Clash: Trận đấu giữa các siêu anh hùng với sức mạnh phi thường. Mỗi anh hùng có kỹ năng đặc biệt và phong cách chiến đấu riêng.', 'Hero Clash', 290000, '10/06/2023', 1, '1.0', 4),
('Warrior Spirits: Chiến đấu với các chiến binh mạnh mẽ từ khắp nơi trên thế giới. Mỗi chiến binh có câu chuyện và kỹ năng riêng biệt.', 'Warrior Spirits', 650000, '11/25/2022', 1, '1.1', 4),
('Fantasy Fighters: Tham gia các trận đấu đối kháng trong thế giới kỳ ảo với các nhân vật huyền bí. Sử dụng phép thuật và vũ khí kỳ diệu để chiến đấu.', 'Fantasy Fighters', 800000, '12/31/2021', 0, '2.1', 4),
('Robot Rumble: Đối kháng với các robot chiến đấu tối tân. Mỗi robot có vũ khí và kỹ năng riêng, tạo nên những trận đấu đầy kịch tính.', 'Robot Rumble', 109000, '01/14/2020', 1, '2.0', 4),
('Knight Duel: Trở thành hiệp sĩ và chiến đấu trong các trận đấu đối kháng thời trung cổ. Sử dụng kiếm và khiên để đánh bại đối thủ.', 'Knight Duel', 460000, '02/28/2019', 0, '2.2', 4),
('Galaxy Warriors: Chiến đấu với các chiến binh ngoài hành tinh trong không gian. Mỗi chiến binh có sức mạnh và vũ khí tiên tiến.', 'Galaxy Warriors', 340000, '03/19/2018', 1, '2.4', 4);

--5
INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES
('Survival Island: Game sinh tồn trên đảo hoang, nơi bạn phải tự mình tìm kiếm thức ăn, xây dựng nơi trú ẩn và đối mặt với những nguy hiểm tự nhiên.', 'Survival Island', 0, '01/15/2017', 1, '1.0', 5),
('Zombie Survival: Sống sót trong thế giới đầy rẫy zombie, nơi bạn phải tìm kiếm tài nguyên, chế tạo vũ khí và bảo vệ mình khỏi lũ xác sống khát máu.', 'Zombie Survival', 0, '02/20/2018', 1, '1.2', 5),
('Wilderness Survival: Khám phá vùng hoang dã, tìm kiếm thực phẩm, nước uống và nơi trú ẩn để sinh tồn qua những đêm lạnh giá và thú hoang.', 'Wilderness Survival', 1340000, '03/10/2019', 0, '1.0', 5),
('Apocalyptic Survival: Sống sót sau thảm họa toàn cầu, tìm kiếm tài nguyên khan hiếm và đối mặt với các nhóm kẻ thù để giành giật sự sống.', 'Apocalyptic Survival', 700000, '04/05/2020', 1, '2.0', 5),
('Space Survival: Cuộc phiêu lưu sinh tồn trong không gian, nơi bạn phải quản lý tài nguyên, duy trì sự sống và đối phó với các nguy cơ ngoài vũ trụ.', 'Space Survival', 199000, '05/18/2021', 0, '1.1', 5),
('Forest Survival: Sinh tồn trong khu rừng rậm nhiệt đới, nơi bạn phải xây dựng nơi trú ẩn, săn bắn và tìm cách sống sót giữa thiên nhiên hoang dã.', 'Forest Survival', 899000, '06/12/2022', 1, '1.3', 5),
('Arctic Survival: Khám phá và sinh tồn trong vùng đất băng giá, nơi nhiệt độ cực thấp và nguồn tài nguyên khan hiếm.', 'Arctic Survival', 799000, '07/22/2023', 0, '1.0', 5),
('Underwater Survival: Sinh tồn dưới đại dương, khám phá các hang động ngầm và đối mặt với các sinh vật biển nguy hiểm.', 'Underwater Survival', 660000, '01/30/2022', 1, '1.2', 5),
('Desert Survival: Thử thách sinh tồn trong sa mạc khắc nghiệt, tìm kiếm nước và thực phẩm giữa cái nóng như thiêu đốt.', 'Desert Survival', 1000000, '09/14/2021', 0, '1.0', 5),
('Mountain Survival: Sinh tồn trong vùng núi hiểm trở, nơi bạn phải đối mặt với điều kiện thời tiết khắc nghiệt và thú hoang dã.', 'Mountain Survival', 104000, '10/06/2020', 1, '3.0', 5);

--6
INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES
('Rhythm Master: Một trò chơi âm nhạc giai điệu nơi bạn phải nhấn đúng các nốt nhạc theo nhịp điệu của bài hát. Cải thiện kỹ năng âm nhạc và thử thách bản thân với các cấp độ khó.', 'Rhythm Master',0, '01/15/2027', 1, '3.0', 6),
('Beat Hero: Trở thành anh hùng âm nhạc bằng cách chơi theo các giai điệu và nhịp điệu của các bài hát nổi tiếng. Thể hiện khả năng của bạn trên sân khấu lớn.', 'Beat Hero', 0, '02/20/2018', 1, '2.6.7', 5),
('Dance Revolution: Game nhảy theo nhịp điệu với các bài hát sôi động. Thực hiện các động tác nhảy chính xác và ghi điểm cao để mở khóa thêm nhiều bài hát mới.', 'Dance Revolution', 150000, '03/10/2019', 0, '2.0.0', 6),
('Piano Tiles: Trò chơi âm nhạc nơi bạn phải nhấn đúng các phím đàn piano đang di chuyển. Thể hiện kỹ năng piano của bạn và đạt điểm số cao.', 'Piano Tiles', 199000, '04/05/2020', 1, '2.0', 6),
('Guitar Legend: Trở thành huyền thoại guitar bằng cách chơi các bản nhạc rock kinh điển. Nhấn đúng các nốt nhạc để thực hiện các bản solo hoành tráng.', 'Guitar Legend', 0, '05/18/2021', 0, '2.1', 6),
('Music Journey: Khám phá hành trình âm nhạc đầy màu sắc và thú vị. Chơi theo các giai điệu và khám phá các vùng đất âm nhạc mới.', 'Music Journey', 209000, '06/12/2022', 1, '1.3.6', 6),
('Drum Master: Trở thành tay trống chuyên nghiệp bằng cách chơi theo các nhịp trống đa dạng. Thực hiện các màn biểu diễn trống ấn tượng và ghi điểm cao.', 'Drum Master', 109000, '07/22/2023', 0, '1.0.6', 6),
('DJ Party: Trở thành DJ hàng đầu và chơi nhạc cho các bữa tiệc. Tạo ra các mix nhạc độc đáo và khuấy động sân khấu.', 'DJ Party', 100000, '01/13/2024', 1, '1.0', 5),
('Singing Star: Thử thách bản thân với các bài hát và trở thành ngôi sao ca nhạc. Hát theo giai điệu và ghi điểm cao để mở khóa thêm nhiều bài hát mới.', 'Singing Star', 200000, '09/14/2023', 0, '1.0.7', 6),
('Melody Magic: Khám phá thế giới giai điệu kỳ diệu và chơi các bản nhạc cổ điển. Thể hiện khả năng âm nhạc của bạn và đạt điểm số cao.', 'Melody Magic', 399000, '10/06/2022', 1, '2.0', 6),
('Violin Virtuoso: Trở thành bậc thầy violin bằng cách chơi các bản nhạc cổ điển. Thực hiện các bản solo violin và ghi điểm cao.', 'Violin Virtuoso', 499000, '11/25/2021', 1, '2.1.0', 6),
('Rhythm Quest: Tham gia vào cuộc phiêu lưu âm nhạc và chinh phục các thử thách nhịp điệu. Mở khóa các bản nhạc mới và nâng cao kỹ năng của bạn.', 'Rhythm Quest', 199000, '12/31/2020', 0, '2.1.8', 6),
('Song Master: Trở thành bậc thầy âm nhạc bằng cách chơi theo các bài hát nổi tiếng. Thể hiện khả năng của bạn và đạt điểm số cao.', 'Song Master', 299000, '01/14/2019', 1, '2.5.7', 6),
('Dance Fever: Nhảy theo nhịp điệu của các bài hát sôi động. Thực hiện các động tác nhảy chính xác và ghi điểm cao để mở khóa thêm nhiều bài hát mới.', 'Dance Fever', 1400000, '02/28/2020', 0, '1.2.8', 6),
('Music Mania: Cuộc thi âm nhạc gay cấn, nơi bạn phải chơi theo nhịp điệu và giai điệu để giành chiến thắng. Thể hiện khả năng âm nhạc của bạn và chinh phục các thử thách.', 'Music Mania', 2000000, '03/19/2019', 1, '1.4', 6);


--7

INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES
('Battlefield Survival: Một trò chơi bắn súng sinh tồn nơi bạn phải chiến đấu chống lại kẻ thù và sống sót đến cuối cùng. Tham gia các trận chiến căng thẳng và nâng cấp vũ khí của bạn.', 'Battlefield Survival', 0, '01/10/2017', 1, '3.0', 7),
('Warzone Extreme: Trò chơi bắn súng sinh tồn với đồ họa ấn tượng và lối chơi hấp dẫn. Bạn phải tìm kiếm vũ khí, đối phó với kẻ thù và sống sót đến cuối cùng.', 'Warzone Extreme', 106000, '01/25/2018', 1, '2.1.0', 7),
('Survival Shooter: Trò chơi bắn súng sinh tồn nơi bạn phải chiến đấu trong một thế giới đầy rẫy nguy hiểm. Tìm kiếm vũ khí, xây dựng nơi trú ẩn và đánh bại kẻ thù.', 'Survival Shooter', 29000, '02/05/2019', 1, '2.0.8', 7),
('Island Battle: Tham gia cuộc chiến sinh tồn trên hòn đảo hoang. Bạn phải tìm kiếm tài nguyên, xây dựng nơi trú ẩn và chiến đấu chống lại kẻ thù để sống sót.', 'Island Battle', 50000, '02/15/2020', 1, '1.2', 7),
('Desert Warfare: Chiến đấu trong môi trường sa mạc khắc nghiệt. Tìm kiếm vũ khí và đối phó với kẻ thù trong một cuộc chiến sinh tồn đầy thách thức.', 'Desert Warfare', 190000, '03/01/2021', 0, '1.0', 7),
('Urban Survival: Tham gia cuộc chiến sinh tồn trong thành phố bị tàn phá. Tìm kiếm tài nguyên, đối phó với kẻ thù và cố gắng sống sót đến cuối cùng.', 'Urban Survival', 1799000, '03/12/2022', 1, '1.3', 7),
('Jungle Combat: Chiến đấu trong rừng rậm với các kẻ thù nguy hiểm. Tìm kiếm vũ khí, xây dựng nơi trú ẩn và sống sót trong môi trường khắc nghiệt.', 'Jungle Combat', 990000, '03/20/2023', 1, '1.1', 7),
('Night Ops: Chiến đấu trong bóng đêm với các kẻ thù nguy hiểm. Sử dụng kỹ năng và chiến thuật để sống sót trong các trận chiến ban đêm.', 'Night Ops', 230000, '04/05/2024', 1, '1.0', 7),
('Snow Survival: Chiến đấu trong môi trường tuyết trắng lạnh giá. Tìm kiếm vũ khí và tài nguyên để sống sót qua những đêm đông giá rét.', 'Snow Survival', 1250000, '04/18/2023', 1, '1.2', 7),
('Mountain Warfare: Tham gia cuộc chiến sinh tồn trên đỉnh núi cao. Tìm kiếm tài nguyên, đối phó với kẻ thù và sống sót trong điều kiện thời tiết khắc nghiệt.', 'Mountain Warfare', 0, '05/02/2022', 0, '1.0', 7),
('Ocean Battle: Chiến đấu trên đại dương rộng lớn. Tìm kiếm tài nguyên, đối phó với kẻ thù và sống sót trên biển cả.', 'Ocean Battle', 799000, '05/14/2021', 1, '1.3', 7),
('Cave Combat: Tham gia cuộc chiến sinh tồn trong các hang động tối tăm. Tìm kiếm vũ khí và đối phó với kẻ thù trong môi trường nguy hiểm.', 'Cave Combat', 899000, '05/25/2020', 1, '1.1', 7),
('Space Survival Shooter: Chiến đấu trong không gian với các kẻ thù ngoài hành tinh. Sử dụng vũ khí công nghệ cao và sống sót trong môi trường không gian.', 'Space Survival Shooter', 0, '06/05/2019', 1, '1.0', 7),
('Swamp Battle: Tham gia cuộc chiến sinh tồn trong đầm lầy. Tìm kiếm vũ khí và tài nguyên để sống sót trong môi trường ẩm ướt và nguy hiểm.', 'Swamp Battle', 499000, '06/18/2019', 1, '1.2', 7),
('Arctic Warfare: Chiến đấu trong môi trường băng giá. Tìm kiếm vũ khí và tài nguyên để sống sót qua những đêm đông lạnh lẽo.', 'Arctic Warfare', 199000, '07/02/2022', 0, '1.0', 7),
('Volcano Survival: Chiến đấu trong khu vực núi lửa hoạt động. Tìm kiếm vũ khí và đối phó với kẻ thù trong môi trường nguy hiểm.', 'Volcano Survival', 347000, '07/14/2023', 1, '1.3', 7),
('Underwater Combat: Chiến đấu dưới lòng biển sâu với các kẻ thù nguy hiểm. Tìm kiếm vũ khí và tài nguyên để sống sót trong môi trường dưới nước.', 'Underwater Combat', 524000, '07/25/2021', 1, '1.1', 7),
('Ruins Battle: Tham gia cuộc chiến sinh tồn trong các tàn tích cổ đại. Tìm kiếm vũ khí và đối phó với kẻ thù trong môi trường đầy bí ẩn.', 'Ruins Battle', 1699000, '08-04-2020',0,'1.6.7',7)

---insert cho tôi 20 dòng của bảng games thuộc thể loại game bắn súng sinh tồn với các thuộc tính miêu tả game ( hãy miêu tả game chi tiết với mô tiếp tên game + mô tả chi tiết), tên game(miêu tả bằng tiếng anh), giá game theo vnđ, ngày tạo theo định dạng mm/dd/yyyy, bit ( 0 hoặc 1 nhưng 1 nhiều hơn), version, và thuộc tính cuối cùng là 7 bằng sql sever và trả câu trả lời bằng tiếng Việt
--8
INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES 
('Silent Hill', 'Silent Hill: Một trò chơi kinh dị nơi người chơi điều hướng qua một thị trấn đầy quái vật và giải quyết các câu đố. Với những pha hù đáng sợ', 1500000, '01/10/2017', 1, '3.0', 8),
('Resident Evil', 'Resident Evil: Người chơi chiến đấu qua một trận dịch zombie trong khi giải quyết các bí ẩn trong một dinh thự rùng rợn.', 1000000, '02/15/2018', 1, '3.1', 8),
('Amnesia: The Dark Descent', 'Amnesia: The Dark Descent: Một trò chơi kinh dị sinh tồn góc nhìn thứ nhất diễn ra trong một lâu đài tối tăm và đáng sợ.', 300000, '03/22/2019', 1, '1.2', 8),
('Outlast', 'Outlast: Nhà báo điều tra khám phá một bệnh viện tâm thần bị bỏ hoang đầy những sinh vật kinh dị.', 400000, '04/05/2020', 1, '1.3.8', 8),
('Dead Space', 'Dead Space: Người chơi chiến đấu chống lại xác sống tái sinh trên một trạm vũ trụ trong khi khám phá một bí ẩn kinh hoàng.', 170000, '05/12/2021', 1, '1.4', 8),
('The Evil Within', 'The Evil Within: Một thám tử bị kéo vào một thế giới xoắn ốc đầy những sinh vật và môi trường ác mộng.', 600000, '06/18/2022', 1, '1.5', 8),
('Layers of Fear', 'Layers of Fear: Một trò chơi kinh dị tâm lý tập trung vào một họa sĩ điên cố gắng hoàn thành kiệt tác của mình.', 200000, '07/24/2023', 1, '1.6', 8),
('Fatal Frame', 'Fatal Frame: Người chơi sử dụng máy ảnh để chụp và đánh bại ma trong một dinh thự bị ám.', 150000, '2/13/2024', 1, '1.0', 8),
('Until Dawn', 'Until Dawn: Một trò chơi kinh dị dẫn dắt câu chuyện nơi người chơi đưa ra các quyết định ảnh hưởng đến kết cục của câu chuyện.', 0, '09/05/2023', 1, '1.8', 8),
('Alien: Isolation', 'Alien: Isolation: Người chơi tránh né một sinh vật ngoài hành tinh kinh hoàng trong khi cố gắng sống sót trên một trạm vũ trụ.', 0, '10/11/2022', 1, '1.9', 8),
('P.T.', 'P.T.: Một trò chơi kinh dị tâm lý góc nhìn thứ nhất diễn ra trong một hành lang lặp đi lặp lại đầy những sự kiện rùng rợn.', 0, '11/17/2021', 1, '2.0', 8),
('SOMA', 'SOMA: Một trò chơi kinh dị khoa học viễn tưởng diễn ra trong một cơ sở dưới nước với một câu chuyện đen tối.', 1500000, '12/23/2020', 1, '2.1', 8),
('Phasmophobia', 'Phasmophobia: Một trò chơi săn ma hợp tác nơi người chơi thu thập bằng chứng về hoạt động huyền bí.', 1300000, '01/29/2019', 1, '2.2', 8),
('Blair Witch', 'Blair Witch: Một trò chơi kinh dị tâm lý dẫn dắt câu chuyện lấy cảm hứng từ loạt phim Blair Witch.', 0, '02/14/2018', 1, '2.5.8', 8),
('Dying Light', 'Dying Light: Một trò chơi kinh dị sinh tồn diễn ra trong một thành phố bị zombie xâm chiếm, với các yếu tố parkour.', 1600000, '03/21/2017', 1, '3.1', 8),
('Little Nightmares', 'Little Nightmares: Một câu chuyện tối tăm và kỳ dị đối mặt với những nỗi sợ hãi thời thơ ấu của bạn.', 1200000, '04/27/2018', 1, '2.5', 8),
('The Forest', 'The Forest: Trò chơi kinh dị sinh tồn nơi người chơi phải sống sót trên một bán đảo rừng sau vụ rơi máy bay.', 1400000, '05/03/2019', 1, '2.6', 8),
('Visage', 'Visage: Một trò chơi kinh dị tâm lý diễn ra trong một ngôi nhà bí ẩn luôn thay đổi.', 1500000, '06/09/2022', 1, '2.7', 8),
('Martha Is Dead', 'Martha Is Dead: Một câu chuyện kinh dị tâm lý góc nhìn thứ nhất diễn ra tại Ý năm 1944.', 1300000, '07/15/2022', 1, '2.8', 8),
('Call of Cthulhu', 'Call of Cthulhu: Một trò chơi kinh dị điều tra lấy cảm hứng từ câu chuyện cổ điển của H.P. Lovecraft.', 1800000, '08/21/2022', 1, '1.9', 8);


--9
INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES 
('Steins;Gate', 'Steins;Gate: Một tiểu thuyết tương tác kể về một nhóm sinh viên phát hiện cách gửi tin nhắn về quá khứ, gây ra những hệ quả không lường trước.', 500000, '01/10/2018', 1, '1.0', 8),
('Clannad', 'Clannad: Một câu chuyện cảm động về tình bạn và gia đình, nơi người chơi đưa ra các lựa chọn ảnh hưởng đến mạch truyện và kết thúc.', 1450000, '02/15/2019', 1, '1.1', 8),
('Doki Doki Literature Club', 'Doki Doki Literature Club: Một tiểu thuyết trực quan ban đầu trông có vẻ đáng yêu, nhưng nhanh chóng trở nên kinh dị và rùng rợn.', 0, '03/22/2020', 1, '1.2', 8),
('Phoenix Wright: Ace Attorney', 'Phoenix Wright: Ace Attorney: Người chơi nhập vai một luật sư bào chữa, giải quyết các vụ án và bảo vệ thân chủ trước tòa.', 600000, '04/05/2021', 1, '1.3', 8),
('Fate/stay night', 'Fate/stay night: Một câu chuyện kỳ ảo kể về cuộc chiến giữa các pháp sư và anh hùng huyền thoại để giành Chén Thánh.', 0, '05/12/2022', 1, '1.4', 8),
('Grisaia no Kajitsu', 'Grisaia no Kajitsu: Một câu chuyện phức tạp về một trường học đặc biệt, nơi mỗi học sinh đều có một quá khứ đen tối và bí ẩn.', 1520000, '06/18/2023', 1, '1.5', 8),
('Planetarian', 'Planetarian: Một câu chuyện ngắn nhưng cảm động về một người sống sót sau thảm họa và một robot ở một đài thiên văn bỏ hoang.', 300000, '07/24/2022', 1, '1.6', 8),
('Higurashi When They Cry', 'Higurashi When They Cry: Một tiểu thuyết kinh dị tâm lý xoay quanh những sự kiện bí ẩn và khủng khiếp xảy ra tại một ngôi làng nhỏ.', 470000, '08/30/2021', 1, '1.7', 8),
('The House in Fata Morgana', 'The House in Fata Morgana: Một câu chuyện kỳ bí và đau thương diễn ra trong một dinh thự ma quái qua nhiều thế kỷ.', 50000, '09/05/2020', 1, '1.8', 8),
('Saya no Uta', 'Saya no Uta: Một câu chuyện kinh dị tâm lý kể về một bác sĩ trẻ và sự gặp gỡ của anh ta với một cô gái bí ẩn giữa thực tại méo mó.', 180000, '10/11/2019', 1, '1.9', 8);

--10
INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES
('Heavy Rain', 'Heavy Rain: Một trò chơi điện ảnh tương tác xoay quanh việc giải quyết vụ án của một kẻ giết người hàng loạt, nơi mỗi quyết định của người chơi có thể dẫn đến nhiều kết cục khác nhau.', 0, '01/10/2017', 1, '3.0', 10),
('Detroit: Become Human', 'Detroit: Become Human: Một câu chuyện tương lai về những người máy có cảm xúc, với mỗi lựa chọn của người chơi ảnh hưởng lớn đến cốt truyện.',0, '02/15/2018', 1, '3.1.6', 10),
('Until Dawn', 'Until Dawn: Một trò chơi kinh dị điện ảnh tương tác, nơi người chơi phải đưa ra những quyết định quan trọng để bảo vệ nhóm bạn khỏi một kẻ giết người bí ẩn.', 800000, '03/22/2019', 1, '2.2', 10),
('The Walking Dead', 'The Walking Dead: Một trò chơi phiêu lưu tương tác dựa trên loạt truyện tranh nổi tiếng, với những quyết định của người chơi ảnh hưởng đến câu chuyện và các nhân vật.', 600000, '04/05/2020', 1, '2.3.0', 10),
('Life is Strange', 'Life is Strange: Một trò chơi phiêu lưu tương tác nơi người chơi có khả năng quay ngược thời gian, và các quyết định của họ sẽ ảnh hưởng đến tương lai.', 1500000, '05/12/2021', 1, '2.4.3', 9),
('Beyond: Two Souls', 'Beyond: Two Souls: Một trò chơi điện ảnh kể về cuộc đời của một cô gái có khả năng kết nối với một thực thể siêu nhiên, với câu chuyện do người chơi điều khiển.', 1600000, '06/18/2022', 1, '2.5.0', 10),
('The Quarry', 'The Quarry: Một trò chơi kinh dị tương tác, nơi người chơi điều khiển một nhóm thanh thiếu niên qua một đêm đầy nguy hiểm trong khu cắm trại.', 800000, '07/24/2023', 1, '1.6.0', 10),
('Telltale Batman', 'Telltale Batman: Một trò chơi phiêu lưu tương tác, nơi người chơi vào vai Batman, đưa ra các quyết định ảnh hưởng đến câu chuyện và mối quan hệ với các nhân vật khác.', 1700000, '01/03/2024', 1, '1.0', 10),
('The Wolf Among Us', 'The Wolf Among Us: Một trò chơi phiêu lưu tương tác dựa trên loạt truyện tranh Fables, nơi người chơi điều khiển một thám tử điều tra các vụ án bí ẩn.', 600000, '09/05/2023', 1, '1.8', 10),
('Erica', 'Erica: Một trò chơi điện ảnh tương tác, nơi người chơi theo chân một cô gái trẻ khám phá bí mật về cái chết của cha mình.', 500000, '10/11/2022', 1, '1.5.8', 10),
('Man of Medan', 'Man of Medan: Một trò chơi kinh dị tương tác, nơi người chơi điều khiển một nhóm bạn trên một con tàu ma ám và các quyết định của họ ảnh hưởng đến số phận của mọi người.', 650000, '11/17/2023', 1, '2.0', 10),
('Hidden Agenda', 'Hidden Agenda: Một trò chơi trinh thám tương tác, nơi người chơi điều khiển các thám tử và phải đưa ra các quyết định quan trọng để giải quyết vụ án.', 550000, '12/23/2022', 1, '2.1', 10),
('The Dark Pictures: Little Hope', 'The Dark Pictures: Little Hope: Một trò chơi kinh dị tương tác, nơi người chơi điều khiển một nhóm người bị mắc kẹt trong một thị trấn ma ám và phải đối mặt với những thế lực siêu nhiên.', 700000, '01/29/2021', 1, '2.2', 10),
('Her Story', 'Her Story: Một trò chơi trinh thám tương tác, nơi người chơi xem các đoạn video thẩm vấn để giải mã một vụ án bí ẩn.', 400000, '02/14/2020', 1, '2.3', 10),
('Late Shift', 'Late Shift: Một trò chơi điện ảnh tương tác, nơi người chơi vào vai một sinh viên bị kéo vào một vụ trộm ngân hàng, với các quyết định của họ ảnh hưởng đến kết cục của câu chuyện.', 450000, '03/21/2019', 1, '2.4', 10);

update games
set game_type_id = 10
where game_type_id = 9

--11
INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES
('Minecraft', 'Minecraft: Một trò chơi sinh tồn 3D nơi người chơi khai thác tài nguyên, xây dựng công trình và chiến đấu với quái vật.', 0, '01/10/2017', 1, '3.0', 11),
('ARK: Survival Evolved', 'ARK: Survival Evolved: Người chơi phải sống sót trên một hòn đảo đầy khủng long, xây dựng căn cứ và thuần hóa sinh vật.', 700000, '02/15/2018', 1, '2.8.9', 11),
('Rust', 'Rust: Một trò chơi sinh tồn 3D thời gian thực, nơi người chơi phải thu thập tài nguyên, xây dựng nơi trú ẩn và chiến đấu với người chơi khác.', 650000, '03/22/2019', 1, '2.2.8', 11),
('Subnautica', 'Subnautica: Một trò chơi sinh tồn dưới nước, nơi người chơi khám phá đại dương, thu thập tài nguyên và xây dựng căn cứ dưới nước.', 1600000, '04/05/2020', 1, '1.3', 11),
('The Forest', 'The Forest: Người chơi sống sót sau vụ rơi máy bay và phải chống lại những kẻ ăn thịt người trên một bán đảo rừng.', 550000, '05/12/2021', 1, '1.4', 11),
('DayZ', 'DayZ: Một trò chơi sinh tồn zombie, nơi người chơi phải tìm kiếm thức ăn, nước uống và thuốc men để sống sót.', 600000, '06/18/2022', 1, '2.5', 11),
('Conan Exiles', 'Conan Exiles: Một trò chơi sinh tồn trong thế giới mở, nơi người chơi phải xây dựng vương quốc và chiến đấu với các thế lực thù địch.', 75000, '07/24/2023', 1, '2.6.6', 11),
('7 Days to Die', '7 Days to Die: Một trò chơi sinh tồn zombie kết hợp giữa xây dựng, chế tạo và chiến đấu với đám đông zombie.', 500000, '02/10/2024', 1, '1.7.8', 11),
('Green Hell', 'Green Hell: Người chơi phải sống sót trong rừng rậm Amazon, tìm kiếm thức ăn và nước uống, và chống lại các mối đe dọa từ thiên nhiên.', 450000, '09/05/2023', 1, '1.8', 11),
('Astroneer', 'Astroneer: Một trò chơi sinh tồn và thám hiểm không gian, nơi người chơi khai thác tài nguyên và xây dựng căn cứ trên các hành tinh xa lạ.', 550000, '10/11/2022', 1, '2.9.5', 11),
('Raft', 'Raft: Người chơi sống sót trên một chiếc bè trôi dạt trên đại dương, thu thập tài nguyên từ nước và xây dựng căn cứ nổi.', 500000, '12/23/2021', 1, '3.2.1', 11),
('Scum', 'Scum: Một trò chơi sinh tồn thực tế, nơi người chơi phải quản lý các chỉ số cơ thể và chống lại những người chơi khác để sống sót.', 650000, '01/29/2020', 1, '2.2', 11),
('Grounded', 'Grounded: Người chơi bị thu nhỏ lại kích thước của con kiến và phải sống sót trong một khu vườn đầy nguy hiểm.', 600000, '02/14/2019', 1, '2.3', 11),
('State of Decay 2', 'State of Decay 2: Một trò chơi sinh tồn zombie, nơi người chơi xây dựng cộng đồng và quản lý tài nguyên để sống sót trước đại dịch zombie.', 700000, '03/21/2022', 1, '2.4', 11);



--12
INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES
('Silent Hill', 'Silent Hill: Một trò chơi kinh dị nơi người chơi điều hướng qua một thị trấn đầy quái vật và giải quyết các câu đố.', 0, '01/10/2017', 1, '3.0', 12),
('Resident Evil', 'Resident Evil: Người chơi chiến đấu qua một trận dịch zombie trong khi giải quyết các bí ẩn trong một dinh thự rùng rợn.', 1800000, '02/15/2018', 1, '2.3.2', 12),
('Amnesia: The Dark Descent', 'Amnesia: The Dark Descent: Một trò chơi kinh dị sinh tồn góc nhìn thứ nhất diễn ra trong một lâu đài tối tăm và đáng sợ.', 300000, '03/22/2019', 1, '2.2', 12),
('Outlast', 'Outlast: Nhà báo điều tra khám phá một bệnh viện tâm thần bị bỏ hoang đầy những sinh vật kinh dị.', 1400000, '04/05/2020', 1, '2.3.0', 12),
('Dead Space', 'Dead Space: Người chơi chiến đấu chống lại xác sống tái sinh trên một trạm vũ trụ trong khi khám phá một bí ẩn kinh hoàng.', 1700000, '05/12/2023', 1, '1.4', 12),
('The Evil Within', 'The Evil Within: Một thám tử bị kéo vào một thế giới xoắn ốc đầy những sinh vật và môi trường ác mộng.', 1600000, '06/18/2024', 1, '1.5', 12),
('Layers of Fear', 'Layers of Fear: Một trò chơi kinh dị tâm lý tập trung vào một họa sĩ điên cố gắng hoàn thành kiệt tác của mình.', 1200000, '07/24/2023', 1, '2.6', 12),
('Fatal Frame', 'Fatal Frame: Người chơi sử dụng máy ảnh để chụp và đánh bại ma trong một dinh thự bị ám.', 1500000, '08/30/2023', 1, '1.5.7', 12),
('Until Dawn', 'Until Dawn: Một trò chơi kinh dị dẫn dắt câu chuyện nơi người chơi đưa ra các quyết định ảnh hưởng đến kết cục của câu chuyện.', 1800000, '09/05/2022', 1, '1.8', 12),
('Alien: Isolation', 'Alien: Isolation: Người chơi tránh né một sinh vật ngoài hành tinh kinh hoàng trong khi cố gắng sống sót trên một trạm vũ trụ.', 1700000, '10/11/2021', 1, '2.9.5', 12),
('P.T.', 'P.T.: Một trò chơi kinh dị tâm lý góc nhìn thứ nhất diễn ra trong một hành lang lặp đi lặp lại đầy những sự kiện rùng rợn.', 0, '11/17/2020', 1, '2.0.8', 12);


--13
INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES 
('Một trò chơi nhập vai trực tuyến với thế giới mở rộng lớn, nơi bạn có thể khám phá các vùng đất mới và tham gia vào các cuộc phiêu lưu kỳ thú.', 'Epic Quest Online', 990000, '03/09/2024', 1, '1.0.0', 13),
('Một trò chơi MMORPG với đồ họa tuyệt đẹp và cốt truyện phong phú, bạn sẽ được trải nghiệm cuộc sống của một anh hùng trong thế giới giả tưởng.', 'Legendary Heroes', 0, '03/15/2023', 1, '2.0.1', 13),
('Trò chơi nhập vai trực tuyến với hệ thống chiến đấu độc đáo và nhiều lớp nhân vật để lựa chọn.', 'Battle Realms Online', 850000, '01/20/2022', 0, '2.2.3', 13),
('MMORPG với lối chơi đồng đội hấp dẫn, nơi bạn có thể kết bạn và lập nhóm để vượt qua các thử thách.', 'Guild Wars Online', 1100000, '04/10/2021', 1, '3.1.4', 13),
('Thế giới ảo rộng lớn và sinh động, bạn sẽ được tham gia vào các cuộc chiến sử thi và xây dựng đế chế của riêng mình.', 'Empire Legends', 95000, '02/25/2020', 1, '2.3.5', 13),
('Game nhập vai trực tuyến với nhiều nhiệm vụ và sự kiện đa dạng, mang lại trải nghiệm chơi game không ngừng nghỉ.', 'Adventure Realms', 0, '06/12/2019', 1, '2.4.2', 13),
('Một trò chơi MMORPG với hệ thống nghề nghiệp phong phú, bạn có thể trở thành chiến binh, pháp sư hay kẻ săn tiền thưởng.', 'Warriors of Magic', 1050000, '07/01/2018', 1, '2.5.5', 13),
('Trải nghiệm nhập vai trong một thế giới bị lãng quên, nơi bạn phải tìm cách sống sót và khám phá bí mật cổ xưa.', 'Forgotten Realms', 1150000, '08/23/2022', 1, '2.0.3', 13),
('Game MMORPG với cốt truyện sâu sắc và các nhiệm vụ phức tạp, thử thách khả năng chiến thuật của bạn.', 'Mystic Adventures',0, '09/14/2023', 1, '2.2.0', 13),
('Thế giới mở với nhiều khu vực bí ẩn và các cuộc phiêu lưu đầy thử thách đang chờ bạn khám phá.', 'Hidden Realms', 990000, '10/05/2021', 1, '3.0.0', 13),
('Một trò chơi MMORPG với hệ thống PvP đa dạng, nơi bạn có thể thách đấu với người chơi khác trên toàn thế giới.', 'Arena of Valor', 560000, '11/22/2020', 1, '1.6.3', 13),
('Game nhập vai trực tuyến với các trận chiến hoành tráng và hệ thống phát triển nhân vật chuyên sâu.', 'Dragon Lords Online', 950000, '12/10/2021', 0, '2.1.2', 13);

--14
INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES
('Một trò chơi nhập vai dạng lưới trực tuyến với thế giới mở rộng lớn, nơi bạn có thể khám phá các vùng đất mới và tham gia vào các cuộc phiêu lưu kỳ thú.', 'Quest Online', 990000, '03/09/2024', 1, '1.0.0', 14),
('Một trò chơi nhập vai dạng lưới với đồ họa tuyệt đẹp và cốt truyện phong phú, bạn sẽ được trải nghiệm cuộc sống của một anh hùng trong thế giới giả tưởng.', 'Legendary Heroes Online', 0, '03/15/2023', 1, '2.0.1', 14),
('Trò chơi nhập vai trực tuyến với hệ thống chiến đấu độc đáo và nhiều lớp nhân vật để lựa chọn.', 'Battle  Online', 850000, '01/20/2022', 0, '2.2.3', 14),
('MMORPG dạng lưới với lối chơi đồng đội hấp dẫn, nơi bạn có thể kết bạn và lập nhóm để vượt qua các thử thách.', 'Guild Wars Online', 1100000, '04/10/2021', 1, '3.1.4', 14),
('Thế giới ảo rộng lớn và sinh động, bạn sẽ được tham gia vào các cuộc chiến sử thi và xây dựng đế chế của riêng mình.', 'Empire Legends Royal', 95000, '02/25/2020', 1, '2.3.5', 14),
('Game nhập vai trực tuyến dạng lưới với nhiều nhiệm vụ và sự kiện đa dạng, mang lại trải nghiệm chơi game không ngừng nghỉ.', 'Adventure Realms Real', 0, '06/12/2019', 1, '2.4.2', 14),
('Một trò chơi MMORPG dạng lưới với hệ thống nghề nghiệp phong phú, bạn có thể trở thành chiến binh, pháp sư hay kẻ săn tiền thưởng.', ' Magic Boys', 1050000, '07/01/2018', 1, '2.5.5', 14),
('Trải nghiệm nhập vai trong một thế giới bị lãng quên, nơi bạn phải tìm cách sống sót và khám phá bí mật cổ xưa.', 'Forgotten 5', 1150000, '08/23/2022', 1, '2.0.3', 14),
('Game MMORPG dạng lưới với cốt truyện sâu sắc và các nhiệm vụ phức tạp, thử thách khả năng chiến thuật của bạn.', 'Mystic Adventures',0, '09/14/2023', 1, '2.2.0', 14),
('Thế giới mở với nhiều khu vực bí ẩn và các cuộc phiêu lưu đầy thử thách đang chờ bạn khám phá.', 'Hidden Realms', 990000, '10/05/2021', 1, '3.0.0', 14),
('Một trò chơi MMORPG với hệ thống PvP đa dạng, nơi bạn có thể thách đấu với người chơi khác trên toàn thế giới.', 'Arena of Valor', 560000, '11/22/2020', 1, '1.6.3', 14),
('Game nhập vai trực tuyến với các trận chiến hoành tráng và hệ thống phát triển nhân vật chuyên sâu.', 'Dragon Lords Online', 950000, '12/10/2021', 0, '2.1.2', 14);


--15
INSERT INTO games (description_game,name,price,release_date,status,version,game_type_id)
VALUES
('Heavy Rain Bullet', 'Heavy Rain: Một trò chơi điện ảnh tương tác xoay quanh việc giải quyết vụ án của một kẻ giết người hàng loạt, nơi mỗi quyết định của người chơi có thể dẫn đến nhiều kết cục khác nhau.', 0, '01/10/2017', 1, '3.0', 15),
('Detroit: Become Human Boys', 'Detroit: Become Human: Một câu chuyện tương lai về những người máy có cảm xúc, với mỗi lựa chọn của người chơi ảnh hưởng lớn đến cốt truyện.',0, '02/15/2018', 1, '3.1.6', 15),
('Until Dawn', 'Until Smart: Một trò chơi kinh dị điện ảnh tương tác, nơi người chơi phải đưa ra những quyết định quan trọng để bảo vệ nhóm bạn khỏi một kẻ giết người bí ẩn.', 800000, '03/22/2019', 1, '2.2', 15),
('The Walking Dead', 'The Walking Dead: Một trò chơi phiêu lưu tương tác dựa trên loạt truyện tranh nổi tiếng, với những quyết định của người chơi ảnh hưởng đến câu chuyện và các nhân vật.', 600000, '04/05/2020', 1, '2.3.0', 15),
('Life 3', 'Life is Strange: Một trò chơi phiêu lưu tương tác nơi người chơi có khả năng quay ngược thời gian, và các quyết định của họ sẽ ảnh hưởng đến tương lai.', 1500000, '05/12/2021', 1, '2.4.3', 15),
('Beyond', 'Beyond: Two Souls: Một trò chơi điện ảnh kể về cuộc đời của một cô gái có khả năng kết nối với một thực thể siêu nhiên, với câu chuyện do người chơi điều khiển.', 1600000, '06/18/2022', 1, '2.5.0', 15),
('The Quarry Legends', 'The Quarry: Một trò chơi kinh dị tương tác, nơi người chơi điều khiển một nhóm thanh thiếu niên qua một đêm đầy nguy hiểm trong khu cắm trại.', 800000, '07/24/2023', 1, '1.6.0', 15),
('Telltale Batman Pull', 'Telltale Batman: Một trò chơi phiêu lưu tương tác, nơi người chơi vào vai Batman, đưa ra các quyết định ảnh hưởng đến câu chuyện và mối quan hệ với các nhân vật khác.', 1700000, '01/03/2024', 1, '1.0', 15),
('The Wolf Among Us', 'The Wolf Among Us: Một trò chơi phiêu lưu tương tác dựa trên loạt truyện tranh Fables, nơi người chơi điều khiển một thám tử điều tra các vụ án bí ẩn.', 600000, '09/05/2023', 1, '1.8', 15),
('Erice', 'Erica: Một trò chơi điện ảnh tương tác, nơi người chơi theo chân một cô gái trẻ khám phá bí mật về cái chết của cha mình.', 500000, '10/11/2022', 1, '1.5.8', 15),
('Man of King', 'Man of Medan: Một trò chơi kinh dị tương tác, nơi người chơi điều khiển một nhóm bạn trên một con tàu ma ám và các quyết định của họ ảnh hưởng đến số phận của mọi người.', 650000, '11/17/2023', 1, '2.0', 15),
('Hidden Dog', 'Hidden Agenda: Một trò chơi trinh thám tương tác, nơi người chơi điều khiển các thám tử và phải đưa ra các quyết định quan trọng để giải quyết vụ án.', 550000, '12/23/2022', 1, '2.1', 15),
('The Dark: Little Hope', 'The Dark Pictures: Little Hope: Một trò chơi kinh dị tương tác, nơi người chơi điều khiển một nhóm người bị mắc kẹt trong một thị trấn ma ám và phải đối mặt với những thế lực siêu nhiên.', 700000, '01/29/2021', 1, '2.2', 15),
('Her Kills', 'Her Story: Một trò chơi trinh thám tương tác, nơi người chơi xem các đoạn video thẩm vấn để giải mã một vụ án bí ẩn.', 400000, '02/14/2020', 1, '2.3', 15),
('Late ', 'Late Shift: Một trò chơi điện ảnh tương tác, nơi người chơi vào vai một sinh viên bị kéo vào một vụ trộm ngân hàng, với các quyết định của họ ảnh hưởng đến kết cục của câu chuyện.', 450000, '03/21/2019', 1, '2.4', 15);

-- Bảng Rank type --
insert into ranktypes (name, price) values ('Bronze', 10000), ('Silver', 50000), ('Gold', 100000);

-- Bảng Roles --
insert into roles (id, name) values ('ADMIN', 'Admin'), ('USER', 'User')

-- Bảng Account --
insert into accounts (account_balance,email,level,password,user_name,rank_account_id) values
(10000,'nguyendinhdung232002@gmail.com',3,'12345','DungDinh232002',1),
(10000,'nguyentrongkhoa@gmail.com',5,'12345','trongkhoa123',2),
(10000,'huynhtanphat@gmail.com',1,'12345','tanphat231',3),
(10000,'trinhphunghongphuc@gmail.com',10,'12345','Hongphuc234',1),
(10000,'lengockhanh@gmail.com',6,'12345','ngockhank84',3),

-- Bảng Authority (add bằng POSTMAN đi) --

-- Bảng User (nhớ check lại account id) --
insert into users (first_name,last_name,sdt,account_id) values
('Dũng','Nguyễn Đình',0937513187,1),
('Khoa','Nguyễn Trọng',0947513188,2),
('Lê','Ngọc Khánh',0957513189,3),
('Phát','Huỳnh Tấn',0967513190,4),
('Phúc','Trịnh Phùng Hồng',0977513191,5);


