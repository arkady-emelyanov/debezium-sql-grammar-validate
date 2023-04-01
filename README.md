# Simple Debezium SQL grammar validator

```
> java -version
openjdk version "17.0.5" 2022-10-18
OpenJDK Runtime Environment Homebrew (build 17.0.5+0)
OpenJDK 64-Bit Server VM Homebrew (build 17.0.5+0, mixed mode, sharing)

> java -jar ./target/sql-grammar-validate-jar-with-dependencies.jar -f example.sql
66 [main] INFO io.debezium.utils.SqlValidator - Reading example.sql
72 [main] INFO io.debezium.utils.SqlValidator - Provided SQL: '-- alter table if exists payment drop encrypted_first_name;
insert into x values (1, 2);
insert into y (id) values (1);
update z set id = 1;
'
606 [main] INFO io.debezium.utils.SqlValidator - Parse successful.
```
