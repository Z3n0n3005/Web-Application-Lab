
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <style>
            #adminlogin{
                position: absolute;
                width: 350px;
                height: 500px;
                padding: 20px;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
            }
            
            .form{
                padding: 20px;
            }
            .pt-1{
                padding-top: 1rem;
            }
        </style>
    </head>
    <body>
        <section id="adminlogin">
            <div class="card z-depht-3">
                <div class="card-panel center light-blue darken-3">
                    <span class="card-title">Admin Login </span>
                </div>
                <form class="form" action="AdminLoginServlet" method="post">
                    <div type="input-field">
                        <input type="email" class="validate" name="email" required>
                        <label>Email</label>
                    </div>
                    <div type="input-field">
                        <input type="password" class="validate" name="password" required>
                        <label>Password</label>
                    </div>
                    <div class="center">
                        <button type="submit" class="btn-large light-blue-darken-3">
                            Sign In
                        </button>
                    </div>
                    <div class="center pt-1">
                        <a href="#">Forget Password?</a>
                    </div>
                </form>
            </div>
        </section>
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </body>
</html>
