
<body>
      <%
             if(session.getAttribute("users") == null) {
   %>
          <script type="text/javascript" language="javascript">
            alert("you are not login on,please login first...");
           top.location.href="ylogin_register.html";
           </script>
   <%
       }
   %>
 </body>
