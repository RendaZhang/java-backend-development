select * from emp;
select lower('YES') from dual; -- dual is a virtual table for the integrity of grammar

-- employer salary tables in descreasing order
-- Five rows per pages, select the page two.
select * from (
       select rownum rn, e.* from (
              select * from emp order by sal desc
       ) e where rownum < 11
) where rn > 5;

---out���Ͳ������ʹ��
---ʹ�ô洢����������н
create or replace procedure p_yearsal(eno emp.empno%type, yearsal out number)
is
   s number(10);
   c emp.comm%type;
begin
   select sal*12, nvl(comm, 0) into s, c from emp where empno = eno;
   yearsal := s+c;
end;

---����p_yearsal
declare
  yearsal number(10);
begin
  p_yearsal(7788, yearsal);
  dbms_output.put_line(yearsal);
end;

----ͨ���洢����ʵ�ּ���ָ��Ա������н
----�洢���̺ʹ洢�����Ĳ��������ܴ�����
----�洢�����ķ���ֵ���Ͳ��ܴ�����
create or replace function f_yearsal(eno emp.empno%type) return number
is
  s number(10);     
begin
  select sal*12+nvl(comm, 0) into s from emp where empno = eno;
  return s;
end;

----����f_yearsal
----�洢�����ڵ��õ�ʱ�򣬷���ֵ��Ҫ���ա�
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





