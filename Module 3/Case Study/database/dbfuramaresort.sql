DROP DATABASE dbfuramaresort;

CREATE DATABASE dbfuramaresort;

USE dbfuramaresort;

CREATE TABLE vitri (
	id INT NOT NULL AUTO_INCREMENT,
    tenvitri VARCHAR(45) NOT NULL,
    CONSTRAINT vitri_pk PRIMARY KEY (id)
);

INSERT INTO vitri (tenvitri)
VALUES ('Chủ tịch'),
		('Giám đốc'),
        ('Trưởng phòng'),
        ('Trưởng nhóm'),
        ('Nhân viên');

CREATE TABLE trinhdo (
	id INT NOT NULL AUTO_INCREMENT,
    trinhdo VARCHAR(45) NOT NULL,
    CONSTRAINT trinhdo_pk PRIMARY KEY (id)
);

INSERT INTO trinhdo (trinhdo)
VALUES ('Nhà bác học'),
		('Giáo sư'),
        ('Phó giáo sư'),
        ('Tiến sĩ'),
        ('Thạc sĩ');

CREATE TABLE bophan (
	id INT NOT NULL AUTO_INCREMENT,
    tenbophan VARCHAR(45) NOT NULL,
    CONSTRAINT bophan_pk PRIMARY KEY (id)
);

INSERT INTO bophan (tenbophan)
VALUES ('Quản trị'),
		('Marketing'),
        ('Vận hành'),
        ('IT'),
        ('Kế toán');

CREATE TABLE nhanvien (
	id INT NOT NULL AUTO_INCREMENT,
    hoten VARCHAR(45) NOT NULL,
    idvitri INT NOT NULL,
    idtrinhdo INT NOT NULL,
    idbophan INT NOT NULL,
    ngaysinh DATE NOT NULL,
    cmnd VARCHAR(45) NOT NULL,
    luong INT NOT NULL,
    sdt VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    diachi VARCHAR(45) NOT NULL,
    CONSTRAINT nhanvien_pk PRIMARY KEY (id),
    CONSTRAINT nhanvien_fk1 FOREIGN KEY (idvitri) REFERENCES vitri(id),
    CONSTRAINT nhanvien_fk2 FOREIGN KEY (idtrinhdo) REFERENCES trinhdo(id),
    CONSTRAINT nhanvien_fk3 FOREIGN KEY (idbophan) REFERENCES bophan(id)
);

INSERT INTO nhanvien (hoten, idvitri, idtrinhdo, idbophan, ngaysinh, cmnd, luong, sdt, email, diachi)
VALUES ('Nguyễn Hữu Nghĩa', '1', '1', '1', '1997-06-09', '201731234', '200000000', '012345678', 'nghia@gmail.com', 'Đà Nẵng'),
		('Hồ Hữu Khánh', '1', '1', '1', '1997-06-09', '201731234', '200000000', '012345678', 'nghia@gmail.com', 'Huế'),
        ('Trần Văn Hòa', 1, 1, 1, '1997-06-09', '201731234', 200000000, '012345678', 'nghia@gmail.com', 'Hà Nội'),
        ('Khoa Tấn', 1, 1, 1, '1997-06-09', '201731234', 200000000, '012345678', 'nghia@gmail.com', 'Hải Phòng'),
        ('Đặng Văn Lam', '1', '1', '1', '1997-06-09', '201731234', '200000000', '012345678', 'nghia@gmail.com', 'Quảng Trị');

CREATE TABLE loaikhach (
	id INT NOT NULL AUTO_INCREMENT,
    tenloaikhach VARCHAR(45) NOT NULL,
    CONSTRAINT loaikhach_pk PRIMARY KEY (id)
);

INSERT INTO loaikhach (tenloaikhach)
VALUES ('Diamond'),
		('Platinium'),
        ('Gold'),
        ('Silver'),
        ('Member');

