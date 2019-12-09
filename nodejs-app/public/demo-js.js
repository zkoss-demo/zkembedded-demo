zEmbedded.load('embeddedZK', '/zkembedded-app/index.zul');
window.addEventListener('load', function(){
	var init = false;
	jq('#a_load').on('click', function() {
		if (!init) {
			zk.afterMount(function () {
				zkbind.$('$win').after('toClient', function (url) {
					jq("#success-alert").fadeTo(1000, 500).slideUp(500, function() {
						jq("#success-alert").slideUp(500);
					});
				});
			});
			init = true;
		}
		zkbind.$('$win').command('loadDemoXlsx');
	});
	jq('#a_toggleToolbar').on('click', function() {
		zkbind.$('$win').command('toggleToolbarVisible');
	});
	jq('#a_toggleSheetbar').on('click', function() {
		zkbind.$('$win').command('toggleSheetbarVisible');
	});
	jq('#a_toggleFormulabar').on('click', function() {
		zkbind.$('$win').command('toggleFormulabarVisible');
	});
});
