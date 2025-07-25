<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>編輯公告</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <!-- 編輯器API -->
    <script src="https://cdn.ckeditor.com/4.22.1/standard/ckeditor.js"></script>
    
</head>
<body class="container mt-4 bulletin-box">
    <h2>編輯公告</h2>
    <form:form action="update" modelAttribute="post" method="post">
        <form:hidden path="id"/>
        <div class="mb-3">
            <form:label path="title">標題：</form:label>
            <form:input path="title" cssClass="form-control"/>
            <form:errors path="title" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label path="publishDate">發佈日期：</form:label>
            <form:input path="publishDate" cssClass="form-control" type="date"/>
            <form:errors path="publishDate" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label path="endDate">截止日期：</form:label>
            <form:input path="endDate" cssClass="form-control" type="date"/>
            <form:errors path="endDate" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label path="author">公告者：</form:label>
            <form:input path="author" cssClass="form-control"/>
            <form:errors path="author" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <form:label path="content">公告內容：</form:label>
            <form:textarea path="content" cssClass="form-control" rows="5"/>
            <form:errors path="content" cssClass="text-danger"/>
        </div>
        <button type="submit" class="btn btn-primary">修改</button>
        <a href="${pageContext.request.contextPath}/posts" class="btn btn-secondary">返回</a>
    </form:form>
</body>
</html>
