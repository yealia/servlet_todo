<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jstl 추가 코드--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../includes/header.jsp"%>

      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-5">
            <div class="card shadow-lg border-0 rounded-lg mt-5">
              <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
              <div class="card-body">
                <form action="/login" method="post">
                  <h1>${param.error}</h1> <!-- 로그인 실패시 fail 출력-->
                  <div class="form-floating mb-3">
<%--                    <input class="form-control" id="inputEmail" type="email" placeholder="name@example.com" />--%>
                    <input class="form-control" id="inputEmail" type="text" name="mid" placeholder="name@example.com" />
                    <label for="inputEmail">Email address</label>
                  </div>
                  <div class="form-floating mb-3">
<%--                    <input class="form-control" id="inputPassword" type="password" placeholder="Password" />--%>
                    <input class="form-control" id="inputPassword" type="text" name="mpw" placeholder="Password" />
                    <label for="inputPassword">Password</label>
                  </div>
                  <div class="form-check mb-3">
                    <input class="form-check-input" id="inputRememberPassword" type="checkbox" value="" />
                    <label class="form-check-label" for="inputRememberPassword">Remember Password</label>
                  </div>
                  <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                    <a class="small" href="password.html">Forgot Password?</a>
<%--                    <a class="btn btn-primary" href="index.html">Login</a>--%>
                    <button class="btn btn-primary">Login</button>
                  </div>
                </form>
              </div>
              <div class="card-footer text-center py-3">
                <div class="small"><a href="register.html">Need an account? Sign up!</a></div>
              </div>
            </div>
          </div>
        </div>
      </div>

<%@ include file="../includes/footer.jsp"%>