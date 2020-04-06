zEmbedded.load('embeddedZK', 'http://localhost:8080/zkembedded-app/index.zul')
    .then(function({widget}) {
        const binder = zkbind.$(widget);

        jq('#a_load').on('click', () => {
            binder.command('loadDemoXlsx');
            binder.after('toClient', function toClientHandler (url) {
                jq("#success-alert").fadeIn(1000).slideUp(500);
                binder.unAfter('toClient', toClientHandler);
            });
        });
        jq('#a_toggleToolbar').on('click', () => binder.command('toggleToolbarVisible'));
        jq('#a_toggleSheetbar').on('click', () => binder.command('toggleSheetbarVisible'));
        jq('#a_toggleFormulabar').on('click', () => binder.command('toggleFormulabarVisible'));
    })
    .catch(function(reason) {
        console.error("error", this, arguments);
    });
