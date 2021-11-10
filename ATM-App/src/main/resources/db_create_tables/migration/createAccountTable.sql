CREATE TABLE IF NOT EXISTS account (
                          id serial PRIMARY KEY,
                          account_number numeric UNIQUE NOT NULL,
                          pin_number integer(4) NOT NULL,
                          opening_balance money NOT NULL,
                          overdraft  money NOT NULL,
                          created_on TIMESTAMP NOT NULL,
                          last_login TIMESTAMP
);