CREATE TABLE khachhang (
	id INT NOT NULL AUTO_INCREMENT,
    idloaikhach INT NOT NULL,
    hoten VARCHAR(45) NOT NULL,
    ngaysinh DATE NOT NULL,
    cmnd VARCHAR(45) NOT NULL,
    sdt VARCHAR(45) NOT NULL,
    email VARCHAR(45) NOT NULL,
    diachi VARCHAR(45) NOT NULL,
    CONSTRAINT khachhang_pk PRIMARY KEY (id),
    CONSTRAINT khachhang_fk FOREIGN KEY (idloaikhach) REFERENCES loaikhach(id)
);

ALTER TABLE khachhang
DROP FOREIGN KEY khachhang_fk;

ALTER TABLE khachhang
ADD CONSTRAINT khachhang_fk FOREIGN KEY (idloaikhach) REFERENCES loaikhach(id) ON UPDATE CASCADE ON DELETE CASCADE;

INSERT INTO khachhang (idloaikhach, hoten, ngaysinh, cmnd, sdt, email, diachi)
VALUES (1, 'Nguyễn Công Phượng', '2002-06-09', '201731234', '012345678', 'nghia@gmail.com', 'Đà Nẵng'),
		(2, 'Nguyễn Huy Hùng', '1997-06-09', '201731234', '012345678', 'nghia@gmail.com', 'Hà Nội'),
        (3, 'Phan Văn Long', '1920-02-26', '201731234', '012345678', 'nghia@gmail.com', 'Hải Phòng'),
        (4, 'Nguyễn Quang Hải', '1956-06-09', '201731234', '012345678', 'nghia@gmail.com', 'Quảng Trị'),
        (5, 'Nguyễn Văn Toàn', '2002-06-09', '201731234', '012345678', 'nghia@gmail.com', 'Vinh');

CREATE TABLE kieuthue (
	id INT NOT NULL AUTO_INCREMENT,
    tenkieuthue VARCHAR(45) NOT NULL,
    gia INT NOT NULL,
    CONSTRAINT kieuthue_pk PRIMARY KEY (id)
);

INSERT INTO kieuthue (tenkieuthue, gia)
VALUES ('Năm', 12000),
		('Tháng', 1000),
        ('Ngày', 50),
        ('Giờ', 20);

CREATE TABLE loaidichvu (
	id INT NOT NULL AUTO_INCREMENT,
    tenloaidichvu VARCHAR(45) NOT NULL,
    CONSTRAINT loaidichvu_pk PRIMARY KEY (id)
);

INSERT INTO loaidichvu (tenloaidichvu)
VALUES ('Villa'),
		('House'),
        ('Room');

CREATE TABLE dichvu (
	id INT NOT NULL AUTO_INCREMENT,
    tendichvu VARCHAR(45) NOT NULL,
    dientich INT NOT NULL,
    sotang INT NOT NULL,
    songuoitoida INT NOT NULL,
    chiphithue INT NOT NULL,
    idkieuthue INT NOT NULL,
    idloaidichvu INT NOT NULL,
    trangthai VARCHAR(45) NOT NULL,
    CONSTRAINT dichvu_pk PRIMARY KEY (id),
    CONSTRAINT dichvu_fk1 FOREIGN KEY (idkieuthue) REFERENCES kieuthue(id),
    CONSTRAINT dichvu_fk2 FOREIGN KEY (idloaidichvu) REFERENCES loaidichvu(id)
);

INSERT INTO dichvu (tendichvu, dientich, sotang, songuoitoida, chiphithue, idkieuthue, idloaidichvu, trangthai)
VALUES ('Villa 1', 100, 2, 8, 1000, 3, 1, 'Yes'),
		('Villa 2', 200, 3, 12, 1500, 2, 1, 'No'),
		('House 1', 150, 3, 10, 1200, 3, 2, 'No'),
		('House 2', 70, 1, 6, 5000, 4, 2, 'Yes'),
		('Room 1', 20, 1, 2, 1000, 1, 3, 'Yes'),
		('Room 2', 15, 1, 2, 500, 2, 3, 'Yes'),
		('Villa 3', 110, 1, 6, 1100, 3, 1, 'No');


CREATE TABLE dichvudikem (
	id INT NOT NULL AUTO_INCREMENT,
    tendichvudikem VARCHAR(45) NOT NULL,
    gia INT NOT NULL,
    donvi INT NOT NULL,
    trangthaikhadung VARCHAR(45) NOT NULL,
    CONSTRAINT dichvudikem_pk PRIMARY KEY (id)
);

