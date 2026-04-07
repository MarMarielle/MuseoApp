<%@ page import="java.util.List" %>
<%@ page import="model.Reporte" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reporte</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4">

        <h3 class="mb-4">Reporte de visitas por día</h3>

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Fecha</th>
                    <th>Total visitantes</th>
                </tr>
            </thead>

            <tbody>

            <%
                List<Reporte> lista = (List<Reporte>) request.getAttribute("reporte");

                if (lista != null && !lista.isEmpty()) {
                    for (Reporte r : lista) {
            %>

                <tr>
                    <td><%= r.getFecha() %></td>
                    <td><%= r.getTotal() %></td>
                </tr>

            <%
                    }
                } else {
            %>

                <tr>
                    <td colspan="2" class="text-center">No hay datos</td>
                </tr>

            <%
                }
            %>

            </tbody>
        </table>

        <a href="excel" class="btn btn-success">Exportar a Excel</a>
        <a href="menu.jsp" class="btn btn-secondary">Volver</a>

    </div>
</div>

</body>
</html>