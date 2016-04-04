<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/JavaScript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js" ></script>
<script type="text/JavaScript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js" ></script>
<script type="text/JavaScript" src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js" ></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css" >
<html>



<body>

<h1 style="text-align: center">Price Comparison</h1>
<c:if  test="${!empty competitor}">
<table class="data" id="example">
<thead>
	<tr >
	<th>Category</th>
<c:forEach items="${competitor}" var="competitor">
		<th id="${competitor}">${competitor} </th>
</c:forEach>


</thead>

</c:if>
<tbody id="headingRow">

</body>

<script type="text/JavaScript" >
$(document).ready(function() {
    var competitorObj;
    $.get("/PriceCompare/competitor", function(competitor) {
        competitorObj = JSON.parse(competitor)
        $.get("/PriceCompare/data", function(priceList) {

            var row = "";
            var categoryName = "";
            var i = 0;

            //iterate each row
            $.each(JSON.parse(priceList), function(key, item) {
                var index = null;
                var gap = 0;
                if (categoryName != item.category.description) {
                    row = row + "</tr><tr><td>" + item.category.description + "</td>"
                    i = 0;
                }
                if (item.store == competitorObj[i])
                    row = row + "<td>" + item.avgPrice + "</td>"
                else if (item.store != competitorObj[i]) {
                    index = competitorObj.indexOf(item.store);
                    for (var j = 0; j < index - i; j++) {
                        row = row + "<td></td>";
                    }
                    row = row + "<td>" + item.avgPrice + "</td>"
                    i = index;
                }
                i++;
                categoryName = item.category.description
            })
            row = row + "</tr></tbody></table>";
            row = row.slice(5);
            $("#headingRow").html(row);
            var table = $('#example').DataTable({"iDisplayLength": 100});
            $('table:first tr').each(function() {
                var lasttd = Number($(this).find(':last-child').text())
                $(this).find(':last-child').hide();
                 for (var c = 0, m = this.cells.length; c < m; c++) {
                    if(this.cells[c].innerHTML.length === 0 )
                    this.cells[c].setAttribute("bgcolor", "white");
                    else if(Number(this.cells[c].innerHTML) > lasttd)
                    this.cells[c].setAttribute("bgcolor", "LightGreen");
                    else if(Number(this.cells[c].innerHTML) < lasttd)
                    this.cells[c].setAttribute("bgcolor", "LightSalmon");
                }
            });
        });
    });
});

</script>


</html>
