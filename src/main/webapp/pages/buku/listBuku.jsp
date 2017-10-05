<%-- 
    Document   : listBuku
    Created on : Oct 5, 2017, 9:38:06 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Buku</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <td>NO</td>
                    <td>Judul Buku</td>
                    <td>Tahun Terbit</td>
                    <td>Jumlah Buku</td>
                    <td>Nama Pengarang</td>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listBuku}" var="sebuahBuku" varStatus="index">
                        <tr>
                        <td>${index.count}</td>
                        <td>${sebuahBuku.judulBuku}</td>
                        <td>${sebuahBuku.tahunTerbit}</td>
                        <td>${sebuahBuku.jumlahBuku}</td>
                        <td>${sebuahBuku.pengarang}</td>
                        <td>
                            <a href="${pageContext.servletContext.contextPath}/buku/delete?kode_buku=
                               ${sebuahBuku.id}">Hapus</a>
                        </td>
                        </tr>
                    </c:forEach>
                    
                </tbody>
        </table>
        
    </body>
</html>
