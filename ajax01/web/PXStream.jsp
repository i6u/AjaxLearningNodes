<%--
  Created by IntelliJ IDEA.
  User: zhouweitao
  Date: 16/8/28
  Time: 上午2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Person</title>
    <script type="text/javascript">
      function getPersons(obj) {
        var did = obj.value;
        var xhr = new XMLHttpRequest();
        xhr.open('post', 'PXStream.do', true);
        xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');
        xhr.send('did='+did);
        xhr.onreadystatechange = function () {
          if (xhr.readyState == 4&& xhr.status == 200) {
            var xmlDoc = xhr.responseXML;
//            console.log(xmlDoc);
            var pns = xmlDoc.getElementsByTagName('person');
            var myDiv = document.getElementById('myDiv');
            var txt = '';
            txt = ("<table border='1px'><tr><th>NO</th><th>NAME</th><th>Salary</th><th>gender</th></tr>");
            for (var i = 0; i < pns.length; i++) {
              txt += '<tr>';
              var id = pns[i].getElementsByTagName('id')[0].firstChild.nodeValue;
              var name = pns[i].getElementsByTagName('username')[0].firstChild.nodeValue;
              var salary = pns[i].getElementsByTagName('salary')[0].firstChild.nodeValue;
              var gender = pns[i].getElementsByTagName('gender')[0].firstChild.nodeValue;
//              document.getElementById('mydiv').innerHTML += id +'-----'+ name +'-----'+ salary+'<br/>';
              txt+=("<td>"+id+"</td>");
              txt+=("<td>"+name+"</td>");
              txt+=("<td>"+salary+"</td>");
              txt+=("<td>"+gender+"</td>");
              txt += '</tr>';
            }
            txt+=("</table>");
            myDiv.innerHTML = txt;
          }
        };
      }
    </script>
  </head>
  <body>
  <select id="getPerson" onchange="getPersons(this)">
    <option value="1">三国</option>
    <option value="2">硅谷</option>
    <option value="3">中国</option>
  </select>
  <div id="myDiv"></div>
  </body>
</html>
