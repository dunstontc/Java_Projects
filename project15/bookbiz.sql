
CREATE TABLE authors (
    au_id character(11) primary key,
    au_lname character varying(40) NOT NULL,
    au_fname character varying(20) NOT NULL,
    phone character(12),
    address character varying(40),
    city character varying(20),
    state character(2),
    zip character(5)
);


CREATE TABLE publishers (
    pub_id character(4) primary key,
    pub_name character varying(40) not null,
    address character varying(40) not null,
    city character varying(20) not null,
    state character(2) not null
);


CREATE TABLE roysched (
    title_id character(6),
    lorange integer,
    hirange integer,
    royalty double precision
);


CREATE TABLE titleauthors (
    au_id character(11) NOT NULL,
    title_id character(6) NOT NULL,
    au_ord smallint,
    royaltyshare double precision,
    primary key(au_id,title_id)
);


CREATE TABLE titles (
    title_id character(6) primary key,
    title character varying(80) NOT NULL,
    "type" character(12),
    pub_id character(4),
    price double precision,
    advance double precision,
    ytd_sales integer,
    contract boolean NOT NULL,
    notes character varying(200),
    pubdate date
);


CREATE TABLE editors (
    ed_id character(11) primary key,
    ed_lname character varying(40) NOT NULL,
    ed_fname character varying(20) NOT NULL,
    ed_pos character varying(12),
    phone character(12),
    address character varying(40),
    city character varying(20),
    state character(2),
    zip character(5)
);


CREATE TABLE titleditors (
    ed_id character(11) NOT NULL,
    title_id character(6) NOT NULL,
    ed_ord smallint,
    primary key(ed_id,title_id)
);


CREATE TABLE sales (
    sonum integer primary key,
    stor_id character(4) NOT NULL,
    ponum character varying(20) NOT NULL,
    sdate date
);


CREATE TABLE salesdetails (
    sonum integer NOT NULL,
    qty_ordered smallint NOT NULL,
    qty_shipped smallint,
    title_id character(6) NOT NULL,
    date_shipped date,
    primary key(sonum,title_id)
);