ALTER TABLE dichvudikem
MODIFY donvi VARCHAR(20) NOT NULL;

ALTER TABLE dichvudikem
MODIFY donvi INT NOT NULL;

INSERT INTO dichvudikem (tendichvudikem, gia, donvi, trangthaikhadung)
VALUES ('Massage', 100, 1, 'Yes'),
		('Karaoke', 200, 3, 'Yes'),
        ('Thức ăn', 300, 2, 'Yes'),
        ('Nước uống', 50, 4, 'Yes'),
        ('Thuê xe ', 150, 1, 'Yes');

CREATE TABLE hopdong (
	id INT NOT NULL AUTO_INCREMENT,
    idnhanvien INT NOT NULL,
    idkhachhang INT NOT NULL,
    iddichvu INT NOT NULL,
    ngaylamhopdong DATE NOT NULL,
    ngayketthuc DATE NOT NULL,
    tiendatcoc INT NOT NULL,
    tongtien INT NOT NULL,
    CONSTRAINT hopdong_pk PRIMARY KEY (id),
    CONSTRAINT hopdong_fk1 FOREIGN KEY (idnhanvien) REFERENCES nhanvien(id),
    CONSTRAINT hopdong_fk2 FOREIGN KEY (idkhachhang) REFERENCES khachhang(id),
    CONSTRAINT hopdong_fk3 FOREIGN KEY (iddichvu) REFERENCES dichvu(id)
);

ALTER TABLE hopdong
DROP FOREIGN KEY hopdong_fk1;

