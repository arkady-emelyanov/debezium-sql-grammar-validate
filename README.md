# Simple Debezium SQL grammar validator

```
> java -jar ./target/sql-grammar-validate-jar-with-dependencies.jar -f example.sql
66 [main] INFO io.debezium.utils.SqlValidator - Reading example.sql
72 [main] INFO io.debezium.utils.SqlValidator - Provided SQL: '-- alter table if exists payment drop encrypted_first_name;
insert into x values (1, 2);
insert into y (id) values (1);
update z set id = 1;
'
606 [main] INFO io.debezium.utils.SqlValidator - Parse successful.
```
