select * from emp;
select lower('YES') from dual; -- dual is a virtual table for the integrity of grammar

-- employer salary tables in descreasing order
-- Five rows per pages, select the page two.
select * from (
       select rownum rn, e.* from (
              select * from emp order by sal desc
       ) e where rownum < 11
) where rn > 5;

---out类型参数如何使用
---使用存储过程来算年薪
create or replace procedure p_yearsal(eno emp.empno%type, yearsal out number)
is
   s number(10);
   c emp.comm%type;
begin
   select sal*12, nvl(comm, 0) into s, c from emp where empno = eno;
   yearsal := s+c;
end;

---测试p_yearsal
declare
  yearsal number(10);
begin
  p_yearsal(7788, yearsal);
  dbms_output.put_line(yearsal);
end;

----通过存储函数实现计算指定员工的年薪
----存储过程和存储函数的参数都不能带长度
----存储函数的返回值类型不能带长度
create or replace function f_yearsal(eno emp.empno%type) return number
is
  s number(10);     
begin
  select sal*12+nvl(comm, 0) into s from emp where empno = eno;
  return s;
end;

----测试f_yearsal
----存储函数在调用的时候，返回值需要接收。
declare
  s number(10); 
begin
  s := f_yearsal(7788);
  dbms_output.put_line(s);
end;


create table dept as select * from scott.dept;
create table emp as select * from scott.emp;

select * from dept;
select * from emp;





