<html lang="en">
<head>
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="343502052313-vk4bvpo1f72q6b0sh1hemqt5u7lt1fdg.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <title>Login</title>
</head>
<body>
<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
<script>
    function onSignIn(googleUser) {
        var id_token = googleUser.getAuthResponse().id_token;


        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'https://localhost:8080/sign-in-out');
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onload = function () {
            console.log('Signed in as: ' + xhr.responseText);
        };
        xhr.send('idtoken=' + id_token);
    };

</script>
</body>
</html>
