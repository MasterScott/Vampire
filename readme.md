#VAMPIRE

A simple reflection client with dynamic configs and scriptable commands

For when Magic Mirror is just overkill


##Command plugins
>var MyJavaClass = Java.type('vampire.api.core');
>
>var command = function(args) {
>	startClient();
>	return "Started client!";
>};
