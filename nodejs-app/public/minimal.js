function calledFromZK(value) {
    clientInput.value = value;
}
zEmbedded.load('zkapp', 'http://localhost:8080/zkembedded-app/minimal.zul?myparam=init-from-client-side')
    .then(function(result) {
        var myWin = result.widget;
        console.log(result.widget);
        clientSideButton.addEventListener('click', function() {
            myWin.fire('onCustomClientEvent', 'update-from-client-side: ' + new Date(), {toServer: true});
        });
    })
    .catch(function(error) {
        console.error(error);
    });
