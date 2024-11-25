--- employee master table create

create table employee_master (id number, name varchar)

----employee master stream create

create stream employee_stream on table employee_master

------ create employee task

create or replace task employee_master_task
warehouse = compute_wh
schedule = '1 minute'
when 
system$stream_has_data('employee_master_stream')
as
merge into curated_employee_master a using employee_master_stream b
on a.employee_id = b.employee_id
when matched and METADATA$ACTION = 'INSERT' and METADATA$ISUPDATE= 'TRUE' then
update  set
a.employee_id=b.employee_id,
a.firstname=b.firstname,
a.lastname=b.lastname,
a.email=lower(b.email || '@gmail.com'),
a.mobile=replace(b.mobile , '.', '')
when not matched and METADATA$ACTION = 'INSERT' and METADATA$ISUPDATE= 'FALSE' then
insert (a.employee_id, a.firstname, a.lastname, a.email, a.mobile) values
(b.employee_id, b.firstname, b.lastname, lower(b.email || '@gmail.com'), replace(b.mobile , '.', ''));

---- start employee task
alter task employee_master_task resume;

----check time
select current_time();


