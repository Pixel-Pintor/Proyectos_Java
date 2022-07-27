<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
    <style>
    textarea {
    width: 500px;
    height: 250px;
    }
    </style>
</head>
<body>
<form action="new" method="get">
    <textarea id="code_snippet">// write your code here</textarea><br>
    <button id="send_snippet" type="submit" onclick="send()">Submit</button>
</form>
    <script type="text/javascript">
    function send() {
        let object = {
            "code": document.getElementById("code_snippet").value
        };

        let json = JSON.stringify(object);

        let xhr = new XMLHttpRequest();
        xhr.open("POST", '/api/code/new', true);
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.send(json);

        if (xhr.status == 200) {
            alert("Success!");
        }
    }
    </script>
</body>
</html>