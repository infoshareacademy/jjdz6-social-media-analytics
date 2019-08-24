<#if originalStatusDTO??>
<div>
    <div>
        <img src="${originalStatusDTO.usersProfileImageURL}">
    </div>                <div style="margin-bottom: 20px; margin-left: 10%; margin-right: 10%;  background-color: white; border-radius: 25px; border: 1px solid #3F3E3A; padding: 20px; width: auto; height: auto">
        <div style="display: inline-block; width: 90%">
            <div>
                <div style="display: inline-block">
                    <img style = "margin-top: 10px; border-radius: 50%; border: 1px solid black; box-shadow: 5px 5px 5px black)" src="${originalStatusDTO.usersProfileImageURL}">
                </div>
                <div style="display: inline-block; margin-top:10px; width: 80%; padding-left: 20px;">
                    <p><b>${originalStatusDTO.userName}</b></p>
                    <p>@${originalStatusDTO.screenName}</p>
                </div>
                <div style="display: inline-block">
                    <img src="images/twitter.png" style="width: 64px; height: 64px">
                </div>
            </div>
            <#if originalStatusDTO.hashtagList??>
                <#list originalStatusDTO.hashtagList as hashtag>
                    #${hashtag}
                </#list>
            </#if>
            <p>${originalStatusDTO.text}</p>
            <p>${originalStatusDTO.createdAt}</p>
            <p>
                <img src="images/favorite_small.png" style="display: inline-block">
                ${originalStatusDTO.favouriteCount}
                <img src="images/retweet.png" style="display: inline-block">
                ${originalStatusDTO.retweetCount}
                <#if originalStatusDTO.urlList??>
                <#list originalStatusDTO.urlList as url>
                    <a href="${url}">Zobacz oryginalny wpis</a>
                </#list>
            </p>
            <#if originalStatusDTO.mediaURLList??>
                <#list originalStatusDTO.mediaURLList as media>
                    <p><embed style="size: auto; border-radius: 25px" src="${media}" ></p>
                </#list>
            </#if>
        </div>
        </#if>
</#if>