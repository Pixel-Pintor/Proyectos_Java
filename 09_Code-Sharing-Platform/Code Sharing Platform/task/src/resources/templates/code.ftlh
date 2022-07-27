<html>
<head>
    <title>Latest</title>
    <style>
        a {
            color: green;
        }
        pre {
            border: 1.5px solid green;
            background-color: #dfe4e6;
            margin-top: 1px;
        }

        #load_date {
            font-family: "Courier New", monospace;
        }
    </style>
</head>
<body>
<#list codes as code>
    <a><span id="load_date">${code.getDateTime()}</span></a>
    <pre id="code_snippet">${code.code}</pre>
</#list>
</body>
</html>