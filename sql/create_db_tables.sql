use pts_db;

CREATE TABLE IF NOT EXISTS users(
	id int PRIMARY KEY auto_increment,
	inserted_at timestamp NOT NULL DEFAULT NOW(),
	first_name varchar(20),
	last_name varchar(30),
	username varchar(20) UNIQUE,
	email_address varchar(30) UNIQUE,
	password varchar(20),
	authenticated boolean DEFAULT FALSE,
	is_deleted boolean DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS followers(
	user_id INTEGER NOT NULL,
	follower_id INTEGER NOT NULL,
	FOREIGN KEY (user_id) REFERENCES users(id),
	FOREIGN KEY (follower_id) REFERENCES users(id),
	PRIMARY KEY (user_id, follower_id)
);

