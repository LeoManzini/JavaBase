create procedure product_name(in product_id int, out product_name varchar(255)) 
begin 
	select name 
		into product_name 
	from product 
	where id = product_id; 
end

create procedure search_products(in termo varchar(30)) 
begin 
	select id, name, price 
	from product 
	where upper(name) like upper(concat(termo, '%')); 
end

create procedure modify_product_price(in product_id int, in amount double, out new_price double) 
begin
	declare 
		product_price double; 
		select price into product_price
		from product 
		where id = product_id; 
		set new_price = product_price * amount; 
		update product set price = new_price where id = product_id; 
end