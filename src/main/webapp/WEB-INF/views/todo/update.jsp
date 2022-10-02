<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Register - SB Admin</title>
  <link href="/css/styles.css" rel="stylesheet" />
  <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="bg-primary">
<div id="layoutAuthentication">
  <div id="layoutAuthentication_content">
    <main>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-7">
            <div class="card shadow-lg border-0 rounded-lg mt-5">
              <div class="card-header"><h3 class="text-center font-weight-light my-4">Add TodoList</h3></div>
              <div class="card-body">
                <form action="/todo/update" method="post">

                  <div class="row mb-3">
                    <div class="col-md-12">
                      <div class="form-floating mb-3 mb-md-0">
                        <input class="form-control" name="tno" id="tno" type="text" />
                        <label for="tno">Update tno</label>
                      </div>
                    </div>

                  </div>
                  <div class="row mb-3">
                    <div class="col-md-12">
                      <div class="form-floating mb-3 mb-md-0">
                        <input class="form-control" name="title" id="title" type="text" placeholder="Enter your first name" />
                        <label for="title">title</label>
                      </div>
                    </div>
                  </div>

                  <div class="form-floating mb-3">
                    <input class="form-control" name="memo"  id="memo" type="text" placeholder="name@example.com" />
                    <label for="memo">memo</label>

                  </div>
                  <div class="row mb-3">
                    <div class="col-md-12">
                      <div class="form-floating mb-3 mb-md-0">
                        <input class="form-control" name="dueDate" id="dueDate" type="text" placeholder="Create a password" />
                        <label for="dueDate">dueDate</label>
                      </div>
                    </div>
                  </div>

                  <div class="mt-4 mb-0">
                    <div class="d-grid"><button class="btn btn-primary btn-block" method="post" type="submit">Create Account</button></div>
                  </div>
                </form>
              </div>
              <div class="card-footer text-center py-3">
                <div class="small"><a href="login.html">Have an account? Go to login</a></div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
  </div>
  <div id="layoutAuthentication_footer">
    <footer class="py-4 bg-light mt-auto">
      <div class="container-fluid px-4">
        <div class="d-flex align-items-center justify-content-between small">
          <div class="text-muted">Copyright &copy; Your Website 2022</div>
          <div>
            <a href="#">Privacy Policy</a>
            &middot;
            <a href="#">Terms &amp; Conditions</a>
          </div>
        </div>
      </div>
    </footer>
  </div>
</div>
<%--<script>--%>
<%--    document.querySelector(".btn-primary").addEventListener("click",myModal.show());--%>

<%--    // console.log(myModal)--%>
<%--    //--%>
<%--    // myModal.show()--%>

<%--</script>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>


</body>
</html>
