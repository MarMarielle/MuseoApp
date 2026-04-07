<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">

            <div class="card shadow p-4">
                <h3 class="text-center mb-3">Iniciar Sesión</h3>

                <% if(request.getParameter("error") != null) { %>
                    <div class="alert alert-danger">Usuario o contraseña incorrectos</div>
                <% } %>

                <form action="login" method="post">

                    <div class="mb-3">
                        <label>Usuario</label>
                        <input type="text" name="username" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label>Contraseña</label>
                        <input type="password" name="password" class="form-control" required>
                    </div>

                    <div class="d-grid">
                        <button class="btn btn-primary">Entrar</button>
                    </div>

                </form>

            </div>

        </div>
    </div>
</div>

</body>
</html>