var api = Java.type('vampire.api.core');

var command = function(args) {
	if(api.setSidebar(6, 12855)) {
		return "Set ancient spellbook!";
	} else {
		return "Error setting sidebar!";
	}
}