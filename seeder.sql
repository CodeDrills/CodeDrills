

use codeon_db;


CREATE USER codeon_user@localhost IDENTIFIED BY 'short';
GRANT ALL ON codeon_db.* TO codeon_user@localhost;