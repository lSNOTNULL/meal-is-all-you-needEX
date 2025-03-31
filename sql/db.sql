create table animes (
    anime_id varchar(255)   primary key ,
    title    varchar(255)   unique not null,
    description varchar(255) not null ,
    created_at timestamp default current_timestamp
);

create table anime_votes (
    anime_vote_id   int unsigned primary key auto_increment,
    anime_id    varchar(255)    references animes (anime_id),
    created_at  timestamp default current_timestamp
);
# MySQL 에서 COLUMN 명 변경
ALTER TABLE animes CHANGE COLUMN createdAt created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
# PostgreSQL
ALTER TABLE animes RENAME COLUMN createdAt TO created_at;

# 해당 COLUMN 만 삭제
ALTER table animes DROP createdAT;
# 해당 COLUMN 만 재생성
alter table animes add column created_at timestamp default current_timestamp;