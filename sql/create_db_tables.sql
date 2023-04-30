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

CREATE TABLE IF NOT EXISTS activities(
	id integer primary key auto_increment,
    user_id INTEGER NOT NULL,
    task_id INTEGER,
	message varchar(1000) NOT NULL,
    created_on TIMESTAMP,
    
	FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE IF NOT EXISTS off_days(
	id integer primary key auto_increment,
    actual_date TIMESTAMP not null,
	type enum('SICK', 'LEAVE', 'HOLIDAY') NOT NULL,
    user_id integer not null,
    reasoning varchar(100),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
