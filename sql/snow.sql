create or replace table git (id number, name varchar);

insert into git values
(1, 'saba'),
(2, 'susi'),
(3, 'ajay'),
(4, 'tamil');

create stream gitstream on table git;

create task t
warehouse = compute_wh
schedule = '1 minute'
as
insert into git values
(5, 'vijay');