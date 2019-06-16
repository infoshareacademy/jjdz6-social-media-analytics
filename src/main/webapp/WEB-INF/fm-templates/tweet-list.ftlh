<div>
    <ul>
        <#list tweets as tweetPresentationObject>
            <div style="margin-bottom: 20px; margin-left: 10%; margin-right: 10%;  background-color: white; border-radius: 25px; border: 1px solid #3F3E3A; padding: 20px; width: auto; height: auto">
                <div style="display: inline-block; width: 90%">
                    <div>
                        <div style="display: inline-block">
                            <img style = "margin-top: 10px; border-radius: 50%; border: 1px solid black; box-shadow: 5px 5px 5px black)" src="${tweetPresentationObject.usersProfileImageURL}">
                        </div>
                        <div style="display: inline-block; margin-top:10px; width: 80%; padding-left: 20px;">
                            <p><b>${tweetPresentationObject.userName}</b></p>
                            <p>@${tweetPresentationObject.screenName}</p>
                        </div>
                        <div style="display: inline-block">
                            <img src="images/twitter.png" style="width: 64px; height: 64px">
                        </div>
                    </div>
                    <#if tweetPresentationObject.hashtagList??>
                        <#list tweetPresentationObject.hashtagList as hashtag>
                            #${hashtag}
                        </#list>
                    </#if>
                    <p>${tweetPresentationObject.text}</p>
                    <p>${tweetPresentationObject.createdAt}</p>
                    <p>
                        <img src="images/favorite_small.png" style="display: inline-block">
                        ${tweetPresentationObject.favouriteCount}
                        <img src="images/retweet.png" style="display: inline-block">
                        ${tweetPresentationObject.retweetCount}
                    </p>
                    <#if tweetPresentationObject.mediaURLList??>
                        <#list tweetPresentationObject.mediaURLList as media>
                            <p><embed style="size: auto; border-radius: 25px" src="${media}" ></p>
                        </#list>
                    </#if>
                    <#if tweetPresentationObject.urlList??>
                        <#list tweetPresentationObject.urlList as url>
                            <p><iframe src="${url}"></iframe></p>
                            ${url}
                        </#list>
                    </#if>
                </div>
            </div>

        </#list>
    </ul>
</div>