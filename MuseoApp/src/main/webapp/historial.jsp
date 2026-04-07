<%@ page import="java.util.List" %>
<%@ page import="model.Visita" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historial</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4">

        <h3 class="mb-4">Historial de Visitas</h3>

        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Fecha</th>
                    <th>Nombre</th>
                    <th>Procedencia</th>
                    <th>Motivo</th>
                    <th>Acompañantes</th>
                </tr>
            </thead>

            <tbody>

            <%
                List<Visita> lista = (List<Visita>) request.getAttribute("visitas");

                if (lista != null) {
                    for (Visita v : lista) {
            %>

                <tr>
                    <td><%= v.getFecha() %></td>
                    <td><%= v.getNombre() %></td>
                    <td><%= v.getProcedencia() %></td>
                    <td><%= v.getMotivo() %></td>
                    <td><%= v.getAcompanantes() %></td>
                </tr>

            <%
                    }
                }
            %>

            </tbody>
        </table>

        <a href="menu.jsp" class="btn btn-secondary">Volver</a>

    </div>
</div>

</body>
</html>