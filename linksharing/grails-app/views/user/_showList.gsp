<g:each in="${resources}" var="res">
    <div class="under">
        <div>
            <div style="float:right">
                <div>
                <h3>${res.topic.name}</h3>
                 </div>
                <div>
                ${res.user.username}
                    </div>
                <div>${res.description}</div>
            </div>

            <img src="${resource(dir:'images',file:'index.jpeg')}" class="m"/>

            <div>
                <g:actionSubmitImage  class="im" value="message" src="${resource(dir:'images',file:'facebook.jpeg')}"/>
                <g:actionSubmitImage  class="im" value="message" src="${resource(dir:'images',file:'twitter.jpeg')}"/>
                <g:actionSubmitImage class="im" value="message" src="${resource(dir:'images',file:'google.jpeg')}" />
            </div>
            <div style="margin-left:300px;margin-top:20px;">
                <I> <ls:marked resource="${res}"></ls:marked></I>
                <I style="margin-left:100px;">
                    <ls:document resource="${res}"></ls:document>
                </I>
            </div>
        </div>
    </div>
</g:each>
