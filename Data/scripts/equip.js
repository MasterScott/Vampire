

var stream = Java.type('vampire.api.packet');

var command = function(args) {
	stream.createFrame(41);
	stream.writeWord(args);
	stream.method432(0);
	stream.method432(3214);
	return "equipped item!"
}