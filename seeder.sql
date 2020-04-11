# DROP DATABASE codeon_db;


use codeon_db;

insert into post_types (type) values ('interview-questions'), ('mentorship-posts'), ('job-postings'), ('whiteboard-questions');

insert into skills (name) values ('Java'), ('HTML'), ('CSS'), ('JavaScript'), ('Thymeleaf'),
                                 ('MySql'), ('Git'), ('Ruby'), ('Python');

insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (1,  true,'User-centric user-facing approach', 'trumford0@merriam-webster.com', 'Tonnie', 'Rumford', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/100x221.bmp/ff4444/ffffff', 'http://dummyimage.com/227x175.bmp/ff4444/ffffff', 'trumford0');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (2,  true,'User-centric static paradigm', 'amatteau1@joomla.org', 'Alicea','Matteau', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/237x214.jpg/ff4444/ffffff', 'http://dummyimage.com/182x153.jpg/5fa2dd/ffffff', 'amatteau1');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (3,  true,'Secured incremental Graphic Interface', 'vbalfour2@icio.us', 'Vincenty', 'Balfour', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/101x204.jpg/dddddd/000000', 'http://dummyimage.com/233x227.bmp/ff4444/ffffff', 'vbalfour2');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (4,  true,'Extended grid-enabled encryption', 'bfrances3@harvard.edu', 'Bartlett','Frances', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/197x247.png/5fa2dd/ffffff', 'http://dummyimage.com/196x177.jpg/5fa2dd/ffffff', 'bfrances3');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (5,  true,'De-engineered encompassing hierarchy', 'ddiggins4@github.com', 'Dewitt','Diggins', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/123x233.bmp/ff4444/ffffff', 'http://dummyimage.com/119x223.png/5fa2dd/ffffff', 'ddiggins4');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (6,  true,'Sharable full-range emulation', 'cshilladay5@shareasale.com', 'Carlotta', 'Shilladay', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/145x123.bmp/5fa2dd/ffffff', 'http://dummyimage.com/147x120.jpg/cc0000/ffffff', 'cshilladay5');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (7,  true,'Optimized explicit encoding', 'ndeane6@issuu.com', 'Nikolaus', 'Deane', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/101x245.bmp/cc0000/ffffff', 'http://dummyimage.com/187x176.png/dddddd/000000', 'ndeane6');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (8,  true,'Mandatory grid-enabled leverage', 'bdesremedios7@techcrunch.com', 'Blythe', 'des Remedios', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/154x225.jpg/cc0000/ffffff', 'http://dummyimage.com/198x174.bmp/cc0000/ffffff', 'bdesremedios7');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (9,  true,'Versatile encompassing synergy', 'fboon8@ning.com', 'Fraze',  'Boon', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/113x173.bmp/dddddd/000000', 'http://dummyimage.com/146x238.png/5fa2dd/ffffff', 'fboon8');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (10, true, 'Distributed systematic toolset', 'tfairbridge9@theatlantic.com', 'Tirrell',  'Fairbridge', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/153x211.jpg/ff4444/ffffff', 'http://dummyimage.com/237x202.png/cc0000/ffffff', 'tfairbridge9');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (11, true, 'Multi-channelled real-time contingency', 'cmelonbya@fc2.com', 'Christian',   'Melonby', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/156x212.bmp/ff4444/ffffff', 'http://dummyimage.com/156x144.bmp/ff4444/ffffff', 'cmelonbya');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (12, true, 'Synchronised human-resource contingency', 'sgronewayb@narod.ru', 'Sharity',   'Groneway', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/183x153.bmp/cc0000/ffffff', 'http://dummyimage.com/149x148.png/ff4444/ffffff', 'sgronewayb');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (13, true, 'Sharable context-sensitive application', 'aleavesleyc@jalbum.net', 'Ad', 'Leavesley', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/194x136.png/5fa2dd/ffffff', 'http://dummyimage.com/197x181.png/cc0000/ffffff', 'aleavesleyc');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (14, true, 'Assimilated object-oriented infrastructure', 'grudsdelld@timesonline.co.uk', 'Gabie',   'Rudsdell', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/210x194.png/ff4444/ffffff', 'http://dummyimage.com/229x124.png/cc0000/ffffff', 'grudsdelld');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (15, true, 'Progressive dedicated throughput', 'mgillume@chronoengine.com', 'Mattias', 'Gillum', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/218x154.jpg/ff4444/ffffff', 'http://dummyimage.com/200x175.jpg/dddddd/000000', 'mgillume');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (16, true, 'Future-proofed foreground secured line', 'kgawkesf@huffingtonpost.com', 'Konrad','Gawkes', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/108x111.png/dddddd/000000', 'http://dummyimage.com/171x104.jpg/dddddd/000000', 'kgawkesf');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (17, true, 'Front-line well-modulated contingency', 'rlivingstong@livejournal.com', 'Rebecca',  'Livingston', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/155x119.jpg/5fa2dd/ffffff', 'http://dummyimage.com/216x250.bmp/cc0000/ffffff', 'rlivingstong');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (18, true, 'Integrated modular superstructure', 'bbollandsh@google.it', 'Bertina', 'Bollands', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/162x146.bmp/5fa2dd/ffffff', 'http://dummyimage.com/134x136.bmp/5fa2dd/ffffff', 'bbollandsh');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (19, true, 'Reduced non-volatile implementation', 'cheadingi@hatena.ne.jp', 'Caritta',   'Heading', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/146x191.png/5fa2dd/ffffff', 'http://dummyimage.com/232x229.bmp/dddddd/000000', 'cheadingi');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (20, true, 'Adaptive high-level system engine', 'rbackhousej@exblog.jp', 'Randi', 'Backhouse', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/223x184.jpg/ff4444/ffffff', 'http://dummyimage.com/144x221.jpg/dddddd/000000', 'rbackhousej');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (21, true, 'Organic homogeneous algorithm', 'ftraisek@sun.com', 'Ferdinand','Traise', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/122x114.jpg/cc0000/ffffff', 'http://dummyimage.com/147x206.jpg/ff4444/ffffff', 'ftraisek');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (22, true, 'Versatile client-server capability', 'mwestwaterl@booking.com', 'Milena','Westwater', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/184x130.png/cc0000/ffffff', 'http://dummyimage.com/122x146.jpg/cc0000/ffffff', 'mwestwaterl');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (23, true, 'Face to face heuristic definition', 'rdamrellm@mapy.cz', 'Rose',   'Damrell', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/147x221.bmp/cc0000/ffffff', 'http://dummyimage.com/185x107.png/dddddd/000000', 'rdamrellm');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (24, true, 'Quality-focused well-modulated customer loyalty', 'nparnabyn@deliciousdays.com', 'Nobe', 'Parnaby', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/155x171.bmp/dddddd/000000', 'http://dummyimage.com/193x153.jpg/ff4444/ffffff', 'nparnabyn');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (25, true, 'Robust leading edge capability', 'gwicklingo@ovh.net', 'Gwen', 'Wickling', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/145x219.png/dddddd/000000', 'http://dummyimage.com/162x246.bmp/5fa2dd/ffffff', 'gwicklingo');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (26, true, 'Front-line client-server algorithm', 'eklausenp@cpanel.net', 'Emalia',     'Klausen', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/213x163.png/dddddd/000000', 'http://dummyimage.com/207x138.png/5fa2dd/ffffff', 'eklausenp');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (27, true, 'Open-architected upward-trending frame', 'jgoldingayq@a8.net', 'Janis',   'Goldingay', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/117x244.jpg/ff4444/ffffff', 'http://dummyimage.com/144x235.bmp/cc0000/ffffff', 'jgoldingayq');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (28, true, 'Diverse attitude-oriented protocol', 'adondonr@rakuten.co.jp', 'Avery',   'Dondon', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/176x141.jpg/cc0000/ffffff', 'http://dummyimage.com/120x155.jpg/ff4444/ffffff', 'adondonr');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (29, true, 'Cross-group local benchmark', 'etrevess@imageshack.us', 'Emilio',  'Treves', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/104x115.jpg/ff4444/ffffff', 'http://dummyimage.com/137x248.png/5fa2dd/ffffff', 'etrevess');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (30, true, 'Down-sized real-time forecast', 'kbremeyert@msn.com', 'Kalie',   'Bremeyer', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/244x248.jpg/cc0000/ffffff', 'http://dummyimage.com/113x192.png/dddddd/000000', 'kbremeyert');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (31, true, 'Cross-platform optimizing workforce', 'cdoylendu@joomla.org', 'Chickie', 'Doylend', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/206x100.png/ff4444/ffffff', 'http://dummyimage.com/131x218.jpg/dddddd/000000', 'cdoylendu');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (32, true, 'Organic dynamic open system', 'fwanjekv@delicious.com', 'Forster','Wanjek', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/164x134.bmp/5fa2dd/ffffff', 'http://dummyimage.com/206x243.bmp/cc0000/ffffff', 'fwanjekv');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (33, true, 'Fully-configurable high-level open system', 'ssoonhousew@t-online.de', 'Suzette','Soonhouse', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/247x245.png/cc0000/ffffff', 'http://dummyimage.com/110x125.bmp/5fa2dd/ffffff', 'ssoonhousew');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (34, true, 'Virtual grid-enabled help-desk', 'ldaunayx@apple.com', 'Lindi', 'Daunay', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/229x129.bmp/5fa2dd/ffffff', 'http://dummyimage.com/172x223.bmp/cc0000/ffffff', 'ldaunayx');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (35, true, 'Integrated high-level parallelism', 'fmullochy@nationalgeographic.com', 'Fabiano', 'Mulloch', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/164x114.bmp/ff4444/ffffff', 'http://dummyimage.com/193x142.bmp/ff4444/ffffff', 'fmullochy');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (36, true, 'Proactive leading edge extranet', 'lpichanz@narod.ru', 'Leigh','Pichan', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/143x215.jpg/ff4444/ffffff', 'http://dummyimage.com/133x236.bmp/5fa2dd/ffffff', 'lpichanz');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (37, true, 'Decentralized composite workforce', 'dcummins10@theguardian.com', 'Dita',   'Cummins', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/230x102.bmp/dddddd/000000', 'http://dummyimage.com/138x185.png/dddddd/000000', 'dcummins10');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (38, true, 'Down-sized user-facing system engine', 'tdcruze11@unc.edu', 'Trevor',   'D''Cruze', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/130x194.png/ff4444/ffffff', 'http://dummyimage.com/197x212.png/dddddd/000000', 'tdcruze11');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (39, true, 'Re-contextualized secondary local area network', 'gkimmins12@economist.com', 'Gaven',     'Kimmins', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/171x202.jpg/dddddd/000000', 'http://dummyimage.com/162x213.png/cc0000/ffffff', 'gkimmins12');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (40, true, 'Versatile responsive synergy', 'lwille13@dagondesign.com', 'Lowe', 'Wille', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/158x147.bmp/dddddd/000000', 'http://dummyimage.com/233x234.png/cc0000/ffffff', 'lwille13');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (41, true, 'Cross-platform bifurcated access', 'hsilcocks14@slashdot.org', 'Hilliard',  'Silcocks', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/186x211.bmp/cc0000/ffffff', 'http://dummyimage.com/245x208.png/5fa2dd/ffffff', 'hsilcocks14');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (42, true, 'Synergistic tangible pricing structure', 'eboick15@uol.com.br', 'Emlen', 'Boick', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/130x202.png/dddddd/000000', 'http://dummyimage.com/168x152.bmp/ff4444/ffffff', 'eboick15');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (43, true, 'Organized even-keeled throughput', 'hsturdey16@studiopress.com', 'Hailey','Sturdey', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/176x178.png/dddddd/000000', 'http://dummyimage.com/108x156.jpg/5fa2dd/ffffff', 'hsturdey16');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (44, true, 'Public-key high-level website', 'alockhart17@bizjournals.com', 'Arlyn',  'Lockhart', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/122x101.png/dddddd/000000', 'http://dummyimage.com/237x137.bmp/dddddd/000000', 'alockhart17');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (45, true, 'Diverse motivating pricing structure', 'arany18@yale.edu', 'Aprilette',   'Rany', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/222x223.png/ff4444/ffffff', 'http://dummyimage.com/173x169.bmp/cc0000/ffffff', 'arany18');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (46, true, 'Cloned interactive software', 'jknox19@biglobe.ne.jp', 'Julina', 'Knox', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/110x125.png/dddddd/000000', 'http://dummyimage.com/249x150.jpg/5fa2dd/ffffff', 'jknox19');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (47, true, 'Expanded mobile hardware', 'vocollopy1a@macromedia.com', 'Vivie',   'O''Collopy', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/146x122.jpg/dddddd/000000', 'http://dummyimage.com/201x103.jpg/ff4444/ffffff', 'vocollopy1a');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (48, true, 'Monitored multi-state function', 'smckerrow1b@alibaba.com', 'Saidee',  'McKerrow', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/125x176.bmp/ff4444/ffffff', 'http://dummyimage.com/234x134.png/cc0000/ffffff', 'smckerrow1b');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (49, true, 'Multi-layered dedicated synergy', 'lleather1c@bigcartel.com', 'Lorens', 'Leather', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/204x107.png/cc0000/ffffff', 'http://dummyimage.com/107x234.png/cc0000/ffffff', 'lleather1c');
insert into users (id, is_active, bio, email, first_name, last_name, password, profile_image_url, resume_url, username) values (50, true, 'Ergonomic cohesive parallelism', 'gpauling1d@dell.com', 'Gerri','Pauling', '607858b389ae3bed1408281d20a2ea82b3baf46c', 'http://dummyimage.com/107x102.png/5fa2dd/ffffff', 'http://dummyimage.com/149x106.jpg/cc0000/ffffff', 'gpauling1d');

insert into users_skills (user_id, skill_id) values (4, 8);
insert into users_skills (user_id, skill_id) values (7, 7);
insert into users_skills (user_id, skill_id) values (25, 3);
insert into users_skills (user_id, skill_id) values (3, 9);
insert into users_skills (user_id, skill_id) values (15, 8);
insert into users_skills (user_id, skill_id) values (25, 5);
insert into users_skills (user_id, skill_id) values (25, 1);
insert into users_skills (user_id, skill_id) values (5, 3);
insert into users_skills (user_id, skill_id) values (18, 5);
insert into users_skills (user_id, skill_id) values (13, 4);
insert into users_skills (user_id, skill_id) values (25, 6);
insert into users_skills (user_id, skill_id) values (18, 2);
insert into users_skills (user_id, skill_id) values (18, 2);
insert into users_skills (user_id, skill_id) values (5, 2);
insert into users_skills (user_id, skill_id) values (2, 6);
insert into users_skills (user_id, skill_id) values (8, 8);
insert into users_skills (user_id, skill_id) values (1, 2);
insert into users_skills (user_id, skill_id) values (23, 3);
insert into users_skills (user_id, skill_id) values (2, 7);
insert into users_skills (user_id, skill_id) values (11, 2);
insert into users_skills (user_id, skill_id) values (15, 1);
insert into users_skills (user_id, skill_id) values (9, 2);
insert into users_skills (user_id, skill_id) values (20, 9);


# mentorship questions
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (3, 2,'What;s the difference between Java and Javascript', 'Java applications are run in a virtual machine or web browser while JavaScript is run on a web browser. Java code is compiled whereas while JavaScript code is in text and in a web page. JavaScript is an OOP scripting language, whereas Java is an OOP programming language', '', '2019-05-19', 'codeup student');
insert into post_ratings (user_id, post_id, rating) values (3, 1, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (6, 2, 'How do you guys deal with Imposter Syndrome', 'I feel like I don"t know enough to start applying for jobs.', '', '2019-05-21', 'codeup student');
insert into post_ratings (user_id, post_id, rating) values (6, 2, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (12, 2, 'Anyone need a mentor in Java', 'I am a Java programmer and have been for the last 3 years if there is anyone that needs help or has questions let me know if i can help', '', '2019-05-23', 'alumnus working for Accenture');
insert into post_ratings (user_id, post_id, rating) values (12, 3, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (4, 2, 'Whats the difference between Java and Javascript', 'Java applications are run in a virtual machine or web browser while JavaScript is run on a web browser. Java code is compiled whereas while JavaScript code is in text and in a web page. JavaScript is an OOP scripting language, whereas Java is an OOP programming language', '', '2019-05-30', 'codeup student');
insert into post_ratings (user_id, post_id, rating) values (4, 4, 0);

# interview questions
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (25, 1, 'What are OOP concepts?', '','They are an abstraction, encapsulation, inheritance, and polymorphism. Grasping them is key to understanding how Java works. Basically, Java OOP concepts let us create working methods and variables, then re-use all or part of them without compromising security', '2019-06-05', 'Accenture');
insert into post_ratings (user_id, post_id, rating) values (25, 5, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (2, 1, 'I got asked about arrays ','How do you find the missing number in a given integer array of 1 to 100?', '1) Calculate the sum of all numbers stored in the array of size 51. 2) Subtract the sum from (52 * 53)/2 ---- Formula : n * (n + 1) / 2.', '2019-06-12', 'Amazon');
insert into post_ratings (user_id, post_id, rating) values (2, 6, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (5, 1, 'Saw this question on LinkedIn', 'Explain encapsulation, inheritance, polymorphism and abstraction', 'Encapsulation is the mechanism of hiding of data implementation by restricting access to public methods. Instance variables are kept private and accessor methods are made public to achieve this. Abstract means a concept or an Idea which is not associated with any particular instance. Inheritances expresses “is-a” and/or “has-a” relationship between two objects. Using Inheritance, In derived classes we can reuse the code of existing super classes. In Java, concept of “is-a” is based on class inheritance (using extends) or interface implementation (using implements). Polymorphism: It means one name many forms. It is further of two types — static and dynamic. Static polymorphism is achieved using method overloading and dynamic polymorphism using method overriding. It is closely related to inheritance. We can write a code that works on the superclass, and it will work with any subclass type as well.','2019-06-13', 'Aivee');
insert into post_ratings (user_id, post_id, rating) values (5, 7, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (17, 1,  'Interview question about Spring Boot', 'Can you explain what happens in the background when a Spring Boot Application is “Run as Java Application','When a Spring Boot application is executed as “Run as Java application”, then it automatically launches up the tomcat server as soon as it sees, that you are developing a web application.', '2019-06-14', 'Intuit');
insert into post_ratings (user_id, post_id, rating) values (17, 8, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (19, 1, 'Make sure you have a great answer!', 'Tell me about some software projects you have worked on.','I just told them about my projects from Codeup and the projects i did at home', '2019-06-16', 'SWBC');
insert into post_ratings (user_id, post_id, rating) values (19, 9, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (8, 1,  'Just a question i though of in case your applying at a job that uses MySQL','What is a join in MySQL?','MySQL JOINS are used to retrieve data from multiple tables. A MySQL JOIN is performed whenever two or more tables are joined in a SQL statement.', '2019-06-17', 'Alumnus');
insert into post_ratings (user_id, post_id, rating) values (8, 10, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (8, 1,  'Java Question','Why Java is not 100% Object-oriented?','Java is not 100% Object-oriented because it makes use of eight primitive data types such as boolean, byte, char, int, float, double, long, short which are not objects.', '2019-06-17', 'Alumnus');
insert into post_ratings (user_id, post_id, rating) values (8, 11, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (8, 1,  ' Got asked this at J-Roc Co','What are wrapper classes in Java?','Wrapper classes convert the Java primitives into the reference types (objects). Every primitive data type has a class dedicated to it. These are known as wrapper classes because they “wrap” the primitive data type into an object of that class. Refer to the below image which displays different primitive type, wrapper class and constructor argument.', '2019-06-17', 'J-Roc Co');
insert into post_ratings (user_id, post_id, rating) values (8, 12, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (8, 1,  'Constructors','What are constructors in Java?','In Java, constructor refers to a block of code which is used to initialize an object. It must have the same name as that of the class. Also, it has no return type and it is automatically called when an object is created.', '2019-06-17', 'Alumnus');
insert into post_ratings (user_id, post_id, rating) values (8, 13, 0);

# job postings
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (10, 3, 'Entry Level Software Engineer', 'You will be joining our cutting-edge development team as it grows. We want individuals who are comfortable asking “why?” The ideal candidate for this role is motivated, energized and has a creative thought process. They are a team player possessing strong analytical as well as technical skills and are able to communicate the logic behind technical decisions to non-tech stakeholders. They must be comfortable working in an agile environment and have the ability to “take the wheel” when necessary.', '', '2019-07-04', 'Enhance IT');
insert into post_ratings (user_id, post_id, rating) values (10, 14, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (15, 3, 'Software Developer I', 'Description: The Software Developer will provide software development in support of custom software design and development of CNO tools and techniques. Candidate will be required to Provide/author documentation, participate in design, code, and software readiness reviews as prescribed by the customers software development procedures and processes.', '', '2019-07-04', 'Raytheon');
insert into post_ratings (user_id, post_id, rating) values (15, 15, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (7, 3, 'Entry Level Full Stack Software Developer', 'As a software developer at Labatt, you will take on projects approximately 6 months in length, iterate on a small team of 3-5, test thoroughly, design clean & modular code, experiment, learn, be challenged, and serve the needs of the business. All developers are expected to contribute to the team''s success by solving non-trivial problems and sharing lessons learned with the group. Developers are also expected to follow the group''s established coding and process best practices as established by the group to ensure quality and consistent code - code that will last for many years. That said, developers have a significant amount of freedom over their projects and the ability to experiment with newer technologies and practices that may help the group overall.', '', '2019-07-12', 'Labatt Food Service');
insert into post_ratings (user_id, post_id, rating) values (7, 16, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (22, 3, 'Entry Level Software Developer','• College degree (Associates or Bachelors)• Must be authorized to work in the US • Strong desire to learn to code - No prior professional experience required. • A natural problem solver • Strong communication and interpersonal skills• Willing to relocate anywhere in the US - Relocation assistance provided', '', '2019-08-01', 'uncle bob''s');
insert into post_ratings (user_id, post_id, rating) values (22, 17, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (20, 3, 'Federal - Entry Level Java Developer Associate [April 2020 Start]','Eager to learn about technology’s role in a real-world setting. You are already passionate about technology and know its potential. Now you are ready to work on a team, use your skills, and deliver innovative solutions that help our federal clients improve the services they provide to the American Public.', '', '2019-08-04', 'Accenture');
insert into post_ratings (user_id, post_id, rating) values (20, 18, 0);
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (1, 3, 'Java Developer - Entry Level- Apply now!','ERP is currently seeking a Java Developer with at least 1-2 years experience in Java Software Development for a full-time position supporting a federal client in San Antonio, TX.', '', '2019-08-14', 'ERP');
insert into post_ratings (user_id, post_id, rating) values (1, 19, 0);

# whiteboard-questions
insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (1, 4, 'Maximum Stock Profit', 'Given a array of numbers representing the stock prices of a company in chronological order, write a function that calculates the maximum profit you could have made from buying and selling that stock once. You must buy before you can sell it.
For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.','Whitboard Host Provided', '2020-04-06', 'Facebook');
insert into post_ratings (user_id, post_id, rating) values (1, 20, 0);

insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (1, 4, 'Longest Palindromic Substring', 'Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum length, return any one.
For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana".','Whitboard Host Provided', '2020-04-06', 'Amazon');
insert into post_ratings (user_id, post_id, rating) values (1, 21, 0);

insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (1, 4, 'Inversion Count', 'We can determine how "out of order" an array A is by counting the number of inversions it has. Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. That is, a smaller element appears after a larger element.
Given an array, count the number of inversions it has. Do this faster than O(N^2) time.
You may assume each element in the array is distinct.
For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3). The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.','Whitboard Host Provided', '2020-04-06', 'Google');
insert into post_ratings (user_id, post_id, rating) values (1, 22, 0);

insert into posts (user_id, post_type_id, title, body, answer, date_time, employer) values (1, 4, 'Push It, Pop It, Max It', 'Implement a stack that has the following methods:
push(val), which pushes an element onto the stack
pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
Each method should run in constant time.','Whitboard Host Provided', '2020-04-06', 'Amazon');
insert into post_ratings (user_id, post_id, rating) values (1, 23, 0);

#Post Comments
insert into post_comments (body, date_time, post_id, user_id) values ('I"m looking for a mentor!', '2019-09-01', 3, 13);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (13, 1, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('How many years of experience do I need?', '2019-09-01', 15, 2);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (2, 2, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('3', '2019-09-01', 1, 6);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (6, 3, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('80 years.', '2019-09-21', 15, 14);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (14, 4, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('There are better ways to do that', '2019-09-23', 6, 5);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (5, 5, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Feel free to join... me in chat if you want to discuss this.', '2019-09-23', 10, 19);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (19, 6, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('We have all felt that way before. It"s natural', '2019-09-23', 2, 19);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (19, 7, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Make sure you"re always working on something new', '2019-10-01', 9, 15);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (15, 8, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Were Java and JavaScript created by the same coffee company?', '2019-10-01', 4, 9);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (9, 9, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Why would you use a wrapper class?', '2019-10-09', 12, 6);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (6, 10, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Can you overload constructors?', '2019-10-09', 13, 18);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (18, 11, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Is there a good book on this subject?', '2019-10-09', 5, 6);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (6, 12, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Working on projects is the best way to learn.', '2019-10-11', 9, 20);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (20, 13, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Comments are a great tool', '2019-10-19', 16, 16);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (16, 14, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Comments are a great tool', '2019-11-01', 14, 11);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (11, 15, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Comments are a great tool', '2019-11-19', 12, 14);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (14, 16, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Comments are a great tool', '2019-12-07', 8, 7);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (7, 17, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Comments are a great tool', '2019-12-09', 11, 2);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (2, 18, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Comments are a great tool', '2020-01-01', 13, 4);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (4, 19, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Comments are a great tool', '2020-01-19', 7, 13);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (13, 20, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Comments are a great tool', '2020-01-19', 12, 6);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (6, 21, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Comments are a great tool', '2020-01-19', 6, 17);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (17, 22, 0);
insert into post_comments (body, date_time, post_id, user_id) values ('Comments are a great tool', '2020-01-19', 3, 12);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (12, 23, 0);

#Generic Ratings for variance
insert into post_ratings (user_id, post_id, rating) values (1, 1, 1);
insert into post_ratings (user_id, post_id, rating) values (2, 1, 1);
insert into post_ratings (user_id, post_id, rating) values (3, 1, 1);
insert into post_ratings (user_id, post_id, rating) values (4, 1, 0);
insert into post_ratings (user_id, post_id, rating) values (4, 2, 1);
insert into post_ratings (user_id, post_id, rating) values (5, 2, 0);
insert into post_ratings (user_id, post_id, rating) values (6, 2, 1);
insert into post_ratings (user_id, post_id, rating) values (7, 2, -1);
insert into post_ratings (user_id, post_id, rating) values (8, 3, -1);
insert into post_ratings (user_id, post_id, rating) values (9, 3, -1);
insert into post_ratings (user_id, post_id, rating) values (10, 3, -1);
insert into post_ratings (user_id, post_id, rating) values (11, 4, 0);
insert into post_ratings (user_id, post_id, rating) values (12, 4, -1);
insert into post_ratings (user_id, post_id, rating) values (13, 4, 1);
insert into post_ratings (user_id, post_id, rating) values (14, 4, 1);
insert into post_ratings (user_id, post_id, rating) values (10, 5, -1);
insert into post_ratings (user_id, post_id, rating) values (11, 5, 0);
insert into post_ratings (user_id, post_id, rating) values (12, 5, -1);
insert into post_ratings (user_id, post_id, rating) values (13, 5, 1);
insert into post_ratings (user_id, post_id, rating) values (14, 5, 1);
insert into post_ratings (user_id, post_id, rating) values (1, 20, 1);
insert into post_ratings (user_id, post_id, rating) values (2, 20, 1);
insert into post_ratings (user_id, post_id, rating) values (1, 21, 1);
insert into post_ratings (user_id, post_id, rating) values (1, 22, 1);
insert into post_ratings (user_id, post_id, rating) values (1, 23, 1);
insert into post_ratings (user_id, post_id, rating) values (2, 23, 1);
insert into post_ratings (user_id, post_id, rating) values (3, 23, 1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (1, 1, 1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (1, 3, 1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (2, 1, 1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (2, 5, -1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (2, 7, 1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (3, 1, 1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (3, 2, 1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (3, 3, 1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (4, 4, -1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (4, 1, 1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (5, 4, -1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (5, 2, 1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (6, 1, 1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (7, 7, 1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (7, 9, 1);
insert into post_comment_ratings (user_id, post_comment_id, rating) values (8, 2, 1);

insert into security_roles (role) values ('ADMIN');
insert into security_roles (role) values ('INSTRUCTOR');
insert into security_roles (role) values ('ALUMNUS');
insert into security_roles (role) values ('STUDENT');

insert into approved_emails (email) values ('superadmin@example.com');
insert into approved_emails (email) values ('admininstructor@example.com');
insert into approved_emails (email) values ('admininstructoralum@example.com');
insert into approved_emails (email) values ('student@example.com');

insert into approved_emails_security_roles (approved_email_id, role_id) values (1, 1);
insert into approved_emails_security_roles (approved_email_id, role_id) values (2, 1);
insert into approved_emails_security_roles (approved_email_id, role_id) values (2, 2);
insert into approved_emails_security_roles (approved_email_id, role_id) values (3, 1);
insert into approved_emails_security_roles (approved_email_id, role_id) values (3, 2);
insert into approved_emails_security_roles (approved_email_id, role_id) values (3, 3);
insert into approved_emails_security_roles (approved_email_id, role_id) values (4, 4);

# insert into image_urls (post_id, url) values (16, 'http://dummyimage.com/115x178.png/ff4444/ffffff');
# insert into image_urls (post_id, url) values (11, 'http://dummyimage.com/217x105.bmp/5fa2dd/ffffff');
# insert into image_urls (post_id, url) values (16, 'http://dummyimage.com/214x212.jpg/ff4444/ffffff');
# insert into image_urls (post_id, url) values (19, 'http://dummyimage.com/126x153.bmp/5fa2dd/ffffff');
# insert into image_urls (post_id, url) values (19, 'http://dummyimage.com/242x182.jpg/ff4444/ffffff');
# insert into image_urls (post_id, url) values (10, 'http://dummyimage.com/102x155.jpg/5fa2dd/ffffff');
# insert into image_urls (post_id, url) values (20, 'http://dummyimage.com/152x163.png/5fa2dd/ffffff');
# insert into image_urls (post_id, url) values (6, 'http://dummyimage.com/119x178.bmp/ff4444/ffffff');
# insert into image_urls (post_id, url) values (3, 'http://dummyimage.com/108x120.jpg/dddddd/000000');
# insert into image_urls (post_id, url) values (16, 'http://dummyimage.com/183x219.png/cc0000/ffffff');
# insert into image_urls (post_id, url) values (5, 'http://dummyimage.com/156x170.png/dddddd/000000');
# insert into image_urls (post_id, url) values (20, 'http://dummyimage.com/229x134.jpg/dddddd/000000');
# insert into image_urls (post_id, url) values (17, 'http://dummyimage.com/185x230.png/dddddd/000000');
# insert into image_urls (post_id, url) values (19, 'http://dummyimage.com/126x173.bmp/cc0000/ffffff');
# insert into image_urls (post_id, url) values (4, 'http://dummyimage.com/104x153.bmp/dddddd/000000');
# insert into image_urls (post_id, url) values (7, 'http://dummyimage.com/217x145.bmp/ff4444/ffffff');
# insert into image_urls (post_id, url) values (5, 'http://dummyimage.com/201x142.png/5fa2dd/ffffff');
# insert into image_urls (post_id, url) values (19, 'http://dummyimage.com/148x224.jpg/dddddd/000000');
# insert into image_urls (post_id, url) values (17, 'http://dummyimage.com/159x214.jpg/dddddd/000000');
# insert into image_urls (post_id, url) values (10, 'http://dummyimage.com/242x216.jpg/ff4444/ffffff');
# insert into image_urls (post_id, url) values (9, 'http://dummyimage.com/183x200.bmp/dddddd/000000');
# insert into image_urls (post_id, url) values (17, 'http://dummyimage.com/191x238.png/cc0000/ffffff');
# insert into image_urls (post_id, url) values (20, 'http://dummyimage.com/203x237.jpg/ff4444/ffffff');