ALTER TABLE hopdong
ADD CONSTRAINT hopdong_fk1 FOREIGN KEY (idnhanvien) REFERENCES nhanvien(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE hopdong
DROP FOREIGN KEY hopdong_fk2;

ALTER TABLE hopdong
ADD CONSTRAINT hopdong_fk2 FOREIGN KEY (idkhachhang) REFERENCES khachhang(id) ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE hopdong
DROP FOREIGN KEY hopdong_fk3;

ALTER TABLE hopdong
ADD CONSTRAINT hopdong_fk3 FOREIGN KEY (iddichvu) REFERENCES dichvu(id) ON UPDATE CASCADE ON DELETE CASCADE;

INSERT INTO hopdong (idnhanvien, idkhachhang, iddichvu, ngaylamhopdong, ngayketthuc, tiendatcoc, tongtien)
VALUES (1, 1, 3, '2021-02-28', '2021-03-02', 1000000, 0),
		(2, 2, 1, '2021-02-28', '2021-03-02', 1000000, 0),
        (4, 3, 4, '2019-01-28', '2019-02-01', 1000000, 0),
        (3, 5, 2, '2019-02-28', '2021-03-02', 1000000, 0),
        (5, 4, 5, '2019-03-28', '2021-03-02', 1000000, 0),
        (4, 5, 2, '2019-07-28', '2021-03-02', 1000000, 0),
        (3, 4, 2, '2019-05-28', '2021-03-02', 1000000, 0),
        (3, 3, 3, '2019-12-28', '2021-03-02', 1000000, 0),
        (2, 2, 1, '2019-02-15', '2019-02-20', 1000000, 0),
        (1, 1, 5, '2019-09-28', '2021-03-02', 1000000, 0);
		
CREATE TABLE hopdongchitiet (
	id INT NOT NULL AUTO_INCREMENT,
	idhopdong INT NOT NULL,
    iddichvudikem INT NOT NULL,
    soluong INT NOT NULL,
    CONSTRAINT hopdongchitiet_pk PRIMARY KEY (id),
    CONSTRAINT hopdongchitiet_fk1 FOREIGN KEY (idhopdong) REFERENCES hopdong(id),
    CONSTRAINT hopdongchitiet_fk2 FOREIGN KEY (iddichvudikem) REFERENCES dichvudikem(id)
);

ALTER TABLE hopdongchitiet
DROP FOREIGN KEY hopdongchitiet_fk1;

ALTER TABLE hopdongchitiet
ADD CONSTRAINT hopdongchitiet_fk1 FOREIGN KEY (idhopdong) REFERENCES hopdong(id) ON UPDATE CASCADE ON DELETE CASCADE;

INSERT INTO hopdongchitiet (idhopdong, iddichvudikem, soluong)
VALUES (1, 1, 2),
		(2, 3, 1),
        (3, 5, 1),
        (4, 4, 3),
        (5, 2, 2),
        (5, 2, 1),
        (4, 2, 1),
        (6, 5, 1),
        (7, 2, 1),
        (8, 2, 1),
        (10, 5, 1);

-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” 
-- và có tối đa 15 ký tự.

SELECT * 
FROM nhanvien
WHERE (SUBSTRING_INDEX(hoten, ' ', -1) LIKE 'H%' OR SUBSTRING_INDEX(hoten, ' ', -1) LIKE 'T%' 
		OR SUBSTRING_INDEX(hoten, ' ', -1) LIKE 'K%')
        AND (LENGTH(SUBSTRING_INDEX(hoten, ' ', -1)) <= 15);

-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

SELECT *, CURDATE() AS today, TIMESTAMPDIFF(YEAR,ngaysinh,CURDATE()) AS age
FROM khachhang
HAVING (age BETWEEN 18 AND 50) AND (diachi IN ('Đà Nẵng', 'Quảng Trị')); 

-- 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần 
-- theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

SELECT khachhang.id, khachhang.hoten, loaikhach.tenloaikhach, COUNT(hopdong.idkhachhang) AS numberoforders
FROM khachhang
INNER JOIN hopdong
ON khachhang.id = hopdong.idkhachhang
INNER JOIN loaikhach
ON khachhang.idloaikhach = loaikhach.id
GROUP BY hopdong.idkhachhang
HAVING loaikhach.tenloaikhach = 'Diamond'
ORDER BY numberoforders;

-- 5. Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

SELECT khachhang.id, khachhang.hoten, loaikhach.tenloaikhach, hopdong.id, dichvu.tendichvu, hopdong.ngaylamhopdong, 
		hopdong.ngayketthuc,
CASE
	WHEN hopdongchitiet.iddichvudikem IN (dichvudikem.id) THEN dichvu.chiphithue + SUM(dichvudikem.donvi * dichvudikem.gia)
    ELSE dichvu.chiphithue
END AS tongtien
FROM khachhang
LEFT JOIN hopdong
ON khachhang.id = hopdong.idkhachhang
LEFT JOIN loaikhach
ON khachhang.idloaikhach = loaikhach.id
LEFT JOIN dichvu
ON hopdong.iddichvu = dichvu.id
LEFT JOIN hopdongchitiet
ON hopdong.id = hopdongchitiet.idhopdong
LEFT JOIN dichvudikem
ON hopdongchitiet.iddichvudikem = dichvudikem.id
GROUP BY hopdong.id;

-- 6. Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được 
-- Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

SELECT dichvu.id, hopdong.ngaylamhopdong
FROM dichvu
INNER JOIN hopdong
ON dichvu.id = hopdong.iddichvu
WHERE hopdong.ngaylamhopdong > '2018-12-31';

SELECT dichvu.id, dichvu.tendichvu, dichvu.dientich, dichvu.chiphithue, loaidichvu.tenloaidichvu, hopdong.ngaylamhopdong
FROM dichvu
INNER JOIN loaidichvu
ON dichvu.idloaidichvu = loaidichvu.id
LEFT JOIN hopdong
ON dichvu.id = hopdong.iddichvu
WHERE dichvu.id NOT IN (SELECT iddichvu
						FROM hopdong
						WHERE hopdong.ngaylamhopdong > '2018-12-31');
                        
-- 7. Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ 
-- đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

SELECT dichvu.id, dichvu.tendichvu, dichvu.dientich, dichvu.songuoitoida, dichvu.chiphithue, loaidichvu.tenloaidichvu
FROM dichvu
INNER JOIN loaidichvu
ON dichvu.idloaidichvu = loaidichvu.id
INNER JOIN hopdong
ON dichvu.id = hopdong.iddichvu
WHERE dichvu.id IN (SELECT iddichvu
						FROM hopdong
						WHERE YEAR(hopdong.ngaylamhopdong) IN (2018))
AND dichvu.id NOT IN (SELECT iddichvu
						FROM hopdong
						WHERE YEAR(hopdong.ngaylamhopdong) IN (2019));

-- 8. Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoTenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

SELECT DISTINCT hoten
FROM khachhang;

SELECT hoten
FROM khachhang
GROUP BY hoten;

SELECT hoten
FROM khachhang
UNION
SELECT hoten
FROM khachhang;

-- 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu 
-- khách hàng thực hiện đặt phòng.

SELECT ngaylamhopdong, MONTH(ngaylamhopdong) AS `thang`, COUNT(id) AS sldatphong
FROM hopdong
GROUP BY `thang`
HAVING YEAR(ngaylamhopdong) IN (2019);

-- 10. Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
-- (được tính dựa trên việc count các IDHopDongChiTiet).

SELECT hopdong.id, hopdong.ngaylamhopdong, hopdong.ngayketthuc, hopdong.tiendatcoc, COUNT(hopdongchitiet.id) AS sldvdikem
FROM hopdong
INNER JOIN hopdongchitiet
ON hopdong.id = hopdongchitiet.idhopdong
GROUP BY hopdong.id;

-- 11. Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
-- và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

SELECT dichvudikem.id, dichvudikem.tendichvudikem, dichvudikem.gia, dichvudikem.donvi, dichvudikem.trangthaikhadung, khachhang.hoten, khachhang.diachi
FROM dichvudikem
INNER JOIN hopdongchitiet
ON dichvudikem.id = hopdongchitiet.iddichvudikem
INNER JOIN hopdong
ON hopdongchitiet.idhopdong = hopdong.id
INNER JOIN khachhang
ON hopdong.idkhachhang = khachhang.id
INNER JOIN loaikhach
ON khachhang.idloaikhach = loaikhach.id
WHERE loaikhach.tenloaikhach = 'Diamond' AND khachhang.diachi IN ('Vinh', 'Quảng Ngãi');

-- 12. Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 
-- 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
-- chua ok

SELECT iddichvu
FROM hopdong
WHERE MONTH(ngaylamhopdong) IN (10, 11, 12);

SELECT iddichvu
FROM hopdong
WHERE MONTH(ngaylamhopdong) NOT IN (1, 2, 3, 4, 5, 6);

SELECT hopdong.id, nhanvien.hoten, khachhang.hoten, khachhang.sdt, dichvu.tendichvu, COUNT(hopdongchitiet.id) AS sldvdikem, hopdong.tiendatcoc
FROM hopdong
INNER JOIN nhanvien
ON hopdong.idnhanvien = nhanvien.id
INNER JOIN khachhang
ON hopdong.idkhachhang = khachhang.id
INNER JOIN dichvu
ON hopdong.iddichvu = dichvu.id
INNER JOIN hopdongchitiet
ON hopdong.id = hopdongchitiet.idhopdong
WHERE dichvu.id IN (SELECT iddichvu
					FROM hopdong
					WHERE MONTH(ngaylamhopdong) IN (10, 11, 12))
	AND dichvu.id NOT IN (SELECT iddichvu
					FROM hopdong
					WHERE MONTH(ngaylamhopdong) IN (1, 2, 3, 4, 5, 6))
	AND YEAR(hopdong.ngaylamhopdong) IN (2019)
GROUP BY hopdong.id;

-- 13. Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

SELECT MAX(sldvdk)
FROM (SELECT dichvudikem.id, COUNT(dichvudikem.id) AS sldvdk
		FROM hopdongchitiet
		INNER JOIN dichvudikem 
        ON hopdongchitiet.iddichvudikem = dichvudikem.id
		GROUP BY hopdongchitiet.iddichvudikem) AS abczyz;

SELECT dichvudikem.id, COUNT(dichvudikem.id) AS sldvdk
FROM hopdongchitiet
INNER JOIN dichvudikem 
ON hopdongchitiet.iddichvudikem = dichvudikem.id
GROUP BY hopdongchitiet.iddichvudikem
HAVING sldvdk IN (SELECT MAX(sldvdk)
					FROM (SELECT dichvudikem.id, COUNT(dichvudikem.id) AS sldvdk
							FROM hopdongchitiet
							INNER JOIN dichvudikem 
                            ON hopdongchitiet.iddichvudikem = dichvudikem.id
							GROUP BY hopdongchitiet.iddichvudikem) AS abczyz
					); 

-- 14. Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

SELECT hopdong.id, loaidichvu.tenloaidichvu, dichvudikem.tendichvudikem, COUNT(hopdongchitiet.iddichvudikem) AS solansudung
FROM hopdong 
INNER JOIN dichvu
ON hopdong.iddichvu = dichvu.id
INNER JOIN loaidichvu
ON dichvu.idloaidichvu = loaidichvu.id
INNER JOIN hopdongchitiet
ON hopdong.id = hopdongchitiet.idhopdong
INNER JOIN dichvudikem
ON hopdongchitiet.iddichvudikem = dichvudikem.id
GROUP BY hopdongchitiet.iddichvudikem
HAVING solansudung = 1;

-- 15. Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

SELECT nhanvien.id, nhanvien.hoten, trinhdo.trinhdo, bophan.tenbophan, nhanvien.sdt, nhanvien.diachi
FROM nhanvien
INNER JOIN trinhdo
ON nhanvien.idtrinhdo = trinhdo.id
INNER JOIN bophan
ON nhanvien.idbophan = bophan.id
INNER JOIN hopdong
ON nhanvien.id = hopdong.idnhanvien
WHERE YEAR(hopdong.ngaylamhopdong) IN (2018, 2019)
GROUP BY idnhanvien
HAVING COUNT(hopdong.idnhanvien) < 4;

-- 16. Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

DELETE 
FROM nhanvien
WHERE id IN (
	SELECT idnhanvien
	FROM hopdong
    WHERE YEAR(ngaylamhopdong) IN (2017, 2018, 2019) 
);

-- 17. Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
-- chua ok

UPDATE khachhang
SET khachhang.idloaikhach = 1
WHERE khachhang.idloaikhach = 2 AND khachhang.idloaikhach IN (
	SELECT hopdong.idkhachhang
	FROM hopdong 
    INNER JOIN dichvu
    ON hopdong.iddichvu = dichvu.id
	WHERE YEAR(hopdong.ngaylamhopdong) IN (2019)
	GROUP BY hopdong.idkhachhang
	HAVING SUM(hopdong.tongtien) >= 10
    -- HAVING dichvu.chiphithue + SUM(dichvudikem.donvi * dichvudikem.gia) >= 1000
);

-- 18. Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).

