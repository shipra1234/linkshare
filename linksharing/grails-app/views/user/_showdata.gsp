
    <div style="float: right">
        <g:form id="formvisibility" name="formvisibility">
        <g:select from="${linksharing.Topic.Visibility.values()}" name="visibilty" id="editVisible" noSelection="${['select':"${visibility}"]}"/>
            <g:hiddenField name="topic" value="${topic}"></g:hiddenField>
            </g:form>
        </div>
    <div style="margin-left:20px">
        <g:actionSubmitImage class="im" style="margin-left:100px;" value="message" src="${resource(dir:'images',file:'edit.png')}" id="edit"/>
        <g:actionSubmitImage class="im" value="message" src="${resource(dir:'images',file:'delete.png')}" id="delete"/>
    </div>

