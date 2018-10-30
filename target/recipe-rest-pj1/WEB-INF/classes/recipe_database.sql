drop database food_recipe;
create database food_recipe;
use food_recipe;

SHOW VARIABLES WHERE Variable_name LIKE 'character\_set\_%' OR Variable_name LIKE 'collation%';

select * from recipe_detail;
SELECT * FROM information_schema.SCHEMATA S WHERE schema_name = "food_recipe";
ALTER DATABASE food_recipe CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

SHOW CHARACTER SET;



-- Cong thuc
CREATE TABLE recipe
(
	id INT auto_increment primary key,
    food_category_id INT,
    name varchar(255) character set utf8mb4,
    service INT,
    cook_time INT,		-- don vi minute
    img_url varchar(255)
);
ALTER TABLE recipe
ADD column img_url varchar(255);

CREATE TABLE recipe_search
(
	id INT auto_increment primary key,
    name varchar(255) character set utf8mb4,
    img_url varchar(255)
);

-- Danh muc 
CREATE TABLE food_category
(
		id INT auto_increment primary key,
        name varchar(255) character set utf8mb4
);

-- Thanh phan
CREATE TABLE ingredient
(
	id int auto_increment primary key,
    name varchar(255) character set utf8mb4
);

-- Don vi
CREATE TABLE measurement
(
	id INT auto_increment primary key,
    name varchar(255) character set utf8mb4
);

-- So luong + don vi do cac thanh phan
CREATE TABLE quantity
(
	id INT auto_increment primary key,
    recipe_id int,
    ingredient_id int,
    ingredient_measurement_id int,
	number float
);
ALTER TABLE quantity
modify column number float;

CREATE TABLE recipe_step
(
	id INT auto_increment primary key,
    recipe_id INT,
    number INT,
    description varchar(255) character set utf8mb4
);

ALTER TABLE recipe 
ADD CONSTRAINT FK_recipe_food_category_id FOREIGN KEY (food_category_id) references food_category(id);

ALTER TABLE quantity
ADD CONSTRAINT FK_quantity_recipe_id foreign key (recipe_id) references recipe(id),
ADD CONSTRAINT FK_quantity_ingredient_id foreign key (ingredient_id) references ingredient(id),
ADD CONSTRAINT FK_quantity_ingredient_measurement_id foreign key (ingredient_measurement_id) references measurement(id);

ALTER TABLE recipe_step
ADD CONSTRAINT FK_recipe_step_recipe_id foreign key(recipe_id) references recipe(id);




select * from recipe;
select * from recipe_search;

select * from food_recipe.food_category;
select * from food_recipe.measurement;
select * from food_recipe.quantity;



insert into food_recipe.food_category(name) values
('Bơ sữa'),
('Trái cây, rau củ'),
('Hải sản'),
('Đồ uống'),
('Thịt');

INSERT INTO food_recipe.recipe(food_category_id, name,cook_time, service, img_url)
values
(5, 'Ức gà nướng chanh tỏi', 150, 4, 'https://media.cooky.vn/recipe/g5/41192/s800x500/cooky-recipe-cover-r41192.jpg');
INSERT INTO food_recipe.recipe(food_category_id, name,cook_time, service, img_url)
values
(2, 'Mước dâu ép húng quế chanh', 20, 4, 'https://media.cooky.vn/recipe/g5/41455/s800x500/cooky-recipe-cover-r41455.jpg');


INSERT INTO food_recipe.ingredient(name) 
values
('Ức gà'),('Chanh'), ('Tỏi'), ('Tiêu'),('Dầu olive'), ('Muối');

INSERT INTO food_recipe.measurement(name)
values
('gr'),
('ml'),
('trái'),
('tép'),
('muỗng cà phê');

INSERT INTO food_recipe.quantity(recipe_id,ingredient_id,number, ingredient_measurement_id) values
(1, 1,800, 1),
(1,2,2,3),
(1,3,6,4),
(1,4,0.25, 5),
(1,5,60,2),
(1,6,0.25,5);

-- CREATE TRIGGER FOR INSERT RECIPE 
DELIMITER $$
CREATE TRIGGER after_recipe_insert 	
	AFTER INSERT ON food_recipe.recipe
    for each row
BEGIN
	INSERT INTO recipe_search
    VALUES(NEW.id, NEW.name, NEW.img_url);
END$$
DELIMITER ;



        
