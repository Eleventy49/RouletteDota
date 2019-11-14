import java.util.*;
//import javax.swing.*;
//import java.awt.*;
//import javax.imageio.*;
import java.io.*;

public class main{
final int SAVE_ARRAY = 1;
final int LOAD_PLAYERS = 2;
final int CURRENT_POSITION = 0;
final int WINS_TOTAL = 1;
final int WINS_CARRY = 2;
final int WINS_MID = 3;
final int WINS_OFFLANE = 4;
final int WINS_SUPPORT4 = 5;
final int WINS_SUPPORT5 = 6;
final int WINS_COACH = 7;
final int GAMES_TOTAL = 8;
final int GAMES_CARRY = 9;
final int GAMES_MID = 10;
final int GAMES_OFFLANE = 11;
final int GAMES_SUPPORT4 = 12;
final int GAMES_SUPPORT5 = 13;
final int GAMES_COACH = 14;
final static int ARRAY_SIZE = 15;

public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}  

public static String posChart(int i)
{
	
	switch(i) {
	case 0:
		return " plays Carry.";
	case 1:
		return " plays Mid.";
	case 2:
		return " plays Offlane.";
	case 3:
		return " plays Support. (4)";
	case 4:
		return " plays Support. (5)";
	default:
		return " will be Coaching";
	
	}
}



public static int [] DoRandoms(int count, ArrayList<player> p)
{int r;
int actual;
Random random = new Random();
int [] flags = new int [count];
int [] array = new int [count];
        if(count <= 5)
{actual = 5;
}
else actual = count;

	for(int i = 0; i < count;)
	{
	r = random.nextInt(actual);
        if (r < 0)
        r = -1*r;
	if (flags[r] != 1)
	{
		array[i] = r;
		p.get(i).setCurrentPosition(r);
		i++;
		flags[r] = 1;
	}
	}
	return array;
}

public static void SaveArray(ArrayList<player> p)
{
	try {
		FileWriter fw = new FileWriter("data.csv", false);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter w = new PrintWriter(bw);
		for(player a:p)
		{
			w.print(a.save());
		}
		w.close();
		
	}
	catch(IOException e) {
		System.out.println("Failed to open the file. Could not save.");
	}
	
	
}

public static ArrayList<player> LoadArray()
{   ArrayList<player> list = new ArrayList<player>();
	int [] a = new int[ARRAY_SIZE];
	
	try {
		File f = new File("C:/Users/"+System.getProperty("user.name")+"/Documents/Valkyrie");
		f.mkdirs();
		File f2 = new File("C:/Users/"+System.getProperty("user.name")+"/Documents/Valkyrie/data.csv");
		f2.createNewFile();
	}
    catch(Exception e)
	{
    	e.printStackTrace();
	}
	
	try {
	FileInputStream file = new FileInputStream("C:/Users/"+System.getProperty("user.name")+"/Documents/Valkyrie/data.csv");
	
	Scanner scnr = new Scanner(file);
	scnr.useDelimiter("[,\r\n]+");
	while(scnr.hasNext()) {
		String name = scnr.next();
		for(int i = 0; i<ARRAY_SIZE;i++)
		{
			a[i]=scnr.nextInt();
			if(i==14)
				scnr.nextLine();
		}
		list.add(new player(name, a));
		
	}
	scnr.close();
    }
    catch(IOException e) {
    System.out.println("Failed to load data from the file.");
    }

return list;
	
}


public static void newPlayer(ArrayList<player> p)
{@SuppressWarnings("resource")
Scanner scnr = new Scanner(System.in);
String n;
int [] a = new int [ARRAY_SIZE];
	System.out.println("Please provide a name for this new player.");
	n = scnr.next();
	for(int i = 0; i<ARRAY_SIZE;i++)
		a[i] = 0;
	
	p.add(new player(n, a));
	SaveArray(p);
	menu(p);
}
public static void viewPlayer(ArrayList<player> p)
{@SuppressWarnings("resource")
Scanner scnr = new Scanner(System.in);
String n;
boolean b = false;
	System.out.println("Please provide the name for the player you want to view. (Case Sensitive)");
	n = scnr.next();
	for(player g: p)
		if (g.nameCheck().equals(n)) {
			System.out.println(g);
		    b = true;
		}
	if(!b)
	System.out.println("No player with that name was found.");
	menu(p);
	
}
public static void newGame(ArrayList<player> p)
{int n;
int [] b;
int [] a = new int[ARRAY_SIZE];

String n1,n2;
boolean x = false;
ArrayList<player> active = new ArrayList<player>();

	@SuppressWarnings("resource")
	Scanner scnr = new Scanner(System.in);
	System.out.print("\nHow many players will be playing?\n");
	n = scnr.nextInt();
	for(int i = 0; i < n; i++)
	{System.out.printf("\nEnter player #%d's name:\n", i+1);
	n1 = scnr.next();
	for(player g: p) {
		if(g.nameCheck().equals(n1))
		{	active.add(g);
			x = true;}
	}
	if(!x)
	{System.out.println("This player does not exist yet, do you want to add them? (y/n)");
	n2 = scnr.next();
	if(n2.equals("y")) {
		p.add(new player(n1, a));
	    SaveArray(p);
	    active.add(p.get(p.size()-1));}
	}
	x = false;
	}
	System.out.println("");
	b = DoRandoms(n,active);
	for(player l: active)
	{
		l.addGame();
	}
	for(int i = 0; i < b.length; i++)
	{
		System.out.println(active.get(i).nameCheck() + posChart(b[i]));
	}
	System.out.println("When the game is done, tell me if you won or lost. (y/n)");
	n1 = scnr.next();
	if(n1.equals("y"))
		for(player m: active)
			m.addWin();
	else
		for(player j:active)
			j.clear();
	
	SaveArray(p);
	
	
	
	menu(p);
	
}

public static void menu(ArrayList<player> p)
{int r;
	System.out.println("\nPlease select:");
	System.out.println("\t1 - Add a player to the Database");
	System.out.println("\t2 - View player stats");
	System.out.println("\t3 - Generate roles (New Game)");
	@SuppressWarnings("resource")
	Scanner scnr = new Scanner(System.in);
	r =  scnr.nextInt();
	switch(r) {
	case 1:
		newPlayer(p);
		break;
	case 2:
		viewPlayer(p);
		break;
	case 3:
		newGame(p);
		break;
	default:
		break;
}
}

public static void main(String[] args)
{	System.out.println("Loading players");
	ArrayList<player> p = LoadArray();
	menu(p);
	SaveArray(p);
	

	}
	
	
	
}