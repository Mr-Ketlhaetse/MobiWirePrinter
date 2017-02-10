var exec = require('cordova/exec');



exports.printTicket = function(arg0, success, error) {
    exec(success, error, "MobiWirePrinter", "printTicket", [arg0]);
};


function success(data)
{
	alert(JSON.stringify(data));
}

function error(errorMessage)
{
	alert(JSON.stringify(errorMessage));
}