DELETE
FROM khachhang
WHERE id IN (
	SELECT idkhachhang
    FROM hopdong
    WHERE YEAR(ngaylamhopdong) < 2016
);

-- 19. Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

CREATE TEMPORARY TABLE temp_dichvudikem 
SELECT dichvudikem.id as iddvdk ,hopdong.ngaylamhopdong, COUNT(hopdongchitiet.iddichvudikem) AS solansudung
FROM hopdong 
INNER JOIN hopdongchitiet
ON hopdong.id = hopdongchitiet.idhopdong
INNER JOIN dichvudikem
ON hopdongchitiet.iddichvudikem = dichvudikem.id
WHERE YEAR(hopdong.ngaylamhopdong) IN (2019)
GROUP BY hopdongchitiet.iddichvudikem
HAVING solansudung > 1;

DROP TEMPORARY TABLE temp_dichvudikem;

UPDATE dichvudikem
SET gia = gia * 2
WHERE dichvudikem.id in (
	SELECT temp_dichvudikem.iddvdk
    FROM temp_dichvudikem
);

-- 20. Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm 
-- ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

SELECT id, hoten, email, sdt, ngaysinh, diachi, 'Nhan vien' AS vitri
FROM nhanvien
UNION ALL
SELECT id, hoten, email, sdt, ngaysinh, diachi, 'Khach hang' AS vitAQri
FROM khachhang;

