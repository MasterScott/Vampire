**VAMPIRE**

A simple reflection client with dynamic configs and scriptable commands

For when Magic Mirror is just overkill


**Command plugins**
>var api = Java.type('vampire.api.core');
>
>var command = function(args) {
>	api.startClient();
>	return "Started client!";
>};

**Utilizing the stream**
>var stream = Java.type('vampire.api.packet');
>
>var command = function(args) {
>	stream.createFrame(41);
>	stream.writeWord(995);
>	stream.method432(1);
>	stream.method432(interfaceID);
>	return "Equipped item!";
>};