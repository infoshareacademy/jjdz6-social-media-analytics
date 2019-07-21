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

            var profile = googleUser.getBasicProfile();
            var redirectUrl = "${pageContext.request.contextPath}/login"; //nullpointer exception
            var form = $('<form action="' + redirectUrl + '" method="get">' +
                '<input type="text" name="id_token" value="' + googleUser.getAuthResponse().id_token + '" />' + '</form>');
        $('body').append(form);
        form.submit();

    }
</script>
</body>
</html>
