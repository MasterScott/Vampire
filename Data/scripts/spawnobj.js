var api = Java.type('vampire.api.core');

var command = function(args) {
	var id = args;
	var x = api.getPlayerX();
	var y = api.getPlayerY();
	var z = api.getPlayerZ();
	if (api.spawnObject(x, y, id, 0, 10, 0) == true) {
	//if (api.spawnObject(3222, 3219, 2213, 0, 10, 0) == true) {
		return "Spawned Object!";
	} else {
		return "Failed to spawn object!";
	}
	//return "Spawned object!";
};