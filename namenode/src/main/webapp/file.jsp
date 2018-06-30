
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/file"  enctype="multipart/form-data" method="post" style="margin-left: 1000px">
    <input type="file" name="file">
    <input type="submit" value="上传">
</form>
<table align="center" border="1">
    <caption>文件管理</caption>
    <tr><td width="400px" align="center">文件名称</td><td width="300px" align="center">操作</td></tr>
    <c:forEach items="${nameNodeList}" var="file">
        <tr>
            <td align="center">${file.filename}</td>
            <td align="center"><a  href="${pageContext.request.contextPath}/file?filename=${file.filename}">下载</a>
                <a  href="${pageContext.request.contextPath}/file/delete?filename=${file.filename}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
