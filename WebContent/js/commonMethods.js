function attachDialog(url, title, idOfButton, divId) {
	console.log("Attaching dialog box to button..");
	var $dialog = $('#' + divId)
		.load(contexPath + '/forms/' + url)
		.dialog({
			autoOpen: false,
			title: title
		});

	$('#' + idOfButton).click(function() {
		console.log("Opening dialog box...");
		$dialog.dialog('open');
		// prevent the default action, e.g., following a link
		return false;
	});
};