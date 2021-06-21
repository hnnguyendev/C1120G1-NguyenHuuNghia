SELECT * FROM cinema_db.ticket;

select ticket.time_create as createDate, 
		sum(movie_ticket.ticket_price) as revenue, 
		count(ticket.ticket_id) as ticketQuantity
from ticket
inner join movie_ticket
on ticket.movie_ticket_id = movie_ticket.movive_ticket_id
where ticket.ticket_status = 2
group by ticket.time_create
having ticket.time_create between '2021-06-20' and '2021-06-21';

select ticket.time_create as createDate, 
		sum(movie_ticket.ticket_price) as revenue, 
		count(ticket.ticket_id) as ticketQuantity
from ticket
inner join movie_ticket
on ticket.movie_ticket_id = movie_ticket.movive_ticket_id
group by ticket.time_create
having month(ticket.time_create) = 6 and year(ticket.time_create) = 2021;

select ticket.time_create as createDate, 
		sum(movie_ticket.ticket_price) as revenue, 
		count(ticket.ticket_id) as ticketQuantity
from ticket
inner join movie_ticket
on ticket.movie_ticket_id = movie_ticket.movive_ticket_id
group by month(ticket.time_create)
having year(ticket.time_create) = 2021;

select user.name as name, 
		sum(movie_ticket.ticket_price) as totalPay,
        account.point as point
from user
inner join account
on user.username = account.username
inner join ticket
on user.user_id = ticket.user_id
inner join movie_ticket
on ticket.movie_ticket_id = movie_ticket.movive_ticket_id
where ticket.ticket_status = 2
group by user.user_id
-- having ticket.ticket_status = 2
order by totalPay desc, point desc
limit 10;

select category.category_name as categoryName,
		count(ticket.ticket_id) as ticketQuantity
from ticket
inner join movie_ticket
on ticket.movie_ticket_id = movie_ticket.movive_ticket_id
inner join movie
on movie_ticket.movie_id = movie.movie_id
inner join movie_category
on movie.movie_id = movie_category.movie_id
inner join category
on movie_category.category_id = category.category_id
group by category.category_id
order by ticketQuantity desc
limit 5;

select show_time.show_time as showTime,
		count(ticket.ticket_id) as ticketQuantity
from ticket
inner join movie_ticket
on ticket.movie_ticket_id = movie_ticket.movive_ticket_id
inner join show_time
on movie_ticket.show_time_id = show_time.show_time_id
group by show_time.show_time_id
order by ticketQuantity desc
limit 5;

select movie.movie_name as movieName, 
		count(ticket.ticket_id) as ticketQuantity,
		sum(movie_ticket.ticket_price) as revenue
from ticket
inner join movie_ticket
on ticket.movie_ticket_id = movie_ticket.movive_ticket_id
inner join movie
on movie_ticket.movie_id = movie.movie_id
where ticket.ticket_status = 2
group by movie.movie_id
order by ticketQuantity desc, revenue desc
limit 5;

alter table show_time
modify show_time varchar(50);

INSERT INTO show_time(show_time)
values ('14:00:00'), 
		('15:45:00'), 
        ('21:30:00'), 
        ('10:30:00'), 
        ('18:45:00'), 
        ('19:00:00'), 
        ('19:45:00'), 
        ('20:30:00'), 
        ('22:30:00'), 
        ('23:45:00');
        
INSERT INTO category(category_name)
values ('Kinh dị'), 
		('Hành động'), 
        ('Tình cảm'), 
        ('Hoạt hình'), 
        ('Khoa học viễn tưởng'),
        ('Hài hước'), 
		('Gia đình'), 
        ('Đua xe'), 
        ('Anime'), 
        ('Tài liệu');

