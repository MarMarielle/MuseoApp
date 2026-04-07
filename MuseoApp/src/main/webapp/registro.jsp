<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Visita</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4">
        <h3 class="mb-4">Registrar Visita</h3>

        <% if(request.getParameter("error") != null) { %>
            <div class="alert alert-danger">Error al registrar</div>
        <% } %>

        <form action="registrarVisita" method="post">

            <div class="mb-3">
                <label>Fecha</label>
                <input type="date" name="fecha" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Nombre</label>
                <input type="text" name="nombre" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Procedencia</label>
                <input type="text" name="procedencia" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Motivo</label>
                <input type="text" name="motivo" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Acompañantes</label>
                <input type="number" name="acompanantes" class="form-control" required>
            </div>

            <button class="btn btn-success">Guardar</button>

        </form>
    </div>
</div>

</body>
</html>