-- 21. Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và 
-- đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”

CREATE OR REPLACE VIEW view_nhanvien AS
SELECT nhanvien.id, nhanvien.hoten, nhanvien.ngaysinh, nhanvien.cmnd, nhanvien.sdt, nhanvien.email, nhanvien.diachi
FROM nhanvien
INNER JOIN hopdong ON hopdong.idnhanvien = nhanvien.id
WHERE nhanvien.diachi = "Hải Châu" AND hopdong.ngaylamhopdong = "2019/12/12";

SELECT *
FROM view_nhanvien;

-- 22. Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.

UPDATE view_nhanvien
SET diachi = 'Liên Chiểu';

-- 23. Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1

DELIMITER $$
CREATE PROCEDURE sp_1(IN idkhachhang INT)
BEGIN
	DELETE 
    FROM khachang
    WHERE id = idkhachhang;
END; $$
DELIMITER ;

CALL sp_1(99);

-- 24. Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
-- với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

DELIMITER $$
CREATE PROCEDURE sp_2(
	-- IN id INT,
    IN idnhanvien INT,
	IN idkhachhang INT,
    IN iddichvu INT,
    IN ngaylamhopdong DATE,
    IN ngayketthuc DATE,
    IN tiendatcoc INT,
    IN tongtien INT
)
BEGIN
	IF (/*id NOT IN (SELECT id FROM hopdong) 
		AND*/ idnhanvien IN (SELECT id FROM nhanvien) 
        AND idkhachhang IN (SELECT id FROM khachhang) 
        AND iddichvu IN (SELECT id FROM dichvu))
    THEN 
		INSERT INTO hopdong (/*id,*/ idnhanvien, idkhachhang, iddichvu, ngaylamhopdong, ngayketthuc, tiendatcoc, tongtien)
		VALUES (/*id,*/ idnhanvien, idkhachhang, iddichvu, ngaylamhopdong, ngayketthuc, tiendatcoc, tongtien);
	ELSE 
		SELECT 'Dữ liệu không hợp lệ'; 
	END IF;
