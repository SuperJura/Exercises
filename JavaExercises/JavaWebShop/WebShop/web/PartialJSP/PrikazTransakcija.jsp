<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="jl" uri="http://jurica.adamek.java3"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table class="table table-bordered">
    <tr>
        <td class="boldBlack">
            Ime proizvoda
        </td>
        <td class="boldBlack">
            Kolicina tog proizvoda
        </td>
        <td class="boldBlack">
            Datum kupnje
        </td>
        <td class="boldBlack">
            Tip placanja
        </td>
        <td class="boldBlack">
            Sveukupna cijena
        </td>
    </tr>
    <c:forEach var="transakcija" items="${transakcije}">
        <tr>
            <td>
                <jl:ProizvodNaziv proizvodId="${transakcija.proizvodId}"/>
            </td>
            <td>
                ${transakcija.kolicina}
            </td>
            <td>
                <fmt:formatDate value="${transakcija.datumKupnje}" pattern="dd.MM.yyyy hh:mm:ss" type="both"/>
            </td>
            <td>
                ${transakcija.tipPlacanja}
            </td>
            <td cijena="${transakcija.cijenaPojedinacna * transakcija.kolicina}">
            </td>
        </tr>
    </c:forEach>
</table>
<script>
    var tds = $("td[cijena]");
    for (i = 0; i < tds.length; i++) {
        cijena = $(tds[i]).attr("cijena");
        floatCijena = parseFloat(cijena);
        tds[i].innerHTML = getCijenaKune(floatCijena);
    }
</script>