var psd = require('psd');
var nodePath = require('path');
var fs = require('fs');


var path = process.cwd() + '/PsdFiles';;
var csPath = process.cwd() + "/PsdCs";
if (!fs.existsSync(csPath)){
    fs.mkdirSync(csPath);
}
if (!fs.existsSync(path)){
    fs.mkdirSync(path);
}


var fileNames = fs.readdirSync(path);
for (var k = 0; k < fileNames.length; k++) {
	var file = fileNames[k];
	var psdName = file.split('.')[0];
	var psdPath = path + "/" + file;

	var psdFile = psd.fromFile(psdPath);
	psdFile.parse();

	var resourcesPsdPath = path + "/" + psdName;
	if(!fs.existsSync(resourcesPsdPath))	fs.mkdirSync(resourcesPsdPath);

	var layers = psdFile.tree().export()['children'];
	var stream = fs.createWriteStream(csPath + "/" + psdName + "Psd.cs");
	stream.write("using UnityEngine;\n");
	stream.write("public static class " + psdName + "Psd\n{\n");

	for (var i = 0; i < layers.length; i++) {
		if(layers[i].type == "layer") {
			var noSpaceName = layers[i].name.replace(' ', '');
			stream.write("\tpublic static Texture " + noSpaceName + "Image = Resources.Load<Texture>(\"PsdFiles/" 
				+ psdName + "/" + noSpaceName + "\");\n");
			stream.write("\tpublic static string " + noSpaceName + "Name = \"" + noSpaceName + "\";\n");
			stream.write("\tpublic static float " + noSpaceName + "Width = " + layers[i].width + "f;\n");
			stream.write("\tpublic static float " + noSpaceName + "Height = " + layers[i].height + "f;\n");
			stream.write("\tpublic static float " + noSpaceName + "Left = " + layers[i].left + "f;\n");
			stream.write("\tpublic static float " + noSpaceName + "Top = " + layers[i].top + "f;\n");
			stream.write("\tpublic static Rect " + noSpaceName + "Rect = new Rect(" +
				noSpaceName + "Left" +
				", " + 
				noSpaceName + "Top" +
				", " + 
				noSpaceName + "Width" + 
				", " + 
				noSpaceName + "Height"
				+ ");\n");
			stream.write("\n\n");

		}
	}
	stream.write("}\n");
  	stream.end();
}