INSERT INTO movie(actor, director, end_date, movie_length, movie_name, movie_studio, movie_type, poster_movie, start_date, trailer)
values ('Brad Pitt', 'James Cameroon', '2021-02-14', 90, 'Troy', 'Paramount', '', '', '2021-02-01', ''), 
		('Leonardo DiCaprio', 'James Cameroon', '2021-02-14', 120, 'Titanic', 'Paramount', '', '', '2021-02-01', ''), 
		('Brad Pitt', 'Doug Liman', '2021-03-14', 95, 'Ông bà Smith', 'Paramount', '', '', '2021-03-01', ''), 
		('Leonardo DiCaprio', 'Martin Scorsese', '2021-06-23', 100, 'Sói già phố Wall', 'Paramount', '', '', '2021-04-10', ''), 
		('Brad Pitt', 'David Ayer', '2021-10-27', 90, 'Cuồng nộ', 'Paramount', '', '', '2021-10-13', ''),
        ('Brad Pitt', 'James Cameroon', '2021-02-14', 90, 'Speed', 'Paramount', '', '', '2021-02-01', ''), 
		('Leonardo DiCaprio', 'James Cameroon', '2021-02-14', 120, 'Endgame', 'Paramount', '', '', '2021-02-01', ''), 
		('Brad Pitt', 'Doug Liman', '2021-03-14', 95, 'Intern', 'Paramount', '', '', '2021-03-01', ''), 
		('Leonardo DiCaprio', 'Martin Scorsese', '2021-06-23', 100, 'Captain America', 'Paramount', '', '', '2021-04-10', ''), 
		('Brad Pitt', 'David Ayer', '2021-10-27', 90, 'Fast and Furious 8', 'Paramount', '', '', '2021-10-13', '');
        
insert into movie_category(category_id,movie_id)
values (1, 1),
		(2, 2),
		(3, 3),
		(4, 4),
		(5, 5),
        (6, 6),
		(7, 7),
		(8, 8),
		(9, 9),
		(10, 10);

insert into movie_ticket(show_date,ticket_price,movie_id,show_time_id)
values ('2021-06-20', 50000,1,1),
		('2021-06-20', 60000,2,2),
        ('2021-06-21', 90000,3,3),
        ('2021-06-21', 120000,4,4),
        ('2021-06-21', 40000,5,5),
        ('2021-06-20', 50000,6,6),
		('2021-06-20', 60000,7,7),
        ('2021-06-21', 90000,8,8),
        ('2021-06-21', 120000,9,9),
        ('2021-06-21', 40000,10,10);
        
insert into account(username,point)
values ('username1', '2000'),
		('username2', '5000'),
        ('username3', '4000'),
        ('username4', '2000'),
        ('username5', '1500'),
        ('username6', '7000'),
		('username7', '3000'),
        ('username8', '7000'),
        ('username9', '9000'),
        ('username10', '2500'),
        ('username11', '4000'),
		('username12', '9000'),
        ('username13', '6000'),
        ('username14', '8000'),
        ('username15', '3500');	

insert into user(name,username)
values ('Nguyễn Hữu Nghĩa', 'username1'),
		('Nguyễn Thị Tường Vi', 'username2'),
        ('Hoàng Lê Quang', 'username3'),
        ('Nguyễn Hoàng Bảo Ngọc', 'username4'),
        ('Trần Quốc Hoàng', 'username5'),
        ('Lê Hoàng Minh Tuấn', 'username6'),
		('Nguyễn Gia Thiên', 'username7'),
        ('Trần Hoàng Sang', 'username8'),
        ('Nguyễn Ngọc Thuần', 'username9'),
        ('Nguyễn Ngọc Đông', 'username10'),
        ('Trần Huỳnh Bảo Thịnh', 'username11'),
		('Trần Hữu Hân', 'username12'),
        ('Trương Tấn Hải', 'username13'),
        ('Đặng Chí Trung', 'username14'),
        ('Nguyễn Vũ Thành Tiến', 'username15');
        
insert into ticket_status(ticket_status_name)
values ('Đợi nhận'),
		('Đã nhận');
        
insert into ticket(time_create,movie_ticket_id,user_id,ticket_status_id)
values ('2021-06-20', 1, 1,2),
		('2021-02-20', 2, 2,2),
        ('2021-01-21', 3, 3,2),
        ('2021-03-21', 4, 4,2),
        ('2021-04-21', 5, 5,2),
        ('2021-05-20', 6, 6,2),
		('2021-12-20', 7, 7,2),
        ('2021-07-21', 8, 8,2),
        ('2021-11-21', 9, 9,2),
        ('2021-10-21', 10, 10,2),
        ('2021-08-20', 1, 11,2),
		('2021-09-20', 2, 12,2),
        ('2021-06-21', 3, 13,2),
        ('2021-06-21', 4, 14,2),
        ('2021-06-21', 5, 15,2),
        ('2021-05-20', 1, 6,2),
		('2021-12-20', 2, 7,2),
        ('2021-07-21', 9, 8,2),
        ('2021-11-21', 8, 9,2),
        ('2021-10-21', 5, 10,2),
        ('2021-08-20', 5, 11,2),
		('2021-09-20', 7, 12,2);