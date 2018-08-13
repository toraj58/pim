<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>PIM</title>
</head>
<body>

<button onclick="location.href='/download.pdf'" style="width:100px">Export to pdf</button>
<br />
<button onclick="location.href='/download.xls'" style="width:100px">Export to xls</button>
<br />

<table border="1" bordercolor=blue>
    <th>ZamroID</th>
    <th>Name</th>
    <th>Description</th>
    <th>MinOrderQuantity</th>
    <th>UnitOfMeasure</th>
    <th>CategoryID</th>
    <th>PurchasePrice</th>
    <th>Available</th>

    <c:forEach items="${products}" var="product">
        <tr>
            <td> ${product.zamroid}</td>
            <td> ${product.name}</td>
            <td> ${product.description}</td>
            <td> ${product.minorderquantity}</td>
            <td> ${product.unitofmeasure}</td>
            <td> ${product.category.categoryid}</td>
            <td> ${product.purchaseprice}</td>
            <td> ${product.available}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>