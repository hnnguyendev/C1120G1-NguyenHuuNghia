# CGDN-Spring-RequestMapping
Bài Tập: <br>
2.1 Trong HomeController  có method0:    Tạo file jsp:  method0.jsp trong thư mục webapp/WEB-INF/views, viết RequestMapping để có thể sử dụng HTTP METHOD = GET  hiển thị trang method0.jsp
<br>
2.2 Trong HomeController  có method1:

Tạo file jsp: method1 trong thư mục webapp/WEB-INF/views.
viết RequestMapping để có thể sử dụng HTTP METHOD = POST  hiển thị trang method0.jsp bằng nhiều URI khác nhau ví dụ: /method1,  /method1/one, /method1/two đều trả về trang method1.jsp
<br>
2.3 Tạo phương thức method3 tương tự. Viết RequestMapping để cả 2 Method GET và POST đều gọi vào phương thức method3 và trả về trang jsp method3
(Trong trang method1.jsp tạo 1 form có method="post" và nút submit để test method POST cho method3)
<br>
2.4 Tạo phương thức method4 tương tự. Viết RequestMapping chỉ nhận Method POST có header là 1 cặp key-value với key = name , value = codegymDaNang, thành công thì trả về trang method4.jsp
(Để test header chúng ta dùng tool POSTMAN để test)
<br>
2.5 Tạo phương thức method5 tương tự. Viết RequestMapping chỉ nhận Method POST có header là 2 cặp key-value với key = name , value = codegymDaNang và key = Id , value = 100 thành công thì trả về trang method5.jsp	
<br>
  2.6 Tạo phương thức method6 tương tự. Viết RequestMapping chỉ nhận request  có content-type  là "application/json", thành công thì trả về nội dung của trang jsp method6.jsp

<br>
Gợi ý: sử dung consumes trong RequestMapping 2.7 Tạo phương thức method7 có kiểu trả về là ModelAndView như sau:
 Viết  RequestMapping với Method Get để khi ta nhập uri trên trình duyệt đúng đường dẫn và có id thì hiển thị trang jsp method7.jsp với Id đã nhập 2.8 Tạo phương thức method8 có kiểu trả về là ModelAndView, nhập uri trên trình duyệt là 2 tham số Id,Name. Hiển thị trong trang method8.jsp


