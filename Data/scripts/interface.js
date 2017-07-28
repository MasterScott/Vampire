var api = Java.type('vampire.api.core');

var command = function(args) {
	var id = args;
	if(api.openInterface(id)) {
		return "Opened interface!";
	} else {
		return "Error opening interface!";
	}
}