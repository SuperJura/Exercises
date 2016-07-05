<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
    <c:forEach var="i" begin="0" items="${sessionScope.kategorije}">
        <button class="btn btn-default btn-block" onclick="kategorijaOnClick(${i.kategorijaId})">
            <div class="text-center">
                <div class="text-primary txtLarge">
                    ${i.naziv}
                </div>
            </div>
        </button>
    </c:forEach>
</div>