END; $$
DELIMITER ;

DROP PROCEDURE sp_2;

CALL sp_2(1, 1, 1, '2019-02-15', '2019-02-20', 1000000, 0);

-- 25. Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database

DELIMITER $$
CREATE TRIGGER Tr_1
AFTER DELETE  
ON hopdong FOR EACH ROW
BEGIN    
	SET @count = (SELECT COUNT(id) FROM hopdong);
END; $$
DELIMITER ;

DROP TRIGGER Tr_1;

DELETE
FROM hopdong
WHERE id = 13;

SELECT @count;
        
-- 26. Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, 
-- với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, 
-- nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database

DELIMITER $$
CREATE TRIGGER Tr_2
BEFORE UPDATE	
ON hopdong FOR EACH ROW
BEGIN    
	IF (DATEDIFF(NEW.ngayketthuc, OLD.ngaylamhopdong) < 2)
	THEN SIGNAL SQLSTATE '22023' SET MESSAGE_TEXT = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
    END IF;
END; $$
DELIMITER ;

DROP TRIGGER Tr_2;

UPDATE hopdong
SET ngayketthuc = '2019-01-29'
WHERE id = 3;

-- 27. Tạo user function thực hiện yêu cầu sau:
-- a. Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
-- b. Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). Mã của Khách hàng được truyền vào như là 1 tham số của function này.

-- 28. Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 
-- để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu) và xóa những HopDong sử dụng dịch vụ liên quan 
-- (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác.

DELIMITER $$
CREATE PROCEDURE sp_3 (
	IN loaidv VARCHAR(45), 
    IN startyear INT, 
    IN endyear INT
)
BEGIN
	DELETE 
    FROM dichvu
    WHERE id IN (
		SELECT dichvu.id
        FROM dichvu
        INNER JOIN loaidichvu
		ON dichvu.idloaidichvu = loaidichvu.id
		INNER JOIN hopdong
		ON dichvu.id = hopdong.iddichvu
		WHERE loaidichvu.tenloaidichvu = loaidv AND (YEAR(hopdong.ngaylamhopdong) BETWEEN startyear AND endyear));
END; $$
DELIMITER ;

DROP PROCEDURE sp_3;

CALL sp_1('Room', 2015, 2019);

                    
