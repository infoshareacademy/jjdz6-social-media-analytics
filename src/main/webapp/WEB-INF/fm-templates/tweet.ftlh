<div>
    <ul>
        <#list tweets as tweetPresentationObject>
            <div>
                <li><b>${tweetPresentationObject.userName}</b></li>
                <li>@${tweetPresentationObject.screenName}</li>
                <li>${tweetPresentationObject.createdAt}</li>
                <li>${tweetPresentationObject.text}</li>
                <li>${tweetPresentationObject.source}</li>
                <li>${tweetPresentationObject.favouriteCount} ${tweetPresentationObject.retweetCount}</li>
                <#if tweetPresentationObject.mediaURLList??>
                    <#list tweetPresentationObject.mediaURLList as media>
                        <li>${media}</li>
                    </#list>
                </#if>
            </div>
            <div>
                <img src="${tweetPresentationObject.usersProfileImageURL}">
            </div>

        </#list>
    </ul>
</div>
