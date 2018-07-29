create table UserWalletAddressEntity
( userId varchar(255) not null ,
address varchar(255) not null,
keyPath varchar(255) not null,
        primary key (address)
    ) ENGINE=InnoDB;