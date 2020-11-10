zEmbedded.load('embeddedZK', 'http://localhost:8080/zkembedded-app/keikai.zul')
    .then(function(result) {
        var spreadsheet = result.widget;
        jq('#a_load').on('click', () => {
            spreadsheet.fire("onImport", {file: 'demo_sample.xlsx'}, {toServer:true})
        });
        jq('#a_toggleToolbar').on('click', () => spreadsheet.fire("onToggleVisibility", {ui: "toolbar"}, {toServer:true}) );
        jq('#a_toggleSheetbar').on('click', () => spreadsheet.fire("onToggleVisibility", {ui: "sheetbar"}, {toServer:true}));
        jq('#a_toggleFormulabar').on('click', () => spreadsheet.fire("onToggleVisibility", {ui: "formulabar"}, {toServer:true}));
    })
    .catch(function(reason) {
        console.error("error", this, arguments);
    });
