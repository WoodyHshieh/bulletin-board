<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>新增公告</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <!-- 編輯器API -->
    <script src="https://cdn.ckeditor.com/4.22.1/standard/ckeditor.js"></script>
</head>
<body class="container mt-4 bulletin-box">
    <h2>新增公告</h2>
    <form:form action="${pageContext.request.contextPath}/posts/add" 
               modelAttribute="post" method="post"
               enctype="multipart/form-data"> <!-- 讓表單支援檔案上傳 -->
               
        <div class="mb-3">
            <form:label path="title">標題：</form:label>
            <form:input path="title" cssClass="form-control"/>
            <form:errors path="title" cssClass="text-danger"/>
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
            <form:textarea path="content" cssClass="form-control" id="editor" rows="5"/>
            <form:errors path="content" cssClass="text-danger"/>
        </div>

        <div class="mb-3">
            <label for="file">上傳附件：</label>
            <input type="file" name="file" class="form-control"/>
        </div>

        <button type="submit" class="btn btn-success">送出</button>
        <a href="${pageContext.request.contextPath}/posts" class="btn btn-secondary">返回</a>
    </form:form>

    <script>
        // 啟動 CKEditor
        CKEDITOR.replace('editor');
    </script>	
</body>
</html>
