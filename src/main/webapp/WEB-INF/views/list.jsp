<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>公告列表</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-4">
    <h2>公告列表</h2>
    <a href="posts/new" class="btn btn-primary mb-3">新增公告</a>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>標題</th>
            <th>發佈日期</th>
            <th>截止日期</th>
            <th>公告者</th>
            <th>公告內容</th> 
            <th>修改</th>
            <th>刪除</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="post" items="${posts}">
            <tr>
                <td>${post.title}</td>
                <td>${post.publishDate}</td>
                <td>${post.endDate}</td>
                <td>${post.author}</td>
                <td>
                    ${post.content}
                    <c:if test="${not empty post.filePath}">
                        <br/>
                        <img src="${pageContext.request.contextPath}/${post.filePath}" width="150" alt="附件圖片"/>
                    </c:if>
                </td>  
                <td><a href="posts/edit?id=${post.id}" class="btn btn-sm btn-warning">修改</a></td>
                <td><a href="posts/delete?id=${post.id}" class="btn btn-sm btn-danger">刪除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
