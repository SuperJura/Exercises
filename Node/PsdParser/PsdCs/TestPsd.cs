using UnityEngine;
public static class TestPsd
{
	public static Texture CloudImage = Resources.Load<Texture>("PsdFiles/Test/Cloud");
	public static string CloudName = "Cloud";
	public static float CloudWidth = 574f;
	public static float CloudHeight = 190f;
	public static float CloudLeft = 406f;
	public static float CloudTop = 594f;
	public static Rect CloudRect = new Rect(CloudLeft, CloudTop, CloudWidth, CloudHeight);


	public static Texture CatImage = Resources.Load<Texture>("PsdFiles/Test/Cat");
	public static string CatName = "Cat";
	public static float CatWidth = 471f;
	public static float CatHeight = 395f;
	public static float CatLeft = 297f;
	public static float CatTop = 96f;
	public static Rect CatRect = new Rect(CatLeft, CatTop, CatWidth, CatHeight);


	public static Texture DoggoImage = Resources.Load<Texture>("PsdFiles/Test/Doggo");
	public static string DoggoName = "Doggo";
	public static float DoggoWidth = 513f;
	public static float DoggoHeight = 407f;
	public static float DoggoLeft = 1290f;
	public static float DoggoTop = 337f;
	public static Rect DoggoRect = new Rect(DoggoLeft, DoggoTop, DoggoWidth, DoggoHeight);


	public static Texture BackgroundcopyImage = Resources.Load<Texture>("PsdFiles/Test/Backgroundcopy");
	public static string BackgroundcopyName = "Backgroundcopy";
	public static float BackgroundcopyWidth = 1920f;
	public static float BackgroundcopyHeight = 1080f;
	public static float BackgroundcopyLeft = 0f;
	public static float BackgroundcopyTop = 0f;
	public static Rect BackgroundcopyRect = new Rect(BackgroundcopyLeft, BackgroundcopyTop, BackgroundcopyWidth, BackgroundcopyHeight);


}
