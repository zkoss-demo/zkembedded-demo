zEmbedded.load('embeddedZK', 'http://localhost:8080/zkembedded-app/keikai.zul')
    .then(function(result) {

        //jq is a custom jQuery $ in zk
        jq('#a_load').on('click', () => {
            //need to get spreadsheet widget each time since spreadsheet's desktop might be null in some cases
            zk.Widget.$('$spreadsheet').fire("onImport", {file: 'demo_sample.xlsx'}, {toServer:true});
        });
        jq('#a_toggleToolbar').on('click', () => {
            zk.Widget.$('$spreadsheet').fire("onToggleVisibility", {ui: "toolbar"}, {toServer:true});
        });
        jq('#a_toggleSheetbar').on('click', () => {
            zk.Widget.$('$spreadsheet').fire("onToggleVisibility", {ui: "sheetbar"}, {toServer:true});
        });
        jq('#a_toggleFormulabar').on('click', () => {
            zk.Widget.$('$spreadsheet').fire("onToggleVisibility", {ui: "formulabar"}, {toServer:true});
        });
    })
    .catch(function(reason) {
        console.error("error", this, arguments);
    });
