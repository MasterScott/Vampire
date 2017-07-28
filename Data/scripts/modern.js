var api = Java.type('vampire.api.core');

var command = function(args) {
	if(api.setSidebar(6, 1151)) {
		return "Set ancient spellbook!";
	} else {
		return "Error setting sidebar!";
	}
}