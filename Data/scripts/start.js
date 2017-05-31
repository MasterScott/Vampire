var MyJavaClass = Java.type('vampire.api.core');

var command = function(args) {
	MyJavaClass.startClient();
	return "Started client!";
};